package ladder.step2.domain.partlinestrategy;

import ladder.step2.domain.PartLine;

import java.util.Random;

public interface PartLineCreateStrategy {
    Random RANDOM = new Random();
    
    PartLine create();
}
