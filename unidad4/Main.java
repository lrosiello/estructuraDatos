package unidad4;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        // Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
        GrafoDirigido<Float> grafito = new GrafoDirigido<>();
        
        // Agrego los vertices
        grafito.agregarVertice(1);
        grafito.agregarVertice(2);
        grafito.agregarVertice(5);
        grafito.agregarVertice(6);
        grafito.agregarVertice(8);
        grafito.agregarVertice(0);
        grafito.agregarVertice(24);
        grafito.agregarVertice(262);
        
        // Conecto los vértices con arcos
        grafito.agregarArco(1, 2, 3F);
        grafito.agregarArco(1, 5, 1.5F);
        grafito.agregarArco(2, 6, 2F);
        grafito.agregarArco(5, 8, 0.5F);
        grafito.agregarArco(6, 0, 4F);
        grafito.agregarArco(8, 24, 2.5F);
        grafito.agregarArco(0, 262, 1F);
        grafito.agregarArco(24, 1, 5F);
        
        // Obtengo el arco entre 1 y 2, y le pido la etiqueta
        Float etiqueta = grafito.obtenerArco(1, 2).getEtiqueta();
        
        System.out.println(etiqueta); // Debería imprimir 3

        // Imprimir etiquetas de otros arcos para verificar
        System.out.println(grafito.obtenerArco(1, 5).getEtiqueta()); // Debería imprimir 1.5
        System.out.println(grafito.obtenerArco(2, 6).getEtiqueta()); // Debería imprimir 2
        System.out.println(grafito.obtenerArco(5, 8).getEtiqueta()); // Debería imprimir 0.5
        System.out.println(grafito.obtenerArco(6, 0).getEtiqueta()); // Debería imprimir 4
        System.out.println(grafito.obtenerArco(8, 24).getEtiqueta()); // Debería imprimir 2.5
        System.out.println(grafito.obtenerArco(0, 262).getEtiqueta()); // Debería imprimir 1
        System.out.println(grafito.obtenerArco(24, 1).getEtiqueta()); // Debería imprimir 5
        
        System.out.println("-------------------------------------");
        
        System.out.println("CANTIDAD DE ARCOS: "+ grafito.cantidadArcos());
        
        System.out.println("-----------TODOS LOS ARCOS--------------------------");
        Iterator<Arco<Float>> itArcos =  grafito.obtenerArcos();
        while(itArcos.hasNext()) {
        	Arco<Float> arco = itArcos.next();
        	System.out.println(""+ arco.getEtiqueta());
        }
        System.out.println("-----------ADYACENTES-------------------------");
        Iterator<Integer> itAdyacentes =  grafito.obtenerAdyacentes(1);
        while(itAdyacentes.hasNext()) {
        	Integer adyacente = itAdyacentes.next();
        	System.out.println(""+ adyacente);
        }
    }
}
