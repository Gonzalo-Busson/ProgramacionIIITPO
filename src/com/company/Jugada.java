package com.company;

public class Jugada {
    Movimiento mov;
    int pos;

    public Jugada() {
    }

    public Movimiento getMov() {
        return this.mov;
    }

    public void setMov(Movimiento m) {
        this.mov = m;
    }

    public int getPos() {
        return this.pos;
    }

    public void setPos(int p) {
        this.pos = p;
    }
}
