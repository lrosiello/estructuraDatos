package unidad4;

import java.util.HashMap;
import java.util.Map;

public class Vertice<T> {

    private int verticeId;
    private int cantidadDeArcos;
    private Map<Integer, Arco<T>> arcos;

    public Vertice(int verticeId) {
        this.verticeId = verticeId;
        this.arcos = new HashMap<>();
        this.cantidadDeArcos = 0;
    }

    public int getVerticeId() {
        return this.verticeId;
    }

    public Map<Integer, Arco<T>> getArcos() {
        return this.arcos;
    }

    public void addArco(int verticeDestino, T etiqueta) {
        arcos.put(verticeDestino, new Arco<>(this.verticeId, verticeDestino, etiqueta));
        cantidadDeArcos++;
    }

    public void removeArco(int verticeDestino) {
        arcos.remove(verticeDestino);
        cantidadDeArcos--;
    }

    public boolean existeArco(int verticeDestino) {
        return arcos.containsKey(verticeDestino);
    }

    public Arco<T> getArco(int verticeDestino) {
        return arcos.get(verticeDestino);
    }
    
    public int getCantidadDeArcos() {
    	return this.cantidadDeArcos;
    }
}
