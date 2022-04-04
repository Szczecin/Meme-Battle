package GAME;

import javax.swing.*;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;     //异常捕捉
import java.net.URI;     //对Internet资源的引用
import java.net.URL;     //直接读取网络资源
import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("deprecation")     //忽视deprecation产生的警告
public class BallListener extends MouseAdapter implements KeyListener,Runnable {
	Graphics g;
	private boolean stop = true;     //线程开始
	private boolean xstop = false;     //暂停
	private Monster monster;
	int m;
	int m1;
	private int m2;
	int m3;
	int m4;
	int mainxspeed = 0;     //主角水平速度
	int mainupheigth = 0;
	//boolean next;
	private boolean right,left,up,down,j,k;     //左右移动，攻击
	ArrayList <Monster> list = new ArrayList<>();     //记录怪物数组
	ArrayList <Monster> list1 = new ArrayList<>();
	ArrayList <Monster> list2 = new ArrayList<>();
	ArrayList <Monster> list3 = new ArrayList<>();
	//ArrayList <Boss> list4 = new ArrayList<>();
	private Random random = new Random();
	private int x,y;
	private Main main = new Main(0,500,mainxspeed,mainupheigth,g,list,list1,list2,list3,/*list4,*/this);     //主角参数
	private Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private BufferedImage buffer;     //缓冲绘画
	private Graphics backgroundpen;
    private ImageIcon backgroundpicture = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\背景\\0.png");//背景图路径
	
	public BallListener(JFrame jf) {
		buffer = new BufferedImage(jf.getWidth(),jf.getHeight(),BufferedImage.TYPE_4BYTE_ABGR);
		/*public static final int TYPE_4BYTE_ABGR表示一个具有 8 位 RGBA 颜色分量的图像，具有用 3 字节存储的 Blue、Green 和 Red 颜色以及 1 字节的 alpha。
		 * 该图像具有带 alpha 的 ComponentColorModel。认为此图像中的颜色数据没有预乘以 alpha。
		 按照每个像素中字节地址从低到高的顺序 A、B、G、R 将字节数据插入单个字节数组中。*/
		backgroundpen = buffer.getGraphics();
	}
	public void setG(Graphics g) {
		this.g = g;
	}
	public void setStop(boolean stop) {     //是否通关
		this.stop = stop;
	}
	public boolean getStop() {
		return stop;
	}
	public void setJ(boolean j) {
		this.j = j;
	}
	public void setK(boolean k) {
		this.k = k;
	}
	public void setM(int m) {
		this.m = m;
	}
	public void setM1(int m1) {
		this.m1 = m1;
	}
	public void setM2(int m2) {
		this.m2 = m2;
	}
	/*public void setXstop(boolean xstop) {
		this.xstop = xstop;
	}*/
	public boolean getXstop() {
		return xstop;
	}
	
	public void mousePressed(MouseEvent e) {
	}//鼠标划过不触发事件
	
