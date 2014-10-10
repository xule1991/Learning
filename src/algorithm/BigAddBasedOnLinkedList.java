package algorithm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * Interview issue to implement the big add based on linked list,on site I thought that I can use Integer as carry,
 * because it is Object and will pass to method by reference and I told the interviewer that way.At that time I just 
 * write the code on the blackboard and when I debug the code I find that Integer can just be passed by value,so we need 
 * to create a new class to deal with this issue.
 * 
 * plus:
 * Wrapper class, String, Primitive can just be passed by value.
 * @author xule
 *
 */
public class BigAddBasedOnLinkedList {
	/**
	 * Get two lists containing Iteger nodes and then compute the sum
	 * @param a
	 * @param b
	 * @return sum
	 */
	public List<Integer> bigAdd(List<Integer> a, List<Integer> b) {
		//List which contains the result
		List<Integer> result = new LinkedList<Integer>();
		
		//Because we need to operate add from the last node of the list so we reverse the list first
		a = reverse(a);
		b = reverse(b);
		Iterator<Integer> i1 = a.iterator();
		Iterator<Integer> i2 = b.iterator();
		
		//Carry is used to mark whether the sum is more then ten
		Carry carry = new Carry();
		/*while i1, i2 both have next element then we should add both and store the answer 
		into the result*/
		while(i1.hasNext() && i2.hasNext()) 
			result.add(add(i1.next(), i2.next(), carry));
		//If i1,i2 both do not have next we need to deal with carry
		if (!(i1.hasNext() || i2.hasNext())) {
			if (carry.carry == 1)
				result.add(1);
			return reverse(result);
		}
		
		//Becuase the carry issue so we need to deal with the first single node specially	
		if (i1.hasNext())
			result.add(i1.next() + carry.carry);
		if (i2.hasNext())
			result.add(i2.next() + carry.carry);
		while (i1.hasNext())
			result.add(i1.next());
		while (i2.hasNext())
			result.add(i2.next());
		return reverse(result);
	}

	/**
	 * Reverse the list
	 * @param origin
	 * @return temp
	 */
	private List<Integer> reverse(List<Integer> origin) {
		List<Integer> temp = new LinkedList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		Iterator<Integer> iterator= origin.iterator();
		while(iterator.hasNext())
			stack.push(iterator.next());
		while(!stack.isEmpty())
			temp.add(stack.pop());
		return temp;
	}

	/**
	 * This method is used to deal with add operation with single digit, considering carry-over 
	 * @param a1
	 * @param a2
	 * @param carry.carry
	 * @return sum in sigle digit and carry in carry
	 */
	private Integer add(Integer a1, Integer a2, Carry carry) {
		Integer sum = a1 + a2 + carry.carry;
		if (sum >= 10) {
			sum = sum - 10;
			carry.carry = 1;
		} else {
			carry.carry = 0;
		}
		return sum;
	}
	
	public static void display(List<Integer> a) {
		Iterator<Integer> iterator = a.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next());
		}
		System.out.println();
	}

	private static List<Integer> createBigIntegerList(Random random) {
		List<Integer> a = new LinkedList<Integer>();
		a.add(random.nextInt(10));
		a.add(random.nextInt(10));
		a.add(random.nextInt(10));
		a.add(random.nextInt(10));
		a.add(random.nextInt(10));
		a.add(random.nextInt(10));
		a.add(random.nextInt(10));
		return a;
	}
	
	private static List<Integer> createBigIntegerList1(Random random) {
		List<Integer> a = new LinkedList<Integer>();
		a.add(random.nextInt(10));
		a.add(random.nextInt(10));
		a.add(random.nextInt(10));
		a.add(random.nextInt(10));
		a.add(random.nextInt(10));
		a.add(random.nextInt(10));
		a.add(random.nextInt(10));
		a.add(random.nextInt(10));
		a.add(random.nextInt(10));
		a.add(random.nextInt(10));
		return a;
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		//Create list a
		List<Integer> a = createBigIntegerList(random);
		List<Integer> b = createBigIntegerList1(random);
		System.out.print("a: " );
		display(a);
		System.out.print("b: " );
		display(b);
		
		BigAddBasedOnLinkedList bigAdd = new BigAddBasedOnLinkedList();
		System.out.print("sum: " );
		display(bigAdd.bigAdd(a, b));
		

	}
}

class Carry{
	int carry = 0;
}
