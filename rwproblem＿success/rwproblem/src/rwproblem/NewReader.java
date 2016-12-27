package rwproblem;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Date;

public class NewReader extends Thread implements Runnable {

	reader_window rw;
	public void run() {
		while(!reader.readerDoing);
			//reader_window rw;
			try {
				reader.readerDoing = false;
				rw = new reader_window();
				rw.setVisible(true);
				rw.setAlwaysOnTop(true);
				this.rw.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent event) {
						reader.reader_counter--;
						System.out.println("sub=" + reader.reader_counter);
						rw.dispose();
						if(reader.reader_counter==0){
							if(!writer.q.isEmpty()){
								writer.couldDel = false;
								try {
									writer.del();
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
				});
				//Date s = new Date();
				//int ss = s.getSeconds();
				//int ms = s.getMinutes();
				rw.setLocation(500, 400);
				//timeArr.timeArr[reader.reader_counter] = ss+ms*60;
				reader.reader_counter++;
				System.out.println("plus=" + reader.reader_counter);
				reader.readerDoing = true;
				
				rw.setVisible(true);
				rw.setAlwaysOnTop(true);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	public void exit(){
		System.out.println("reader #:"+reader.reader_counter);
		reader.reader_counter--;
		if(reader.reader_counter==0){
			writer.writerStart = true;
		}
		rw.dispose();
	}
	
}
