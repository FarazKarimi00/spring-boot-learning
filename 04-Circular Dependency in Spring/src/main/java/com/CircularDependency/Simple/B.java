package com.CircularDependency.Simple;

public class B {
    private A a;

    public B() {
        System.out.println("Constructor of class B is called");
        this.a = new A();
    }
}
