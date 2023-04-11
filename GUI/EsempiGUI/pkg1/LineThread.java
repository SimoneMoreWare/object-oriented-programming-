package pkg1;

import java.awt.*; import java.applet.Applet;
class LineThread extends Thread {
Applet a;  // Thread needs to know the applet...
public LineThread(Applet a) {this.a = a;} // stores the applet
public void run() {// Run the thread. Lines everywhere!
  // Get dimension data about the applet...
  //double width =  (double)a.getSize().width; 
  //double height = (double)a.getSize().height;

  try{
	  while (true) {
		  double width =  (double)a.getSize().width; 
		  double height = (double)a.getSize().height;
	 	Graphics g = a.getGraphics();
	 	g.drawLine((int)(width * Math.random()), 
		(int)(height * Math.random()),
		(int)(width * Math.random()), 
		(int)(height * Math.random()) );
	    	sleep(1000); } 
	  } catch (InterruptedException e){
		System.out.println("thread interrupted");} 
	 System.out.println("thread terminated");
	   } } 


