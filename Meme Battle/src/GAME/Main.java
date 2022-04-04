package GAME;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Random;

public class Main implements ImageObserver {
	private int picture = 0;
	private int x;
	private int y;
	private int xspeed;
	private int upheigth;
	private int attackwidth = 75 *2;
	private int attackheigth = 75 *2;
	private int runwidth = 75* 2,runheigth = 75 * 2;
	private int standwidth = 75 * 2,standheigth = 75 * 2;
	private int attacknum,attacknum1,attacknum2,attacknum3 = 0;
	private int m1;
	private Graphics g;
	private ArrayList<Monster> list;
	private ArrayList<Monster> list1;
	private ArrayList<Monster> list2;
	private ArrayList<Monster> list3;
	//private ArrayList<Boss> list4;
	private int score = 0;
	private BallListener bl;
	private Background backgroundpicture;
	private boolean right;
	private boolean left;
	private boolean up;
	private boolean down;
	private boolean j;
	private boolean k;
	private int backgroundpicturex = -800;     //看图片大小
	private Random random = new Random();
	private int l = random.nextInt(67);
	ImageIcon im1 = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\POP\\右移动.gif");//主角站立图片路径
	ImageIcon []ima2 = new ImageIcon[68];//主角右移图片路径
	ImageIcon []ima3 = new ImageIcon[68];//主角左移图片路径
	ImageIcon im4 = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\POP\\右移动.gif");
	ImageIcon im5 = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\POP\\当场去世.gif");
	ImageIcon [] ima4 = new ImageIcon[13];//右图片数组
	ImageIcon [] ima5 = new ImageIcon[13];//左图片数组
	
	{
		for(int i = 0;i <= 67;i++) {
			ima2[i] = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\POP\\→\\登场 " + i + ".png");
		}
		for(int i = 0;i <= 67;i++) {
			ima3[i] = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\POP\\←\\登场 " + i + ".png");
		}
		for(int i = 0;i <= 12;i++) {
			ima4[i] = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\PIPI\\→\\生气了嘛 " + i + ".png");//右打斗图附入
		}
		for(int i = 0;i <= 12;i++) {
			ima5[i] = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\PIPI\\←\\生气了嘛 " + i + ".png");//左打斗图附入
		}
	}
	
	public Main(int x,int y,int xspeed,int upheigth,Graphics g,ArrayList<Monster> list,
			ArrayList<Monster> list1,ArrayList<Monster> list2,ArrayList<Monster> list3,
			/*ArrayList<Boss> list4,*/BallListener bl) {
		this.x = x;
		this.y = y;
		this.xspeed = xspeed;
		this.upheigth = upheigth;
		this.g = g;
		this.list = list;
		this.list1 = list1;
		this.list2 = list2;
		this.list3 = list3;
		//this.list4 = list4;
		this.bl = bl;
	}
	
