public class APCSA_9A {
        public static void main(String[] args) {
            Circle circle = new Circle("Red", true, 5.0);
            Rectangle rectangle = new Rectangle("Blue", false, 4.0, 6.0);
            Triangle triangle = new Triangle("Green", true, 3.0, 4.0, 5.0);

            // Display info
            System.out.println("Circle:");
            circle.displayInfo();
            System.out.println("\nRectangle:");
            rectangle.displayInfo();
            System.out.println("\nTriangle:");
            triangle.displayInfo();


            Shape[] shapes = { circle, rectangle, triangle };
            for (Shape shape : shapes) {
                System.out.println(shape.getClass().getSimpleName() + " Area: " + shape.calculateArea());
                System.out.println(shape.getClass().getSimpleName() + " Perimeter: " + shape.calculatePerimeter());
            }

            Square square = new Square("Purple", true, 7.0);
            Pentagon pentagon = new Pentagon("Yellow", false, 5.0);
            House house = new House("Brown", true, 8.0);

            // Display info
            System.out.println("\nSquare:");
            square.displayInfo();
            System.out.println("\nPentagon:");
            pentagon.displayInfo();
            System.out.println("\nHouse:");
            house.displayInfo();

            Shape[] shapesnum = { circle, rectangle, triangle, square, pentagon, house };

            for (Shape shape : shapes) {
                System.out.println("\n" + shape.getClass().getSimpleName() + " - Area: " + shape.calculateArea());
                System.out.println(shape.getClass().getSimpleName() + " - Perimeter: " + shape.calculatePerimeter());
            }
        }

}
class Shape {
    private String color;
    private boolean filled;

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    // Accessor
    public String getColor() {
        return color;
    }

    public boolean isFilled() {
        return filled;
    }

    // Mutator
    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public double calculateArea() {
        return 0.0;
    }

    public double calculatePerimeter() {
        return 0.0;
    }

    public void displayInfo() {
        System.out.println("Color: " + color);
        System.out.println("Filled: " + filled);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
    }
}
 class Circle extends Shape {
    private double radius;

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    // Accessor and mutator
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
     public void displayInfo() {
         System.out.println("Color: " + super.getColor());
         System.out.println("Filled: " + super.isFilled());
         System.out.println("radius: " + radius);

     }
}

 class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(String color, boolean filled, double length, double width) {
        super(color, filled);
        this.length = length;
        this.width = width;
    }

    // Accessor and mutator
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }

    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

 class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(String color, boolean filled, double side1, double side2, double side3) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Accessor and mutator
    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double calculateArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
}

 class Square extends Rectangle {
    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }
}


class Pentagon extends Shape {
    private double side;

    public Pentagon(String color, boolean filled, double side) {
        super(color, filled);
        this.side = side;
    }

    // Accessor and mutator
    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double calculateArea() {
        return (1.0 / 4.0) * Math.sqrt(5.0 * (5.0 + 2.0 * Math.sqrt(5.0))) * side * side;
    }

    public double calculatePerimeter() {
        return 5.0 * side;
    }
}


 class House extends Shape {
    private Square base;
    private Triangle roof;

    public House(String color, boolean filled, double side) {
        super(color, filled);
        this.base = new Square(color, filled, side);
        this.roof = new Triangle(color, filled, side, side, side);
    }

    // Accessor methods
    public Square getBase() {
        return base;
    }

    public Triangle getRoof() {
        return roof;
    }

    public double calculateArea() {
        return base.calculateArea() + roof.calculateArea();
    }

    public double calculatePerimeter() {
        return base.calculatePerimeter() + roof.calculatePerimeter();
    }

    public void displayInfo() {
        System.out.println("House Information:");
        System.out.println("Base:");
        base.displayInfo();
        System.out.println("Roof:");
        roof.displayInfo();
    }
}