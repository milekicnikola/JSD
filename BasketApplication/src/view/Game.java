package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Event;
import model.EventType;
import model.Player;
import model.TeamType;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Game extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox cbEvent;
	private JComboBox cbTeam;
	private JComboBox cbPlayer;
	private JComboBox cbMade;
	private JComboBox cbAsist;
	private JComboBox cbFouled;
	private JComboBox cbBlocked;
	private JComboBox cbPeriod;

	/**
	 * Create the dialog.
	 */
	public Game() {
		setTitle("Game");
		setBounds(100, 100, 450, 450);
		getContentPane().setLayout(null);

		cbPeriod = new JComboBox();
		cbPeriod.setBounds(140, 12, 200, 24);
		cbPeriod.addItem("1st");
		cbPeriod.addItem("2nd");
		cbPeriod.addItem("3rd");
		cbPeriod.addItem("4rd");
		cbPeriod.addItem("Over time");
		getContentPane().add(cbPeriod);

		JLabel lblPeriod = new JLabel("Period:");
		lblPeriod.setBounds(12, 12, 70, 15);
		getContentPane().add(lblPeriod);

		JLabel lblEvent = new JLabel("Event:");
		lblEvent.setBounds(12, 48, 70, 15);
		getContentPane().add(lblEvent);

		JLabel lblTeam = new JLabel("Team:");
		lblTeam.setBounds(12, 84, 70, 15);
		getContentPane().add(lblTeam);

		cbEvent = new JComboBox();
		cbEvent.setBounds(140, 48, 200, 24);
		cbEvent.addItem("Free throw"); // 0
		cbEvent.addItem("2 points"); // 1
		cbEvent.addItem("3 points"); // 2
		cbEvent.addItem("Personal foul"); // 3
		cbEvent.addItem("Tournover"); // 4
		cbEvent.addItem("Steal"); // 5
		cbEvent.addItem("Asist"); // 6
		cbEvent.addItem("Block"); // 7
		cbEvent.addItem("Offence rebound"); // 8
		cbEvent.addItem("Deffence rebound"); // 9
		cbEvent.addItem("Technical foul coach"); // 10
		cbEvent.addItem("Technical foul team"); // 11
		cbEvent.addItem("Technical foul player"); // 12
		cbEvent.addItem("Unsporstman foul"); // 13
		getContentPane().add(cbEvent);
		cbEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switch (cbEvent.getSelectedIndex()) {
				case 0:
					cbPlayer.setEnabled(true);
					cbMade.setEnabled(true);
					cbAsist.setEnabled(false);
					cbFouled.setEnabled(false);
					cbBlocked.setEnabled(false);
					break;
				case 1:
					cbPlayer.setEnabled(true);
					cbMade.setEnabled(true);
					if (cbMade.getSelectedIndex() == 0) {
						cbAsist.setEnabled(false);
					} else {
						cbAsist.setEnabled(true);
					}
					cbFouled.setEnabled(false);
					cbBlocked.setEnabled(false);
					break;
				case 2:
					cbPlayer.setEnabled(true);
					cbMade.setEnabled(true);
					if (cbMade.getSelectedIndex() == 0) {
						cbAsist.setEnabled(false);
					} else {
						cbAsist.setEnabled(true);
					}
					cbFouled.setEnabled(false);
					cbBlocked.setEnabled(false);
					break;
				case 3:
					cbPlayer.setEnabled(true);
					cbMade.setEnabled(false);
					cbAsist.setEnabled(false);
					cbFouled.setEnabled(true);
					cbBlocked.setEnabled(false);
					break;
				case 4:
					cbPlayer.setEnabled(true);
					cbMade.setEnabled(false);
					cbAsist.setEnabled(false);
					cbFouled.setEnabled(false);
					cbBlocked.setEnabled(false);
					break;
				case 5:
					cbPlayer.setEnabled(true);
					cbMade.setEnabled(false);
					cbAsist.setEnabled(false);
					cbFouled.setEnabled(false);
					cbBlocked.setEnabled(false);
					break;
				case 6:
					cbPlayer.setEnabled(true);
					cbMade.setEnabled(false);
					cbAsist.setEnabled(false);
					cbFouled.setEnabled(false);
					cbBlocked.setEnabled(false);
					break;
				case 7:
					cbPlayer.setEnabled(true);
					cbMade.setEnabled(false);
					cbAsist.setEnabled(false);
					cbFouled.setEnabled(false);
					cbBlocked.setEnabled(true);
					break;
				case 8:
					cbPlayer.setEnabled(true);
					cbMade.setEnabled(false);
					cbAsist.setEnabled(false);
					cbFouled.setEnabled(false);
					cbBlocked.setEnabled(false);
					break;
				case 9:
					cbPlayer.setEnabled(true);
					cbMade.setEnabled(false);
					cbAsist.setEnabled(false);
					cbFouled.setEnabled(false);
					cbBlocked.setEnabled(false);
					break;
				case 10:
					cbPlayer.setEnabled(false);
					cbMade.setEnabled(false);
					cbAsist.setEnabled(false);
					cbFouled.setEnabled(false);
					cbBlocked.setEnabled(false);
					break;
				case 11:
					cbPlayer.setEnabled(false);
					cbMade.setEnabled(false);
					cbAsist.setEnabled(false);
					cbFouled.setEnabled(false);
					cbBlocked.setEnabled(false);
					break;
				case 12:
					cbPlayer.setEnabled(true);
					cbMade.setEnabled(false);
					cbAsist.setEnabled(false);
					cbFouled.setEnabled(false);
					cbBlocked.setEnabled(false);
					break;
				case 13:
					cbPlayer.setEnabled(true);
					cbMade.setEnabled(false);
					cbAsist.setEnabled(false);
					cbFouled.setEnabled(false);
					cbBlocked.setEnabled(false);
					break;
				default:
					break;
				}

			}
		});

		cbTeam = new JComboBox();
		cbTeam.setBounds(140, 84, 200, 24);
		cbTeam.addItem(model.Game.getInstance().getHome().getName());
		cbTeam.addItem(model.Game.getInstance().getAway().getName());
		cbTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cbPlayer.removeAllItems();
				cbFouled.removeAllItems();
				cbBlocked.removeAllItems();
				cbAsist.removeAllItems();
				cbAsist.addItem("-");

				if (cbTeam.getSelectedIndex() == 0) {
					for (Player p : model.Game.getInstance().getHome().getPlayers()) {
						cbPlayer.addItem(p);
					}
					for (Player p : model.Game.getInstance().getHome().getPlayers()) {
						cbAsist.addItem(p);
					}
					for (Player p : model.Game.getInstance().getAway().getPlayers()) {
						cbFouled.addItem(p);
					}
					for (Player p : model.Game.getInstance().getAway().getPlayers()) {
						cbBlocked.addItem(p);
					}
				} else if (cbTeam.getSelectedIndex() == 1) {
					for (Player p : model.Game.getInstance().getAway().getPlayers()) {
						cbPlayer.addItem(p);
					}
					for (Player p : model.Game.getInstance().getAway().getPlayers()) {
						cbAsist.addItem(p);
					}
					for (Player p : model.Game.getInstance().getHome().getPlayers()) {
						cbFouled.addItem(p);
					}
					for (Player p : model.Game.getInstance().getHome().getPlayers()) {
						cbBlocked.addItem(p);
					}
				}

			}
		});
		getContentPane().add(cbTeam);

		JLabel lblPlayer = new JLabel("Player:");
		lblPlayer.setBounds(12, 116, 70, 15);
		getContentPane().add(lblPlayer);

		cbPlayer = new JComboBox();
		cbPlayer.setBounds(140, 116, 200, 24);
		for (Player p : model.Game.getInstance().getHome().getPlayers()) {
			cbPlayer.addItem(p);
		}
		getContentPane().add(cbPlayer);

		JLabel lblMade = new JLabel("Made:");
		lblMade.setBounds(12, 148, 70, 15);
		getContentPane().add(lblMade);

		cbMade = new JComboBox();
		cbMade.setBounds(140, 148, 200, 24);
		cbMade.addItem(false);
		cbMade.addItem(true);
		cbMade.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (cbEvent.getSelectedIndex() == 1 || cbEvent.getSelectedIndex() == 2) {
					if (cbMade.getSelectedIndex() == 0) {
						cbAsist.setEnabled(false);
					} else {
						cbAsist.setEnabled(true);
					}
				}
			}
		});
		getContentPane().add(cbMade);

		JLabel lblAsist = new JLabel("Asist:");
		lblAsist.setBounds(12, 180, 70, 15);
		getContentPane().add(lblAsist);

		cbAsist = new JComboBox();
		cbAsist.setBounds(140, 180, 200, 24);
		cbAsist.addItem("-");
		for (Player p : model.Game.getInstance().getHome().getPlayers()) {
			cbAsist.addItem(p);
		}
		getContentPane().add(cbAsist);
		cbAsist.setEnabled(false);

		JLabel lblFouled = new JLabel("Fouled:");
		lblFouled.setBounds(12, 212, 70, 15);
		getContentPane().add(lblFouled);

		cbFouled = new JComboBox();
		cbFouled.setBounds(140, 212, 200, 24);
		for (Player p : model.Game.getInstance().getAway().getPlayers()) {
			cbFouled.addItem(p);
		}
		getContentPane().add(cbFouled);
		cbFouled.setEnabled(false);

		JLabel lblBlocked = new JLabel("Blocked:");
		lblBlocked.setBounds(12, 244, 70, 15);

		getContentPane().add(lblBlocked);

		cbBlocked = new JComboBox();
		cbBlocked.setBounds(140, 244, 200, 24);
		for (Player p : model.Game.getInstance().getAway().getPlayers()) {
			cbBlocked.addItem(p);
		}
		getContentPane().add(cbBlocked);
		cbBlocked.setEnabled(false);

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Event event = new Event();

				if (cbTeam.getSelectedIndex() == 0) {
					event.setTeam(TeamType.HOME);
				} else {
					event.setTeam(TeamType.AWAY);
				}

				Player player = new Player();
				player = (Player) cbPlayer.getSelectedItem();

				boolean made = (boolean) cbMade.getSelectedItem();

				Player fouled = new Player();
				fouled = (Player) cbFouled.getSelectedItem();

				Player blocked = new Player();
				blocked = (Player) cbBlocked.getSelectedItem();

				Player asist = new Player();
				if (cbAsist.getSelectedIndex() != 0) {
					asist = (Player) cbAsist.getSelectedItem();
				}

				switch (cbEvent.getSelectedIndex()) {
				case 0:
					event.setKeyword(EventType.FT);
					event.setPlayer(player.getNumber());
					event.setMade(made);

					break;
				case 1:
					event.setKeyword(EventType.P2);
					event.setPlayer(player.getNumber());
					event.setMade(made);
					if (made) {
						event.setAsist(asist.getNumber());
					}
					break;
				case 2:
					event.setKeyword(EventType.P3);
					event.setPlayer(player.getNumber());
					event.setMade(made);
					if (made) {
						event.setAsist(asist.getNumber());
					}
					break;
				case 3:
					event.setKeyword(EventType.PF);
					event.setPlayer(player.getNumber());
					event.setFouled(fouled.getNumber());
					break;
				case 4:
					event.setKeyword(EventType.TO);
					event.setPlayer(player.getNumber());
					break;
				case 5:
					event.setKeyword(EventType.STL);
					event.setPlayer(player.getNumber());
					break;
				case 6:
					event.setKeyword(EventType.AST);
					event.setPlayer(player.getNumber());
					break;
				case 7:
					event.setKeyword(EventType.BLK);
					event.setPlayer(player.getNumber());
					event.setBlocked(blocked.getNumber());
					break;
				case 8:
					event.setKeyword(EventType.OREB);
					event.setPlayer(player.getNumber());
					break;
				case 9:
					event.setKeyword(EventType.DREB);
					event.setPlayer(player.getNumber());
					break;
				case 10:
					event.setKeyword(EventType.TFC);
					
					break;
				case 11:
					event.setKeyword(EventType.TFT);
					break;
				case 12:
					event.setKeyword(EventType.TFP);
					event.setPlayer(player.getNumber());
					break;
				case 13:
					event.setKeyword(EventType.UF);
					event.setPlayer(player.getNumber());
					break;

				default:
					break;
				}

				switch (cbPeriod.getSelectedIndex()) {
				case 0:
					model.Game.getInstance().getPeriod1().addEvent(event);
					break;
				case 1:
					model.Game.getInstance().getPeriod2().addEvent(event);
					break;
				case 2:
					model.Game.getInstance().getPeriod3().addEvent(event);
					break;
				case 3:
					model.Game.getInstance().getPeriod4().addEvent(event);
					break;
				case 4:
					model.Game.getInstance().getOverTime().addEvent(event);
					break;
				default:
					break;
				}
				
				System.out.println(event);

			}
		});
		btnOk.setBounds(223, 280, 117, 25);
		getContentPane().add(btnOk);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code;
				
				code="City: \""+model.Game.getInstance().getGameInfo().getCity()+"\"\n"+
						"Arena: \""+model.Game.getInstance().getGameInfo().getArena()+"\"\n"+
						"Date: \""+model.Game.getInstance().getGameInfo().getDate()+"\"\n"+
						"Time: \""+model.Game.getInstance().getGameInfo().getTime()+"\"\n"+
						"Attendance: "+model.Game.getInstance().getGameInfo().getAttendance()+"\n"+
						"\n"+
						"Crew Chief:\n"+
						"\tFirst name: \""+model.Game.getInstance().getGameInfo().getCrewChief().getFirstName()+"\n"+
						"\tLast name: \""+model.Game.getInstance().getGameInfo().getCrewChief().getLastName()+"\n";
				
				System.out.println(code);
						
			}
		});
		btnFinish.setBounds(223, 317, 117, 25);
		getContentPane().add(btnFinish);

	}
}
