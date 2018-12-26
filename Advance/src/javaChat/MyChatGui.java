/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaChat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class MyChatGui extends javax.swing.JFrame 
implements Runnable {
	
	Socket sock;
	String host;
	final int port = 33333;
	ObjectOutputStream out;
	ObjectInputStream in;
	boolean isStop = false;
	String id;
	boolean isSendOne = false; // 귓속말이라면 true
	Color fontCr = Color.BLACK; // 글자색(디폴트 검정색)
	
	DefaultTableModel userModel;
	
	StyledDocument doc;
	SimpleAttributeSet att;
	
	Emoticon emoticon = new Emoticon(this);

    public MyChatGui() {
        initComponents();
        // JTextPane의 문서 모델 얻기
        doc = tpMsg.getStyledDocument();
        
        // 창닫기 이벤트 처리--
        this.addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowClosing(java.awt.event.WindowEvent e) {
        		isStop = true;
        		exitProcess();
        	}
        });
        
        emoticon.bt[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==emoticon.bt[0]) {
					
				}
			}
		});
        
        emoticon.bt[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        emoticon.bt[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        emoticon.bt[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        emoticon.bt[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        emoticon.bt[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        emoticon.bt[6].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        emoticon.bt[7].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        emoticon.bt[8].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        emoticon.bt[9].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        emoticon.bt[10].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        emoticon.bt[11].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        emoticon.bt[12].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
    }
    
    class Handler implements ActionListener{
    	public Handler() {
    		
    	}
    	
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		
    	}
    }
    
    @Override
    public void run() {
    	try {
			//서버가 보내오는 메시지를 계속 듣고 tpMsg에 메시지를 출력한다.
			while(!isStop) {
				String serverMsg = (String)in.readObject();
				
				if(serverMsg==null) return;
				// 서버가 보내오는 메시지를 계속 듣고 이를 분석하는 메소드를 호출
				process(serverMsg);
			}
		} catch (Exception e) {
			System.out.println("클 run()예외: "+e);
		}
    }
    
    /**프로토콜별로 로직을 처리하는 메소드*/
    public void process(String msg) {
		//구분자('|')를 기준으로 문자열을 쪼개서 토큰으로 만든다.
    	String[] tokens = msg.split("\\|");
    	switch(tokens[0]) {
	    	case "100": //입장 100|아이디
	    		userModel=(DefaultTableModel)userTable.getModel();
	    		String[] rowData = {tokens[1]};
	    		userModel.addRow(rowData);
				break;
	    	case "300": // 300|아이디|이모티콘 사진
	    		break;
	    	case "400": // 400|아이디|글꼴색|메시지
	    		String fromId = tokens[1];
	    		String foRgb = tokens[2];
	    		String fromMsg = tokens[3];
	    		//showChat(fromId,foRgb,fromMsg);
	    		showCacaoStyle(fromId,foRgb,fromMsg);
				break;
	    	case "500": // 500|보낸사람 아이디|메시지
	    		String myId = tokens[1];
	    		String myMsg = tokens[2];
	    		String str = "["+myId+"]님이 보내는 귀속말>>"
	    				+myMsg+"\r\n";
	    		//showChat(Color.yellow, new Color(227,0,227),str);
	    		showCacaoStyle("Other", Color.BLUE, Color.white, str);
				break;
	    	case "600": // 600|기존아이디|변경아이디
	    		String ccid = tokens[1]; // 기존 아이디
	    		String gid = tokens[2]; // 변경 아이디;
	    		if(this.id.equals(ccid)) {
	    			this.id = gid;
	    			lbInfo.setText("아이디: "+this.id);
	    		}
	    		for(int i=0;i<userModel.getRowCount();i++) {
	        		// 입장한 사람의 id를 꺼내옴
	        		String cId = userModel.getValueAt(i, 0).toString();
	        		if(cId.equals(ccid)) {
	        			userModel.setValueAt(gid, i, 0);
	        			break;
	        		}
	        	}
	    		
	    		String str1 = ccid+"에서 "+gid+"로 아이디가 변경되었습니다.\r\n";
	    		showChat(Color.white,Color.red,str1);
				break;
	    	case "700": // 서버=>클 아이디 중복일 경우 700|
	    		if(tokens[1].equals("id변경실패")) {
	    			showMsg(tokens[2]+"란 아이디는 이미 존재해요");
	    			return;
	    		}
	    		showMsg(id+"란 아이디는 이미 존재해요");
	    		exitChat(1); //채팅을 퇴장 또는 종료하는 메소드
	    		// 1을 넘기면 퇴장, 0을 넘기면 종료
				break;
	    	case "800": // 서버=>클 "800|퇴장하는사람id"
	    		String logoutId = tokens[1];
	    		logout(logoutId, 1); // 1:퇴장, 0:종료
				break;
	    	case "900": // 서버=>클 "900|종료하는사람id"
	    		String exitId = tokens[1];
	    		logout(exitId,0);
				break;
    	}
	}

    private void logout(String logoutId, int mode) {
		// 1. 퇴장하는 고객이 본인이 아닐 경우
    	// userModel에서 퇴장하는 고객의 id를 제거하고 tpMsg에 "xxx님이 퇴장" 
    	String exitId = "";
    	for(int i=0;i<userModel.getRowCount();i++) {
    		// 입장한 사람의 id를 꺼내옴
    		String cId = userModel.getValueAt(i, 0).toString();
    		
    		if(cId.equals(logoutId)) {
    			userModel.removeRow(i);
    			exitId = cId;
    			break;
    		}
    	}
    	
    	if(mode==1) { // 로그아웃
    		String str = "["+exitId+"]님이 퇴장하였습니다.\n";
    		showChat(Color.white,Color.red,str);
    	}else if(mode==0) { // 종료
    		String str = "["+exitId+"]님이 접속을 끊었습니다.\n";
    		showChat(Color.white,Color.red,str);
    	}
    	// 2. 퇴장하는 고객이 본인일 경우
    	// 로그아웃 처리(채팅방에서 로그인방으로 전환)
    	if(exitId.equals(this.id)) {
    		exitChat(mode);
    	}
	}
    
    private void exitChat(int mode) {
		try {
			isStop=true;
			lbInfo.setText("");
			tfId.setText("");
			tfId.requestFocus();
			if(out!=null) out.close();
			if(in!=null) in.close();
			if(sock!=null) {
				sock.close();
				sock=null;
			}
		} catch (IOException e) {
			System.out.println("exitChat()예외: "+e);
		}
		if(mode==0) { //종료
			this.dispose(); //프레임 닫기
			System.exit(0); //시스템 종료
		}else if(mode==1) { //로그아웃 처리
			userModel.setDataVector(null, new String[] {"아이디"});
			this.tabEnable(0, 1);
			//로그인 탭(0)은 활성화, 채팅방 탭(1)은 비활성화
		}
	}

	/**클라이언트가 전달한 메시지를 화면(JTextPane)에 뿌리는 메소드.
     * 스타일을 적용하여 표현한다.*/
	private void showChat(
			String fromId, String foRgb, String fromMsg) {
		synchronized(this) { // 동기화 블럭
			int rgb = Integer.parseInt(foRgb);
			att = new SimpleAttributeSet();
			StyleConstants.setForeground(att, new Color(rgb));
			StyleConstants.setFontSize(att, 20);
			
			int caretPos = doc.getEndPosition().getOffset()-1;
			tpMsg.setCaretPosition(caretPos);
			
			try {
				String msg = fromId+">>"+fromMsg+ "\r\n";
				doc.insertString(caretPos, msg, att);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**귓속말 등 스타일을 적용하여 보여주는 메소드*/
	public void showChat(Color bgCr, Color foCr, String msg) {
		synchronized(this) {
			att = new SimpleAttributeSet();
			StyleConstants.setForeground(att, foCr);
			StyleConstants.setBackground(att, bgCr);
			StyleConstants.setFontSize(att, 20);
			
			int offset = doc.getEndPosition().getOffset()-1;
			tpMsg.setCaretPosition(offset);
			try {
				doc.insertString(offset, msg, att);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}
	}

	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabP = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfHost = new javax.swing.JTextField();
        btCon = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tpMsg = new javax.swing.JTextPane();
        tf = new javax.swing.JTextField();
        chk = new javax.swing.JCheckBox();
        btColor = new javax.swing.JButton();
        lb = new javax.swing.JLabel();
        btEmoti = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        lbInfo = new javax.swing.JLabel();
        btLogout = new javax.swing.JButton();
        btExit = new javax.swing.JButton();

        setDefaultCloseOperation(
        		javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("굴림", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("::CACAO APP v18.2::");

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("아이디 : ");

        jLabel5.setText("호스트 : ");

        tfHost.setText("192.168.0.92");
        tfHost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHostActionPerformed(evt);
            }
        });

        btCon.setMnemonic('C');
        btCon.setText("연 결");
        btCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConActionPerformed(evt);
            }
        });

        btCancel.setMnemonic('R');
        btCancel.setText("취 소");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfId)
                            .addComponent(tfHost)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btCon, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfId)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfHost, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btCon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("굴림", 1, 33)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("배너 광고 월 30");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabP.addTab("로그인", jPanel1);

        tpMsg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
        jScrollPane2.setViewportView(tpMsg);

        tf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));
        tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfActionPerformed(evt);
            }
        });

        chk.setText("귓속말");
        chk.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkItemStateChanged(evt);
            }
        });

        btColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Y.png"))); // NOI18N
        btColor.setMnemonic('F');
        btColor.setText("글자색");
        btColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btColorActionPerformed(evt);
            }
        });

        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("가");
        lb.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btEmoti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btEmoti.setMnemonic('E');
        btEmoti.setText("이모티콘");
        btEmoti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEmotiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(chk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btColor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEmoti)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addComponent(tf))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chk, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btEmoti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabP.addTab("채팅방", jPanel2);

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "아이디"
            }
        ));
        jScrollPane1.setViewportView(userTable);

        lbInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.png"))); // NOI18N
        lbInfo.setText("아이디:");
        lbInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("MyInfo"));

        btLogout.setBackground(new java.awt.Color(255, 51, 0));
        btLogout.setForeground(new java.awt.Color(255, 255, 255));
        btLogout.setMnemonic('V');
        btLogout.setText("퇴 장");
        btLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogoutActionPerformed(evt);
            }
        });

        btExit.setBackground(new java.awt.Color(255, 153, 255));
        btExit.setForeground(new java.awt.Color(255, 255, 255));
        btExit.setMnemonic('X');
        btExit.setText("종 료");
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabP, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btExit, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tabP))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btExit, btLogout});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
    	tfId.setText("");
    }

    private void tfHostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHostActionPerformed
        
    }

    private void btConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConActionPerformed
    	host = tfHost.getText();
    	id = tfId.getText();
    	
    	if(host==null||host.trim().isEmpty()) {
    		showMsg("접속할 호스트명(IP)을 입력하세요");
    		tfHost.requestFocus();
    		return;
    	}
    	if(id==null||id.trim().isEmpty()) {
    		showMsg("ID를 입력하세요");
    		tfId.requestFocus();
    		return;
    	}
    	isStop = false;
    	
        chatEnter();
        tabEnable(1,0);
        
        lbInfo.setText("아이디: "+id);
        lbInfo.setForeground(Color.blue);
    }

    private void tabEnable(int enable, int disable) {
		tabP.setEnabledAt(enable, true);
		tabP.setEnabledAt(disable, false);
		tabP.setSelectedIndex(enable);
	}

	/**채팅방에 입장하는 메소드*/
    private void chatEnter() {
    	try {
	    	sock = new Socket(host, port);
			tpMsg.setText("##채팅 서버와 연결됨##\r\n");
			
			out = new ObjectOutputStream(sock.getOutputStream());
			in = new ObjectInputStream(sock.getInputStream());
			//out을 먼저생성하면 서버단에서는 in을 먼저 생성

			//서버에 아이디를 전송
			out.writeObject(id);
			out.flush();
			
			//서버가 보내오는 메시지를 듣는 스레드 동작
			Thread listener = new Thread(this);
			listener.start();
		
		} catch (IOException e) {
			System.out.println("chatEnter()예외: "+e);
		}
	}

	private void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}

	private void btLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogoutActionPerformed
		int yn = showConfirmMsg("퇴장할까요?");
		if(yn==JOptionPane.YES_OPTION) {
			try {
				out.writeObject("800|"+this.id);
				out.flush();
			} catch (IOException e) {
				System.out.println("퇴장 중 예외: "+e);
			}
		}else {
			showMsg("취소되었습니다.");
		}
    }//GEN-LAST:event_btLogoutActionPerformed

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
    	exitProcess();
    }//GEN-LAST:event_btExitActionPerformed
    
    private void exitProcess() {
    	int yn = showConfirmMsg("종료할까요?");
    	if(yn==JOptionPane.YES_OPTION) {
    		if(sock!=null) { //1) 채팅 서버에 접속하고 종료하는 경우
    			try {
					out.writeObject("900|"+this.id);
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}else { //2) 채팅 서버에 접속(연결)하지 않고 종료하는 경우
    			System.exit(0);
    		}
		}else {
			showMsg("취소되었습니다.");
		}
    }

    private int showConfirmMsg(String msg) {
		int yn = JOptionPane.showConfirmDialog(
				this, msg,"퇴장 확인",JOptionPane.YES_NO_OPTION);
		return yn;
	}

	private void tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfActionPerformed
        String sendMsg = tf.getText();
        if(sendMsg==null||sendMsg.equals("")) {
        	return;
        }
        sendMessage(sendMsg);
        tf.setText("");
        tf.requestFocus();
    }

    private void sendMessage(String msg) {
		/* 사용자가 혹시라도 대화내용 중에 '|'를 포함시키면 프로토콜이 엉망이 된다.
		 * '|'가 있다면 'ㅣ'로 바꾸기 */
    	msg = msg.replace('|', 'l');
    	
    	if(msg.equals("600")) { // 600|기존아이디|변경아이디
    		String cId = JOptionPane.showInputDialog(
    				"변경할 아이디를 입력하세요");
    		String str = "600|"+id+"|"+cId;
    		try {
				out.writeObject(str);
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
    		return;
    	}
    	
    	// 1) 일반 대화 메시지라면 "400|글꼴색|메시지"를 서버에 보낸다.
    	try {
	    	if(!isSendOne) {
	    		int rgb = fontCr.getRGB();
	    		String str="400|"+rgb+"|"+msg;
	    		out.writeObject(str);
	    		out.flush();
	    	}else {
	    		// 2) 500|귓속말을 보내는 사람의 아이디|귓속말 메시지
	    		int row = userTable.getSelectedRow();
	    		// 만약 선택한 행이 없다면 -1을 반환함.
	    		if(row==-1) {
	    			showMsg("귓속말 보낼 사람을 먼저 선택하세요.");
	    			return;
	    		}
	    		String toId = userTable.getValueAt(row, 0).toString();
	    		String sndMsg = "500|"+toId+"|"+msg;
	    		out.writeObject(sndMsg);
	    		out.flush();
	    		
	    		String str = "["+toId+"]님에게 보내는 귀속말>>"
	    				+msg+"\r\n";
	    		//showChat(Color.yellow, new Color(227,0,227),str);
	    		showCacaoStyle("Me", Color.red, Color.white, str);
	    	}
	    	
    	}catch(IOException e){
    		System.out.println("sendMessage() 중 예외: "+e);
    	}
	}

	private void chkItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkItemStateChanged
		// 귓속말 보내기에 체크 했다면
		int mode = evt.getStateChange();
		if(mode==ItemEvent.SELECTED) {
			isSendOne = true;
		}else {
			isSendOne = false;
		}
    }

    private void btColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btColorActionPerformed
        Color cr = JColorChooser.showDialog(
        		this, "글자색", Color.black);
        if(cr==null) return;
        fontCr=cr;
        lb.setForeground(fontCr);
    }
    
    

    private void btEmotiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmotiActionPerformed
