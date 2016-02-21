package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Game;
import model.GameInfo;
import model.Person;
import model.Player;
import model.Team;

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JDialog;

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
	private JTextField tfHomeName;
	private JTextField tfCoachHomeFirstName;
	private JTextField tfFirstNamePlayer;
	private JTextField tfLastNamePlayer;
	private JTextField tfNationalityPlayer;
	private JComboBox<Integer> cbNumberPlayer;
	private JComboBox<String> cbPositionPlayer;

	private JTextField tfAwayName;
	private JTextField tfCoachAwayFirstName;
	private JTextField tfFirstNamePlayerAway;
	private JTextField tfLastNamePlayerAway;
	private JTextField tfNationalityPlayerAway;
	private JComboBox<Integer> cbNumberPlayerAway;
	private JComboBox<String> cbPositionPlayerAway;

	DefaultListModel homeListModel;
	private JTextField tfCoachHomeLastName;
	private JTextField tfCoachHomeNationality;

	DefaultListModel awayListModel;
	private JTextField tfCoachAwayLastName;
	private JTextField tfCoachAwayNationality;

	private JButton btnAddPlayer;
	private JButton btnAddPlayerAway;

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
		setResizable(false);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 50, 865, 450);
		contentPane.add(tabbedPane);

		JPanel panelTools = new JPanel();
		panelTools.setBounds(12, 0, 876, 55);
		contentPane.add(panelTools);
		panelTools.setLayout(null);

		JButton btnNewGame = new JButton("New game");
		btnNewGame.setBounds(0, 12, 117, 25);
		panelTools.add(btnNewGame);

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

		JPanel panelHome = new JPanel();
		tabbedPane.addTab("Home team", null, panelHome, null);
		panelHome.setLayout(null);

		JLabel lblNameHome = new JLabel("Name:");
		lblNameHome.setBounds(12, 20, 70, 15);
		panelHome.add(lblNameHome);

		tfHomeName = new JTextField();
		tfHomeName.setBounds(150, 18, 250, 19);
		panelHome.add(tfHomeName);
		tfHomeName.setColumns(10);

		homeListModel = new DefaultListModel();
		JList listHome = new JList(homeListModel);
		listHome.setBounds(150, 48, 250, 200);
		panelHome.add(listHome);

		JLabel lblPlayersHome = new JLabel("Players:");
		lblPlayersHome.setBounds(12, 40, 70, 15);
		panelHome.add(lblPlayersHome);

		btnAddPlayer = new JButton("<< Add");
		btnAddPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				if (!tfFirstNamePlayer.getText().equals("") && !tfLastNamePlayer.getText().equals("")
						&& !tfNationalityPlayer.getText().equals("") && cbNumberPlayer.getSelectedIndex() != -1
						&& cbPositionPlayer.getSelectedIndex() != -1) {
					
					
					Player p = new Player();
					p.setFirstName(tfFirstNamePlayer.getText());
					p.setLastName(tfLastNamePlayer.getText());
					p.setNationality(tfNationalityPlayer.getText());
					p.setNumber((Integer) cbNumberPlayer.getSelectedItem());
					p.setPosition(cbPositionPlayer.getSelectedItem().toString());
					
					homeListModel.addElement(p);
					cbNumberPlayer.removeItem(cbNumberPlayer.getSelectedItem());
				}

				if (homeListModel.size() == 12) {
					btnAddPlayer.setEnabled(false);
				}
			}
		});
		btnAddPlayer.setBounds(436, 126, 85, 25);
		panelHome.add(btnAddPlayer);

		JLabel lblCoachHome = new JLabel("Coach");
		lblCoachHome.setBounds(12, 308, 70, 15);
		panelHome.add(lblCoachHome);

		tfCoachHomeFirstName = new JTextField();
		tfCoachHomeFirstName.setBounds(150, 326, 250, 19);
		panelHome.add(tfCoachHomeFirstName);
		tfCoachHomeFirstName.setColumns(10);

		JLabel lblPlayerHome = new JLabel("Player");
		lblPlayerHome.setBounds(545, 45, 108, 15);
		panelHome.add(lblPlayerHome);

		JLabel lblFirstNameHome = new JLabel("First name:");
		lblFirstNameHome.setBounds(555, 65, 85, 15);
		panelHome.add(lblFirstNameHome);

		JLabel lblLastNameHome = new JLabel("Last name:");
		lblLastNameHome.setBounds(555, 85, 98, 15);
		panelHome.add(lblLastNameHome);

		JLabel lblPositionHome = new JLabel("Position:");
		lblPositionHome.setBounds(555, 105, 98, 15);
		panelHome.add(lblPositionHome);

		JLabel lblNumberHome = new JLabel("Number:");
		lblNumberHome.setBounds(555, 125, 98, 15);
		panelHome.add(lblNumberHome);

		JLabel lblNationalityHome = new JLabel("Nationality:");
		lblNationalityHome.setBounds(555, 145, 98, 15);
		panelHome.add(lblNationalityHome);

		tfFirstNamePlayer = new JTextField();
		tfFirstNamePlayer.setBounds(648, 63, 200, 19);
		panelHome.add(tfFirstNamePlayer);
		tfFirstNamePlayer.setColumns(10);

		tfLastNamePlayer = new JTextField();
		tfLastNamePlayer.setColumns(10);
		tfLastNamePlayer.setBounds(648, 83, 200, 19);
		panelHome.add(tfLastNamePlayer);

		cbPositionPlayer = new JComboBox<String>();
		String[] positions = { "PG", "SG", "SF", "PF", "C", "G", "F" };
		for (String s : positions) {
			cbPositionPlayer.addItem(s);
		}
		cbPositionPlayer.setSelectedIndex(-1);
		cbPositionPlayer.setBounds(648, 103, 70, 19);
		panelHome.add(cbPositionPlayer);

		tfNationalityPlayer = new JTextField();
		tfNationalityPlayer.setColumns(10);
		tfNationalityPlayer.setBounds(648, 143, 200, 19);
		panelHome.add(tfNationalityPlayer);

		cbNumberPlayer = new JComboBox<Integer>();
		for (int i = 1; i < 100; i++) {

			cbNumberPlayer.addItem(i);
		}
		cbNumberPlayer.setSelectedIndex(-1);
		cbNumberPlayer.setBounds(648, 123, 70, 24);
		panelHome.add(cbNumberPlayer);

		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setBounds(22, 328, 108, 15);
		panelHome.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setBounds(22, 348, 90, 15);
		panelHome.add(lblLastName);

		JLabel lblNationality = new JLabel("Nationality:");
		lblNationality.setBounds(22, 368, 108, 15);
		panelHome.add(lblNationality);

		tfCoachHomeLastName = new JTextField();
		tfCoachHomeLastName.setColumns(10);
		tfCoachHomeLastName.setBounds(150, 346, 250, 19);
		panelHome.add(tfCoachHomeLastName);

		tfCoachHomeNationality = new JTextField();
		tfCoachHomeNationality.setColumns(10);
		tfCoachHomeNationality.setBounds(150, 366, 250, 19);
		panelHome.add(tfCoachHomeNationality);

		JPanel panelAway = new JPanel();
		tabbedPane.addTab("Away team", null, panelAway, null);
		panelAway.setLayout(null);

		JLabel lblNameAway = new JLabel("Name:");
		lblNameAway.setBounds(12, 20, 70, 15);
		panelAway.add(lblNameAway);

		tfAwayName = new JTextField();
		tfAwayName.setBounds(150, 18, 250, 19);
		panelAway.add(tfAwayName);
		tfAwayName.setColumns(10);

		awayListModel = new DefaultListModel();
		JList listAway = new JList(awayListModel);
		listAway.setBounds(150, 48, 250, 200);
		panelAway.add(listAway);

		JLabel lblPlayersAway = new JLabel("Players:");
		lblPlayersAway.setBounds(12, 40, 70, 15);
		panelAway.add(lblPlayersAway);

		btnAddPlayerAway = new JButton("<< Add");
		btnAddPlayerAway.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!tfFirstNamePlayerAway.getText().equals("") && !tfLastNamePlayerAway.getText().equals("")
						&& !tfNationalityPlayerAway.getText().equals("") && cbNumberPlayerAway.getSelectedIndex() != -1
						&& cbPositionPlayerAway.getSelectedIndex() != -1) {
					
					
					Player p = new Player();
					p.setFirstName(tfFirstNamePlayerAway.getText());
					p.setLastName(tfLastNamePlayerAway.getText());
					p.setNationality(tfNationalityPlayerAway.getText());
					p.setNumber((Integer) cbNumberPlayerAway.getSelectedItem());
					p.setPosition(cbPositionPlayerAway.getSelectedItem().toString());
					
					awayListModel.addElement(p);
					cbNumberPlayerAway.removeItem(cbNumberPlayerAway.getSelectedItem());
				}

				if (awayListModel.size() == 12) {
					btnAddPlayerAway.setEnabled(false);
				}
			}
		});
		btnAddPlayerAway.setBounds(436, 126, 85, 25);
		panelAway.add(btnAddPlayerAway);

		JLabel lblCoachAway = new JLabel("Coach");
		lblCoachAway.setBounds(12, 308, 70, 15);
		panelAway.add(lblCoachAway);

		JLabel lblPlayerAway = new JLabel("Player");
		lblPlayerAway.setBounds(545, 45, 108, 15);
		panelAway.add(lblPlayerAway);

		JLabel lblFirstNamePlayerAway = new JLabel("First name:");
		lblFirstNamePlayerAway.setBounds(555, 65, 85, 15);
		panelAway.add(lblFirstNamePlayerAway);

		JLabel lblLastNamePlayerAway = new JLabel("Last name:");
		lblLastNamePlayerAway.setBounds(555, 85, 98, 15);
		panelAway.add(lblLastNamePlayerAway);

		JLabel lblPositionPlayerAway = new JLabel("Position:");
		lblPositionPlayerAway.setBounds(555, 105, 98, 15);
		panelAway.add(lblPositionPlayerAway);

		JLabel lblNumberPlayerAway = new JLabel("Number:");
		lblNumberPlayerAway.setBounds(555, 125, 98, 15);
		panelAway.add(lblNumberPlayerAway);

		JLabel lblNationalityPlayerAway = new JLabel("Nationality:");
		lblNationalityPlayerAway.setBounds(555, 145, 98, 15);
		panelAway.add(lblNationalityPlayerAway);

		tfFirstNamePlayerAway = new JTextField();
		tfFirstNamePlayerAway.setBounds(648, 63, 200, 19);
		panelAway.add(tfFirstNamePlayerAway);
		tfFirstNamePlayerAway.setColumns(10);

		tfLastNamePlayerAway = new JTextField();
		tfLastNamePlayerAway.setColumns(10);
		tfLastNamePlayerAway.setBounds(648, 83, 200, 19);
		panelAway.add(tfLastNamePlayerAway);

		cbPositionPlayerAway = new JComboBox<String>();
		for (String s : positions) {
			cbPositionPlayerAway.addItem(s);
		}
		cbPositionPlayerAway.setSelectedIndex(-1);
		cbPositionPlayerAway.setBounds(648, 103, 70, 19);
		panelAway.add(cbPositionPlayerAway);

		tfNationalityPlayerAway = new JTextField();
		tfNationalityPlayerAway.setColumns(10);
		tfNationalityPlayerAway.setBounds(648, 143, 200, 19);
		panelAway.add(tfNationalityPlayerAway);

		cbNumberPlayerAway = new JComboBox<Integer>();

		for (int i = 1; i < 100; i++) {

			cbNumberPlayerAway.addItem(i);
		}
		cbNumberPlayerAway.setSelectedIndex(-1);
		cbNumberPlayerAway.setBounds(648, 123, 70, 24);
		panelAway.add(cbNumberPlayerAway);

		JLabel lblFirstNameAway = new JLabel("First name:");
		lblFirstNameAway.setBounds(22, 328, 108, 15);
		panelAway.add(lblFirstNameAway);

		JLabel lblLastNameAway = new JLabel("Last name:");
		lblLastNameAway.setBounds(22, 348, 90, 15);
		panelAway.add(lblLastNameAway);

		JLabel lblNationalityAway = new JLabel("Nationality:");
		lblNationalityAway.setBounds(22, 368, 108, 15);
		panelAway.add(lblNationalityAway);

		tfCoachAwayFirstName = new JTextField();
		tfCoachAwayFirstName.setColumns(10);
		tfCoachAwayFirstName.setBounds(150, 326, 250, 19);
		panelAway.add(tfCoachAwayFirstName);

		tfCoachAwayLastName = new JTextField();
		tfCoachAwayLastName.setColumns(10);
		tfCoachAwayLastName.setBounds(150, 346, 250, 19);
		panelAway.add(tfCoachAwayLastName);

		tfCoachAwayNationality = new JTextField();
		tfCoachAwayNationality.setColumns(10);
		tfCoachAwayNationality.setBounds(150, 366, 250, 19);
		panelAway.add(tfCoachAwayNationality);

		JButton btnStartGame = new JButton("Start game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (isGameInfoCorrect() && isTeamsInfoCorrect()) {

					GameInfo gameInfo = new GameInfo();
					gameInfo.setArena(tfArena.getText());
					gameInfo.setAttendance(Integer.parseInt(tfAttendance.getText()));
					gameInfo.setCity(tfCity.getText());
					gameInfo.setDate(tfDate.getText());
					gameInfo.setTime(tfTime.getText());
					gameInfo.setCrewChief(new Person(tfFirstNameCrewChief.getText(), tfLastNameCrewChief.getText(),
							tfCountryCrewChief.getText()));
					gameInfo.setReferee(new Person(tfFirstNameReferee.getText(), tfLastNameReferee.getText(),
							tfCountryReferee.getText()));
					gameInfo.setUmpire(new Person(tfFirstNameUmpire.getText(), tfLastNameUmpire.getText(),
							tfCountryUmpire.getText()));

					Team home = new Team();
					home.setName(tfHomeName.getText());
					home.setCoach(new Person(tfCoachHomeFirstName.getText(), tfCoachHomeLastName.getText(),
							tfCoachHomeNationality.getText()));

					for (int i = 0; i < homeListModel.size(); i++) {
						home.addPlayer(i, (Player) homeListModel.getElementAt(i));
					}

					Team away = new Team();
					away.setName(tfAwayName.getText());
					away.setCoach(new Person(tfCoachAwayFirstName.getText(), tfCoachAwayLastName.getText(),
							tfCoachAwayNationality.getText()));

					for (int i = 0; i < awayListModel.size(); i++) {
						away.addPlayer(i, (Player) awayListModel.getElementAt(i));
					}

					model.Game.getInstance().setGameInfo(gameInfo);
					model.Game.getInstance().setHome(home);
					model.Game.getInstance().setAway(away);

					// System.out.println(model.Game.getInstance());

					view.Game dialog = new view.Game();
					dialog.setVisible(true);
				} else {
					System.out.println("Game cannot start, datas are not valid.");
					Warning dialog=new Warning();
					dialog.setVisible(true);
				}
			}
		});
		btnStartGame.setBounds(448, 512, 117, 25);
		contentPane.add(btnStartGame);

	}

	public boolean isGameInfoCorrect() {
		try {
			Integer.parseInt(tfAttendance.getText());
		} catch (Exception e) {
			return false;
		}

		if (!tfCity.getText().equals("") && !tfArena.getText().equals("") && !tfAttendance.getText().equals("")
				&& !tfFirstNameReferee.equals("") && !tfLastNameReferee.equals("") && !tfCountryReferee.equals("")
				&& !tfFirstNameCrewChief.equals("") && !tfLastNameCrewChief.equals("") && !tfCountryCrewChief.equals("")
				&& !tfFirstNameUmpire.equals("") && !tfLastNameUmpire.equals("") && !tfCountryUmpire.equals("")) {
			return true;
		}
		return false;
	}

	public boolean isTeamsInfoCorrect() {
		if (!tfHomeName.getText().equals("") && !tfCoachHomeFirstName.getText().equals("")
				&& !tfCoachHomeLastName.getText().equals("") && !tfCoachHomeNationality.getText().equals("")
				&& homeListModel.getSize() == 12 && !tfAwayName.getText().equals("")
				&& !tfCoachAwayFirstName.getText().equals("") && !tfCoachAwayLastName.getText().equals("")
				&& !tfCoachAwayNationality.getText().equals("") && awayListModel.size() == 12) {
			return true;
		}
		return false;
	}
}
