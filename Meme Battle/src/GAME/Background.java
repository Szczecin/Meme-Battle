package GAME;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Background implements ImageObserver {
	private int x;     //������ʼ����
	private int y;
	private Graphics g;
	private Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private ImageIcon backgroundpicture = new ImageIcon("G:\\Java World!\\Meme Battle\\source material\\����\\0.png");//����ͼ
	
	public Background(int x,int y,Graphics g) {
		this.x = x;
		this.y = y;
		this.g = g;
	}
	
	public void setX(int x) {     //���������Ĵ��ݾ���
		this.x = x;
	}
	
	public void Backgroundmove() {
		System.out.println(x + " ");
		g.drawImage(backgroundpicture.getImage(),x,y,ScreenSize.width,ScreenSize.height,null);
		g.drawImage(backgroundpicture.getImage(),x + ScreenSize.width,y,ScreenSize.width,ScreenSize.height,null);
	}
	
	@Override
	public boolean imageUpdate(Image img,int infoflags,int x,int y,int wideth,int heigth) {
		return false;
	}
}
