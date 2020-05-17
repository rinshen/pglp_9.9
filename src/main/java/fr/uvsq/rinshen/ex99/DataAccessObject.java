package fr.uvsq.rinshen.ex99;

public interface DataAccessObject<T> {
	public abstract void ecrire(T obj);

	public abstract T lire(String nom);
	
	public abstract void supprimer(String nom);
	
	public abstract void modifier(T obj);
}
