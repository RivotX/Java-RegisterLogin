package trimestre;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class login extends JFrame {

	private JPanel contentPane;
	private final JTextField usuariolog = new JTextField();
	private JPasswordField passwordLog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("New label");
		label.setBounds(250, 10, 46, 14);
		contentPane.add(label);
		usuariolog.setText("Usuario");
		usuariolog.setHorizontalAlignment(SwingConstants.CENTER);
		usuariolog.setFont(new Font("Times New Roman", Font.BOLD, 13));
		usuariolog.setBackground(new Color(139, 0, 0));
		usuariolog.setForeground(new Color(255, 140, 0));
		usuariolog.setBounds(209, 51, 141, 31);
		contentPane.add(usuariolog);
		usuariolog.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Recordar contraseña");
		chckbxNewCheckBox.setBackground(new Color(0, 0, 0));
		chckbxNewCheckBox.setForeground(new Color(255, 140, 0));
		chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		chckbxNewCheckBox.setBounds(172, 142, 197, 43);
		contentPane.add(chckbxNewCheckBox);
		
		passwordLog = new JPasswordField();
		passwordLog.setFont(new Font("Times New Roman", Font.BOLD, 13));
		passwordLog.setForeground(new Color(255, 69, 0));
		passwordLog.setBackground(new Color(139, 0, 0));
		passwordLog.setBounds(209, 108, 141, 27);
		contentPane.add(passwordLog);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Migue\\Downloads\\maxresdefault (1).jpg"));
		lblNewLabel.setBounds(0, 0, 547, 347);
		contentPane.add(lblNewLabel);
	}
}
