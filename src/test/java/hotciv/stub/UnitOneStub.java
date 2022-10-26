package hotciv.stub;

import Strategies.EpsilonAttack;
import hotciv.framework.*;
import hotciv.standard.Utility;


import java.util.Iterator;

import static hotciv.framework.GameConstants.ARCHER;

public class UnitOneStub implements Unit {

    @Override
    public String getTypeString() {
        return ARCHER;
    }

    @Override
    public Player getOwner() {
        return Player.RED;
    }

    @Override
    public int getMoveCount() {
        return 1;
    }

    @Override
    public int getDefensiveStrength() {
        return 5;
    }

    @Override
    public int getAttackingStrength() {
        return 2;
    }

}
