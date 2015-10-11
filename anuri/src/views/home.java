package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import views.*;

public class home {

	private JFrame frmAuriHispanoamericanaSa;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
					window.frmAuriHispanoamericanaSa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAuriHispanoamericanaSa = new JFrame();
		frmAuriHispanoamericanaSa.setTitle("A\u00F1uri Hispanoamericana S.A.");
		frmAuriHispanoamericanaSa.setBounds(100, 100, 450, 300);
		frmAuriHispanoamericanaSa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmAuriHispanoamericanaSa.setJMenuBar(menuBar);
		
		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);
		
		JMenuItem mntmIniciarSesion = new JMenuItem("Iniciar Sesi\u00F3n");
		mntmIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			login log = new login(); 
			log.frmLogin.setVisible(true);
			frmAuriHispanoamericanaSa.setEnabled(false);
			}
		});
		mnUsuario.add(mntmIniciarSesion);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesi\u00F3n");
		mnUsuario.add(mntmCerrarSesion);
		
		JMenuItem mntmCambiarContrasea = new JMenuItem("Cambiar Contrase\u00F1a");
		mnUsuario.add(mntmCambiarContrasea);
		
		JMenuItem mntmAdministrarUsuarios = new JMenuItem("Administrar Usuarios");
		mnUsuario.add(mntmAdministrarUsuarios);
	}
}
