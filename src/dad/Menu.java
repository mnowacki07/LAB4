package dad;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Button;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.TextArea;
import java.awt.Label;

import java.awt.Choice;

import java.awt.Dimension;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JButton;

public class Menu {

	private JFrame freMenu;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.freMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Sending<Message> empList;
		empList = new Sending<Message>();

		Choice choice = new Choice();
		choice.setBounds(87, 116, 68, 20);
		Choice choice_1 = new Choice();

		freMenu = new JFrame();
		freMenu.setTitle("Program kolejka LIFO i FIFO");
		freMenu.setBounds(100, 100, 450, 300);
		freMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		freMenu.getContentPane().setLayout(null);

		Label label = new Label("");
		label.setBounds(122, 5, 14, 22);
		freMenu.getContentPane().add(label);

		TextArea textArea = new TextArea();
		textArea.setBounds(80, 153, 274, 99);
		textArea.setMinimumSize(new Dimension(23, 19));
		textArea.setMaximumSize(new Dimension(120, 120));
		textArea.setText("");

		Button button_3 = new Button("zapisz wiad");
		button_3.setBounds(10, 114, 68, 22);
		button_3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (choice.getSelectedItem() == "FIFO") {
					empList.enqueueFifo(new Message(Integer.parseInt(textField
							.getText()), textField_1.getText(), Priority
							.valueOf(choice_1.getSelectedItem())));

				}

				if (choice.getSelectedItem() == "LIFO") {
					empList.enqueueLifo(new Message(Integer.parseInt(textField
							.getText()), textField_1.getText(), Priority
							.valueOf(choice_1.getSelectedItem())));
				}

			}
		});
		freMenu.getContentPane().add(button_3);

		choice.add("FIFO");
		choice.add("LIFO");
		choice_1.add("LOW");
		choice_1.add("NORMAL");
		choice_1.add("URGENT");

		freMenu.getContentPane().add(choice);

		textField = new JTextField();
		textField.setBounds(79, 5, 37, 22);
		freMenu.getContentPane().add(textField);
		textField.setColumns(10);

		freMenu.getContentPane().add(textArea);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(90, 46, 288, 49);
		freMenu.getContentPane().add(textField_1);

		JLabel lblWybierzId = new JLabel("Wybierz ID:");
		lblWybierzId.setBounds(10, 5, 68, 14);
		freMenu.getContentPane().add(lblWybierzId);

		choice_1.setBounds(268, 5, 78, 20);
		freMenu.getContentPane().add(choice_1);

		JLabel lblPriorytet = new JLabel("Priorytet:");
		lblPriorytet.setBounds(174, 5, 88, 14);
		freMenu.getContentPane().add(lblPriorytet);

		JLabel lblWpiszWiad = new JLabel("Wpisz wiad:");
		lblWpiszWiad.setBounds(10, 50, 78, 14);
		freMenu.getContentPane().add(lblWpiszWiad);

		JButton btnPokazWiad = new JButton("POKAZ WIAD");
		btnPokazWiad.setBounds(301, 114, 123, 23);
		freMenu.getContentPane().add(btnPokazWiad);
		btnPokazWiad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				while (empList.hasItems()) {
					Message emp = empList.dequeue();
					textArea.append(emp.id + " " + emp.text + " "
							+ emp.priority + "\n");

				}
			}
		});

	}
}
