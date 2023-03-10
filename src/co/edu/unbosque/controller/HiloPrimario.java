package co.edu.unbosque.controller;

import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import co.edu.unbosque.view.Mensaje;
import co.edu.unbosque.view.PanelAbajo;
import co.edu.unbosque.view.PanelArriba;
import co.edu.unbosque.view.VentanaCaptura;
import co.edu.unbosque.view.VentanaCreacionUsuario;
import co.edu.unbosque.view.VentanaLiberar;
import co.edu.unbosque.view.VentanaMovimiento;
import co.edu.unbosque.view.VentanaPokemon;
import co.edu.unbosque.view.VentanaPrincipal;
import co.edu.unbosque.view.VentanaUsuario;

/**
 * Class that creates and uses the thread for the program connection.
 * 
 * @author Miguel Linares
 * @author Johan Silva
 *
 */
public class HiloPrimario extends Thread {
	private Socket socket;
	private Socket socketR;
	private ServerSocket server;
	private DataInputStream in;
	private DataOutputStream out;
	private String address, line, res;
	private int port;
	VentanaUsuario user;
	VentanaPrincipal principal;
	VentanaPokemon poke;
	VentanaLiberar free;
	VentanaMovimiento mov;
	VentanaCaptura captura;
	PanelArriba arriba;
	PanelAbajo abajo;
	VentanaCreacionUsuario createUs;
	String userActual;
	String cajaActualPoke, bolsillo;
	Boolean estado;
	private Mensaje mensaje;

	/**
	 * Class constructor.
	 * 
	 * @param address IP adress
	 * @param port    Port to conecction
	 * @param mouse   Mouse Action Listener
	 * @param momo    Motion Mouse Listener
	 * @param itemL   Item Listener
	 */
	public HiloPrimario(String address, int port, MouseListener mouse, MouseMotionListener momo, ItemListener itemL) {
		this.address = address;
		this.socket = null;
		this.socketR = null;
		this.server = null;
		this.in = null;
		this.out = null;
		this.port = port;
		line = "";
		res = "";
		user = new VentanaUsuario(mouse, momo);
		mov = new VentanaMovimiento(mouse, momo);
		free = new VentanaLiberar(mouse, momo);
		principal = new VentanaPrincipal(mouse, momo, itemL);
		arriba = new PanelArriba();
		abajo = new PanelAbajo(mouse);
		poke = new VentanaPokemon(arriba, abajo, mouse, momo);
		createUs = new VentanaCreacionUsuario(mouse, momo);
		captura = new VentanaCaptura(mouse, momo, itemL);
		user.setVisible(true);
		userActual = "";
		cajaActualPoke = "";
		estado = false;
		bolsillo = "";
	}

