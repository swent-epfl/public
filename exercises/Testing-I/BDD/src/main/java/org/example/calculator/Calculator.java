package org.example.calculator;

/**
 * A calculator class that has a "memory" state.
 */
public class Calculator {
    private int state;

    public Calculator(int initState) {
        this.state = initState;
    }

    public int add(int a) {
        state += a;
        return state;
    }
    public int subtract(int a) {
        state -= a;
        return state;
    }

    public int getState() {
        return state;
    }
}

