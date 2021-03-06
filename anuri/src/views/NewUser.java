package views;

import modelo.*;
import util.HibernateUtil;
import query.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;

import java.awt.Checkbox;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import org.hibernate.Query;
import org.hibernate.Session;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NewUser extends JDialog {
	private JTextField nameField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private List<JCheckBox> listCheckBox = new ArrayList<JCheckBox>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NewUser dialog = new NewUser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public NewUser() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setTitle("Nuevo usuario");
		setBounds(100, 100, 626, 365);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Nombre de usuario");
		label.setFont(new Font("Century", Font.PLAIN, 16));
		label.setBounds(6, 13, 155, 14);
		getContentPane().add(label);
		
		nameField = new JTextField();
		
		nameField.setColumns(10);
		nameField.setBounds(186, 12, 198, 20);
		getContentPane().add(nameField);
		
		passwordField = new JPasswordField();
		
		passwordField.setBounds(186, 50, 198, 20);
		getContentPane().add(passwordField);
		
		JLabel label_1 = new JLabel("Contrase\u00F1a");
		label_1.setFont(new Font("Century", Font.PLAIN, 16));
		label_1.setBounds(6, 51, 155, 14);
		getContentPane().add(label_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(186, 91, 198, 20);
		getContentPane().add(passwordField_1);
		
		JLabel label_2 = new JLabel("Confirmar contrase\u00F1a");
		label_2.setFont(new Font("Century", Font.PLAIN, 16));
		label_2.setBounds(6, 92, 168, 14);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Permisos");
		label_3.setFont(new Font("Century", Font.PLAIN, 16));
		label_3.setBounds(6, 143, 168, 14);
		getContentPane().add(label_3);
		
		JCheckBox checkBox_0 = new JCheckBox("Administrar materiales");
		checkBox_0.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_0.setBounds(6, 164, 245, 23);
		getContentPane().add(checkBox_0);
		
		JCheckBox checkBox_1 = new JCheckBox("Solicitar materiales");
		checkBox_1.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_1.setBounds(6, 190, 245, 23);
		getContentPane().add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("Entrada de materiales");
		checkBox_2.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_2.setBounds(6, 216, 245, 23);
		getContentPane().add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("Salida de materiales");
		checkBox_3.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_3.setBounds(6, 242, 245, 23);
		getContentPane().add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("New check box");
		checkBox_4.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_4.setBounds(6, 268, 245, 23);
		getContentPane().add(checkBox_4);
		
		JCheckBox checkBox_5 = new JCheckBox("New check box");
		checkBox_5.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_5.setBounds(6, 294, 245, 23);
		getContentPane().add(checkBox_5);
		
		JCheckBox checkBox_6 = new JCheckBox("New check box");
		checkBox_6.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_6.setBounds(253, 164, 268, 23);
		getContentPane().add(checkBox_6);
		
		JCheckBox checkBox_7 = new JCheckBox("New check box");
		checkBox_7.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_7.setBounds(253, 190, 268, 23);
		getContentPane().add(checkBox_7);
		
		JCheckBox checkBox_8 = new JCheckBox("New check box");
		checkBox_8.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_8.setBounds(253, 216, 268, 23);
		getContentPane().add(checkBox_8);
		
		JCheckBox checkBox_9 = new JCheckBox("New check box");
		checkBox_9.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_9.setBounds(253, 268, 268, 23);
		getContentPane().add(checkBox_9);
		
		JCheckBox checkBox_10 = new JCheckBox("New check box");
		checkBox_10.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_10.setBounds(253, 242, 268, 23);
		getContentPane().add(checkBox_10);
		
		JCheckBox checkBox_11 = new JCheckBox("New check box");
		checkBox_11.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_11.setBounds(253, 294, 268, 23);
		getContentPane().add(checkBox_11);
		
		final JButton button = new JButton("Guardar");
		button.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					button.doClick();
				}
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (passwordField.getPassword().length==0 || passwordField_1.getPassword().length==0 || nameField.getText().length()==0){
					JOptionPane.showMessageDialog(null, "Debe completar todos los campos.","Error",JOptionPane.PLAIN_MESSAGE);
				}
				else{
					UserQuery userQ=new UserQuery();
					User u=userQ.buscarUsuario(nameField.getText());
					if (u==null){
						if (!passwordField.getText().equals(passwordField_1.getText())){
							JOptionPane.showMessageDialog(null, "Las contraseņas nuevas deben coincidir.","Error",JOptionPane.PLAIN_MESSAGE);
						}else{
							User usuarioNuevo = new User();
							usuarioNuevo.setPassword(passwordField.getText());
							usuarioNuevo.setNombre(nameField.getText());
							PermisoQuery permisoQ = new PermisoQuery();
							for (JCheckBox jCheckBox : listCheckBox) {								
								if (jCheckBox.isSelected()){
									Permiso permiso=permisoQ.buscarPermiso(jCheckBox.getText());
									usuarioNuevo.addPermiso(permiso);
								} 
							}
							Home.session.save(usuarioNuevo);
							Home.session.flush();
							JOptionPane.showMessageDialog(null, "El usuario ha sido creado correctamente.","Usuario creado",JOptionPane.PLAIN_MESSAGE);
							Home.frmAuriHispanoamericanaSa.setEnabled(true);
							dispose();
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese nombre.","Error",JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
		});
		button.setFont(new Font("Century", Font.PLAIN, 16));
		button.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		button.setBounds(505, 11, 99, 35);
		getContentPane().add(button);
		
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
		button_1.setBounds(505, 71, 99, 35);
		getContentPane().add(button_1);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{nameField, passwordField, passwordField_1, checkBox_0, checkBox_1, checkBox_2, checkBox_3, checkBox_4, checkBox_5, checkBox_6, checkBox_7, checkBox_8, checkBox_10, checkBox_9, checkBox_11, button, button_1}));
	
		nameField.addKeyListener(new KeyAdapter() {
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
		
		passwordField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					button.doClick();
				}
			}
		});
		
		// si se agrega un checkbox, agregarlo aca tambien.
		listCheckBox.add(checkBox_0);
		listCheckBox.add(checkBox_1);
		listCheckBox.add(checkBox_2);
		listCheckBox.add(checkBox_3);
	/*	listCheckBox.add(checkBox_4);
		listCheckBox.add(checkBox_5);
		listCheckBox.add(checkBox_6);
		listCheckBox.add(checkBox_7);
		listCheckBox.add(checkBox_8);
		listCheckBox.add(checkBox_9);
		listCheckBox.add(checkBox_10);
		listCheckBox.add(checkBox_11);
	*/	
	}
}
