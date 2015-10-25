package hh_points;

public class Dot {
	private int x, y, neighbors;
	private float radius;

	/**
	 * @param x
	 *            - ���������� ����� �� ��� OX
	 * @param y
	 *            - ���������� ����� �� ��� OY
	 */
	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return ���������� ���������� ����� �� ��� OX
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return ���������� ���������� ����� �� ��� �Y
	 */
	public int getY() {
		return y;
	}

	/**
	 * ������ ���������� ������� �����.
	 * 
	 * @param neighbors
	 *            - ���������� ������� �����.
	 */
	public void setNeighbors(int neighbors) {
		this.neighbors = neighbors;
	}

	/**
	 * @return ���������� ���������� �����, ����������� �� ������ � �������� �
	 *         �������� �������.
	 */
	public int getNeighbors() {
		return neighbors;
	}

	/**
	 * ������ ������ �����.
	 * 
	 * @param radius
	 *            - ������
	 */
	public void setR(float radius) {
		this.radius = radius;
	}

	/**
	 * @return ���������� ������ �����
	 */
	public float getR() {
		return radius;
	}

	/**
	 * ���������� ������ ���������� � �����, �������������� � ���� ������:<br>
	 * Dot (�;�) has radius R=radius and Neighbors=neighbors<br>
	 * radius - ������ �����<br>
	 * neighbors - ���������� �������
	 * 
	 * @return ���������� � �����.
	 */
	public String getInfoString() {
		return String.valueOf("Dot (" + x + ";" + y + ") has radius R=" + radius + " and Neighbors=" + neighbors);
	}
}
