package rwproblem;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Date;

public class NewWriter extends Thread implements Runnable{
	writer_window ww;
	public void run() {
			try {
				ww = new writer_window();
				System.out.println("create the writer");
				//writer.nw = ww;
				ww.setLocation(500, 400);
				
				ww.setVisible(true);
				ww.setAlwaysOnTop(true);
				//exitWriter();
				this.ww.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent event) {
						System.out.println("close the writer");
						ww.dispose();
						writer.writerStart = true;
						try {
							writer.couldDel = false;
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
	
	public writer_window getWriterWindow(){
		return this.ww;
	}
	
	/*public void exitWriter() throws InterruptedException{
		this.ww.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				System.out.println("close the writer");
				ww.dispose();
				writer.writerStart = true;
				try {
					writer.couldDel = false;
					writer.del();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		writer.writerStart = true;
		writer.couldDel = false;
		ww.dispose();
		writer.del();
	}*/
	
	public void exit(){
		writer.writerStart = true;
		writer.couldDel = false;
		ww.dispose();
	}

}
