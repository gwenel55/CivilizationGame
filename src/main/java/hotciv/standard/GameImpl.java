package hotciv.standard;

import hotciv.framework.*;

import java.util.HashMap;

import static hotciv.framework.GameConstants.*;

/** Skeleton implementation of HotCiv.
 
   This source code is from the book 
     "Flexible, Reliable Software:
       Using Patterns and Agile Development"
     published 2010 by CRC Press.
   Author: 
     Henrik B Christensen 
     Department of Computer Science
     Aarhus University
   
   Please visit http://www.baerbak.com/ for further information.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
 
       http://www.apache.org/licenses/LICENSE-2.0
 
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/

public class GameImpl implements Game {
  private int year = 2900;
  private HashMap<Position, TileImpl> tileMap = new HashMap();
  private HashMap<Position, UnitImpl> unitMap = new HashMap();
  public GameImpl() {
    //For world layout: tile types
    for(int i=0; i<WORLDSIZE; i++) {
      for(int j=0; j<WORLDSIZE; j++) {
        Position p = new Position(i, j);
        tileMap.put(p, new TileImpl(p, PLAINS));
      }
    }
    Position oceanPos = new Position(1,0);
    Position hillPos = new Position(0,1);
    Position mountainPos = new Position(2,2);
    tileMap.put(oceanPos, new TileImpl(oceanPos, OCEANS));
    tileMap.put(hillPos, new TileImpl(oceanPos, HILLS));
    tileMap.put(mountainPos, new TileImpl(oceanPos, MOUNTAINS));

    //For units: troop layout
    Position archerPos = new Position(2,0);
    Position legionPos = new Position(3,2);
    Position settlerPos = new Position(4,3);
    unitMap.put(archerPos, new UnitImpl(archerPos, ARCHER, Player.RED));
    unitMap.put(legionPos, new UnitImpl(legionPos, LEGION, Player.BLUE));
    unitMap.put(settlerPos, new UnitImpl(settlerPos, SETTLER, Player.RED));
  }
  public Tile getTileAt( Position p ) {
    return tileMap.get(p);
  }
  public Unit getUnitAt( Position p ) {
    return unitMap.get(p);
  }
  public City getCityAt( Position p ) { return null; }
  public Player getPlayerInTurn() {
    int turn;
    turn = I_turn.getTurn();
    turn++;
    I_turn.setTurn(turn);
    year = year + 100;
    if(turn%2 == 0){
      return Player.BLUE;
    }
    else {
      return Player.RED;
    }
  }
  public Player getWinner() {
    if (getAge() >= 3000) {

      return Player.RED;
    }
    return null;
  }

  public int getAge() { return year; }
  public boolean moveUnit( Position from, Position to ) {
    return false;
  }
  public void endOfTurn() {
    //each turn should add 100 years
    //each turn should switch the Player in turn at the very end
  }
  public void changeWorkForceFocusInCityAt( Position p, String balance ) {}
  public void changeProductionInCityAt( Position p, String unitType ) {}
  public void performUnitActionAt( Position p ) {}
}
