package io.day02;

import java.io.Serializable;

/* java.io.Serializable 인터페이스를 상속받으면 직렬화 객체로 사용할 수 있다.
 * 객체를 파일이나 네트워크로 전송하려면 반드시 java.io.Serializable 인터페이스를
 * 상속받아 구현해야 한다.
 * #직렬화(Serializable)란?
 * - 데이터를 한 줄로 나열할 수 있다고 표시하는 것을 의미
 *   이는 스트림을 통해 데이터를 전송할 수 있다는 의미다.
 * - 단순히 Serializable인터페이스를 상속받으면 직렬화가 되는데, 
 *   이 인터페이스에는 추상메소드가 존재 하지 않으며, 
 *   단순히 직렬화된 객체로 마킹(marking) 하는 기능만 한다.
 *   <cf> 직렬화된 객체를 복원하는 것을 역직렬화라고 한다. 
 * */
public class Emp implements Serializable{
	private String name;
	private int sal;
	private int deptno;
	
	public Emp() {
		
	}
	
	public Emp(String name, int sal, int deptno) {
		this.name = name;
		this.sal = sal;
		this.deptno = deptno;
	}
	
	public void print() {
		System.out.println("---Record for Emp---");
		System.out.println("Name  : "+name);
		System.out.println("sal   : "+sal);
		System.out.println("deptno: "+deptno);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
}