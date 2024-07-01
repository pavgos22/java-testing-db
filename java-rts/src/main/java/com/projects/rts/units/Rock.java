package com.projects.rts.units;

public class Rock implements Unit {

    @Override
    public Integer beats(Unit unit) {
        if(unit instanceof Paper)
            return -1;
        else if(unit instanceof Scissors)
            return 1;
        else return 0;
    }
}
