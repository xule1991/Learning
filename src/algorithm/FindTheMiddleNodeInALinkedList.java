package algorithm;

import java.util.Random;
/**
 * A interview question:
 * Description:
 * 	Find the middle node of a linkedlist 
 * Ideas:
 * 	1. quick and slow pointer
 *  2. go through the list and find the number of nodes then traverse again to find the middle
 * @author xule
 *
 */
public class FindTheMiddleNodeInALinkedList {
	
		
	public static void main(String[] args) {
		FindTheMiddleNodeInALinkedList findTheMiddleNodeInALinkedList = new FindTheMiddleNodeInALinkedList();
		Node head = new Node();
		head = findTheMiddleNodeInALinkedList.constructNewList();
		System.out.println("***********The original list***************");
		display(head);
		Integer i1 = findTheMiddleNodeInALinkedList.findMiddleByTraverse(head);
		System.out.println("***********The middle node traverse***************");
		System.out.println(i1);
		Integer i2 = findTheMiddleNodeInALinkedList.findMiddleByQuickSlowPointer(head);
		System.out.println("***********The middle node quick slow pointer***************");
		System.out.println(i2);
	}

	/**
	 * if the num of the node is odd, then the middle is (num + 1) / 2
	 * if the num of the node is even, then the middle is num / 2
	 * @param head
	 * @return the integer of the middle node
	 */
	private Integer findMiddleByQuickSlowPointer(Node head) {
		Node cur1 = head;
		Node cur2 = head;
		int count = 0;
		while (cur1.next != null) {
			cur1 = cur1.next;
			//pre++ and post++ is different
			if((++count)%2 == 1)
				cur2 = cur2.next;
		}
		return cur2.integer;
		
	}

	private Integer findMiddleByTraverse(Node head) {
		Node cur = head;
		int count = 0;
		while (cur.next != null) {
			count++;
			cur = cur.next;
		}
		cur = head;
		for (int i = 0; i < (count + 1) / 2; i ++) {
			cur = cur.next;
		}
		return cur.integer;
	}

	private static void display(Node head) {
		Node cur = head;
		int i = 0;
		while(cur.next != null) {
			cur = cur.next;
			System.out.print(cur.integer + " ");
			i ++;
		}
		System.out.println();
		System.out.println("count is: " + i);
	}

	private Node constructNewList() {
		Node head = new Node();
		Node cur = head;
		Random r = new Random();
		for (int i = 0; i < r.nextInt(100); i ++) {
			Node temp = new Node();
			temp.integer = r.nextInt(100);
			cur.next = temp;
			cur = cur.next;
		}
		return head;
	}
}

class Node {
	public Integer integer;
	public Node next;
}
