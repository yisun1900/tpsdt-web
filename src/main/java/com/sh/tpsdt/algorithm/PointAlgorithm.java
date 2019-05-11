package com.sh.tpsdt.algorithm;

import com.sh.tpsdt.constants.CommandConstants;
import com.sh.tpsdt.constants.PasswordLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: tpsdt
 * @description:
 * @author:
 * @create: 2019-03-14 14:47
 **/
@Getter
@Setter
public class PointAlgorithm implements CommandAlgorithm, EstimateAlgorithm {

    private BruteMeterAlgorithm bruteMeterAlgorithm;

    private HeatAndStructureAlgorithm heatAndStructureAlgorithm;

    public PointAlgorithm() {
    }

    @Override
    public String validateCommand(String command) {
        return CommandConstants.COMMAND_POINT_TITLE + this.estimatePasswordLevel(command).name();
    }

    @Override
    public PasswordLevel estimatePasswordLevel(String command) {
        PasswordLevel bruteMeterLevel = bruteMeterAlgorithm.estimatePasswordLevel(command);
        PasswordLevel heatAndStructureLevel = heatAndStructureAlgorithm.estimatePasswordLevel(command);
        PasswordLevel estimatePasswordLevel = PasswordLevel.SUPER_LOW;
        int totalScore = bruteMeterLevel.getScore() + heatAndStructureLevel.getScore();
        if (totalScore <= 6) {
            estimatePasswordLevel = PasswordLevel.SUPER_LOW;
        } else if (totalScore > 6 && totalScore <= 10) {
            estimatePasswordLevel = PasswordLevel.LOW;
        } else if (totalScore > 10 && totalScore <= 12) {
            estimatePasswordLevel = PasswordLevel.MEDIUM;
        } else if (totalScore > 12 && totalScore <= 16) {
            estimatePasswordLevel = PasswordLevel.HIGH;
        } else if (totalScore > 16) {
            estimatePasswordLevel = PasswordLevel.SUPER_HIGH;
        }
        return estimatePasswordLevel;
    }
}
