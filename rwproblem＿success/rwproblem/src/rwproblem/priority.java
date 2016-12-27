package rwproblem;

public class priority {
	public static int ratio;

	public static void count() throws InterruptedException {
		System.out.println("ratio="+ratio+",r="+reader.qr.size()+",w="+writer.q.size());
		System.out.println("this is the ratio");
		if (!writer.turnToReader) {
			ratio = reader.qr.size()/writer.q.size();
			System.out.println("get the ratio number");
			writer.turnToReader = true;
			writer.newWriterWindow();
		} else {

			NewReader[] nrArr = new NewReader[ratio];
			for (int i = 0; i < nrArr.length; i++) {
				nrArr[i] = reader.qr.poll();
			}
			reader.showNumber(nrArr);
		}
	}

}
