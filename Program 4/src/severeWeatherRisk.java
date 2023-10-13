// https://elearning.delta.edu/d2l/le/dropbox/2970298/261322/DownloadAttachment?fid=9504649
// http://weather.uwyo.edu/upperair/sounding.html
/*
Write a Java program that will determine the risk of severe weather at a given weather station by utilizing measurements
taken from a weather balloon. Weather balloons are used to observe upper air measurements.
There are several severe weather indexes used by meteorologists. Two are included in this assignment. Each include a
simple arithmetic formula and are defined to calculate values based on patterns and conditions likely to produce severe
weather. They offer a forecaster a quick number that can be referenced to assist in judging weather risks on a given day.
These measurements taken via weather balloons are not taken at standard heights, but instead at standard pressure
levels (in the unit of millibars). The severe weather indexes your program will calculate require the following values (℃):

 */

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//T850 = 20 ℃, Td850 = 15 ℃, T700 = 3 ℃, Td700 = 1 ℃, and T500 = –9 ℃
public class severeWeatherRisk {


    public static double totalTotalIndexCalc(double temperatureEightHundredFifty, double dewPointEightHundredFifty, double temperatureFiveHundred) {
        double totalTotalIndex = temperatureEightHundredFifty + dewPointEightHundredFifty - 2 * (temperatureFiveHundred);

        return totalTotalIndex;
    }

    public static double kIndexCalc(double temperatureEightHundredFifty, double dewPointEightHundredFifty, double temperatureSevenHundred, double dewPointSevenHundred, double temperatureFiveHundred) {
        double kIndex = temperatureEightHundredFifty + dewPointEightHundredFifty - temperatureFiveHundred - (temperatureSevenHundred - dewPointSevenHundred);
        return kIndex;
    }


    // This validates the input of all the temperature
    public static double validateTemperature (double temperature, double min,double max){
        if (temperature >= min && temperature <= max)
        {
            return temperature;
        } else {
            throw new IllegalArgumentException("Invalid temperature. Temperature must be between " + min + " and " + max + " Celsius.");
        }
    }

    public static void main(String[] args) {

        // All Temperature Values are in Celsius
        double temperatureEightHundredFifty = 0; //T850
        double dewPointEightHundredFifty = 0; //Td850
        double temperatureSevenHundred = 0; //T700
        double dewPointSevenHundred = 0; //Td700
        double temperatureFiveHundred = 0; //T500

        String totalTotalForecast = "";
        String kIndexForecast = "";

        try {
            File myObj = new File("uadata.txt");
            Scanner dataReader = new Scanner(myObj);

            temperatureEightHundredFifty = validateTemperature(dataReader.nextDouble(), -40, 40);
            dewPointEightHundredFifty = validateTemperature(dataReader.nextDouble(), -40, temperatureEightHundredFifty);
            temperatureSevenHundred = validateTemperature(dataReader.nextDouble(), -60, 10);
            dewPointSevenHundred = validateTemperature(dataReader.nextDouble(), -60, temperatureSevenHundred);
            temperatureFiveHundred = validateTemperature(dataReader.nextDouble(), -50, 0);


            // Calculation Holders for Total Total Index and K Index
            double totalTotalIndex = totalTotalIndexCalc(temperatureEightHundredFifty, dewPointEightHundredFifty, temperatureFiveHundred);
            double kIndexPlace = kIndexCalc(temperatureEightHundredFifty, dewPointEightHundredFifty, temperatureSevenHundred, dewPointSevenHundred, temperatureFiveHundred);


            if (totalTotalIndex < 44) {
                totalTotalForecast = "Thunderstorms Unlikely";
            } else if (totalTotalIndex >= 44 && totalTotalIndex <= 45) {
                totalTotalForecast = "Isolated Moderate Thunderstorms";
            } else if (totalTotalIndex >= 46 && totalTotalIndex <= 47) {
                totalTotalForecast = "Scattered Moderate, Few Heavy Thunderstorms";
            } else if (totalTotalIndex >= 48 && totalTotalIndex <= 49) {
                totalTotalForecast = "Scattered Moderate, Few Heavy, Isolated Severe Thunderstorms";
            } else if (totalTotalIndex >= 50 && totalTotalIndex <= 51) {
                totalTotalForecast = "Scattered Heavy, Few Severe Thunderstorms, Isolated Tornadoes";
            } else if (totalTotalIndex >= 52 && totalTotalIndex <= 55) {
                totalTotalForecast = "Scattered to Numerous Heavy, Few to Scattered Severe Thunderstorms, Isolated Tornadoes";
            } else if (totalTotalIndex > 55) {
                totalTotalForecast = "Numerous Heavy, Scattered Severe Thunderstorms, Few to Scattered Tornadoes";
            }

            // K Index Forecast
            if (kIndexPlace < 20) {
                kIndexForecast = "Thunderstorms Unlikely";
            } else if (kIndexPlace >= 20 && kIndexPlace <= 25) {
                kIndexForecast = "Isolated Thunderstorms";
            } else if (kIndexPlace >= 26 && kIndexPlace <= 30) {
                kIndexForecast = "40% - 60% chance of thunderstorms";
            } else if (kIndexPlace >= 31 && kIndexPlace <= 35) {
                kIndexForecast = "60% - 80% chance of thunderstorms, some severe";
            } else if (kIndexPlace >= 36 && kIndexPlace <= 40) {
                kIndexForecast = "80% - 90% chance of heavy thunderstorms, some severe";
            } else if (kIndexPlace > 40) {
                kIndexForecast = "Almost 100% chance for thunderstorms, some severe";
            }


            JOptionPane.showMessageDialog(null, "Total Total Placeholder: " + totalTotalIndex + "\n" + "Total Total Index Forecast: " + totalTotalForecast);
            JOptionPane.showMessageDialog(null, "K Index Placeholder: " + kIndexPlace + "\n" + "K Index Forecast: " + kIndexForecast);


            // Close the File
            dataReader.close();

            // Catch if the file is not found.
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: File not found.");
        } catch (IllegalArgumentException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
