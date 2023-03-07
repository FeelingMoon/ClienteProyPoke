package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

@SuppressWarnings("serial")
public class VentanaCaptura extends JFrame {
	private JPanel ventana;
	private JLabel salir, fantasma, continuar, fondo;
	private JTextField nombre;
	private Color sc, pr;
	private Font fuente;
	private ArrayList<JLabel> botones;
	private JTextPane text, text2, text3;
	private JComboBox<String> cajas, pokemon;

	public VentanaCaptura(MouseListener mouse, MouseMotionListener momo) {
		fuente = Fuente.oFuente();
		ventana = new JPanel();
		salir = new JLabel("Exit", SwingConstants.CENTER);
		fantasma = new JLabel();
		continuar = new JLabel("Capture", SwingConstants.CENTER);
		fondo = new JLabel();
		nombre = new JTextField();
		pr = new Color(56, 56, 56);
		sc = new Color(72, 72, 72);
		botones = new ArrayList<>();
		text = new JTextPane();
		text2 = new JTextPane();
		text3 = new JTextPane();
		cajas = new JComboBox<>();
		pokemon = new JComboBox<>();
		//
		botones.add(salir);
		botones.add(fantasma);
		botones.add(continuar);
		//
		salir.setForeground(Color.WHITE);
		salir.setFont(fuente.deriveFont(Font.BOLD, 30));
		salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		salir.setBounds(0, 350, 200, 50);
		salir.addMouseListener(mouse);
		salir.setBackground(Color.RED);
		salir.setOpaque(true);
		fantasma.setBounds(0, 0, 300, 100);
		fantasma.addMouseListener(mouse);
		fantasma.addMouseMotionListener(momo);
		continuar.setForeground(Color.WHITE);
		continuar.setFont(fuente.deriveFont(Font.BOLD, 30));
		continuar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		continuar.setBounds(200, 350, 200, 50);
		continuar.addMouseListener(mouse);
		continuar.setBackground(pr);
		continuar.setOpaque(true);
		nombre.setForeground(Color.BLACK);
		nombre.setFont(fuente.deriveFont(Font.BOLD, 30));
		nombre.setCursor(new Cursor(Cursor.HAND_CURSOR));
		nombre.setBounds(25, 80, 350, 50);
		nombre.addMouseListener(mouse);
		nombre.setBackground(Color.WHITE);
		nombre.setOpaque(true);
		nombre.setBorder(new MatteBorder(2, 2, 2, 2, pr));
		pokemon.setForeground(Color.BLACK);
		pokemon.setFont(fuente.deriveFont(Font.BOLD, 30));
		pokemon.setBounds(25, 180, 350, 50);
		pokemon.setBackground(Color.WHITE);
		pokemon.setOpaque(true);
		pokemon.setBorder(new MatteBorder(2, 2, 2, 2, pr));
		cajas.setForeground(Color.BLACK);
		cajas.setFont(fuente.deriveFont(Font.BOLD, 30));
		cajas.setBounds(25, 280, 350, 50);
		cajas.setBackground(Color.WHITE);
		cajas.setOpaque(true);
		cajas.setBorder(new MatteBorder(2, 2, 2, 2, pr));
		text.setForeground(Color.BLACK);
		text.setFont(fuente.deriveFont(Font.BOLD, 30));
		text.setBounds(25, 40, 350, 30);
		text.setEditable(false);
		text.setOpaque(false);
		text.setText("Name: ");
		text2.setForeground(Color.BLACK);
		text2.setFont(fuente.deriveFont(Font.BOLD, 30));
		text2.setBounds(25, 140, 350, 30);
		text2.setEditable(false);
		text2.setOpaque(false);
		text2.setText("Pokemon: ");
		text3.setForeground(Color.BLACK);
		text3.setFont(fuente.deriveFont(Font.BOLD, 30));
		text3.setBounds(25, 240, 350, 30);
		text3.setEditable(false);
		text3.setOpaque(false);
		text3.setText("Location: ");
		//
		this.setSize(400, 400);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		//
		ventana.setSize(this.getSize());
		ventana.setLayout(null);
		ventana.add(text);
		ventana.add(text2);
		ventana.add(text3);
		ventana.add(cajas);
		ventana.add(pokemon);
		ventana.add(nombre);
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

	public String getNombre() {
		return nombre.getText();
	}

	public void setPokemones(String pokemones) {
		List<String> list = Arrays.asList(pokemones.split("&%&"));
		for (int i = 0; i < list.size(); i++) {
			pokemon.addItem(list.get(i));
		}
	}

	public void setCajas(boolean isFull) {
		cajas.removeAllItems();
		cajas.addItem("Box 1");
		cajas.addItem("Box 2");
		cajas.addItem("Box 3");
		if (!isFull) {
			cajas.addItem("Backpack");
		}
	}

	public String getCajas() {
		return (String) cajas.getSelectedItem();
	}

	public String getPokemon() {
		String end = "";
		String cad = (String) pokemon.getSelectedItem();
		for (int i = 0; i < cad.length(); i++) {
			if (Character.isDigit(cad.charAt(i)))
				end = end + cad.charAt(i);

		}
		return end;
	}

}
