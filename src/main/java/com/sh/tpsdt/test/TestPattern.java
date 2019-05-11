package com.sh.tpsdt.test;

import com.sh.tpsdt.constants.CommandConstants;

public class TestPattern {

    public static void main(String args[]) {
        System.out.println("19:00".matches(CommandConstants.TIMER_24));
        System.out.println("19:00:00".matches(CommandConstants.NUM09 + "{1,8}"));
    }
}
