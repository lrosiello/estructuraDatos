package unidad2;

public class Tree {

	private TreeNode root;

	public Tree() {
		this.root = null;
	}

	// toma raiz
	public Integer getRoot() {
		if(this.root !=null) {
			return this.root.getValue();
		}
		return 0;
	}

	// esta vacio?
	public boolean isEmpty() {
		return this.root == null;
	}

	// es una hoja?
	public boolean isItALeaf(TreeNode treeNode) {
		return treeNode.getLeft() == null && treeNode.getRight() == null;
	}
	// INSERT////////////////////////////////////

	public void add(Integer value) {
		if (this.isEmpty())
			this.root = new TreeNode(value);
		else
			this.add(this.root, value);
	}

	private void add(TreeNode actual, Integer value) {
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) {
				TreeNode temp = new TreeNode(value);
				actual.setLeft(temp);
			} else {
				add(actual.getLeft(), value);
			}
		} else if (actual.getValue() < value) {
			if (actual.getRight() == null) {
				TreeNode temp = new TreeNode(value);
				actual.setRight(temp);
			} else {
				add(actual.getRight(), value);
			}
		}
	}

	public boolean deleteItem(int item) {
	    return delete(null, this.root, item);
	}

	private boolean delete(TreeNode parent, TreeNode currentNode, int item) {
	    if (currentNode == null) {
	        return false;
	    }

	    if (currentNode.getValue() == item) {
	    	//SI ES UNA HOJA
	        if (isItALeaf(currentNode)) {
	            if (parent != null) { //SI HAY PADRE
	                if (parent.getLeft() == currentNode) { //SI NODO IZQ DE PADRE ES IGUAL AL NODO
	                    parent.setLeft(null); //EL PADRE ELIMINA REFERENCIA A NODO ACTUAL
	                } else {
	                    parent.setRight(null); //SINO, ELIMINA REFERENCIA AL DERECHO
	                }
	            } else { //SI NO TIENE PADRE, ES PORQUE ES UNA RAIZ
	                this.root = null; // SE ELIMINA LA RAIZ
	            }
	            return true;
	        } else if (currentNode.getLeft() != null && currentNode.getRight() != null) { // TIENE 2 HIJOS
	            int newValue = findMax(currentNode.getLeft());
	            delete(currentNode, currentNode.getLeft(), newValue); // Eliminar el valor máximo del subárbol izquierdo
	            currentNode.setValue(newValue);
	            return true;
	        } else if (currentNode.getLeft() != null) { // TIENE IZQUIERDO
	            if (parent != null) {
	                if (parent.getLeft() == currentNode) {
	                    parent.setLeft(currentNode.getLeft());
	                } else {
	                    parent.setRight(currentNode.getLeft());
	                }
	            } else {
	                this.root = currentNode.getLeft(); // Si el nodo a eliminar es la raíz
	            }
	            return true;
	        } else { // TIENE DERECHO
	            if (parent != null) {
	                if (parent.getLeft() == currentNode) {
	                    parent.setLeft(currentNode.getRight());
	                } else {
	                    parent.setRight(currentNode.getRight());
	                }
	            } else {
	                this.root = currentNode.getRight(); // Si el nodo a eliminar es la raíz
	            }
	            return true;
	        }
	    } else if (currentNode.getValue() > item) {
	        return delete(currentNode, currentNode.getLeft(), item);
	    } else {
	        return delete(currentNode, currentNode.getRight(), item);
	    }
	}

	// Método auxiliar para encontrar el máximo valor en un subárbol
	private int findMax(TreeNode treeNode) {
	    if (treeNode.getRight() != null) {
	        return findMax(treeNode.getRight());
	    } else {
	        return treeNode.getValue();
	    }
	}




	// RECORRIDO/////////////////////////////////////////////////
	public void recorridoOrden() {
		System.out.println(recorridoOrdenado(this.root));
	}

	private String recorridoOrdenado(TreeNode treeNode) {
		// CONDICION DE CORTE
		if (this.isEmpty()) {
			return "";
		}

		String salida = "";

		if (treeNode.getLeft() != null) {
			salida += recorridoOrdenado(treeNode.getLeft());
		}

		salida += treeNode.getValue() + ", ";

		if (treeNode.getRight() != null) {
			salida += recorridoOrdenado(treeNode.getRight());
		}

		return salida;
	}

	public void recorridoPreOrden() {
		System.out.println(recorridoPreOrdenado(this.root));
	}

	private String recorridoPreOrdenado(TreeNode treeNode) {
		if (treeNode == null) {
			return "";
		}

		String salida = "";

		// Visitar el nodo actual
		salida += treeNode.getValue() + ", ";

		// Recorrer el subárbol izquierdo
		salida += recorridoPreOrdenado(treeNode.getLeft());

		// Recorrer el subárbol derecho
		salida += recorridoPreOrdenado(treeNode.getRight());

		return salida;
	}

}