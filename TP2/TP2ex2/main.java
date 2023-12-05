public class Main {
    public static void main(String[] args) {
        MallardQuack Mq=new  MallardQuack();
        MallardFly Mf=new MallardFly();
        RedQuack Rq=new RedQuack();
        RedFly Rf=new RedFly();
        RubberQuack Ruq=new RubberQuack();
      
        MallardDuck mallardDuck=new MallardDuck(Mq,Mf);
        RedHeadDuck redheadDuck=new RedHeadDuck(Rq,Rf);
        RubberDuck rubberDuck=new RubberDuck(Ruq);
        DecoyDuck decoyDuck=new DecoyDuck();

        mallardDuck.display();
        mallardDuck.quack();
        mallardDuck.fly();
        mallardDuck.swim();
        System.out.println("----------------------------------------------------------");
        redheadDuck.display();
        redheadDuck.quack();
        redheadDuck.fly();
        redheadDuck.swim();
        System.out.println("----------------------------------------------------------");
        rubberDuck.display();
        rubberDuck.quack();
        rubberDuck.swim();
        System.out.println("----------------------------------------------------------");
        decoyDuck.display();
        decoyDuck.swim();
    }
}
