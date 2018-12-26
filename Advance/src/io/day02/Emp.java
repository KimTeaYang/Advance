package io.day02;

import java.io.Serializable;

/* java.io.Serializable �������̽��� ��ӹ����� ����ȭ ��ü�� ����� �� �ִ�.
 * ��ü�� �����̳� ��Ʈ��ũ�� �����Ϸ��� �ݵ�� java.io.Serializable �������̽���
 * ��ӹ޾� �����ؾ� �Ѵ�.
 * #����ȭ(Serializable)��?
 * - �����͸� �� �ٷ� ������ �� �ִٰ� ǥ���ϴ� ���� �ǹ�
 *   �̴� ��Ʈ���� ���� �����͸� ������ �� �ִٴ� �ǹ̴�.
 * - �ܼ��� Serializable�������̽��� ��ӹ����� ����ȭ�� �Ǵµ�, 
 *   �� �������̽����� �߻�޼ҵ尡 ���� ���� ������, 
 *   �ܼ��� ����ȭ�� ��ü�� ��ŷ(marking) �ϴ� ��ɸ� �Ѵ�.
 *   <cf> ����ȭ�� ��ü�� �����ϴ� ���� ������ȭ��� �Ѵ�. 
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