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

	//객체 생성과 동시에 directory 생성
	public Library_ManageMember() {
		fileManager.makeDIR();
	}
	
	void signIn()
	{
		String signinID="";
		String signinPW="";
		Library_printMenu.jump();
		Library_printMenu.signIn();
		
		System.out.print("		아이디 입력: ");
		signinID=scan.nextLine();
		
		tempString = fileManager.fileInInfo(signinID.toUpperCase());
		String memberInfo[]=tempString.split(",");
		if(tempString.equals("NOTFOUND"))
		{
			System.out.println("		존재하지 않는 ID입니다.");
			System.out.println("		초기화면으로 돌아갑니다");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return ;
		}
		System.out.print("		비밀번호입력 :");
		signinPW=scan.nextLine();
		if(signinPW.equals(memberInfo[2]))
		{
			System.out.println("		반갑습니다 "+memberInfo[0]+"씨♥");
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
			System.out.println("		비밀번호가 틀렸습니다.");
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
				fileManager.fileOut(msg,Id.toUpperCase()); //(파일내용,파일명 )
				this.msg="";//메세지 초기화
				System.out.println("		회원가입해 주셔서 감사합니다 "+Name+"씨.");
				Library_printMenu.sleep();
			}
			else{
			System.out.println("		형식에맞게 입력하셔야 합니다");
			Library_printMenu.sleep();
			}
	}

	//private 변수들 setter getter Part.
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
				//this.msg +="확인";
				this.flagSign=true;			//while문 빠져나옴.	
			}
			else{
				System.out.println("		아이디가 중복됩니다.");
				System.out.print("		ID 재입력:");
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
