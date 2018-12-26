package io.day01;

import java.io.*;
import javax.swing.*;
/* FileInputStream
 *  - 1byte 기반 스트림
 *  - Node Stream : 파일과 노드 연결을 한다.
 *  - 파일을 읽어들이는 스트림
 *  
 *  [실습] InputStreamTest.java 파일을 읽어서 도스 콘솔에 출력해보자.
 *   단, 배열에 담아서 읽어들이고 내보내세요.
 *   
 *   데이터 소스   : 파일 (FileInputStream)
 *   데이터 목적지 : 콘솔 (System.out)
 * */

public class FileInStream2 {

	public static void main(String[] args) {
		String file 
			= JOptionPane.showInputDialog(
					"읽을 파일명을 입력하세요",
					"./src/io/day01/InputStreamTest.java");
		// Advance 프로젝트 => 기준경로
		
		try {
			//파일과 노드 연결
			FileInputStream fis = new FileInputStream(file);
			PrintStream ps = System.out; // 콘솔과 노드연결
			byte[] data = new byte[400];
			int n=0, total=0;
			while((n=fis.read(data))!=-1) {
				//파일의 끝을 만나면 -1을 반환한다.
				ps.write(data,0,n);
				total+=n;
			}
			ps.println("총 "+total+"byte");
			
			fis.close();
			ps.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}