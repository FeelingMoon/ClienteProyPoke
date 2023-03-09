package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;

@SuppressWarnings("serial")
/**
 * Class in charge of the above part of the pokemon information.
 * 
 * @author Miguel Linares
 * @author Johan Silva
 */
public class PanelArriba extends JPanel {
	private JPanel tituloPanel, principal, pokeTipo, estadisticas;
	private JLabel imagen, tipo1, tipo2;
	private JProgressBar hp, att, def, sp_att, sp_def, spd;
	private JTextPane descripcion, nombreId, habilidad;
	private Font fuente;

	/**
	 * This method initializes the attributes, their own attributes and adds them to
	 * the JPanel
	 * 
	 * @param fuente Font of program
	 */
	public PanelArriba() {
		fuente = Fuente.oFuente();
		tituloPanel = new JPanel();
		principal = new JPanel();
		descripcion = new JTextPane();
		imagen = new JLabel();
		hp = new JProgressBar();
		att = new JProgressBar();
		def = new JProgressBar();
		sp_att = new JProgressBar();
		sp_def = new JProgressBar();
		spd = new JProgressBar();
		estadisticas = new JPanel();
		tipo1 = new JLabel();
		tipo2 = new JLabel();
		nombreId = new JTextPane();
		pokeTipo = new JPanel();
		habilidad = new JTextPane();
		//
		tituloPanel.setBackground(Color.RED);
		tituloPanel.setBorder(new MatteBorder(0, 20, 5, 0, new Color(129, 0, 0)));
		tituloPanel.setPreferredSize(new Dimension(600, 50));
		//
		habilidad.setFont(fuente.deriveFont(Font.BOLD));
		habilidad.setEditable(false);
		habilidad.setOpaque(false);
		habilidad.setBounds(350, 110, 250, 100);
		//
		imagen.setBounds(55, 2, 180, 200);
		//
		nombreId.setFont(fuente.deriveFont(Font.BOLD));
		nombreId.setEditable(false);
		nombreId.setBackground(Color.RED);
		nombreId.setForeground(Color.WHITE);
		nombreId.setBorder(new MatteBorder(0, 10, 5, 0, new Color(129, 0, 0)));
		nombreId.setBounds(350, 0, 250, 50);
		//
		pokeTipo.setOpaque(false);
		pokeTipo.setLayout(new GridLayout(1, 2));
		pokeTipo.add(tipo1);
		pokeTipo.add(tipo2);
		pokeTipo.setBounds(350, 60, 200, 40);
		//
		descripcion.setFont(fuente);
		descripcion.setEditable(false);
		descripcion.setBorder(new MatteBorder(2, 8, 2, 8, Color.RED));
		descripcion.setBounds(0, 212, 585, 120);
		//
		hp.setStringPainted(true);
		hp.setMinimum(0);
		hp.setMaximum(255);
		hp.setForeground(new Color(255, 100, 100));
		hp.setValue(0);
		hp.setFont(fuente.deriveFont(Font.BOLD, 18));
		//
		att.setStringPainted(true);
		att.setMinimum(0);
		att.setMaximum(190);
		att.setForeground(new Color(255, 100, 100));
		att.setValue(0);
		att.setFont(fuente.deriveFont(Font.BOLD, 18));
		//
		def.setStringPainted(true);
		def.setMinimum(0);
		def.setMaximum(250);
		def.setForeground(new Color(255, 100, 100));
		def.setValue(0);
		def.setFont(fuente.deriveFont(Font.BOLD, 18));
		//
		sp_att.setStringPainted(true);
		sp_att.setMinimum(0);
		sp_att.setMaximum(194);
		sp_att.setForeground(new Color(255, 100, 100));
		sp_att.setValue(0);
		sp_att.setFont(fuente.deriveFont(Font.BOLD, 18));
		//
		sp_def.setStringPainted(true);
		sp_def.setMinimum(0);
		sp_def.setMaximum(250);
		sp_def.setForeground(new Color(255, 100, 100));
		sp_def.setValue(0);
		sp_def.setFont(fuente.deriveFont(Font.BOLD, 18));
		//
		spd.setStringPainted(true);
		spd.setMinimum(0);
		spd.setMaximum(180);
		spd.setForeground(new Color(255, 100, 100));
		spd.setValue(0);
		spd.setFont(fuente.deriveFont(Font.BOLD, 18));
		//
		estadisticas.setLayout(new GridLayout(6, 1));
		estadisticas.setBackground(Color.WHITE);
		estadisticas.add(hp);
		estadisticas.add(att);
		estadisticas.add(def);
		estadisticas.add(sp_att);
		estadisticas.add(sp_def);
		estadisticas.add(spd);
		estadisticas.setBounds(300, 30, 250, 150);
		//
		principal.setLayout(null);
		principal.setPreferredSize(new Dimension(600, 400));
		principal.add(imagen);
		principal.add(habilidad);
		principal.add(descripcion);
		principal.add(nombreId);
		principal.add(pokeTipo);
		principal.add(estadisticas);
		principal.setBackground(Color.WHITE);
		estadisticas.setVisible(false);
		//
		this.setLayout(new BorderLayout());
		this.add(tituloPanel, BorderLayout.NORTH);
		this.add(principal, BorderLayout.CENTER);
		//

	}

