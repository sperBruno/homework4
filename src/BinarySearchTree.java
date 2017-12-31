
public class BinarySearchTree<E extends Comparable<E>> {
	class Node {
		E value;
		Node leftChild = null;
		Node rightChild = null;

		Node(E value) {
			this.value = value;
		}

		@Override
		public boolean equals(Object obj) {
			if ((obj instanceof BinarySearchTree.Node) == false)
				return false;
			@SuppressWarnings("unchecked")
			Node other = (BinarySearchTree<E>.Node) obj;
			return other.value.compareTo(value) == 0 && other.leftChild == leftChild && other.rightChild == rightChild;
		}
	}

	protected Node root = null;

	protected void visit(Node n) {
		System.out.println(n.value);
	}

	public boolean contains(E val) {
		return contains(root, val);
	}

	protected boolean contains(Node n, E val) {
		if (n == null)
			return false;

		if (n.value.equals(val)) {
			return true;
		} else if (n.value.compareTo(val) > 0) {
			return contains(n.leftChild, val);
		} else {
			return contains(n.rightChild, val);
		}
	}

	public boolean add(E val) {
		if (root == null) {
			root = new Node(val);
			return true;
		}
		return add(root, val);
	}

	protected boolean add(Node n, E val) {
		if (n == null) {
			return false;
		}
		int cmp = val.compareTo(n.value);
		if (cmp == 0) {
			return false; // this ensures that the same value does not appear more than once
		} else if (cmp < 0) {
			if (n.leftChild == null) {
				n.leftChild = new Node(val);
				return true;
			} else {
				return add(n.leftChild, val);
			}
		} else {
			if (n.rightChild == null) {
				n.rightChild = new Node(val);
				return true;
			} else {
				return add(n.rightChild, val);
			}
		}
	}

	public boolean remove(E val) {
		return remove(root, null, val);
	}

	protected boolean remove(Node n, Node parent, E val) {
		if (n == null)
			return false;

		if (val.compareTo(n.value) == -1) {
			return remove(n.leftChild, n, val);
		} else if (val.compareTo(n.value) == 1) {
			return remove(n.rightChild, n, val);
		} else {
			if (n.leftChild != null && n.rightChild != null) {
				n.value = maxValue(n.leftChild);
				remove(n.leftChild, n, n.value);
			} else if (parent == null) {
				root = n.leftChild != null ? n.leftChild : n.rightChild;
			} else if (parent.leftChild == n) {
				parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
			} else {
				parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
			}
			return true;
		}
	}

	protected E maxValue(Node n) {
		if (n.rightChild == null) {
			return n.value;
		} else {
			return maxValue(n.rightChild);
		}
	}

	/*********************************************
	 * 
	 * IMPLEMENT THE METHODS BELOW!
	 *
	 *********************************************/

	// Method #1.
	public Node findNode(E val) {

		if (val != null) {
			return findNode(root, val);
		}

		return null; // this line is here only so this code will compile if you don't modify it

	}

	private Node findNode(Node root, E val) {
	 /*	if (root != null) {
			if (root.value.equals(val)) {
				return root;
			} else if (root.leftChild != null && root.leftChild.value.equals(val)) {
				return root.leftChild;
			} else if (root.rightChild != null && root.rightChild.value.equals(val)) {
				return root.rightChild;

			} else {
				if (root.leftChild != null && root.rightChild == null) {
					findNode(root.leftChild, val);
				} else if (root.rightChild != null && root.leftChild == null) {
					findNode(root.rightChild, val);
				} else {
					findNode(root.leftChild, val);
					findNode(root.rightChild, val);
				}
			}
		}
		*/
		if (root == null)
			return null;

		if (root.value.equals(val)) {
			return root;
		} else if (root.value.compareTo(val) > 0) {
			count++;
			return findNode(root.leftChild, val);
		} else {
			count++;
			return findNode(root.rightChild, val);
		}
	}
	int count = 0;
	// Method #2.
	protected int depth(E val) {
		
		if (root == null || val == null)
			return -1;

		Node nodeExists = findNode(root, val);
		if (nodeExists == null) {
			return -1;
		}
		return count; // this line is here only so this code will compile if you don't modify it

	}

	// Method #3.
	protected int height(E val) {
		if (root == null || val == null)
			return -1;
		
		
		Node nodeExists = findNode(root, val);
		
		if (nodeExists == null) {
			return -1;
		}
		
		if (nodeExists.leftChild == null && nodeExists.rightChild == null)
			return 0;

		return count; // this line is here only so this code will compile if you don't modify it

	}

	// Method #4.
	protected boolean isBalanced(Node n) {

		/* IMPLEMENT THIS METHOD! */
		if (n == null)
			return false;
		return true; // this line is here only so this code will compile if you don't modify it

	}

	// Method #5. .
	public boolean isBalanced() {

		/* IMPLEMENT THIS METHOD! */

		return false; // this line is here only so this code will compile if you don't modify it

	}

}
