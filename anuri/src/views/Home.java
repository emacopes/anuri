package views;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
import org.hibernate.Query;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import views.*;
import java.awt.Frame;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Choice;
import java.awt.Dimension;
import javax.swing.JInternalFrame;
import java.awt.event.WindowFocusListener;
import java.util.List;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.hibernate.Session;

import java.awt.Component;
import util.*;
import modelo.*;

public class Home {
  private JDialog actual;
  static JFrame frmAuriHispanoamericanaSa;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}
	private void ListarUsuarios(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
       // List var = session.createQuery("select u.userId, u.nombre from User as u").list();
       // System.out.println(var.toString());      
        User usuario= new User();
        usuario.setNombre("pepe");
        usuario.setPassword("123");
        Permiso permiso= new Permiso();
        permiso.setNombre("login");
        usuario.setPermisos(permiso);
        session.save(usuario);
        session.getTransaction().commit();
        session.close();
        
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAuriHispanoamericanaSa = new JFrame();
		frmAuriHispanoamericanaSa.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				if (actual != null) {actual.toFront();}
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		frmAuriHispanoamericanaSa.setMinimumSize(new Dimension(800, 600));
		frmAuriHispanoamericanaSa.setExtendedState(Frame.MAXIMIZED_BOTH);
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
			Login log = new Login();
			log.setVisible(true);
			actual=log;
			frmAuriHispanoamericanaSa.setEnabled(false);
			}
		});
		mnUsuario.add(mntmIniciarSesion);
		
		JMenuItem mntmCambiarContrasea = new JMenuItem("Cambiar Contrase\u00F1a");
		mntmCambiarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangePassword cp=new ChangePassword();
				cp.setVisible(true);
				actual=cp;
				frmAuriHispanoamericanaSa.setEnabled(false);
			}
		});
		mnUsuario.add(mntmCambiarContrasea);
			
		JMenu mnAdministrarUsuarios = new JMenu("Administrar Usuarios");
		mnUsuario.add(mnAdministrarUsuarios);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewUser nu = new NewUser(); 
				nu.setVisible(true);
				actual=nu;
				frmAuriHispanoamericanaSa.setEnabled(false);
			}
		});
		mnAdministrarUsuarios.add(mntmNuevo);
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyUser mu=new ModifyUser();
				mu.setVisible(true);
				actual=mu;
				frmAuriHispanoamericanaSa.setEnabled(false);
			}
		});
		mnAdministrarUsuarios.add(mntmModificar);
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteUser du=new DeleteUser();
				du.setVisible(true);
				actual=du;
				frmAuriHispanoamericanaSa.setEnabled(false);
			}
		});
		mnAdministrarUsuarios.add(mntmEliminar);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesi\u00F3n");
		mnUsuario.add(mntmCerrarSesion);
		
		
		
		mntmCerrarSesion.setEnabled(false);
		//mntmCambiarContrasea.setEnabled(false);
		
		JMenu mnMateriales = new JMenu("Materiales");
		menuBar.add(mnMateriales);
		
		JMenuItem mntmEntrada = new JMenuItem("Entrada");
		mnMateriales.add(mntmEntrada);
		
		JMenuItem mntmDespiece = new JMenuItem("Despiece");
		mnMateriales.add(mntmDespiece);
		
		JMenuItem mntmSolicitud = new JMenuItem("Solicitud");
		mnMateriales.add(mntmSolicitud);
		
		JMenu mnAdministrarMateriales = new JMenu("Administrar Materiales");
		mnMateriales.add(mnAdministrarMateriales);
		
		JMenuItem mntmNuevo_1 = new JMenuItem("Nuevo");
		mnAdministrarMateriales.add(mntmNuevo_1);
		
		JMenuItem mntmModificar_1 = new JMenuItem("Modificar");
		mnAdministrarMateriales.add(mntmModificar_1);
		frmAuriHispanoamericanaSa.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListarUsuarios();
			}
		});
		btnNewButton.setBounds(131, 183, 89, 23);
		frmAuriHispanoamericanaSa.getContentPane().add(btnNewButton);
		//mnAdministrarUsuarios.setVisible(false);
	}	
}
