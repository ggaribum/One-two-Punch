package library;
import java.sql.ResultSet;
/*
 1.클래스를 패키지화
 2."대여가능" - > 스트링변수로 만들어서 저장하는식으로
 3.UI클래스 만들어서 기본 메서드 따로 정리
 4.어레이리스트 담지않고도 바로바로 데이터 베이스 접근
  방법으로 문제해결하는 코드 작성해보기
 5.회원가입시 3회이상 아이디 중복될때 종료.
 
 **질문**LibraryDB.DB_CheckMEMBER2(String id) 이 메서드부분.
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
