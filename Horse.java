package ru.geekbrains.HW.Java_HW;

public class Horse extends Animal {
    private int maxRunDistance = 1500;
    private int maxSwimDistance = 100;
    private float maxJumpHeight = 3f;

    Horse (){}

    Horse (int maxRunDistance, int maxSwimDistance, float maxJumpHeight){
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    protected void run (int distance){
        if (distance <= maxRunDistance) {
            System.out.println("Лошадь пробежала - " + distance + " м!");
        } else System.out.println("Лошадь не добежала!");
    }
    @Override
    protected void swim (int distance){
        if (distance <= maxSwimDistance) {
            System.out.println("Лошадь проплыла - " + distance + " м!");
        } else System.out.println("Лошадь не доплыла!");
    }
    @Override
    protected void jump (float height){
        if (height <= maxJumpHeight) {
            System.out.println("Лошадь прыгнула на - " + height + " м!");
        } else System.out.println("Лошадь не перепрыгнула!");
    }

}
