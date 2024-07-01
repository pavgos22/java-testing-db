package com.projects.rts.units;

public class Scissors implements Unit {

    @Override
    public Integer beats(Unit unit) {
        if(unit instanceof Rock)
            return -1;
        else if(unit instanceof Paper)
            return 1;
        else return 0;
    }
}
