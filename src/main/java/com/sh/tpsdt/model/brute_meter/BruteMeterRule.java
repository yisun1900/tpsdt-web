package com.sh.tpsdt.model.brute_meter;

import com.sh.tpsdt.model.CommonRule;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BruteMeterRule extends CommonRule {

    public BruteMeterRule(String rulePattern, Double totalSpace, String desc) {
        this.rulePattern = rulePattern;
        this.totalSpace = totalSpace;
        this.desc = desc;
        this.evaluatePasswordLevel();
    }

    public BruteMeterRule(Integer length, String rulePattern, Double totalSpace, Integer order, String desc) {
        this.desc = desc;
        this.order = order;
        this.length = length;
        this.rulePattern = rulePattern;
        this.totalSpace = totalSpace;
        this.evaluatePasswordLevel();
    }
}
