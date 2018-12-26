package io.day03;

import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest2 {

	public static void main(String[] args) {
		/* c:/myjava 디렉토리에 있는 파일(또는 dir) 목록을 가져와 출력하세요
		 * */
		File file = new File("C:/myjava");
		
		String[] files = file.list();
		if(files!=null) {
			for(String s:files) {
				System.out.println(s);
			}
		}
		
		System.out.println("----------------------");
		
		File[] files2 = file.listFiles();
		Date d = null;
		SimpleDateFormat sdf = null;
		if(files2!=null) {
			for(File f:files2) {
				String str = f.isDirectory()?"<DIR>":"<File>";
				d = new Date(f.lastModified());
				sdf = new SimpleDateFormat("yyyy-MM-dd");
				System.out.println(f.getName()+"\t"+str+"\t"+sdf.format(d));
			}
		}
		
		System.out.println("----------------------");
		ImageFileFilter filter = new ImageFileFilter();
		
		File[] files3 = file.listFiles(filter);
		
		if(files3!=null) {
			for(File f:files3) {
				System.out.println(f.getName()+" ["
						+f.length()+"bytes]");
			}
		}
	}
}