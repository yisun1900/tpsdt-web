package com.sh.tpsdt.algorithm;

import com.sh.tpsdt.constants.CommandConstants;
import org.springframework.util.StringUtils;

/**
 * @program: tpsdt
 * @description:
 * @author:
 * @create: 2019-03-14 13:52
 **/
public class LengthAlgorithm implements CommandAlgorithm {

    @Override
    public String validateCommand(String command) {
        return CommandConstants.COMMAND_LENGTH_TITLE + (StringUtils.isEmpty(command) ? "0" : command.length());
    }
}
