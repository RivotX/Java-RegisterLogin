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
        textoUsuario.setForeground(Color.ORANGE);
        textoUsuario.setBounds(34, 47, 117, 23);
        contentPane.add(textoUsuario);

        JLabel textoPassword = new JLabel("Contraseña");
        textoPassword.setForeground(Color.ORANGE);
        textoPassword.setBounds(285, 47, 117, 23);
        contentPane.add(textoPassword);

        JLabel textoConfirmarPassword = new JLabel("Confirmar contraseña");
        textoConfirmarPassword.setForeground(Color.ORANGE);
        textoConfirmarPassword.setBounds(285, 126, 132, 23);
        contentPane.add(textoConfirmarPassword);

        password_error.setForeground(Color.RED);
        password_error.setBounds(285, 173, 211, 23);
        password_error.setVisible(false);
        contentPane.add(password_error);

        usuario = new JTextField();
        usuario.setBounds(34, 69, 123, 20);
        contentPane.add(usuario);
        usuario.setColumns(10);

        password1 = new JPasswordField();
        password1.setBounds(285, 69, 140, 20);
        contentPane.add(password1);

        password2 = new JPasswordField();
        password2.addFocusListener(new FocusAdapter() {
            @SuppressWarnings("deprecation")
            @Override

            public void focusLost(FocusEvent e) {
                password_error.setVisible(!password1.getText().equals(password2.getText()));
            }
        });
        password2.setBounds(285, 153, 132, 20);
        contentPane.add(password2);

        JLabel correo_error = new JLabel("Debe contener @");
        correo_error.setForeground(Color.RED);
        correo_error.setBounds(34, 173, 117, 23);
        contentPane.add(correo_error);
        correo_error.setVisible(false);

        JLabel textoCorreo = new JLabel("Correo electrónico");
        textoCorreo.setForeground(Color.ORANGE);
        textoCorreo.setBounds(34, 126, 117, 23);
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
        correo.setBounds(34, 153, 123, 20);
        contentPane.add(correo);

        JButton boton_registro = new JButton("Registrarse");
        boton_registro.setForeground(new Color(255, 128, 0));
        boton_registro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (correo_error.isVisible() == false && password1.getText().equals(password2.getText())
                        && usuario.getText().length() != 0 && password1.getText().length() != 0) {
                    SegundoFrame segundo_frame = new SegundoFrame();
                    segundo_frame.setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(boton_registro,
	                		"Error al crear usuario, revisa que las contraseñas sean iguales,"
	                                + " el correo válido y ningun campo este vacio",
	                        "ERROR", JOptionPane.ERROR_MESSAGE);
	                }
            }
        });
        boton_registro.setBounds(162, 235, 132, 44);
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
        jcMostrarClave.setBounds(285, 96, 140, 23);
        contentPane.add(jcMostrarClave);

        JLabel Fondo = new JLabel("");
        Fondo.setIcon(new ImageIcon("C:\\Users\\Migue\\Downloads\\hYdwKEj (1).jpg"));
        Fondo.setBounds(0, 0, 546, 346);
        contentPane.add(Fondo);

    }
}