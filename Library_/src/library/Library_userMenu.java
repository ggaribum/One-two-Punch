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
			System.out.println("							"+userInfo[0]+" �� �ݰ����ϴ�.");
			Library_printMenu.userMenu();
			System.out.println("");
			System.out.print("		�޴����� : ");

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
				System.out.print("		�α׾ƿ� �Ͻðڽ��ϱ� ? [y/n] : " );
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
			System.out.print("		å ������ �Է��ϼ��� :");
			String s= sc.nextLine();

			exceptionManger.isEmptyList(bookSearch(s, select));
			break;
		}
		case 2:
		{
			System.out.print("		å ���ڸ� �Է��ϼ��� :");
			String s= sc.nextLine();

			exceptionManger.isEmptyList(bookSearch(s, select));
			break;
		}
		case 3:
			System.out.print("		å ���� �Ǵ� ���ڸ� �Է��ϼ��� :");
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
			System.out.println("å ���� : "+list_iter.name+" ���� : "+list_iter.author);
			System.out.println("å ���� : "+list_iter.price+" ������ �� : "+list_iter.page
					+" ���� : "+list_iter.state+"");
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
			System.out.print("		å ������ �Է��ϼ��� :");
			String s= sc.nextLine();

			if(bookSearch(s,select)!=0)
			{	
				System.out.print("����� �������Դϴ�. �뿩�� ���� index �Է� :");
				select=sc.nextInt();
				if(bookList.get(select).name.contains(s))
				{
					bookRent_valid(select);
					Library_printMenu.sleep();
				}

				else
				{
					System.out.println("�߸��� �ε����Դϴ�.");
					Library_printMenu.sleep();
				}
				break;
			}
			else
			{
				System.out.println("-----------------------------------");
				System.out.println("�˻������ �����ϴ�.");
				Library_printMenu.pressanykey();
				//break;

			}
			break;
		}

		case 2:
		{
			System.out.print("		å ���ڸ� �Է��ϼ��� :");
			String s= sc.nextLine();

			if(bookSearch(s,select)!=0)
			{
				System.out.print("����� �������Դϴ�. �뿩�� ���� index �Է� :");
				select=sc.nextInt();
				if(bookList.get(select).author.contains(s))
				{
					bookRent_valid(select);
					Library_printMenu.sleep();
				}

				else
				{
					System.out.println("�߸��� �ε����Դϴ�.");
					Library_printMenu.sleep();
				}
				break;
			}
			else

			{
				System.out.println("-----------------------------------");
				System.out.println("�˻������ �����ϴ�.");
				Library_printMenu.pressanykey();
			}
			break;
		}
		case 3:
		{
			System.out.print("		å ���� �Ǵ� ���ڸ� �Է��ϼ��� :");
			String s= sc.nextLine();

			if(bookSearch(s,select)!=0)
			{
				System.out.print("����� �������Դϴ�. �뿩�� ���� index �Է� :");
				select=sc.nextInt();
				if(bookList.get(select).name.contains(s) || bookList.get(select).author.contains(s))
				{
					bookRent_valid(select);
					Library_printMenu.sleep();
				}

				else
				{
					System.out.println("�߸��� �ε����Դϴ�.");
					Library_printMenu.sleep();
				}
				break;
			}
			else
			{
				System.out.println("-----------------------------------");
				System.out.println("�˻������ �����ϴ�.");
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
			System.out.print("����� �������Դϴ�. �ݳ��� ���� index �Է�: ");
			i=sc.nextInt();
			sc.nextLine();
			if(bookList.get(i).host.equals(userInfo[0]))
			{
				while(true)
				{
					System.out.print("�ݳ��ϽǷ��� [y], ����ϽǷ���[n] �Է��ϼ���: ");
					s=exceptionManger.yesORno();
					if(s.equals("Y"))
					{
						System.out.println("�ݳ��� �Ϸ����ϴ�.");
						bookList.get(i).state="�뿩����";
						bookList.get(i).host="������";
						bookList.get(i).due_date="0";
						fileManager.bookUpdate(bookList);

						Library_printMenu.sleep();
						break;
					}
					else if(s.equals("N"))
					{
						System.out.println("��ҵǾ����ϴ�.");
						Library_printMenu.sleep();
						break;
					}
					else
						System.out.println("�߸� �Է� �ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
				}
			}
			else
			{
				System.out.println("�߸��� �ε����Դϴ�.");
				Library_printMenu.sleep();
			}
		}
		else
		{
			System.out.println("		�뿩�� ������ �����ϴ�.");
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

		System.out.print("��й�ȣ �Է�: ");
		pw=sc.nextLine();
		if(pw.equals(userInfo[2]))
		{
			System.out.print("��й�ȣ Ȯ��: ");
			pw=sc.nextLine();
			if(pw.equals(userInfo[2]))
			{
				Library_printMenu.jump();
				Library_printMenu.modifyinfo();
				System.out.print("����(���� : "+userInfo[0]+" ): ");
				newNAME=sc.nextLine();
				//�뿩���� å�� ������ ����� �̸����� �缳��.
				for(int i=0;i<bookList.size();i++)
				{
					if(bookList.get(i).host.equals(userInfo[0]))
					{
						bookList.get(i).host=newNAME;
						fileManager.bookUpdate(bookList);
					}
				}
				System.out.println("");

				System.out.print("��й�ȣ(���� : "+userInfo[2]+" ): ");
				newPW=sc.nextLine();
				flag_pw=exceptionManger.PWexception(newPW);
				System.out.println("");

				System.out.print("��ȭ��ȣ(���� : "+userInfo[3]+" ): ");
				newPN=sc.nextLine();
				flag_pn=exceptionManger.PHONEexception(newPN);
				System.out.println("");

				System.out.print("�̸���(���� : "+userInfo[4]+" ): ");
				newEMAIL=sc.nextLine();
				System.out.println("");

				if(flag_pn&&flag_pw)
				{
					userInfo[0]=newNAME;
					userInfo[2]=newPW;
					userInfo[3]=newPN;
					userInfo[4]=newEMAIL;
					System.out.println("������ �Ϸ�Ǿ����ϴ�...");
					fileManager.memberUpdate(userInfo);
					Library_printMenu.pressanykey();
				}
				else
				{
					System.out.println("���Ŀ� �°� �Է��ϼž��մϴ�...");
					Library_printMenu.pressanykey();
				}
			}
			else
			{
				System.out.println("�߸��� ��й�ȣ�Դϴ�.");
				Library_printMenu.sleep();
			}
		}
		else
		{
			System.out.println("�߸��� ��й�ȣ�Դϴ�");
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
				System.out.println("�뿩���� å�� �־ ȸ�� Ż�� �Ұ����մϴ�.");
				Library_printMenu.sleep();
				return 0;
			}
		}
		System.out.print(userInfo[0]+"�� ȸ��Ż�� �Ͻðڽ��ϱ� ? [ y / n ]�Է� :");
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
		if(bookList.get(num).state.equals("�뿩����"))
		{
			System.out.println("���� �뿩�� �Ϸ�Ǿ����ϴ�.");
			System.out.println("�ݳ���"+dueDate()+" �κ��� 7�� �� �����Դϴ�.");
			bookList.get(num).state="�뿩��";
			bookList.get(num).host=userInfo[0];
			bookList.get(num).due_date=dueDate();
			fileManager.bookUpdate(bookList);
		}
		else
		{
			System.out.println("������ �̹� �뿩���Դϴ�.");
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
				System.out.println("------------���� �ε��� : "+i+"---------------");
				System.out.println("�뿩���� : "+bookList.get(i).due_date);
				System.out.println("�ݳ����� : "+bookList.get(i).due_date+"7��");
				flag_return++;
			}
		}
		return flag_return;
	}

	String dueDate()
	{
		Calendar cal = Calendar.getInstance();
		String msg= cal.get(Calendar.YEAR) + "��" +(cal.get(Calendar.MONTH)+1) + "��" +
				(cal.get(Calendar.DATE))+ "��";
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
				System.out.println("------------���� �ε��� : "+i+"---------------");
				System.out.println("å ���� : "+bookList.get(i).name+" ���� : "+bookList.get(i).author);
				System.out.println("å ���� : "+bookList.get(i).price+" ������ �� : "+bookList.get(i).page
						+" ���� : "+bookList.get(i).state+"");
				System.out.println("-----------------------------------");
				flag++;
			}
			if(caseNum==2 && bookList.get(i).author.contains(s))
			{
				System.out.println("------------���� �ε��� : "+i+"---------------");
				System.out.println("å ���� : "+bookList.get(i).name+" ���� : "+bookList.get(i).author);
				System.out.println("å ���� : "+bookList.get(i).price+" ������ �� : "+bookList.get(i).page
						+" ���� : "+bookList.get(i).state+"");
				System.out.println("-----------------------------------");
				flag++;
			}
			if(caseNum==3 && (bookList.get(i).name.contains(s) || bookList.get(i).author.contains(s)))
			{
				System.out.println("------------���� �ε��� : "+i+"---------------");
				System.out.println("å ���� : "+bookList.get(i).name+" ���� : "+bookList.get(i).author);
				System.out.println("å ���� : "+bookList.get(i).price+" ������ �� : "+bookList.get(i).page
						+" ���� : "+bookList.get(i).state+"");
				System.out.println("-----------------------------------");
				flag++;
			}

		}
		return flag;
	}

}
