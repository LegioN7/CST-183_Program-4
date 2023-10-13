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

    // static values for the temperatures
    public static final double temperatureEightHundredFiftyMin = -40;
    public static final double temperatureEightHundredFiftyMax = 40;
    public static final double temperatureDewPointEightHundredFiftyMin = -40;
    public static final double temperatureSevenHundredMin = -60;
    public static final double temperatureSevenHundredMax = 10;
    public static final double temperatureDewPointSevenHundredMin = -60;
    public static final double temperatureFiveHundredMin = -50;
    public static final double temperatureFiveHundredMax = 0;

    // Calculates the Total Total Index from the uadata.txt file
    public static double totalTotalIndexCalc(double temperatureEightHundredFifty, double dewPointEightHundredFifty, double temperatureFiveHundred) {
        //I could inline this code and remove the redundancy
        double totalTotalIndex = temperatureEightHundredFifty + dewPointEightHundredFifty - 2 * (temperatureFiveHundred);

        return totalTotalIndex;
    }

    // Calculates the K Index from the uadata.txt file
    public static double kIndexCalc(double temperatureEightHundredFifty, double dewPointEightHundredFifty, double temperatureSevenHundred, double dewPointSevenHundred, double temperatureFiveHundred) {
        //I could inline this code and remove the redundancy
        double kIndex = temperatureEightHundredFifty + dewPointEightHundredFifty - temperatureFiveHundred - (temperatureSevenHundred - dewPointSevenHundred);
        return kIndex;
    }

    public static String totalTotalWeatherRiskCalc(double totalTotalIndex) {

        String totalTotalForecast = null;

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

        return totalTotalForecast;
    }

    public static String kIndexWeatherRiskCalc(double kIndexPlace) {

        String kIndexForecast = null;

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

        return kIndexForecast;
    }

    // This validates the input of all the temperature
    // Dewpoint can not be greater than the temperature in its value (i.e. 850 dewpoint can not be greater than 850 temperature)
    public static double validateTemperature(double temperature, double min, double max) {
        if (temperature >= min && temperature <= max) {
            return temperature;
        } else {
            throw new IllegalArgumentException("Invalid temperature. Temperature must be between " + min + " and " + max + " Celsius.");
        }
    }

    public static void main(String[] args) {

        // All Temperature Values are in Celsius
        // Set the variables for the data that comes from the uadata.txt file
        double temperatureEightHundredFifty = 0; //T850
        double dewPointEightHundredFifty = 0; //Td850
        double temperatureSevenHundred = 0; //T700
        double dewPointSevenHundred = 0; //Td700
        double temperatureFiveHundred = 0; //T500

        // Placeholder string for the Weather Risks Texts


        // Read the uadata.txt file
        // Data comes in individual lines

        // Example Start
        // value
        // value
        // value
        // value
        // value
        // Example End

        try {
            File myObj = new File("uadata.txt");
            Scanner dataReader = new Scanner(myObj);

            temperatureEightHundredFifty = validateTemperature(dataReader.nextDouble(), temperatureEightHundredFiftyMin, temperatureEightHundredFiftyMax);
            dewPointEightHundredFifty = validateTemperature(dataReader.nextDouble(), temperatureDewPointEightHundredFiftyMin, temperatureEightHundredFifty);
            temperatureSevenHundred = validateTemperature(dataReader.nextDouble(), temperatureSevenHundredMin, temperatureSevenHundredMax);
            dewPointSevenHundred = validateTemperature(dataReader.nextDouble(), temperatureDewPointSevenHundredMin, temperatureSevenHundred);
            temperatureFiveHundred = validateTemperature(dataReader.nextDouble(), temperatureFiveHundredMin, temperatureFiveHundredMax);


            // Calculation Holders for Total Total Index and K Index
            double totalTotalIndex = totalTotalIndexCalc(temperatureEightHundredFifty, dewPointEightHundredFifty, temperatureFiveHundred);
            double kIndexPlace = kIndexCalc(temperatureEightHundredFifty, dewPointEightHundredFifty, temperatureSevenHundred, dewPointSevenHundred, temperatureFiveHundred);


            // Severe Weather Texts for Total Total Index
            String totalTotalForecast = totalTotalWeatherRiskCalc(totalTotalIndex);
            String kIndexForecast = kIndexWeatherRiskCalc(kIndexPlace);

            // Severe Weather Texts for K Index


            // Dialog Panels for the output
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
