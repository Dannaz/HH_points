package hh_points;

public class Dot {
	private int x, y, neighbors;
	private float radius;

	/**
	 * @param x
	 *            - Координата точки по оси OX
	 * @param y
	 *            - Координата точки по оси OY
	 */
	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return Возвращает координату точки по оси OX
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return Возвращает координату точки по оси ОY
	 */
	public int getY() {
		return y;
	}

	/**
	 * Задает количество соседей точки.
	 * 
	 * @param neighbors
	 *            - Количество соседей точки.
	 */
	public void setNeighbors(int neighbors) {
		this.neighbors = neighbors;
	}

	/**
	 * @return Возвращает количество точек, находящихся от данной в пределах её
	 *         двойного радиуса.
	 */
	public int getNeighbors() {
		return neighbors;
	}

	/**
	 * Задает радиус точки.
	 * 
	 * @param radius
	 *            - радиус
	 */
	public void setR(float radius) {
		this.radius = radius;
	}

	/**
	 * @return Возврашает радиус точки
	 */
	public float getR() {
		return radius;
	}

	/**
	 * Возвращает полную информацию о точке, представленную в виде строки:<br>
	 * Dot (х;у) has radius R=radius and Neighbors=neighbors<br>
	 * radius - радиус точки<br>
	 * neighbors - количество соседей
	 * 
	 * @return Информацию о точке.
	 */
	public String getInfoString() {
		return String.valueOf("Dot (" + x + ";" + y + ") has radius R=" + radius + " and Neighbors=" + neighbors);
	}
}
