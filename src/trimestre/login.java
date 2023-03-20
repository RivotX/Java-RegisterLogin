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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordLog;
	private JTextField usuario_log;
	static login login;

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
		
		usuario_log = new JTextField();
		usuario_log.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usuario_log.setText("");
			}
		});
		
		usuario_log.setHorizontalAlignment(SwingConstants.CENTER);
		usuario_log.setText("Usuario");
		usuario_log.setBackground(new Color(139, 0, 0));
		usuario_log.setForeground(new Color(255, 140, 0));
		usuario_log.setFont(new Font("Times New Roman", Font.BOLD, 13));
		usuario_log.setBounds(209, 51, 141, 27);
		contentPane.add(usuario_log);
		usuario_log.setColumns(10);
		
		JCheckBox RecordarPassword = new JCheckBox("Recordar contraseña");
		RecordarPassword.setBackground(new Color(0, 0, 0));
		RecordarPassword.setForeground(new Color(255, 140, 0));
		RecordarPassword.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		RecordarPassword.setBounds(172, 142, 197, 43);
		contentPane.add(RecordarPassword);
		
		passwordLog = new JPasswordField();
		passwordLog.setFont(new Font("Times New Roman", Font.BOLD, 13));
		passwordLog.setForeground(new Color(255, 69, 0));
		passwordLog.setBackground(new Color(139, 0, 0));
		passwordLog.setBounds(209, 108, 141, 27);
		contentPane.add(passwordLog);
		
		JButton Boton_registro = new JButton("Registrarse");
		Boton_registro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		Boton_registro.setFont(new Font("Times New Roman", Font.BOLD, 13));
		Boton_registro.setBackground(new Color(139, 0, 0));
		Boton_registro.setForeground(new Color(255, 140, 0));
		Boton_registro.setBounds(227, 208, 102, 43);
		contentPane.add(Boton_registro);
		
		JButton CrearCuenta = new JButton("Crear cuenta nueva");
		CrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                  
                    
                    login.setVisible(false);
				
			}
		});
		CrearCuenta.setBackground(new Color(105, 105, 105));
		CrearCuenta.setForeground(new Color(255, 69, 0));
		CrearCuenta.setFont(new Font("Times New Roman", Font.BOLD, 13));
		CrearCuenta.setBounds(195, 313, 174, 23);
		contentPane.add(CrearCuenta);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("C:\\Users\\Migue\\Downloads\\maxresdefault (1).jpg"));
		fondo.setBounds(0, 0, 547, 347);
		contentPane.add(fondo);
	}
}
