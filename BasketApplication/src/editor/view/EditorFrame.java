package editor.view;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import net.miginfocom.swing.MigLayout;
import editor.utils.Autocomplete;
import editor.utils.MyKeyListener;


public class EditorFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextPane txtpnEditor;
	private static EditorFrame instance = null;
	public static int init = 0;
	public List<String> pressedCharacter = new ArrayList<String>();
	
	public static EditorFrame getInstance() {
		if (init == 0) {
			instance = new EditorFrame();
			init = 1;			
			return instance;
		}
		return instance;
	}
	
	public EditorFrame() {
		initGUI();
	}
	private static final String COMMIT_ACTION = "commit";
		
	 private int findLastNonWordChar (String text, int index) {
	        while (--index >= 0) {
	            if (String.valueOf(text.charAt(index)).matches("\\W")) {
	                break;
	            }
	        }
	        return index;
	    }

	    private int findFirstNonWordChar (String text, int index) {
	        while (index < text.length()) {
	            if (String.valueOf(text.charAt(index)).matches("\\W")) {
	                break;
	            }
	            index++;
	        }
	        return index;
	    }
		
	public List<String> keywords;
	
	public int currentLine=-1;
	
	public void initGUI(){
		this.setTitle("Editor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][grow][]"));
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		getContentPane().add(panel, "cell 1 4,grow");
		panel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		txtpnEditor = new JTextPane();
		txtpnEditor.setBackground(Color.BLACK);
		txtpnEditor.setForeground(Color.WHITE);
		txtpnEditor.setFont(new Font("Consolas", Font.BOLD, 12));
		// Our words to complete
		keywords  = new ArrayList<String>(10);
		
		
		try {
			FileInputStream fstream = new FileInputStream("resources/reserved_words.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String strLine;

			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {
			  if(!strLine.isEmpty() && strLine!="")
				  keywords.add(strLine);
			}
			
			try {
				FileReader reader = new FileReader("resources/game.tx");
				txtpnEditor.read(reader,"game.tx");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			br.close();

				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JScrollPane scrollPane = new JScrollPane(txtpnEditor);
		scrollPane.setBackground(Color.DARK_GRAY);
		TextLineNumber tln = new TextLineNumber(txtpnEditor); 
		
		scrollPane.setRowHeaderView( tln );
		panel.add(scrollPane, "flowx,cell 0 0,grow");
		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	try{  
      			  Process p = Runtime.getRuntime().exec("cmd /c start C:\\runner2.bat");      
	      		}catch( IOException ex ){
	      		    //Validate the case the file can't be accesed (not enought permissions)
	      		}
            }
        });
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
                SaveAs();
            }
        }); 
		getContentPane().add(btnRun, "cell 1 5,alignx right");
		getContentPane().add(btnSave, "cell 1 5,alignx right");
		pack();
		setSize(900,600);
		this.setLocationRelativeTo(null);
		this.setForeground(Color.DARK_GRAY);
		getContentPane().setBackground(Color.DARK_GRAY); 
	}
	
	public void SaveAs() {

	      final JFileChooser SaveAs = new JFileChooser();
	      SaveAs.setApproveButtonText("Save");
	      int actionDialog = SaveAs.showOpenDialog(this);
	      if (actionDialog != JFileChooser.APPROVE_OPTION) {
	         return;
	      }

	      File fileName = new File(SaveAs.getSelectedFile() + ".tx");
	      BufferedWriter outFile = null;
	      try {
	
	    	  StringReader stringReader = new StringReader(txtpnEditor.getText());
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
	               // one of the few times that I think that it's OK
	               // to leave this blank
	            }
	         }
	      }
	   }

	
	private final class CustomDocumentFilter extends DocumentFilter
	{
	        private final StyledDocument styledDocument = txtpnEditor.getStyledDocument();

	        private final StyleContext styleContext = StyleContext.getDefaultStyleContext();
	        private final AttributeSet blueAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, new Color(63, 130, 246));
	        private final AttributeSet whiteAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, Color.WHITE);

	    // Use a regular expression to find the words you are looking for
	    Pattern pattern = buildPattern();

	    @Override
	    public void insertString(FilterBypass fb, int offset, String text, AttributeSet attributeSet) throws BadLocationException {
	        super.insertString(fb, offset, text, attributeSet);

	        handleTextChanged();
	    }

	    @Override
	    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
	        super.remove(fb, offset, length);

	        handleTextChanged();
	    }

	    @Override
	    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attributeSet) throws BadLocationException {
	        super.replace(fb, offset, length, text, attributeSet);

	        handleTextChanged();
	    }

	    /**
	     * Runs your updates later, not during the event notification.
	     */
	    private void handleTextChanged()
	    {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                updateTextStyles();
	            }
	        });
	    }

	    /**
	     * Build the regular expression that looks for the whole word of each word that you wish to find.  The "\\b" is the beginning or end of a word boundary.  The "|" is a regex "or" operator.
	     * @return
	     */
	    private Pattern buildPattern()
	    {
	        StringBuilder sb = new StringBuilder();
	        for (String token : keywords) {
	            sb.append("\\b"); // Start of word boundary
	            sb.append(token);
	            sb.append("\\b|"); // End of word boundary and an or for the next word
	            
	        }
	        if (sb.length() > 0) {
	            sb.deleteCharAt(sb.length() - 1); // Remove the trailing "|"
	        }

	        Pattern p = Pattern.compile(sb.toString());

	        return p;
	    }


	    private void updateTextStyles()
	    {
	        // Clear existing styles
	        styledDocument.setCharacterAttributes(0, txtpnEditor.getText().length(), whiteAttributeSet, true);

	        // Look for tokens and highlight them
	        Matcher matcher = pattern.matcher(txtpnEditor.getText());
	        while (matcher.find()) {
	            // Change the color of recognized tokens
	        	
	            styledDocument.setCharacterAttributes(matcher.start(), matcher.end() - matcher.start(), blueAttributeSet, false);
	        }
	    }
	}
}
