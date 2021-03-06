/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseballreservation;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 1class-03
 */
public class AdminPage extends javax.swing.JFrame {
	AdminDAO adminDAO = new AdminDAO();
    /**
     * Creates new form AdminPage
     */
    public AdminPage(Main main) {
        initComponents();
        idx_table();
		pay_table();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_idx = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_pay = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bt_idx_out = new javax.swing.JButton();
        bt_pay_out = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lb_pay_number = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lb_idx = new javax.swing.JLabel();
        lb_play_number = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        table_idx.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "회원번호", "이름", "아이디", "비밀번호", "이메일", "핸드폰", "주소", "가입일"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_idx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                table_idxMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(table_idx);

        table_pay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "회원번호", "결제번호", "티켓번호", "경기번호", "선택좌석", "금액"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_pay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                table_payMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(table_pay);

        jLabel1.setFont(new java.awt.Font("굴림", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("회원 목록");

        jLabel2.setFont(new java.awt.Font("굴림", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("결제 목록");

        bt_idx_out.setText("회원 탈퇴");
        bt_idx_out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_idx_outActionPerformed(evt);
            }
        });

        bt_pay_out.setText("결제취소");
        bt_pay_out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pay_outActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("굴림", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("선택한 회원번호");

        lb_pay_number.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        lb_pay_number.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("굴림", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("선택한 결제번호");

        lb_idx.setFont(new java.awt.Font("굴림", 1, 24)); // NOI18N
        lb_idx.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lb_play_number.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        lb_play_number.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_idx, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_idx_out, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_pay_number, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lb_play_number, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_pay_out, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_pay_out, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_pay_number, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_idx_out, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_idx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_play_number, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_pay_outActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pay_outActionPerformed
        int pay_number = Integer.parseInt(lb_pay_number.getText());
        int[] seat_number = this.getSeat();
        int play_number = Integer.parseInt(lb_play_number.getText());
        
        int cnt = JOptionPane.showConfirmDialog(
    			this, pay_number+"결제를 취소하겠습니까?",
    			"결제취소",JOptionPane.YES_NO_OPTION);
        if(cnt==0) {
        	int n = adminDAO.payAll_delete(pay_number);
            if(n>0) {
            	for(int i=0;i<seat_number.length;i++) {
            		int n1 = adminDAO.ticket_delete(play_number, seat_number[i]);
            		if(n1<0) return;
            	}
            }else if(n<0){
            	showMsg("실패");
            }
            lb_pay_number.setText("");
            lb_play_number.setText("");
            pay_table();
        }else {
        	showMsg("취소하셨습니다.");
        }
    }

    private void bt_idx_outActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_idx_outActionPerformed
    	int row = table_idx.getSelectedRow();
    	String id = (String)table_idx.getValueAt(row, 2);
    	if(id.equals("admin")) {
    		lb_idx.setText("");
    		showMsg("관리자는 탈퇴 불가능");
    		return;
    	}
    	
    	int idx=Integer.parseInt(lb_idx.getText());
    	int cnt = JOptionPane.showConfirmDialog(
    			this, idx+"회원을 탈퇴 시키겠습니까?",
    			"회원탈퇴",JOptionPane.YES_NO_OPTION);
    	if(cnt==0) {
    		int n = adminDAO.idx_delete(idx);
        	String str = (n>0)?idx+"회원탈퇴":"실패";
        	showMsg(str);
        	lb_idx.setText("");
        	idx_table();
    	}else {
    		showMsg("취소하셨습니다.");
    		lb_idx.setText("");
    	}
    	
    }//GEN-LAST:event_bt_idx_outActionPerformed
    
    private void table_idxMousePressed(java.awt.event.MouseEvent evt) {                                       
    	int row = table_idx.getSelectedRow();
    	Object obj = table_idx.getValueAt(row, 0);
    	if (obj instanceof Integer) {
    		int idx = (int) obj;
    		lb_idx.setText(idx+"");
		}else {
			return;
		}
    }  
    
    private void table_payMousePressed(java.awt.event.MouseEvent evt) {                                       
    	int row = table_pay.getSelectedRow();
        Object obj = table_pay.getValueAt(row, 1);
        Object obj2 = table_pay.getValueAt(row, 3);
        if((obj instanceof Integer)&&(obj2 instanceof Integer)) {
        	int pay_number = (int) obj;
        	int play_number = (int) obj2;
        	lb_pay_number.setText(pay_number+"");
        	lb_play_number.setText(play_number+"");
        }else {
        	return;
        }
        
        int[] row1 = table_pay.getSelectedRows();
        seat = new int[row1.length];
        for(int i=0;i<row1.length;i++) {
        	Object obj1 = table_pay.getValueAt(row1[i], 4);
        	seat[i] = (int) obj1;
        }
    } 
    
    private void idx_table() {
    	idxInfo = adminDAO.idx_select();
        
        Object[][] data = new Object[idxInfo.size()][8];
		for (int i = 0; i < idxInfo.size(); i++) {
			data[i][0] = idxInfo.get(i).getIdx_pk();
			data[i][1] = idxInfo.get(i).getName();
			data[i][2] = idxInfo.get(i).getId();
			data[i][3] = idxInfo.get(i).getPwd();
			data[i][4] = idxInfo.get(i).getEmail();
			data[i][5] = idxInfo.get(i).getPh();
			data[i][6] = idxInfo.get(i).getAddr();
			data[i][7] = idxInfo.get(i).getIndate();
		}
		
		String[] colNames = {"회원번호", "이름", "아이디", "비밀번호",
				"이메일", "핸드폰", "주소", "가입일"};
		table_idx.setModel(new DefaultTableModel(data, colNames) {
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false, false, false, false};

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
    }
    
    private void pay_table() {
    	payInfo = adminDAO.pay_select();
		
		Object[][] data1 = new Object[payInfo.size()][6];
		for (int i = 0; i < payInfo.size(); i++) {
			data1[i][0] = payInfo.get(i).getIdx_fk();
			data1[i][1] = payInfo.get(i).getPay_number_fk();
			data1[i][2] = payInfo.get(i).getTicket_number_fk();
			data1[i][3] = payInfo.get(i).getPlay_number_fk1();
			data1[i][4] = payInfo.get(i).getSeat_number_fk1();
			data1[i][5] = payInfo.get(i).getSeat_price_fk1();
		}
		
		String[] colNames1 = {"회원번호", "결제번호", "티켓번호",
				"경기번호", "선택좌석", "금액"};
		table_pay.setModel(new DefaultTableModel(data1, colNames1) {
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false, false};

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
    }
    
    private void showMsg(String str) {
    	JOptionPane.showMessageDialog(this, str);
    }

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
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new AdminPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_idx_out;
    private javax.swing.JButton bt_pay_out;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_idx;
    private javax.swing.JLabel lb_pay_number;
    private javax.swing.JLabel lb_play_number;
    private javax.swing.JTable table_idx;
    private javax.swing.JTable table_pay;
    private ArrayList<ManagerVO> idxInfo;
    private ArrayList<AdminVO> payInfo;
    private int[] seat;
	public int[] getSeat() {
		return seat;
	}
}
