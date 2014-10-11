package algorithm;

/**
 * Need to calculate the sum of the number in even position in a fibonacci sequence(for the first 1000 number)
 */
public class Fibonacci {
	public int sumByStore(){
		int sum = 0;
		int []fibonacci = null;
		fibonacci[1] = 1;
		fibonacci[2] = 1;
		sum += fibonacci[2]; 
		for (int i = 3; i <= 1000; i++) {
			fibonacci[i] = fibonacci[i-1] + fibonacci[i-2]; 
			if ((i % 2) ==0)
			sum += fibonacci[i];
		}
		return sum;
	}
	
	public void printFibonacci() {
		int first = 1;
		int second = 1;
		int third = 0;
		System.out.print(first + "   ");
		System.out.print(second + "   ");
		int count = 0;
		for (int i = 3; i <= 1000; i++) {
			third = first + second;
			first = second;
			second = third;
			System.out.print(third + "  ");
			if ((++count) % 10 == 0 )
				System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		fibonacci.printFibonacci();
	}
}
