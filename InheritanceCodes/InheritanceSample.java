package InheritanceCodes;
class shape {
    public int numberofSides = 4;

    public void displayparent() {
        System.out.println("this is a shape class");
    }
}

class circle22 extends shape {
    int numberofSides = 5;

    public void display() {
        System.out.println("this is a circle class");
    }
}

public class InheritanceSample {
    public static void main(String[] args) {
        circle22 c1 = new circle22();
        c1.displayparent();
        c1.display();

    }
}