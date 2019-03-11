package chapter3.ex10;

interface Food {
	
}

abstract class Animal {
	abstract void eat(Food food);
}

class Feeder {
	void feed(Animal animal, Food food) {
		
	}
}

class Bone implements Food {
	
}

class Fish extends Animal implements Food {
	@Override
	void eat(Food food) {
		
	}
}

class Cat extends Animal {
	@Override
	void eat(Food food) {
		
	}
}

class Dog extends Animal {
	@Override
	void eat(Food food) {
		
	}
}

public class Test {
	public static void main(String[] args) {
		Feeder feeder = new Feeder();
		Animal animal = new Cat();
		Food food = new Fish();
		feeder.feed(animal, food);
		animal = new Dog();
		food = new Bone();
		feeder.feed(animal, food);
	}
}
