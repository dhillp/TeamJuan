package Pamal;
import java.awt.EventQueue;

public class projectMain {

	public static void main(String[] thAargs) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new mainWindow();
			}
		});
	}

}
