import java.util.*;

public class ComparatorTester
{
	/**
	 * creates a list of 3 countries with names/areas and then sorts them in different ways
	 * @param args
	 */
   public static void main(String[] args)
   {
      ArrayList<Country> countries = new ArrayList<Country>();
      countries.add(new Country("Uruguay", 176220));
      countries.add(new Country("Thailand", 514000));
      countries.add(new Country("Belgium", 30510));

     
	  Collections.sort(countries, Country.createComparatorByName(true));
      System.out.println("Now the array list is sorted by name A-Z:");
      for (Country c : countries)
         System.out.println(c.getName() + " " + c.getArea());
      
      Collections.sort(countries, Country.createComparatorByName(false));
      System.out.println("Now the array list is sorted by name Z-A:");
      for (Country c : countries)
          System.out.println(c.getName() + " " + c.getArea());
      
      Collections.sort(countries, Country.createComparatorByArea(true));
      System.out.println("Now the array list is sorted by area ascending:");
      for (Country c : countries)
          System.out.println(c.getName() + " " + c.getArea());
      
      Collections.sort(countries, Country.createComparatorByArea(false));
      System.out.println("Now the array list is sorted by area descending:");
      for (Country c : countries)
          System.out.println(c.getName() + " " + c.getArea());
      
   }
   
}
