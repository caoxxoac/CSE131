package studio7;

public class Rectangle {
	private int length;
	private int width;
	
	private Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}
	
	private Rectangle() {
		this.length = 0;
		this.width = 0;
	}
	
	public int getArea() {
		return this.length * this.width;
	}
	
	
	public int getPerimeter() {
		return (this.length + this.width) * 2;
	}
	
	public boolean isSquare() {
		return (this.length == this.width);
	}
	
	public boolean isSmaller(Rectangle rec) {
		return (this.getArea() < rec.getArea());
	}
	
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(3, 2);
		Rectangle compare = new Rectangle(3, 4);
		System.out.println(rectangle.isSmaller(compare));
	}

}
