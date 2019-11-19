/*
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.  <http://www.gnu.org/licenses/>
 *
 * Author(s):
 * © 2019 Fabian Ramirez <fabian.ramirez@gmail.com>
 */

public class Client
{
    public static void main(String[] args)
    {
        System.out.println("ClienteWeather: Conectando con el servidor remoto\n");
        String city = "Temuco";

        try(com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args))
        {
            com.zeroc.Ice.ObjectPrx base = communicator.stringToProxy("Sensor:default -p 10000");
            Ufro.SensorPrx printer = Ufro.SensorPrx.checkedCast(base);
            if(printer == null)
            {
                throw new Error("Proxy remoto invalido");
            }

            System.out.println("[+] Solicitando información requerida");
            System.out.println("[+] Solicitando temperatura para " + city + " " + printer.getTemperature(city));
            System.out.println("[+] Solicitando Humedad para " + city + " " + printer.getHumidity(city));
            System.out.println("[+] Solicitando Velocidad del Viento para " + city + " " + printer.getWindSpeed(city));
        }
    }
}