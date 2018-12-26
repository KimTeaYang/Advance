package io.day03;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
/* public long length() : 파일크기
 * public String getName() : 파일명
 * public String getAbsolutePath() : 절대경로
 * public String getPath() : 상대경로
 * */

public class FileTest {

	public static void print(String str) {
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		String str="src/images/골프공.png";
		File file = new File(str);
		
		print("파일명: "+file.getName());
		print("파일크기: "+file.length());
		print("절대경로: "+file.getAbsolutePath());
		print ("상대경로: "+file.getPath());
		
		File dir = new File("sample","example");
		boolean b = dir.exists();
		if(!b) {
			boolean c = dir.mkdirs();
			print("디렉토리 생성여부: "+c);
		}
		
		File dir2 = new File("study");
		if(!dir2.exists()) {
			dir2.mkdir();
		}
		
		
		System.out.println(dir2.renameTo(new File("simple")));
		System.out.println(dir2.delete());
		
		boolean isFile = file.isFile();
		print("파일 여부: "+isFile);
		print("DIR 여부: "+file.isDirectory()	);
		
		//파일이 마지막으로 수정된 날짜
		long time = file.lastModified();
		print("파일의 마지막 수정일: "+time);
		/* 1970년 1월1일부터 마지막으로 수정된 날짜까지의 시간을 밀리세컨드 초로
		 * 반환함 */
		
		Date d = new Date(time);
		print(d.toString());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		System.out.println(sdf.format(d));
	}

}