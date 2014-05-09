public class Circle {

	private double radius;
	private double diameter;
	private double circumference;
	private double area;

	private static final double PI = 3.14159;

	public Circle() { this(0.0); }

	public Circle(double radius) { init(radius); }

	public void setRadius(double radius) { init(radius); }

	public double getRadius() { return radius; }

	public double getDiameter() { return diameter; }

	public double getCircumference() { return circumference; }

	public double getArea() { return area; }

	private void init(double r) {

		radius = Math.abs(r);

		diameter = 2 * radius;

		circumference = 2 * PI * radius;

		area = PI * Math.pow(radius, 2);

	}
}