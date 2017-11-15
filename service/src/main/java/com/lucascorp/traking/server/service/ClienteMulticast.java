package com.lucascorp.traking.server.service;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ClienteMulticast {

	public static void main(String[] args) {

		while (true) {
			try {
				System.setProperty("java.net.preferIPv4Stack", "true");
				MulticastSocket mcs = new MulticastSocket(12347);
				InetAddress grp = InetAddress.getByName("239.000.000.001");
				mcs.joinGroup(grp);
				byte rec[] = new byte[256];
				DatagramPacket pkg = new DatagramPacket(rec, rec.length);
				mcs.receive(pkg);
				String data = new String(pkg.getData());
				System.out.println("Dados recebidos:" + data);
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
	}

}
