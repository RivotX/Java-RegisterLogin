package trimestre;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Grafica extends JFrame {

    private JPanel contentPane;
    private JPasswordField passwordField_2;
    private JTextField usuario;
    private JPasswordField password1;
    private JPasswordField password2;
    private JTextField correo;
 	static Grafica frame;
 

    /**
     * Launch the application.
     */

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Grafica frame = new Grafica();
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

    public Grafica() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 563, 386);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel password_error = new JLabel("Las contraseñas deben coincidir*");

        JLabel textoUsuario = new JLabel("Nombre de usuario");
        textoUsuario.setForeground(Color.GREEN);
        textoUsuario.setBounds(47, 47, 117, 23);
        contentPane.add(textoUsuario);

        JLabel textoPassword = new JLabel("Contraseña");
        textoPassword.setForeground(Color.GREEN);
        textoPassword.setBounds(293, 47, 117, 23);
        contentPane.add(textoPassword);

        JLabel textoConfirmarPassword = new JLabel("Confirmar contraseña");
        textoConfirmarPassword.setForeground(Color.GREEN);
        textoConfirmarPassword.setBounds(293, 126, 132, 23);
        contentPane.add(textoConfirmarPassword);

        password_error.setForeground(Color.RED);
        password_error.setBounds(295, 173, 211, 23);
        password_error.setVisible(false);
        contentPane.add(password_error);

        usuario = new JTextField();
        usuario.setBounds(47, 69, 123, 20);
        contentPane.add(usuario);
        usuario.setColumns(10);

        password1 = new JPasswordField();
        password1.setBounds(295, 69, 140, 20);
        contentPane.add(password1);

        password2 = new JPasswordField();
        password2.addFocusListener(new FocusAdapter() {
            @SuppressWarnings("deprecation")
            @Override

            public void focusLost(FocusEvent e) {
                password_error.setVisible(!password1.getText().equals(password2.getText()));
            }
        });
        password2.setBounds(295, 153, 140, 20);
        contentPane.add(password2);

        JLabel correo_error = new JLabel("Debe contener @");
        correo_error.setForeground(Color.RED);
        correo_error.setBounds(47, 173, 117, 23);
        contentPane.add(correo_error);
        correo_error.setVisible(false);

        JLabel textoCorreo = new JLabel("Correo electrónico");
        textoCorreo.setForeground(Color.GREEN);
        textoCorreo.setBounds(47, 126, 117, 23);
        contentPane.add(textoCorreo);

        correo = new JTextField();
        correo.addFocusListener(new FocusAdapter() {

            @Override

            public void focusLost(FocusEvent e) {
                boolean correcto = false;

                for (int i = 0; i < correo.getText().length(); i++) {
                    if (correo.getText().charAt(i) == '@') {
                        correcto = true;
                        break;
                    }
                }
                if (correcto == false) {
                    correo_error.setVisible(true);

                } else {
                    correo_error.setVisible(false);
                }
            }
        });
        correo.setColumns(10);
        correo.setBounds(47, 153, 123, 20);
        contentPane.add(correo);

        JButton boton_registro = new JButton("Registrarse");
        boton_registro.setBackground(Color.BLACK);
        boton_registro.setForeground(Color.GREEN);
        boton_registro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                if (correo_error.isVisible() == false && password1.getText().equals(password2.getText())
                	&& usuario.getText().length() != 0 && password1.getText().length() != 0) {
                	
	                    SegundoFrame segundo_frame = new SegundoFrame();
	                    segundo_frame.setVisible(true);
	                    setVisible(false);
	                    
	                    Consultas datos = new Consultas();        
	                    datos.registrar(usuario.getText(), password1.getText(), correo.getText());
                    
                } else {
                    JOptionPane.showMessageDialog(boton_registro,
	                		"Error al crear usuario, revisa que las contraseñas sean iguales,"
	                                + " el correo válido y ningun campo este vacio",
	                        "ERROR", JOptionPane.ERROR_MESSAGE);
	                }
            }
        });
        boton_registro.setBounds(172, 234, 132, 44);
        contentPane.add(boton_registro);

        JCheckBox jcMostrarClave = new JCheckBox("Mostrar contraseña");
        jcMostrarClave.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                if (jcMostrarClave.isSelected() == true) {
                    password1.setEchoChar((char) 0);
                    password2.setEchoChar((char) 0);

                } else {
                    password1.setEchoChar('●');
                    password2.setEchoChar('●');
                }
            }
        });
        jcMostrarClave.setBounds(295, 96, 140, 23);
        contentPane.add(jcMostrarClave);
        
        JButton ir_a_login = new JButton("iniciar sesion");
        ir_a_login.setBackground(Color.BLACK);
        ir_a_login.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Login login= new Login();
                login.setVisible(true);
                setVisible(false);
        	}
        });
        ir_a_login.setForeground(Color.GREEN);
        ir_a_login.setBounds(380, 283, 126, 38);
        contentPane.add(ir_a_login);
        
        JLabel Ya_tienes_cuenta = new JLabel("Ya tienes cuenta?");
        Ya_tienes_cuenta.setForeground(Color.GREEN);
        Ya_tienes_cuenta.setBounds(392, 264, 105, 14);
        contentPane.add(Ya_tienes_cuenta);
        
        JLabel Fondo = new JLabel("");
        Fondo.setIcon(new ImageIcon("C:\\Users\\Migue\\Downloads\\wlg3Xf5 (1).png"));
        Fondo.setBounds(0, 0, 547, 347);
        contentPane.add(Fondo);

    }
}