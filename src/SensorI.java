/*
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.  <http://www.gnu.org/licenses/>
 *
 * Author(s):
 * © 2019 Fabian Ramirez <fabian.ramirez@gmail.com>
 */

public class SensorI implements Ufro.Sensor
{

    public String getTemperature(String city, com.zeroc.Ice.Current current)
    {
        System.out.println("Temperatura solicitada para la ciudad de " + city);
        WeatherApiCall weatherApiCall = new WeatherApiCall();
        return weatherApiCall.getWeather(city);
    }

    public String getHumidity(String city, com.zeroc.Ice.Current current)
    {
        System.out.println("Humedad solicitada para la ciudad de " + city);
        WeatherApiCall weatherApiCall = new WeatherApiCall();
        return weatherApiCall.getHumidity(city);
    }

    public String getWindSpeed(String city, com.zeroc.Ice.Current current)
    {
        System.out.println("Velocidad del viento solicitada para la ciudad de " + city);
        WeatherApiCall weatherApiCall = new WeatherApiCall();
        return weatherApiCall.getWind(city);
    }
}