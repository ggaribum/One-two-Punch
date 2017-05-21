/*package library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Library_fileManager {

	ArrayList<Library_book>bookList=new ArrayList<Library_book>();
	BufferedReader br= null;
	BufferedWriter bw= null;
	FileInputStream fin = null;
	FileInputStream fin2 = null;
	FileWriter fout = null;
	File memberDIR =new File("src/MemberDirectory"); //���Ⱑ �����ε� �̹� ���丮�� ������ ��������
	File del=null;
	//ó���� �ڵ����� �Ǵ��� �ƴϸ� �ؾ��ϴ���..
	File temp =null;

	String memberFileName = "Info_";
	String tempString="";
	String memberInfo="";
	String bookInfo="";

	void makeDIR()
	{
		memberDIR.mkdir();//��������� ������ ���丮 ����
	}

	void fileDelete(String id)
	{
		id="Info_"+id.toUpperCase()+".txt";
		String path="src/MemberDirectory/"+id;
		del=new File(path);
		System.out.println("�����Ϸ�");
		Library_printMenu.sleep();
		del.delete(); //�� ������ �ȵɱ�..�������� �����̶� ������ �ȵǴ°ǰ�..?

	}
	String fileInInfo(String id)
	{
		id="Info_"+id+".txt";

		temp= new File(memberDIR,""); //temp�� ��θ� memberDIR��
		File read_dir[]=temp.listFiles();// read_dir[]�迭�� ���丮 ���� ������ ��´�.

		for(int i=0; i< read_dir.length;i++)
		{
			if(id.equals(read_dir[i].getName() ) ) //���̵�� ���� ������ ���丮�� �ִٸ�
			{
				try {
					//�� ��� ����� �α� ********************
					br= new BufferedReader(new FileReader(read_dir[i]));
					while( ( tempString=br.readLine() ) != null )
					{
						memberInfo=tempString;
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
				//*********************************
				return memberInfo;
			}
		}
		return "NOTFOUND";
	}

	void memberUpdate(String []s)
	{
		String fileNameTemp;
		fileNameTemp="Info_"+s[1].toUpperCase()+".txt";
		String path="src/MemberDirectory/"+fileNameTemp;

		try (BufferedWriter bfw= new BufferedWriter(new FileWriter(path));)
		{
			for(int i=0;i<s.length;i++)
			{
				bfw.write(s[i]);
				bfw.write(",");
			}
		}catch (IOException e) 
		{
			e.printStackTrace();
		}

	}
	void bookUpdate(ArrayList<Library_book> tempList)
	{
		String path="src/LibBook.txt";
		try {
			bw=new BufferedWriter(new FileWriter(path));
			for(int i=0; i<tempList.size();i++)
			{
				bw.write(tempList.get(i).name);
				bw.write(",");
				bw.write(tempList.get(i).author);
				bw.write(",");
				bw.write(tempList.get(i).price);
				bw.write(",");
				bw.write(tempList.get(i).page);
				bw.write(",");
				bw.write(tempList.get(i).state);
				bw.write(",");
				bw.write(tempList.get(i).host);
				bw.write(",");
				bw.write(tempList.get(i).due_date);
				bw.newLine();
			}
			bw.flush();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	ArrayList<Library_book> fileInBook()
	{
		int i=0;
		String path="src/LibBook.txt";
		//temp=new File(path);
		try {
			br= new BufferedReader(new FileReader(path));
			while( ( tempString=br.readLine() ) != null )
			{
				bookInfo=tempString;
				String bookInfo2[]=bookInfo.split(",");
				bookList.add(new Library_book( bookInfo2[0], 
						bookInfo2[1], bookInfo2[2], bookInfo2[3], 
						bookInfo2[4],bookInfo2[5],bookInfo2[6])
						);
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bookList;
	}


	boolean fileInCheck(String id)
	{
		id="Info_"+id+".txt";	//id�ߺ� �˻����� ���ϸ�� ���ҷ���.

		temp=new File(memberDIR,"");
		File read_dir[]=temp.listFiles();

		for(int i=0; i<read_dir.length;i++)
		{
			if(id.equals(read_dir[i].getName())) //���� MemberDirectory�� ���̵� �ߺ��Ǹ�
			{return false;}
		}
		return true;
	}

	void fileOut(String msg,String memberFileName)
	{

		try {
			temp=new File(memberDIR,this.memberFileName+memberFileName+".txt");
			temp.createNewFile();
			fout= new FileWriter(temp);

			fout.write(msg);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
*/