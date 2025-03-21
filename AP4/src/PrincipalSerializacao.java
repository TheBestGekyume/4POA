package AP4.src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PrincipalSerializacao {
	public static void main(String[] args) {
		Desenvolvedor dev = new Desenvolvedor(
				"Gekyume",
				19,
				"523.290.142-00",
				"CLT",
				7865.89);
		try {

			File dir = new File("C:/Users/Gekyume Serna/Documents/GitHub/4POA/AP4/data");
			if(!dir.exists()) dir.mkdir();
			FileOutputStream arqOSer = new FileOutputStream("C:/Users/Gekyume Serna/Documents/GitHub/4POA/AP4/data/data.ser");
			ObjectOutputStream oOSer = new ObjectOutputStream(arqOSer);
			oOSer.writeObject(dev);
			oOSer.close();
			System.out.println("---------------Antes de alterar idade e salário-------------");
			System.out.println(dev);
			dev.setIdade(20);
			dev.setSalario(8000);
			System.out.println("---------------Depois de alterar idade e salário-------------");
			System.out.println(dev);
			FileInputStream arqISer = new FileInputStream("C:/Users/Gekyume Serna/Documents/GitHub/4POA/AP4/data/data.ser");
			ObjectInputStream iOSer = new ObjectInputStream(arqISer);
			dev = (Desenvolvedor) iOSer.readObject();
			iOSer.close();
			System.out.println("---------------Depois de recuperar os valores-------------");
			System.out.println(dev);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}


