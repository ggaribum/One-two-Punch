package library;
import java.sql.ResultSet;
/*
 1.Ŭ������ ��Ű��ȭ
 2."�뿩����" - > ��Ʈ�������� ���� �����ϴ½�����
 3.UIŬ���� ���� �⺻ �޼��� ���� ����
 4.��̸���Ʈ �����ʰ� �ٷιٷ� ������ ���̽� ����
  ������� �����ذ��ϴ� �ڵ� �ۼ��غ���
 5.ȸ�����Խ� 3ȸ�̻� ���̵� �ߺ��ɶ� ����.
 
 **����**LibraryDB.DB_CheckMEMBER2(String id) �� �޼���κ�.
 */
import java.util.Scanner;


public class Library_main {
	final static int SIGNIN =1;
	final static int SIGNUP =2;
	final static int EXIT =3;

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
			case SIGNIN: obj.signIn();break;
			case SIGNUP: obj.signUp();break;
			case EXIT:return;
			}

		}

	}

}
