package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

/**
 * Class in charge of the window to move a pokemon.
 * 
 * @author Miguel Linares
 * @author Johan Silva
 * 
 */
@SuppressWarnings("serial")
public class VentanaMovimiento extends JFrame {
	private JPanel ventana;
	private JLabel salir, fantasma, continuar, fondo;
	private Color sc, pr;
	private Font fuente;
	private ArrayList<JLabel> botones;
	private JTextPane text;
	private JComboBox<String> ubicacionP;

	/**
	 * Window constructor where you initialize what is going to be used.
	 * 
	 * @param mouse Mouse Action Listener
	 * @param momo  Mouse Motion Listener
	 */
	public VentanaMovimiento(MouseListener mouse, MouseMotionListener momo) {
		fuente = Fuente.oFuente();
		ventana = new JPanel();
		salir = new JLabel("Return", SwingConstants.CENTER);
		fantasma = new JLabel();
		continuar = new JLabel("Move", SwingConstants.CENTER);
		fondo = new JLabel();
		ubicacionP = new JComboBox<String>();
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
		ubicacionP.setForeground(Color.WHITE);
		ubicacionP.setFont(fuente.deriveFont(Font.BOLD, 30));
		ubicacionP.setBounds(25, 75, 350, 50);
		ubicacionP.addMouseListener(mouse);
		ubicacionP.setBackground(pr);
		ubicacionP.setOpaque(true);
		ubicacionP.setMaximumRowCount(2);
		ubicacionP.addItem("Box1");
		ubicacionP.addItem("Box2");
		ubicacionP.addItem("Box3");
		ubicacionP.addItem("Backpack");
		ubicacionP.setBorder(new MatteBorder(2, 2, 2, 2, pr));
		text.setForeground(Color.BLACK);
		text.setFont(fuente.deriveFont(Font.BOLD, 30));
		text.setBounds(25, 40, 350, 30);
		text.setEditable(false);
		text.setOpaque(false);
		text.setText("Box: ");
		//
		this.setSize(400, 200);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		//
		ventana.setSize(this.getSize());
		ventana.setLayout(null);
		ventana.add(text);
		ventana.add(ubicacionP);
		ventana.add(continuar);
		ventana.add(salir);
		ventana.add(fantasma);
		ventana.add(fondo);
		//
		this.add(ventana);
		fondo.setIcon(new ImageIcon(new ImageIcon("src/co/edu/unbosque/util/img/fondo.png").getImage()
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

	/**
	 * Method that obtains the selected box.
	 * 
	 * @return Selected Box
	 */
	public String getBoxSelected() {
		String end = "";
		String cad = ubicacionP.getSelectedItem().toString();
		if (cad.equalsIgnoreCase("Backpack")) {
			end = "0";
		} else {
			for (int i = 0; i < cad.length(); i++) {
				if (Character.isDigit(cad.charAt(i)))
					end = end + cad.charAt(i);
			}
		}
		return end;
	}

	/**
	 * Method that is responsible for displaying information about the pokemon's
	 * movement.
	 * 
	 * @param poke Pokemon to move
	 */
	public void cambiarPokemon(String poke) {
		text.setText("Move Pokemon " + poke + " to the box:");
	}
}
