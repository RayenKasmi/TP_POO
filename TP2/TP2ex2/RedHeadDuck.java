class RedHeadDuck extends Duck implements Quackable,Flyable
{
    Quackable q;
    Flyable f;
    RedHeadDuck(Quackable q,Flyable f)
    {
        this.f=f;
        this.q=q;
    }
    public void display()
    {
        System.out.println("I'm a RedheadDuck");
    }
    @Override
    public void quack(){
        //System.out.println("Redhead Duck is quaking");
        q.quack();
    }
    @Override
    public void fly() {
        //System.out.println("Redhead Duck is flying");
        f.fly();
    }
}