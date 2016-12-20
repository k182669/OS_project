package rwproblem;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Date;

public class NewWriter extends Thread implements Runnable{

	public void run() {
		
			writer_window ww;
			try {
				ww = new writer_window();
				writer.nw = ww;
				ww.setLocation(500, 400);
				
				ww.setVisible(true);
				ww.setAlwaysOnTop(true);
				ww.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent event) {
						//ww.dispose();
						//writer.writerStart = true;
						try {
							writer.del();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
