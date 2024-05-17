package unidad2;

import java.util.ArrayList;

public class Libro implements Comparable<Libro> {

	private int id;
	private String titulo;
	private String autor;
	private ArrayList<String> generos;
	private int anio;
	private int cantidad;

	public Libro(int id, String titulo, String autor, int anio, int cantidad) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.generos = new ArrayList<String>();
		this.anio = anio;
		this.cantidad = cantidad;
	}

	// GETTERS SETTERS

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	// ADD GENERO
	public void addGenero(String genero) {
		if (!this.generos.contains(genero)) {
			this.generos.add(genero);
		}
	}

	// GET GENERO
	public ArrayList<String> getGeneros() {
		ArrayList<String> generos = new ArrayList<>();
		generos.addAll(this.generos);
		return generos;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		ArrayList<String> listaGeneros = this.getGeneros();
		sb.append("ID: ").append(this.getId()).append("\n").append("Titulo: ").append(this.getTitulo()).append("\n")
				.append("Autor: ").append(this.getAutor()).append("\n").append("Generos: ");

		for (int i = 0; i < listaGeneros.size(); i++) {
			sb.append(listaGeneros.get(i));
			if (i < listaGeneros.size() - 1) {
				sb.append(", ");
			}
		}

		sb.append("\nAño: ").append(this.getAnio()).append("\n").append("Cantidad: ").append(this.getCantidad()).append("\n");

		return sb.toString();
	}

	@Override
	public int compareTo(Libro otroLibro) {
		return Integer.compare(this.id, otroLibro.getId());
	}

}
