package productandconsume;

import java.util.List;

public class Consume implements Runnable {
	private List container = null;
	private int count;

	public Consume(List lst) {
		this.container = lst;
	}

	public void run() {
		while (true) {
			synchronized (container) {
				if (container.size() == 0) {
					try {
						container.wait();// 放弃锁
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				container.remove(0);
				container.notify();
				System.out.println("I ate: " + (++count));
			}
		}
	}
}