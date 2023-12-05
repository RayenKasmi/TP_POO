public class CustomArrayList
{
    protected int[] arrayliste;
    protected int size;
    public CustomArrayList()
    {
        this.arrayliste=new int[10];
        this.size=0;
    }
    public CustomArrayList(int initialSize)
    {
        this.arrayliste=new int[initialSize];
        this.size=0;
    }

    public void add(int x) {
        if (this.arrayliste.length==this.size)
        {
            System.out.println("expanding the array");
            int[] a = new int[this.size*2];
            for (int i = 0; i < this.size; i++)
            {
                a[i] = arrayliste[i];
            }
            a[this.size] = x;
            this.arrayliste = a;
        }
        else
        {
            arrayliste[size]=x;
        }
        this.size++;
    }

    public void add(int p,int x)
    {

        int [] a;
        if(arrayliste.length==size) {
            System.out.println("expanding array");
            a = new int[this.size * 2];
        }
        else
        {
            a = new int[arrayliste.length];
        }
        for (int i = 0; i < p; i++)
        {
            a[i] = arrayliste[i];
        }
        a[p] = x;
        for (int i = p + 1; i < this.size + 1; i++)
        {
            a[i] = arrayliste[i-1];
        }
        this.size++;
        this.arrayliste = a;
    }

    public int get(int p) {
        return(arrayliste[p]);
    }

    public int getSize() {
        return(this.size);
    }

    public boolean isEmpty() {
        return this.getSize() == 0;
    }

    public boolean isIn(int x) {
        for(int i =0;i<this.size;i++)
            if (arrayliste[i] == x) {
                return (true);
            }
        return(false);
    }

    public int find(int x) {
        for(int i =0;i<this.size;i++)
            if (arrayliste[i] == x) {
                return (i);
            }
        return(-1);
    }

    public void remove(int x) {
        if(this.find(x) != -1) {
            if (this.find(x) != (size - 1)) {
                for (int i = this.find(x); i < size - 1; i++) {
                    arrayliste[i] = arrayliste[i + 1];
                }
            }
            else {
                arrayliste[size - 1] = 0;
            }
            size--;
        }
        if(size==arrayliste.length/2){
            System.out.println("shrinking down array");
            int [] a;
            a = new int[arrayliste.length / 2];
            for (int i = 0; i < size; i++)
            {
                a[i] = arrayliste[i];
            }
            arrayliste = a;
        }
    }

    public void afficher() {
        for(int i= 0;i<size;i++)
        {
            System.out.print(arrayliste[i]+"|");
        }
        System.out.println();
    }
}

