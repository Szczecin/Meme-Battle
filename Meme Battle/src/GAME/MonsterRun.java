package GAME;

import java.util.Random;

public class MonsterRun implements Runnable {     //�����߳�
	int x;
	int X,Y;
	BallListener bl;
	private Random random = new Random();
	
	public MonsterRun(BallListener bl) {
		this.bl = bl;
	}
	public void run() {
		while(bl.getStop()) {     //�������߳��Ƿ����ִ��
			System.out.println();
			if(bl.getXstop() == true) {     //����˾���
				try {
					System.out.println("�������Ϯ");
					x = random.nextInt(350) + 50;     //��x�����ֹ���
					X = random.nextInt(700) + 100;    //��(X,Y)������BOSS
					Y = random.nextInt(500) + 100;
					bl.monster(x);
					/*if(bl.next = true) {
						bl.boss(X,Y);
					}*/
					Thread.sleep(15000);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}//�������д�ӡ�쳣��Ϣ�ڳ����г����λ�ü�ԭ��
			}
		}
	}
}
