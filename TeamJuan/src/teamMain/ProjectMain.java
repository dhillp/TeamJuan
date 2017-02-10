package teamMain;
import java.awt.EventQueue;

public class ProjectMain {

	public static void main(String[] theAargs) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainWindow();
			}
		});
	}

}
