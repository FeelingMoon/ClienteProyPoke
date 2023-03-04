package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

@SuppressWarnings("serial")

/**
 * @author MiguelLinares
 * @author JohanSilva
 *
 */
public class PanelAbajo extends JPanel {
	private JPanel botones, principal, mv1Img, mv2Img, mv3Img, mv4Img, moveset;
	private JLabel imgA1, imgA2, imgB1, imgB2, imgC1, imgC2, imgD1, imgD2, grito, detalles, volver;
	private JTextPane mv1, mv2, mv3, mv4;
	private Font fuente;
	private ArrayList<JLabel> botoneses;
	private Color pr, sc;

	/**
	 * This method initializes the attributes, their own attributes and adds them to
	 * the JPanel
	 * 
	 * @param fuente   Font of the program
	 * @param listener Button Action Manager
	 */
	public PanelAbajo(MouseListener mouse) {
		fuente = Fuente.oFuente();
		botones = new JPanel();
		principal = new JPanel();
		moveset = new JPanel();
		mv1 = new JTextPane();
		mv2 = new JTextPane();
		mv3 = new JTextPane();
		mv4 = new JTextPane();
		mv1Img = new JPanel();
		mv2Img = new JPanel();
		mv3Img = new JPanel();
		mv4Img = new JPanel();
		imgA1 = new JLabel();
		imgA2 = new JLabel();
		imgB1 = new JLabel();
		imgB2 = new JLabel();
		imgC1 = new JLabel();
		imgC2 = new JLabel();
		imgD1 = new JLabel();
		imgD2 = new JLabel();
		grito = new JLabel("Sound", SwingConstants.CENTER);
		detalles = new JLabel("Details", SwingConstants.CENTER);
		volver = new JLabel("Go to PC", SwingConstants.CENTER);
		botoneses = new ArrayList<>();
		pr = new Color(56, 56, 56);
		sc = new Color(72, 72, 72);
		//
		botoneses.add(grito);
		botoneses.add(detalles);
		botoneses.add(volver);
		grito.addMouseListener(mouse);
		detalles.addMouseListener(mouse);
		volver.addMouseListener(mouse);
		//

		mv1Img.setLayout(new GridLayout(1, 2));
		mv1Img.setBorder(new BevelBorder(BevelBorder.RAISED));
		mv1Img.add(imgA1);
		mv1Img.add(imgA2);
		mv2Img.setLayout(new GridLayout(1, 2));
		mv2Img.setBorder(new BevelBorder(BevelBorder.RAISED));
		mv2Img.add(imgB1);
		mv2Img.add(imgB2);
		mv3Img.setLayout(new GridLayout(1, 2));
		mv3Img.setBorder(new BevelBorder(BevelBorder.RAISED));
		mv3Img.add(imgC1);
		mv3Img.add(imgC2);
		mv4Img.setLayout(new GridLayout(1, 2));
		mv4Img.setBorder(new BevelBorder(BevelBorder.RAISED));
		mv4Img.add(imgD1);
		mv4Img.add(imgD2);
		imgA1.setIcon(null);
		imgA2.setIcon(null);
		imgB1.setIcon(null);
		imgB2.setIcon(null);
		imgC1.setIcon(null);
		imgC2.setIcon(null);
		imgD1.setIcon(null);
		imgD2.setIcon(null);
		mv1.setEditable(false);
		mv1.setFont(fuente);
		mv1.setBorder(new BevelBorder(BevelBorder.RAISED));
		mv2.setEditable(false);
		mv2.setFont(fuente);
		mv2.setBorder(new BevelBorder(BevelBorder.RAISED));
		mv3.setEditable(false);
		mv3.setFont(fuente);
		mv3.setBorder(new BevelBorder(BevelBorder.RAISED));
		mv4.setEditable(false);
		mv4.setFont(fuente);
		mv4.setBorder(new BevelBorder(BevelBorder.RAISED));
		moveset.setLayout(new GridLayout(4, 4));
		moveset.add(mv1);
		moveset.add(mv2);
		moveset.add(mv1Img);
		moveset.add(mv2Img);
		moveset.add(mv3);
		moveset.add(mv4);
		moveset.add(mv3Img);
		moveset.add(mv4Img);
		moveset.setBorder(new MatteBorder(5, 5, 5, 5, Color.RED));
		moveset.setBounds(8, 60, 584, 250);
		principal.setLayout(null);
		principal.add(moveset);
		principal.setBackground(Color.WHITE);
		principal.setPreferredSize(new Dimension(600, 400));
		grito.setFont(fuente.deriveFont(Font.BOLD));
		grito.setBorder(new MatteBorder(5, 5, 5, 5, Color.BLACK));
		grito.setForeground(Color.WHITE);
		grito.setBackground(pr);
		grito.setCursor(new Cursor(Cursor.HAND_CURSOR));
		grito.setOpaque(true);
		detalles.setFont(fuente.deriveFont(Font.BOLD));
		detalles.setBorder(new MatteBorder(5, 5, 5, 5, Color.BLACK));
		detalles.setForeground(Color.WHITE);
		detalles.setBackground(pr);
		detalles.setOpaque(true);
		detalles.setCursor(new Cursor(Cursor.HAND_CURSOR));
		volver.setFont(fuente.deriveFont(Font.BOLD));
		volver.setBorder(new MatteBorder(5, 5, 5, 5, Color.BLACK));
		volver.setForeground(Color.WHITE);
		volver.setBackground(pr);
		volver.setOpaque(true);
		volver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		botones.setLayout(new GridLayout(1, 3));
		botones.setPreferredSize(new Dimension(600, 70));
		botones.add(detalles);
		botones.add(grito);
		botones.add(volver);
		this.setLayout(new BorderLayout());
		this.add(principal, BorderLayout.CENTER);
		this.add(botones, BorderLayout.SOUTH);

	}

