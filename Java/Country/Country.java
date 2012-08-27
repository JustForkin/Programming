import java.util.Comparator;

/**
   A country with a name and area.
*/
public class Country implements Comparable<Country>
{
   /**
      Constructs a country.
      @param aName the name of the country
      @param anArea the area of the country
   */
   public Country(String aName, double anArea)
   {
      name = aName;
      area = anArea;
   }

   /**
      Gets the name of the country.
      @return the name
   */
   public String getName()
   {
      return name;
   }

   /**
      Gets the area of the country.
      @return the area
   */
   public double getArea()
   {
      return area;
   }


   /**
      Compares two countries by area.
      @param other the other country
      @return a negative number if this country has a smaller
      area than otherCountry, 0 if the areas are the same,
      a positive number otherwise
   */
   public int compareTo(Country other)
   {
      if (area < other.area) return -1;
      if (area > other.area) return 1;
      return 0;
   }
   
   /**
    * Creates an instance of an anon class that implements Comparator interface
    * @param increasing Indicates whether to compare increasingly/decreasingly
    * @return an instance of an anon class that compares country names increasing/decreasingly
    */
   public static Comparator<Country> createComparatorByName(final boolean increasing)
   {
	   return new 
		   Comparator<Country>()
		   {
			   private int direction;
		
			   public int compare(Country country1, Country country2) 
			   {
				   if (increasing==true) {direction=1;} else {direction=-1;}
				   return (direction*country1.getName().compareTo(country2.getName()));
			   }
		
		   };
   }
   
   /**
    * Creates an instance of an anon class that implements Comparator interface
    * @param increasing Indicates whether to compare increasingly/decreasingly
    * @return an instance of an anon class that compares country areas increasing/decreasingly
    */
   public static Comparator<Country> createComparatorByArea(final boolean increasing)
   {
	   return new 
		   Comparator<Country>()
		   {
			   private int direction;
		
			   public int compare(Country country1, Country country2) 
			   {
				   if (increasing==true) {direction=1;} else {direction=-1;}
				   return (direction*country1.compareTo(country2));
			   }
		   };
   }

   private String name;
   private double area;
}