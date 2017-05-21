package library;
/*
 	1.예외처리 
 	-> 각 입력마다
 	-> 공통되는 예외는 메서드로
 	-> **회원정보 수정시 예외처리
 	-> 회원가입,숫자만입력, 문자만입력, 한글입력시 자꾸동작멈추는거.
 	2.메서드화
 	-> **userMenu파트
 	3.디자인
 	-> 초기메뉴부분
 	-> 입력할 때 println으로 할지 print로 할지 확인.
 	4.좀 더 클래스화시키고, 각 클래스별 특징 명확히 구분.

 	+회원탈퇴시 파일 삭제하는법 *****
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
