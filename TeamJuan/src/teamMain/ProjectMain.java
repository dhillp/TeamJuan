package teamMain;
import java.awt.EventQueue;

public class ProjectMain {

	public static void main(String[] theArgs) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
//				new LoginScreen();
				new MainWindow();
			}
		});
	}

}
