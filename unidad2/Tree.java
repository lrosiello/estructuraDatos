package unidad2;

import java.util.ArrayList;
import java.util.List;

public class Tree<T extends Comparable<T>> {

	private TreeNode<T> root;

	public Tree() {
		this.root = null;
	}

	// TOMAR LA RAIZ
	public T getRoot() {
		if (this.root != null) {
			return this.root.getValue();
		}
		return null;
	}

	// ESTA VACIO
	public boolean isEmpty() {
		return this.root == null;
	}

	// ES UNA HOJA
	public boolean isItALeaf(TreeNode<T> treeNode) {
		return treeNode.getLeft() == null && treeNode.getRight() == null;
	}

	// INSERTAR
	public void add(T value) {
		if (this.isEmpty())
			this.root = new TreeNode<T>(value);
		else
			this.add(this.root, value);
	}

	private void add(TreeNode<T> actual, T value) {
		if (actual.getValue().compareTo(value) > 0) {
			if (actual.getLeft() == null) {
				TreeNode<T> temp = new TreeNode<T>(value);
				actual.setLeft(temp);
				System.out.println("Estamos insertando en lado izquierdo de: " + actual.getValue()
						+ ", el nuevo elemento: " + value);
			} else {
				add(actual.getLeft(), value);
			}
		} else if (actual.getValue().compareTo(value) < 0) {
			if (actual.getRight() == null) {
				TreeNode<T> temp = new TreeNode<T>(value);
				actual.setRight(temp);
				System.out.println("Estamos insertando en lado derecho de: " + actual.getValue()
						+ ", el nuevo elemento: " + value);
			} else {
				add(actual.getRight(), value);
			}
		}
	}

	// BORRADO
	public boolean deleteItem(T item) {
		return delete(null, this.root, item);
	}

	private boolean delete(TreeNode<T> parent, TreeNode<T> currentNode, T item) {
		if (currentNode == null) {
			return false;
		}

		if (currentNode.getValue().compareTo(item) == 0) {
			if (isItALeaf(currentNode)) {
				if (parent != null) {
					if (parent.getLeft() == currentNode) {
						parent.setLeft(null);
					} else {
						parent.setRight(null);
					}
				} else {
					this.root = null;
				}
				return true;
			} else if (currentNode.getLeft() != null && currentNode.getRight() != null) {
				T newValue = findMax(currentNode.getLeft());
				delete(currentNode, currentNode.getLeft(), newValue);
				currentNode.setValue(newValue);
				return true;
			} else if (currentNode.getLeft() != null) {
				if (parent != null) {
					if (parent.getLeft() == currentNode) {
						parent.setLeft(currentNode.getLeft());
					} else {
						parent.setRight(currentNode.getLeft());
					}
				} else {
					this.root = currentNode.getLeft();
				}
				return true;
			} else {
				if (parent != null) {
					if (parent.getLeft() == currentNode) {
						parent.setLeft(currentNode.getRight());
					} else {
						parent.setRight(currentNode.getRight());
					}
				} else {
					this.root = currentNode.getRight();
				}
				return true;
			}
		} else if (currentNode.getValue().compareTo(item) > 0) {
			return delete(currentNode, currentNode.getLeft(), item);
		} else {
			return delete(currentNode, currentNode.getRight(), item);
		}
	}

	// ENCONTRAR EL MAXIMO
	private T findMax(TreeNode<T> treeNode) {
		if (treeNode.getRight() != null) {
			return findMax(treeNode.getRight());
		} else {
			return treeNode.getValue();
		}
	}

	// ENCONTRAR ELEMENTO
	public boolean hasElem(T element) {
		TreeNode<T> node = this.root;
		boolean result = hasElem(node, element);
		System.out.println(result);
		return result;
	}

	private boolean hasElem(TreeNode<T> node, T element) {
		if (node == null) {
			return false;
		}
		if (node.getValue().compareTo(element) == 0) {
			return true;
		}
		if (element.compareTo(node.getValue()) < 0) {
			return hasElem(node.getLeft(), element);
		}
		if (element.compareTo(node.getValue()) > 0) {
			return hasElem(node.getRight(), element);
		}
		return false;
	}

	// OBTENER ALTURA DEL ARBOL
	public int getHeight() {
		TreeNode<T> node = this.root;
		int count = 0;
		int result = recorrer(node, count);
		System.out.println(result);
		return result;
	}

	private int recorrer(TreeNode<T> node, int count) {
		int salida = 0;
		int sumatoriaIzq = 0;
		int sumatoriaDer = 0;

		salida++;

		if (!isItALeaf(node)) {
			if (node.getLeft() != null) {
				sumatoriaIzq += recorrer(node.getLeft(), count + 1);
			}
			if (node.getRight() != null) {
				sumatoriaDer += recorrer(node.getRight(), count + 1);
			}
		}

		if (sumatoriaIzq > sumatoriaDer) {
			salida += sumatoriaIzq;
		} else {
			salida += sumatoriaDer;
		}
		return salida;
	}

	// OBTENER RAMA MAS LARGA
	public List<T> getLongestBranch() {
		TreeNode<T> node = this.root;
		List<T> result = getLongestBranch(node);
		for (T i : result) {
			System.out.println(i);
		}

		return result;
	}

