package GAME;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Random;
/*Panel����ʵ��ImageObserver�ӿڣ�����Panel�����ӡ�implements ImageObserver����
��Panel�Ĺ��췽���г�ʼ��Buffer Image����Ȼ����Paint��������Graphics��DrawImage��������Observer����Ϊthis��*/
import java.util.ArrayList;

public class Boss implements ImageObserver {
	private int x,y,xspeed;     //������ֵ����꼰�ƶ��ٶ�
	int a = x,b = y;
	private int bosswidth = 100 * 2,bossheigth = 100 * 2;
	private int skillwidth1 = 20 * 2,skillheigth1 = 20 * 2;
	private int skillwidth = 100 * 2,skillheigth = 100 * 2;
	private int attacknum;
	private Graphics g;
	private ImageIcon bosspicture = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\BOSS\\Boss.gif");
	private ImageIcon bosspicture1 = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\BOSS\\Boss Skill.png");
	private ImageIcon bosspicture2 = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\BOSS\\Boss Skill1.gif");
	private ArrayList<Boss> list;
	private Random random = new Random();
	private int skillx = random.nextInt(700) + 100;
	private int skilly = random.nextInt(500) + 100;
	
	public int getX() {     //�ж�������������Ĵ���
		return x;
	}
	public void setAttacknum(int attacknum) {
		this.attacknum = attacknum;
	}
	
	public Boss(int x,int y,int xspeed,Graphics g,ArrayList<Boss> list) {
		this.x = x;
		this.y = y;
		this.xspeed = xspeed;
		this.g = g;
		this.list = list;
	}
	public void Drawbosspicture(Graphics g) {     //���ƹ���ͼ��
		g.drawImage(bosspicture.getImage(),x,y,bosswidth,bossheigth,null);//�����Ƿ�Ҫָ��Ϊthis
	}
	public void Move() {
		x += xspeed;     //����
		if(x - 25 <= 0 || x >= 1720) {     //��������߽緵���ƶ�
			xspeed = -xspeed;
		}
	}
	
	public void Skill1() {
		while (true) {
			for(int i = 1;i < 80;i++) {
				x = x + i * 10;
				y = y + i * 10;
				if(x >= 800 || x <= 0 || y >= 600 || y <= 0) {
					g.drawImage(bosspicture1.getImage(),a,b,skillwidth1,skillheigth1,null);
				}
				g.drawImage(bosspicture1.getImage(),x,y,skillwidth1,skillheigth1,null);
			}
		}
	}
	
	public void Skill() throws InterruptedException {
		Thread.sleep(10000);
		g.drawImage(bosspicture2.getImage(),skillx,skilly,skillwidth,skillheigth,null);
	}
	
	@Override
	public boolean imageUpdate(Image img,int infoflags,int x,int y,int wideth,int heigth) {
		return false;
	}//infoflags - ���б�־��λ OR �����Ľ����WIDTH��HEIGHT��PROPERTIES��SOMEBITS��FRAMEBITS��ALLBITS��ERROR��ABORT��
}//��� infoflags ָʾ����ȫ������ͼ���򷵻� false�����򷵻� true��
