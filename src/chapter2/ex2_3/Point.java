package chapter2.ex2_3;

public class Point {
	int x;
	int y;
	Point(int x1, int y1) { //构造方法，和类同名
		this.x = x1;
		this.y = y1;
	}
	void setX(int x1) {
		this.x = x1;
	}
	void setY(int y1) {
		this.y = y1;
	}
	double getDistance() {
		double distance = 0;
		distance = Math.sqrt(x*x + y*y); //数学类Math的静态方法sqrt：开根号
		return distance;
	}
	public static void main(String[] args) {
		Point p = new Point(1,1); //创建了一个点对象，x轴=1，y轴=1
		System.out.println(p.getDistance());
	}
}


