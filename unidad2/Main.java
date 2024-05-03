package unidad2;

public class Main {

	public static void main(String[] args) {

		Tree arbolBinario = new Tree();
		arbolBinario.add(6);
		arbolBinario.add(2);
		arbolBinario.add(8);
		arbolBinario.add(1);
		arbolBinario.add(4);
		arbolBinario.add(3);
		arbolBinario.add(7);
		
		arbolBinario.recorridoOrden();
		arbolBinario.recorridoPreOrden();
		
	
		arbolBinario.deleteItem(7);
	
		System.out.println("eliminando un elemento=========");
		
		System.out.println(arbolBinario.getRoot());
		arbolBinario.recorridoOrden();
		arbolBinario.recorridoPreOrden();
	}

}