	public void setRight(boolean right) {
		this.right = right;
	}
	public void setLeft(boolean left) {
		this.left = left;
	}
	public void setUp(boolean up) {
		this.up = up;
	}
	public void setDown(boolean down) {
		this.down = down;
	}
	public void setJ(boolean j) {
		this.j = j;
	}
	public void setK(boolean k) {
		this.k = k;
	}
	public void setXspeed(int xspeed) {
		this.xspeed = xspeed;
	}
	public void setUpheigth(int upheigth) {
		this.upheigth = upheigth;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getbackgroundpicturex() {
		return backgroundpicturex;
	}
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
	public int getscore() {
		return score;
	}
	
	public void Drawmain(Graphics g) {
		try {
			g.setColor(Color.BLACK);
			g.drawString("得分超过20就将进入BOSS关！",0,75);
			//最左侧字符的基线位于此图形上下文坐标系统的 (x, y) 位置处。
			g.drawString("┑(￣Д ￣)┍ 加油咯~",0,50);
			g.drawString("目前得分：" + score,0,25);
			if(right) {
				g.drawImage(ima2[picture].getImage(),x,y,runwidth,runheigth,null);
			} else if(left) {
				g.drawImage(ima3[picture].getImage(),x,y,runwidth,runheigth,null);
			}else if(up){
				g.drawImage(im4.getImage(),x,y,runwidth,runheigth,null);
			}else if(down) {
				g.drawImage(im5.getImage(),x,y,runwidth,runheigth,null);
			}else if(j) {     //左攻击
				g.drawImage(ima4[picture].getImage(),x,y,attackwidth,attackheigth,null);
				picture++;
				while(picture == 12) {
					j = false;
					bl.setJ(false);
					picture = 0;
				}
			} else if(k) {
				g.drawImage(ima5[picture].getImage(),x,y,attackwidth,attackheigth,null);
				picture++;
				while(picture == 12) {
					k = false;
					bl.setK(false);
					picture = 0;
				}
			} else {
				g.drawImage(im1.getImage(),x,y,standwidth,standheigth,null);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Sweepmain(Graphics g) {
		backgroundpicture = new Background(backgroundpicturex,0,g);
		if(x <= 25 || x >= 1720) {     //人物到达边界时，背景反向滚动
			backgroundpicturex += -xspeed;
			if(backgroundpicturex >= -40) {
				backgroundpicturex = -40;
				backgroundpicture.setX(backgroundpicturex);
			} else if(backgroundpicturex <= -2000) {
				backgroundpicturex = -2000;
				backgroundpicture.setX(backgroundpicturex);
			} else {
				backgroundpicture.setX(backgroundpicturex);
			}
			backgroundpicture.Backgroundmove();
		} else {
			backgroundpicture.Backgroundmove();
		}	
	}
	
	public void mainmove() {
		x += xspeed;
		if(x - 25 <= 0 || x >= 400) {
			if(x - 25 <= 0) {
				x = 25;
			}
			if(x >= 1720) {
				x = 1720;
			}
		}
		y += upheigth;
		if(y - 25 <= 0 || y >= 500) {
			if(y - 25 <= 0) {
				y = 25;
			}
			if(y >= 500) {
				y = 500;
			}
		}
		for(int i = 0;i < list.size();i++) {
			Monster monster = (Monster) list.get(i);
			int attackx = this.x - monster.getX();
			if((j && attackx <= 100 && attackx>= 0) || (k && attackx <= 0 && attackx >= -100)) {
				list.remove(i);
				score = score + 3;
			}
		}
		for(int i = 0;i < list1.size();i++) {
			Monster monster1 = (Monster) list1.get(i);
			int attackx1 = this.x - monster1.getX();
			if((j && attackx1 <= 100 && attackx1>= 0) || (k && attackx1 <= 0 && attackx1 >= -100)) {
				attacknum1++;
				monster1.setAttacknum1(attacknum1);
				if(attacknum1 == 3) {
					list1.remove(i);
					score++;
				}else if(attacknum1 > 3){
					attacknum1 = 0;
				}
			}
		}
		for(int i = 0;i < list2.size();i++) {
			Monster monster2 = (Monster) list2.get(i);
			int attackx2 = this.x - monster2.getX();
			if((j && attackx2 <= 100 && attackx2>= 0) || (k && attackx2 <= 0 && attackx2 >= -100)) {
				attacknum2++;
				monster2.setAttacknum2(attacknum2);
				if(attacknum2 == 3) {
					list2.remove(i);
					score++;
				}else if(attacknum2 > 3){
					attacknum2 = 0;
				}
			}
		}
		for(int i = 0;i < list3.size();i++) {
			Monster monster3 = (Monster) list3.get(i);
			int attackx3 = this.x - monster3.getX();
			if((j && attackx3 <= 100 && attackx3>= 0) || (k && attackx3 <= 0 && attackx3 >= -100)) {
				attacknum3++;
				monster3.setAttacknum3(attacknum3);
				if(attacknum3 == 3) {
					list3.remove(i);
					score++;
				}else if(attacknum3 > 3){
					attacknum3 = 0;
				}
			}
		}
		/*for(int i = 0;i < list4.size();i++) {
			Boss boss = (Boss) list4.get(i);
			int attackx4 = this.x - boss.getX();
			if((j && attackx4 <= 100 && attackx4>= 0) || (k && attackx4 <= 0 && attackx4 >= -100)) {
				attacknum++;
				boss.setAttacknum(attacknum);
				if(attacknum == 3) {
					list3.remove(i);
				}
			}
		}*/
	}
	
	@Override
	public boolean imageUpdate(Image img,int infoflag,int x,int y,int width,int height) {
		return false;
	}
}
