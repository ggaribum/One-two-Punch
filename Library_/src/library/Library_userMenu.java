package library;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
//import java.util.InputMismatchException;
import java.util.Scanner;

public class Library_userMenu {

	Library_exception exceptionManger = new Library_exception();
	Library_fileManager fileManager = new Library_fileManager();

	Scanner sc= new Scanner(System.in);
	ArrayList<Library_book>bookList= new ArrayList<Library_book>();
	Library_book bookTEMP;

	final static int searchBOOK=1;
	final static int printAllBOOK=2;
	final static int rentBOOK=3;
	final static int returnBOOK=4;
	final static int modifyINFO=5;
	final static int logOUT=6;
	final static int withdrawMEMBER=7;

	private String userInfo[];
	int select;

	public Library_userMenu() {}
	public Library_userMenu(String info[]) 
	{ 
		bookList=fileManager.fileInBook();
		this.userInfo=info;
		run_UserMenu(); 
	}


	void run_UserMenu()
	{
		while(true)
		{
			Library_printMenu.jump();
			System.out.println("							"+userInfo[0]+" 님 반갑습니다.");
			Library_printMenu.userMenu();
			System.out.println("");
			System.out.print("		메뉴선택 : ");

			select=exceptionManger.inputNumber(7);
			switch(select)
			{
			case searchBOOK: searchBook();    break;
			case printAllBOOK: printAllBook();break;
			case rentBOOK:	rentBook();       break;
			case returnBOOK: returnBook();    break;
			case modifyINFO:modifyInfo();     break;
			case logOUT:
			{
				System.out.print("		로그아웃 하시겠습니까 ? [y/n] : " );
				String s=exceptionManger.yesORno();
				if(s.equals("Y"))			{return;}
				else if(s.equals("N"))		{break;}
				else {Library_printMenu.sleep();break;}
			}
			case withdrawMEMBER: if(withdrawMember()==1){return ;} else break;
			}
		}
	}

	void searchBook()
	{
		select=0;
		Library_printMenu.jump();
		Library_printMenu.searchbook();
		select=exceptionManger.inputNumber(4);

		switch(select)
		{
		case 1:
		{
			System.out.print("		책 제목을 입력하세요 :");
			String s= sc.nextLine();

			exceptionManger.isEmptyList(bookSearch(s, select));
			break;
		}
		case 2:
		{
			System.out.print("		책 저자를 입력하세요 :");
			String s= sc.nextLine();

			exceptionManger.isEmptyList(bookSearch(s, select));
			break;
		}
		case 3:
			System.out.print("		책 제목 또는 저자를 입력하세요 :");
			String s= sc.nextLine();

			exceptionManger.isEmptyList(bookSearch(s, select));
			break;

		case 4: break;
		}
	}

	void printAllBook()
	{
		Library_printMenu.jump();
		Iterator<Library_book>ite = bookList.iterator();
		while(ite.hasNext())
		{
			Library_book list_iter=ite.next();
			System.out.println("-----------------------------------");
			System.out.println("책 제목 : "+list_iter.name+" 저자 : "+list_iter.author);
			System.out.println("책 가격 : "+list_iter.price+" 페이지 수 : "+list_iter.page
					+" 상태 : "+list_iter.state+"");
			System.out.println("-----------------------------------");
		}
		Library_printMenu.pressanykey();

	}
	void rentBook()
	{
		select=0;
		Library_printMenu.jump();
		Library_printMenu.rentbook();
		select=sc.nextInt();
		sc.nextLine();

		switch(select)
		{
		case 1:
		{
			System.out.print("		책 제목을 입력하세요 :");
			String s= sc.nextLine();

			if(bookSearch(s,select)!=0)
			{	
				System.out.print("목록의 마지막입니다. 대여할 도서 index 입력 :");
				select=sc.nextInt();
				if(bookList.get(select).name.contains(s))
				{
					bookRent_valid(select);
					Library_printMenu.sleep();
				}

				else
				{
					System.out.println("잘못된 인덱스입니다.");
					Library_printMenu.sleep();
				}
				break;
			}
			else
			{
				System.out.println("-----------------------------------");
				System.out.println("검색결과가 없습니다.");
				Library_printMenu.pressanykey();
				//break;

			}
			break;
		}

		case 2:
		{
			System.out.print("		책 저자를 입력하세요 :");
			String s= sc.nextLine();

			if(bookSearch(s,select)!=0)
			{
				System.out.print("목록의 마지막입니다. 대여할 도서 index 입력 :");
				select=sc.nextInt();
				if(bookList.get(select).author.contains(s))
				{
					bookRent_valid(select);
					Library_printMenu.sleep();
				}

				else
				{
					System.out.println("잘못된 인덱스입니다.");
					Library_printMenu.sleep();
				}
				break;
			}
			else

			{
				System.out.println("-----------------------------------");
				System.out.println("검색결과가 없습니다.");
				Library_printMenu.pressanykey();
			}
			break;
		}
		case 3:
		{
			System.out.print("		책 제목 또는 저자를 입력하세요 :");
			String s= sc.nextLine();

			if(bookSearch(s,select)!=0)
			{
				System.out.print("목록의 마지막입니다. 대여할 도서 index 입력 :");
				select=sc.nextInt();
				if(bookList.get(select).name.contains(s) || bookList.get(select).author.contains(s))
				{
					bookRent_valid(select);
					Library_printMenu.sleep();
				}

				else
				{
					System.out.println("잘못된 인덱스입니다.");
					Library_printMenu.sleep();
				}
				break;
			}
			else
			{
				System.out.println("-----------------------------------");
				System.out.println("검색결과가 없습니다.");
				Library_printMenu.pressanykey();
			}
			break;
		}
		case 4: break;
		}
	}

