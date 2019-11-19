/*
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.  <http://www.gnu.org/licenses/>
 *
 * Author(s):
 * © 2019 Fabian Ramirez <fabian.ramirez@gmail.com>
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.TreeMap;
import com.google.gson.Gson;
import java.net.URI;

public class Server
{
    public static void main(String[] args)
    {
        System.out.println("Iniciando servidor de Temperatura basado en ZeroC");

        try(com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args))
        {
            com.zeroc.Ice.ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("SensorAdapter", "default -p 10000");
            com.zeroc.Ice.Object object = new SensorI();
            adapter.add(object, com.zeroc.Ice.Util.stringToIdentity("Sensor"));
            adapter.activate();
            communicator.waitForShutdown();
        }
    }
}