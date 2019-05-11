package com.sh.tpsdt.constants;

public enum PasswordLevel {
    SUPER_HIGH(10),
    HIGH(8),
    MEDIUM(6),
    LOW(3),
    SUPER_LOW(1),
    UNKNOW(0);

    public int score;

    public int getScore(){
        return this.score;
    }

    PasswordLevel(int score){
        this.score = score;
    }
}
