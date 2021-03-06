/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc_memo;

import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
/**
 *
 * @author 1class-18
 */
public class MemoGui extends javax.swing.JFrame {
	MemoDAO mdao = new MemoDAO();
	String colName="name"; 
	// 글검색시 작성자로 검색하면=>"name" 메모내용=>"msg"
    /**
     * Creates new form MemoGui
     */
    public MemoGui() {
        initComponents();
        Date today = new Date();
        SimpleDateFormat sdf 
        	= new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String strToday = sdf.format(today);
        lbWdate.setText(strToday);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tabP = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        tfName = new javax.swing.JTextField();
        tfMsg = new javax.swing.JTextField();
        lbIdx = new javax.swing.JLabel();
        lbWdate = new javax.swing.JLabel();
        btInsert = new javax.swing.JButton();
        btList = new javax.swing.JButton();
        btDel = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btEditEnd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        combo = new javax.swing.JComboBox<>();
        tfSearch = new javax.swing.JTextField();
        btFind = new javax.swing.JButton();
        btAll = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("::한줄 메모장::");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon1.png"))); // NOI18N
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("♥한줄 메모장♥");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon2.png"))); // NOI18N
        jLabel3.setToolTipText("");

        jPanel3.setBackground(new java.awt.Color(255, 255, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153), 2));

        tfName.setBackground(new java.awt.Color(255, 255, 0));
        tfName.setBorder(javax.swing.BorderFactory.createTitledBorder("::작성자::"));

