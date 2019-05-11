package com.sh.tpsdt.model.heat_structure;

import com.sh.tpsdt.model.CommonRule;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeatStructureRule extends CommonRule {

    public HeatStructureRule(String rulePattern, Double totalSpace, String desc) {
        this.rulePattern = rulePattern;
        this.totalSpace = totalSpace;
        this.desc = desc;
        this.evaluatePasswordLevel();
    }

    public HeatStructureRule(Integer length, String rulePattern, Double totalSpace, Integer order, String desc) {
        this.desc = desc;
        this.order = order;
        this.length = length;
        this.rulePattern = rulePattern;
        this.totalSpace = totalSpace;
        this.evaluatePasswordLevel();
    }
}
