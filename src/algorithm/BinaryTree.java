package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Trying to build a tree form which means it can be showing like a tree in console,have the idea of do this by 
 * find the number of layers of the tree and then calculate the blanks before each node, but I think it is a bit 
 * quite complicated,I do not know how to solve this with recursion,so just put this aside as unsolved
 * @author xule
 *
 */
public class BinaryTree {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
	}

	BinaryNode<Integer> root;

	public BinaryTree() {
		root = new BinaryNode<Integer>(3);
		createTree(root);
		System.out.println("*************display the tree*****************");
		display(root);
	}

	private void display(BinaryNode<Integer> root) {
		int layers = calculateLayers(root);
		System.out.println("*************"+ layers + "*****************");

		Queue<BinaryNode<Integer>> sameLayerOld = new LinkedList<BinaryNode<Integer>>();
		Queue<BinaryNode<Integer>> sameLayerNew = new LinkedList<BinaryNode<Integer>>();
		sameLayerOld.offer(root);
		BinaryNode<Integer> cur;
		while (sameLayerOld.size() != 0) {
			while ((cur = sameLayerOld.poll()) != null) {
				System.out.print(cur.getElement() + "  ");
				if (cur.getElement() < 10)
					System.out.print(" ");
				if (cur.getLeft() != null)
					sameLayerNew.offer(cur.getLeft());
				if (cur.getRight() != null)
					sameLayerNew.offer(cur.getRight());
			}
			sameLayerOld = sameLayerNew;
			sameLayerNew = new LinkedList<BinaryNode<Integer>>();
			System.out.println();
		}
	}

	private int calculateLayers(BinaryNode<Integer> root) {
		int count = 0;
		Queue<BinaryNode<Integer>> temp = new LinkedList<BinaryNode<Integer>>();
		Queue<BinaryNode<Integer>> newQueue = new LinkedList<BinaryNode<Integer>>();
		temp.offer(root);
		BinaryNode<Integer> cur = null;
		while (temp.size() != 0) {
			while ((cur = temp.poll()) != null) {
				if (cur.getLeft() != null)
					newQueue.offer(cur.getLeft());
				if (cur.getRight() != null)
					newQueue.offer(cur.getRight());
			}
			temp = newQueue;
			newQueue = new LinkedList<BinaryNode<Integer>>();
			count ++;
		}
		return count;

	}

	private void createTree(BinaryNode<Integer> root) {
		Queue<BinaryNode<Integer>> leafQueueOld = new LinkedList<BinaryNode<Integer>>();
		leafQueueOld.offer(root);
		System.out.println(root.getElement());
		for (int i = 0; i < 100; i++) {
			BinaryNode<Integer> cur = leafQueueOld.poll();
			if (cur != null) {
				addChild(cur, leafQueueOld);
			}
		}
	}

	private void addChild(BinaryNode<Integer> cur,
			Queue<BinaryNode<Integer>> leafQueue) {
		Random r = new Random();
		int luck = r.nextInt(4);
		BinaryNode<Integer> temp = null;
		if ((luck % 4) == 0) {
			temp = new BinaryNode<Integer>(r.nextInt(100));
			cur.setLeft(temp);
			leafQueue.offer(temp);
			System.out.println(temp.getElement());
		} else if ((luck % 4) == 1) {
			temp = new BinaryNode<Integer>(r.nextInt(100));
			cur.setRight(temp);
			leafQueue.offer(temp);
			System.out.println(temp.getElement());
		} else if ((luck % 4) == 2) {
			temp = new BinaryNode<Integer>(r.nextInt(100));
			cur.setRight(temp);
			leafQueue.offer(temp);
			System.out.println(temp.getElement());
			temp = new BinaryNode<Integer>(r.nextInt(100));
			cur.setLeft(temp);
			leafQueue.offer(temp);
			System.out.println(temp.getElement());
		}
	}

}

// The node element of a tree
class BinaryNode<T> {

	private T element;
	private BinaryNode<T> left;
	private BinaryNode<T> right;

	public BinaryNode(BinaryNode<T> left, BinaryNode<T> right, T value) {
		this.element = value;
		this.left = left;
		this.right = right;
	}

	public BinaryNode(T value) {
		this(null, null, value);
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public BinaryNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryNode<T> left) {
		this.left = left;
	}

	public BinaryNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryNode<T> right) {
		this.right = right;
	}
}
