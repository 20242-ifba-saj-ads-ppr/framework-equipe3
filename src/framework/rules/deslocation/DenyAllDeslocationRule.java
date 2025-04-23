package framework.rules.deslocation;

import framework.vector.Vector;

public class DenyAllDeslocationRule implements DeslocationRule {

    @Override
    public boolean isValidDeslocation(Vector deslocation) {
        return false;
    }

}
