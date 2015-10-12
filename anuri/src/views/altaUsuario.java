package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Window.Type;

public class altaUsuario {

	JFrame frmNuevoUsuario;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lblPermisos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					altaUsuario window = new altaUsuario();
					window.frmNuevoUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public altaUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNuevoUsuario = new JFrame();
		frmNuevoUsuario.setType(Type.UTILITY);
		frmNuevoUsuario.setSize(new Dimension(800, 450));
		frmNuevoUsuario.setResizable(false);
		frmNuevoUsuario.setTitle("Nuevo Usuario");
		frmNuevoUsuario.setBounds(100, 100, 765, 447);
		frmNuevoUsuario.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmNuevoUsuario.getContentPane().setLayout(null);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
		lblNombreDeUsuario.setFont(new Font("Century", Font.PLAIN, 16));
		lblNombreDeUsuario.setBounds(77, 49, 155, 14);
		frmNuevoUsuario.getContentPane().add(lblNombreDeUsuario);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(257, 48, 198, 20);
		frmNuevoUsuario.getContentPane().add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(257, 86, 198, 20);
		frmNuevoUsuario.getContentPane().add(passwordField);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Century", Font.PLAIN, 16));
		lblContrasea.setBounds(77, 87, 155, 14);
		frmNuevoUsuario.getContentPane().add(lblContrasea);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(257, 127, 198, 20);
		frmNuevoUsuario.getContentPane().add(passwordField_1);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar contrase\u00F1a");
		lblConfirmarContrasea.setFont(new Font("Century", Font.PLAIN, 16));
		lblConfirmarContrasea.setBounds(77, 128, 168, 14);
		frmNuevoUsuario.getContentPane().add(lblConfirmarContrasea);
		
		lblPermisos = new JLabel("Permisos");
		lblPermisos.setFont(new Font("Century", Font.PLAIN, 16));
		lblPermisos.setBounds(77, 179, 168, 14);
		frmNuevoUsuario.getContentPane().add(lblPermisos);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Administrar materiales");
		chckbxNewCheckBox.setFont(new Font("Century", Font.PLAIN, 13));
		chckbxNewCheckBox.setBounds(77, 200, 245, 23);
		frmNuevoUsuario.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Solicitar materiales");
		chckbxNewCheckBox_1.setFont(new Font("Century", Font.PLAIN, 13));
		chckbxNewCheckBox_1.setBounds(77, 226, 245, 23);
		frmNuevoUsuario.getContentPane().add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxEntradaDeMateriales = new JCheckBox("Entrada de materiales");
		chckbxEntradaDeMateriales.setFont(new Font("Century", Font.PLAIN, 13));
		chckbxEntradaDeMateriales.setBounds(77, 252, 245, 23);
		frmNuevoUsuario.getContentPane().add(chckbxEntradaDeMateriales);
		
		JCheckBox chckbxSalidaDeMateriales = new JCheckBox("Salida de materiales");
		chckbxSalidaDeMateriales.setFont(new Font("Century", Font.PLAIN, 13));
		chckbxSalidaDeMateriales.setBounds(77, 278, 245, 23);
		frmNuevoUsuario.getContentPane().add(chckbxSalidaDeMateriales);
		
		JCheckBox checkBox_2 = new JCheckBox("New check box");
		checkBox_2.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_2.setBounds(77, 304, 245, 23);
		frmNuevoUsuario.getContentPane().add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("New check box");
		checkBox_3.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_3.setBounds(77, 330, 245, 23);
		frmNuevoUsuario.getContentPane().add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("New check box");
		checkBox_4.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_4.setBounds(324, 200, 268, 23);
		frmNuevoUsuario.getContentPane().add(checkBox_4);
		
		JCheckBox checkBox_5 = new JCheckBox("New check box");
		checkBox_5.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_5.setBounds(324, 226, 268, 23);
		frmNuevoUsuario.getContentPane().add(checkBox_5);
		
		JCheckBox checkBox_6 = new JCheckBox("New check box");
		checkBox_6.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_6.setBounds(324, 252, 268, 23);
		frmNuevoUsuario.getContentPane().add(checkBox_6);
		
		JCheckBox checkBox_7 = new JCheckBox("New check box");
		checkBox_7.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_7.setBounds(324, 304, 268, 23);
		frmNuevoUsuario.getContentPane().add(checkBox_7);
		
		JCheckBox checkBox_8 = new JCheckBox("New check box");
		checkBox_8.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_8.setBounds(324, 278, 268, 23);
		frmNuevoUsuario.getContentPane().add(checkBox_8);
		
		JCheckBox checkBox_9 = new JCheckBox("New check box");
		checkBox_9.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_9.setBounds(324, 330, 268, 23);
		frmNuevoUsuario.getContentPane().add(checkBox_9);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Century", Font.PLAIN, 16));
		btnGuardar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnGuardar.setBounds(576, 47, 99, 35);
		frmNuevoUsuario.getContentPane().add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.frmAuriHispanoamericanaSa.setEnabled(true);
				frmNuevoUsuario.dispose();
			}
		});
		btnCancelar.setFont(new Font("Century", Font.PLAIN, 16));
		btnCancelar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnCancelar.setBounds(576, 107, 99, 35);
		frmNuevoUsuario.getContentPane().add(btnCancelar);
		frmNuevoUsuario.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField, passwordField, passwordField_1, chckbxNewCheckBox, chckbxNewCheckBox_1, chckbxEntradaDeMateriales, chckbxSalidaDeMateriales, checkBox_2, checkBox_3, checkBox_4, checkBox_5, checkBox_6, checkBox_7, checkBox_8, checkBox_9, btnGuardar, btnCancelar}));
		frmNuevoUsuario.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField, passwordField, passwordField_1, chckbxNewCheckBox, chckbxNewCheckBox_1, chckbxEntradaDeMateriales, chckbxSalidaDeMateriales, checkBox_2, checkBox_3, checkBox_4, checkBox_5, checkBox_6, checkBox_8, checkBox_7, checkBox_9, btnGuardar, btnCancelar}));
	}
}
