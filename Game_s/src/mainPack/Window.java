package mainPack;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Window extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JFrame frame;
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public static int WIDTH = screenSize.width;
	public static int HEIGHT = screenSize.height;
	
	public Window(Game game) {
		frame = new JFrame("title");
		frame.setPreferredSize(screenSize);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		frame.requestFocus();
		frame.setVisible(true);
		game.start();
	}
	
	
	
}
