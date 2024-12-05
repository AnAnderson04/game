package World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Canvas extends JFrame implements ActionListener {

	public Canvas() {
		buildWindow();
	}

	public void actionPerformed(ActionEvent event) {
		String s = TextF.getText();
		System.out.println(s);
		Game.processCommand(s); //possible error?
	}

	private JButton button;
	public JTextArea TextA;
	private JPanel Panel;
	private JTextField TextF;
	private JLabel Label;

	private void buildWindow() {
		setTitle("Game Window");
		setLayout(new BorderLayout(30, 10));
		button = new JButton("Execute");
		button.addActionListener(this);
		TextA = new JTextArea(" ");
		Panel = new JPanel();
		Panel.setLayout(new GridLayout(3,1));
		TextF = new JTextField();
		Label = new JLabel("What would you like to do?");

		add(TextA, BorderLayout.CENTER);
		add(Panel, BorderLayout.SOUTH);
		// add label, text field, and button to panel using add method
		Panel.add(Label);
		Panel.add(TextF);
		Panel.add(button);
		// add text area and panel to jframe using add method
		


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits window and quits program
		setSize(500, 500); // sets window size
		setLocationRelativeTo(null); // centers window in middle
		setVisible(true); // makes window visible
	}
}
