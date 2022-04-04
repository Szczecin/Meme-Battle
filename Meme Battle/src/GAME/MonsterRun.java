package GAME;

import java.util.Random;

public class MonsterRun implements Runnable {     //创建线程
	int x;
	int X,Y;
	BallListener bl;
	private Random random = new Random();
	
	public MonsterRun(BallListener bl) {
		this.bl = bl;
	}
	public void run() {
		while(bl.getStop()) {     //监听器线程是否继续执行
			System.out.println();
			if(bl.getXstop() == true) {     //获得了距离
				try {
					System.out.println("表情包来袭");
					x = random.nextInt(350) + 50;     //在x处出现怪物
					X = random.nextInt(700) + 100;    //在(X,Y)处出现BOSS
					Y = random.nextInt(500) + 100;
					bl.monster(x);
					/*if(bl.next = true) {
						bl.boss(X,Y);
					}*/
					Thread.sleep(15000);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}//在命令行打印异常信息在程序中出错的位置及原因。
			}
		}
	}
}
