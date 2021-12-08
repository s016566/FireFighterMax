package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Entity{
	
	public int worldX, worldY;
	public int speed;
	public int tileNum1, tileNum2;
	
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	public String direction;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	public static boolean isDead = false;

	public Rectangle solidArea;
	public boolean collisionOn = false;
	
	public static void setPlayerDead(boolean death) {
		isDead = death;
	}
	public static boolean isPlayerDead() {
		return isDead;
	}
	
}
