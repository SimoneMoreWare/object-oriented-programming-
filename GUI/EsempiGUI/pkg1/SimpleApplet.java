package pkg1;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
@SuppressWarnings("serial")
public class SimpleApplet extends Applet{
  String text = "I'm a simple applet";
  public void init() {
        setBackground(Color.CYAN);  }
  public void start() {}
  public void stop() {}
  public void destroy() {}
  public void paint(Graphics g){
        //System.out.println("Paint");
        g.setColor(Color.blue);
        g.drawRect(0, 0, getSize().width -1, getSize().height -1);
        g.setColor(Color.red);
        g.drawString(text, 15, 25);
  }
}

