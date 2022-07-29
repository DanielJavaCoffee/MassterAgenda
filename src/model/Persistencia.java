package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Persistencia {

	private XStream xstream = new XStream(new DomDriver("ISO-8859-1"));
	private File arquivo = new File("banco.xml ");

	/**
	 * Metodo utilizado para criar um arquivo e salvar os dados dos m�todos da classe central de informa��es 
	 **/
	public void salvarCentral(CentralDeInformacoes central) {

		String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>\n";
		xml += xstream.toXML(central);

		try {
			if (!arquivo.exists())
				arquivo.createNewFile();
			PrintWriter gravar = new PrintWriter(arquivo);
			gravar.print(xml);
			gravar.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 *  Metodo utilizado para recuperar um arquivo junto com os dados dos m�todos da classe central de informa��es
	 * @return
	 */
	public CentralDeInformacoes recuperarCentral() {

		try {

			if (arquivo.exists()) {
				FileInputStream fis = new FileInputStream(arquivo);
				xstream.addPermission(AnyTypePermission.ANY);
				return (CentralDeInformacoes) xstream.fromXML(fis);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new CentralDeInformacoes();
	}
}