	/**
	 * Method that makes visible the name, type(s) and abilities of the pokemon
	 */
	public boolean panelPrincipalActivo() {
		if (!nombreId.isVisible()) {
			nombreId.setVisible(true);
			pokeTipo.setVisible(true);
			habilidad.setVisible(true);
			estadisticas.setVisible(false);
			return false;
		}
		return true;
	}

	/**
	 * Method that only makes visible the stats of the pokemon
	 */
	public boolean panelEstadisActivo() {
		if (!estadisticas.isVisible()) {
			estadisticas.setVisible(true);
			habilidad.setVisible(false);
			nombreId.setVisible(false);
			pokeTipo.setVisible(false);
			return false;
		}
		return true;
	}

	/**
	 * Method that allows to change the image of a pokemon
	 * 
	 * @param url Url of the image
	 */
	public void imagenPokeCambio(String url) {
		imagen.setIcon(new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(180, 200, Image.SCALE_DEFAULT)));
	}

	/**
	 * Method that allows to change the name of a pokemon
	 * 
	 * @param nombre Name of the pokemon
	 */
	public void cambiarNombre(String nombre) {
		nombreId.setText(nombre);
	}

	/**
	 * Method that allows to change the description of a pokemon
	 * 
	 * @param descrip Description of the pokemon
	 */
	public void cambiarDescripcion(String descrip) {
		descripcion.setText(descrip);
	}

	/**
	 * method that allows to change the type(s) of a pokemon
	 * 
	 * @param url1 Url of the image
	 * @param url2 Url of the image
	 */
	public void cambiarTipos(String url1, String url2) {
		tipo1.setIcon(new ImageIcon(new ImageIcon(url1).getImage().getScaledInstance(75, 30, Image.SCALE_DEFAULT)));
		tipo2.setIcon(new ImageIcon(new ImageIcon(url2).getImage().getScaledInstance(75, 30, Image.SCALE_DEFAULT)));
	}

	/**
	 * Method that allows to change the stats of a pokemon
	 * 
	 * @param hpV Health points
	 * @param atV Attack points
	 * @param deV Defense points
	 * @param stV Special attack points
	 * @param sdV Special defense points
	 * @param veV Speed points
	 */
	public void cambiarEstadis(int hpV, int atV, int deV, int stV, int sdV, int veV) {
		hp.setString("Healt points " + hpV);
		hp.setValue(hpV);
		att.setValue(atV);
		att.setString("Physical attack points " + atV);
		def.setValue(deV);
		def.setString("Physical defense points " + deV);
		sp_att.setValue(stV);
		sp_att.setString("Special attack points " + stV);
		sp_def.setValue(sdV);
		sp_def.setString("Special defense points " + sdV);
		spd.setValue(veV);
		spd.setString("Speed points " + veV);
	}

	/**
	 * Method that allows to change the abilities of a pokemon
	 * 
	 * @param h1 Hability of the pokemon
	 * @param h2 Hability of the pokemon
	 * @param h3 Hability of the pokemon
	 */
	public void cambiarHabilidades(String h1, String h2, String h3) {
		habilidad.setText(h1 + "\n" + h2 + "\n" + h3 + "\n");
	}
}
