package library;

import java.util.Scanner;

public class Library_printMenu {
	public static void baseMenu()
	{
		System.out.println("			�ʱ�ȭ��		");
		System.out.println("		 \"�α���\" �Ǵ� \"���������\" ");
		System.out.println("		1. Sign In	2. Sign Up	3. EXIT");
		System.out.print("		(���ڸ� �Է��Ͻÿ�) :");
	}
	public static void signIn()
	{
		System.out.println("		����������������");
		System.out.println("		�� ��  ��  �� ��");
		System.out.println("		����������������");
		System.out.println("");
	}
	public static void signUp()
	{
		System.out.println("		����������������");
		System.out.println("		��ȸ �� �� �Ԧ�");
		System.out.println("		����������������");
		System.out.println("");
	}
	public static void userMenu()
	{
		System.out.println("		����������������");
		System.out.println("		�� ����ڸ޴� ��");
		System.out.println("		����������������");
		System.out.println("");
		System.out.println("		1. �����˻�");
		System.out.println("		2. ��ü�������");
		System.out.println("		3. �����뿩");
		System.out.println("		4. �����ݳ�");
		System.out.println("		5. ȸ����������");
		System.out.println("		6. �α׾ƿ�");
		System.out.println("		7. ȸ��Ż��");
	}
	
	public static void withdraw()
	{
		System.out.println("		����������������");
		System.out.println("		��ȸ �� Ż ��");
		System.out.println("		����������������");
		System.out.println("");
	}
	public static void searchbook()
	{
		System.out.println("		����������������");
		System.out.println("		���� �� �� ����");
		System.out.println("		����������������");
		System.out.println("");
		System.out.println("		1. å ����");
		System.out.println("		2. å ����");
		System.out.println("		3. ����and����");
		System.out.println("		4. �ڷΰ���");
		System.out.print("		������ ������ ? :");
	}
	
	public static void rentbook()
	{
		System.out.println("		����������������");
		System.out.println("		���� �� �� ����");
		System.out.println("		����������������");
		System.out.println("");
		System.out.println("		1. å ����");
		System.out.println("		2. å ����");
		System.out.println("		3. ����and����");
		System.out.println("		4. �ڷΰ���");
		System.out.print("		������ ������ ? :");
	}
	public static void returnbook()
	{
		System.out.println("		����������������");
		System.out.println("		���� �� �� ����");
		System.out.println("		����������������");
		System.out.println("");
	}
	public static void modifyinfo()
	{
		System.out.println("		������������������");
		System.out.println("		��ȸ������ ������");
		System.out.println("		������������������");
		System.out.println("");
		
	}
	
	
	
	public static void jump()
	{
		for(int i=0; i<30 ; i++)
		{
		System.out.println("");
		}
	}
	public static void pressanykey()
	{
		System.out.println("����� �������Դϴ�. <press [ENTER] key..>");
		new Scanner(System.in).nextLine();
	}
	
	public static void sleep()
	{
		System.out.println("		2�� �� ���� ȭ������ ���ư��ϴ�...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
