/*
 * This file is part of Weather web-service call.
 * Weather web-service call is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 3
 * as published by the Free Software Foundation.
 *
 * Weather web-service call is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.  <http://www.gnu.org/licenses/>
 *
 * Author(s):
 * © 2015 Kasra Madadipouya <kasra@madadipouya.com>
 */

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.util.List;

public class WebServiceResponseJson {
    @SerializedName("coord")
    public Coord coord;
    @SerializedName("weather")
    public List<Weather> weather;
    @SerializedName("base")
    public String base;
    @SerializedName("main")
    public Main main;
    @SerializedName("visibility")
    public BigDecimal visibility;
    @SerializedName("wind")
    public Wind wind;
    @SerializedName("clouds")
    public Clouds clouds;
    @SerializedName("dt")
    public BigDecimal dt;
    @SerializedName("sys")
    public Sys sys;
    @SerializedName("id")
    public BigDecimal id;
    @SerializedName("name")
    public String name;
    @SerializedName("cod")
    public BigDecimal cod;
    public static class Coord {
        public BigDecimal lon;
        public BigDecimal lat;
        public Coord() {
            this.lon = new BigDecimal(0);
            this.lat = new BigDecimal(0);
        }
    }
    public static class Weather {
        public Integer id;
        public String main;
        public String description;
        public String icon;
        public Weather() {
            this.id = new Integer(0);
            this.main = "";
            this.description = "";
            this.icon = "";
        }
    }
    public static class Main {
        public BigDecimal temp;
        public BigDecimal pressure;
        public BigDecimal humidity;
        public BigDecimal temp_min;
        public BigDecimal temp_max;
        public Main() {
            this.temp = new BigDecimal(0);
            this.pressure = new BigDecimal(0);
            this.humidity = new BigDecimal(0);
            this.temp_min = new BigDecimal(0);
            this.temp_max = new BigDecimal(0);
        }
    }
    public static class Wind {
        public BigDecimal speed;
        public BigDecimal deg;
        public Wind() {
            this.speed = new BigDecimal(0);
            this.deg = new BigDecimal(0);
        }
    }
    public static class Clouds {
        public BigDecimal all;
        public Clouds() {
            this.all = new BigDecimal(0);
        }
    }
    public static class Sys {
        public BigDecimal type;
        public BigDecimal id;
        public BigDecimal message;
        public String country;
        public BigDecimal sunrise;
        public BigDecimal sunset;
        public Sys() {
            this.type = new BigDecimal(0);
            this.id = new BigDecimal(0);
            this.message = new BigDecimal(0);
            this.country = "";
            this.sunrise = new BigDecimal(0);
            this.sunset = new BigDecimal(0);
        }
    }
}