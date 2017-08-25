

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameFrame(GameModel model) {
		setTitle("snak");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setResizable(false);
		Canvas canvas = new Canvas(model);
		add(canvas);
		addKeyListener(new KeyController(model,canvas));
		pack();
		repaint();
	}
}