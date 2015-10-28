package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.border.BevelBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import modelo.Permiso;
import modelo.User;
import query.PermisoQuery;
import query.UserQuery;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;

public class ModifyUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private List<JCheckBox> listCheckBox = new ArrayList<JCheckBox>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModifyUser dialog = new ModifyUser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModifyUser() {
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setTitle("Modificar usuario");
		setBounds(100, 100, 701, 501);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("Usuario");
		label.setFont(new Font("Century", Font.PLAIN, 16));
		label.setBounds(34, 28, 83, 29);
		contentPanel.add(label);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!comboBox.getSelectedItem().toString().equals("Seleccione un usuario...")){
					UserQuery userQ=new UserQuery();
					User userSeleccionado=userQ.buscarUsuario(comboBox.getSelectedItem().toString());
					for (JCheckBox checkBox : listCheckBox){
						checkBox.setSelected(false);
					}
					textField.setText(userSeleccionado.getNombre());
					Set<Permiso> permisos= userSeleccionado.getPermisos();
					for (Permiso permiso:permisos){
						for (JCheckBox checkBox : listCheckBox){
							if(permiso.getNombre().equals(checkBox.getText())){
								checkBox.setSelected(true);
							}
						}
					}
				}
			}
		});
		comboBox.setToolTipText("");
		comboBox.setName("");
		comboBox.setBounds(123, 28, 273, 29);
		comboBox.addItem("Seleccione un usuario...");
		UserQuery userQ=new UserQuery();
		List<User> otrosUsuarios=userQ.buscarOtrosUsuarios(Home.usuarioLogueado.getNombre());
		if (otrosUsuarios!=null){
			List<String>nombres=new ArrayList<String>();
			for (User usuario:otrosUsuarios){
				nombres.add(usuario.getNombre());
			}
			Collections.sort(nombres);
			for (String nombre:nombres){
				comboBox.addItem(nombre);
			}
		}
		else JOptionPane.showMessageDialog(null, "No existen usuarios para modificar.","Error",JOptionPane.PLAIN_MESSAGE);

		contentPanel.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 84, 665, 367);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("Nombre de usuario");
		label_1.setFont(new Font("Century", Font.PLAIN, 16));
		label_1.setBounds(38, 30, 218, 14);
		panel.add(label_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(266, 30, 233, 20);
		panel.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(266, 68, 233, 20);
		panel.add(passwordField);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva contrase\u00F1a");
		lblNuevaContrasea.setFont(new Font("Century", Font.PLAIN, 16));
		lblNuevaContrasea.setBounds(38, 68, 218, 14);
		panel.add(lblNuevaContrasea);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(266, 109, 233, 20);
		panel.add(passwordField_1);
		
		JLabel lblConfirmarNuevaContrasea = new JLabel("Confirmar nueva contrase\u00F1a");
		lblConfirmarNuevaContrasea.setFont(new Font("Century", Font.PLAIN, 16));
		lblConfirmarNuevaContrasea.setBounds(38, 109, 218, 14);
		panel.add(lblConfirmarNuevaContrasea);
		
		JLabel label_4 = new JLabel("Permisos");
		label_4.setFont(new Font("Century", Font.PLAIN, 16));
		label_4.setBounds(38, 160, 168, 14);
		panel.add(label_4);
		
		JCheckBox checkBox_0 = new JCheckBox("Administrar materiales");
		checkBox_0.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_0.setBounds(38, 181, 245, 23);
		panel.add(checkBox_0);
		
		JCheckBox checkBox_1 = new JCheckBox("Solicitar materiales");
		checkBox_1.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_1.setBounds(38, 207, 245, 23);
		panel.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("Entrada de materiales");
		checkBox_2.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_2.setBounds(38, 233, 245, 23);
		panel.add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("Salida de materiales");
		checkBox_3.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_3.setBounds(38, 259, 245, 23);
		panel.add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("New check box");
		checkBox_4.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_4.setBounds(38, 285, 245, 23);
		panel.add(checkBox_4);
		
		JCheckBox checkBox_5 = new JCheckBox("New check box");
		checkBox_5.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_5.setBounds(38, 311, 245, 23);
		panel.add(checkBox_5);
		
		JCheckBox checkBox_6 = new JCheckBox("New check box");
		checkBox_6.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_6.setBounds(285, 181, 268, 23);
		panel.add(checkBox_6);
		
		JCheckBox checkBox_7 = new JCheckBox("New check box");
		checkBox_7.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_7.setBounds(285, 207, 268, 23);
		panel.add(checkBox_7);
		
		JCheckBox checkBox_8 = new JCheckBox("New check box");
		checkBox_8.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_8.setBounds(285, 233, 268, 23);
		panel.add(checkBox_8);
		
		JCheckBox checkBox_9 = new JCheckBox("New check box");
		checkBox_9.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_9.setBounds(285, 285, 268, 23);
		panel.add(checkBox_9);
		
		JCheckBox checkBox_10 = new JCheckBox("New check box");
		checkBox_10.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_10.setBounds(285, 259, 268, 23);
		panel.add(checkBox_10);
		
		JCheckBox checkBox_11 = new JCheckBox("New check box");
		checkBox_11.setFont(new Font("Century", Font.PLAIN, 13));
		checkBox_11.setBounds(285, 311, 268, 23);
		panel.add(checkBox_11);
		
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
		button_1.setBounds(553, 25, 99, 35);
		contentPanel.add(button_1);
		button_1.setFont(new Font("Century", Font.PLAIN, 16));
		button_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

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
				if (comboBox.getSelectedItem().toString().equals("Seleccione un usuario...")){
					JOptionPane.showMessageDialog(null, "Elija un usuario.","Error",JOptionPane.PLAIN_MESSAGE);
				}
				else{
					UserQuery userQ=new UserQuery();
					User usuarioSeleccionado=userQ.buscarUsuario(textField.getText());
					Boolean continuar=true;
					PermisoQuery permisoQ = new PermisoQuery();
					for (JCheckBox jCheckBox : listCheckBox) {
						Permiso permiso=permisoQ.buscarPermiso(jCheckBox.getText());
						if (jCheckBox.isSelected()){
							usuarioSeleccionado.addPermiso(permiso);
						} 
						else{
							usuarioSeleccionado.delPermiso(permiso);
						}
					}	
					if (!(passwordField.getPassword().length==0 && passwordField_1.getPassword().length==0)){
						if (!passwordField.getText().equals(passwordField_1.getText())){
							continuar=false;
							JOptionPane.showMessageDialog(null, "Las contraseñas nuevas deben coincidir.","Error",JOptionPane.PLAIN_MESSAGE);
						}
						else{
							usuarioSeleccionado.setPassword(passwordField.getText());
						}
					}
					if(continuar){
						Home.session.update(usuarioSeleccionado);
						Home.session.flush();
						JOptionPane.showMessageDialog(null, "El usuario ha sido modificado correctamente.","Usuario modificado",JOptionPane.PLAIN_MESSAGE);
						Home.frmAuriHispanoamericanaSa.setEnabled(true);
						dispose();
					}
				}
			}
		});
		button.setBounds(433, 25, 99, 35);
		contentPanel.add(button);
		button.setFont(new Font("Century", Font.PLAIN, 16));
		button.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBox, textField, passwordField, passwordField_1, checkBox_0, checkBox_1, checkBox_2, checkBox_3, checkBox_4, checkBox_5, checkBox_6, checkBox_7, checkBox_8, checkBox_10, checkBox_9, checkBox_11, button, button_1}));
	
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
