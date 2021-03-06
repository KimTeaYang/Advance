/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc_memo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 1class-18
 */
public class MySQLDev extends javax.swing.JFrame {
	MySQLDao mdao = new MySQLDao();
	boolean isCon = false;
    /**
     * Creates new form MySQLDev
     */
    public MySQLDev() {
    	super("::MySQLDev::");
        initComponents();
        ta.setFont(new Font("serif",Font.BOLD,22));
        addWindowListener(new WindowAdapter() {
        	public void winddowClosing(WindowEvent e) {
        		mdao.close();
        		System.out.println("DB자원 반납됨");
        		System.exit(0);
        	}
		});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tfHost = new javax.swing.JTextField();
        tfSid = new javax.swing.JTextField();
        tfUser = new javax.swing.JTextField();
        tfPwd = new javax.swing.JPasswordField();
        btCon = new javax.swing.JButton();
        btReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        lb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tfHost.setText("localhost:1521");
        tfHost.setBorder(javax.swing.BorderFactory.createTitledBorder("호스트명:포트"));
        tfHost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfHostActionPerformed(evt);
            }
        });

        tfSid.setText("XE");
        tfSid.setBorder(javax.swing.BorderFactory.createTitledBorder("SID"));

        tfUser.setText("scott");
        tfUser.setBorder(javax.swing.BorderFactory.createTitledBorder("사용자명"));

        tfPwd.setText("tiger");
        tfPwd.setBorder(javax.swing.BorderFactory.createTitledBorder("비밀번호"));

        btCon.setMnemonic('C');
        btCon.setText("연결");
        btCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConActionPerformed(evt);
            }
        });

        btReset.setMnemonic('R');
        btReset.setText("Reset");
        btReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfHost, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btCon, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btReset, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfHost, tfPwd, tfSid, tfUser});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCon)
                    .addComponent(btReset))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfHost, tfPwd, tfSid, tfUser});

        ta.setColumns(20);
        ta.setRows(5);
        ta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 51), 3));
        ta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                taKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(ta);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(table);

        lb.setText("결과: ");
        lb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfHostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfHostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfHostActionPerformed
    
    private void btConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConActionPerformed
        String host = tfHost.getText();
        String sid = tfSid.getText();
        String user = tfUser.getText();
        char[] ch = tfPwd.getPassword();
        String pwd = new String(ch);
        
        if(host==null||host.trim().isEmpty()||
        		sid==null||sid.trim().isEmpty()||
        				user==null||user.trim().isEmpty()||
        						pwd==null||pwd.trim().isEmpty()) {
        	showMsg("입력한 값이 없습니다.");
        	return;
        }
    	
    	mdao.setUrl("jdbc:oracle:thin:@"+host+":"+sid);
    	mdao.setUser(user);
    	mdao.setPwd(pwd);
    	
    	try {
			boolean is = mdao.dbConnect();
			isCon = is;
			if(is) lb.setText("DB연결됨: "+is);
		} catch (SQLException e) {
			lb.setForeground(Color.RED);
			lb.setText("연결실패: "+e);
		}
    }
    
    public void showMsg(String msg) {
    	JOptionPane.showMessageDialog(this, msg);
    }

    private void btResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResetActionPerformed
        tfHost.setText("");
        tfUser.setText("");
        tfSid.setText("");
        tfPwd.setText("");
        lb.setText("");
    }

    private void taKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taKeyReleased
        int mode = evt.getModifiers();
        int code = evt.getKeyCode();
        try {
	        // Ctrl+Enter키를 눌렀다 떼었을 때
	        if(mode==KeyEvent.CTRL_MASK && code==KeyEvent.VK_ENTER){
	        	if(!isCon) {
	        		showMsg("DB에 먼저 연결해야 해요!!");
	        		return;
	        	}
	            String sql = ta.getText();
	            if(sql.trim().isEmpty()) return;
	            
	            int index = sql.indexOf(";");
	            if(index>0) {
	            	sql=sql.substring(0, index);
	            }
	            
	            Object obj = mdao.execute(sql);
	            if(obj instanceof Integer) {
	            	lb.setText(obj.toString()+"개의 레코드가 변경됨");
	            }else {
	            	//ResultSet인 경우=>SELECT문에 의해 가져오는 
	            	//컬럼정보(컬럼명)를 배열로 받아오자.
	            	String[] colNames
	            		= mdao.getColumInfo((ResultSet)obj);
	            	
	            	////////////// 내 방식대로 한 경우
	            	Object[][] data
	            		= mdao.getInfo((ResultSet)obj);
	            	
	            	DefaultTableModel model = new DefaultTableModel();
	            	model.setDataVector(data, colNames);
	            	
	            	((ResultSet)obj).close();
	            	///////////////
	            	
	            	/* 강사님 방식으로 한 경우
	            	model.setColumnIdentifiers(colNames);
	            	
	            	ResultSet rs = (ResultSet)obj;
	            	ResultSetMetaData rsmd = rs.getMetaData();
	            	int colCount = rsmd.getColumnCount();
	            	while(rs.next()) {
	            		String[] row = new String[colCount];
	            		for(int i=1;i<colCount;i++) {
	            			String data=rs.getString(i);
	            			System.out.println(data);
	            			row[i-1] = data;
	            		}
	            		model.addRow(row);
	            		System.out.println("-----------");
	            	}
	            	rs.close();
	            	*/
	            	table.setModel(model);
	            }
				
	        }
        } catch(SQLException e) {
        	lb.setForeground(Color.red);
        	lb.setText("Error: "+e);
        	e.printStackTrace();
        }
    }//GEN-LAST:event_taKeyReleased

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
            java.util.logging.Logger.getLogger(MySQLDev.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MySQLDev.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MySQLDev.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MySQLDev.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MySQLDev().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCon;
    private javax.swing.JButton btReset;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb;
    private javax.swing.JTextArea ta;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfHost;
    private javax.swing.JPasswordField tfPwd;
    private javax.swing.JTextField tfSid;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables
}
