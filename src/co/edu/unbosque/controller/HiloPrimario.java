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
	private int xmouse, ymouse;
	private HiloPrimario primario;
	VentanaCreacionUsuario createUs;
	String userActual;
	String cajaActualPoke;
	Boolean estado;
	int numCaja;
	private Mensaje mensaje;

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
		numCaja = 1;
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
						estado = true;
						line = userActual + "-get@" + numCaja;
						principal.setVisible(true);
					} else {
						System.err.println(res);
						mensaje.mensaje("Usuario No Existente");
					}
				}
				if (line.split("@")[0].split("-")[1].equals("nuevo")) {
					if (!res.equalsIgnoreCase("error")) {
						Mensaje.mensaje("User created successfully");
						createUs.setVisible(false);
						user.setVisible(true);
					} else {
						Mensaje.mensaje("Could not create");
					}
				}
				if (line.split("@")[0].split("-")[1].equals("get") && line.split("@")[1].equals("1")) {
					if (res.equals("error")) {
						System.err.println("Vacio");
					} else {
						cajaActualPoke = res;
						System.err.println(cajaActualPoke + " caja1");
						estado = false;
					}
				}
				if (line.split("@")[0].split("-")[1].equals("get") && line.split("@")[1].equals("2")) {
					if (res.equals("error")) {
						System.out.println("Vacio");
					} else {
						cajaActualPoke = res;
						System.err.println(cajaActualPoke + " caja2");
					}
				}
				if (line.split("@")[0].split("-")[1].equals("get") && line.split("@")[1].equals("3")) {
					if (res.equals("error")) {
						System.out.println("Vacio");
					} else {
						cajaActualPoke = res;
						System.err.println(cajaActualPoke + " caja3");
					}
				}
				if (line.split("@")[0].split("-")[1].equals("capturar")) {
					if (res.equals("error")) {
						mensaje.mensaje("El bolsillo se encuentra lleno intente en una caja");
					} else {
						System.err.println(res);
						estado = true;
						line = userActual + "-get@" + numCaja;
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

				if (!line.equals("Over") && estado == false) {
					System.out.println("paso");
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
		try {
			if (line.equals("Over")) {
				out.close();
				socket.close();
				System.exit(0);
			}
		} catch (IOException i) {
			System.out.println(i);
		}
	}

	public synchronized void pausarHilo() {
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void enviarInfo(String msm) {
		line = msm;
		this.notify();
	}

}
