package framework.rules.deslocation.decorators;

import framework.rules.deslocation.DeslocationRule;
import framework.vector.Vector;

public class AllowHorizontal extends DeslocationDecorator {

    int horizontalLimit = 99999999;

    public AllowHorizontal(DeslocationRule next) {
        super(next);
        this.horizontalLimit = 99999999;
    }

    public AllowHorizontal(DeslocationRule next, int horizontalLimit) {
        super(next);
        this.horizontalLimit = horizontalLimit;
    }

    @Override
    public boolean isValidDeslocation(Vector deslocation) {
        return deslocation.horizontal() <= this.horizontalLimit && this.nextRule.isValidDeslocation(deslocation);
    }

}
