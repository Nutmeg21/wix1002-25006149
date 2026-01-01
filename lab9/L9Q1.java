import java.util.*;

public class L9Q1 {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        Square sq = new Square();
        Circle circ = new Circle();

        rect.getLength();
        rect.compute();
        rect.display();

        sq.getLength();
        sq.compute();
        sq.display();

        circ.getDiameter();
        circ.compute();
        circ.display();
    }
}

class Shape {
    String name;
    double perimeter;
    double area;
    Scanner sc = new Scanner(System.in);

    public void setPerimeter(double shapePerimeter)
    {
        perimeter = shapePerimeter;
    }

    public void setArea(double shapeArea)
    {
        area = shapeArea;
    }

    public double getPerimeter()
    {
        return perimeter;
    }

    public double getArea()
    {
        return area;
    }

    public void display()
    {
        System.out.println("Shape: " + name);
        System.out.printf("Perimeter: %.2f\n", perimeter);
        System.out.printf("Area: %.2f\n", area);
    }
}

class Rectangle extends Shape {
    double length;
    double width;

    public Rectangle()
    {
        name = "Rectangle";
    }

    public void getLength()
    {
        System.out.print("Enter length: ");
        length = sc.nextDouble();
        System.out.print("Enter width: ");
        width = sc.nextDouble();
    }

    public void compute()
    {
        perimeter = 2 * length + 2 * width;
        setPerimeter(perimeter);
        area = length * width;
        setArea(area);
    }
}

class Square extends Shape {
    double length;

    public Square()
    {
        name = "Square";
    }

    public void getLength()
    {
        System.out.print("Enter length: ");
        length = sc.nextDouble();
    }

    public void compute()
    {
        perimeter = 4 * length;
        setPerimeter(perimeter);
        area = length * length;
        setArea(area);
    }
}

class Circle extends Shape {
    double diameter;

    public Circle()
    {
        name = "Circle";
    }

    public void getDiameter()
    {
        System.out.print("Enter diameter: ");
        diameter = sc.nextDouble();
    }

    public void compute()
    {
        perimeter = Math.PI * diameter;
        setPerimeter(perimeter);
        area = Math.PI * Math.pow((diameter / 2), 2);
        setArea(area);
    }
}
