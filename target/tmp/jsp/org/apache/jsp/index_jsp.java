package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import weather.Weather;
import weatherclient.WeatherClient;
import city.City;
import java.util.List;
import city.CityRepository;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Pogoda</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <table border=\"1\" width=\"30%\" cellpadding=\"3\">\n");
      out.write("        <thead>\n");
      out.write("           <tr>\n");
      out.write("\t\t      <th><h1>POGODA</h1></th>\n");
      out.write("\t\t   </tr>\n");
      out.write("\t\t   <tr>\n");
      out.write("\t\t      <th><h2>Wybierz miasto:</h2></th>\n");
      out.write("\t\t   </tr>\n");
      out.write("\t\t</thead>\n");
      out.write("\t\t<tbody>\n");
      out.write("\t\t");

			CityRepository cityRepository = new CityRepository();
			List<City> cities = cityRepository.getCities();
			
			for (City c : cities) 
			{
		
      out.write("\n");
      out.write("\t\t   <tr>\n");
      out.write("\t\t     <td><br/><a href=\"?");
      out.print("id");
      out.write('=');
      out.print(c.getId());
      out.write('"');
      out.write('>');
      out.print(c.getName());
      out.write("</a></td>\n");
      out.write("\t\t   </tr>\n");
      out.write("\t\t");

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
		
      out.write("\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t  <td>\n");
      out.write("\t\t        <h3>");
      out.print(name);
      out.write("</h3><br/>\n");
      out.write("\t\t");

			    WeatherClient weatherClient = new WeatherClient();
			    Weather weather = weatherClient.getById(newId);
		
      out.write("\n");
      out.write("\t\t        Poziom zachmurzenia:");
      out.print(weather.getClouds().getAll());
      out.write(" %<br/> \n");
      out.write("\t\t        Temperatura:");
      out.print(weather.getMain().getTemp());
      out.write(" °C<br/>\n");
      out.write("\t\t        Ciśnienie:");
      out.print(weather.getMain().getPressure());
      out.write(" hPa<br/> \n");
      out.write("\t\t        Prędkość wiatru:");
      out.print(weather.getWind().getSpeed());
      out.write(" m/s<br/>\n");
      out.write("\t\t  </td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t");

			}
		
      out.write("\n");
      out.write("\t\t</tbody>\n");
      out.write("\t</table>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
