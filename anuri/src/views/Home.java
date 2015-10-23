package views;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
import org.hibernate.Query;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
import java.util.Set;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.hibernate.Session;

import java.awt.Component;
import util.*;
import modelo.*;
import query.PermisoQuery;

import java.awt.event.WindowAdapter;

public class Home {
  private JDialog actual;
  static JFrame frmAuriHispanoamericanaSa;
  static User usuarioLogueado;
  public static Session session;
  private static JMenu mnAdministrarUsuarios=new JMenu("Administrar Usuarios");
  private static JMenuItem mntmIniciarSesion = new JMenuItem("Iniciar Sesi\u00F3n");
  private static JMenuItem mntmCambiarContrasea = new JMenuItem("Cambiar Contrase\u00F1a");
  private static JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesi\u00F3n");
  private static JMenuItem mntmEntrada = new JMenuItem("Entrada");
  private static JMenuItem mntmDespiece = new JMenuItem("Despiece");
  private static JMenuItem mntmSolicitud = new JMenuItem("Solicitud");
  private static JMenu mnAdministrarMateriales = new JMenu("Administrar Materiales");
  
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
		session = HibernateUtil.getSessionFactory().openSession();
		this.crearContextoInicial();
		Login log = new Login();
		log.setVisible(true);
		log.setLocationRelativeTo(frmAuriHispanoamericanaSa);
		actual=log;
		frmAuriHispanoamericanaSa.setEnabled(false);
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void crearContextoInicial(){
		mntmIniciarSesion.setEnabled(true);
		mntmCerrarSesion.setEnabled(false);
		mntmCambiarContrasea.setEnabled(false);
		mnAdministrarMateriales.setEnabled(false);
		mntmSolicitud.setEnabled(false);
		mntmEntrada.setEnabled(false);
		mntmDespiece.setEnabled(false);
		frmAuriHispanoamericanaSa.setTitle("A\u00F1uri Hispanoamericana S.A.");
		
		mnAdministrarUsuarios.setVisible(false);
	}
	
	public static void crearContextoParaUsuario(User usuario){
		mntmIniciarSesion.setEnabled(false);
		mntmCerrarSesion.setEnabled(true);
		usuarioLogueado=usuario;
		frmAuriHispanoamericanaSa.setTitle(usuarioLogueado.getNombre() + " - A\u00F1uri Hispanoamericana S.A.");
		
		mntmCambiarContrasea.setEnabled(true);
		if(usuarioLogueado.getNombre().equals("rocio")){
			mnAdministrarUsuarios.setVisible(true);
		}
		Set<Permiso> permisos_user=usuarioLogueado.getPermisos();
		
		for (Permiso permiso : permisos_user){
			String nombre=permiso.getNombre();
			switch(nombre){
			case "Administrar materiales":
				mnAdministrarMateriales.setEnabled(true);break;
			case "Solicitar materiales":
				mntmSolicitud.setEnabled(true);break;
			case "Entrada de materiales":
				mntmEntrada.setEnabled(true);break;
			case "Salida de materiales":
				mntmDespiece.setEnabled(true);break;
			}
		}
	}
	
	private void initialize() {
		frmAuriHispanoamericanaSa = new JFrame();
		frmAuriHispanoamericanaSa.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				session.close();
			}
		});
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
		
		Fondo panel=new Fondo("/anuri.jpg");	
		frmAuriHispanoamericanaSa.getContentPane().add(panel);
		
		JMenuBar menuBar = new JMenuBar();
		frmAuriHispanoamericanaSa.setJMenuBar(menuBar);
		
		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);
		
		
		mntmIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Login log = new Login();
			log.setLocationRelativeTo(frmAuriHispanoamericanaSa);
			log.setVisible(true);
			actual=log;
			frmAuriHispanoamericanaSa.setEnabled(false);
			}
		});
		mnUsuario.add(mntmIniciarSesion);
		
		
		mntmCambiarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangePassword cp=new ChangePassword();
				cp.setLocationRelativeTo(frmAuriHispanoamericanaSa);
				cp.setVisible(true);
				actual=cp;
				frmAuriHispanoamericanaSa.setEnabled(false);
			}
		});
		mnUsuario.add(mntmCambiarContrasea);
			
		
		mnUsuario.add(mnAdministrarUsuarios);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewUser nu = new NewUser(); 
				nu.setLocationRelativeTo(frmAuriHispanoamericanaSa);
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
				mu.setLocationRelativeTo(frmAuriHispanoamericanaSa);
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
				du.setLocationRelativeTo(frmAuriHispanoamericanaSa);
				du.setVisible(true);
				actual=du;
				frmAuriHispanoamericanaSa.setEnabled(false);
			}
		});
		mnAdministrarUsuarios.add(mntmEliminar);
		
		mnUsuario.add(mntmCerrarSesion);
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuarioLogueado=null;
				crearContextoInicial();
				JOptionPane.showMessageDialog(null, "Su sesión ha sido cerrada.","Mensaje",JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		JMenu mnMateriales = new JMenu("Materiales");
		menuBar.add(mnMateriales);
		
		mnMateriales.add(mntmEntrada);
		
		mnMateriales.add(mntmDespiece);
		
		mnMateriales.add(mntmSolicitud);
		
		mnMateriales.add(mnAdministrarMateriales);
		
		JMenuItem mntmNuevo_1 = new JMenuItem("Nuevo");
		mnAdministrarMateriales.add(mntmNuevo_1);
		
		JMenuItem mntmModificar_1 = new JMenuItem("Modificar");
		mnAdministrarMateriales.add(mntmModificar_1);
		
		mnAdministrarUsuarios.setVisible(false);
	}	
}
