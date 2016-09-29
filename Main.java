import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Luis Sierra, Carlos Solórzano
 * @since 28-09-2016
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String st = readFile("pacientes.txt"); 
		VectorHeap<String> vector = new VectorHeap<String>();
		System.out.println("Orden de ingreso:");
		for (String sp : st.split("\r\n")) {
			System.out.println(sp);
			String ss = sp.substring(sp.length() - 1);
			vector.add(ss + " " + sp.substring(0, sp.length() - 1));
		}
		System.out.println();
		System.out.println("Orden de atención:");
		while (!vector.isEmpty()) {
			String ss = vector.removeFirst();
			String sc = ss.substring(0, 1);
			System.out.println(ss.substring(2, ss.length() - 1) + " " + sc);
		}
	}

	/**
	 * 
	 * @param path La ruta del archivo a leer
	 * @return Cadena de caracteres con el contenido del archivo
	 */
	private static String readFile(String path) {
		String str = "";
		String s = "";
		try {
			FileReader f = new FileReader(path);
			BufferedReader b = new BufferedReader(f);
			try {
				while ((s = b.readLine()) != null) {
					str += s + "\r\n";
				}
				b.close();
			} catch (IOException e) {
				return "";
			}
		} catch (FileNotFoundException e) {
			return "";
		}
		return str;
	}
	
}
