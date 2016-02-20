package application;


import java.io.IOException;
import java.io.InputStream;

import javax.script.ScriptException;




import editor.view.EditorFrame;
import view.MainFrame;

public class Application {
	
	public static void main(String[] args) throws ScriptException {
		// TODO Auto-generated method stub
		MainFrame mf=new MainFrame();
		mf.setVisible(true);
		EditorFrame mg = new EditorFrame();
		mg.setVisible(true);
		
		
	}

}
