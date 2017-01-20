package pamaldeep;
import java.awt.EventQueue;

public class PamaldeepProjectMain {

	public static void main(String[] thAargs) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PamaldeepMainWindow();
			}
		});
	}

}
