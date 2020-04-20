package ru.geekbrains.HW.Java_HW;

public class Bird extends Animal{
    private int maxRunDistance = 5;
    private float maxJumpHeight = 0.2f;

    Bird (){}

    Bird (int maxRunDistance, float maxJumpHeight){
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    protected void run (int distance){
        if (distance <= maxRunDistance) {
            System.out.println("Птица пробежала - " + distance + " м!");
        } else System.out.println("Птица не добежала!");
    }
    @Override
    protected void swim (int distance){
            System.out.println("Птицы не плавают!");
    }
    @Override
    protected void jump (float height){
        if (height <= maxJumpHeight) {
            System.out.println("Птица прыгнула на - " + height + " м!");
        } else System.out.println("Птица не перепрыгнула!");
    }

}
