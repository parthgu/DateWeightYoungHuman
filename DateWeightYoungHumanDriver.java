

/**
 * DateWeightYoungHumanDriver class:
 * This is used to test the Date, Weight, and YoungHuman classes
 *
 * @author David Nixon
 * @version 2021
 */
public class DateWeightYoungHumanDriver
{
    public static void main(String [] args){
        /* *** DATE TESTS:  *** */
        
        System.out.println("Date tests:");
        System.out.println("-----------");
        // construct some date objects and do some tests:
        Date d1 = new Date(6,7,2018);
        System.out.println("Testing getMonth(). Should print 6:  " + d1.getMonth());
        
        
        Date d2 = new Date(5,13,2020);
        System.out.println("Testing Date(). Should print 1/7/2018: " + d2.toString());
        
        System.out.println(d1.isEarlierThan(d2));
        
        // now add many more tests!
        
        /* *** WEIGHT TESTS:  *** */
    	
        System.out.println("Weight tests:");
        System.out.println("-------------");
        // construct some Weight objects and do some tests:
        Weight w1 = new Weight(14,8);
        System.out.println(w1.toString());
        System.out.println("Testing getWeight(). Should print 14.5: " +w1.getWeight());
        w1.add(1 , 3);
        System.out.println("Testing add(). Should print  15 lbs. 11 oz.: " + w1.toString());
        
        w1.add(-2 , 17);
        System.out.println("Testing add(). Should print  14 lbs. 12 oz.: " + w1.toString());
        
        Weight w2 = new Weight(15 , -4);
        System.out.println("Testing equals(). Should print true: " + w1.equals(w2));
        
        w2.setOunces(17);
        System.out.println("Testing setOunces(). Should print 15 lbs. 1 oz.: " + w2.toString());
        
        System.out.print("Testing Weight(). Should print error of negative weight.: ");
        Weight w3 = new Weight(2, -33);
        
        
        // now add many more tests!
        
        /* *** YOUNGHUMAN TESTS:  *** */
        
        System.out.println("YoungHuman tests:");
        System.out.println("-----------------");
        // construct some YoungHuman objects and do some tests:
        YoungHuman y1 = new YoungHuman(w1, d1, "Homer", "Simpson");
        System.out.print("Testing getName(): ");
        if (y1.getName().equals("Homer Simpson"))
            System.out.println(" TEST PASSED! :) ");
        else System.out.println(" TEST FAILED!  :( ");
        
        // now add many more tests!
        
        YoungHuman y2 = new YoungHuman(y1);
        y2.setName("Parth", "Gupta");
        System.out.println("Testing copy constructor");
        if(!y1.equals(y2))
        	System.out.println("TEST PASSED");
        else
        	System.out.println("TEST FAILED");
        
        y2.setBirthDate(new Date(11,11,2020));
        System.out.println("TESTING toString(): Should print Parth Gupta, 14 lbs. 12 oz. birth date: 11/11/2020, has not had a check-up: \n" + y2.toString());
        
        System.out.println("Testing getLastCheckUpDate(): Should print null: " + y2.getLastCheckUpDate());
        
    }
}

