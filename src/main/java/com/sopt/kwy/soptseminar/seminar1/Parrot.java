package com.sopt.kwy.soptseminar.seminar1;

public class Parrot extends Bird implements Flyable {
    public Parrot(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Parrot() {
        this("앵무새", 1);
    }

    @Override
    public void twit() {
        System.out.println("짹짹");
    }

    // 오버로딩
    public void twit(String sound) {
        System.out.println(sound);
    }

    @Override
    public void fly() {
        System.out.println("파닥 파닥");
    }
}
