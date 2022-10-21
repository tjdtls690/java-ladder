package ladder.step2.domain.partlinestrategy;

import ladder.step2.domain.PartLine;

public class RandomPartLineCreateStrategy implements PartLineCreateStrategy {
    @Override
    public PartLine create() {
        return new PartLine(randomBoolean());
    }
    
    private boolean randomBoolean() {
        return RANDOM.nextBoolean();
    }
}
