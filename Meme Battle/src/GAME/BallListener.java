package GAME;

import javax.swing.*;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;     //�쳣��׽
import java.net.URI;     //��Internet��Դ������
import java.net.URL;     //ֱ�Ӷ�ȡ������Դ
import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("deprecation")     //����deprecation�����ľ���
public class BallListener extends MouseAdapter implements KeyListener,Runnable {
	Graphics g;
	private boolean stop = true;     //�߳̿�ʼ
	private boolean xstop = false;     //��ͣ
	private Monster monster;
	int m;
	int m1;
	private int m2;
	int m3;
	int m4;
	int mainxspeed = 0;     //����ˮƽ�ٶ�
	int mainupheigth = 0;
	//boolean next;
	private boolean right,left,up,down,j,k;     //�����ƶ�������
	ArrayList <Monster> list = new ArrayList<>();     //��¼��������
	ArrayList <Monster> list1 = new ArrayList<>();
	ArrayList <Monster> list2 = new ArrayList<>();
	ArrayList <Monster> list3 = new ArrayList<>();
	//ArrayList <Boss> list4 = new ArrayList<>();
	private Random random = new Random();
	private int x,y;
	private Main main = new Main(0,500,mainxspeed,mainupheigth,g,list,list1,list2,list3,/*list4,*/this);     //���ǲ���
	private Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private BufferedImage buffer;     //����滭
	private Graphics backgroundpen;
    private ImageIcon backgroundpicture = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\����\\0.png");//����ͼ·��
	
	public BallListener(JFrame jf) {
		buffer = new BufferedImage(jf.getWidth(),jf.getHeight(),BufferedImage.TYPE_4BYTE_ABGR);
		/*public static final int TYPE_4BYTE_ABGR��ʾһ������ 8 λ RGBA ��ɫ������ͼ�񣬾����� 3 �ֽڴ洢�� Blue��Green �� Red ��ɫ�Լ� 1 �ֽڵ� alpha��
		 * ��ͼ����д� alpha �� ComponentColorModel����Ϊ��ͼ���е���ɫ����û��Ԥ���� alpha��
		 ����ÿ���������ֽڵ�ַ�ӵ͵��ߵ�˳�� A��B��G��R ���ֽ����ݲ��뵥���ֽ������С�*/
		backgroundpen = buffer.getGraphics();
	}
	public void setG(Graphics g) {
		this.g = g;
	}
	public void setStop(boolean stop) {     //�Ƿ�ͨ��
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
	}//��껮���������¼�
	
	public void monster(int x) {     //��ȡMonsterRun������������ٶȺ�ˮƽ����
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
			Object[] options ={ "�������ĵ�ʱ��", "��ѡ���˷�����" };  //�Զ��尴ť�ϵ�����
			m2 = JOptionPane.showOptionDialog(null, "�ҳ���Ǹ����û��սʤ�����","��ѽ�������̫������QAQ",
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
			Object[] options ={ "�������ĵ�ʱ��", "��ѡ���˷�����" };  //�Զ��尴ť�ϵ�����
			m1 = JOptionPane.showOptionDialog(null, "��ϲͨ����һ��", "QWQ",
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
			Object[] options ={ "��������ʱ��", "��ѡ���˷�����" };  //�Զ��尴ť�ϵ�����
			m4 = JOptionPane.showOptionDialog(null, "�㱻����������","QAQ",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(m4 == 1) {
				System.exit(0);
			}else {
				for(int i = 0;i < list4.size();i++) {     //���¿�ʼ
					list4.remove(i);
				}
				xstop = false;
				stop = true;
			}
		}
		if(list4.size() == 0) {
			Object[] options ={ "��С�ʵ���", "��ѡ���˷�����" };  //�Զ��尴ť�ϵ�����
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
			if(mainxspeed >= -16) {     //����ٶ�
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
			if(mainupheigth >= -50 ) {     //y�Ƿ��ģ�Խ��Խ��
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
		case KeyEvent.VK_SPACE:     //��ʼ��Ϸ
			if(m == 0) {
				xstop = true;
			}
			break;
		case KeyEvent.VK_ENTER:
			for(int i = 0;i < list.size();i++) {     //���¿�ʼ
				list.remove(i);
			}
			for(int i = 0;i < list1.size();i++) {     //���¿�ʼ
				list1.remove(i);
			}
			for(int i = 0;i < list2.size();i++) {     //���¿�ʼ
				list2.remove(i);
			}
			for(int i = 0;i < list3.size();i++) {     //���¿�ʼ
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
			music = new File("H:\\FFOutput\\MAN WITH A MISSION - database feat.TAKUMA(10-FEET) [������].wav");
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
					System.out.println("ʹ�������");
					main.Sweepmain(backgroundpen);     //����ǰһ��ͼ��
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
					g.drawImage(buffer,0,0,null);     //��������ͼ��
					Thread.sleep(80);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
