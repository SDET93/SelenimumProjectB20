package com.cybertek.tests.practice;

public class Animal {

        public static void something() {
            System.out.println("animal.something");
        }

        public void eat() {
            System.out.println("animal.eat");
        }

        public Animal() {
            // This will always call Animal.something(), since it can't be overriden, because it is static.
            something();
            // This will call the eat() defined in overriding classes.
            eat();
        }

    }


    class Dog extends Animal {

        public static void something() {
            // This method merely hides Animal.something(), making it uncallable, but does not override it, or alter calls to it in any way.
            System.out.println("dog.something");
        }

        public void eat() {
            // This method overrides eat(), and will affect calls to eat()
            System.out.println("dog.eat");
        }

        public Dog() {
            super();
        }

        public static void main(String[] args) {
            new Dog();
        }

    }

