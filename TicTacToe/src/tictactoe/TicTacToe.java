package tictactoe;
//1번 : make를 한 번 더 해주기
//2번 : 꼼수 - > make내부만 맨 마지막에 해주기.
import java.util.Scanner;

class Board
{
	Board pan[][]=new Board[3][3];
	int panCase=0; //해당 부분에 돌이 놓여졌는지 판별용
	int spotNum;//해당 칸의 주소,이름 과 같은 역할. 몇 번 칸인지 판별용
	String spot; //실제 바둑돌이 놓여져 출력될 부분.
	
	int comWin=0;
	int userWin=0;
	int user1_win=0;
	int user2_win=0;
	int comuser_draw=0;
	int useruser_draw=0;

	Scanner sc= new Scanner(System.in);

	//객체 배열 생성 메소드.
	void make() 
	{
		int number=1;
		for(int i=0; i<3 ; i++)
		{
			for(int j =0 ; j<3 ;j++)
			{
				pan[i][j]= new Board();

				pan[i][j].spot=Integer.toString(number); //string 형태로 Parse
				pan[i][j].spotNum=number; //pan배열에 번호 할당.
				number++;
			}
		}
	}
	//무승부 판별하는 메소드
	boolean draw()
	{
		int temp=0;
		for(int i=0; i<3; i++)
		{
			for(int j=0;j<3;j++)
			{
				if(pan[i][j].panCase==1) //각 칸마다 돌이 놓여져있는지 검사
				{temp++;}
			}
		}
		if(temp==9){return true;}//돌이 다 놓아져 있다면 무승부
		else return false;
	}


	//승패 판별하는 메소드.
	boolean valid_UserWin()
	{
		//User가 이기는 경우
		if((pan[0][0].spot.equals("○")) && (pan[0][1].spot.equals("○")) && (pan[0][2].spot.equals("○")))
		{return true;}
		else if((pan[0][0].spot.equals("○")) && (pan[1][0].spot.equals("○")) && (pan[2][0].spot.equals("○")))
		{return true;}
		else if((pan[0][0].spot.equals("○")) && (pan[1][1].spot.equals("○")) && (pan[2][2].spot.equals("○")))
		{return true;}
		else if((pan[2][0].spot.equals("○")) && (pan[2][1].spot.equals("○")) && (pan[2][2].spot.equals("○")))
		{return true;}
		else if((pan[2][0].spot.equals("○")) && (pan[1][1].spot.equals("○")) && (pan[0][2].spot.equals("○")))
		{return true;}
		else if((pan[2][2].spot.equals("○")) && (pan[1][2].spot.equals("○")) && (pan[0][2].spot.equals("○")))
		{return true;}
		else if((pan[1][0].spot.equals("○")) && (pan[1][1].spot.equals("○")) && (pan[1][2].spot.equals("○")))
		{return true;}
		else if((pan[0][1].spot.equals("○")) && (pan[1][1].spot.equals("○")) && (pan[2][1].spot.equals("○")))
		{return true;}

		else
		{return false;}
	}

	boolean valid_ComWin()
	{
		//Com이 이기는 경우

		if((pan[0][0].spot.equals("●")) && (pan[0][1].spot.equals("●")) && (pan[0][2].spot.equals("●")))
		{return true;}
		else if((pan[0][0].spot.equals("●")) && (pan[1][0].spot.equals("●")) && (pan[2][0].spot.equals("●")))
		{return true;}
		else if((pan[0][0].spot.equals("●")) && (pan[1][1].spot.equals("●")) && (pan[2][2].spot.equals("●")))
		{return true;}
		else if((pan[2][0].spot.equals("●")) && (pan[2][1].spot.equals("●")) && (pan[2][2].spot.equals("●")))
		{return true;}
		else if((pan[2][0].spot.equals("●")) && (pan[1][1].spot.equals("●")) && (pan[0][2].spot.equals("●")))
		{return true;}
		else if((pan[2][2].spot.equals("●")) && (pan[1][2].spot.equals("●")) && (pan[0][2].spot.equals("●")))
		{return true;}
		else if((pan[1][0].spot.equals("●")) && (pan[1][1].spot.equals("●")) && (pan[1][2].spot.equals("●")))
		{return true;}
		else if((pan[0][1].spot.equals("●")) && (pan[1][1].spot.equals("●")) && (pan[2][1].spot.equals("●")))
		{return true;}

		else
		{return false;}
	}

