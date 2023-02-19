package day08;

import java.util.Iterator; // 반복자 ? 이따 찾아보기
import java.util.Random; // 랜덤부여를 사용하겠다.
import java.util.Scanner; // 입력을 사용하겠다.

public class ATM {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // 입력 선언
		Random r = new Random(); // 랜덤 선언
		System.out.println("★☆★☆ATM기기를 시작합니다★☆★☆");
		String myAccount = ""; // 발급받은 계좌를 저장할 변수
		String pw = ""; // 패스워드를 저정할 변수
		int wallet = 0; // 총 금액을 저장할 변수
		
		while(true) { // 종료하기 전까지 무한 반복
			System.out.println("--main menu--");
			System.out.println("1. 계좌개설하기");
			System.out.println("2. 입금하기");
			System.out.println("3. 출금하기");
			System.out.println("4. 나가기");
			System.out.print("입력 >> ");
			int choice = Integer.parseInt(sc.nextLine()); // 정수형으로 강제로 바꾸면서 버퍼 에러 동시에 조치하기 위함.
			if(choice == 1) { // 입력이 1이 되었을 때
				// 계좌 개설하기
//				System.out.println(r.nextInt(100) + "-" + r.nextInt(10000) + "-" + r.nextInt(10000));
//				System.out.printf("%02d-%04d-%04d\n", r.nextInt(100), r.nextInt(10000), r.nextInt(10000));
				
				// String 클래스 안에 있는 format()이라는 메소드, 사용법은 printf()랑 똑같은데 문자열 값으로 가져온다는 점이 차이점.
				// 형식을 갖춘 문자열을 반환하는(가져오는) 메소드 - 랜덤 계좌를 1번 입금할 때 계좌랑 같아야함.
				myAccount = String.format("%02d-%04d-%04d", r.nextInt(100), r.nextInt(10000), r.nextInt(10000));
				                        // 랜덤으로 부여받은 값을 %02d %04d %0d 형식에 맞춰서 입력되고, 그 값을 myAccount 에 저장하겠다.
				System.out.println("발급 계좌 : " +myAccount); // 위의 형태는 출력으로 나타 낼 수 없기때문에 myAccount 에 저장된 값을 출력해서 보겠다.
				
				for(int i=0; i<3; i++) // 비밀번호 생성 시 [비밀번호 생성과 확인] 일치하는지 3회까지는 확인을 해보기 위한 반복
				{
					System.out.print("설정할 비밀번호 입력 >>");
					pw = sc.nextLine(); //String 으로 입력하는 이유는 int 0524 로 하게 되면 0 은 없는걸로 치게 됨.
					
					System.out.print("비밀번호 확인 >> ");
					String ch_pw = sc.nextLine(); // pw == ch_pw 가 같은지 확인
					
					
					if(pw.equals(ch_pw)) // 만약 같다면 비밀번호 설정 완료.  // 여기서 문자열이기 때문에 equals 로 확인.
					{
						System.out.println("비밀번호 설정이 완료 되었습니다!");
						break; // 반복문 빠져나감 ( 현재 반복문이 for 문이기 때문에 빠져나가면 다시 while(ture) 으로 돌아감. )
					}else {	// 만약 비밀번호가 다르다면
						if(i == 2) { // 만약 3번째 틀렸을 때. ( 0, 1, 2 라서 i==2 일때면 3번째 틀린것이 됨 )
							System.out.println("비밀번호 횟수초과, 메인메뉴로 이동합니다!");
							break; // 다시 while(true). 메인메뉴로 이동
						}
						System.out.println("비밀번호가 일치하지 않습니다! 남은 기회 : "+ (2-i) + "회"); // 두번의 기회를 더 준다.
					}
				}
				
			}else if(choice == 2) { // 만약 choice 가 2라면
				
				if(myAccount.equals("")) // 계좌가 생성 되어 있는지부터 확인. 계좌가 myAccount 가 초기값. 즉 null과 같다면 계좌를 먼저 발급해라.
				{
					System.out.println("계좌를 먼저 발급해주세요");
					continue; // 계좌가 없기 때문에 for문을 나가서 메인메뉴(while)로 이동
				}
				// 입금하기
				System.out.print("입금할 계좌 입력 >> ");
				String inputAccount = sc.nextLine();
				
				// 발급계좌가 지금 입력한 계좌랑 같다면 
				// 계좌 입력 잘못 했을 경우 해당 계좌가 없습니다 출력 후 메인메뉴 이동
				if(myAccount.equals(inputAccount)) // 입력한 계좌랑 랜덤으로 발급받은 계좌가 같다면
				{
						for(int i=0; i<3; i++) // 비밀번호가 맞는지 3회까지만 반복해라.
						{
						//비밀번호를 입력 받아야한다.
							System.out.print("비밀번호 입력 >> ");
							String inputPw = sc.nextLine();
							if(pw.equals(inputPw)) // 입력받은 패스워드랑 생성한 패스워드가 같다면
							{ 
								System.out.print("입금 금액 입력 >>");
								int money = Integer.parseInt(sc.nextLine()); // Integer.parseInt = String -> int 형식으로 바꿈.
								wallet += money; // 입금 금액을 wallet 변수에 저장
								System.out.println(money+"원이 정상적으로 입금 되었습니다.");
								System.out.println("현재 통장 잔액 : " +wallet);
								break;
							}
							else
							{
								if(i==2) // 비밀번호 3회 틀렸을 때
								{
									System.out.println("비밀번호 오류 횟수 초과, 메인메뉴로 이동합니다");
									break;
								}
								System.out.println("비밀번호 오류, 기회 : "+(2-i)+"회");
							}
					}
				}
				else // 입력한 계좌랑 랜덤으로 발급받은 계좌가 다르다면
				{
					System.out.println("해당 계좌가 없습니다. 메인메뉴로 이동합니다");
				}
				
				
			}else if(choice == 3) { // 만약 choice 가 3이라면
				// 출금하기
				if(myAccount.equals("")) // 만약 랜덤으로 받은 계좌가 null 이라면 ( 즉, 계좌가 비어있다는 상태. 생성안된상태 )
				{
					System.out.println("계좌를 먼저 만들어주세요");
					continue; // for문을 빠져나가 다시 while(메인메뉴)로 이동
				}
				
				System.out.print("계좌번호 입력 >>");
				String inputAccount = sc.nextLine();
				
				if(myAccount.equals(inputAccount)) // 입력받은 계좌랑 랜덤으로 부여받은 계좌가 같다면
				{
					for(int i=0; i<3; i++) // 비밀번호 틀렸을 시 3회까지 확인
					{
						System.out.print("비밀번호 입력 >>");
						String inputPw = sc.nextLine();
						if(pw.equals(inputPw)) // 입력 비밀번호랑 생성비밀번호랑 같다면
						{
							System.out.print("출금 금액 입력 >> ");
							int money = Integer.parseInt(sc.nextLine()); 
							if(money <= wallet) // 총 지갑에 있는 금액보다 출금할려는 금액이 더 작다면
							{
								wallet -= money; // 지갑에서 돈을 뺀 남은 돈을 지갑에 다시 저장. (15000원에서 5000원 뺀 남은 돈을(10000원) 지갑에 다시 저장)
								System.out.println("출금 성공! 현재 남은 잔액 : " + wallet +"원");
								break;
							}
							else // 지갑에 있는 금액보다 출금할려는 금액이 더 크다면
							{
								//통장 잔액이 부족하다면 실패
								System.out.println("통장 잔액이 부족합니다. 현재 잔액 : " +wallet +"원이 남아있습니다.");
								break;
							}
						}
						else // 입력 비밀번호랑 생성 비밀번호랑 다르다면
						{
							if(i==2) // 3회까지 입력할 수 있게 기회를 준
							{
								//비밀번호 다르게 입력 시 실패
								System.out.println("비밀번호 입력 횟수 초과, 메인메뉴로 이동합니다");
								break;
							}
							System.out.println("비밀번호 오류, 기회 : "+(2-i) +"회");
						}
					}
					
				}
				else
				{
					//계좌번호 다르게 입력 시 실패
					System.out.println("해당 계좌가 존재하지 않습니다.");
				}
			}else if(choice == 4) {
				// 나가기
				System.out.println("시스템을 종료합니다.");
				break;
			}else {
				//잘못입력했을 경우
				System.out.println("잘못 입력했습니다. 다시 입력하세요.");
				System.out.println();
			}
			
			
		}// main menu 닫는 중괄호
		
	} 

}
