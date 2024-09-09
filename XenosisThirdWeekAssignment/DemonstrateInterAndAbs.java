package XenosisThirdWeekAssignment;

abstract class Animal {
    String name;
    public Animal(String name) {
        this.name = name;
    }

    public abstract void eat();
}

interface Sound {
    void makeSound();
}

class Dog extends Animal implements Sound {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(name + " eats bones.");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof Woof!");
    }
}

class Cat extends Animal implements Sound {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(name + " eats fish.");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " meows: Meow Meow!");
    }
}

public class DemonstrateInterAndAbs {
    public static void main(String[] args) {

        Dog dog = new Dog("Buddy");
        Cat cat = new Cat("Whiskers");

        dog.eat();
        dog.makeSound();

        cat.eat();
        cat.makeSound();
    }
}
