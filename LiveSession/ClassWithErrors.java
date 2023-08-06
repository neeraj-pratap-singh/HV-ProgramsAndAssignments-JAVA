
package LiveSession;
// public ClassWithErrors {
//     protected ClassWithError() {
//         System.out.println("This is the constructor.");
//     }
//     private void privateMethod() {
//         System.out.println("This is a private method.");
//     }
//     public int publicVariable = 10;
//     public static void main(String[] args) {
//         ClassWithErrors obj = new ClassWithErrors(); 
//         obj.privateMethod(); 
//     }
// }
public class ClassWithErrors {
    protected ClassWithErrors() {
        System.out.println("This is the constructor.");
    }

    private void privateMethod() {
        System.out.println("This is a private method.");
    }

    private int publicVariable = 10;

    public int getPublicVariable() {
        return publicVariable;
    }

    public static void main(String[] args) {
        ClassWithErrors obj = new ClassWithErrors(); 
        obj.privateMethod(); 
    }
}

