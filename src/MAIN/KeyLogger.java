package MAIN;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyLogger implements KeyListener {

	public boolean up_Pressed, down_Pressed, left_Pressed, right_Pressed;
	
	@Override
	public void keyTyped(KeyEvent e) {	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_W) {
			up_Pressed = true;	
		}
		if(key == KeyEvent.VK_S) {
			down_Pressed = true;
		}
		if(key == KeyEvent.VK_A) {
			left_Pressed = true;
		}
		if(key == KeyEvent.VK_D) {
			right_Pressed = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_W) {
			up_Pressed = false;	
		}
		if(key == KeyEvent.VK_S) {
			down_Pressed = false;
		}
		if(key == KeyEvent.VK_A) {
			left_Pressed = false;
		}
		if(key == KeyEvent.VK_D) {
			right_Pressed = false;
		}
		
	}

}
