public class CircleTest {
	public static void main (String[] args) {
		Circle c = new Circle(5);

		System.out.printf("Diameter:%f\n", c.getDiameter());
		System.out.printf("Area:%f\n", c.getArea());
		System.out.printf("Circumference:%f\n", c.getCircumference());
	}
}