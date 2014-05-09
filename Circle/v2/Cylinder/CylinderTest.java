public class CylinderTest {
	public static void main(String[] args) {
		Cylinder x = new Cylinder();
		
		System.out.printf("Radius: %f\n", x.getRadius());
		System.out.printf("Diameter: %f\n", x.getDiameter());
		System.out.printf("Circumference: %f\n", x.getCircumference());
		
		System.out.printf("Length: %f\n", x.getLength());
		System.out.printf("Area: %f\n", x.getArea());
		System.out.printf("Volume: %f\n", x.getVolume());
		
		Cylinder y = new Cylinder(5.0, 10.0);
		
		System.out.printf("Radius: %f\n", y.getRadius());
		System.out.printf("Diameter: %f\n", y.getDiameter());
		System.out.printf("Circumference: %f\n", y.getCircumference());
		
		System.out.printf("Length: %f\n", y.getLength());
		System.out.printf("Area: %f\n", y.getArea());
		System.out.printf("Volume: %f\n", y.getVolume());
	}
}
		