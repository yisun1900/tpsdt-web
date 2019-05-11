package com.sh.tpsdt.algorithm;

import com.sh.tpsdt.constants.CommandConstants;
import com.sh.tpsdt.constants.PasswordLevel;
import com.sh.tpsdt.model.heat_structure.HeatStructureRule;

import java.util.Optional;

public class HeatAndStructureAlgorithm extends AbstractRuleAlgorithm<HeatStructureRule>
        implements CommandAlgorithm, EstimateAlgorithm {

    @Override
    protected HeatStructureRule hitTheTarget(String command) {
        Optional<HeatStructureRule> optional = CommandConstants.HEAT_STRUCTURE_RULES.stream().filter(heatStructureRule ->
                command.matches(heatStructureRule.getRulePattern())).findFirst();
        return optional.isPresent() ? optional.get() : new HeatStructureRule(command.length(), "*", 0d, 0, "No pattern match!");
    }

    @Override
    public String validateCommand(String command) {
        HeatStructureRule result = this.hitTheTarget(command);
        return CommandConstants.COMMAND_HEAT_STRUCTURE_TITLE + result.getPasswordLevel().name() + "," +
                CommandConstants.COMMAND_SYNTACTIC_CONTENT + result.getDesc();
    }

    @Override
    public PasswordLevel estimatePasswordLevel(String command) {
        return this.hitTheTarget(command).getPasswordLevel();
    }
}
