package com.sh.tpsdt.algorithm;

import com.sh.tpsdt.constants.CommandConstants;
import com.sh.tpsdt.constants.PasswordLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
public class RecommendAlgorithm implements CommandAlgorithm, EstimateAlgorithm {

    private PointAlgorithm pointAlgorithm;

    public RecommendAlgorithm(PointAlgorithm pointAlgorithm,
                              BruteMeterAlgorithm bruteMeterAlgorithm,
                              HeatAndStructureAlgorithm heatAndStructureAlgorithm) {
        this.pointAlgorithm = pointAlgorithm;
        this.pointAlgorithm.setBruteMeterAlgorithm(bruteMeterAlgorithm);
        this.pointAlgorithm.setHeatAndStructureAlgorithm(heatAndStructureAlgorithm);
    }

    public String trimBracket(String source) {
        return source.substring(1, source.length() - 1);
    }

    public int getSourceIndex(String[] source) {
        return RandomUtils.nextInt(0, source.length - 1);
    }

    public String recommendPassword() {
        String[] azLowList = trimBracket(CommandConstants.AZ_LOW).split("");
        String[] azHighList = trimBracket(CommandConstants.AZ_HIGH).split("");
        String[] azVowelList = trimBracket(CommandConstants.AZ_VOWEL).split("");
        String[] azUpperList = trimBracket(CommandConstants.AZ_UPPER).split("");
        String[] azLowerList = trimBracket(CommandConstants.AZ_LOWER).split("");
        String[] num09List = trimBracket(CommandConstants.NUM09).split("");
        String[] spHighList = trimBracket(CommandConstants.SP_HIGH).split("");
        String[] spLowList = trimBracket(CommandConstants.SP_LOW).split("");
        String azLowStr = azLowList[getSourceIndex(azLowList)];
        String azHighStr = azHighList[getSourceIndex(azHighList)];
        String azUpperStr = azUpperList[getSourceIndex(azUpperList)];
        String azLowerStr = azLowerList[getSourceIndex(azLowerList)];
        String azVowelStr = azVowelList[getSourceIndex(azVowelList)];
        String num09Str = num09List[getSourceIndex(num09List)];
        String spHighStr = spHighList[getSourceIndex(spHighList)];
        String spLowStr = spLowList[getSourceIndex(spLowList)];
        List<String> passwordList = Arrays.asList(azLowStr, azHighStr, azVowelStr +
                azUpperStr, azLowerStr, num09Str, spHighStr, spLowStr);
        Collections.shuffle(passwordList);
        return passwordList.stream().collect(Collectors.joining(""));
    }

    public String sortAllElement(String command) {
        return Stream.of(command.split("")).sorted().collect(Collectors.joining(""));
    }

    public String removeSameElement(String command) {
        return command.replaceAll("(.)\\1+", "$1");
    }

    public String reverseElement(String command) {
        List<String> wordList = Stream.of(command.split("")).collect(Collectors.toList());
        Collections.shuffle(wordList);
        String newWord = wordList.stream().collect(Collectors.joining());
        return newWord;
    }

    public String recommendPassword(String command) {
        String distinctWord = this.sortAllElement(command);
        String removeWord = this.removeSameElement(distinctWord);
        String rebalanceWord = this.rebalanceElement(removeWord);
        String reverseWord = this.reverseElement(rebalanceWord);
        String completionWord = this.completionCommand(reverseWord);
        return completionWord;
    }

    public String upgradeSafePhase(String command, PasswordLevel passwordLevel) {
        switch (passwordLevel) {
            case SUPER_LOW:
            case LOW:
                return recommendPassword();
            case MEDIUM:
                return this.recommendPassword(command);
            case HIGH:
            case SUPER_HIGH:
            default:
                return command;
        }
    }

    public String completionCommand(String command) {
        return command.length() < 8 ?
                command + recommendPassword().substring(0, 8 - command.length()) : command.substring(0, 8);
    }

    public String removeUnBalanceElement(int unbalanceNum, String command, String rule) {
        List<String> commandList = Stream.of(command.split("")).collect(Collectors.toList());
        List<String> newList = new ArrayList<>();
        for (int index = 0, size = commandList.size(); index < size; index++) {
            if (commandList.get(index).matches(rule) && unbalanceNum > 0) {
                unbalanceNum--;
            } else {
                newList.add(commandList.get(index));
            }
        }
        return newList.stream().collect(Collectors.joining(""));
    }

    public String rebalanceElement(String command) {
        Integer balanceNum = command.length() / 6 + 1;
        SyntacticAlgorithm syntacticAlgorithm = new SyntacticAlgorithm();
        syntacticAlgorithm.validateCommand(command);
        String newCommand = "";
        if (syntacticAlgorithm.getAZ_HIGH_NUM() > balanceNum) {
            newCommand = this.removeUnBalanceElement(syntacticAlgorithm.getAZ_HIGH_NUM() - balanceNum,
                    command, CommandConstants.AZ_HIGH);
        }
        if (syntacticAlgorithm.getAZ_LOW_NUM() > balanceNum) {
            newCommand = this.removeUnBalanceElement(syntacticAlgorithm.getAZ_LOW_NUM() - balanceNum,
                    command, CommandConstants.AZ_LOW);
        }
        if (syntacticAlgorithm.getAZ_VOWEL_NUM() > balanceNum) {
            newCommand = this.removeUnBalanceElement(syntacticAlgorithm.getAZ_VOWEL_NUM() - balanceNum,
                    command, CommandConstants.AZ_VOWEL);
        }
        if (syntacticAlgorithm.getAZ_NUM() > balanceNum) {
            newCommand = this.removeUnBalanceElement(syntacticAlgorithm.getAZ_NUM() - balanceNum,
                    command, CommandConstants.AZ);
        }
        if (syntacticAlgorithm.getNUM09() > balanceNum) {
            newCommand = this.removeUnBalanceElement(syntacticAlgorithm.getNUM09() - balanceNum,
                    command, CommandConstants.NUM09);
        }
        if (syntacticAlgorithm.getSP_NUM() > balanceNum) {
            newCommand = this.removeUnBalanceElement(syntacticAlgorithm.getSP_NUM() - balanceNum,
                    command, CommandConstants.SP);
        }
        return newCommand;
    }

    @Override
    public PasswordLevel estimatePasswordLevel(String command) {
        return this.pointAlgorithm.estimatePasswordLevel(command);
    }

    @Override
    public String validateCommand(String command) {
        PasswordLevel passwordLevel = this.estimatePasswordLevel(command);
        return CommandConstants.COMMAND_POINT_TITLE + passwordLevel.name() + "," +
                CommandConstants.COMMAND_RECOMMEND + this.upgradeSafePhase(command, passwordLevel);
    }
}
