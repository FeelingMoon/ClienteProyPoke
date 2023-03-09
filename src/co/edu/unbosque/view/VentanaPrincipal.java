package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemListener;
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
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

/**
 * 
 * Class in charge of creating the main window.
 * 
 * @author Miguel Linares
 * @author Johan Silva
 *
 */
@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {
	private JPanel ventana;
	private JLabel salir, fantasma, pokemon1, pokemon2, pokemon3, pokemon4, pokemon5, pokemon6;
	private JLabel caja, barra, bolsillo, datos, liberar, mover, sumar, imagen, fondo, derecha, izquierda, actualizar;
	private JComboBox<String> pokemones;
	private ArrayList<JLabel> botones, pokesBolsillo;
	private JTextPane titulo;
	private Color sc, pr;
	private Dimension dCaja, dBarra;
	private Font fuente;
	private int cajaActual;

	/**
	 * Cosntructor where you initialize what is used in the window.
	 * 
	 * @param mouse   Mouse action listener
	 * @param momo    Motion Mouse Actions Listener
	 * @param itemLis Item Action Listener
	 */
	public VentanaPrincipal(MouseListener mouse, MouseMotionListener motion, ItemListener itemLis) {
		cajaActual = 1;
		pokemones = new JComboBox<>();
		ventana = new JPanel();
		salir = new JLabel("EXIT", SwingConstants.CENTER);
		fantasma = new JLabel();
		botones = new ArrayList<>();
		caja = new JLabel();
		barra = new JLabel();
		bolsillo = new JLabel();
		datos = new JLabel("Information", SwingConstants.CENTER);
		mover = new JLabel("Move", SwingConstants.CENTER);
		liberar = new JLabel("Liberate", SwingConstants.CENTER);
		sumar = new JLabel("Capture", SwingConstants.CENTER);
		actualizar = new JLabel("Update", SwingConstants.CENTER);
		pr = new Color(56, 56, 56);
		sc = new Color(72, 72, 72);
		dCaja = new Dimension(168 * 5, 121 * 5);
		dBarra = new Dimension(168 * 5, 19 * 4);
		fuente = Fuente.oFuente();
		pokemon1 = new JLabel();
		pokemon2 = new JLabel();
		pokemon3 = new JLabel();
		pokemon4 = new JLabel();
		pokemon5 = new JLabel();
		pokemon6 = new JLabel();
		imagen = new JLabel();
		titulo = new JTextPane();
		fondo = new JLabel();
		izquierda = new JLabel("<", SwingConstants.CENTER);
		derecha = new JLabel(">", SwingConstants.CENTER);
		pokesBolsillo = new ArrayList<>();
		//
		botones.add(salir);
		botones.add(fantasma);
		botones.add(liberar);
		botones.add(mover);
		botones.add(sumar);
		botones.add(datos);
		botones.add(pokemon1);
		botones.add(pokemon2);
		botones.add(pokemon3);
		botones.add(pokemon4);
		botones.add(pokemon5);
		botones.add(pokemon6);
		botones.add(izquierda);
		botones.add(derecha);
		botones.add(actualizar);
		//
		pokesBolsillo.add(pokemon1);
		pokesBolsillo.add(pokemon2);
		pokesBolsillo.add(pokemon3);
		pokesBolsillo.add(pokemon4);
		pokesBolsillo.add(pokemon5);
		pokesBolsillo.add(pokemon6);
		//
		salir.setForeground(Color.WHITE);
		salir.setFont(fuente.deriveFont(Font.BOLD, 30));
		salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
		salir.setBounds(90, 550, 150, 50);
		salir.addMouseListener(mouse);
		salir.setBackground(Color.RED);
		salir.setOpaque(true);
		actualizar.setForeground(Color.WHITE);
		actualizar.setFont(fuente.deriveFont(Font.BOLD, 30));
		actualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		actualizar.setBounds(90, 400, 150, 50);
		actualizar.addMouseListener(mouse);
		actualizar.setBackground(Color.RED);
		actualizar.setOpaque(true);
		fantasma.setBounds(0, 0, 1280, 100);
		fantasma.addMouseListener(mouse);
		fantasma.addMouseMotionListener(motion);
		mover.setForeground(Color.WHITE);
		mover.setBackground(pr);
		mover.setFont(fuente.deriveFont(Font.BOLD, 30));
		mover.setCursor(new Cursor(Cursor.HAND_CURSOR));
		mover.setBounds(100, 150, 200, 50);
//		mover.addMouseListener(mouse);
		mover.setOpaque(true);
		liberar.setForeground(Color.WHITE);
		liberar.setBackground(pr);
		liberar.setFont(fuente.deriveFont(Font.BOLD, 30));
		liberar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		liberar.setBounds(100, 250, 200, 50);
//		liberar.addMouseListener(mouse);
		liberar.setOpaque(true);
		sumar.setForeground(Color.WHITE);
		sumar.setBackground(pr);
		sumar.setFont(fuente.deriveFont(Font.BOLD, 30));
		sumar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sumar.setBounds(100, 350, 200, 50);
		sumar.addMouseListener(mouse);
		sumar.setOpaque(true);
		datos.setForeground(Color.WHITE);
		datos.setBackground(pr);
		datos.setFont(fuente.deriveFont(Font.BOLD, 30));
		datos.setCursor(new Cursor(Cursor.HAND_CURSOR));
		datos.setBounds(100, 450, 200, 50);
//		datos.addMouseListener(mouse);
		datos.setOpaque(true);
		izquierda.setForeground(Color.WHITE);
		izquierda.setFont(fuente.deriveFont(Font.BOLD, 50));
		izquierda.setCursor(new Cursor(Cursor.HAND_CURSOR));
		izquierda.setBounds(25, 15, 50, 50);
		izquierda.addMouseListener(mouse);
		derecha.setForeground(Color.WHITE);
		derecha.setFont(fuente.deriveFont(Font.BOLD, 50));
		derecha.setCursor(new Cursor(Cursor.HAND_CURSOR));
		derecha.setBounds((int) (dBarra.getWidth() - 75), 15, 50, 50);
		derecha.addMouseListener(mouse);
		//
		pokemones.setBounds(32, 38, 775, 50);
		pokemones.setMaximumRowCount(3);
		pokemones.setFont(fuente);
		pokemones.setBackground(pr);
		pokemones.setEditable(false);
		pokemones.setForeground(Color.WHITE);
		if (pokemones.getItemCount() == 0) {
			pokemones.setEnabled(false);
			liberar.setEnabled(false);
			liberar.addMouseListener(null);
			mover.setEnabled(false);
			mover.addMouseListener(null);
			datos.setEnabled(false);
			datos.addMouseListener(null);
		} else {
			pokemones.setEnabled(true);
			liberar.setEnabled(true);
			mover.setEnabled(true);
			datos.setEnabled(true);
			liberar.addMouseListener(mouse);
			mover.addMouseListener(mouse);
			datos.addMouseListener(mouse);
		}
		caja.setIcon(new ImageIcon(new ImageIcon("src/co/edu/unbosque/util/Assets/Images/Inf1.png").getImage()
				.getScaledInstance((int) (dCaja.getWidth()), (int) (dCaja.getHeight() - 85), Image.SCALE_DEFAULT)));
		caja.setBounds(425, 120, (int) (dCaja.getWidth()), (int) (dCaja.getHeight() - 85));
		imagen.setBounds(445, 150, 300, 350);
		imagen.setBackground(Color.red);
		imagen.setOpaque(true);
		caja.add(pokemones);
		caja.add(mover);
		caja.add(liberar);
		caja.add(datos);
		caja.add(sumar);
		caja.add(imagen);
		//
		barra.setIcon(new ImageIcon(new ImageIcon("src/co/edu/unbosque/util/Assets/Images/Sup1.png").getImage()
				.getScaledInstance((int) (dBarra.getWidth()), (int) (dBarra.getHeight()), Image.SCALE_DEFAULT)));
		barra.setBounds(425, 20, (int) (dBarra.getWidth()), (int) (dBarra.getHeight()));
		titulo.setFont(fuente.deriveFont(0, 55));
		titulo.setForeground(Color.black);
		titulo.setBounds(350, 15, 150, 50);
		titulo.setOpaque(false);
		titulo.setEditable(false);
		titulo.setText("Box 1");
		barra.add(titulo);
		barra.add(izquierda);
		barra.add(derecha);
		//
		bolsillo.setIcon(new ImageIcon(new ImageIcon("src/co/edu/unbosque/util/Assets/Images/bolsillo.png").getImage()
				.getScaledInstance(120 * 3, 208 * 3, Image.SCALE_DEFAULT)));
		bolsillo.setBounds(32, 20, 120 * 3, 208 * 3);
		bolsillo.add(salir);
		bolsillo.add(actualizar);
		pokemon1.setBounds(45, 75, 100, 100);
		pokemon1.setBackground(Color.pink);
		pokemon1.setOpaque(true);
		pokemon1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pokemon1.addMouseListener(mouse);
		pokemon2.setBounds(190, 100, 100, 100);
		pokemon2.setBackground(Color.pink);
		pokemon2.setOpaque(true);
		pokemon2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pokemon2.addMouseListener(mouse);
		pokemon3.setBounds(45, 195, 100, 100);
		pokemon3.setBackground(Color.pink);
		pokemon3.setOpaque(true);
		pokemon3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pokemon3.addMouseListener(mouse);
		pokemon4.setBounds(190, 220, 100, 100);
		pokemon4.setBackground(Color.pink);
		pokemon4.setOpaque(true);
		pokemon4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pokemon4.addMouseListener(mouse);
		pokemon5.setBounds(45, 315, 100, 100);
		pokemon5.setBackground(Color.pink);
		pokemon5.setOpaque(true);
		pokemon5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pokemon5.addMouseListener(mouse);
		pokemon6.setBounds(190, 340, 100, 100);
		pokemon6.setBackground(Color.pink);
		pokemon6.setOpaque(true);
		pokemon6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pokemon6.addMouseListener(mouse);
		bolsillo.add(pokemon1);
		bolsillo.add(pokemon2);
		bolsillo.add(pokemon3);
		bolsillo.add(pokemon4);
		bolsillo.add(pokemon5);
		bolsillo.add(pokemon6);
		//
		this.setSize(1280, 675);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		//
		ventana.setSize(this.getSize());
		ventana.setLayout(null);
		ventana.setBackground(Color.BLUE);
		ventana.add(bolsillo);
		ventana.add(caja);
		ventana.add(barra);
		ventana.add(fantasma);
		ventana.add(fondo);
		//
		this.add(ventana);
		fondo.setIcon(new ImageIcon(new ImageIcon("src/co/edu/unbosque/util/Assets/Images/fondo.png").getImage()
				.getScaledInstance((int) (this.getWidth()), (int) (this.getHeight()), Image.SCALE_DEFAULT)));
		fondo.setSize(((int) (this.getWidth())), (int) (this.getHeight()));
		pokemones.addItemListener(itemLis);
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
		if (x == 0 || x == 14) {
			botones.get(x).setForeground(Color.BLACK);
		} else if (x < 6) {
			botones.get(x).setBackground(sc);
		} else if (x > 11) {
			botones.get(x).setForeground(pr);
		}
	}

	/**
	 * Method that changes the color of the label when the mouse pointer leaves the
	 * label.
	 * 
	 * @param x The label to change the color.
	 */
	public void exteriorColor(int x) {
		if (x == 0 || x == 14) {
			botones.get(x).setForeground(Color.RED);
		} else if (x < 6) {
			botones.get(x).setBackground(pr);
		} else if (x > 11) {
			botones.get(x).setForeground(Color.WHITE);
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

	/**
	 * Method for adding a pokemon to the selection.
	 * 
	 * @param nombre Name of the pokemon.
	 */
	public void agregarComboBox(String nombre) {
		pokemones.addItem(nombre);
	}

	/**
	 * Method that remove the ComboBox
	 */
	public void eliminarComboBox() {
		pokemones.removeAllItems();
	}

	/**
	 * Method that remove an item from the ComboBox
	 * 
	 * @param i Int of the index
	 */
	public void eliminarItem(int i) {
		pokemones.removeItemAt(i);
	}

	/**
	 * This method adds the ItemListener to the ComboBox
	 * 
	 * @param lsitener Listener of the comboBox
	 */
	public void colocarItemListener(ItemListener lsitener) {
		pokemones.addItemListener(lsitener);
	}

	/**
	 * this method allows to select and index from ComboBox
	 * 
	 * @param i Int of the index
	 */
	public void seleccionar(int i) {
		pokemones.setSelectedIndex(i);
	}

	/**
	 * This method gets the ComboBox
	 * 
	 * @return the ComboBox "pokemones"
	 */
	public JComboBox<String> getCombo() {
		return pokemones;
	}

	/**
	 * Method in charge of the main pokemon change.
	 * 
	 * @param url Url of the imagen.
	 */
	public void cambioImagen(String url) {
		if (url != null) {
			imagen.setOpaque(true);
			imagen.setIcon(new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(imagen.getWidth(),
					imagen.getHeight(), Image.SCALE_DEFAULT)));
		} else {
			imagen.setOpaque(false);
		}
	}

	/**
	 * Method in charge of changing boxes in the main window.
	 * 
	 * @param x     Box selected
	 * @param pokes Pokemons in the box
	 */
	public void cambioCaja(int x, String pokes) {
		if (x == 1 && pokes != null) {
			caja.setIcon(new ImageIcon(new ImageIcon("src/co/edu/unbosque/util/Assets/Images/Inf1.png").getImage()
					.getScaledInstance((int) (dCaja.getWidth()), (int) (dCaja.getHeight() - 85), Image.SCALE_DEFAULT)));
			barra.setIcon(new ImageIcon(new ImageIcon("src/co/edu/unbosque/util/Assets/Images/Sup1.png").getImage()
					.getScaledInstance((int) (dBarra.getWidth()), (int) (dBarra.getHeight()), Image.SCALE_DEFAULT)));
			titulo.setText("Box 1");
			cajaActual = 1;
			pokemones.removeAllItems();
			List<String> list = Arrays.asList(pokes.split("&%&"));
			for (int i = 0; i < list.size(); i++) {
				pokemones.addItem(list.get(i));
			}
		} else if (x == 2 && pokes != null)

		{
			caja.setIcon(new ImageIcon(new ImageIcon("src/co/edu/unbosque/util/Assets/Images/Inf2.png").getImage()
					.getScaledInstance((int) (dCaja.getWidth()), (int) (dCaja.getHeight() - 85), Image.SCALE_DEFAULT)));
			barra.setIcon(new ImageIcon(new ImageIcon("src/co/edu/unbosque/util/Assets/Images/Sup2.png").getImage()
					.getScaledInstance((int) (dBarra.getWidth()), (int) (dBarra.getHeight()), Image.SCALE_DEFAULT)));
			titulo.setText("Box 2");
			cajaActual = 2;
			pokemones.removeAllItems();
			List<String> list = Arrays.asList(pokes.split("&%&"));
			for (int i = 0; i < list.size(); i++) {
				pokemones.addItem(list.get(i));
			}
		} else if (x == 3 && pokes != null) {
			caja.setIcon(new ImageIcon(new ImageIcon("src/co/edu/unbosque/util/Assets/Images/Inf3.png").getImage()
					.getScaledInstance((int) (dCaja.getWidth()), (int) (dCaja.getHeight() - 85), Image.SCALE_DEFAULT)));
			barra.setIcon(new ImageIcon(new ImageIcon("src/co/edu/unbosque/util/Assets/Images/Sup3.png").getImage()
					.getScaledInstance((int) (dBarra.getWidth()), (int) (dBarra.getHeight()), Image.SCALE_DEFAULT)));
			titulo.setText("Box 3");
			pokemones.removeAllItems();
			List<String> list = Arrays.asList(pokes.split("&%&"));
			for (int i = 0; i < list.size(); i++) {
				pokemones.addItem(list.get(i));
			}
			cajaActual = 3;
		}

	}

	/**
	 * Method in charge of giving the box in use.
	 * 
	 * @return Number of the box
	 */
	public int getCajaActual() {
		return cajaActual;
	}

	/**
	 * Method in charge of adding an item in the box.
	 * 
	 * @param item Item to add.
	 */
	public void agregarItem(String item) {
		pokemones.addItem(item);
	}

	/**
	 * Method for placing images of the suitcase.
	 * 
	 * @param urls Arrangement with the images.
	 */
	public void agregarBolsilloImg(String[] urls) {

		for (int i = 0; i < pokesBolsillo.size(); i++) {
			if (pokesBolsillo.get(i).getIcon() != null) {
				pokesBolsillo.get(i).setOpaque(false);
			}
		}
	}
}
