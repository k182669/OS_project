package rwproblem;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class writer {
	public static boolean start = true;//在writer查看是否有reader在並且產生時間中，避免reader再次生成
	public static boolean writerStart = true;//若有writer存在，則為false，不讓其他w或r生成
	public static writer_window nw;
	public static ConcurrentLinkedQueue<NewWriter> q = new ConcurrentLinkedQueue<NewWriter>();

	public static void del() throws InterruptedException {
		nw.dispose();
		System.out.println("enter");
		if (!q.isEmpty()) {
			newWriterWindow();
		} else {
			writer.writerStart = true;
			reader.show();
		}
	}

	public static void newWriterWindow() {
		NewWriter waitWriter = q.poll();
		waitWriter.start();
	}
}
