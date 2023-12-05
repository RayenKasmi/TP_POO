
public class Main {
    public static void main(String[] args) {
        System.out.println("Creating a stack with a size of 5");
        CustomStack myStack = new CustomStack(5);

        System.out.println("Adding elements to the stack....");
        myStack.AddElement(20);
        myStack.AddElement(30);
        myStack.AddElement(74);
        myStack.AddElement(85);
        myStack.AddElement(93);

        System.out.println("\nInitial Stack:");
        myStack.affiche();
        System.out.println();

        System.out.println("\nTrying to add an element to a full stack");
        myStack.AddElement(6);

        System.out.println("\nRemoving an element from the stack");
        myStack.RemoveElement();

        System.out.println("\nStack after removing an element:");
        myStack.affiche();
        System.out.println();

        System.out.println("\nLast element in the stack: " + myStack.LastInStack());

        System.out.println("Removing all elements from the stack");
        myStack.RemoveElement();
        myStack.RemoveElement();
        myStack.RemoveElement();
        myStack.RemoveElement();


        System.out.println("\nTrying to remove an element from an empty stack");
        myStack.RemoveElement();

        System.out.println("\nFinal Empty Stack:");
        myStack.affiche();
    }
}
