package unidad2;

public class FiltroEntreAnios extends FiltroLibro{
	
private int anio1;
private int anio2;
	
	public FiltroEntreAnios(int anio1, int anio2) {
		this.anio1 = anio1;
		this.anio2 = anio2;
	}

	@Override
	public boolean cumple(Libro libro) {
		return libro.getAnio() >= anio1 && libro.getAnio() <= anio2;
	}
}
