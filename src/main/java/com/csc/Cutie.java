package com.csc;

// Cutie interface
public interface Cutie {
    public String description();
    public Integer cutenessRating();
}

// Example implementations of Cutie
class Puppy implements Cutie {
    public String description() {
        return "A little puppy with big, sad eyes";
    }

    public Integer cutenessRating() {
        return 11; // 11/10 cuteness
    }
}

class Kitty implements Cutie {
    public String description() {
        return "A fluffy kitty with soft fur";
    }

    public Integer cutenessRating() {
        return 10; // 10/10 cuteness
    }
}

class PygmyMarmoset implements Cutie {
    public String description() {
        return "A tiny monkey with a curious expression";
    }

    public Integer cutenessRating() {
        return 9; // 9/10 cuteness
    }
}

