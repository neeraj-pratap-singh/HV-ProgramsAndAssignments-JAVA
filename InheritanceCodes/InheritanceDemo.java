package InheritanceCodes;

// Single Inheritance
class Parent {
    void showParent() {
        System.out.println("This is the parent class.");
    }
}

class Child extends Parent {
    void showChild() {
        System.out.println("This is the child class.");
    }
}

// Multiple Inheritance through Interfaces
interface Parent1 {
    void showParent1();
}

interface Parent2 {
    void showParent2();
}

class ChildMultiple implements Parent1, Parent2 {
    public void showParent1() {
        System.out.println("This is Parent1 interface method.");
    }

    public void showParent2() {
        System.out.println("This is Parent2 interface method.");
    }
}

// Multilevel Inheritance
class Grandparent {
    void showGrandparent() {
        System.out.println("This is the grandparent class.");
    }
}

class ParentMultilevel extends Grandparent { }

class ChildMultilevel extends ParentMultilevel {
    void showChildMultilevel() {
        System.out.println("This is multilevel inherited child class.");
    }
}

// Hierarchical Inheritance
class ParentHierarchical { }

class Child1Hierarchical extends ParentHierarchical {
    void showChild1() {
        System.out.println("This is the first child in hierarchical inheritance.");
    }
}

class Child2Hierarchical extends ParentHierarchical {
    void showChild2() {
        System.out.println("This is the second child in hierarchical inheritance.");
    }
}

// Main class to run the code
public class InheritanceDemo {
    public static void main(String[] args) {
        // Single Inheritance
        Child child = new Child();
        child.showParent();
        child.showChild();
        
        // Multiple Inheritance through Interfaces
        ChildMultiple childMultiple = new ChildMultiple();
        childMultiple.showParent1();
        childMultiple.showParent2();

        // Multilevel Inheritance
        ChildMultilevel childMultilevel = new ChildMultilevel();
        childMultilevel.showGrandparent();
        childMultilevel.showChildMultilevel();

        // Hierarchical Inheritance
        Child1Hierarchical child1Hierarchical = new Child1Hierarchical();
        child1Hierarchical.showChild1();
        Child2Hierarchical child2Hierarchical = new Child2Hierarchical();
        child2Hierarchical.showChild2();
    }
}
