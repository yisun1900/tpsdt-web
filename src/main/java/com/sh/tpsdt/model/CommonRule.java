package com.sh.tpsdt.model;

import com.sh.tpsdt.constants.PasswordLevel;
import com.sh.tpsdt.model.heat_structure.HeatStructureStandard;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonRule {

    protected String rulePattern;

    protected Integer length;

    protected Double space;

    protected Double frequent;

    protected Double frequency;

    protected Double efficiency;

    protected Double totalSpace;

    protected Double totalFrequent;

    protected Integer order;

    protected PasswordLevel passwordLevel;

    protected String desc;

    protected void evaluatePasswordLevel() {
        if (this.totalSpace < HeatStructureStandard.SUPER_LOW) {
            this.passwordLevel = PasswordLevel.SUPER_LOW;
        } else if (this.totalSpace >= HeatStructureStandard.SUPER_LOW && this.totalSpace < HeatStructureStandard.LOW) {
            this.passwordLevel = PasswordLevel.LOW;
        } else if (this.totalSpace >= HeatStructureStandard.LOW && this.totalSpace < HeatStructureStandard.MEDIUM) {
            this.passwordLevel = PasswordLevel.MEDIUM;
        } else if (this.totalSpace >= HeatStructureStandard.MEDIUM && this.totalSpace < HeatStructureStandard.HIGH) {
            this.passwordLevel = PasswordLevel.HIGH;
        } else if (this.totalSpace >= HeatStructureStandard.HIGH && this.totalSpace < HeatStructureStandard.SUPER_HIGH) {
            this.passwordLevel = PasswordLevel.SUPER_HIGH;
        } else {
            this.passwordLevel = PasswordLevel.SUPER_HIGH;
        }
    }
}
