package entity;

import main.KeyHandler;
import main.UtilityTool;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Player extends Entity{
	
	KeyHandler keyH;
	GamePanel gp;
	
	public final int screenX;
	public final int screenY;
	public int deathCounter;
	Font deathFont = new Font ("SansSerif New", Font.BOLD, 30);
	
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		solidArea = new Rectangle();
		solidArea.x = 10;
		solidArea.y = 24;
		solidArea.width = 30;
		solidArea.height = 23;
		
		
		setDefaultValues();
		getPlayerImage();
	}
	public void setDefaultValues() {
		deathCounter=0;
		worldX=gp.tileSize * 23;
		worldY=gp.tileSize * 21;
		speed=4;
		direction = "down";
		
	}
	public void getPlayerImage() {
		

		up1 = setup("boy_up_1");
		up2 = setup("boy_up_2");
		down1 = setup("boy_down_1");
		down2 = setup("boy_down_2");
		left1 = setup("boy_left_1");
		left2 = setup("boy_left_2");
		right1 = setup("boy_right_1");
		right2 = setup("boy_right_2");
	}
	public BufferedImage setup(String imageName) {
		
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/player/"+imageName+".png"));
			image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	public void update() {
		

		if(keyH.upPressed==true || keyH.downPressed==true || keyH.leftPressed==true || keyH.rightPressed==true) {
			
			gp.cChecker.checkTile(this);
			
			spriteCounter++;
			if(spriteCounter > 10) {
				if(spriteNum==1) {
					spriteNum=2;
				}
				else if(spriteNum==2) {
					spriteNum=1;
				}
				spriteCounter=0;
			}
		}
		
	}
	public void draw(Graphics2D g2) {
		//g2.setColor(Color.white);
		//g2.fillRect(x, y, gp.tileSize, gp.tileSize);// (pos x, pos y, size x, size y)
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum==1) {
				image = up1;
			}
			if(spriteNum==2) {
				image=up2;
			}
			break;
		case "down":
			if(spriteNum==1) {
				image = down1;
			}
			if(spriteNum==2) {
				image=down2;
			}
			break;
		case "right":
			if(spriteNum==1) {
				image = right1;
			}
			if(spriteNum==2) {
				image=right2;
			}
			break;
		case "left":
			if(spriteNum==1) {
				image = left1;
			}
			if(spriteNum==2) {
				image=left2;
			}
			break;
		}
		if(isPlayerDead()) {
			g2.setFont (deathFont);
			g2.drawString("You Died!",305,100);	
			deathCounter++;
			if(deathCounter > 140) {
				setPlayerDead(false);
				deathCounter=0;
				}
			
			
			
		}
		
		
		int x = screenX;
		int y = screenY;
		
		if(screenX > worldX) {
			x = worldX;
		}
		if(screenY > worldY) {
			y = worldY;
		}
		int rightOffSet = gp.screenWidth - screenX;
		
		if(rightOffSet > gp.worldWidth - gp.player.worldX) {
			x = gp.screenWidth - (gp.worldWidth - worldX);
		}
		
		int bottomOffSet = gp.screenHeight - screenY;
		
		if(bottomOffSet > gp.worldHeight - worldY) {
			y = gp.screenHeight - (gp.worldHeight - worldY);
		}
		
		
		
		g2.drawImage(image, x, y, null);
		
		
	}
}
