module Ufro
{
    interface Sensor {
        string getTemperature(string city);
        string getHumidity(string city);
        string getWindSpeed(string city);
    }
}