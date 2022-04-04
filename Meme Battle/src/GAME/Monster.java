package GAME;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
/*Panel����ʵ��ImageObserver�ӿڣ�����Panel�����ӡ�implements ImageObserver����
��Panel�Ĺ��췽���г�ʼ��Buffer Image����Ȼ����Paint��������Graphics��DrawImage��������Observer����Ϊthis��*/
import java.util.ArrayList;

public class Monster implements ImageObserver {
	private int x,y,xspeed;     //������ֵ����꼰�ƶ��ٶ�
	private int monsterwidth = 90 * 2,monsterheigth = 90 * 2;
	private int attacknum1,attacknum2,attacknum3;
	private Graphics g;
	private ImageIcon monsterpicture = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\����\\������ɫ����\\0.gif");
	private ImageIcon monsterpicture1 = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\����\\��������\\0.jpg");
	private ImageIcon monsterpicture2 = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\����\\��������\\1.jpg");
	private ImageIcon monsterpicture3 = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\����\\��������\\2.jpg");
	private ImageIcon monsterpicture4 = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\����\\����\\0.jpg");
	private ImageIcon monsterpicture5 = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\����\\����\\1.jpg");
	private ImageIcon monsterpicture6 = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\����\\����\\2.jpg");
	private ImageIcon monsterpicture7 = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\����\\����������\\0.jpg");
	private ImageIcon monsterpicture8 = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\����\\����������\\1.jpg");
	private ImageIcon monsterpicture9 = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\����\\����������\\2.jpg");
	private ArrayList<Monster> list;
	
	public int getX() {     //�ж�������������Ĵ���
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
	public void Drawmonsterpicture(Graphics g) {     //���ƹ���ͼ��
		g.drawImage(monsterpicture.getImage(),x,y,monsterwidth,monsterheigth,null);//�����Ƿ�Ҫָ��Ϊthis
	}
	public void Drawmonsterpicture1(Graphics g) {     //���ƹ���ͼ��
		g.drawImage(monsterpicture1.getImage(),x,y,monsterwidth,monsterheigth,null);//�����Ƿ�Ҫָ��Ϊthis
		if(attacknum1 == 1) {
			g.drawImage(monsterpicture2.getImage(),x,y,monsterwidth,monsterheigth,null);
		}else if(attacknum1 == 2) {
			g.drawImage(monsterpicture3.getImage(),x,y,monsterwidth,monsterheigth,null);
		}
	}
	public void Drawmonsterpicture2(Graphics g) {     //���ƹ���ͼ��
		g.drawImage(monsterpicture4.getImage(),x,y,monsterwidth,monsterheigth,null);//�����Ƿ�Ҫָ��Ϊthis
		if(attacknum2 == 1) {
			g.drawImage(monsterpicture5.getImage(),x,y,monsterwidth,monsterheigth,null);
		}else if(attacknum2 == 2) {
			g.drawImage(monsterpicture6.getImage(),x,y,monsterwidth,monsterheigth,null);
		}
	}
	public void Drawmonsterpicture3(Graphics g) {     //���ƹ���ͼ��
		g.drawImage(monsterpicture7.getImage(),x,y,monsterwidth,monsterheigth,null);//�����Ƿ�Ҫָ��Ϊthis
		if(attacknum3 == 1) {
			g.drawImage(monsterpicture8.getImage(),x,y,monsterwidth,monsterheigth,null);
		}else if(attacknum3 == 2) {
			g.drawImage(monsterpicture9.getImage(),x,y,monsterwidth,monsterheigth,null);
		}
	}
	public void Move() {
		x += xspeed;     //����
		if(x - 25 <= 0 || x >= 1720) {     //��������߽緵���ƶ�
			xspeed = -xspeed;
		}
	}
	
	@Override
	public boolean imageUpdate(Image img,int infoflags,int x,int y,int wideth,int heigth) {
		return false;
	}//infoflags - ���б�־��λ OR �����Ľ����WIDTH��HEIGHT��PROPERTIES��SOMEBITS��FRAMEBITS��ALLBITS��ERROR��ABORT��
}//��� infoflags ָʾ����ȫ������ͼ���򷵻� false�����򷵻� true��
