package teamMain;
import java.awt.EventQueue;

public class ProjectMain {

	public static void main(String[] thAargs) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainWindow();
			}
		});
	}

}
