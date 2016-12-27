package rwproblem;

public class mutex {
	private int r_mutex;
	private int rw_mutex;
	private int w_mutex;
	public int getW_mutex() {
		return w_mutex;
	}
	public void setW_mutex(int w_mutex) {
		this.w_mutex = w_mutex;
	}
	public int getR_mutex() {
		return r_mutex;
	}
	public void setR_mutex(int r_mutex) {
		this.r_mutex = r_mutex;
	}
	public int getRw_mutex() {
		return rw_mutex;
	}
	public void setRw_mutex(int rw_mutex) {
		this.rw_mutex = rw_mutex;
	}
	
}
