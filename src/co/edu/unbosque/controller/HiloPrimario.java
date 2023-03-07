package co.edu.unbosque.controller;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import co.edu.unbosque.view.Mensaje;

public class HiloPrimario extends Thread {
	private Socket socket;
	private Socket socketR;
	private ServerSocket server;
	private DataInputStream in;
	private DataOutputStream out;
	private String address, line, res;
	private int port;

	public HiloPrimario(String address, int port) {
		this.address = address;
		this.socket = null;
		this.socketR = null;
		this.server = null;
		this.in = null;
		this.out = null;
		this.port = port;
		line = "";
		res = "";
	}

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
				if (!line.equals("Over")) {
					line = "";
				}
				if (res.equals("error")) {
					Mensaje.mensaje("Error with the server");
					break;
				}
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
			out.close();
			socket.close();
			if (line.equals("Over")) {
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

	public synchronized String enviarInfo(String msm) {
		line = msm;
		this.notify();
		return res;
	}
}
