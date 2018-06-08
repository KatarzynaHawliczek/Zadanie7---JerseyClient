
package weather;

public class Weather 
{

	protected String name;

	protected Clouds clouds;
	protected Main main;
	protected Wind wind;

	public Wind getWind()
	{
		return wind;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setWind(Wind wind) 
	{
		this.wind = wind;
	}

	public Main getMain() 
	{
		return main;
	}

	public void setMain(Main main) 
	{
		this.main = main;
	}

	public Clouds getClouds() 
	{
		return clouds;
	}

	public void setClouds(Clouds clouds) 
	{
		this.clouds = clouds;
	}

}
