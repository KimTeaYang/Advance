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
	boolean isSendOne = false; // �ӼӸ��̶�� true
	Color fontCr = Color.BLACK; // ���ڻ�(����Ʈ ������)
	
	DefaultTableModel userModel;
	
	StyledDocument doc;
	SimpleAttributeSet att;
	
	Emoticon emoticon = new Emoticon(this);

    public MyChatGui() {
        initComponents();
        // JTextPane�� ���� �� ���
        doc = tpMsg.getStyledDocument();
        
        // â�ݱ� �̺�Ʈ ó��--
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
			//������ �������� �޽����� ��� ��� tpMsg�� �޽����� ����Ѵ�.
			while(!isStop) {
				String serverMsg = (String)in.readObject();
				
				if(serverMsg==null) return;
				// ������ �������� �޽����� ��� ��� �̸� �м��ϴ� �޼ҵ带 ȣ��
				process(serverMsg);
			}
		} catch (Exception e) {
			System.out.println("Ŭ run()����: "+e);
		}
    }
    
    /**�������ݺ��� ������ ó���ϴ� �޼ҵ�*/
    public void process(String msg) {
		//������('|')�� �������� ���ڿ��� �ɰ��� ��ū���� �����.
    	String[] tokens = msg.split("\\|");
    	switch(tokens[0]) {
	    	case "100": //���� 100|���̵�
	    		userModel=(DefaultTableModel)userTable.getModel();
	    		String[] rowData = {tokens[1]};
	    		userModel.addRow(rowData);
				break;
	    	case "300": // 300|���̵�|�̸�Ƽ�� ����
	    		break;
	    	case "400": // 400|���̵�|�۲û�|�޽���
	    		String fromId = tokens[1];
	    		String foRgb = tokens[2];
	    		String fromMsg = tokens[3];
	    		//showChat(fromId,foRgb,fromMsg);
	    		showCacaoStyle(fromId,foRgb,fromMsg);
				break;
	    	case "500": // 500|������� ���̵�|�޽���
	    		String myId = tokens[1];
	    		String myMsg = tokens[2];
	    		String str = "["+myId+"]���� ������ �ͼӸ�>>"
	    				+myMsg+"\r\n";
	    		//showChat(Color.yellow, new Color(227,0,227),str);
	    		showCacaoStyle("Other", Color.BLUE, Color.white, str);
				break;
	    	case "600": // 600|�������̵�|������̵�
	    		String ccid = tokens[1]; // ���� ���̵�
	    		String gid = tokens[2]; // ���� ���̵�;
	    		if(this.id.equals(ccid)) {
	    			this.id = gid;
	    			lbInfo.setText("���̵�: "+this.id);
	    		}
	    		for(int i=0;i<userModel.getRowCount();i++) {
	        		// ������ ����� id�� ������
	        		String cId = userModel.getValueAt(i, 0).toString();
	        		if(cId.equals(ccid)) {
	        			userModel.setValueAt(gid, i, 0);
	        			break;
	        		}
	        	}
	    		
	    		String str1 = ccid+"���� "+gid+"�� ���̵� ����Ǿ����ϴ�.\r\n";
	    		showChat(Color.white,Color.red,str1);
				break;
	    	case "700": // ����=>Ŭ ���̵� �ߺ��� ��� 700|
	    		if(tokens[1].equals("id�������")) {
	    			showMsg(tokens[2]+"�� ���̵�� �̹� �����ؿ�");
	    			return;
	    		}
	    		showMsg(id+"�� ���̵�� �̹� �����ؿ�");
	    		exitChat(1); //ä���� ���� �Ǵ� �����ϴ� �޼ҵ�
	    		// 1�� �ѱ�� ����, 0�� �ѱ�� ����
				break;
	    	case "800": // ����=>Ŭ "800|�����ϴ»��id"
	    		String logoutId = tokens[1];
	    		logout(logoutId, 1); // 1:����, 0:����
				break;
	    	case "900": // ����=>Ŭ "900|�����ϴ»��id"
	    		String exitId = tokens[1];
	    		logout(exitId,0);
				break;
    	}
	}

    private void logout(String logoutId, int mode) {
		// 1. �����ϴ� ���� ������ �ƴ� ���
    	// userModel���� �����ϴ� ���� id�� �����ϰ� tpMsg�� "xxx���� ����" 
    	String exitId = "";
    	for(int i=0;i<userModel.getRowCount();i++) {
    		// ������ ����� id�� ������
    		String cId = userModel.getValueAt(i, 0).toString();
    		
    		if(cId.equals(logoutId)) {
    			userModel.removeRow(i);
    			exitId = cId;
    			break;
    		}
    	}
    	
    	if(mode==1) { // �α׾ƿ�
    		String str = "["+exitId+"]���� �����Ͽ����ϴ�.\n";
    		showChat(Color.white,Color.red,str);
    	}else if(mode==0) { // ����
    		String str = "["+exitId+"]���� ������ �������ϴ�.\n";
    		showChat(Color.white,Color.red,str);
    	}
    	// 2. �����ϴ� ���� ������ ���
    	// �α׾ƿ� ó��(ä�ù濡�� �α��ι����� ��ȯ)
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
			System.out.println("exitChat()����: "+e);
		}
		if(mode==0) { //����
			this.dispose(); //������ �ݱ�
			System.exit(0); //�ý��� ����
		}else if(mode==1) { //�α׾ƿ� ó��
			userModel.setDataVector(null, new String[] {"���̵�"});
			this.tabEnable(0, 1);
			//�α��� ��(0)�� Ȱ��ȭ, ä�ù� ��(1)�� ��Ȱ��ȭ
		}
	}

	/**Ŭ���̾�Ʈ�� ������ �޽����� ȭ��(JTextPane)�� �Ѹ��� �޼ҵ�.
     * ��Ÿ���� �����Ͽ� ǥ���Ѵ�.*/
	private void showChat(
			String fromId, String foRgb, String fromMsg) {
		synchronized(this) { // ����ȭ ��
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
	
	/**�ӼӸ� �� ��Ÿ���� �����Ͽ� �����ִ� �޼ҵ�*/
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
        jLabel2.setFont(new java.awt.Font("����", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("::CACAO APP v18.2::");

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("���̵� : ");

        jLabel5.setText("ȣ��Ʈ : ");

        tfHost.setText("192.168.0.92");
        tfHost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHostActionPerformed(evt);
            }
        });

        btCon.setMnemonic('C');
        btCon.setText("�� ��");
        btCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConActionPerformed(evt);
            }
        });

        btCancel.setMnemonic('R');
        btCancel.setText("�� ��");
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

        jLabel3.setFont(new java.awt.Font("����", 1, 33)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("��� ���� �� 30");

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

        tabP.addTab("�α���", jPanel1);

        tpMsg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
        jScrollPane2.setViewportView(tpMsg);

        tf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));
        tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfActionPerformed(evt);
            }
        });

        chk.setText("�ӼӸ�");
        chk.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkItemStateChanged(evt);
            }
        });

        btColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Y.png"))); // NOI18N
        btColor.setMnemonic('F');
        btColor.setText("���ڻ�");
        btColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btColorActionPerformed(evt);
            }
        });

        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("��");
        lb.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btEmoti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btEmoti.setMnemonic('E');
        btEmoti.setText("�̸�Ƽ��");
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

        tabP.addTab("ä�ù�", jPanel2);

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "���̵�"
            }
        ));
        jScrollPane1.setViewportView(userTable);

        lbInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.png"))); // NOI18N
        lbInfo.setText("���̵�:");
        lbInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("MyInfo"));

        btLogout.setBackground(new java.awt.Color(255, 51, 0));
        btLogout.setForeground(new java.awt.Color(255, 255, 255));
        btLogout.setMnemonic('V');
        btLogout.setText("�� ��");
        btLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogoutActionPerformed(evt);
            }
        });

        btExit.setBackground(new java.awt.Color(255, 153, 255));
        btExit.setForeground(new java.awt.Color(255, 255, 255));
        btExit.setMnemonic('X');
        btExit.setText("�� ��");
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
    		showMsg("������ ȣ��Ʈ��(IP)�� �Է��ϼ���");
    		tfHost.requestFocus();
    		return;
    	}
    	if(id==null||id.trim().isEmpty()) {
    		showMsg("ID�� �Է��ϼ���");
    		tfId.requestFocus();
    		return;
    	}
    	isStop = false;
    	
        chatEnter();
        tabEnable(1,0);
        
        lbInfo.setText("���̵�: "+id);
        lbInfo.setForeground(Color.blue);
    }

    private void tabEnable(int enable, int disable) {
		tabP.setEnabledAt(enable, true);
		tabP.setEnabledAt(disable, false);
		tabP.setSelectedIndex(enable);
	}

	/**ä�ù濡 �����ϴ� �޼ҵ�*/
    private void chatEnter() {
    	try {
	    	sock = new Socket(host, port);
			tpMsg.setText("##ä�� ������ �����##\r\n");
			
			out = new ObjectOutputStream(sock.getOutputStream());
			in = new ObjectInputStream(sock.getInputStream());
			//out�� ���������ϸ� �����ܿ����� in�� ���� ����

			//������ ���̵� ����
			out.writeObject(id);
			out.flush();
			
			//������ �������� �޽����� ��� ������ ����
			Thread listener = new Thread(this);
			listener.start();
		
		} catch (IOException e) {
			System.out.println("chatEnter()����: "+e);
		}
	}

	private void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}

	private void btLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogoutActionPerformed
		int yn = showConfirmMsg("�����ұ��?");
		if(yn==JOptionPane.YES_OPTION) {
			try {
				out.writeObject("800|"+this.id);
				out.flush();
			} catch (IOException e) {
				System.out.println("���� �� ����: "+e);
			}
		}else {
			showMsg("��ҵǾ����ϴ�.");
		}
    }//GEN-LAST:event_btLogoutActionPerformed

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
    	exitProcess();
    }//GEN-LAST:event_btExitActionPerformed
    
    private void exitProcess() {
    	int yn = showConfirmMsg("�����ұ��?");
    	if(yn==JOptionPane.YES_OPTION) {
    		if(sock!=null) { //1) ä�� ������ �����ϰ� �����ϴ� ���
    			try {
					out.writeObject("900|"+this.id);
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}else { //2) ä�� ������ ����(����)���� �ʰ� �����ϴ� ���
    			System.exit(0);
    		}
		}else {
			showMsg("��ҵǾ����ϴ�.");
		}
    }

    private int showConfirmMsg(String msg) {
		int yn = JOptionPane.showConfirmDialog(
				this, msg,"���� Ȯ��",JOptionPane.YES_NO_OPTION);
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
		/* ����ڰ� Ȥ�ö� ��ȭ���� �߿� '|'�� ���Խ�Ű�� ���������� ������ �ȴ�.
		 * '|'�� �ִٸ� '��'�� �ٲٱ� */
    	msg = msg.replace('|', 'l');
    	
    	if(msg.equals("600")) { // 600|�������̵�|������̵�
    		String cId = JOptionPane.showInputDialog(
    				"������ ���̵� �Է��ϼ���");
    		String str = "600|"+id+"|"+cId;
    		try {
				out.writeObject(str);
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
    		return;
    	}
    	
    	// 1) �Ϲ� ��ȭ �޽������ "400|�۲û�|�޽���"�� ������ ������.
    	try {
	    	if(!isSendOne) {
	    		int rgb = fontCr.getRGB();
	    		String str="400|"+rgb+"|"+msg;
	    		out.writeObject(str);
	    		out.flush();
	    	}else {
	    		// 2) 500|�ӼӸ��� ������ ����� ���̵�|�ӼӸ� �޽���
	    		int row = userTable.getSelectedRow();
	    		// ���� ������ ���� ���ٸ� -1�� ��ȯ��.
	    		if(row==-1) {
	    			showMsg("�ӼӸ� ���� ����� ���� �����ϼ���.");
	    			return;
	    		}
	    		String toId = userTable.getValueAt(row, 0).toString();
	    		String sndMsg = "500|"+toId+"|"+msg;
	    		out.writeObject(sndMsg);
	    		out.flush();
	    		
	    		String str = "["+toId+"]�Կ��� ������ �ͼӸ�>>"
	    				+msg+"\r\n";
	    		//showChat(Color.yellow, new Color(227,0,227),str);
	    		showCacaoStyle("Me", Color.red, Color.white, str);
	    	}
	    	
    	}catch(IOException e){
    		System.out.println("sendMessage() �� ����: "+e);
    	}
	}

	private void chkItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkItemStateChanged
		// �ӼӸ� �����⿡ üũ �ߴٸ�
		int mode = evt.getStateChange();
		if(mode==ItemEvent.SELECTED) {
			isSendOne = true;
		}else {
			isSendOne = false;
		}
    }

    private void btColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btColorActionPerformed
        Color cr = JColorChooser.showDialog(
        		this, "���ڻ�", Color.black);
        if(cr==null) return;
        fontCr=cr;
        lb.setForeground(fontCr);
    }
    
    

    private void btEmotiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEmotiActionPerformed
//    	tpMsg.insertComponent(
//        		new JLabel(new ImageIcon("C:\\myjava\\Workspace\\Advance\\src\\images\\������.png")));
    	emoticon.setSize(400, 400);
    	emoticon.setLocation(this.getWidth(), 0);
    	emoticon.setVisible(true);
    }
    
    public void setStyle(JLabel lb, String msg, SimpleAttributeSet attr){
    	int caretPos=doc.getEndPosition().getOffset()-1;    	
    	tpMsg.setCaretPosition(caretPos);
    	int offset=tpMsg.getCaretPosition();

    	//�ؽ�Ʈ���ο� �� �����ֱ�
	   //(JLabel�� ���ڿ�����,������ ���µ� �پ��ϰ� ǥ�� ����.)
    	tpMsg.insertComponent(lb);
    	try {
    		String sg="\r\n";//���Ͱ� �����ֱ�(�ٹٲ��ϵ���)
    		
			doc.insertString(offset, sg, attr);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
    	//���Ĺ�� ���ܼӼ� ����
    	doc.setParagraphAttributes(offset+2,msg.length() , attr, true);
    	tpMsg.setCaretPosition(offset+2);
    	//Ŀ���� ��ġ�� ���Ͱ� 2����Ʈ ���ؼ� ��ġ��Ŵ

	}
    
    public synchronized void showCacaoStyle(String who,Color bgCr, 
    		Color fgCr, String msg) {
    	JLabel lb=new JLabel(msg);
    	lb.setOpaque(true);//�� ������ ����Ƿ��� �����ϰ�
    	lb.setPreferredSize(new Dimension(700,50)); 
    	//lb�� ���̸� 50���� ��. ���� ���ڿ� ���븸ŭ ������
    	lb.setForeground(fgCr);
    	lb.setBackground(bgCr);
    	
    	if(who.equals("Me")) {
    		//���� �ӼӸ� ���� ���
    		//�����̰� ����� �����ʿ� �� �����ֱ�(�����)
    		att=new SimpleAttributeSet();
    		StyleConstants.setAlignment(att, StyleConstants.ALIGN_RIGHT);
    	}else {
    		//���� �ӼӸ��� ���� ���
    		att=new SimpleAttributeSet();
    		StyleConstants.setAlignment(att, StyleConstants.ALIGN_LEFT);
    	}
    	
    	setStyle(lb,msg,att);	
    }
    
    public synchronized void showCacaoStyle(String chatId, String foRgb,String msg) {
    	
    	String msg2="   "+chatId+">>"+msg+"  \n";
    	JLabel lb=new JLabel(msg2);
    	lb.setOpaque(true);//�� ������ ����Ƿ��� �����ϰ�
    	lb.setPreferredSize(new Dimension(700,50)); 
    	//lb�� ���̸� 40���� ��. ���� ���ڿ� ���븸ŭ ������
    	lb.setForeground(new Color(Integer.parseInt(foRgb)));
    	
    	if(chatId.equals(id)) {
    		//�����̰� ����� �����ʿ� �� �����ֱ�(�����)
    		att=new SimpleAttributeSet();
    		StyleConstants.setAlignment(att, StyleConstants.ALIGN_RIGHT);
    		lb.setBackground(Color.YELLOW);
    	}else {
    		//�����̰� �ٸ��̶�� ���ʿ� �� �����ֱ�(��ũ��)
    		att=new SimpleAttributeSet();
    		StyleConstants.setAlignment(att, StyleConstants.ALIGN_LEFT);
    		lb.setBackground(Color.pink);
    	}
    	setStyle(lb,msg2,att);
    	
    }//-------------------------------

    public synchronized void showEmoticon(String chatId, ImageIcon icon) {
        tpMsg.setCaretPosition(doc.getEndPosition().getOffset() - 1);
        int end = tpMsg.getCaretPosition();

        String msg2 = "[" + chatId + "]��" + "\r\n";
        
        JLabel lb=new JLabel(msg2,icon,JLabel.CENTER);
        
    	//lb.setOpaque(true);
        //�� ������ ����Ƿ��� �����ϰ� true�ش�.
        //�̸�Ƽ�� ���� ���� �������ϰ� false
    	lb.setPreferredSize(new Dimension(700,90)); 
    	//lb�� ���̸� 90���� ��. ���� ���ڿ� ���븸ŭ ������
    	lb.setHorizontalTextPosition(JLabel.CENTER);
    	lb.setVerticalTextPosition(JLabel.BOTTOM);
    	
    	if(chatId.equals(id)) {
    		//�����̰� ����� �����ʿ� �� �����ֱ�(�����)
    		att=new SimpleAttributeSet();
    		StyleConstants.setAlignment(att, StyleConstants.ALIGN_RIGHT);
    		
    	}else {
    		//�����̰� �ٸ��̶�� ���ʿ� �� �����ֱ�(��ũ��)
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