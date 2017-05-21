package tictactoe;
//1�� : make�� �� �� �� ���ֱ�
//2�� : �ļ� - > make���θ� �� �������� ���ֱ�.
import java.util.Scanner;

class Board
{
	Board pan[][]=new Board[3][3];
	int panCase=0; //�ش� �κп� ���� ���������� �Ǻ���
	int spotNum;//�ش� ĭ�� �ּ�,�̸� �� ���� ����. �� �� ĭ���� �Ǻ���
	String spot; //���� �ٵϵ��� ������ ��µ� �κ�.
	
	int comWin=0;
	int userWin=0;
	int user1_win=0;
	int user2_win=0;
	int comuser_draw=0;
	int useruser_draw=0;

	Scanner sc= new Scanner(System.in);

	//��ü �迭 ���� �޼ҵ�.
	void make() 
	{
		int number=1;
		for(int i=0; i<3 ; i++)
		{
			for(int j =0 ; j<3 ;j++)
			{
				pan[i][j]= new Board();

				pan[i][j].spot=Integer.toString(number); //string ���·� Parse
				pan[i][j].spotNum=number; //pan�迭�� ��ȣ �Ҵ�.
				number++;
			}
		}
	}
	//���º� �Ǻ��ϴ� �޼ҵ�
	boolean draw()
	{
		int temp=0;
		for(int i=0; i<3; i++)
		{
			for(int j=0;j<3;j++)
			{
				if(pan[i][j].panCase==1) //�� ĭ���� ���� �������ִ��� �˻�
				{temp++;}
			}
		}
		if(temp==9){return true;}//���� �� ������ �ִٸ� ���º�
		else return false;
	}


	//���� �Ǻ��ϴ� �޼ҵ�.
	boolean valid_UserWin()
	{
		//User�� �̱�� ���
		if((pan[0][0].spot.equals("��")) && (pan[0][1].spot.equals("��")) && (pan[0][2].spot.equals("��")))
		{return true;}
		else if((pan[0][0].spot.equals("��")) && (pan[1][0].spot.equals("��")) && (pan[2][0].spot.equals("��")))
		{return true;}
		else if((pan[0][0].spot.equals("��")) && (pan[1][1].spot.equals("��")) && (pan[2][2].spot.equals("��")))
		{return true;}
		else if((pan[2][0].spot.equals("��")) && (pan[2][1].spot.equals("��")) && (pan[2][2].spot.equals("��")))
		{return true;}
		else if((pan[2][0].spot.equals("��")) && (pan[1][1].spot.equals("��")) && (pan[0][2].spot.equals("��")))
		{return true;}
		else if((pan[2][2].spot.equals("��")) && (pan[1][2].spot.equals("��")) && (pan[0][2].spot.equals("��")))
		{return true;}
		else if((pan[1][0].spot.equals("��")) && (pan[1][1].spot.equals("��")) && (pan[1][2].spot.equals("��")))
		{return true;}
		else if((pan[0][1].spot.equals("��")) && (pan[1][1].spot.equals("��")) && (pan[2][1].spot.equals("��")))
		{return true;}

		else
		{return false;}
	}

	boolean valid_ComWin()
	{
		//Com�� �̱�� ���

		if((pan[0][0].spot.equals("��")) && (pan[0][1].spot.equals("��")) && (pan[0][2].spot.equals("��")))
		{return true;}
		else if((pan[0][0].spot.equals("��")) && (pan[1][0].spot.equals("��")) && (pan[2][0].spot.equals("��")))
		{return true;}
		else if((pan[0][0].spot.equals("��")) && (pan[1][1].spot.equals("��")) && (pan[2][2].spot.equals("��")))
		{return true;}
		else if((pan[2][0].spot.equals("��")) && (pan[2][1].spot.equals("��")) && (pan[2][2].spot.equals("��")))
		{return true;}
		else if((pan[2][0].spot.equals("��")) && (pan[1][1].spot.equals("��")) && (pan[0][2].spot.equals("��")))
		{return true;}
		else if((pan[2][2].spot.equals("��")) && (pan[1][2].spot.equals("��")) && (pan[0][2].spot.equals("��")))
		{return true;}
		else if((pan[1][0].spot.equals("��")) && (pan[1][1].spot.equals("��")) && (pan[1][2].spot.equals("��")))
		{return true;}
		else if((pan[0][1].spot.equals("��")) && (pan[1][1].spot.equals("��")) && (pan[2][1].spot.equals("��")))
		{return true;}

		else
		{return false;}
	}

