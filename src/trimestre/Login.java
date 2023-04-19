package trimestre;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordLog;
	private JTextField usuario_log;
	static Login login;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 Consultas datos = new Consultas();  
					
					Login login = new Login();
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usuario_log = new JTextField();
		usuario_log.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(usuario_log.getText().equals("Usuario")) {
				usuario_log.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (usuario_log.getText().length()==0 ) {
				usuario_log.setText("Usuario");
				}
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
		
		JCheckBox Recordarme = new JCheckBox("Recordarme");
		Recordarme.setBackground(new Color(0, 0, 0));
		Recordarme.setForeground(new Color(255, 140, 0));
		Recordarme.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		Recordarme.setBounds(172, 142, 197, 43);
		contentPane.add(Recordarme);
		
		passwordLog = new JPasswordField();
		passwordLog.setToolTipText("");
		passwordLog.setFont(new Font("Times New Roman", Font.BOLD, 13));
		passwordLog.setForeground(Color.BLACK);
		passwordLog.setBackground(new Color(139, 0, 0));
		passwordLog.setBounds(209, 108, 141, 27);
		contentPane.add(passwordLog);
		
		JButton boton_log = new JButton("Iniciar sesion");
		boton_log.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Consultas datos = new Consultas();
				
				datos.logeo(usuario_log.getText(), passwordLog.getText());
				
				if (usuario_log.getText().equals("Administrador") && passwordLog.getText().equals("Elpapu")){
                    Administrador admin = new Administrador();
                    admin.setVisible(true);
                    setVisible(false);
                }
				
				else if(datos.logeo(usuario_log.getText(), passwordLog.getText())==true) {
					JOptionPane.showMessageDialog(boton_log,
	                		"Iniciando Sesión...",
	                        "de locos", JOptionPane.INFORMATION_MESSAGE);
					}
				
				else { 
					JOptionPane.showMessageDialog(boton_log,
                		"Error al iniciar sesión",
                        "ERROR", JOptionPane.ERROR_MESSAGE);}
			}
		});
		
		boton_log.setFont(new Font("Times New Roman", Font.BOLD, 13));
		boton_log.setBackground(new Color(139, 0, 0));
		boton_log.setForeground(new Color(255, 140, 0));
		boton_log.setBounds(219, 209, 118, 38);
		contentPane.add(boton_log);
		
		JButton CrearCuenta = new JButton("Crear cuenta nueva");
		CrearCuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Grafica frame= new Grafica();
                frame.setVisible(true);
                setVisible(false);
			}
		});
		
		CrearCuenta.setBackground(Color.BLACK);
		CrearCuenta.setForeground(new Color(255, 69, 0));
		CrearCuenta.setFont(new Font("Times New Roman", Font.BOLD, 13));
		CrearCuenta.setBounds(195, 313, 174, 23);
		contentPane.add(CrearCuenta);
		
		JLabel lblNewLabel = new JLabel("No has creado una cuenta?");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(207, 290, 141, 14);
		contentPane.add(lblNewLabel);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("C:\\Users\\Migue\\Downloads\\maxresdefault (1).jpg"));
		fondo.setBounds(0, 0, 547, 347);
		contentPane.add(fondo);
	}
}
