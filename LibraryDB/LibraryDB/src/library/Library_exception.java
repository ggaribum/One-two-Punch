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
			System.out.println("검색결과가 없습니다.");
			Library_printMenu.pressanykey();
		}
	}
	int inputNumber(int boundaryNum)
	{
		try{
			int i=new Scanner(System.in).nextInt();
			if(!(0<i && i<boundaryNum+1))

			{
				System.out.println("		입력 범위를 벗어났습니다. 다시 입력하세요");
				Library_printMenu.sleep();
				return 0;

			}
			else return i;
		}catch (InputMismatchException e) {
			System.out.println("		정수만 입력하세요.");
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
			System.out.println("Y / N 으로만 입력해 주세요.");
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
			System.out.println("		[전 화 번 호]");
			return false;
		}
		return true;
	}
	boolean IDexception(String id)
	{
		if(id.length()<4 || 12<id.length())
		{
			System.out.println("		[아 이 디]");
			return false;
		}
		return true;
	}
	boolean PWexception(String pw)
	{	
		if(pw.length()<4 || 12<pw.length() )
		{
			System.out.println("		[비 밀 번 호]");
			return false ;
		}
		return true;
	}

}