	void returnBook()
	{
		Library_printMenu.jump();
		Library_printMenu.returnbook();
		String s="";
		int i=0;
		if(bookReturn()!=0)
		{
			System.out.print("목록의 마지막입니다. 반납할 도서 index 입력: ");
			i=sc.nextInt();
			sc.nextLine();
			if(bookList.get(i).host.equals(userInfo[0]))
			{
				while(true)
				{
					System.out.print("반납하실려면 [y], 취소하실려면[n] 입력하세요: ");
					s=exceptionManger.yesORno();
					if(s.equals("Y"))
					{
						System.out.println("반납이 완료됬습니다.");
						bookList.get(i).state="대여가능";
						bookList.get(i).host="도서관";
						bookList.get(i).due_date="0";
						fileManager.bookUpdate(bookList);

						Library_printMenu.sleep();
						break;
					}
					else if(s.equals("N"))
					{
						System.out.println("취소되었습니다.");
						Library_printMenu.sleep();
						break;
					}
					else
						System.out.println("잘못 입력 하셨습니다. 다시 입력하세요.");
				}
			}
			else
			{
				System.out.println("잘못된 인덱스입니다.");
				Library_printMenu.sleep();
			}
		}
		else
		{
			System.out.println("		대여한 도서가 없습니다.");
			Library_printMenu.sleep();
		}

	}
	void modifyInfo()
	{
		Library_printMenu.jump();
		Library_printMenu.modifyinfo();
		String pw="";
		String newNAME;
		String newPW;
		String newPN;
		String newEMAIL;
		boolean flag_pw;
		boolean flag_pn;

		System.out.print("비밀번호 입력: ");
		pw=sc.nextLine();
		if(pw.equals(userInfo[2]))
		{
			System.out.print("비밀번호 확인: ");
			pw=sc.nextLine();
			if(pw.equals(userInfo[2]))
			{
				Library_printMenu.jump();
				Library_printMenu.modifyinfo();
				System.out.print("성명(기존 : "+userInfo[0]+" ): ");
				newNAME=sc.nextLine();
				//대여중인 책이 있으면 변경된 이름으로 재설정.
				for(int i=0;i<bookList.size();i++)
				{
					if(bookList.get(i).host.equals(userInfo[0]))
					{
						bookList.get(i).host=newNAME;
						fileManager.bookUpdate(bookList);
					}
				}
				System.out.println("");

				System.out.print("비밀번호(기존 : "+userInfo[2]+" ): ");
				newPW=sc.nextLine();
				flag_pw=exceptionManger.PWexception(newPW);
				System.out.println("");

				System.out.print("전화번호(기존 : "+userInfo[3]+" ): ");
				newPN=sc.nextLine();
				flag_pn=exceptionManger.PHONEexception(newPN);
				System.out.println("");

				System.out.print("이메일(기존 : "+userInfo[4]+" ): ");
				newEMAIL=sc.nextLine();
				System.out.println("");

				if(flag_pn&&flag_pw)
				{
					userInfo[0]=newNAME;
					userInfo[2]=newPW;
					userInfo[3]=newPN;
					userInfo[4]=newEMAIL;
					System.out.println("변경이 완료되었습니다...");
					fileManager.memberUpdate(userInfo);
					Library_printMenu.pressanykey();
				}
				else
				{
					System.out.println("형식에 맞게 입력하셔야합니다...");
					Library_printMenu.pressanykey();
				}
			}
			else
			{
				System.out.println("잘못된 비밀번호입니다.");
				Library_printMenu.sleep();
			}
		}
		else
		{
			System.out.println("잘못된 비밀번호입니다");
			Library_printMenu.sleep();
		}
	}
	int withdrawMember()
	{
		Library_printMenu.jump();
		Library_printMenu.withdraw();

		for(int i=0;i<bookList.size();i++)
		{
			if(bookList.get(i).host.equals(userInfo[0]))
			{
				System.out.println("대여중인 책이 있어서 회원 탈퇴가 불가능합니다.");
				Library_printMenu.sleep();
				return 0;
			}
		}
		System.out.print(userInfo[0]+"님 회원탈퇴 하시겠습니까 ? [ y / n ]입력 :");
		String s=exceptionManger.yesORno();
		if(s.equals("Y"))
		{
			fileManager.fileDelete(userInfo[1]);
			return 1;
		}
		else if(s.equals("N"))
		{
			Library_printMenu.sleep();
			return 0;
		}
		else 
		{
			Library_printMenu.sleep();
			return 0;
		}

	}

