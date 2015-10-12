package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteUser extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DeleteUser dialog = new DeleteUser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DeleteUser() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setTitle("Eliminar usuario");
		setResizable(false);
		setBounds(100, 100, 418, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("Usuario");
			label.setFont(new Font("Century", Font.PLAIN, 16));
			label.setBounds(10, 34, 83, 29);
			contentPanel.add(label);
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setToolTipText("");
			comboBox.setName("");
			comboBox.setBounds(99, 34, 248, 29);
			contentPanel.add(comboBox);
		}
		{
			JButton button = new JButton("Cancelar");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Home.frmAuriHispanoamericanaSa.setEnabled(true);
					dispose();
				}
			});
			button.setFont(new Font("Century", Font.PLAIN, 16));
			button.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			button.setBounds(247, 113, 99, 35);
			contentPanel.add(button);
		}
		{
			JButton btnEliminar = new JButton("Eliminar");
			btnEliminar.setFont(new Font("Century", Font.PLAIN, 16));
			btnEliminar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			btnEliminar.setBounds(71, 113, 99, 35);
			contentPanel.add(btnEliminar);
		}
	}

}
