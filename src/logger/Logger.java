package logger;

public class Logger {
  /*
   *  Printar texto com o efeito "typewriter";
   */
  public void printWithDelay(String text, Integer delay) {
		for (char c : text.toCharArray()) {
				System.out.print(c);
				try {
						Thread.sleep(delay);
				} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
				}
		}
		
		System.out.println();
	}
}
