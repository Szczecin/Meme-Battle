package GAME;

import javax.swing.*;
import java.awt.*;

public class Ball extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//serialVersionUID作用是序列化时保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性。
	private Graphics g;
	
	Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
	/*Dimension 类封装单个对象中组件的宽度和高度（精确到整数）。
	该类与组件的某个属性关联。由 Component 类和LayoutManager 接口定义的一些方法将返回 Dimension 对象。*/
	
	public void Panel() {     //窗口画板
		JFrame jf = new JFrame();
		jf.setSize(ScreenSize.width,ScreenSize.height);
		jf.setTitle("表情包作战？！");
		
		jf.setDefaultCloseOperation(3);
		/*setDefaultCloseOperation(int operation)：设置用户在此窗体上发起 "close" 时默认执行的操作。
		 * 为“0”或DO_NOTHING_ON_CLOSE：不执行任何操作；
		 * 为“1”或HIDE_ON_CLOSE：调用任意已注册的 WindowListener 对象后自动隐藏该窗体。
		 * 为“2”或DISPOSE_ON_CLOSE：调用任意已注册 WindowListener 的对象后自动隐藏并释放该窗体。
		 为“3”EXIT_ON_CLOSE：使用 System exit 方法退出应用程序。*/
		
		jf.setLocationRelativeTo(null);     //设置窗体相对指定组件的位置
		jf.getContentPane().setBackground(Color.BLUE);
		//JFrame 有一个 Content Pane，窗口能显示的所有组件都是添加在这个 Content Pane 中。
		jf.setResizable(false);     //Frame不可调节大小
		jf.add(this,BorderLayout.CENTER);     //将当前类的对象实例加到frame的中间位置。
		jf.setVisible(true);
		
		Object[] options ={ "开始无聊的时光", "不选择浪费生命" };  //自定义按钮上的文字
		int m = JOptionPane.showOptionDialog(null, "这里是《表情包大作战》，是一个超级简陋滴游戏\n" + 
		"A：向左移动     D：向右移动     J：向左攻击     K：向右攻击\n" + "也许W和S也有什么用处？Σ( ° △ °|||)︴\n" + 
				"请按空格开始游戏吧！（才不会告诉你回车可以重新开始）", "这是个普通的介绍Orz",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if(m == 1) {     //直接退出游戏
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