	/**
	 * this method allows to change info of movements of pokemons
	 * 
	 * @param nMv1  Movement
	 * @param urlA1 Url of the image
	 * @param urlA2 Url of the image
	 * @param nMv2  Movement
	 * @param urlB1 Url of the image
	 * @param urlB2 Url of the image
	 * @param nMv3  Movement
	 * @param urlC1 Url of the image
	 * @param urlC2 Url of the image
	 * @param nMv4  Movement
	 * @param urlD1 Url of the image
	 * @param urlD2 Url of the image
	 */
	public void cambiarMovimientos(String nMv1, String urlA1, String urlA2, String nMv2, String urlB1, String urlB2,
			String nMv3, String urlC1, String urlC2, String nMv4, String urlD1, String urlD2) {
		mv1.setText(nMv1);
		imgA1.setIcon(new ImageIcon(new ImageIcon(urlA1).getImage().getScaledInstance(75, 30, Image.SCALE_DEFAULT)));
		imgA2.setIcon(new ImageIcon(new ImageIcon(urlA2).getImage().getScaledInstance(80, 35, Image.SCALE_DEFAULT)));
		mv2.setText(nMv2);
		imgB1.setIcon(new ImageIcon(new ImageIcon(urlB1).getImage().getScaledInstance(75, 30, Image.SCALE_DEFAULT)));
		imgB2.setIcon(new ImageIcon(new ImageIcon(urlB2).getImage().getScaledInstance(80, 35, Image.SCALE_DEFAULT)));
		mv3.setText(nMv3);
		imgC1.setIcon(new ImageIcon(new ImageIcon(urlC1).getImage().getScaledInstance(75, 30, Image.SCALE_DEFAULT)));
		imgC2.setIcon(new ImageIcon(new ImageIcon(urlC2).getImage().getScaledInstance(80, 35, Image.SCALE_DEFAULT)));
		mv4.setText(nMv4);
		imgD1.setIcon(new ImageIcon(new ImageIcon(urlD1).getImage().getScaledInstance(75, 30, Image.SCALE_DEFAULT)));
		imgD2.setIcon(new ImageIcon(new ImageIcon(urlD2).getImage().getScaledInstance(80, 35, Image.SCALE_DEFAULT)));
	}

	/**
	 * Method in charge of giving the labels (buttons) to give them their use.
	 * 
	 * @param x The label to give.
	 * @return The requested label.
	 */
	public JLabel obtenerLB(int x) {
		return botoneses.get(x);
	}

	/**
	 * Method that changes the color of the label when the mouse pointer passes over
	 * it.
	 * 
	 * @param x The label to change the color.
	 */
	public void interiorColor(int x) {
		botoneses.get(x).setBackground(sc);
	}

	/**
	 * Method that changes the color of the label when the mouse pointer leaves the
	 * label.
	 * 
	 * @param x The label to change the color.
	 */
	public void exteriorColor(int x) {
		botoneses.get(x).setBackground(pr);
	}

}
