package com.sh.tpsdt.service;

import com.sh.tpsdt.algorithm.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: tpsdt
 * @description:
 * @author:
 * @create: 2019-03-14 13:48
 **/
@Service
public class ValidateCommandService {

    private LengthAlgorithm lengthAlgorithm = new LengthAlgorithm();

    private BruteMeterAlgorithm bruteMeterAlgorithm = new BruteMeterAlgorithm();

    private HeatAndStructureAlgorithm heatAndStructureAlgorithm = new HeatAndStructureAlgorithm();

    private PointAlgorithm pointAlgorithm = new PointAlgorithm();

    private RecommendAlgorithm recommendAlgorithm =
            new RecommendAlgorithm(pointAlgorithm, bruteMeterAlgorithm, heatAndStructureAlgorithm);

    private List<CommandAlgorithm> commandAlgorithmList = Arrays.asList(
            lengthAlgorithm, bruteMeterAlgorithm, heatAndStructureAlgorithm, recommendAlgorithm
    );

    public List<String> validateCommand(String password) {
        List<String> result = new ArrayList<>();
        result.add("==================================================<br/>");
        result.add("==== 当前为文本口令强度评估工具！<br/>");
        result.add("==== 在此为您输入要评测文本口令: " + password + "<br/>");
        result.addAll(this.commandAlgorithmList.stream()
                .map(commandAlgorithm -> commandAlgorithm.validateCommand(password) + "<br/>")
                .collect(Collectors.toList()));
        result.add("==================================================");
        return result;
    }
}
