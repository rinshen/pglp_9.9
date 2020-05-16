package fr.uvsq.rinshen.ex99;

public class Point {
	private int abs;
	private int ord;
	
	public Point(int x, int y) {
		this.setAbs(x);
		this.setOrd(y);
	}
	
	public void deplacer(int horizontal, int vertical) {
		abs += horizontal;
		ord += vertical;
	}
	
	public void afficher() {
		System.out.println("abscisse: " + abs);
		System.out.println("ordonées: " + ord);
	}

	public int getAbs() {
		return abs;
	}

	public void setAbs(int x) {
		this.abs = x;
	}

	public int getOrd() {
		return ord;
	}

	public void setOrd(int y) {
		this.ord = y;
	}
}
