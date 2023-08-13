package abstractPracticePrograms;
// Abstract class Shape
abstract class Shape {
  public abstract double area();
  public abstract double perimeter();
}

// Interface for three-dimensional shapes
interface ThreeDimensionalShape {
  double volume();
  double surfaceArea();
}

// Class Circle extends Shape
class Circle extends Shape {
  private double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  @Override
  public double area() {
    return Math.PI * radius * radius;
  }

  @Override
  public double perimeter() {
    return 2 * Math.PI * radius;
  }
}

// Class Square extends Shape
class Square extends Shape {
  private double sideLength;

  public Square(double sideLength) {
    this.sideLength = sideLength;
  }

  @Override
  public double area() {
    return sideLength * sideLength;
  }

  @Override
  public double perimeter() {
    return 4 * sideLength;
  }
}

// Class Triangle extends Shape
class Triangle extends Shape {
  private double a, b, c; // sides

  public Triangle(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  @Override
  public double area() {
    double s = perimeter() / 2;
    return Math.sqrt(s * (s - a) * (s - b) * (s - c));
  }

  @Override
  public double perimeter() {
    return a + b + c;
  }
}

// Class Sphere extends Shape and implements ThreeDimensionalShape
class Sphere extends Shape implements ThreeDimensionalShape {
  private double radius;

  public Sphere(double radius) {
    this.radius = radius;
  }

  @Override
  public double area() {
    return 4 * Math.PI * radius * radius;
  }

  @Override
  public double surfaceArea() {
    return area();
  }

  @Override
  public double volume() {
    return (4.0 / 3) * Math.PI * Math.pow(radius, 3);
  }

  @Override
  public double perimeter() {
    return 0; // Not applicable for 3D shape
  }
}

// Class Cube extends Shape and implements ThreeDimensionalShape
class Cube extends Shape implements ThreeDimensionalShape {
  private double sideLength;

  public Cube(double sideLength) {
    this.sideLength = sideLength;
  }

  @Override
  public double area() {
    return 6 * sideLength * sideLength;
  }

  @Override
  public double surfaceArea() {
    return area();
  }

  @Override
  public double volume() {
    return Math.pow(sideLength, 3);
  }

  @Override
  public double perimeter() {
    return 0; // Not applicable for 3D shape
  }
}

// Example usage
public class AbstractExample {
  public static void main(String[] args) {
    // Circle
    Shape circle = new Circle(5);
    System.out.println("Circle Area: " + String.format("%.2f", circle.area()));
    System.out.println("Circle Perimeter: " + String.format("%.2f", circle.perimeter()));

    // Square
    Shape square = new Square(4);
    System.out.println("Square Area: " + String.format("%.2f", square.area()));
    System.out.println("Square Perimeter: " + String.format("%.2f", square.perimeter()));

    // Triangle
    Shape triangle = new Triangle(3, 4, 5);
    System.out.println("Triangle Area: " + String.format("%.2f", triangle.area()));
    System.out.println("Triangle Perimeter: " + String.format("%.2f", triangle.perimeter()));

    // Sphere
    Sphere sphere = new Sphere(3);
    System.out.println("Sphere Surface Area: " + String.format("%.2f", sphere.surfaceArea()));
    System.out.println("Sphere Volume: " + String.format("%.2f", sphere.volume()));

    // Cube
    Cube cube = new Cube(2);
    System.out.println("Cube Surface Area: " + String.format("%.2f", cube.surfaceArea()));
    System.out.println("Cube Volume: " + String.format("%.2f", cube.volume()));
}

}