	//VS USER
	void versusUser()
	{
		spaceJump();
		System.out.println("VS USER �Դϴ�.");

		Loop1: while(true)//User 1 LOOP
		{
			int inputNum=0; //��� �����԰� �ʱ�ȭ
			printAll();

			System.out.println("1p Turn");
			System.out.print("Select a number : ");

			inputNum=sc.nextInt();
			if(inputNum>9) //�Է¹��� ����� �� ����ó��
			{
				spaceJump();
				System.out.println("The number is out of range.");
				continue Loop1;
			}

			//USER 1 Turn
			for(int i=0; i<3 ; i++)
			{
				for(int j =0 ; j<3 ;j++)
				{
					if(inputNum==pan[i][j].spotNum && pan[i][j].panCase==0)
					{
						pan[i][j].spot="��";
						pan[i][j].panCase=1; // Boolean ����
						spaceJump();
					}


					else if(inputNum==pan[i][j].spotNum && pan[i][j].panCase==1)//���� ������ �ִٸ�
					{
						spaceJump();
						System.out.println("The space is already occupied");
						continue Loop1; 
					}
				}
			}

			if(valid_UserWin())
			{
				user1_win++;
				System.out.println("User1 is WIN !!!");
				printAll();
				make();
				break;
			}

			if(draw())
			{
				useruser_draw++;
				System.out.println("DRAW !!!!");
				printAll();
				make();
				break;
			}
			/////////////////////////////
			//USER 2 turn
			Loop2: while(true) //goto�� ���� �ļ�
			{
			printAll();

			System.out.println("2p Turn");
			System.out.print("Select a number : ");

			inputNum=sc.nextInt();
			if(inputNum>9) //�Է¹��� ����� �� ����ó��
			{
				spaceJump();
				System.out.println("The number is out of range.");
				continue Loop2;
			}
			for(int i=0; i<3 ; i++)
			{
				for(int j =0 ; j<3 ;j++)
				{
					if(inputNum==pan[i][j].spotNum && pan[i][j].panCase==0)
					{
						pan[i][j].spot="��";
						pan[i][j].panCase=1; // Boolean ����
						spaceJump();
					}


					else if(inputNum==pan[i][j].spotNum && pan[i][j].panCase==1)	//���� ������ �ִٸ�
					{
						spaceJump();

						System.out.println("The space is already occupied");
						continue Loop2;
					}
				}
			}
			break;
		}//USER 2 LOOP2
			if(valid_ComWin())
			{
				user2_win++;
				System.out.println("User2 is WIN");
				printAll();
				make();
				break;
			}
		}//VS USER LOOP1
	}


