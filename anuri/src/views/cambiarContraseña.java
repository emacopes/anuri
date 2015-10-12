package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class cambiarContraseña {

	JFrame frmCambiarContrasea;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cambiarContraseña window = new cambiarContraseña();
					window.frmCambiarContrasea.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public cambiarContraseña() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCambiarContrasea = new JFrame();
		frmCambiarContrasea.setType(Type.UTILITY);
		frmCambiarContrasea.setResizable(false);
		frmCambiarContrasea.setTitle("Cambiar contrase\u00F1a");
		frmCambiarContrasea.setBounds(100, 100, 544, 265);
		frmCambiarContrasea.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmCambiarContrasea.getContentPane().setLayout(null);
		
		JLabel lblContraseaNueva = new JLabel("Contrase\u00F1a nueva");
		lblContraseaNueva.setFont(new Font("Century", Font.PLAIN, 16));
		lblContraseaNueva.setBounds(22, 71, 155, 14);
		frmCambiarContrasea.getContentPane().add(lblContraseaNueva);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(250, 71, 256, 20);
		frmCambiarContrasea.getContentPane().add(passwordField);
		
		JLabel lblConfirmarNuevaContrasea = new JLabel("Confirmar nueva contrase\u00F1a");
		lblConfirmarNuevaContrasea.setFont(new Font("Century", Font.PLAIN, 16));
		lblConfirmarNuevaContrasea.setBounds(22, 112, 218, 14);
		frmCambiarContrasea.getContentPane().add(lblConfirmarNuevaContrasea);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(250, 112, 256, 20);
		frmCambiarContrasea.getContentPane().add(passwordField_1);
		
		JButton button = new JButton("Guardar");
		button.setFont(new Font("Century", Font.PLAIN, 16));
		button.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		button.setBounds(124, 168, 99, 35);
		frmCambiarContrasea.getContentPane().add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home.frmAuriHispanoamericanaSa.setEnabled(true);
				frmCambiarContrasea.dispose();
			}
		});
		button_1.setFont(new Font("Century", Font.PLAIN, 16));
		button_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		button_1.setBounds(315, 168, 99, 35);
		frmCambiarContrasea.getContentPane().add(button_1);
		
		JLabel lblContraseaActual = new JLabel("Contrase\u00F1a actual");
		lblContraseaActual.setFont(new Font("Century", Font.PLAIN, 16));
		lblContraseaActual.setBounds(22, 30, 155, 14);
		frmCambiarContrasea.getContentPane().add(lblContraseaActual);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(250, 30, 256, 20);
		frmCambiarContrasea.getContentPane().add(passwordField_2);
		frmCambiarContrasea.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{passwordField_2, passwordField, passwordField_1, button, button_1}));
	}
}
