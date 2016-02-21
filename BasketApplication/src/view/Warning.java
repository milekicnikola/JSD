package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Warning extends JDialog {

	

	/**
	 * Create the dialog.
	 */
	public Warning() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		setResizable(false);
		
		JLabel lblCannotStartGame = new JLabel("Cannot start game, please insert valid informations in all fields.");
		panel.add(lblCannotStartGame);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		panel.add(btnBack);
		
		pack();

	}

}
