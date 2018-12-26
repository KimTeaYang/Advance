package javaChat;

import java.io.*;
import java.net.*;
import java.util.*;
/*���������� Ŭ���̾�Ʈ�� �޽����� �ְ�޴� ���� �Ѵ�.*/
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
			System.out.println("ChatHandler()����: "+e);
		}
	}
	
	@Override
	public void run() {
		// Ŭ�� �����ϸ� ���� ���̵� ������.
		
		try {
			Object obj = in.readObject();
			if(obj instanceof String) {
				uid = (String)obj;
				System.out.println("##["+uid+"]�� ������##");
			}
			// ���̵� �ߺ��ƴ��� ���θ� üũ
			// 1. �ߺ��ȴٸ�
			boolean isExist = isDuplicated(uid);
			if(isExist) {
				sendMessageTo("700|");
				//���̵� �ߺ��� "700|"�� ������.
			}else {
				// 2. �ߺ����� �ʴ´ٸ�
				// ��� ������(Ŭ)���� ������ ����� ���̵� �����ش�.
					
				// 1) ��� ������ Ŭ���� ������ ������ Ŭ�� ������ �����ֱ�
				for(ChatHandler userChat:userV) {
					String msg = "100|"+userChat.uid;
					sendMessageTo(msg);
				}
					
				userV.add(this);
					
				// 2) ��� ������ Ŭ�� ������ ����.
				String sendMsg="100|"+this.uid;
				sendMessageAll(sendMsg);
			}
			
			while(true) {
				//Ŭ�� �������� �޽����� ��� ��� �� ������ �м�(parse)�Ѵ�.
				String cMsg = (String)in.readObject();
				
				parse(cMsg);
			}
			
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("ChatHandler run()����: "+e);
		}
	}
	
	/**���������� �м��Ͽ� �������ݺ��� ������ ó����*/
	private void parse(String cMsg) {
		String[] tks = cMsg.split("\\|");
		switch(tks[0]) {
			case "400": 
				//Ŭ=>���� "400|���ڻ�|�޽���"
				String fntRgb = tks[1];
				String message = tks[2];
				
				//����=>��� Ŭ "400|���̵�|���ڻ�|�޽���
				sendMessageAll(
						"400|"+uid+"|"+fntRgb+"|"+message);
				break;
			case "500": //500|�ӼӸ��� ������ ����� ���̵�|�ӼӸ� �޽���
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
			case "600": // 600|�������̵�|������̵�
				boolean isExist = isDuplicated(tks[2]);
				if(isExist) {
					try {
						sendMessageTo("700|id�������|"+tks[2]);
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
			case "800": // Ŭ=>���� "800|�����ϴ»�� id"
				String logoutId = tks[1];
				sendMessageAll("800|"+logoutId);
				// logoutId�� this.uid�� ����
				
				//���Ϳ��� �����ϴ� Ŭ�� ����ϴ� ChatHandler�� �����Ѵ�.
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
			System.out.println("CloseAll() ����: "+e);
		}
	}

	/**���̵� �ߺ� ���θ� üũ�ϴ� �޼ҵ�*/
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

	/* ������ ������ Ư�� Ŭ���̾�Ʈ �Ѹ��� �޽����� ������. */
	private synchronized void sendMessageTo(String msg) 
	throws IOException {
		out.writeObject(msg);
		out.flush();
	}
	
	/* ������ �������ִ� ��� Ŭ���� �޽����� ���� */
	private synchronized void sendMessageAll(String msg) {
		for(ChatHandler userChat:userV) {
			try {
				userChat.out.writeObject(msg);
				userChat.out.flush();
			} catch (IOException e) {
				// ������ ���� Ŭ���̾�Ʈ�� ���Ϳ��� ����
				System.out.println("sendMessageAll()����: "+e);
				userV.remove(userChat);
				break;
			}
		}
	}
}