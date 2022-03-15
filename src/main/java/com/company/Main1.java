package com.company;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?q=Steyr,at&appid=d134cb284ef6ebbab66ea57a6b83f4f8");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        Scanner s = new Scanner(con.getInputStream());

        StringBuilder sb = new StringBuilder();
        while (s.hasNextLine()) {
            sb.append(s.nextLine());
        }

        Gson gson = new Gson();
        Example example = gson.fromJson(sb.toString(), Example.class);


        System.out.println("City: " + example.getCity().getName() + " | " + "Einwohner: " + example.getCity().getPopulation());
        for (int i = 0; i < example.getList().size(); i++) {
            Double tempMin;
            Double tempMax;
            tempMin = example.getList().get(i).getMain().getTempMin() - 273.15;
            tempMax = example.getList().get(i).getMain().getTempMax() - 273.15;


            System.out.println("Datum: " + example.getList().get(i).getDtTxt() + " | " + "Wetter: " + example.getList().get(i).getWeather().get(0).getMain() +
                    " - " + example.getList().get(i).getWeather().get(0).getDescription() + " | " + "Windstärke: " + example.getList().get(i).getWind().getSpeed() +
                    " | " + "minTemperatur: " + new DecimalFormat("##.##").format(tempMin) + "° C | " + "max. Temperatur: " + new DecimalFormat("##.##").format(tempMax) + "° C");
        }


    }
}
