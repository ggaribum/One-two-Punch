package library;

public class Library_book {

	Library_book BOOK[];
	
	String name="";
	String author="";
	String price="";
	String page="";
	String state="";
	String host="";
	String due_date="";
	public Library_book() {
	
	}
	public Library_book(String n,String a,String pr,String pa,String s,String h, String d) 
	{
		this.name=n;
		this.author=a;
		this.price=pr;
		this.page=pa;
		this.state=s;
		this.host=h;
		this.due_date=d;
	}
}
