public class Cylinder {
	private Circle c;
	private double length;
	private double area;
	private double volume;
	
	public Cylinder() { this(0.0, 0.0); }
	
	public Cylinder( double radius, double length ) {
		c = new Circle(radius);
		
		this.length = length;
		
		area = (2 * c.getArea()) + (c.getCircumference() * length);
		
		volume = c.getArea() * length;
	}
	
	public double getRadius() { return c.getRadius(); }
	public double getDiameter() { return c.getDiameter(); }
	public double getCircumference() { return c.getCircumference(); }
	
	public double getLength() { return length; }
	public double getArea() { return area; }
	public double getVolume() { return volume; }
}