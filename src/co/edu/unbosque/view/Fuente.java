package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

/**
 * @author MiguelLinares
 * @author JohanSilva
 */
public class Fuente {

	private Font fn;
	private static Font fnf;

	/**
	 * This method creates and register a new font
	 */
	public Fuente() {
		try {
			fn = Font.createFont(Font.TRUETYPE_FONT,
					new File("src/co/edu/unbosque/util/Assets/Font/pokemon-ds-font.ttf"));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,
					new File("src/co/edu/unbosque/util/Assets/Font/pokemon-ds-font.ttf")));
			fnf = fn.deriveFont(0, 30);
		} catch (IOException e) {
			fnf = new Font("Arial", 0, 20);
		} catch (FontFormatException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This public method allows to take the font "fnf"
	 * 
	 * @return the new font
	 */
	public static Font oFuente() {
		return fnf;
	}
}
