package multithread;

public class Test implements Runnable {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			Test line = new Test();
			Thread t = new Thread(line, i + "");
			t.start();
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Sum.list();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}

class Sum {
	static Integer sum = 0;

	public static void list() {
		sum++;
		System.out.println("I am Thread: " + Thread.currentThread().getName()
				+ " sum--------->" + sum);
	}
}
