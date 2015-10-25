package hh_points;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Methods {

	/**
	 * ��������� ���������� ����� ����� �������, � ���������� ������ �����
	 * 
	 * @return ���������� ������ �������� ������ Dot, � ������������ ����������
	 *         ����� �������
	 */
	public static ArrayList<Dot> readDotsFromConsole() {

		ArrayList<Dot> dots = new ArrayList<Dot>();
		Scanner in = new Scanner(System.in);
		String input = new String();
		int x, y;

		System.out.println(
				"Enter coordinates of point in the folowing format: <x><space><y>. Type \'end\' for complite.");
		input = in.nextLine();
		while (!input.equals("end")) {
			try {
				x = Integer.valueOf(input.substring(0, input.indexOf(" ")));
				y = Integer.valueOf(input.substring(input.indexOf(" ") + 1));
				dots.add(new Dot(x, y));
				input = in.nextLine();
			} catch (NumberFormatException e) {
				System.out.println("Uncorrect format of input data. Or numbers are not is Integer");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Uncorrect format of input data. String must be look like <x><space><y>");
			}
		}
		in.close();
		return dots;
	}

	/**
	 * ��������� ���������� ����� �� ���������� �����. ������ �������������
	 * ������ � �����:<br>
	 * <������ ����������><������><������ ����������>
	 * 
	 * @param path
	 *            - ���� � ����� � ������������ �����
	 * @return ���������� ������ �������� ������ Dot
	 * @throws FileNotFoundException
	 *             - � ������, ���� ���������� �� ���� ���� �� �������� ����,
	 *             <br>
	 *             ������������ ����������
	 */
	public static ArrayList<Dot> readDotsFromFile(String path) throws FileNotFoundException {

		ArrayList<Dot> dots = new ArrayList<Dot>();
		int x, y;
		String input;
		File file = new File(path);
		Scanner fin = new Scanner(file);

		if (file.canRead()) {
			while (fin.hasNextLine()) {
				try {
					input = fin.nextLine();
					x = Integer.valueOf(input.substring(0, input.indexOf(" ")));
					y = Integer.valueOf(input.substring(input.indexOf(" ") + 1));
					dots.add(new Dot(x, y));
				} catch (NumberFormatException e) {
					System.out.println("Uncorrect format of input data. Or numbers are not is Integer");
				} catch (IndexOutOfBoundsException e) {
					System.out.println("Uncorrect format of input data. String must be look like <x><space><y>");
				}
			}
			fin.close();
		} else {
			System.out.println("The specified file does not exist or is being used by another process.");
		}
		return dots;

	}

	/**
	 * ������� ������ ���������� � ������ �� ������, ����������� �� ������� �
	 * ���������� �������.
	 * 
	 * @param dots
	 *            - ������ �����, ��������� ������� �� ���� ���������
	 */
	public static void getDotsInfo(ArrayList<Dot> dots) {

		/*
		 * ��������� ������ ��������, �� ����������� ������ ������ �����. ��
		 * ������ �������� ����� � ������ ������������ ���������� �� i-�� �����
		 * �� ���� ���������, ������������ � ���� ������ ����������� ����������.
		 * ��� ���� ���������� �� ����� �� ����� ���� - ������� ��� �����������
		 * ��������� �������� ��� ���� Float. ����������� ���������� - ���
		 * ������ ������ �����, ����� ���� ��� ������ ������, ���������� ���
		 * �����, ����������� � �������� �������� �������, ��� ��������������
		 * ������.
		 */
		float[] radius = new float[dots.size()];
		float thisRad;
		int count = 0;

		radius[0] = -1.0f;

		if (dots.size() >= 2) {
			for (int i = 0; i < radius.length; i++) {
				radius[i] = Float.POSITIVE_INFINITY;
				thisRad = radius[i];

				// ����� ������� i-��� �����
				for (int j = 0; j < radius.length; j++) {
					if (j != i && (radius[j] = destenation(dots.get(i), dots.get(j))) < thisRad) {
						thisRad = radius[j];
					}
				}
				dots.get(i).setR(thisRad);

				// ������� ������� i-��� �����
				thisRad *= 2;
				for (int q = 0; q < radius.length; q++) {
					if (radius[q] <= thisRad) {
						count++;
					}
				}
				dots.get(i).setNeighbors(count);
				System.out.println(dots.get(i).getInfoString());
				count = 0;
			}
		} else {
			System.out.println("Not enough points to count states.\n Count of dots must be great or equal 2");
		}
	}

	public static float destenation(Dot a, Dot b) {

		return (float) Math.sqrt(Double
				.valueOf(String.valueOf((Math.pow((b.getX() - a.getX()), 2) + Math.pow((b.getY() - a.getY()), 2)))));
	}

}
