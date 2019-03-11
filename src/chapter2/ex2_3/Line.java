package chapter2.ex2_3;

public class Line {
	Point startPoint; //起点
	Point endPoint;  //终点
	Line(Point p1, Point p2) {
		startPoint = p1;
		endPoint = p2;
	}
	Line(int x1, int y1, int x2, int y2) {
		Point p1 = new Point(x1, y1); //创建点对象
		Point p2 = new Point(x2, y2); 
		startPoint = p1; // 将起点设为p1
		endPoint = p2;
	}
	void setStartPoint(Point p) {
		startPoint = p;
	}
	void setEndPoint(Point p) {
		endPoint = p;
	}
	double getLength() { // 获得直线段的长度
		int x = startPoint.x - endPoint.x;
		int y = startPoint.y - endPoint.y;
		double length = Math.sqrt(x*x + y*y);
		return length;
	}
	public static void main(String[] args) {
		Point p1 = new Point(1,1);
		Point p2 = new Point(2,2);
		Line line1 = new Line(p1,p2);
		System.out.println(line1.getLength());
	}

}