        tfMsg.setBackground(new java.awt.Color(255, 255, 0));
        tfMsg.setBorder(javax.swing.BorderFactory.createTitledBorder("::메모내용::"));
        tfMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMsgActionPerformed(evt);
            }
        });

        lbIdx.setText("^^");

        lbWdate.setFont(new java.awt.Font("맑은 고딕", 1, 16)); // NOI18N
        lbWdate.setForeground(new java.awt.Color(255, 0, 51));
        lbWdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbWdate.setText("2018-10-29");

        btInsert.setBackground(new java.awt.Color(255, 102, 102));
        btInsert.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        btInsert.setForeground(new java.awt.Color(255, 255, 255));
        btInsert.setMnemonic('I');
        btInsert.setText("글쓰기");
        btInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInsertActionPerformed(evt);
            }
        });

        btList.setBackground(new java.awt.Color(204, 0, 204));
        btList.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        btList.setForeground(new java.awt.Color(255, 255, 255));
        btList.setMnemonic('L');
        btList.setText("글목록");
        btList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListActionPerformed(evt);
            }
        });

        btDel.setBackground(new java.awt.Color(255, 51, 0));
        btDel.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        btDel.setForeground(new java.awt.Color(255, 255, 255));
        btDel.setMnemonic('D');
        btDel.setText("글삭제");
        btDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDelActionPerformed(evt);
            }
        });

        btEdit.setBackground(new java.awt.Color(51, 51, 255));
        btEdit.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        btEdit.setForeground(new java.awt.Color(255, 255, 255));
        btEdit.setMnemonic('E');
        btEdit.setText("글수정");
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        btEditEnd.setBackground(new java.awt.Color(255, 153, 204));
        btEditEnd.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        btEditEnd.setForeground(new java.awt.Color(255, 255, 255));
        btEditEnd.setMnemonic('U');
        btEditEnd.setText("글수정처리");
        btEditEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditEndActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfMsg)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbIdx, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbWdate, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(btInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEditEnd)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btDel, btEdit, btEditEnd, btInsert, btList});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfName, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(lbIdx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbWdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(tfMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btInsert, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btList, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btDel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btEdit)
                        .addComponent(btEditEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tfMsg, tfName});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btDel, btEdit, btEditEnd, btInsert, btList});

        ta.setColumns(20);
        ta.setRows(5);
        ta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 2));
        jScrollPane1.setViewportView(ta);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabP.addTab("메인등록", jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "작성자", "글내용" }));
        combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboItemStateChanged(evt);
            }
        });
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        tfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchActionPerformed(evt);
            }
        });

        btFind.setMnemonic('F');
        btFind.setText("글검색");
        btFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFindActionPerformed(evt);
            }
        });

        btAll.setMnemonic('A');
        btAll.setText("전체글");
        btAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btFind)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAll)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(combo))
                    .addComponent(btFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(table);
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tabP.addTab("메모검색", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(tabP, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabP, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMsgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMsgActionPerformed
    
    public void showMsg(String str) {
    	JOptionPane.showMessageDialog(this,str);
    }

    private void btInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInsertActionPerformed
        String name = tfName.getText();
        String msg = tfMsg.getText();
    	
        if((name==null||name.trim().equals(""))||
        	(msg==null||msg.trim().equals(""))) {
        		showMsg("작성자와 메모내용을 모두 입력하세요");
        		tfName.requestFocus();
        		return;
        }else {
        	
            MemoVO mvo = new MemoVO();
            
            mvo.setName(name);
            mvo.setMsg(msg);
        	
        	int n = mdao.insertMemo(mvo);
        	//setTitle(n+"");
        	String str=(n>0)?"메모 등록성공":"등록 실패";
        	showMsg(str);
        	clearTf();
        	allMemoTa(); // 모든 메모 목록 가져오기
        }
    }

    private void clearTf() {
		tfName.setText("");
		tfMsg.setText("");
		tfName.requestFocus();
	}

	private void btListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListActionPerformed
        allMemoTa();
    }
	
	public void allMemoTa() {
		ArrayList<MemoVO> arr = mdao.listMemo();
        if(arr==null) {
        	showMsg("프로그램 오류 발생");
        	return;
        }
		if(arr.size()==0) {
			ta.setText("데이터가 없습니다");
			return;
		}
		
		String str = "\t===================================================\n"
				+ "\t글번호\t작성일\t메모내용\t작성자\n"
				+ "\t===================================================\n";
		
		for(MemoVO m:arr) {
			int idx = m.getIdx();
			String name = m.getName();
			String msg = m.getMsg();
			Date wdate = m.getWdate();
			str+="\t"+idx+"\t"+name+"\t"+wdate+"\t"+msg+"\n";
		}
		
		str += "\t===================================================\n";
		ta.setText(str);
	}

    private void btDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDelActionPerformed
        String idx = JOptionPane.showInputDialog(
        		"삭제할 글 번호를 입력하세요");
        if(idx.trim().isEmpty()||idx==null) {
        	showMsg("입력한 글번호가 없습니다.");
        	return;
        }
        
        MemoVO mvo = new MemoVO();
        mvo.setIdx(Integer.parseInt(idx));
        
        int n = mdao.deleteMemo(mvo);
        String str=(n>0)?"메모 삭제성공":"삭제 실패";
    	showMsg(str);
    	if(n>0) allMemoTa();
    }

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
    	String idx = JOptionPane.showInputDialog(
        		"수정할 글 번호를 입력하세요");
    	
    	if(idx.trim().isEmpty()||idx==null) {
        	showMsg("입력한 글번호가 없습니다.");
        	return;
        }
    	
    	MemoVO mvo = mdao.selectMemo(Integer.parseInt(idx));
    	mvo.setIdx(Integer.parseInt(idx));
    	if(mvo==null) {
    		showMsg("해당 글은 존재하지 않아요");
    		return;
    	}
    	
    	lbIdx.setText("글번호: "+idx);
    	tfName.setText(mvo.getName());
    	tfMsg.setText(mvo.getMsg());
    	lbWdate.setText(mvo.getWdate().toString());
    }

    private void btEditEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditEndActionPerformed
    	MemoVO mvo = new MemoVO();
    	
    	if(tfName.getText().trim().isEmpty()||tfName.getText()==null) {
    		showMsg("이름이 입력되지 않았습니다.");
        	return;
    	}
    	/* substring(int start, int end) => start에서 end직전까지
    	 *  문자열을 잘라내어 반환한다.*/
    	mvo.setIdx(Integer.parseInt(lbIdx.getText().substring(5)));
    	mvo.setName(tfName.getText());
    	mvo.setMsg(tfMsg.getText());
    	int n = mdao.updateMemo(mvo);
    	tfName.setText("");
    	tfMsg.setText("");
    	String str=(n>0)?"메모 수정성공":"수정 실패";
    	showMsg(str);
    	
    	if(n>0) allMemoTa();
    }

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
    	
    }

    private void comboItemStateChanged(java.awt.event.ItemEvent e) {//GEN-FIRST:event_comboItemStateChanged
    	int mode = e.getStateChange();
    	if(mode==ItemEvent.SELECTED) {
    		int index = combo.getSelectedIndex();
    		if(index==0) {
    			colName = "name";
    		}else if(index==1) {
    			colName = "msg";
    		}
    	}
    }
    
    public void findMemo() {
    	String keyword = tfSearch.getText();
    	if(keyword==null||keyword.trim().isEmpty()) {
    		showMsg("검색어를 입력하세요.");
    		tfSearch.requestFocus();
    		return;
    	}
    	ArrayList<MemoVO> arr = mdao.findMemo(colName,keyword);
    	//JTable에 가져온 검색데이터를 출력해주는 메소드
    	showTable(arr);
    }
    
    private void showTable(ArrayList<MemoVO> arr) {
    	String[] colNames= {"글번호", "작성자", "작성일", "메모 내용"};
    	Object[][] data=new Object[arr.size()][colNames.length];
    	for(int i=0;i<arr.size();i++) {
    
    		data[i][0]=arr.get(i).getIdx();
    		data[i][1]=arr.get(i).getName();
    		data[i][2]=arr.get(i).getWdate();
    		data[i][3]=arr.get(i).getMsg();
    	}
    	
    	table.setModel(new DefaultTableModel(data, colNames) {
			boolean[] canEdit = 
					new boolean[] { false, true, true, true };

			public boolean isCellEditable(
					int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
    	setTableUi();
	}
    
    public void setTableUi() {
    	table.setRowHeight(25);
        JTableHeader header = table.getTableHeader();
        header.getColumnModel().getColumn(0).setPreferredWidth(50);
        header.getColumnModel().getColumn(3).setPreferredWidth(350);
    }
    
	private void tfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchActionPerformed
        findMemo();
    }

    private void btFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFindActionPerformed
    	findMemo();
    }

    private void btAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAllActionPerformed
    	ArrayList<MemoVO> arr = mdao.listMemo();
        if(arr==null) {
        	showMsg("프로그램 오류 발생");
        	return;
        }
		if(arr.size()==0) {
			showMsg("데이터가 없습니다");
			return;
		}
		showTable(arr);
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
            java.util.logging.Logger.getLogger(MemoGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemoGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemoGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemoGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemoGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAll;
    private javax.swing.JButton btDel;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btEditEnd;
    private javax.swing.JButton btFind;
    private javax.swing.JButton btInsert;
    private javax.swing.JButton btList;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbIdx;
    private javax.swing.JLabel lbWdate;
    private javax.swing.JTextArea ta;
    private javax.swing.JTabbedPane tabP;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfMsg;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
