package javaChat;

import java.io.*;
import java.net.*;
import java.util.*;
/*실질적으로 클라이언트와 메시지를 주고받는 일을 한다.*/
public class ChatHandler extends Thread{
	Socket sock;
	Vector<ChatHandler> userV;
	ObjectInputStream in;
	ObjectOutputStream out;
	String uid;
	
	public ChatHandler(Socket sock, Vector<ChatHandler> userV) {
		this.sock = sock;
		this.userV = userV;
		try {
			in = new ObjectInputStream(sock.getInputStream());
			out = new ObjectOutputStream(sock.getOutputStream());
		} catch (IOException e) {
			System.out.println("ChatHandler()예외: "+e);
		}
	}
	
	@Override
	public void run() {
		// 클이 접속하면 먼저 아이디를 보낸다.
		
		try {
			Object obj = in.readObject();
			if(obj instanceof String) {
				uid = (String)obj;
				System.out.println("##["+uid+"]님 입장함##");
			}
			// 아이디가 중복됐는지 여부를 체크
			// 1. 중복된다면
			boolean isExist = isDuplicated(uid);
			if(isExist) {
				sendMessageTo("700|");
				//아이디 중복시 "700|"를 보낸다.
			}else {
				// 2. 중복되지 않는다면
				// 모든 참여자(클)에게 입장한 사람의 아이디를 보내준다.
					
				// 1) 방금 접속한 클에게 기존의 입장한 클의 정보를 보내주기
				for(ChatHandler userChat:userV) {
					String msg = "100|"+userChat.uid;
					sendMessageTo(msg);
				}
					
				userV.add(this);
					
				// 2) 방금 접속한 클의 정보를 띄운다.
				String sendMsg="100|"+this.uid;
				sendMessageAll(sendMsg);
			}
			
			while(true) {
				//클이 보내오는 메시지를 계속 듣고 그 내용을 분석(parse)한다.
				String cMsg = (String)in.readObject();
				
				parse(cMsg);
			}
			
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("ChatHandler run()예외: "+e);
		}
	}
	
	/**프로토콜을 분석하여 포로토콜별로 로직을 처리함*/
	private void parse(String cMsg) {
		String[] tks = cMsg.split("\\|");
		switch(tks[0]) {
			case "400": 
				//클=>서버 "400|글자색|메시지"
				String fntRgb = tks[1];
				String message = tks[2];
				
				//서버=>모든 클 "400|아이디|글자색|메시지
				sendMessageAll(
						"400|"+uid+"|"+fntRgb+"|"+message);
				break;
			case "500": //500|귓속말을 보내는 사람의 아이디|귓속말 메시지
				String toId = tks[1];
				String oneMsg = tks[2];
				
				for(ChatHandler userChat:userV) {
					if(userChat.uid.equals(toId)){
						String str = "500|"+this.uid+"|"+oneMsg;
						try {
							userChat.sendMessageTo(str);
						} catch (IOException e) {
							userV.remove(userChat);
						}
						break;
					}
				}
				break;
			case "600": // 600|기존아이디|변경아이디
				boolean isExist = isDuplicated(tks[2]);
				if(isExist) {
					try {
						sendMessageTo("700|id변경실패|"+tks[2]);
					} catch (IOException e) {
						e.printStackTrace();
					}
					return;
				}
				String id = tks[1];
				String cid = tks[2];
				this.uid = cid;
				
				String str = "600|"+id+"|"+this.uid;
				sendMessageAll(str);
				break;
			case "800": // 클=>서버 "800|퇴장하는사람 id"
				String logoutId = tks[1];
				sendMessageAll("800|"+logoutId);
				// logoutId가 this.uid와 동일
				
				//벡터에서 퇴장하는 클과 통신하는 ChatHandler를 제거한다.
				userV.remove(this);
				CloseAll();
				break;
			case "900":
				sendMessageAll("900|"+tks[1]);
				userV.remove(this);
				CloseAll();
				break;
		}
	}

	private void CloseAll() {
		try {
			if(in!=null) in.close();
			if(out!=null) out.close();
			if(sock!=null) {
				sock.close();
				sock=null;
			}
		}catch(Exception e) {
			System.out.println("CloseAll() 오류: "+e);
		}
	}

	/**아이디 중복 여부를 체크하는 메소드*/
	private boolean isDuplicated(String uid2) {
		Enumeration<ChatHandler> en = userV.elements();
		while(en.hasMoreElements()) {
			ChatHandler userChat = en.nextElement();
			if(userChat.uid.equals(uid2)) {
				return true;
			}
		}
		return false;
	}

	/* 서버와 전송한 특정 클라이언트 한명에게 메시지를 보낸다. */
	private synchronized void sendMessageTo(String msg) 
	throws IOException {
		out.writeObject(msg);
		out.flush();
	}
	
	/* 서버와 접속해있는 모든 클에게 메시지를 보냄 */
	private synchronized void sendMessageAll(String msg) {
		for(ChatHandler userChat:userV) {
			try {
				userChat.out.writeObject(msg);
				userChat.out.flush();
			} catch (IOException e) {
				// 연결이 끊긴 클라이언트를 벡터에서 제거
				System.out.println("sendMessageAll()예외: "+e);
				userV.remove(userChat);
				break;
			}
		}
	}
}