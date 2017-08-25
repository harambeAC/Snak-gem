

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class Canvas extends JPanel {

	public static final int SIZE = 50;

	public GameModel model;
	public int[][] grid;


	public Canvas(GameModel model) {
		this.model = model;
		grid = model.grid;
		Timer t = new Timer();
		TimerTask task = new TimerTask(){
			@Override
			public void run(){
				model.move();
				repaint();
			}
		};
		t.scheduleAtFixedRate(task, 0, 250);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		grid = model.grid;
		
		for(int i = 0; i<grid.length; i++){
			for(int j = 0; j<grid[0].length; j++){
				if(grid[i][j] == 1){
					g.setColor(Color.YELLOW);
					g.fillRect(j*50, i*50, 50, 50);
				}
				else if(grid[i][j] == 2){
					g.setColor(Color.RED);
					g.fillRect(j*50, i*50, 50, 50);
				}else{
					g.setColor(Color.BLUE);
					g.fillRect(j*50, i*50, 50, 50);
				}
			}
		}
	}

	@Override
	public Dimension preferredSize() {
		return new Dimension(SIZE * grid[0].length, SIZE * grid.length);
	}
}
