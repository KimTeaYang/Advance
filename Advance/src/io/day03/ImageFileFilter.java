package io.day03;

import java.io.*;
/* 이미지 파일만 걸러내는 필터 클래스(.gif, .jpg, .png)
 * */

public class ImageFileFilter implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		
		name=name.toLowerCase();
		
		// .가 마지막으로 들어간 인덱스 정보를 받는다.
		int index = name.lastIndexOf(".");
		
		if(index>0) {
			String ext = name.substring(index);
			if(ext.equals(".gif")||ext.equals(".jpg")
					||ext.equals(".png")) {
				return true;
			}
		}
		
		return false;
	}
}