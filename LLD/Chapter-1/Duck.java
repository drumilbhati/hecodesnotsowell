/* 
-> This implementation is bad
-> Tightly coupled design is bad
-> A rubber duck is a duck, but it cannot fly
-> It squeaks rather than quacking too

public class Duck {
    public void swim() {}

    public void display() {}

    public void quack() {}

    public void fly() {}
}

class RubberDuck extends Duck {
    @Override
    public void swim() {
        System.out.println("Swiming in bathtub");
    }

    @Override
    public void display() {
        System.out.println("Yellow duck");
    }

    @Override
    public void quack() {
        // Cannot quack
    }

    @Override
    public void fly() {
        // Cannot fly
    }
}
*/


/*
-> Better design:
    = Create interfaces for each behaviour that is bound to vary
    = Such behaviours can be dynamically determined using runtime
    = Use behaviours in the superclass to attach a specific implementation of the behaviour
*/
interface FlyBehaviour {
    public void fly();
}

interface  QuackBehaviour {
    public void quack();    
}

class FlyWithWings implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("Flying with wings");
    }
}

class FlyNoWay implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("This duck cannot fly");
    }
}

class Quack implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Quack quack!");
    }
}

class Squeak implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Squeak squeak!");
    }
}

public class Duck {

    FlyBehaviour flyBehaviour;
    QuackBehaviour quackBehaviour;

    public void swim() {}

    public void display() {}

    public void performFly() {
        flyBehaviour.fly();
    }

    public void performQuack() {
        quackBehaviour.quack();
    }

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }

    public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }
}
