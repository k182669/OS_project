package rwproblem;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

public class reader {
	// private int reader_counter;
	public static int reader_counter;// 記錄現在有開啟幾個reader
	public static boolean readerDoing = true;// 避免同時產生reader造成count不同步
	public static boolean hasWaiting = false;//當還有writer和reader在等的時候，reader必須放在等待佇列中
	public static ConcurrentLinkedQueue<NewReader> qr = new ConcurrentLinkedQueue<NewReader>();// 紀錄在有writer下的時候，被點擊卻無法開啟的reader

	public reader(int rc) {
		this.reader_counter = rc;
	}

	public static void show() throws InterruptedException {
		int j = 0;// 當writer結束之後，將writer時間開啟的reader全部開啟
		while (!qr.isEmpty()) {// 當佇列中還有reader
			NewReader nr = qr.poll();// 從佇列中取第一個reader
			timeArr.threadArr[j] = nr;// 將NewReader放入陣列中與time相對應
			Thread.sleep(1000);// 等待一秒鐘，避免同時間無法重複start thread
			Date d = new Date();// 取得reader被start的時間
			int s = d.getSeconds();
			int m = d.getMinutes();
			timeArr.timeArr[j] = m * 60 + s;
			timeArr.threadArr[j].start();// start這個NewReader
			j++;// array index++
		}
	}

	public static void showNumber(NewReader[] nrArr) throws InterruptedException {// 當reader和writer都有在等候時
		for (int i = 0; i < nrArr.length; i++) {// 取得的reader數量，來自priority
			timeArr.threadArr[i] = nrArr[i];// 將NewReader放入陣列中
			Thread.sleep(1000);//等待一秒鐘
			Date d = new Date();
			int s = d.getSeconds();
			int m = d.getMinutes();
			timeArr.timeArr[i] = m * 60 + s;//將開始時間放入
			timeArr.threadArr[i].start();//開始thread
			writer.turnToReader = false;//下一個將換成writer
		}
		
	}
	
}
