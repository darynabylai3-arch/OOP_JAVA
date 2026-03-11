package lab2.task1;
public abstract class Shape3D {
    public abstract double volume();
    public abstract double surfaceArea();

    @Override
    public String toString() {
        return getClass().getSimpleName() +
               " [Volume: " + String.format("%.2f", volume()) +
               ", Surface Area: " + String.format("%.2f", surfaceArea()) + "]";
    }
}

class Cylinder extends Shape3D {
    private double radius, height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getRadius() { return radius; }
    public double getHeight() { return height; }

    @Override
    public double volume() {
        return Math.PI * radius * radius * height;
    }

    @Override
    public double surfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }
}

class Sphere extends Shape3D {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double getRadius() { return radius; }

    @Override
    public double volume() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }

    @Override
    public double surfaceArea() {
        return 4 * Math.PI * radius * radius;
    }
}

class Cube extends Shape3D {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    public double getSide() { return side; }

    @Override
    public double volume() {
        return side * side * side;
    }

    @Override
    public double surfaceArea() {
        return 6 * side * side;
    }
}

class TestShape3D {
    public static void main(String[] args) {
        Shape3D[] shapes = {
            new Cylinder(5, 10),
            new Sphere(7),
            new Cube(4)
        };

        for (Shape3D shape : shapes) {
            System.out.println(shape);
        }
    }
}