//    	tpMsg.insertComponent(
//        		new JLabel(new ImageIcon("C:\\myjava\\Workspace\\Advance\\src\\images\\골프공.png")));
    	emoticon.setSize(400, 400);
    	emoticon.setLocation(this.getWidth(), 0);
    	emoticon.setVisible(true);
    }
    
    public void setStyle(JLabel lb, String msg, SimpleAttributeSet attr){
    	int caretPos=doc.getEndPosition().getOffset()-1;    	
    	tpMsg.setCaretPosition(caretPos);
    	int offset=tpMsg.getCaretPosition();

    	//텍스트페인에 라벨 끼워넣기
	   //(JLabel은 문자열형태,아이콘 형태등 다양하게 표현 가능.)
    	tpMsg.insertComponent(lb);
    	try {
    		String sg="\r\n";//엔터값 끼워넣기(줄바꿈하도록)
    		
			doc.insertString(offset, sg, attr);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
    	//정렬방식 문단속성 적용
    	doc.setParagraphAttributes(offset+2,msg.length() , attr, true);
    	tpMsg.setCaretPosition(offset+2);
    	//커릿의 위치를 엔터값 2바이트 더해서 위치시킴

	}
    
    public synchronized void showCacaoStyle(String who,Color bgCr, 
    		Color fgCr, String msg) {
    	JLabel lb=new JLabel(msg);
    	lb.setOpaque(true);//라벨 배경색이 적용되려면 투명하게
    	lb.setPreferredSize(new Dimension(700,50)); 
    	//lb의 높이를 50으로 줌. 폭은 문자열 내용만큼 차지함
    	lb.setForeground(fgCr);
    	lb.setBackground(bgCr);
    	
    	if(who.equals("Me")) {
    		//내가 귓속말 보낼 경우
    		//보낸이가 나라면 오른쪽에 라벨 보여주기(노란색)
    		att=new SimpleAttributeSet();
    		StyleConstants.setAlignment(att, StyleConstants.ALIGN_RIGHT);
    	}else {
    		//내가 귓속말을 받을 경우
    		att=new SimpleAttributeSet();
    		StyleConstants.setAlignment(att, StyleConstants.ALIGN_LEFT);
    	}
    	
    	setStyle(lb,msg,att);	
    }
    
    public synchronized void showCacaoStyle(String chatId, String foRgb,String msg) {
    	
    	String msg2="   "+chatId+">>"+msg+"  \n";
    	JLabel lb=new JLabel(msg2);
    	lb.setOpaque(true);//라벨 배경색이 적용되려면 투명하게
    	lb.setPreferredSize(new Dimension(700,50)); 
    	//lb의 높이를 40으로 줌. 폭은 문자열 내용만큼 차지함
    	lb.setForeground(new Color(Integer.parseInt(foRgb)));
    	
    	if(chatId.equals(id)) {
    		//보낸이가 나라면 오른쪽에 라벨 보여주기(노란색)
    		att=new SimpleAttributeSet();
    		StyleConstants.setAlignment(att, StyleConstants.ALIGN_RIGHT);
    		lb.setBackground(Color.YELLOW);
    	}else {
    		//보낸이가 다른이라면 왼쪽에 라벨 보여주기(핑크색)
    		att=new SimpleAttributeSet();
    		StyleConstants.setAlignment(att, StyleConstants.ALIGN_LEFT);
    		lb.setBackground(Color.pink);
    	}
    	setStyle(lb,msg2,att);
    	
    }//-------------------------------

    public synchronized void showEmoticon(String chatId, ImageIcon icon) {
        tpMsg.setCaretPosition(doc.getEndPosition().getOffset() - 1);
        int end = tpMsg.getCaretPosition();

        String msg2 = "[" + chatId + "]님" + "\r\n";
        
        JLabel lb=new JLabel(msg2,icon,JLabel.CENTER);
        
    	//lb.setOpaque(true);
        //라벨 배경색이 적용되려면 투명하게 true준다.
        //이모티콘 보낼 때는 불투명하게 false
    	lb.setPreferredSize(new Dimension(700,90)); 
    	//lb의 높이를 90으로 줌. 폭은 문자열 내용만큼 차지함
    	lb.setHorizontalTextPosition(JLabel.CENTER);
    	lb.setVerticalTextPosition(JLabel.BOTTOM);
    	
    	if(chatId.equals(id)) {
    		//보낸이가 나라면 오른쪽에 라벨 보여주기(노란색)
    		att=new SimpleAttributeSet();
    		StyleConstants.setAlignment(att, StyleConstants.ALIGN_RIGHT);
    		
    	}else {
    		//보낸이가 다른이라면 왼쪽에 라벨 보여주기(핑크색)
    		att=new SimpleAttributeSet();
    		StyleConstants.setAlignment(att, StyleConstants.ALIGN_LEFT);
    		
    	}
    	setStyle(lb,msg2,att);
    }//----------------------
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyChatGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyChatGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyChatGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyChatGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyChatGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btColor;
    private javax.swing.JButton btCon;
    private javax.swing.JButton btEmoti;
    private javax.swing.JButton btExit;
    private javax.swing.JButton btLogout;
    private javax.swing.JCheckBox chk;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lbInfo;
    private javax.swing.JTabbedPane tabP;
    private javax.swing.JTextField tf;
    private javax.swing.JTextField tfHost;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextPane tpMsg;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}