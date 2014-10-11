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
			if ((i % 2) ==0)
			fibonacci[i] = fibonacci[i-1] + fibonacci[i-2]; 
			sum += fibonacci[i];
		}
		return sum;
	}
	public static void main() {
		
	}
}
