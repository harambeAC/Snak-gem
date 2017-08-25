

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyController implements KeyListener{
	public static final int[] UP = new int[]{-1,0};
	public static final int[] LEFT = new int[]{0,-1};
	public static final int[] RIGHT = new int[]{0,1};
	public static final int[] DOWN = new int[]{1,0};
	public static final int[][] DIRS = new int[][]{LEFT,UP,RIGHT,DOWN};
	
	public GameModel model;
	public Canvas canvas;
	
	public KeyController(GameModel model, Canvas canvas){
		this.model = model;
		this.canvas = canvas;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		
		if(key >= 37 && key <= 40)	model.dir = key-37;

		canvas.repaint();
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}