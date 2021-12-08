package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	
	// SCREEN SETTINGS
	
	final int originalTileSize = 19; // 16x16 tile
	final int scale = 3; //makes each pixel 3 pixel bigger
	
	public final int tileSize = originalTileSize * scale; // 48x48 tile
	public final int maxScreenCol = 26; //1X = 1 tile = 48 pixels
	public final int maxScreenRow = 16; //1Y = 1 tile = 48 pixels
	public final int screenWidth = tileSize * maxScreenCol; // 16*(16*3)=768 pixels
	public final int screenHeight = tileSize * maxScreenRow; // 12*(16*3)=576 pixels
	
	//FPS
	public final int FPS = 60;
	
	// WORLD SETTINGS
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	
	
	public Graphics g;

	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	public TileManager tileM = new TileManager(this);
	public CollisionChecker cChecker = new CollisionChecker(this,keyH);
	public Player player = new Player(this,keyH);
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //Panel size
		this.setBackground(Color.black); //sets color backround of panel to black
		this.setDoubleBuffered(true); //If set to true, all the drawing from this component will be done in an offscreen painting buffer.
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		double drawInterval = 1000000000/FPS; // 1 second divided by 60 = 0.01666 seconds
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while(gameThread!=null) {
			currentTime = System.nanoTime();
			delta+=(currentTime - lastTime) / drawInterval;
			
			lastTime = currentTime;
			
			// 1 UPDATE DATA: change information
			if(delta >= 1) {
				update();
				// 2 DRAE: draw the screen with the updated data
				repaint(); //calls paintComponent
				delta--;
			}
		}
	}
	
	public void update() {
		
		player.update();
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g); //access super class (JPanel) and uses paintComponent method
		
		Graphics2D g2 = (Graphics2D)g; //extends the graphics class to provide more sophisticated control over geometry, coordinate transmations, color management, and text layout
		
		tileM.draw(g2);
		
		player.draw(g2);
		
		g2.dispose();
	}
}
