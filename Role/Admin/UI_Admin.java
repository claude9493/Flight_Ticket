package Admin;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class UI_Admin {

	public static void main(String[] args) {
		JFrame AdminUI = new JFrame("Admin");
		AdminUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AdminUI.setSize(200, 400);
		AdminUI.setVisible(true);
		AdminUI.setResizable(false);
		JButton log = new JButton("LOG");
		JButton register = new JButton("REGISTER");
		JPanel jp = new JPanel();
		jp.add(log);
		jp.add(register);
		AdminUI.add(jp);
		JMenuBar BAR = new JMenuBar();
		JMenu Log = new JMenu("LOG"), Register = new JMenu("REGISTER");
		BAR.add(Log);
		BAR.add(Register);
		AdminUI.setJMenuBar(BAR);
		
	}
	
	public void LOG(){
		JFrame log = new JFrame("Log");
		log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		log.setVisible(true);
		
		
		
	}

}
