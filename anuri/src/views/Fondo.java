package views;


import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Fondo extends JPanel {
	ImageIcon imagen;
	String nombre;
	static Dimension tamanio;
	
	public Fondo(String nombre){
		this.nombre=nombre;
	}
	
	public void paint(Graphics g){
		tamanio=getSize();
		imagen=new ImageIcon(getClass().getResource(nombre));
		g.drawImage(imagen.getImage(), 0, 0, tamanio.width,tamanio.height, null);
		setOpaque(false);
		super.paint(g);
	}
}
