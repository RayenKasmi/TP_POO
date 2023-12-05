class MallardDuck extends Duck implements Quackable,Flyable
{
    Quackable q;
    Flyable f;
    MallardDuck(Quackable q,Flyable f)
    {
        this.f=f;
        this.q=q;
    }
    public void display()
    {
        System.out.println("I'm a Mallar Duck");
    }
    @Override
    public void quack(){
        //System.out.println("Mallard Duck is quaking");
        q.quack();
    }
    @Override
    public void fly() {
        //System.out.println("Mallard Duck is flying");
        f.fly();
    }
}
