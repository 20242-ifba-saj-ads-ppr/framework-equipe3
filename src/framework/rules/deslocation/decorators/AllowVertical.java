package framework.rules.deslocation.decorators;

import framework.rules.deslocation.DeslocationRule;
import framework.vector.Vector;

public class AllowVertical extends DeslocationDecorator {

    int verticalLimit;

    public AllowVertical(DeslocationRule next) {
        super(next);
        this.verticalLimit = 99999999;
    }

    public AllowVertical(DeslocationRule next, int verticalLimit) {
        super(next);
        this.verticalLimit = verticalLimit;
    }

    @Override
    public boolean isValidDeslocation(Vector deslocation) {
        return deslocation.vertical() <= this.verticalLimit && this.nextRule.isValidDeslocation(deslocation);
    }

}
