package swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;

public class Layouts {
	
	static String[] labels = "The quick brown fox jumped over the lazy dogs".split(" ");
	static String[] pos = {"North","West","Center","East","South"};
	static Color[] colors = {Color.LIGHT_GRAY,Color.WHITE};
	static JFrame frame(String title,LayoutManager mgr) {
		JFrame f = new JFrame(title);
		f.setSize(200,200);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setLayout(mgr);
		
        for(int i=0; i<labels.length; ++i) {
			JLabel lbl = new JLabel(labels[i],JLabel.CENTER);
			lbl.setBackground(colors[i%colors.length]);
			lbl.setOpaque(true);
			if(mgr instanceof BorderLayout) {
				if(i<pos.length) f.add(lbl,pos[i]);
			}else {
				f.add(lbl);
			}
		}
		f.setVisible(true);
		return f;
	}

	public static void main(String[] args) {
		
		JFrame flow = frame("Flow layout",new FlowLayout());
		JFrame grid = frame("Grid layout",new GridLayout(3,3));
		JFrame border = frame("Grid layout",new BorderLayout());

	}

}
