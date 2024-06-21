//interface Shape {
//    // Default method in the Shape interface
//    default String getDescription() {
//        return "This is a shape.";
//    }
//}
//
//interface Color {
//    // Default method in the Color interface
//    default String getDescription() {
//        return "This is a color.";
//    }
//}
//
//class ColoredCircle implements Shape, Color {
//    private double radius;
//    private String color;
//
//    public ColoredCircle(double radius, String color) {
//        this.radius = radius;
//        this.color = color;
//    }
//
//    @Override
//    public String getDescription() {
//        return "This is a " + color + " circle with a radius of " + radius + ".";
//    }
//
//    // You can also provide additional methods if needed
//    public double getRadius() {
//        return radius;
//    }
//
//    public String getColor() {
//        return color;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        ColoredCircle coloredCircle = new ColoredCircle(5.0, "red");
//        System.out.println(coloredCircle.getDescription());
//    }
//}
