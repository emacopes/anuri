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
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Frame;
import javax.swing.JPasswordField;

public class login {

	private JFrame frmLogin;
	private JTextField textField;
	private JPasswordField passwordField;

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
		frmLogin.setType(Type.UTILITY);
		frmLogin.setResizable(false);
		frmLogin.setBounds(100, 100, 349, 195);
		frmLogin.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton.setFont(new Font("Century", Font.PLAIN, 16));
		btnNewButton.setBounds(40, 117, 99, 35);
		frmLogin.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Century", Font.PLAIN, 16));
		btnNewButton_1.setBounds(197, 117, 99, 35);
		frmLogin.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(141, 20, 155, 20);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Century", Font.PLAIN, 16));
		lblUsuario.setBounds(22, 21, 83, 14);
		frmLogin.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Century", Font.PLAIN, 16));
		lblContrasea.setBounds(22, 59, 127, 14);
		frmLogin.getContentPane().add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(141, 58, 155, 20);
		frmLogin.getContentPane().add(passwordField);
	}
}
