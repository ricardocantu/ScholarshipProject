import javax.swing.*;

public class Log extends JFrame {

	JButton blogin = new JButton("Login");
	JPanel panel = new JPanel();
	JTextField txuser = new JTextField(15);
	JPasswordField pass = new JPasswordField(15);
	
	public Log(){
		super("Login");
		setSize(300,200);
		setLocation(null);
		panel.setLayout(null);
	}
	
	
}
