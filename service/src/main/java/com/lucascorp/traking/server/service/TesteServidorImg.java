package com.lucascorp.traking.server.service;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author lucasmantovani
 *
 */
/**
 * @author lucasmantovani
 *
 */
public class TesteServidorImg {
	
	public static void main(String[] args) {
		
		String txtServidor = "localhost"; 
		String txtPorta = "1234"; 
		String txtArquivo = "/Users/lucasmantovani/teste-img/willos.jpg";
		String txtSaida = "/Users/lucasmantovani/teste-img-saida/willos.jpg";
		
		try {
			// Cria o Socket para buscar o arquivo no servidor
			Socket rec = new Socket(txtServidor, Integer.parseInt(txtPorta));

			// Enviando o nome do arquivo a ser baixado do servidor
			ObjectOutputStream saida = new ObjectOutputStream(rec.getOutputStream());
			saida.writeObject(txtArquivo);

			// DataInputStream para processar os bytes recebidos
			DataInputStream entrada = new DataInputStream(rec.getInputStream());
			// FileOuputStream para salvar o arquivo recebido
			FileOutputStream sarq = new FileOutputStream(txtSaida);
			byte[] br = new byte[512];
			int leitura = entrada.read(br);
			while (leitura != -1) {
				if (leitura != -2) {
					sarq.write(br, 0, leitura);
				}
				leitura = entrada.read(br);
			}

			saida.close();
			entrada.close();
			sarq.close();
			rec.close();
			//ImageIcon img = new ImageIcon(txtSaida);
			// lblImagem.setText("");
			// lblImagem.setIcon(img);
		}

		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Exceção:" + e.getMessage(), "Erro", 2);
		}
		

	}

	/*public void buscarImgViaServidor(String txtServidor, String txtPorta, String txtArquivo, String txtSaida) {

		try {
			// Cria o Socket para buscar o arquivo no servidor
			Socket rec = new Socket(txtServidor, Integer.parseInt(txtPorta));

			// Enviando o nome do arquivo a ser baixado do servidor
			ObjectOutputStream saida = new ObjectOutputStream(rec.getOutputStream());
			saida.writeObject(txtArquivo);

			// DataInputStream para processar os bytes recebidos
			DataInputStream entrada = new DataInputStream(rec.getInputStream());
			// FileOuputStream para salvar o arquivo recebido
			FileOutputStream sarq = new FileOutputStream(txtSaida);
			byte[] br = new byte[512];
			int leitura = entrada.read(br);
			while (leitura != -1) {
				if (leitura != -2) {
					sarq.write(br, 0, leitura);
				}
				leitura = entrada.read(br);
			}

			saida.close();
			entrada.close();
			sarq.close();
			rec.close();
			ImageIcon img = new ImageIcon(txtSaida);
			// lblImagem.setText("");
			// lblImagem.setIcon(img);
		}

		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Exceção:" + e.getMessage(), "Erro", 2);
		}
	}*/

	

}
