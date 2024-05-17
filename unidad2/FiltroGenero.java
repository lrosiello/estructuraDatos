package unidad2;

public  class FiltroGenero extends FiltroLibro{

	private String genero;
	
	public FiltroGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public boolean cumple(Libro libro) {
		return libro.getGeneros().contains(genero);
	}

	
}
