package tsp.controllers;

import java.util.ArrayList;
import java.util.List;
import tsp.models.Map;
import tsp.models.Town;
import tsp.models.Way;

public class BasicMapController {
    
    public static Map basicMap; 

    public static void createBasicMap() {
        Town townStart = new Town("Starting", true, 4, 2);
        Town townOne = new Town("One", false, 7, 5);
        Town townTwo = new Town("Two", false, 2, 5);
        Town townThree = new Town("Three", false, 9, 4);
        Town townFour = new Town("Four", false, 9, 10);
        Town townFive = new Town("Five", false, 3, 14);
        Town townSix = new Town("Six", false, 6, 15);
        Town townSeven = new Town("Seven", false, 9, 16);
        Town townEight = new Town("Eight", false, 8, 17);
        Town townNine = new Town("Nine", false, 4, 9);
        
        List<Town> towns = new ArrayList<>();
        towns.add(townStart);
        towns.add(townOne);
        towns.add(townTwo);
        towns.add(townThree);
        towns.add(townFour);
        towns.add(townFive);
        towns.add(townSix);
        towns.add(townSeven);
        towns.add(townEight);
        towns.add(townNine);
        
        Way startToOne = new Way(townStart, townOne);
        Way startToTwo = new Way(townStart, townTwo);
        Way startToThree = new Way(townStart, townThree);
        
        Way oneToTwo = new Way(townOne, townTwo);
        
        Way twoToNine = new Way(townTwo, townNine);
        
        Way threeToFour = new Way(townThree, townFour);
        Way threeToNine = new Way(townThree, townNine);
        
        Way fourToFive = new Way(townFour, townFive);
        
        Way fiveToSix = new Way(townFive, townSix);
        
        Way sixToSeven = new Way(townSix, townSeven);
        Way sixToEight = new Way(townSix, townEight);
        
        Way sevenToEight = new Way(townSeven, townEight);
        Way sevenToNine = new Way(townSeven, townNine);
        
        List<Way> ways = new ArrayList<>();
        ways.add(startToOne);
        ways.add(startToTwo);
        ways.add(startToThree);
        ways.add(oneToTwo);
        ways.add(twoToNine);
        ways.add(threeToFour);
        ways.add(threeToNine);
        ways.add(fourToFive);
        ways.add(fiveToSix);
        ways.add(sixToSeven);
        ways.add(sixToEight);
        ways.add(sevenToEight);
        ways.add(sevenToNine);
        
        Map map = new Map();
        
        map.setTowns(towns);
        map.setWays(ways);
        
        basicMap = map;

    }
}
