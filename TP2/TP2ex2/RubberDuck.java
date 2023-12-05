class RubberDuck extends Duck implements Quackable
{
    Quackable q;
    RubberDuck(Quackable q)
    {
        this.q=q;
    }
    public void display()
    {
        System.out.println("I'm a RubberDuck");
    }
    @Override
    public void quack(){
        //System.out.println("Rubber Duck is quaking");
        q.quack();
    }
}