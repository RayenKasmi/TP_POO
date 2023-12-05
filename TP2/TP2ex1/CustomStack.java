
class Node
{
    int val;
    Node next;
    Node(int val)
    {
        this.val=val;
        this.next=null;
    }
}

public class CustomStack {
    private int size;
    Node head;
    CustomStack(int size){
        this.size=size;
        this.head=null;
    }
    public void AddElement (int x)
    {
        if(this.StackIsFull())
        {
            System.out.println("OVERFLOW!!!");
        }
        else{
            Node node=new Node(x);
            node.next=head;
            head=node;
        }
    }
    public void RemoveElement()
    {
        if(this.StackIsEmpty())
        {
            System.out.println("ERROR STACK IS EMPTY");
        }
        else {
            head=head.next;
        }
    }
    public int LastInStack()
    {
        if(this.StackIsEmpty())
            throw new RuntimeException("stack empty");
        else {
            return (head.val);
        }
    }
    public boolean StackIsEmpty()
    {
        return(head==null);
    }
    public boolean StackIsFull()
    {
        Node aux=head;
        int counter=0;
        while(aux!=null)
        {
            aux=aux.next;
            counter++;
        }
        return(counter==size);
    }
    public void affiche()
    {
        if(!this.StackIsEmpty())
        {
            Node aux=head;
            while(aux!=null)
            {
                System.out.print(aux.val +"|");
                aux=aux.next;
            }
        }
    }
}
