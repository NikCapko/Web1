import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	private static BufferedReader reader;
	
	public static void main(String[] args) {
		reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("Введите число в римской системе ");
			String rimNumber = reader.readLine();
			Convert convert = new Convert(rimNumber);
			String arabicNumber = convert.getResult();
			System.out.println(rimNumber + " в арабской системе -> " + arabicNumber);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
