package GAME;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Random;
/*Panel可以实现ImageObserver接口，所以Panel类后添加“implements ImageObserver”，
在Panel的构造方法中初始化Buffer Image对象，然后在Paint语句中添加Graphics的DrawImage方法，其Observer参数为this。*/
import java.util.ArrayList;

public class Boss implements ImageObserver {
	private int x,y,xspeed;     //怪物出现的坐标及移动速度
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
	
	public int getX() {     //判断人物与怪物距离的传递
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
	public void Drawbosspicture(Graphics g) {     //绘制怪物图像
		g.drawImage(bosspicture.getImage(),x,y,bosswidth,bossheigth,null);//看看是否要指定为this
	}
	public void Move() {
		x += xspeed;     //加速
		if(x - 25 <= 0 || x >= 1720) {     //碰到界面边界返回移动
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
	}//infoflags - 下列标志按位 OR 运算后的结果：WIDTH、HEIGHT、PROPERTIES、SOMEBITS、FRAMEBITS、ALLBITS、ERROR、ABORT。
}//如果 infoflags 指示已完全加载了图像，则返回 false；否则返回 true。
