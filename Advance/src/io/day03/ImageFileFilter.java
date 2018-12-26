package io.day03;

import java.io.*;
/* �̹��� ���ϸ� �ɷ����� ���� Ŭ����(.gif, .jpg, .png)
 * */

public class ImageFileFilter implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		
		name=name.toLowerCase();
		
		// .�� ���������� �� �ε��� ������ �޴´�.
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