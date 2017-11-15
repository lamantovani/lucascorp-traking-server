package com.lucascorp.traking.server.service;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import com.lucascorp.traking.server.utils.FunctionsUtils;

public class ReceptorUDP {

	public static void main(String[] args) {


		try {
			
			// Converte o argumento recebido para inteiro (numero da porta)
			int port = Integer.parseInt(FunctionsUtils.getPropertiesByKey("traking.server.port"));
			// Cria o DatagramSocket para aguardar mensagens, neste momento o método fica
			// bloqueando
			// até o recebimente de uma mensagem
			DatagramSocket ds = new DatagramSocket(port);
			System.out.println("Ouvindo a porta: " + port);
			// Preparando o buffer de recebimento da mensagem
			byte[] msg = new byte[256];
			
			while (true) {
				// Prepara o pacote de dados
				DatagramPacket pkg = new DatagramPacket(msg, msg.length);
				// Recebimento da mensagem
				ds.receive(pkg);
				//JOptionPane.showMessageDialog(null, new String(pkg.getData()).trim(), "Mensagem recebida", 1);
				//ds.close();
				System.out.println("Mensagem recebida" + new String(pkg.getData()).trim());

			}

		}

		catch (IOException ioe) {
			System.out.println("ERROR");
		}
	}

}
