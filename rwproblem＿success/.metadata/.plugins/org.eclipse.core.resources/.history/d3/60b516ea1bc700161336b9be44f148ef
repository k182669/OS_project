package rwproblem;

import java.awt.*;
import java.io.IOException;
import java.util.Date;

import javax.swing.*;

public class rw {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * reader r & writer w 
		 * 當r讀取時，可以分享給無限數量的reader 
		 * 但是當w改動時，必須互斥
		 * 問題一：當w開始改寫時，沒有r可以進去，產生r的飢餓 
		 * 問題二：當有任何waiting reader的時候，writer不能進去，產生w的飢餓
		 */
		userInt userInterface = new userInt();//呼叫產生使用者介面
		userInterface.setVisible(true);//使用者介面顯示
		boolean b = true;//當所有reader超過十秒鐘，全部刪除跳出
		do {
			Date now = new Date();//取得現在時間
			int e = now.getSeconds();//現在秒數
			int em = now.getMinutes();//現在分鐘
			int end = em*60+e;//轉換成秒數，和start時的時間相減，取得此介面開啟時間
			for (int i = 0; i < reader.reader_counter; i++) {//跑每個開啟的reader界面
				if (end - timeArr.timeArr[i] < 10) {//當時間未超過十秒
					b = true;//當有一個為超過十秒，無法跳出
				} else {//其中一個超過十秒
					b = false;//可能會跳出
					timeArr.threadArr[i].exit();//跳到NewReader，執行jFrame的dispose
					System.out.println(i+":"+(end - timeArr.timeArr[i]));
				}
			}
		} while (b);//當有一個未到十秒即繼續
	}

}