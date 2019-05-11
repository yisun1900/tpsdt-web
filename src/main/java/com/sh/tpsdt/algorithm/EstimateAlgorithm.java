package com.sh.tpsdt.algorithm;

import com.sh.tpsdt.constants.PasswordLevel;

public interface EstimateAlgorithm {

    PasswordLevel estimatePasswordLevel(String command);
}