	//VS COM
	void versusCom()
	{
		spaceJump();
		System.out.println("VS COM �Դϴ�.");
		Loop: while(true)
		{
			int whileCounter=0;//�̰� �밡�� ����ε� �׳� while�� ���������� �ϴ� ���
			int inputNum=0;
			printAll();

			System.out.print("Select a number : ");
			//System.out.println("�� : user  �� : com");

			inputNum=sc.nextInt();
			if(inputNum>9) //�Է¹��� ����� �� ����ó��
			{
				spaceJump();
				System.out.println("The number is out of range.");
				continue Loop;
			}

			//����ڰ� �Է��� �ٵϵ��� ���� �κ�
			for(int i=0; i<3 ; i++)
			{
				for(int j =0 ; j<3 ;j++)
				{
					if(inputNum==pan[i][j].spotNum && pan[i][j].panCase==0)
					{
						pan[i][j].spot="��";
						pan[i][j].panCase=1; // Boolean ����
						spaceJump();
					}


					else if(inputNum==pan[i][j].spotNum && pan[i][j].panCase==1)	//���� ������ �ִٸ�
					{
						spaceJump();

						System.out.println("The space is already occupied");
						continue Loop; //���ȴ�... JAVA������ �������� label�� �� �� �־ �ش������ continue ����
					}
				}
			}

			if(valid_UserWin())
			{
				userWin++;
				System.out.println("User is WIN !!!");
				printAll();
				make();
				break;
			}

			if(draw())
			{
				comuser_draw++;
				System.out.println("DRAW !!!");
				printAll();
				make();
				break;
			}

			//Com�� �ٵϵ��� �����ϰ� �δ� �κ�
			while(whileCounter==0)
			{
				inputNum=(int)(Math.random()*9)+1;
				for(int s=0; s<3 ; s++)
				{
					for(int q =0 ; q<3 ;q++)
					{
						//��� �迭�� �˻��ؼ� �ش� spot�� ����ְ�, ���� ���� ��ġ�ϴٸ� �ٵϵ� �α�
						if((pan[s][q].spotNum==inputNum)&&(pan[s][q].panCase==0))
						{
							pan[s][q].spot="��";
							pan[s][q].panCase=1;
							whileCounter=1;
							break;
						}
					}
				}
			}
			if(valid_ComWin())
			{
				spaceJump();
				comWin++;
				System.out.println("Com is WIN");
				printAll();
				make();
				break;
			}
			spaceJump();
		}

	}//VS com while��


	//ȭ�� �Ѿ�°� ó�� ���̰� 20�� ������� �޼ҵ�
	void spaceJump() 
	{
		for(int i=0;i<20;i++)
		{System.out.println(" ");}
	}


	//���ھ� ���� ��� �޼ҵ�
	void scoreBoard()
	{
		spaceJump();
		System.out.println("=========== 	Score Board 	==========");
		System.out.println("		Com vs 1P			");
		System.out.println("Computer	Draw		Player");
		System.out.println(comWin+"		"+comuser_draw+"		"+userWin);
		System.out.println("");
		System.out.println("		1P vs 2P			");
		System.out.println("1p Win		Draw		2p Win");
		System.out.println(user1_win+"		"+useruser_draw+"		"+user2_win);
		System.out.println("==========================================");
		
	}
	
	//�ٵ��� ��� �޼ҵ�
	void printAll()
	{
		System.out.println("===================");
		for(int i=0; i<3 ; i++)
		{
			for(int j=0; j<3; j++)
			{
				System.out.print(pan[i][j].spot);
				System.out.print("	");
			}
			System.out.println();
		}
		System.out.println("===================");
	}

}

public class TicTacToe {

	public static int printMenu() // �޴� ǥ�� �޼ҵ�
	{
		int selectNum=0;
		System.out.println("**	TIC_TAC_TOE	**");
		System.out.println("��������������������������������");
		System.out.print("��	1. VS COM");
		System.out.println("	      ��");
		System.out.print("��	2. VS USER");
		System.out.println("	      ��");
		System.out.print("��	3. SCORE");
		System.out.println("	      ��");
		System.out.print("��	4. EXIT");
		System.out.println(" 	      ��");
		System.out.println("��   			      ��");
		System.out.println("��������������������������������");
		System.out.println("�� SELECT A NUMBER :");


		Scanner sc=new Scanner(System.in);		
		selectNum=sc.nextInt();
		sc.nextLine();

		if( (selectNum<1) || (selectNum>4) )//�޴����� ���� �Ѿ �� ����
		{System.out.println("!! The number is wrong !!"); return 0;}
		else
		{return selectNum;}
	}


	public static void main(String[] args) {
		Board obj = new Board();
		obj.make();

		int selectNum=0;

		while(true)
		{
			selectNum=printMenu();

			switch(selectNum)
			{
			case 1:	obj.versusCom(); break;
			case 2:	obj.versusUser(); break;
			case 3: obj.scoreBoard(); break;
			case 4: obj.spaceJump(); System.out.println("GAME OVER");return;
			}

		}

	}

}