	void bookRent_valid(int num)
	{
		if(bookList.get(num).state.equals("대여가능"))
		{
			System.out.println("도서 대여가 완료되었습니다.");
			System.out.println("반납은"+dueDate()+" 로부터 7일 뒤 까지입니다.");
			bookList.get(num).state="대여중";
			bookList.get(num).host=userInfo[0];
			bookList.get(num).due_date=dueDate();
			fileManager.bookUpdate(bookList);
		}
		else
		{
			System.out.println("도서가 이미 대여중입니다.");
		}
	}

	int bookReturn()
	{
		int flag_return=0;
		Library_printMenu.jump();
		for(int i=0;i<bookList.size();i++)
		{
			if(bookList.get(i).host.equals(userInfo[0]))
			{
				System.out.println("------------도서 인덱스 : "+i+"---------------");
				System.out.println("대여일자 : "+bookList.get(i).due_date);
				System.out.println("반납일자 : "+bookList.get(i).due_date+"7일");
				flag_return++;
			}
		}
		return flag_return;
	}

	String dueDate()
	{
		Calendar cal = Calendar.getInstance();
		String msg= cal.get(Calendar.YEAR) + "년" +(cal.get(Calendar.MONTH)+1) + "월" +
				(cal.get(Calendar.DATE))+ "일";
		return msg;
	}

	int bookSearch(String s,int n)
	{
		Library_printMenu.jump();
		int caseNum=n;
		int flag=0;

		for(int i=0;i<bookList.size();i++)
		{
			if(caseNum==1 && bookList.get(i).name.contains(s) )
			{
				System.out.println("------------도서 인덱스 : "+i+"---------------");
				System.out.println("책 제목 : "+bookList.get(i).name+" 저자 : "+bookList.get(i).author);
				System.out.println("책 가격 : "+bookList.get(i).price+" 페이지 수 : "+bookList.get(i).page
						+" 상태 : "+bookList.get(i).state+"");
				System.out.println("-----------------------------------");
				flag++;
			}
			if(caseNum==2 && bookList.get(i).author.contains(s))
			{
				System.out.println("------------도서 인덱스 : "+i+"---------------");
				System.out.println("책 제목 : "+bookList.get(i).name+" 저자 : "+bookList.get(i).author);
				System.out.println("책 가격 : "+bookList.get(i).price+" 페이지 수 : "+bookList.get(i).page
						+" 상태 : "+bookList.get(i).state+"");
				System.out.println("-----------------------------------");
				flag++;
			}
			if(caseNum==3 && (bookList.get(i).name.contains(s) || bookList.get(i).author.contains(s)))
			{
				System.out.println("------------도서 인덱스 : "+i+"---------------");
				System.out.println("책 제목 : "+bookList.get(i).name+" 저자 : "+bookList.get(i).author);
				System.out.println("책 가격 : "+bookList.get(i).price+" 페이지 수 : "+bookList.get(i).page
						+" 상태 : "+bookList.get(i).state+"");
				System.out.println("-----------------------------------");
				flag++;
			}

		}
		return flag;
	}

}
