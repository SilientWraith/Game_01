package ENTITY;

import java.awt.image.BufferedImage;

public class Entity {
	
	public int x, y;
	public int velocity;
	
	public BufferedImage up_1, up_2, down_1, down_2, left_1, left_2, right_1, right_2; // bufferimage - it describes an image with an accessible bigger of an image
	public String direction;														   // data. (we use this to store our image files
	
	public int sprite_counter = 0;
	public int sprite_number = 1;
}
