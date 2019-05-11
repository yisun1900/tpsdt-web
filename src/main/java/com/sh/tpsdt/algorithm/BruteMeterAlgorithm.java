package com.sh.tpsdt.algorithm;

import com.sh.tpsdt.constants.CommandConstants;
import com.sh.tpsdt.constants.PasswordLevel;
import com.sh.tpsdt.model.brute_meter.BruteMeterRule;
import org.springframework.stereotype.Component;

import java.util.Optional;

public class BruteMeterAlgorithm extends AbstractRuleAlgorithm implements CommandAlgorithm, EstimateAlgorithm {

    @Override
    public BruteMeterRule hitTheTarget(String command) {
        Optional<BruteMeterRule> optional = CommandConstants.BRUTE_METER_RULES.stream().filter(bruteMeterRule ->
                command.matches(bruteMeterRule.getRulePattern())).findFirst();
        return optional.isPresent() ? optional.get() : new BruteMeterRule(command.length(), "*", 0d, 0,"No pattern match!");
    }

    @Override
    public String validateCommand(String command) {
        BruteMeterRule result = this.hitTheTarget(command);
        return CommandConstants.COMMAND_BRUTE_METER + result.getPasswordLevel().name() + "," +
                CommandConstants.COMMAND_SYNTACTIC_CONTENT + result.getDesc();
    }

    @Override
    public PasswordLevel estimatePasswordLevel(String command) {
        return this.hitTheTarget(command).getPasswordLevel();
    }
}
