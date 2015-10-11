package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login {

	private JFrame frmLogin;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setType(Type.POPUP);
		frmLogin.setResizable(false);
		frmLogin.setBounds(100, 100, 358, 249);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setFont(new Font("Century", Font.PLAIN, 16));
		btnNewButton.setBounds(50, 174, 99, 23);
		frmLogin.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Century", Font.PLAIN, 16));
		btnNewButton_1.setBounds(197, 174, 99, 23);
		frmLogin.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(153, 41, 155, 20);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(153, 94, 155, 20);
		frmLogin.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Century", Font.PLAIN, 16));
		lblUsuario.setBounds(22, 42, 83, 14);
		frmLogin.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Century", Font.PLAIN, 16));
		lblContrasea.setBounds(22, 95, 127, 14);
		frmLogin.getContentPane().add(lblContrasea);
	}
}
