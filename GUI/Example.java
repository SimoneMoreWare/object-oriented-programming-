package graphics;

import java.awt.GridLayout;
import java.awt.Polygon;
import java.util.function.Consumer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Example extends JFrame {
	
	public Example() {
		super("Graphics examples");
		
		setLayout(new GridLayout(3,3));
		
		add(paintPanel(g -> {
			g.drawLine(25, 25, 75, 75);
		}));
		add(paintPanel(g -> {
			g.drawRect(20, 20, 60, 60);
			g.fillRect(120, 20, 60, 60);
		}));
		add(paintPanel(g -> {
			g.drawRoundRect(20,20, 60,60, 10,10);
			g.fillRoundRect(120,20, 60,60, 20,20);
		}));
		add(paintPanel(g -> {
			int x[ ] = {39,94,97,142,53,58, 26};
			int y[ ] = {33,74,36,70,108,80, 106};
			int points = x.length;
			g.drawPolygon(x,y,points);
		}));
		add(paintPanel(g -> {
			int x[ ] = {39,94,97,142,53,58, 26};
			int y[ ] = {33,74,36,70,108,80, 106};
			Polygon poly = new Polygon(x,y,x.length);
			g.fillPolygon(poly);
		}));
		add(paintPanel(g -> {
			g.drawOval(20, 20, 60, 60); 
			g.fillOval(120, 20, 100, 60); 
		}));
		add(paintPanel(g -> {
			g.drawArc(20, 20, 60, 60, 90, 180);
			g.fillArc(120, 20, 60, 60, 90, 180);
		}));
		add(paintPanel(g -> {
			g.drawArc(20, 20, 80, 60, 230,160);
			g.fillArc(120, 20, 80, 60, 230,160);
		}));
		add(paintPanel(g -> {
			g.drawString("Hello", 50, 50);
		}));
		
		

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(700,500);
	}

	public static void main(String[] args) {
		Example window = new Example();
		window.setVisible(true);
	}
	
	static int n = 1;
    static JPanel paintPanel(Consumer<Graphics> painter) {
    	final long id = n++;
		JPanel res = new JPanel() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				painter.accept(g);
			}
		};
		if(id%2==0) res.setBackground(Color.WHITE);
		else res.setBackground(Color.LIGHT_GRAY);
		return res;
	}

}
