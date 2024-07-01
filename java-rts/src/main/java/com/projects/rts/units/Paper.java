package com.projects.rts.units;

public class Paper implements Unit {

    @Override
    public Integer beats(Unit unit) {
        if(unit instanceof Scissors)
            return -1;
        else if(unit instanceof Rock)
            return 1;
        else return 0;
    }
}
