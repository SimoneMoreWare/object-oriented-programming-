package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class DrawingSnake extends JFrame{ 
	
	DrawingSnake(){
		super("Example drawing");
		setSize(400,300);
		this.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()){
					case KeyEvent.VK_DOWN: moveXY(0,5);
										   break;
					case KeyEvent.VK_UP: moveXY(0,-5);
					   					 break;
					case KeyEvent.VK_LEFT: moveXY(-5,0);
										   break;
					case KeyEvent.VK_RIGHT: moveXY(5,0);
					   						break;
				}
			}
		});
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	int x=100;
	int y=100;
	public void paint(Graphics g){
		Rectangle b = getBounds();
		g.clearRect(0, 0, b.width, b.height);
		g.setColor(Color.RED);
		g.drawRoundRect(4,30,
				b.width-9,b.height-35,50,50);
		g.setColor(Color.GREEN);
		g.fillOval(x+1,y+1,9,9);
		g.setColor(Color.BLUE);
		g.drawOval(x,y,10,10);
	}
	
	void moveXY(int deltaX, int deltaY){
		x+=deltaX;
		y+=deltaY;
		this.repaint();
	}
	
	public static void main(String[] args) {
		new DrawingSnake();
	}

}
