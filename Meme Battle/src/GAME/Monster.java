package GAME;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
/*Panel可以实现ImageObserver接口，所以Panel类后添加“implements ImageObserver”，
在Panel的构造方法中初始化Buffer Image对象，然后在Paint语句中添加Graphics的DrawImage方法，其Observer参数为this。*/
import java.util.ArrayList;

public class Monster implements ImageObserver {
	private int x,y,xspeed;     //怪物出现的坐标及移动速度
	private int monsterwidth = 90 * 2,monsterheigth = 90 * 2;
	private int attacknum1,attacknum2,attacknum3;
	private Graphics g;
	private ImageIcon monsterpicture = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\北方\\看我脸色行事\\0.gif");
	private ImageIcon monsterpicture1 = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\北方\\而你们呢\\0.jpg");
	private ImageIcon monsterpicture2 = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\北方\\而你们呢\\1.jpg");
	private ImageIcon monsterpicture3 = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\北方\\而你们呢\\2.jpg");
	private ImageIcon monsterpicture4 = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\北方\\你走\\0.jpg");
	private ImageIcon monsterpicture5 = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\北方\\你走\\1.jpg");
	private ImageIcon monsterpicture6 = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\北方\\你走\\2.jpg");
	private ImageIcon monsterpicture7 = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\北方\\是在下输了\\0.jpg");
	private ImageIcon monsterpicture8 = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\北方\\是在下输了\\1.jpg");
	private ImageIcon monsterpicture9 = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\北方\\是在下输了\\2.jpg");
	private ArrayList<Monster> list;
	
	public int getX() {     //判断人物与怪物距离的传递
		return x;
	}
	public void setAttacknum1(int attacknum1) {
		this.attacknum1 = attacknum1;
	}
	public void setAttacknum2(int attacknum2) {
		this.attacknum2 = attacknum2;
	}
	public void setAttacknum3(int attacknum3) {
		this.attacknum3 = attacknum3;
	}
	
	public Monster(int x,int y,int xspeed,Graphics g,ArrayList<Monster> list) {
		this.x = x;
		this.y = y;
		this.xspeed = xspeed;
		this.g = g;
		this.list = list;
	}
	public void Drawmonsterpicture(Graphics g) {     //绘制怪物图像
		g.drawImage(monsterpicture.getImage(),x,y,monsterwidth,monsterheigth,null);//看看是否要指定为this
	}
	public void Drawmonsterpicture1(Graphics g) {     //绘制怪物图像
		g.drawImage(monsterpicture1.getImage(),x,y,monsterwidth,monsterheigth,null);//看看是否要指定为this
		if(attacknum1 == 1) {
			g.drawImage(monsterpicture2.getImage(),x,y,monsterwidth,monsterheigth,null);
		}else if(attacknum1 == 2) {
			g.drawImage(monsterpicture3.getImage(),x,y,monsterwidth,monsterheigth,null);
		}
	}
	public void Drawmonsterpicture2(Graphics g) {     //绘制怪物图像
		g.drawImage(monsterpicture4.getImage(),x,y,monsterwidth,monsterheigth,null);//看看是否要指定为this
		if(attacknum2 == 1) {
			g.drawImage(monsterpicture5.getImage(),x,y,monsterwidth,monsterheigth,null);
		}else if(attacknum2 == 2) {
			g.drawImage(monsterpicture6.getImage(),x,y,monsterwidth,monsterheigth,null);
		}
	}
	public void Drawmonsterpicture3(Graphics g) {     //绘制怪物图像
		g.drawImage(monsterpicture7.getImage(),x,y,monsterwidth,monsterheigth,null);//看看是否要指定为this
		if(attacknum3 == 1) {
			g.drawImage(monsterpicture8.getImage(),x,y,monsterwidth,monsterheigth,null);
		}else if(attacknum3 == 2) {
			g.drawImage(monsterpicture9.getImage(),x,y,monsterwidth,monsterheigth,null);
		}
	}
	public void Move() {
		x += xspeed;     //加速
		if(x - 25 <= 0 || x >= 1720) {     //碰到界面边界返回移动
			xspeed = -xspeed;
		}
	}
	
	@Override
	public boolean imageUpdate(Image img,int infoflags,int x,int y,int wideth,int heigth) {
		return false;
	}//infoflags - 下列标志按位 OR 运算后的结果：WIDTH、HEIGHT、PROPERTIES、SOMEBITS、FRAMEBITS、ALLBITS、ERROR、ABORT。
}//如果 infoflags 指示已完全加载了图像，则返回 false；否则返回 true。
