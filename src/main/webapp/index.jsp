<%@page import="weather.Weather"%>
<%@page import="weatherclient.WeatherClient"%>
<%@page import="city.City"%>
<%@page import="java.util.List"%>
<%@page import="city.CityRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pogoda</title>
</head>
<body>
    <table border="1" width="30%" cellpadding="3">
        <thead>
           <tr>
		      <th><h1>POGODA</h1></th>
		   </tr>
		   <tr>
		      <th><h2>Wybierz miasto:</h2></th>
		   </tr>
		</thead>
		<tbody>
		<%
			CityRepository cityRepository = new CityRepository();
			List<City> cities = cityRepository.getCities();
			
			for (City c : cities) 
			{
		%>
		   <tr>
		     <td><br/><a href="?<%="id"%>=<%=c.getId()%>"><%=c.getName()%></a></td>
		   </tr>
		<%
			}
			
			String name = "";
			
			if (request.getParameter("id") != null) 
			{
			    String id = request.getParameter("id");
			    int newId = Integer.parseInt(id);
				
			    for (City c : cities)
			    {
				    if(c.getId() == newId) 
				    {
					    name = c.getName();
				    }
		        }
		%>
		<tr>
		  <td>
		        <h3><%=name%></h3><br/>
		<%
			    WeatherClient weatherClient = new WeatherClient();
			    Weather weather = weatherClient.getById(newId);
		%>
		        Poziom zachmurzenia:<%=weather.getClouds().getAll()%> %<br/> 
		        Temperatura:<%=weather.getMain().getTemp()%> °C<br/>
		        Ciśnienie:<%=weather.getMain().getPressure()%> hPa<br/> 
		        Prędkość wiatru:<%=weather.getWind().getSpeed()%> m/s<br/>
		  </td>
		</tr>
		<%
			}
		%>
		</tbody>
	</table>
</body>
</html>