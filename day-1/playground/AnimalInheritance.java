public class AnimalInheritance {
    public static void main(String[] args) {

        Animal animal = new Animal();
        animal.eat();



    }
}

class Animal {
    String name;
    public void eat(){
        System.out.println("Animal eats");
    }
}

class Dog extends Animal{

    public void eat(){
        System.out.println("Animal eats");
    }
    void bark(){
        System.out.println("Dog barks");
    }
}



