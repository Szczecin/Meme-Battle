package GAME;

import javax.swing.*;
import java.awt.*;

public class Ball extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//serialVersionUID���������л�ʱ���ְ汾�ļ����ԣ����ڰ汾����ʱ�����л��Ա��ֶ����Ψһ�ԡ�
	private Graphics g;
	
	Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
	/*Dimension ���װ��������������Ŀ�Ⱥ͸߶ȣ���ȷ����������
	�����������ĳ�����Թ������� Component ���LayoutManager �ӿڶ����һЩ���������� Dimension ����*/
	
	public void Panel() {     //���ڻ���
		JFrame jf = new JFrame();
		jf.setSize(ScreenSize.width,ScreenSize.height);
		jf.setTitle("�������ս����");
		
		jf.setDefaultCloseOperation(3);
		/*setDefaultCloseOperation(int operation)�������û��ڴ˴����Ϸ��� "close" ʱĬ��ִ�еĲ�����
		 * Ϊ��0����DO_NOTHING_ON_CLOSE����ִ���κβ�����
		 * Ϊ��1����HIDE_ON_CLOSE������������ע��� WindowListener ������Զ����ظô��塣
		 * Ϊ��2����DISPOSE_ON_CLOSE������������ע�� WindowListener �Ķ�����Զ����ز��ͷŸô��塣
		 Ϊ��3��EXIT_ON_CLOSE��ʹ�� System exit �����˳�Ӧ�ó���*/
		
		jf.setLocationRelativeTo(null);     //���ô������ָ�������λ��
		jf.getContentPane().setBackground(Color.BLUE);
		//JFrame ��һ�� Content Pane����������ʾ��������������������� Content Pane �С�
		jf.setResizable(false);     //Frame���ɵ��ڴ�С
		jf.add(this,BorderLayout.CENTER);     //����ǰ��Ķ���ʵ���ӵ�frame���м�λ�á�
		jf.setVisible(true);
		
		Object[] options ={ "��ʼ���ĵ�ʱ��", "��ѡ���˷�����" };  //�Զ��尴ť�ϵ�����
		int m = JOptionPane.showOptionDialog(null, "�����ǡ����������ս������һ��������ª����Ϸ\n" + 
		"A�������ƶ�     D�������ƶ�     J�����󹥻�     K�����ҹ���\n" + "Ҳ��W��SҲ��ʲô�ô�����( �� �� ��|||)��\n" + 
				"�밴�ո�ʼ��Ϸ�ɣ����Ų��������س��������¿�ʼ��", "���Ǹ���ͨ�Ľ���Orz",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if(m == 1) {     //ֱ���˳���Ϸ
			System.exit(0);
		}
	

		
		g = getGraphics();
		BallListener bl = new BallListener(jf);
		
		jf.addKeyListener(bl);
		jf.addMouseListener(bl);
		
		bl.setG(g);
		bl.setM(m);
		Thread BL = new Thread(bl);
		BL.start();

		/*bl.setJ(false);
		bl.setK(false);
		bl.setStop(bl.getStop());
		bl.setXstop(bl.getXstop());*/
		
		MonsterRun monsterrun = new MonsterRun(bl);
		bl.monster(monsterrun.x);
		Thread MR = new Thread(monsterrun);
		
		MR.start();
		
		/*Main main = new Main(200, 275, bl.mainxspeed,g, bl.list, bl);
		main.Drawmain(g);
		main.mainmove();
		main.Sweepmain(g);*/
		
	}
	
	public static void main(String[] args) {
		Ball ball = new Ball();
		ball.Panel();
		Music music = new Music();
		music.play();
	}
}