	@SuppressWarnings("static-access")
	@Override
	public void run() {

		// string to read message from input

		// keep reading until "Over" is input
		while (!line.equals("Over")) {
			// establish a connection
			try {
				this.socket = new Socket(this.address, this.port);
				System.out.println("Connected");

				// sends output to the socket
				this.out = new DataOutputStream(socket.getOutputStream());

				// line = this.input.readLine();
				if (line.equals("")) {
					pausarHilo();
				}
				this.out.writeUTF(line);
				// close socket and output stream
				this.out.close();
				this.socket.close();
				// Create a serverSocket to wait message from server
				this.server = new ServerSocket(this.port + 1);
				this.socket = server.accept();
				// takes input from the client socket
				this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
				//
				res = in.readUTF();
				if (line.split("@")[0].split("-")[1].equals("iniciar")) {
					if (res.equals("logro")) {
						userActual = line.split("@")[0].split("-")[0];
						user.setVisible(false);
						Mensaje.mensaje("Welcome " + user.getUsuario());
						principal.setVisible(true);
					} else {
						System.err.println(res);
						mensaje.mensaje("User Does Not Exist");
					}
				}
				if (line.split("@")[0].split("-")[1].equals("nuevo")) {
					if (!res.equalsIgnoreCase("error")) {
						Mensaje.mensaje("User created successfully");
						createUs.setVisible(false);
						user.setVisible(true);
					} else if (res.equalsIgnoreCase("exist")) {
						Mensaje.mensaje("The user exists");
					} else {
						Mensaje.mensaje("Could not create");
					}
				}
				if (line.split("@")[0].split("-")[1].equals("getCB") && line.split("@")[1].equals("1")) {
					if (res.equals("error") || res.equals("") || res == null) {
						mensaje.mensaje("It has no captured pokemon.");
					} else {
						String tmp3 = res;
						String[] aux = tmp3.split("@");
						try {
							bolsillo = aux[0];
						} catch (Exception e) {
						}
						try {
							cajaActualPoke = aux[1];
							String[] tmp = aux[1].split("%!%");
							for (int i = 0; i < tmp.length; i++) {
							}
							principal.eliminarComboBox();
							for (int i = 0; i < tmp.length; i++) {
								String[] tmp2 = tmp[i].split("%&");
								principal.agregarItem(tmp2[4].split("-")[0]);
							}
							principal.seleccionar(0);
							principal.comprobar();
						} catch (Exception e) {
							principal.comprobar();
						}

					}
				}
				if (line.split("@")[0].split("-")[1].equals("getCB") && line.split("@")[1].equals("2")) {
					if (res.equals("error") || res.equals("") || res == null) {
						System.out.println("Vacio");
					} else {
						String tmp3 = res;
						String[] aux = tmp3.split("@");
						try {
							bolsillo = aux[0];
						} catch (Exception e) {
						}
						try {
							cajaActualPoke = aux[1];
							String[] tmp = aux[1].split("%!%");
							for (int i = 0; i < tmp.length; i++) {
							}
							principal.eliminarComboBox();
							for (int i = 0; i < tmp.length; i++) {
								String[] tmp2 = tmp[i].split("%&");
								principal.agregarItem(tmp2[4].split("-")[0]);
							}
							principal.seleccionar(0);
							principal.comprobar();
						} catch (Exception e) {
							principal.comprobar();
						}
					}
				}
				if (line.split("@")[0].split("-")[1].equals("getCB") && line.split("@")[1].equals("3")) {
					if (res.equals("error") || res.equals("") || res == null) {
						System.out.println("Vacio");
					} else {
						String tmp3 = res;
						String[] aux = tmp3.split("@");
						try {
							bolsillo = aux[0];
						} catch (Exception e) {
						}
						try {
							cajaActualPoke = aux[1];
							String[] tmp = aux[1].split("%!%");
							for (int i = 0; i < tmp.length; i++) {
							}
							principal.eliminarComboBox();
							for (int i = 0; i < tmp.length; i++) {
								String[] tmp2 = tmp[i].split("%&");
								principal.agregarItem(tmp2[4].split("-")[0]);
							}
							principal.comprobar();
						} catch (Exception e) {
							principal.comprobar();
						}

					}
				}
				if (line.split("@")[0].split("-")[1].equals("capturar")) {
					if (res.equals("error")) {
						mensaje.mensaje("El bolsillo se encuentra lleno intente en una caja");
					} else if (res.equals("exist")) {
						mensaje.mensaje("There is already a Pokemon with that nickname.");
					} else {
						mensaje.mensaje("Agregado con exito");
						captura.setVisible(false);
						principal.setVisible(true);

					}
				}
				if (line.split("@")[0].split("-")[1].equals("getAll")) {
					if (res.equals("error")) {
						System.out.println("Vacio");
					} else {
						String[] tmp = res.split("%");
						String[] tmp2 = new String[tmp.length];
						for (int i = 0; i < tmp.length; i++) {
							String[] tmp3 = tmp[i].split("-");
							tmp2[i] = tmp3[0] + "." + tmp3[1];
						}
						principal.setVisible(false);
						captura.setCajas();
						captura.setPokemones(tmp2);
						captura.setVisible(true);
					}
				}
				if (line.split("@")[0].split("-")[1].equals("liberar")) {
					if (res.equals("error")) {
						System.out.println("No liberado");
					} else if (res.equals("logro")) {
						mensaje.mensaje("Liberado");
						principal.setVisible(false);
						free.setVisible(true);
					}
				}
				if (line.split("@")[0].split("-")[1].equals("getMote")) {
					if (res.equals("error")) {
						mensaje.mensaje("a");
					} else {
						try {
							String tmp[] = res.split("%&");
							String imagen = tmp[4].split("-")[8];
							if (!imagen.split("/")[0].equals("src")) {
								imagen = tmp[4].split("-")[9];
							}
							if (tmp[4].split("-")[0].equals(line.split("@")[1].split("-")[1])) {
								principal.cambioImagen(imagen);
							}
							String[] poke = res.split("&");
							String[] stats = poke[0].split("-");
							int num = Integer.parseInt(stats[0]);
							int hp = Integer.parseInt(stats[1]);
							int attack = Integer.parseInt(stats[2]);
							int defense = Integer.parseInt(stats[3]);
							int spAtk = Integer.parseInt(stats[4]);
							int spDef = Integer.parseInt(stats[5]);
							int speed = Integer.parseInt(stats[6]);
							arriba.cambiarEstadis(hp, attack, defense, spAtk, spDef, speed);
							String[] mov1 = poke[1].split("-");
							String[] mov2 = poke[2].split("-");
							String[] mov3 = poke[3].split("-");
							String[] mov4 = poke[4].split("-");
							abajo.cambiarMovimientos(mov1[0] + " " + mov1[1] + " " + mov1[2] + " " + mov1[3], mov1[4],
									mov1[5], mov2[0] + " " + mov2[1] + " " + mov2[2] + " " + mov2[3], mov2[4], mov2[5],
									mov3[0] + " " + mov3[1] + " " + mov3[2] + " " + mov3[3], mov3[4], mov3[5],
									mov4[0] + " " + mov4[1] + " " + mov4[2] + " " + mov4[3], mov4[4], mov4[5]);
							String[] info = poke[5].split("-");
							String mote = info[0];
							String nombre = info[1];
							String tipo1 = info[2];
							String tipo2 = info[3];
							String desc = info[4];
							String hab1 = info[5];
							String hab2 = info[6];
							String hab3 = info[7];
							String gif = info[8];
							arriba.cambiarDescripcion(desc);
							arriba.cambiarHabilidades(hab1, hab2, hab3);
							arriba.cambiarNombre(nombre + " " + mote);
							arriba.cambiarTipos(tipo1, tipo2);
							arriba.imagenPokeCambio(gif);

						} catch (Exception e) {
							// TODO: handle exception
						}

					}
				}
				if (line.split("@")[0].split("-")[1].equals("liberar")) {
					if (res.equals("logro")) {
						mensaje.mensaje("Released successfully");
					} else {
						mensaje.mensaje("Pokemon Does Not Exist");
					}
				}
				if (line.split("@")[0].split("-")[1].equals("mover")) {
					if (res.equals("logro")) {
						mensaje.mensaje("Pokemon Successfully Moved");
					} else {
						mensaje.mensaje("Pokemon Does Not Exist");
					}
				}
				if (!line.equals("Over")) {
					line = "";
				}
//				if (res.equals("error")) {
//					Mensaje.mensaje("Error with the server");
//					break;
//				}
				this.in.close();
				this.server.close();
			} catch (java.io.EOFException e) {
				System.out.println("end");
				break;
			} catch (IOException i) {
				System.out.println(i);
			}
		}
		// close the connection
		try

		{
			if (line.equals("Over")) {
				out.close();
				socket.close();
				System.exit(0);
			}
		} catch (IOException i) {
			System.out.println(i);
		}
	}

	/**
	 * Method that pauses the thread.
	 */
	public synchronized void pausarHilo() {
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method sending a message through the thread.
	 * 
	 * @param msm Message
	 */
	public synchronized void enviarInfo(String msm) {
		line = msm;
		this.notify();
	}

}
