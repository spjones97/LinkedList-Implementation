package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
	
	Node headCell;
	Node lastCell;

	public LinkedListImpl() {
		headCell = null;
		lastCell = null;
	}

	@Override
	public boolean insert(double elt, int index) {
		Node tempNode = new Node(elt);
		// First node is added
		if (headCell == null && lastCell == null && index == 0) {
			headCell = tempNode;
			lastCell = tempNode;
			tempNode = null;
			return true;
		}
		// Second node added
		if (headCell == lastCell && index == 0) {
			headCell = tempNode;
			lastCell.prev = headCell;
			headCell.next = lastCell;
			tempNode = null;
			return true;
		} else if (headCell == lastCell && headCell != null && lastCell != null && index == 1) {
			lastCell = tempNode;
			headCell.next = lastCell;
			lastCell.prev = headCell;
			return true;
		}
		// If insert at beginning
		if (index == 0 && headCell != null && lastCell != null) {
			headCell.prev = tempNode;
			tempNode.next = headCell;
			headCell = tempNode;
			tempNode = null;
			return true;
		}
		// If insert at end
		if (index == size()) {
			lastCell.next = tempNode;
			tempNode.prev = lastCell;
			lastCell = tempNode;
			return true;
		}
		// If insert is in middle
		Node root = getRoot();
		int i = 0;
		while (i < size()) {
			if (i == index) {
				root.prev.next = tempNode;
				tempNode.prev = root.prev;
				root.prev = tempNode;
				tempNode.next = root;
				root = null;
				tempNode = null;
				return true;
			}
			i++;
			root = root.getNext();
		}
		tempNode = null;
		return false;
	}

	@Override
	public boolean insort(double elt) {
		Node tempNode = new Node(elt);
		// If first time
		if (headCell == null) {
			headCell = tempNode;
			lastCell = tempNode;
			return true;
		}
		// If second time
		if (headCell == lastCell) {
			if (elt < headCell.getData()) {
				lastCell.prev = tempNode;
				tempNode.next = lastCell;
				headCell = tempNode;
			} else {
				headCell.next = tempNode;
				tempNode.prev = headCell;
				lastCell = tempNode;
			}
			return true;
		}
		Node root = headCell;
		while (root.next != null) {
			// If insert at beginning
			if (root == headCell && root.getData() > elt) {
				tempNode.next = headCell;
				headCell.prev = tempNode;
				headCell = tempNode;
				return true;
			} else {
				if (elt >= root.getData() && root.next.getData() > elt) {
					root.next.prev = tempNode;
					tempNode.next = root.next;
					root.next = tempNode;
					tempNode.prev =  root;
					return true;
				}
			}
			root = root.next;
		}
		// If insert at end;
		root.next = tempNode;
		tempNode.prev = lastCell;
		lastCell = tempNode;
		return true;
	}

	@Override
	public boolean remove(int index) {
		Node root = headCell;
		int i = 0;
		// If first node
		if (index == 0) {
			root.next.prev = null;
			headCell = root.next;
			root.next = null;
			return true;
		}
		// If last node
		if (index == size() - 1) {
			lastCell.prev.next = null;
			lastCell = lastCell.prev;
			return true;
		}
		// If middle node
		while (root != null) {
			if (i == index) {
				root.next.prev = root.prev;
				root.prev.next = root.next;
				root.next = null;
				root.prev = null;
				return true;
			}
			i++;
			root = root.next;
		}
		return false;
	}

	@Override
	public double get(int index) {
		Node tempNode = headCell;
		for (int i = 0; i < size(); i++) {
			if (i == index) {
				return tempNode.getData();
			} else {
				tempNode = tempNode.getNext();
			}
		}
		return Double.NaN;
	}

	@Override
	public int size() {
		int num = 0;
		Node tempNode = headCell;
		if (tempNode == null) {
			return num;
		}
		while (tempNode != null) {
			num++;
			tempNode = tempNode.getNext();
		}
		return num;
	}

	@Override
	public boolean isEmpty() {
		return headCell == null;
	}

	@Override
	public void clear() {
		headCell = null;
		lastCell = null;
	}

	public Node getRoot() {
		return headCell;
	}

	public Node getLast() {
		return lastCell;
	}
	
}
