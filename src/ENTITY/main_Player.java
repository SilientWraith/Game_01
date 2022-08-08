package ENTITY;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import MAIN.GameFrame;
import MAIN.KeyLogger;

public class main_Player extends Entity{
	
	GameFrame graph;
	KeyLogger keyJ;
	
	
	
	public main_Player(GameFrame graph, KeyLogger keyJ) {
		
		this.graph = graph;
		this.keyJ = keyJ;
		
		setDefaultValues();
		getPlayerGraphic();
	}
	public void setDefaultValues() {
		
		x = 100;
		y = 100;
		velocity = 5; // this means 5 pixels
		direction = "down"; // any direction is fine
	}
	
	public void getPlayerGraphic() {
		
		try {
			
			up_1 = ImageIO.read(getClass().getResourceAsStream("/PLAYER/boy_up_1.png"));
			up_2 = ImageIO.read(getClass().getResourceAsStream("/PLAYER/boy_up_2.png"));
			down_1 = ImageIO.read(getClass().getResourceAsStream("/PLAYER/boy_down_1.png"));
			down_2 = ImageIO.read(getClass().getResourceAsStream("/PLAYER/boy_down_2.png"));
			left_1 = ImageIO.read(getClass().getResourceAsStream("/PLAYER/boy_left_1.png"));
			left_2 = ImageIO.read(getClass().getResourceAsStream("/PLAYER/boy_left_2.png"));
			right_1 = ImageIO.read(getClass().getResourceAsStream("/PLAYER/boy_right_1.png"));
			right_2 = ImageIO.read(getClass().getResourceAsStream("/PLAYER/boy_right_2.png"));
			
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
		
	
	public void UPDATE() {
		if (keyJ.up_Pressed == true || keyJ.down_Pressed == true ||         // || = or
				keyJ.left_Pressed == true || keyJ.right_Pressed == true) {
			
			if(keyJ.up_Pressed == true) {
				y -= velocity; //-= means subtract and assignment operator meaning C = C-A.
				// PlayerY = PlayerY - PlayerSpeed
				direction = "up";
			}
			else if (keyJ.down_Pressed == true) {
				y += velocity;
				direction = "down";
			}
			else if (keyJ.left_Pressed == true) {
				x -= velocity;
				direction = "left";
			}
			else if (keyJ.right_Pressed == true) {
				x += velocity;
				direction = "right";
			}
			
			sprite_counter++;
			if(sprite_counter > 15) {
				if(sprite_number == 1) {
					sprite_number = 2;
				}
				else if(sprite_number == 2)	{
					sprite_number = 1;
				}
				sprite_counter = 0; // the update method gets called 60 times a second every 10 frames it changes sprite
			}
			
		}
		
		
	}
		
	public void draw(Graphics2D g2) {
		
		//g2.setColor(Color.green);
		//g2.fillRect(x, y, graph.tileSize, graph.tileSize); // draws a rectangle on the screen
		
		BufferedImage IMAGE = null;
		
		switch(direction) {
		case "up":
			if(sprite_number == 1) {
				IMAGE = up_1;
			}
			if(sprite_number == 2) {
				IMAGE = up_2;
			}
			break;
		case "down":
			if(sprite_number == 1) {
				IMAGE = down_1;
			}
			if(sprite_number == 2) {
				IMAGE = down_2;
			}
			break;
		case "left":
			if(sprite_number == 1) {
				IMAGE = left_1;
			}
			if(sprite_number == 2) {
				IMAGE = left_2;
			}
			break;
		case "right":
			if(sprite_number == 1) {
				IMAGE = right_1;
			}
			if(sprite_number == 2) {
				IMAGE = right_2;
			}
			break;
		}
			
		g2.drawImage(IMAGE, x, y, graph.tileSize, graph.tileSize, null);
		
		
		}
	
	}

