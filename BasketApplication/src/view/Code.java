package view;


import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Code extends JDialog {

	JTextPane tpCode;

	/**
	 * Create the dialog.
	 */
	public Code(String code) {
		setVisible(true);
		setBounds(100, 100, 450, 600);
		getContentPane().setLayout(null);
		setResizable(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 426, 484);
		getContentPane().add(scrollPane);
		
		tpCode = new JTextPane();
		scrollPane.setViewportView(tpCode);
		tpCode.setText(code);
		
		JButton btnExport = new JButton("Export");
		btnExport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				saveAs();
			}
			
		});
		btnExport.setBounds(321, 546, 117, 25);
		getContentPane().add(btnExport);
		
	}
		
		
	private void saveAs() {
		// TODO Auto-generated method stub

	      final JFileChooser SaveAs = new JFileChooser();
	      SaveAs.setApproveButtonText("Save");
	      int actionDialog = SaveAs.showOpenDialog(this);
	      if (actionDialog != JFileChooser.APPROVE_OPTION) {
	         return;
	      }
	      
	      File fileName = new File(SaveAs.getSelectedFile() + ".tx");
	      BufferedWriter outFile = null;
	      try {
	      
	    	  StringReader stringReader = new StringReader(tpCode.getText());
              BufferedReader bufferedReader = new BufferedReader(stringReader);
              FileWriter fileWriter = new FileWriter(fileName);
              BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
              for(String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                  bufferedWriter.write(line);
                  bufferedWriter.newLine();
              }
              bufferedReader.close();
              bufferedWriter.close();
	      } catch (IOException ex) {
	         ex.printStackTrace();
	      } finally {
	         if (outFile != null) {
	            try {
	               outFile.close();
	            } catch (IOException e) {
	               
	            }
	         }
	      }
		
	}
}
