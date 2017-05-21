package library;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class Library_ManageMember {

	private String Name="";
	private String Id="";
	private String Pw="";
	private String PhoneNum="";
	private String Email="";
	boolean flagSign = false;

	Scanner scan = new Scanner(System.in);
	LibraryDB dbManager = new LibraryDB();
	Library_exception exceptionManager = new Library_exception();
	ResultSet temp=null;

	void signIn()
	{
		String signinID="";
		String signinPW="";
		Library_printMenu.jump();
		Library_printMenu.signIn();

		System.out.print("		���̵� �Է�: ");
		signinID=scan.nextLine();

		if(dbManager.DB_CheckMEMBER(signinID))
		{
			System.out.println("		�������� �ʴ� ID�Դϴ�.");
			Library_printMenu.sleep();
			return ;
		}
		
		String [] memberInfo=dbManager.memberInfo(signinID); //���� if���� ����ؼ� �����ϴ� ���̵��� info ��ƿ�

		System.out.print("		��й�ȣ�Է� :");
		signinPW=scan.nextLine();
		if(signinPW.equals(memberInfo[2]))
		{
			System.out.println("		�ݰ����ϴ� "+memberInfo[0]+"����");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Library_userMenu obj=new Library_userMenu(memberInfo);
			return ;
		}
		else
		{
			System.out.println("		��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			Library_printMenu.sleep();
			return ;
		}

	}
	void signUp()
	{
		Library_printMenu.jump();
		Library_printMenu.signUp();

		System.out.print("		Name :");
		setName(scan.nextLine());
		System.out.print("		ID :");
		setId();
		System.out.print("		PW :");
		setPw(scan.nextLine());
		System.out.print("		PhoneNumber :");
		setPhoneNum(scan.nextLine());
		System.out.print("		Email :");
		setEmail(scan.nextLine());

		if(exceptionManager.IDexception(Id)&&exceptionManager.PWexception(Pw)&&
				exceptionManager.PHONEexception(PhoneNum))
		{
			dbManager.DB_OutMEMBER(this.Name,this.Id,this.Pw,this.PhoneNum,this.Email);
			System.out.println("		ȸ�������� �ּż� �����մϴ� "+Name+"��.");
			Library_printMenu.sleep();
		}
		else{
			System.out.println("		���Ŀ��°� �Է��ϼž� �մϴ�");
			Library_printMenu.sleep();
		}
	}

	//private ������ setter getter Part.
	public void setName(String name)
	{
		this.Name=name;
	}

	public void setId() {
		int count=0;
		this.flagSign=false;

		while((!flagSign))
		{
			String id =scan.nextLine();
			if(dbManager.DB_CheckMEMBER(id) )
			{
				this.Id = id;
				this.flagSign=true;			//while�� ��������.	
			}
			else{
				System.out.println("		���̵� �ߺ��˴ϴ�.");
				System.out.print("		ID ���Է�:");
				count++; //3ȸ�̻� �ݺ��� ����ǰ� �����غ���.
			}
		}
	}

	/*	public String getId() {
		return Id;
	}
	public String getPw() {
		return Pw;
	}
	public String getPhoneNum() {
		return PhoneNum;
	}
	public String getEmail() {
		return Email;
	}
	 */
	public void setPw(String pw) {
		this.Pw = pw;
	}

	public void setPhoneNum(String phoneNum) {
		this.PhoneNum = phoneNum;
	}

	public void setEmail(String email) {
		this.Email = email;
	}
}