	public void monster(int x) {     //获取MonsterRun传递来的随机速度和水平坐标
		Monster monster = new Monster(x,500,random.nextInt(20) - 10,g,list);
		Monster monster1 = new Monster(x,500,random.nextInt(20) - 10,g,list1);
		Monster monster2 = new Monster(x,500,random.nextInt(20) - 10,g,list2);
		Monster monster3 = new Monster(x,500,random.nextInt(20) - 10,g,list3);
		list.add(monster);
		list1.add(monster1);
		list2.add(monster2);
		list3.add(monster3);
		//monster.Drawmonsterpicture(g);
		//monster.Move();
		if(list.size() + list1.size() + list2.size() + list3.size() >= 20) {
			Object[] options ={ "继续无聊的时光", "不选择浪费生命" };  //自定义按钮上的文字
			m2 = JOptionPane.showOptionDialog(null, "灰常抱歉，你没能战胜表情包","诶呀，表情包太多啦！QAQ",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(m2 == 1) {
				System.exit(0);
			}else {
				for(int i = 0;i < list.size();i++) {     
					list.remove(i);
				}
				for(int i = 0;i < list1.size();i++) {     
					list1.remove(i);
				}
				for(int i = 0;i < list2.size();i++) {     
					list2.remove(i);
				}
				for(int i = 0;i < list3.size();i++) {     
					list3.remove(i);
				}
				main.setScore(0);
				xstop = false;
				stop = true;
			}
		}
		if(main.getscore() >= 20 ) {
			Object[] options ={ "继续无聊的时光", "不选择浪费生命" };  //自定义按钮上的文字
			m1 = JOptionPane.showOptionDialog(null, "恭喜通过第一关", "QWQ",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(m1 == 1) {
				System.exit(0);
			}
			//next = true;
		}
	}
	
	/*public void boss(int X,int Y) {
		Boss boss = new Boss(X,Y,random.nextInt(30) - 10,g,list4);
		list4.add(boss);
		if((boss.a == main.getx())&&(boss.b == main.gety())) {
			Object[] options ={ "继续无聊时光", "不选择浪费生命" };  //自定义按钮上的文字
			m4 = JOptionPane.showOptionDialog(null, "你被滑稽击败啦","QAQ",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(m4 == 1) {
				System.exit(0);
			}else {
				for(int i = 0;i < list4.size();i++) {     //重新开始
					list4.remove(i);
				}
				xstop = false;
				stop = true;
			}
		}
		if(list4.size() == 0) {
			Object[] options ={ "→小彩蛋←", "不选择浪费生命" };  //自定义按钮上的文字
			m3 = JOptionPane.showOptionDialog(null, "tql wsl","QWQ",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(m3 == 1) {
				System.exit(0);
			}
		}
	}*/
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int Key = e.getKeyCode();
		switch(Key) {
		case KeyEvent.VK_A:
			if(mainxspeed >= -16) {     //最大速度
				mainxspeed += -1;
				main.setXspeed(mainxspeed);
				left = true;
				main.setLeft(left);
			} break;
		case KeyEvent.VK_D:
			if(mainxspeed <= 16) {
				mainxspeed += 1;
				main.setXspeed(mainxspeed);
				right = true;
				main.setRight(right);
			} break;
		case KeyEvent.VK_W:
			if(mainupheigth >= -50 ) {     //y是反的，越大越下
				mainupheigth = -(random.nextInt(30) + 20);
				main.setUpheigth(mainupheigth);
				up = true;
				main.setUp(up);
			}break;
		case KeyEvent.VK_S:
			down = true;
			main.setDown(down);
		case KeyEvent.VK_J:
			j = true;
			main.setJ(j);
			break;
		case KeyEvent.VK_K:
			k = true;
			main.setK(k);
			break;
		case KeyEvent.VK_SPACE:     //开始游戏
			if(m == 0) {
				xstop = true;
			}
			break;
		case KeyEvent.VK_ENTER:
			for(int i = 0;i < list.size();i++) {     //重新开始
				list.remove(i);
			}
			for(int i = 0;i < list1.size();i++) {     //重新开始
				list1.remove(i);
			}
			for(int i = 0;i < list2.size();i++) {     //重新开始
				list2.remove(i);
			}
			for(int i = 0;i < list3.size();i++) {     //重新开始
				list3.remove(i);
			}
			main.setScore(0);
			xstop = false;
			stop = true;
			default:break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int Key = e.getKeyCode();
		switch(Key) {
		case KeyEvent.VK_A:
			left = false;
			mainxspeed = 0;
			main.setXspeed(mainxspeed);
			main.setLeft(left);
			break;
		case KeyEvent.VK_D:
			right = false;
			mainxspeed = 0;
			main.setXspeed(mainxspeed);
			main.setRight(right);
			break;
		case KeyEvent.VK_W:
			mainupheigth = -mainupheigth;
			main.setUpheigth(mainupheigth);
			up = false;
			main.setUp(up);
		case KeyEvent.VK_S:
			down = false;
			main.setDown(down);
		case KeyEvent.VK_J:
			j = false;
			main.setJ(j);
		case KeyEvent.VK_K:
			k = false;
			main.setK(k);
		default:break;
		}
	}
	
	@Override
	public void run() {
		File music = null;
		try {
			music = new File("H:\\FFOutput\\MAN WITH A MISSION - database feat.TAKUMA(10-FEET) [高质量].wav");
			AudioClip BGM;
			BGM = Applet.newAudioClip(music.toURI().toURL());
			BGM.loop();
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		while(stop) {
			if(xstop == false) {
				g.drawImage(backgroundpicture.getImage(),main.getbackgroundpicturex(),y,ScreenSize.width,ScreenSize.height,null);
				g.drawImage(backgroundpicture.getImage(),main.getbackgroundpicturex() + ScreenSize.width,y,ScreenSize.width,ScreenSize.height,null);
			} else {
				try {
					System.out.println("痛击表情包");
					main.Sweepmain(backgroundpen);     //擦除前一个图像
					main.mainmove();
					main.Drawmain(backgroundpen);
					for (int i = 0;i < list.size();i++) {
						Monster monster = list.get(i);
						monster.Move();
						monster.Drawmonsterpicture(backgroundpen);
					}
					for (int i = 0;i < list1.size();i++) {
						Monster monster1 = list1.get(i);
						monster1.Move();
						monster1.Drawmonsterpicture1(backgroundpen);
					}
					for (int i = 0;i < list2.size();i++) {
						Monster monster2 = list2.get(i);
						monster2.Move();
						monster2.Drawmonsterpicture2(backgroundpen);
					}
					for (int i = 0;i < list3.size();i++) {
						Monster monster3 = list3.get(i);
						monster3.Move();
						monster3.Drawmonsterpicture3(backgroundpen);
					}
					/*for (int i = 0;i < list4.size();i++) {
						Boss boss = list4.get(i);
						boss.Move();
						boss.Drawbosspicture(backgroundpen);
					}*/
					g.drawImage(buffer,0,0,null);     //绘出缓冲带图像
					Thread.sleep(80);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
