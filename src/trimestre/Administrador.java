package trimestre;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Administrador extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField Nombre_usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrador frame = new Administrador();
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
	public Administrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JButton boton_borrar = new JButton("borrar");
		boton_borrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Consultas data=new Consultas();
				data.borrar(Nombre_usuario.getText());
			}
		});
		boton_borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		boton_borrar.setBounds(206, 178, 165, 44);
		contentPane.add(boton_borrar);
		
		Nombre_usuario = new JTextField();
		Nombre_usuario.setBounds(22, 184, 129, 32);
		contentPane.add(Nombre_usuario);
		Nombre_usuario.setColumns(10);
		
		JLabel textito = new JLabel("Nombre_Usuario");
		textito.setBounds(36, 157, 129, 25);
		contentPane.add(textito);
	
		
	
	}}
