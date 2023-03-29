package trimestre;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SegundoFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtRegistradoCorrectamente;
	private JButton Volver_a_registro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SegundoFrame frame = new SegundoFrame();
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
	public SegundoFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtRegistradoCorrectamente = new JTextField();
		txtRegistradoCorrectamente.setEditable(false);
		txtRegistradoCorrectamente.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtRegistradoCorrectamente.setText("Registrado Correctamente");
		txtRegistradoCorrectamente.setForeground(new Color(255, 0, 0));
		txtRegistradoCorrectamente.setBounds(123, 11, 250, 87);
		contentPane.add(txtRegistradoCorrectamente);
		txtRegistradoCorrectamente.setColumns(10);
		
		Volver_a_registro = new JButton("Volver");
		Volver_a_registro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Grafica frame= new Grafica();
                frame.setVisible(true);
                setVisible(false);
			}
		});
		Volver_a_registro.setFont(new Font("Tahoma", Font.BOLD, 13));
		Volver_a_registro.setBounds(179, 226, 123, 36);
		contentPane.add(Volver_a_registro);
		
		JLabel fondo_registrado = new JLabel("New label");
		fondo_registrado.setIcon(new ImageIcon("C:\\Users\\Migue\\Downloads\\pp,504x498-pad,600x600,f8f8f8.u2 (1).jpg"));
		fondo_registrado.setBounds(0, 0, 526, 313);
		contentPane.add(fondo_registrado);
	}
}
