//public interface Shape {
//    // A default method to calculate the area of the shape
//    default double calculateArea() {
//        // Default implementation can return 0 or throw an exception
//        // as we usually don't know the shape's specific dimensions
//        return 0;
//    }
//}
//
//// Example implementation for a Rectangle
//class Rectangle implements Shape {
//    private double length;
//    private double width;
//
//    public Rectangle(double length, double width) {
//        this.length = length;
//        this.width = width;
//    }
//
//    @Override
//    public double calculateArea() {
//        return length * width;
//    }
//}
//
//// Example implementation for a Circle
//class Circle implements Shape {
//    private double radius;
//
//    public Circle(double radius) {
//        this.radius = radius;
//    }
//
//    @Override
//    public double calculateArea() {
//        return Math.PI * radius * radius;
//    }
//}
//
//public class CalculateAreaExample {
//    public static void main(String[] args) {
//        Shape rectangle = new Rectangle(4, 5);
//        Shape circle = new Circle(3);
//
//        System.out.println("Area of rectangle: " + rectangle.calculateArea());
//        System.out.println("Area of circle: " + circle.calculateArea());
//    }
//}