import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        CustomArrayList ar=new CustomArrayList(5);
        System.out.println("please fill out an array of size 5");
        for(int i =0;i<5;i++)
        {
            System.out.println("enter int : ");
            x =scanner.nextInt();
            ar.add(x);
        }
        ar.afficher();
        System.out.println("\nadding 10 at end of array");
        ar.add(10);
        ar.afficher();
        System.out.println("\nthe new allocated size is "+ar.arrayliste.length);
        System.out.println("\nadding 20 at index 4");
        ar.add(4,20);
        ar.afficher();
        System.out.println("\nadding 28 at index 7(last index)");
        ar.add(7,28);
        ar.afficher();
        System.out.println("\nremoving 10");
        ar.remove(10);
        ar.afficher();
        System.out.println("\nremoving 28");
        ar.remove(28);
        ar.afficher();
        System.out.println("\nremoving 20");
        ar.remove(20);
        ar.afficher();
        System.out.println("\nthe new allocated size is "+ar.arrayliste.length);
        System.out.println("\nthe size of the array is: "+ar.getSize());
        System.out.println("\nsearching for 20 in array");
        System.out.println("index:" +ar.find(20));
        System.out.println("\nsearching for "+ x +" in array");
        System.out.println("index:" +ar.find(x));
    }
}
