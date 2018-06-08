package city;


import java.util.ArrayList;
import java.util.List;

public class CityRepository 
{

	private List<City> cities;

	public List<City> addCities()
    {
		cities = new ArrayList<City>();

		cities.add(new City(4927854, "Warszawa", "PL"));
		cities.add(new City(3099434, "Gdansk", "PL"));
		cities.add(new City(3094802, "Krakow", "PL"));
		cities.add(new City(3081368, "Wroclaw", "PL"));
		cities.add(new City(7530858, "Poznan", "PL"));
		cities.add(new City(3093133, "Lodz", "PL"));
		cities.add(new City(3096472, "Katowice", "PL"));

		return cities;
	}

	public List<City> getCities()
	{ 
		if (cities == null) 
		{
			addCities();
		}
		return cities;
	}

}
