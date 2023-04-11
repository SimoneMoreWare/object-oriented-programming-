package pkg1;

import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener;import java.applet.Applet;
// This is an applet that creates a Thread that
// randomly draws lines on its workspace...
@SuppressWarnings("serial")
public class LineApplet1 extends Applet implements MouseListener {
LineThread t;
   // Set the size of the applet, create and start the thread
public void init() {resize(400,300); addMouseListener(this);
     t = new LineThread(this); t.start();}
   // Click the mouse to kill the thread...
public void mousePressed(MouseEvent arg0) {
if (t != null) {t.interrupt(); t = null;} 
else {t = new LineThread(this); t.start(); System.out.println("thread restarded");}
}
public void mouseClicked(MouseEvent arg0) {}
public void mouseReleased(MouseEvent arg0) {}
public void mouseEntered(MouseEvent arg0) {}
public void mouseExited(MouseEvent arg0) {}}

