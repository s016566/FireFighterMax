package main;
import entity.Entity;

public class CollisionChecker extends Entity{


	public GamePanel gp;
	public KeyHandler keyH;


	public CollisionChecker(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		speed=4;
		
	}

	public void checkTile(Entity entity) {

		int entityLeftWorldX = entity.worldX + entity.solidArea.x;
		int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.worldY + entity.solidArea.y;
		int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
		
		int bottomStop = entityBottomWorldY;
		int rightStop = entityRightWorldX;
				
		
		int entityLeftCol = entityLeftWorldX/gp.tileSize;
		int entityRightCol = entityRightWorldX/gp.tileSize;
		int entityTopRow = entityTopWorldY/gp.tileSize;
		int entityBottomRow = entityBottomWorldY/gp.tileSize;

		collisionOn = false;
		if(keyH.upPressed==true || keyH.downPressed==true || keyH.leftPressed==true || keyH.rightPressed==true) {
			if(keyH.upPressed==true) {
				entity.direction="up";
				entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
				entity.tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
				entity.tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
				if(gp.tileM.tile[entity.tileNum1].collision == true || gp.tileM.tile[entity.tileNum2].collision == true) {
					collisionOn = true;

					if(entity.tileNum1 == 2 || entity.tileNum2 ==2) {
						entity.worldX=gp.tileSize * 23;
						entity.worldY=gp.tileSize * 21;
						Entity.setPlayerDead(true);

					}
				}

				if(collisionOn==false && entityTopWorldY-25>0) {
					entity.worldY-=speed;
				}
			}
			if(keyH.downPressed==true) {
				entity.direction="down";
				bottomStop = (entityBottomWorldY + entity.speed);
				entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
				entity.tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
				entity.tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
				if(gp.tileM.tile[entity.tileNum1].collision == true || gp.tileM.tile[entity.tileNum2].collision == true) {
					collisionOn = true;

					if(entity.tileNum1 == 2 || entity.tileNum2 ==2 ) {
						entity.worldX=gp.tileSize * 23;
						entity.worldY=gp.tileSize * 21;
						Entity.setPlayerDead(true);
					}
				}
				if(collisionOn==false && bottomStop+speed < gp.worldHeight) {
					entity.worldY+=speed;
				}
			}
			if(keyH.leftPressed==true) {
				entity.direction="left";
				entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
				entity.tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
				entity.tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
				if(gp.tileM.tile[entity.tileNum1].collision == true || gp.tileM.tile[entity.tileNum2].collision == true) {
					collisionOn = true;

					if(entity.tileNum1 == 2 || entity.tileNum2 ==2) {
						entity.worldX=gp.tileSize * 23;
						entity.worldY=gp.tileSize * 21;
						Entity.setPlayerDead(true);
					}
				}
				if(collisionOn==false && entityLeftWorldX > 0) {
					entity.worldX-=speed;
				}
			}
			if(keyH.rightPressed==true) {
				entity.direction="right";
				rightStop = (entityRightWorldX + entity.speed);
				entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
				entity.tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
				entity.tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
				if(gp.tileM.tile[entity.tileNum1].collision == true || gp.tileM.tile[entity.tileNum2].collision == true) {
					collisionOn = true;

					if(entity.tileNum1 == 2 || entity.tileNum2 ==2) {
						entity.worldX=gp.tileSize * 23;
						entity.worldY=gp.tileSize * 21;
						Entity.setPlayerDead(true);
					}
				}
				if(collisionOn==false && rightStop+speed < gp.worldWidth) {
					entity.worldX+=speed;
				}
			}
		}

	}
	
}
