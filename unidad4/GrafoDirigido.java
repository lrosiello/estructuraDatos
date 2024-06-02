package unidad4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;


public class GrafoDirigido<T> implements Grafo<T> {

    private HashMap<Integer, Vertice<T>> vertices;
    private int cantidadDeArcos;

    public GrafoDirigido() {
        this.vertices = new HashMap<>();
        this.cantidadDeArcos = 0;
    }

    @Override
    public void agregarVertice(int verticeId) {
        if (!contieneVertice(verticeId)) {
            vertices.put(verticeId, new Vertice<>(verticeId));
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        if (contieneVertice(verticeId)) {
            // Primero restar los arcos que serán eliminados
            Vertice<T> vertice = vertices.remove(verticeId);
            cantidadDeArcos -= vertice.getCantidadDeArcos();
            // Luego eliminar todos los arcos que tienen este vértice como destino
            for (Vertice<T> v : vertices.values()) {
                if (v.existeArco(verticeId)) {
                    v.removeArco(verticeId);
                    cantidadDeArcos--;
                }
            }
        }
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if (!contieneVertice(verticeId1) || !contieneVertice(verticeId2)) {
            return;
        }
        Vertice<T> vertice = vertices.get(verticeId1);
        vertice.addArco(verticeId2, etiqueta);
        cantidadDeArcos++; //sumo el arco creado;
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        if (contieneVertice(verticeId1)) {
            Vertice<T> vertice = vertices.get(verticeId1);
            vertice.removeArco(verticeId2);
            cantidadDeArcos--; //resto el arco eliminado;
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return vertices.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        if (!contieneVertice(verticeId1)) {
            return false;
        }
        Vertice<T> vertice = vertices.get(verticeId1);
        return vertice.existeArco(verticeId2);
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        if (!contieneVertice(verticeId1)) {
            return null;
        }
        Vertice<T> vertice = vertices.get(verticeId1);
        return vertice.getArco(verticeId2);
    }

    @Override
    public int cantidadVertices() {
        return vertices.size();
    }

    @Override
    public int cantidadArcos() {
        return cantidadDeArcos;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        return vertices.keySet().iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        if (!contieneVertice(verticeId)) {
            return null;
        }
        Vertice<T> vertice = vertices.get(verticeId);
        return vertice.getArcos().keySet().iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        LinkedList<Arco<T>> arcos = new LinkedList<>();
        for (Vertice<T> v : vertices.values()) {
            arcos.addAll(v.getArcos().values());
        }
        return arcos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        if (!contieneVertice(verticeId)) {
            return null;
        }
        Vertice<T> vertice = vertices.get(verticeId);
        return vertice.getArcos().values().iterator();
    }
}
