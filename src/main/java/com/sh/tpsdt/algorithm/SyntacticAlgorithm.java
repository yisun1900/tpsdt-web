package com.sh.tpsdt.algorithm;

import com.sh.tpsdt.constants.CommandConstants;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: tpsdt
 * @description:
 * @author:
 * @create: 2019-03-14 13:54
 **/
@Getter
@Setter
public class SyntacticAlgorithm implements CommandAlgorithm {

    private int AZ_VOWEL_NUM = 0;
    private int AZ_HIGH_NUM = 0;
    private int AZ_LOW_NUM = 0;
    private int AZ_NUM = 0;
    private int NUM09 = 0;
    private int SP_NUM = 0;

    @Override
    public String validateCommand(String command) {
        String[] elementList = command.split("");
        for (String element : elementList) {
            if (element.matches(CommandConstants.AZ_VOWEL)) {
                AZ_VOWEL_NUM++;
            } else if (element.matches(CommandConstants.AZ_HIGH)) {
                AZ_HIGH_NUM++;
            } else if (element.matches(CommandConstants.AZ_LOW)) {
                AZ_LOW_NUM++;
            } else if (element.matches(CommandConstants.AZ)) {
                AZ_NUM++;
            } else if (element.matches(CommandConstants.NUM09)) {
                NUM09++;
            } else if (element.matches(CommandConstants.SP)) {
                SP_NUM++;
            }
        }
        return CommandConstants.COMMAND_SYNTACTIC_TITLE +
                CommandConstants.AZ_VOWEL_TITLE + ":" + AZ_VOWEL_NUM + "个, " +
                CommandConstants.AZ_HIGH_TITLE + ":" + AZ_HIGH_NUM + "个, " +
                CommandConstants.AZ_LOW_TITLE + ":" + AZ_LOW_NUM + "个, " +
                CommandConstants.AZ_TITLE + ":" + AZ_NUM + "个, " +
                CommandConstants.NUM09_TITLE + ":" + NUM09 + "个, " +
                CommandConstants.SP_TITLE + ":" + SP_NUM + "个";
    }
}
