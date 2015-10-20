package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import query.*;
import modelo.*;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton button_1;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public void chequear(){
		if (passwordField.getPassword().length==0 || textField.getText().length()==0){
			JOptionPane.showMessageDialog(null, "Debe ingresar un nombre de usuario y contraseña.","Error",JOptionPane.PLAIN_MESSAGE);
		}
		else {
			UserQuery userQ=new UserQuery();
			User u=userQ.buscarUsuario(textField.getText());
			if (u!=null){
				if (u.getPassword().equals(passwordField.getText())){
					Home.crearContextoParaUsuario(u);
					Home.frmAuriHispanoamericanaSa.setEnabled(true);
					dispose();
				}
				else JOptionPane.showMessageDialog(null, "La contraseña ingresada es incorrecta.","Error",JOptionPane.PLAIN_MESSAGE);
			}
			else JOptionPane.showMessageDialog(null, "El usuario ingresado no existe.","Error",JOptionPane.PLAIN_MESSAGE);

		}
	}

	public Login() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 325, 199);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		contentPanel.setLayout(null);
		{
			button_1 = new JButton("Aceptar");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					chequear();
				}

			});
			button_1.setFont(new Font("Century", Font.PLAIN, 16));
			button_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			button_1.setBounds(28, 108, 99, 35);
			contentPanel.add(button_1);
		}
		{
			button = new JButton("Cancelar");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Home.frmAuriHispanoamericanaSa.setEnabled(true);
					dispose();
				}
			});
			button.setFont(new Font("Century", Font.PLAIN, 16));
			button.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			button.setBounds(185, 108, 99, 35);
			contentPanel.add(button);
		}
		{
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(129, 11, 155, 20);
			contentPanel.add(textField);
		}
		{
			JLabel label = new JLabel("Usuario");
			label.setFont(new Font("Century", Font.PLAIN, 16));
			label.setBounds(10, 12, 83, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Contrase\u00F1a");
			label.setFont(new Font("Century", Font.PLAIN, 16));
			label.setBounds(10, 50, 127, 14);
			contentPanel.add(label);
		}
		{
			passwordField = new JPasswordField();
			passwordField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					int key = e.getKeyCode();
					if (key == KeyEvent.VK_ENTER) {
						chequear();
					}
				}
			});
			passwordField.setBounds(129, 49, 155, 20);
			contentPanel.add(passwordField);
		}
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField, passwordField, button_1, button}));
	}

}
