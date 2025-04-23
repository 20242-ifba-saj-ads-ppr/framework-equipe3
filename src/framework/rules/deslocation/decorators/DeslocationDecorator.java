package framework.rules.deslocation.decorators;

import framework.rules.deslocation.DeslocationRule;

public abstract class DeslocationDecorator implements DeslocationRule {

    protected DeslocationRule nextRule;

    public DeslocationDecorator(DeslocationRule nextRule) {
        this.nextRule = nextRule;
    }




}
