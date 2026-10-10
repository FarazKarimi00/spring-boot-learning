package com.CircularDependency.Simple;

public class A {

    private B b;

    public A() {
        System.out.println("Constructor of class A called");
        this.b = new B();
    }

}
