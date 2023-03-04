package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class VentanaLiberar extends JFrame {
	private JPanel ventana;
	private JLabel salir, fantasma, continuar, fondo;
	private Color sc, pr;
	private Font fuente;
	private ArrayList<JLabel> botones;
	private JTextPane text;

	public VentanaLiberar(MouseListener mouse, MouseMotionListener momo) {
		fuente = Fuente.oFuente();
		ventana = new JPanel();
		salir = new JLabel("Return", SwingConstants.CENTER);
		fantasma = new JLabel();
		continuar = new JLabel("Release", SwingConstants.CENTER);
		fondo = new JLabel();
		pr = new Color(56, 56, 56);
		sc = new Color(72, 72, 72);
		botones = new ArrayList<>();
		text = new JTextPane();
		//
		botones.add(salir);
		botones.add(fantasma);
		botones.add(continuar);
		//
		salir.setForeground(Color.WHITE);
		salir.setFont(fuente.deriveFont(Font.BOLD, 30));
		salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		salir.setBounds(0, 150, 200, 50);
		salir.addMouseListener(mouse);
		salir.setBackground(Color.RED);
		salir.setOpaque(true);
		fantasma.setBounds(0, 0, 300, 100);
		fantasma.addMouseListener(mouse);
		fantasma.addMouseMotionListener(momo);
		continuar.setForeground(Color.WHITE);
		continuar.setFont(fuente.deriveFont(Font.BOLD, 30));
		continuar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		continuar.setBounds(200, 150, 200, 50);
		continuar.addMouseListener(mouse);
		continuar.setBackground(pr);
		continuar.setOpaque(true);
		text.setForeground(Color.WHITE);
		text.setFont(fuente.deriveFont(Font.BOLD, 38));
		text.setBounds(25, 50, 375, 100);
		text.setEditable(false);
		text.setOpaque(false);
		//
		this.setSize(400, 200);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		//
		ventana.setSize(this.getSize());
		ventana.setLayout(null);
		ventana.add(text);
		ventana.add(continuar);
		ventana.add(salir);
		ventana.add(fantasma);
		ventana.add(fondo);
		//
		this.add(ventana);
		fondo.setIcon(new ImageIcon(new ImageIcon("src/co/edu/unbosque/util/Assets/Images/fondo.png").getImage()
				.getScaledInstance((int) (this.getWidth()), (int) (this.getHeight()), Image.SCALE_DEFAULT)));
		fondo.setSize(((int) (this.getWidth())), (int) (this.getHeight()));
	}

	/**
	 * Method in charge of giving the labels (buttons) to give them their use.
	 * 
	 * @param x The label to give.
	 * @return The requested label.
	 */
	public JLabel obtenerLB(int x) {
		return botones.get(x);
	}

	/**
	 * Method that changes the color of the label when the mouse pointer passes over
	 * it.
	 * 
	 * @param x The label to change the color.
	 */
	public void interiorColor(int x) {
		if (x == 0) {
			salir.setBackground(Color.BLACK);
		} else {
			botones.get(x).setBackground(sc);
		}
	}

	/**
	 * Method that changes the color of the label when the mouse pointer leaves the
	 * label.
	 * 
	 * @param x The label to change the color.
	 */
	public void exteriorColor(int x) {
		if (x == 0) {
			salir.setBackground(Color.RED);
		} else {
			botones.get(x).setBackground(pr);
		}
	}

	/**
	 * Method that takes care of changing the location of the window.
	 * 
	 * @param x Location on the x-axis.
	 * @param y Location on the y-axis.
	 */
	public void ubicacion(int x, int y) {
		this.setLocation(x, y);

	}

	public boolean isLiberated() {
		return true;
	}

	public void cambiarTextoPoke(String poke) {
		text.setText("Do you want to release the " + poke + "?");
	}
}
