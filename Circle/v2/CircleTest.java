public class CircleTest {
	public static void main (String[] args) {
		Circle a = new Circle();

		System.out.printf("Radius:%f\n", a.getRadius());
		System.out.printf("Diameter:%f\n", a.getDiameter());
		System.out.printf("Area:%f\n", a.getArea());
		System.out.printf("Circumference:%f\n", a.getCircumference());
		
		Circle b = new Circle(1);

		System.out.printf("Radius:%f\n", b.getRadius());
		System.out.printf("Diameter:%f\n", b.getDiameter());
		System.out.printf("Area:%f\n", b.getArea());
		System.out.printf("Circumference:%f\n", b.getCircumference());
	}
}