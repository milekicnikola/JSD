package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Player;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Game extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox cbEvent;
	private JComboBox cbTeam;
	private JComboBox cbPlayer;
	

	/**
	 * Create the dialog.
	 */
	public Game() {
		setTitle("Game");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JComboBox cbPeriod = new JComboBox();
		cbPeriod.setBounds(140, 12, 200, 24);
		cbPeriod.addItem("1st");
		cbPeriod.addItem("2nd");
		cbPeriod.addItem("3rd");
		cbPeriod.addItem("4rd");
		cbPeriod.addItem("Over time");
		getContentPane().add(cbPeriod);
		
		JLabel lblPeriod = new JLabel("Period:");
		lblPeriod.setBounds(12, 17, 70, 15);
		getContentPane().add(lblPeriod);
		
		JLabel lblEvent = new JLabel("Event:");
		lblEvent.setBounds(12, 53, 70, 15);
		getContentPane().add(lblEvent);
		
		
		
		JLabel lblTeam = new JLabel("Team:");
		lblTeam.setBounds(12, 89, 70, 15);
		getContentPane().add(lblTeam);
		
		cbEvent = new JComboBox();
		cbEvent.setBounds(140, 48, 200, 24);
		cbEvent.addItem("Free throw");					//0
		cbEvent.addItem("2 points");					//1
		cbEvent.addItem("3 points");					//2
		cbEvent.addItem("Personal foul");				//3
		cbEvent.addItem("Tournover");					//4
		cbEvent.addItem("Steal");						//5
		cbEvent.addItem("Asist");						//6
		cbEvent.addItem("Block");						//7
		cbEvent.addItem("Offence rebound");				//8
		cbEvent.addItem("Deffence rebound");			//9
		cbEvent.addItem("Technical foul coach");		//10
		cbEvent.addItem("Technical foul team");			//11
		cbEvent.addItem("Unsporstman foul");			//12
		getContentPane().add(cbEvent);
		cbEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbEvent.getSelectedIndex()==10){
					cbPlayer.setEnabled(false);
				}else{
					cbPlayer.setEnabled(true);
				}
				
			}
		});
		
		cbTeam = new JComboBox();
		cbTeam.setBounds(140, 84, 200, 24);
		cbTeam.addItem(model.Game.getInstance().getHome().getName());
		cbTeam.addItem(model.Game.getInstance().getAway().getName());
		cbTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbTeam.getSelectedIndex()==0){
					cbPlayer.removeAllItems();
					for (Player p : model.Game.getInstance().getHome().getPlayers()) {
						cbPlayer.addItem(p);
					}
				}else if(cbTeam.getSelectedIndex()==1){
					cbPlayer.removeAllItems();
					for (Player p : model.Game.getInstance().getAway().getPlayers()) {
						cbPlayer.addItem(p);
					}
				}
				
			}
		});
		getContentPane().add(cbTeam);
		
		JLabel lblPlayer = new JLabel("Player:");
		lblPlayer.setBounds(12, 125, 70, 15);
		getContentPane().add(lblPlayer);
		
		cbPlayer = new JComboBox();
		cbPlayer.setBounds(140, 116, 200, 24);
		for (Player p : model.Game.getInstance().getHome().getPlayers()) {
			cbPlayer.addItem(p);
		}
		getContentPane().add(cbPlayer);
		
	}
}
