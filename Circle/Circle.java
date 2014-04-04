public class Circle {
	private double radius;
	private double PI = 3.14159;

	public Circle() { radius = 0.0; }

	public Circle(double radius) { this.radius = radius; }

	public double getRadius() { return radius; }

	public double getDiameter() { return 2*radius; }

	public double getCircumference() { return 2*PI*radius; }

	public double getArea() { return PI*radius*radius; }
}