	private List<T> getLongestBranch(TreeNode<T> node) {
		List<T> salida = new ArrayList<>();
		List<T> salidaIzq = new ArrayList<>();
		List<T> salidaDer = new ArrayList<>();

		salida.add(node.getValue());

		if (!isItALeaf(node)) {
			if (node.getLeft() != null) {
				salidaIzq.addAll(getLongestBranch(node.getLeft()));
			}
			if (node.getRight() != null) {
				salidaDer.addAll(getLongestBranch(node.getRight()));
			}
		}

		if (salidaIzq.size() > salidaDer.size()) {
			salida.addAll(salidaIzq);
		} else {
			salida.addAll(salidaDer);
		}
		return salida;
	}

	// OBTENER FRONTERAS
	public List<T> getFrontera() {
		TreeNode<T> node = this.root;
		List<T> result = getFrontera(node);
		for (T i : result) {
			System.out.println(i);
		}

		return result;
	}

	private List<T> getFrontera(TreeNode<T> node) {
		List<T> salida = new ArrayList<>();

		if (isItALeaf(node)) {
			salida.add(node.getValue());
		}

		if (!isItALeaf(node)) {
			if (node.getLeft() != null) {
				salida.addAll(getFrontera(node.getLeft()));
			}
			if (node.getRight() != null) {
				salida.addAll(getFrontera(node.getRight()));
			}
		}

		return salida;
	}

	// OBTENER ELEMENTO DE MAS ALTO VALOR
	public T getMaxElem() {
		TreeNode<T> node = this.root;
		T result = getMaxElem(node);
		System.out.println(result);
		return result;
	}

	private T getMaxElem(TreeNode<T> node) {
		T max = null;

		if (node != null) {
			max = node.getValue();
			if (node.getRight() != null) {
				max = getMaxElem(node.getRight());
			}
			if (node.getLeft() != null) {
				if (max.compareTo(node.getLeft().getValue()) < 0) {
					max = getMaxElem(node.getLeft());
				}
			}
		}
		return max;
	}

	// OBTENER ELEMENTOS DE UN NIVEL INGRESADO
	public List<T> getElementAtLevel(int level) {
		TreeNode<T> node = this.root;
		int count = 0;
		List<T> result = getElementAtLevel(node, level, count);
		for (T i : result) {
			System.out.println(i);
		}

		return result;
	}

	private List<T> getElementAtLevel(TreeNode<T> node, int level, int count) {
		List<T> salida = new ArrayList<>();

		if (node == null) {
			return salida;
		}

		T currentValue = node.getValue();
		count++;

		if (node.getLeft() != null) {
			salida.addAll(getElementAtLevel(node.getLeft(), level, count));
		}
		if (node.getRight() != null) {
			salida.addAll(getElementAtLevel(node.getRight(), level, count));
		}

		if (level == count) {
			salida.add(currentValue);
		}

		return salida;
	}

	// OBTENER LAS HOJAS MAYORES AL VALOR K INGRESADO
	public List<T> getMajorLeafs(T k) {
		List<T> result = new ArrayList<>();
		result = getMajorLeafs(this.root, k);
		for (T i : result) {
			System.out.println(i);
		}
		return result;
	}

	private List<T> getMajorLeafs(TreeNode<T> node, T k) {
		List<T> salida = new ArrayList<>();

		if (node == null) {
			return salida;
		}

		if (isItALeaf(node) && node.getValue().compareTo(k) > 0) {
			salida.add(node.getValue());
		}

		if (node.getLeft() != null) {
			salida.addAll(getMajorLeafs(node.getLeft(), k));
		}

		if (node.getRight() != null) {
			salida.addAll(getMajorLeafs(node.getRight(), k));
		}
		return salida;
	}

	// OBTENER SUMATORIA DE VALORES
	public Integer getSumatoria() {
		TreeNode<T> node = this.root;
		int result = getSumatoria(node);
		System.out.println(result);
		return result;
	}

	private Integer getSumatoria(TreeNode<T> node) {
		Integer suma = 0;

		if (node != null) {
			suma += Integer.parseInt(node.getValue().toString());
			if (node.getRight() != null) {
				suma += getSumatoria(node.getRight());
			}
			if (node.getLeft() != null) {
				suma += getSumatoria(node.getLeft());
			}
		}
		return suma;
	}

	// OBTENER SEGUN ATRIBUTO

	public List<Libro> getElementsByAtribute(FiltroLibro filtro) {
	    return getElementsByAtribute(this.root, filtro);
	}

	private List<Libro> getElementsByAtribute(TreeNode<T> node, FiltroLibro filtro) {
	    List<Libro> salida = new ArrayList<>();

	    if (node == null) {
	        return salida;
	    }

	    if (filtro.cumple((Libro) node.getValue())) {
	        salida.add((Libro) node.getValue());
	    }

	    salida.addAll(getElementsByAtribute(node.getLeft(), filtro));
	    salida.addAll(getElementsByAtribute(node.getRight(), filtro));

	    return salida;
	}



	// RECORRIDOS
	public void recorridoOrden() {
		System.out.println(recorridoOrdenado(this.root));
	}

	private String recorridoOrdenado(TreeNode<T> treeNode) {
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

	private String recorridoPreOrdenado(TreeNode<T> treeNode) {
		if (treeNode == null) {
			return "";
		}

		String salida = "";

		salida += treeNode.getValue() + ", ";

		salida += recorridoPreOrdenado(treeNode.getLeft());

		salida += recorridoPreOrdenado(treeNode.getRight());

		return salida;
	}

}
