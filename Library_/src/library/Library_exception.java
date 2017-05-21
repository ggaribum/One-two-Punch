package library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Library_exception {

	void isEmptyList(int i)
	{
		if(i!=0)
		{
			Library_printMenu.pressanykey();
		}
		else
		{
			System.out.println("�˻������ �����ϴ�.");
			Library_printMenu.pressanykey();
		}
	}
	int inputNumber(int boundaryNum)
	{
		try{
			int i=new Scanner(System.in).nextInt();
			if(!(0<i && i<boundaryNum+1))

			{
				System.out.println("		�Է� ������ ������ϴ�. �ٽ� �Է��ϼ���");
				Library_printMenu.sleep();
				return 0;

			}
			else return i;
		}catch (InputMismatchException e) {
			System.out.println("		������ �Է��ϼ���.");
			Library_printMenu.sleep();
			return 0;
		}
	}

	String yesORno()
	{	
		String s=new Scanner(System.in).nextLine();
		s=s.toUpperCase();//.charAt(0);
		if(!(s.equals("Y") || s.equals("N")))
		{
			System.out.println("Y / N ���θ� �Է��� �ּ���.");
			return s=null;
		}

		else return s;
	}
	boolean numberBoundary(int num)
	{	
		Integer a=num;
		if(a instanceof Integer){return true;}
		return false;
	}

	boolean PHONEexception(String phoneNum)
	{
		if( (phoneNum.charAt(3)!='-') || (phoneNum.charAt(8)!='-') || (phoneNum.length()!=13) )
		{
			System.out.println("		[�� ȭ �� ȣ]");
			return false;
		}
		return true;
	}
	boolean IDexception(String id)
	{
		if(id.length()<4 || 12<id.length())
		{
			System.out.println("		[�� �� ��]");
			return false;
		}
		return true;
	}
	boolean PWexception(String pw)
	{	
		if(pw.length()<4 || 12<pw.length() )
		{
			System.out.println("		[�� �� �� ȣ]");
			return false ;
		}
		return true;
	}

}
