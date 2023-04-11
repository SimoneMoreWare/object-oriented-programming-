package pkg1;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*; 
@SuppressWarnings("serial")
// esempio Sun rivisto
public class ListDemo1 extends JFrame {
	JList<String> list;
	DefaultListModel<String> listModel;
	JTextField text;
public static void main(String[] args) {
	//Make sure we have nice window decorations.
	JFrame.setDefaultLookAndFeelDecorated(true);
	ListDemo1 frame = new ListDemo1();
	frame.setTitle("ListDemo"); 
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//Display the window.
	frame.pack(); frame.setVisible(true);
}
public ListDemo1() {
	listModel = new DefaultListModel<String>();
	listModel.addElement("Torino");listModel.addElement("Milano");
	listModel.addElement("Roma");listModel.addElement("Genova");
	listModel.addElement("Cagliari");listModel.addElement("Firenze");
	// Create the list and put it in a scroll pane.
	list = new JList<String>(listModel); 
	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	list.setSelectedIndex(0);
	list.setVisibleRowCount(5);
	JScrollPane listScrollPane = new JScrollPane(list);
	JButton addButton = new JButton("add");
	JButton removeButton = new JButton("remove");
	text = new JTextField(10);
	ListDemoListener listener = 
		new ListDemoListener(removeButton, list, listModel, text);
	addButton.addActionListener(listener);
	removeButton.addActionListener(listener);
	// Create a panel that uses BoxLayout.
	JPanel buttonPane = new JPanel();
	buttonPane.setLayout(new BoxLayout(buttonPane,BoxLayout.LINE_AXIS));
	buttonPane.add(addButton);
	buttonPane.add(Box.createHorizontalStrut(5));
	buttonPane.add(text);
	buttonPane.add(Box.createHorizontalStrut(5));
	buttonPane.add(removeButton);
	buttonPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	add(listScrollPane, BorderLayout.CENTER);
	add(buttonPane, BorderLayout.PAGE_END);
	list.addListSelectionListener(new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent e){
			text.setText((String)listModel.getElementAt(list.getSelectedIndex()));
		}
	});
}

}
