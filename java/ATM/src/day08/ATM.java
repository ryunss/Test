package day08;

import java.util.Iterator; // �ݺ��� ? �̵� ã�ƺ���
import java.util.Random; // �����ο��� ����ϰڴ�.
import java.util.Scanner; // �Է��� ����ϰڴ�.

public class ATM {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // �Է� ����
		Random r = new Random(); // ���� ����
		System.out.println("�ڡ١ڡ�ATM��⸦ �����մϴ١ڡ١ڡ�");
		String myAccount = ""; // �߱޹��� ���¸� ������ ����
		String pw = ""; // �н����带 ������ ����
		int wallet = 0; // �� �ݾ��� ������ ����
		
		while(true) { // �����ϱ� ������ ���� �ݺ�
			System.out.println("--main menu--");
			System.out.println("1. ���°����ϱ�");
			System.out.println("2. �Ա��ϱ�");
			System.out.println("3. ����ϱ�");
			System.out.println("4. ������");
			System.out.print("�Է� >> ");
			int choice = Integer.parseInt(sc.nextLine()); // ���������� ������ �ٲٸ鼭 ���� ���� ���ÿ� ��ġ�ϱ� ����.
			if(choice == 1) { // �Է��� 1�� �Ǿ��� ��
				// ���� �����ϱ�
//				System.out.println(r.nextInt(100) + "-" + r.nextInt(10000) + "-" + r.nextInt(10000));
//				System.out.printf("%02d-%04d-%04d\n", r.nextInt(100), r.nextInt(10000), r.nextInt(10000));
				
				// String Ŭ���� �ȿ� �ִ� format()�̶�� �޼ҵ�, ������ printf()�� �Ȱ����� ���ڿ� ������ �����´ٴ� ���� ������.
				// ������ ���� ���ڿ��� ��ȯ�ϴ�(��������) �޼ҵ� - ���� ���¸� 1�� �Ա��� �� ���¶� ���ƾ���.
				myAccount = String.format("%02d-%04d-%04d", r.nextInt(100), r.nextInt(10000), r.nextInt(10000));
				                        // �������� �ο����� ���� %02d %04d %0d ���Ŀ� ���缭 �Էµǰ�, �� ���� myAccount �� �����ϰڴ�.
				System.out.println("�߱� ���� : " +myAccount); // ���� ���´� ������� ��Ÿ �� �� ���⶧���� myAccount �� ����� ���� ����ؼ� ���ڴ�.
				
				for(int i=0; i<3; i++) // ��й�ȣ ���� �� [��й�ȣ ������ Ȯ��] ��ġ�ϴ��� 3ȸ������ Ȯ���� �غ��� ���� �ݺ�
				{
					System.out.print("������ ��й�ȣ �Է� >>");
					pw = sc.nextLine(); //String ���� �Է��ϴ� ������ int 0524 �� �ϰ� �Ǹ� 0 �� ���°ɷ� ġ�� ��.
					
					System.out.print("��й�ȣ Ȯ�� >> ");
					String ch_pw = sc.nextLine(); // pw == ch_pw �� ������ Ȯ��
					
					
					if(pw.equals(ch_pw)) // ���� ���ٸ� ��й�ȣ ���� �Ϸ�.  // ���⼭ ���ڿ��̱� ������ equals �� Ȯ��.
					{
						System.out.println("��й�ȣ ������ �Ϸ� �Ǿ����ϴ�!");
						break; // �ݺ��� �������� ( ���� �ݺ����� for ���̱� ������ ���������� �ٽ� while(ture) ���� ���ư�. )
					}else {	// ���� ��й�ȣ�� �ٸ��ٸ�
						if(i == 2) { // ���� 3��° Ʋ���� ��. ( 0, 1, 2 �� i==2 �϶��� 3��° Ʋ������ �� )
							System.out.println("��й�ȣ Ƚ���ʰ�, ���θ޴��� �̵��մϴ�!");
							break; // �ٽ� while(true). ���θ޴��� �̵�
						}
						System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�! ���� ��ȸ : "+ (2-i) + "ȸ"); // �ι��� ��ȸ�� �� �ش�.
					}
				}
				
			}else if(choice == 2) { // ���� choice �� 2���
				
				if(myAccount.equals("")) // ���°� ���� �Ǿ� �ִ������� Ȯ��. ���°� myAccount �� �ʱⰪ. �� null�� ���ٸ� ���¸� ���� �߱��ض�.
				{
					System.out.println("���¸� ���� �߱����ּ���");
					continue; // ���°� ���� ������ for���� ������ ���θ޴�(while)�� �̵�
				}
				// �Ա��ϱ�
				System.out.print("�Ա��� ���� �Է� >> ");
				String inputAccount = sc.nextLine();
				
				// �߱ް��°� ���� �Է��� ���¶� ���ٸ� 
				// ���� �Է� �߸� ���� ��� �ش� ���°� �����ϴ� ��� �� ���θ޴� �̵�
				if(myAccount.equals(inputAccount)) // �Է��� ���¶� �������� �߱޹��� ���°� ���ٸ�
				{
						for(int i=0; i<3; i++) // ��й�ȣ�� �´��� 3ȸ������ �ݺ��ض�.
						{
						//��й�ȣ�� �Է� �޾ƾ��Ѵ�.
							System.out.print("��й�ȣ �Է� >> ");
							String inputPw = sc.nextLine();
							if(pw.equals(inputPw)) // �Է¹��� �н������ ������ �н����尡 ���ٸ�
							{ 
								System.out.print("�Ա� �ݾ� �Է� >>");
								int money = Integer.parseInt(sc.nextLine()); // Integer.parseInt = String -> int �������� �ٲ�.
								wallet += money; // �Ա� �ݾ��� wallet ������ ����
								System.out.println(money+"���� ���������� �Ա� �Ǿ����ϴ�.");
								System.out.println("���� ���� �ܾ� : " +wallet);
								break;
							}
							else
							{
								if(i==2) // ��й�ȣ 3ȸ Ʋ���� ��
								{
									System.out.println("��й�ȣ ���� Ƚ�� �ʰ�, ���θ޴��� �̵��մϴ�");
									break;
								}
								System.out.println("��й�ȣ ����, ��ȸ : "+(2-i)+"ȸ");
							}
					}
				}
				else // �Է��� ���¶� �������� �߱޹��� ���°� �ٸ��ٸ�
				{
					System.out.println("�ش� ���°� �����ϴ�. ���θ޴��� �̵��մϴ�");
				}
				
				
			}else if(choice == 3) { // ���� choice �� 3�̶��
				// ����ϱ�
				if(myAccount.equals("")) // ���� �������� ���� ���°� null �̶�� ( ��, ���°� ����ִٴ� ����. �����ȵȻ��� )
				{
					System.out.println("���¸� ���� ������ּ���");
					continue; // for���� �������� �ٽ� while(���θ޴�)�� �̵�
				}
				
				System.out.print("���¹�ȣ �Է� >>");
				String inputAccount = sc.nextLine();
				
				if(myAccount.equals(inputAccount)) // �Է¹��� ���¶� �������� �ο����� ���°� ���ٸ�
				{
					for(int i=0; i<3; i++) // ��й�ȣ Ʋ���� �� 3ȸ���� Ȯ��
					{
						System.out.print("��й�ȣ �Է� >>");
						String inputPw = sc.nextLine();
						if(pw.equals(inputPw)) // �Է� ��й�ȣ�� ������й�ȣ�� ���ٸ�
						{
							System.out.print("��� �ݾ� �Է� >> ");
							int money = Integer.parseInt(sc.nextLine()); 
							if(money <= wallet) // �� ������ �ִ� �ݾ׺��� ����ҷ��� �ݾ��� �� �۴ٸ�
							{
								wallet -= money; // �������� ���� �� ���� ���� ������ �ٽ� ����. (15000������ 5000�� �� ���� ����(10000��) ������ �ٽ� ����)
								System.out.println("��� ����! ���� ���� �ܾ� : " + wallet +"��");
								break;
							}
							else // ������ �ִ� �ݾ׺��� ����ҷ��� �ݾ��� �� ũ�ٸ�
							{
								//���� �ܾ��� �����ϴٸ� ����
								System.out.println("���� �ܾ��� �����մϴ�. ���� �ܾ� : " +wallet +"���� �����ֽ��ϴ�.");
								break;
							}
						}
						else // �Է� ��й�ȣ�� ���� ��й�ȣ�� �ٸ��ٸ�
						{
							if(i==2) // 3ȸ���� �Է��� �� �ְ� ��ȸ�� ��
							{
								//��й�ȣ �ٸ��� �Է� �� ����
								System.out.println("��й�ȣ �Է� Ƚ�� �ʰ�, ���θ޴��� �̵��մϴ�");
								break;
							}
							System.out.println("��й�ȣ ����, ��ȸ : "+(2-i) +"ȸ");
						}
					}
					
				}
				else
				{
					//���¹�ȣ �ٸ��� �Է� �� ����
					System.out.println("�ش� ���°� �������� �ʽ��ϴ�.");
				}
			}else if(choice == 4) {
				// ������
				System.out.println("�ý����� �����մϴ�.");
				break;
			}else {
				//�߸��Է����� ���
				System.out.println("�߸� �Է��߽��ϴ�. �ٽ� �Է��ϼ���.");
				System.out.println();
			}
			
			
		}// main menu �ݴ� �߰�ȣ
		
	} 

}
