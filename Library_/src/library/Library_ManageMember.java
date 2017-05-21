package library;


import java.util.Scanner;



public class Library_ManageMember {
	
	private String Name="";
	private String Id="";
	private String Pw="";
	private String PhoneNum="";
	private String Email="";
	boolean flagSign = false;
	String msg = "";
	String tempString="";
	
	Scanner scan = new Scanner(System.in);
	Library_fileManager fileManager =new Library_fileManager();
	Library_exception exceptionManager = new Library_exception();

	//��ü ������ ���ÿ� directory ����
	public Library_ManageMember() {
		fileManager.makeDIR();
	}
	
	void signIn()
	{
		String signinID="";
		String signinPW="";
		Library_printMenu.jump();
		Library_printMenu.signIn();
		
		System.out.print("		���̵� �Է�: ");
		signinID=scan.nextLine();
		
		tempString = fileManager.fileInInfo(signinID.toUpperCase());
		String memberInfo[]=tempString.split(",");
		if(tempString.equals("NOTFOUND"))
		{
			System.out.println("		�������� �ʴ� ID�Դϴ�.");
			System.out.println("		�ʱ�ȭ������ ���ư��ϴ�");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return ;
		}
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
				fileManager.fileOut(msg,Id.toUpperCase()); //(���ϳ���,���ϸ� )
				this.msg="";//�޼��� �ʱ�ȭ
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
		this.msg+=name;
		this.msg+=",";
	}
	
	public void setId() {
		
		this.flagSign=false;
		
		while(!flagSign)
		{
			String id =scan.nextLine();
			if(fileManager.fileInCheck(id.toUpperCase()) )
			{
				this.Id = id;
				this.msg +=id;
				this.msg +=",";
				//this.msg +="Ȯ��";
				this.flagSign=true;			//while�� ��������.	
			}
			else{
				System.out.println("		���̵� �ߺ��˴ϴ�.");
				System.out.print("		ID ���Է�:");
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
		this.msg+=pw;
		this.msg+=",";
	}

	public void setPhoneNum(String phoneNum) {
		this.PhoneNum = phoneNum;
		this.msg+=phoneNum;
		this.msg+=",";
		
	}

	public void setEmail(String email) {
		this.Email = email;
		this.msg+=email;
	}
	//////////////////////
}
