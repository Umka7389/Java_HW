package ru.geekbrains.HW.Java_HW;

public class Dog extends Animal {
    private int maxRunDistance = 500;
    private int maxSwimDistance = 10;
    private float maxJumpHeight = 0.5f;

    Dog (){}

    Dog (int maxRunDistance, int maxSwimDistance, float maxJumpHeight){
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    protected void run (int distance){
        if (distance <= maxRunDistance) {
            System.out.println("Собака пробежала - " + distance + " м!");
        } else System.out.println("Собака не добежала!");
    }
    @Override
    protected void swim (int distance){
        if (distance <= maxSwimDistance) {
            System.out.println("Собака проплыла - " + distance + " м!");
        } else System.out.println("Собака не доплыла!");
    }
    @Override
    protected void jump (float height){
        if (height <= maxJumpHeight) {
            System.out.println("Собака прыгнула на - " + height + " м!");
        } else System.out.println("Собака не перепрыгнула!");
    }

}
