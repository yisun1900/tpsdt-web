package com.sh.tpsdt.algorithm;

import com.sh.tpsdt.constants.CommandConstants;
import com.sh.tpsdt.constants.PasswordLevel;

/**
 * @program: tpsdt
 * @description:
 * @author:
 * @create: 2019-03-14 13:53
 **/
public class PersonPreferAlgorithm implements CommandAlgorithm ,EstimateAlgorithm{

    @Override
    public String validateCommand(String command) {
        return CommandConstants.COMMAND_PERSON_PREFER_TITLE + "";
    }

    @Override
    public PasswordLevel estimatePasswordLevel(String command) {
        return PasswordLevel.LOW;
    }
}
