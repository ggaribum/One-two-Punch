package library;
/*
 	1.����ó�� 
 	-> �� �Է¸���
 	-> ����Ǵ� ���ܴ� �޼����
 	-> **ȸ������ ������ ����ó��
 	-> ȸ������,���ڸ��Է�, ���ڸ��Է�, �ѱ��Է½� �ڲٵ��۸��ߴ°�.
 	2.�޼���ȭ
 	-> **userMenu��Ʈ
 	3.������
 	-> �ʱ�޴��κ�
 	-> �Է��� �� println���� ���� print�� ���� Ȯ��.
 	4.�� �� Ŭ����ȭ��Ű��, �� Ŭ������ Ư¡ ��Ȯ�� ����.

 	+ȸ��Ż��� ���� �����ϴ¹� *****
 */
import java.util.Scanner;


public class Library_main {
	final static int ONE =1;
	final static int TWO =2;
	final static int THREE =3;

	public static void main(String[] args) {

		Library_exception exceptionManager= new Library_exception();
		Library_ManageMember obj = new Library_ManageMember();
		Scanner sc= new Scanner(System.in);
		int selectNum=0;

		while(true)
		{
			Library_printMenu.jump();
			Library_printMenu.baseMenu();

			selectNum=exceptionManager.inputNumber(3);
			
			switch(selectNum)
			{
			case 0 : continue;
			case ONE: obj.signIn();break;
			case TWO: obj.signUp();break;
			case THREE:return;
			}

		}

	}

}
