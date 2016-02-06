package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5836632015960697137L;
	private JPanel contentPane;
	private JTextField tfCity;
	private JTextField tfArena;
	private JTextField tfDate;
	private JTextField tfTime;
	private JTextField tfAttendance;
	private JTextField tfFirstNameCrewChief;
	private JTextField tfLastNameCrewChief;
	private JTextField tfCountryCrewChief;
	private JTextField tfFirstNameReferee;
	private JTextField tfLastNameReferee;
	private JTextField tfCountryReferee;
	private JTextField tfFirstNameUmpire;
	private JTextField tfLastNameUmpire;
	private JTextField tfCountryUmpire;
	private JTextArea taGameInfoCode;

	

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("BasketStats");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 50, 865, 513);
		contentPane.add(tabbedPane);
		
		
		JPanel panelGameInfo = new JPanel();
		tabbedPane.addTab("Game Informations", null, panelGameInfo, null);
		panelGameInfo.setLayout(null);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setBounds(12, 20, 70, 15);
		panelGameInfo.add(lblCity);
		
		JLabel lblArena = new JLabel("Arena:");
		lblArena.setBounds(12, 40, 70, 15);
		panelGameInfo.add(lblArena);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(12, 60, 70, 15);
		panelGameInfo.add(lblDate);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(12, 80, 70, 15);
		panelGameInfo.add(lblTime);
		
		JLabel lblAttendance = new JLabel("Attendance:");
		lblAttendance.setBounds(12, 100, 98, 15);
		panelGameInfo.add(lblAttendance);
		
		tfCity = new JTextField();
		tfCity.setBounds(150, 18, 250, 19);
		panelGameInfo.add(tfCity);
		tfCity.setColumns(10);
		
		tfArena = new JTextField();
		tfArena.setBounds(150, 38, 250, 19);
		panelGameInfo.add(tfArena);
		tfArena.setColumns(10);
		
		tfDate = new JTextField();
		tfDate.setBounds(150, 58, 250, 19);
		panelGameInfo.add(tfDate);
		tfDate.setColumns(10);
		
		tfTime = new JTextField();
		tfTime.setBounds(150, 78, 250, 19);
		panelGameInfo.add(tfTime);
		tfTime.setColumns(10);
		
		tfAttendance = new JTextField();
		tfAttendance.setBounds(150, 98, 250, 19);
		panelGameInfo.add(tfAttendance);
		tfAttendance.setColumns(10);
		
		JLabel lblCrewChief = new JLabel("Crew chief");
		lblCrewChief.setBounds(12, 120, 98, 15);
		panelGameInfo.add(lblCrewChief);
		
		JLabel lblFirstNameCrewChief = new JLabel("First name:");
		lblFirstNameCrewChief.setBounds(22, 140, 98, 15);
		panelGameInfo.add(lblFirstNameCrewChief);
		
		JLabel lblLastNameCrewChief = new JLabel("Last name:");
		lblLastNameCrewChief.setBounds(22, 160, 98, 15);
		panelGameInfo.add(lblLastNameCrewChief);
		
		JLabel lblCountryCrewChief = new JLabel("Country:");
		lblCountryCrewChief.setBounds(22, 180, 70, 15);
		panelGameInfo.add(lblCountryCrewChief);
		
		tfFirstNameCrewChief = new JTextField();
		tfFirstNameCrewChief.setBounds(150, 138, 250, 19);
		panelGameInfo.add(tfFirstNameCrewChief);
		tfFirstNameCrewChief.setColumns(10);
		
		tfLastNameCrewChief = new JTextField();
		tfLastNameCrewChief.setBounds(150, 158, 250, 19);
		panelGameInfo.add(tfLastNameCrewChief);
		tfLastNameCrewChief.setColumns(10);
		
		tfCountryCrewChief = new JTextField();
		tfCountryCrewChief.setBounds(150, 178, 250, 19);
		panelGameInfo.add(tfCountryCrewChief);
		tfCountryCrewChief.setColumns(10);
		
		JLabel lblReferee = new JLabel("Referee");
		lblReferee.setBounds(12, 200, 70, 15);
		panelGameInfo.add(lblReferee);
		
		JLabel lblFirstNameReferee = new JLabel("First name:");
		lblFirstNameReferee.setBounds(22, 220, 98, 15);
		panelGameInfo.add(lblFirstNameReferee);
		
		JLabel lblLastNameReferee = new JLabel("Last name:");
		lblLastNameReferee.setBounds(22, 240, 98, 15);
		panelGameInfo.add(lblLastNameReferee);
		
		JLabel lblCountryReferee = new JLabel("Country:");
		lblCountryReferee.setBounds(22, 260, 98, 15);
		panelGameInfo.add(lblCountryReferee);
		
		tfFirstNameReferee = new JTextField();
		tfFirstNameReferee.setColumns(10);
		tfFirstNameReferee.setBounds(150, 218, 250, 19);
		panelGameInfo.add(tfFirstNameReferee);
		
		tfLastNameReferee = new JTextField();
		tfLastNameReferee.setColumns(10);
		tfLastNameReferee.setBounds(150, 238, 250, 19);
		panelGameInfo.add(tfLastNameReferee);
		
		tfCountryReferee = new JTextField();
		tfCountryReferee.setColumns(10);
		tfCountryReferee.setBounds(150, 258, 250, 19);
		panelGameInfo.add(tfCountryReferee);
		
		JLabel lblUmpire = new JLabel("Umpire");
		lblUmpire.setBounds(12, 280, 70, 15);
		panelGameInfo.add(lblUmpire);
		
		JLabel lblFirstNameUmpire = new JLabel("First name:");
		lblFirstNameUmpire.setBounds(22, 300, 98, 15);
		panelGameInfo.add(lblFirstNameUmpire);
		
		JLabel lblLastNameUmpire = new JLabel("Last name:");
		lblLastNameUmpire.setBounds(22, 320, 98, 15);
		panelGameInfo.add(lblLastNameUmpire);
		
		JLabel lblCountryUmpire = new JLabel("Country:");
		lblCountryUmpire.setBounds(22, 340, 70, 15);
		panelGameInfo.add(lblCountryUmpire);
		
		tfFirstNameUmpire = new JTextField();
		tfFirstNameUmpire.setColumns(10);
		tfFirstNameUmpire.setBounds(150, 298, 250, 19);
		panelGameInfo.add(tfFirstNameUmpire);
		
		tfLastNameUmpire = new JTextField();
		tfLastNameUmpire.setColumns(10);
		tfLastNameUmpire.setBounds(150, 318, 250, 19);
		panelGameInfo.add(tfLastNameUmpire);
		
		tfCountryUmpire = new JTextField();
		tfCountryUmpire.setColumns(10);
		tfCountryUmpire.setBounds(150, 338, 250, 19);
		panelGameInfo.add(tfCountryUmpire);
		
		
		
		 taGameInfoCode = new JTextArea();
		 taGameInfoCode.setFont(new Font("Courier 10 Pitch", Font.ITALIC, 12));
		taGameInfoCode.setBounds(433, 20, 415, 338);
		panelGameInfo.add(taGameInfoCode);
		
		JPanel panelTools = new JPanel();
		panelTools.setBounds(12, 0, 876, 55);
		contentPane.add(panelTools);
		panelTools.setLayout(null);
		
		JButton btnNewGame = new JButton("New game");
		btnNewGame.setBounds(0, 12, 117, 25);
		panelTools.add(btnNewGame);
		
		JButton btnTranslate = new JButton("Translate");
		btnTranslate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taGameInfoCode.setText(
						"City: "+tfCity.getText()+"\n"+
						"Arena: "+tfArena.getText()+"\n"+
						"Date: "+tfDate.getText()+"\n"+
						"Time: "+tfTime.getText()+"\n"+
						"Attendance: "+tfAttendance.getText()+"\n"+
						"Crew chief:\n\t"+
						"First name: "+tfFirstNameCrewChief.getText()+"\n\t"+
						"Last name: "+tfLastNameCrewChief.getText()+"\n\t"+
						"Country: "+tfCountryCrewChief.getText()+"\n"+
						"Referee:\n\t"+
						"First name: "+tfFirstNameReferee.getText()+"\n\t"+
						"Last name: "+tfLastNameReferee.getText()+"\n\t"+
						"Country: "+tfCountryReferee.getText()+"\n"+
						"Umpire:\n\t"+
						"First name: "+tfFirstNameUmpire.getText()+"\n\t"+
						"Last name: "+tfLastNameUmpire.getText()+"\n\t"+
						"Country: "+tfCountryUmpire.getText()+"\n"
						);
			}
		});
		btnTranslate.setBounds(283, 369, 117, 25);
		panelGameInfo.add(btnTranslate);
		
		
		JPanel panelHome = new JPanel();
		tabbedPane.addTab("Home team", null, panelHome, null);
		
		JPanel panelAway = new JPanel();
		tabbedPane.addTab("Away team", null, panelAway, null);
		
		JPanel panelStats = new JPanel();
		tabbedPane.addTab("Stats", null, panelStats, null);
		
		
		
		
		
		
		}
}