	//VS USER
	void versusUser()
	{
		spaceJump();
		System.out.println("VS USER 입니다.");

		Loop1: while(true)//User 1 LOOP
		{
			int inputNum=0; //계속 생성함과 초기화
			printAll();

			System.out.println("1p Turn");
			System.out.print("Select a number : ");

			inputNum=sc.nextInt();
			if(inputNum>9) //입력범위 벗어났을 때 예외처리
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
						pan[i][j].spot="○";
						pan[i][j].panCase=1; // Boolean 역할
						spaceJump();
					}


					else if(inputNum==pan[i][j].spotNum && pan[i][j].panCase==1)//돌이 놓여져 있다면
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
			Loop2: while(true) //goto를 위한 꼼수
			{
			printAll();

			System.out.println("2p Turn");
			System.out.print("Select a number : ");

			inputNum=sc.nextInt();
			if(inputNum>9) //입력범위 벗어났을 때 예외처리
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
						pan[i][j].spot="●";
						pan[i][j].panCase=1; // Boolean 역할
						spaceJump();
					}


					else if(inputNum==pan[i][j].spotNum && pan[i][j].panCase==1)	//돌이 놓여져 있다면
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
		System.out.println("VS COM 입니다.");
		Loop: while(true)
		{
			int whileCounter=0;//이건 노가다 방법인데 그냥 while문 빠져나가게 하는 방법
			int inputNum=0;
			printAll();

			System.out.print("Select a number : ");
			//System.out.println("○ : user  ● : com");

			inputNum=sc.nextInt();
			if(inputNum>9) //입력범위 벗어났을 때 예외처리
			{
				spaceJump();
				System.out.println("The number is out of range.");
				continue Loop;
			}

			//사용자가 입력한 바둑돌을 놓는 부분
			for(int i=0; i<3 ; i++)
			{
				for(int j =0 ; j<3 ;j++)
				{
					if(inputNum==pan[i][j].spotNum && pan[i][j].panCase==0)
					{
						pan[i][j].spot="○";
						pan[i][j].panCase=1; // Boolean 역할
						spaceJump();
					}


					else if(inputNum==pan[i][j].spotNum && pan[i][j].panCase==1)	//돌이 놓여져 있다면
					{
						spaceJump();

						System.out.println("The space is already occupied");
						continue Loop; //지렸다... JAVA에서는 루프마다 label을 달 수 있어서 해당루프로 continue 가능
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

			//Com이 바둑돌을 랜덤하게 두는 부분
			while(whileCounter==0)
			{
				inputNum=(int)(Math.random()*9)+1;
				for(int s=0; s<3 ; s++)
				{
					for(int q =0 ; q<3 ;q++)
					{
						//모든 배열을 검사해서 해당 spot이 비어있고, 랜덤 수와 일치하다면 바둑돌 두기
						if((pan[s][q].spotNum==inputNum)&&(pan[s][q].panCase==0))
						{
							pan[s][q].spot="●";
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

	}//VS com while문


	//화면 넘어가는거 처럼 보이게 20줄 띄워쓰기 메소드
	void spaceJump() 
	{
		for(int i=0;i<20;i++)
		{System.out.println(" ");}
	}


	//스코어 보드 출력 메소드
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
	
	//바둑판 출력 메소드
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

	public static int printMenu() // 메뉴 표시 메소드
	{
		int selectNum=0;
		System.out.println("**	TIC_TAC_TOE	**");
		System.out.println("┏━━━━━━━━━━━━━━┓");
		System.out.print("┃	1. VS COM");
		System.out.println("	      ┃");
		System.out.print("┃	2. VS USER");
		System.out.println("	      ┃");
		System.out.print("┃	3. SCORE");
		System.out.println("	      ┃");
		System.out.print("┃	4. EXIT");
		System.out.println(" 	      ┃");
		System.out.println("┃   			      ┃");
		System.out.println("┗━━━━━━━━━━━━━━┛");
		System.out.println("※ SELECT A NUMBER :");


		Scanner sc=new Scanner(System.in);		
		selectNum=sc.nextInt();
		sc.nextLine();

		if( (selectNum<1) || (selectNum>4) )//메뉴선택 범위 넘어갈 시 오류
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
