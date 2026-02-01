public class RubberDuck extends Duck {
    public RubberDuck() {
        flyBehaviour = new FlyNoWay();
        quackBehaviour = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("Swiming in bathtub");
    }

    public static void main(String[] args) {
        Duck rubber = new RubberDuck();
        rubber.performFly();
        rubber.performQuack();
    }
}
