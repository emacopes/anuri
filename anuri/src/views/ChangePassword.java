package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;

import modelo.User;
import query.UserQuery;
import util.HibernateUtil;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Dialog.ModalityType;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChangePassword extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ChangePassword dialog = new ChangePassword();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * Create the dialog.
	 */
	public ChangePassword() {
		setResizable(false);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setTitle("Cambiar contrase\u00F1a");
		setBounds(100, 100, 530, 251);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("Contrase\u00F1a nueva");
		label.setFont(new Font("Century", Font.PLAIN, 16));
		label.setBounds(10, 62, 155, 14);
		contentPanel.add(label);
		
		passwordField = new JPasswordField();
	
		passwordField.setBounds(238, 62, 256, 20);
		contentPanel.add(passwordField);
		
		JLabel label_1 = new JLabel("Confirmar nueva contrase\u00F1a");
		label_1.setFont(new Font("Century", Font.PLAIN, 16));
		label_1.setBounds(10, 103, 218, 14);
		contentPanel.add(label_1);
		
		passwordField_1 = new JPasswordField();
		
		passwordField_1.setBounds(238, 103, 256, 20);
		contentPanel.add(passwordField_1);
		
		final JButton button = new JButton("Guardar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (passwordField_2.getPassword().length==0 || passwordField_1.getPassword().length==0 || passwordField.getPassword().length==0){
					JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.","Error",JOptionPane.PLAIN_MESSAGE);
				}
				else {
					User u=Home.usuarioLogueado;
					if (u.getPassword().equals(passwordField_2.getText())){
						if (passwordField.getText().equals(passwordField_1.getText())){
							u.setPassword(passwordField.getText());
							Home.session.save(u);
							JOptionPane.showMessageDialog(null, "La contraseña se ha cambiado con éxito.","Contraseña modificada",JOptionPane.PLAIN_MESSAGE);
							Home.frmAuriHispanoamericanaSa.setEnabled(true);
							dispose();
						}
						else
							JOptionPane.showMessageDialog(null, "Las contraseñas nuevas deben coincidir.","Error",JOptionPane.PLAIN_MESSAGE);
					}
					else JOptionPane.showMessageDialog(null, "La contraseña actual es incorrecta.","Error",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		button.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					button.doClick();
				}
			}
		});
		passwordField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					button.doClick();
				}
			}
		});
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					button.doClick();
				}
			}
		});
		button.setFont(new Font("Century", Font.PLAIN, 16));
		button.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		button.setBounds(112, 159, 99, 35);
		contentPanel.add(button);
		
		final JButton button_1 = new JButton("Cancelar");
		button_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					button_1.doClick();
				}
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.frmAuriHispanoamericanaSa.setEnabled(true);
				dispose();
			}
		});
		button_1.setFont(new Font("Century", Font.PLAIN, 16));
		button_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		button_1.setBounds(303, 159, 99, 35);
		contentPanel.add(button_1);
		
		JLabel label_2 = new JLabel("Contrase\u00F1a actual");
		label_2.setFont(new Font("Century", Font.PLAIN, 16));
		label_2.setBounds(10, 21, 155, 14);
		contentPanel.add(label_2);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					button.doClick();
				}
			}
		});
		passwordField_2.setBounds(238, 21, 256, 20);
		contentPanel.add(passwordField_2);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{passwordField_2, passwordField, passwordField_1, button, button_1}));
	}
	
	
}
