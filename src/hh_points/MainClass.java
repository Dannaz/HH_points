package hh_points;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		String path;
		String selection = new String();
		Scanner in = new Scanner(System.in);
		try {

			System.out.println(
					"Enter coordinates of the points. Type \'c\'-for console input or \n\'f\'-for input from file \nor anything else for exit.");
			System.out.print("> ");

			selection = in.nextLine();

			switch (selection) {
			case "c":
				Methods.getDotsInfo(Methods.readDotsFromConsole());
				break;
			case "f":
				System.out.println("Enter path to file or press \'enter\' to read default file.");
				System.out.print("> ");
				path = in.nextLine();
				Methods.getDotsInfo(Methods.readDotsFromFile(path));
				break;
			default:
				System.out.println("Exit");
				System.exit(0);
				break;
			}
			in.close();

		} catch (FileNotFoundException e) {
			System.out.println("Unable to find the specified file.");
		}
	}

}
