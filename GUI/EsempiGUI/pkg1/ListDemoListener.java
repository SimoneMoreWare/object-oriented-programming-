package pkg1;
import javax.swing.*;
import java.awt.*; import java.awt.event.*;
public class ListDemoListener implements ActionListener {
	JButton removeButton; JList<?> list;
	DefaultListModel<String> listModel;
	JTextField text;
public ListDemoListener(JButton button, JList<?> l, 
			DefaultListModel<String> lM, JTextField t) {
	removeButton = button; list = l;
	listModel = lM; text = t;
}
public void actionPerformed(ActionEvent e) {
	if (e.getActionCommand().equals("remove")) {
		int index = list.getSelectedIndex();
		listModel.remove(index); int size = listModel.getSize();
		if (size == 0) removeButton.setEnabled(false);
		else { //Select an index.
			if (index == listModel.getSize()) index--;
			list.setSelectedIndex(index);
			list.ensureIndexIsVisible(index);	
		}
	} else {	// add
		String name = text.getText();
		if (name.equals("") || listModel.contains(name)) {
			Toolkit.getDefaultToolkit().beep();
			text.requestFocusInWindow(); text.selectAll(); return;
		}
		int index = list.getSelectedIndex(); //get selected index
		if (index == -1) { //no selection, so insert at beginning
			index = 0;
		} else { //add after the selected item
			index++;
		}
		listModel.insertElementAt(name, index);
		text.requestFocusInWindow();
		text.setText("");
		// Select the new item and make it visible.
		list.setSelectedIndex(index);
		list.ensureIndexIsVisible(index);
		if (listModel.getSize() > 0) removeButton.setEnabled(true);
	}
	}
	}

