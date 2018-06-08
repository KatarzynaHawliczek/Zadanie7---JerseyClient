
package weatherclient;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import weather.Weather;

public class WeatherClient 
{

	public static final String URL = "http://api.openweathermap.org/data/2.5/weather?id=%d&units=metric&appid=e0fdc563f3ca224f3f9e1da87c81585e";

	public Weather getById(int id) 
	{
		String customPath = String.format(URL, id);
		Response response = ClientBuilder.newClient().target(customPath).request().get();
		if (response.getStatus() == 200)
		{
			return response.readEntity(Weather.class);
		}			
		return null;
	}
	
}
