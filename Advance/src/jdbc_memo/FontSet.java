package jdbc_memo;

import java.awt.Color;
import java.awt.Font;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class FontSet{
	
	private String name;
	private int style;
	private int size;
	private Color color;
	
	public FontSet() {
		name = "sans-serif";
		style = Font.PLAIN;
		size = 12;
		color = Color.black;
	}
	
	public SimpleAttributeSet att() {
		SimpleAttributeSet attr = new SimpleAttributeSet();
		StyleConstants.setFontFamily(attr, getName());
		StyleConstants.setForeground(attr, getColor());
		StyleConstants.setFontSize(attr, getSize());
		return attr;
	}
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStyle() {
		return style;
	}

	public void setStyle(int style) {
		this.style = style;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
