# CST-183_Program 4

Objective
To build a complete working Java program that offers practice with program modularity using methods.
Overview & Instruction
Write a Java program that will determine the risk of severe weather at a given weather station by utilizing measurements
taken from a weather balloon. Weather balloons are used to observe upper air measurements.
There are several severe weather indexes used by meteorologists. Two are included in this assignment. Each include a
simple arithmetic formula and are defined to calculate values based on patterns and conditions likely to produce severe
weather. They offer a forecaster a quick number that can be referenced to assist in judging weather risks on a given day.
These measurements taken via weather balloons are not taken at standard heights, but instead at standard pressure
levels (in the unit of millibars). The severe weather indexes your program will calculate require the following values (℃):
T850
temperature at 850 mb T700
temperature at 700 mb T500
temperature at 500 mb
Td850 dew point at 850 mb Td700 dew point at 700 mb

Below are two indexes your program needs calculate:
Total Totals Index
TT = T850 + Td850 – 2 ( T500
) in degrees Celsius

The value produced from the Total Totals Index then can be interpreted to produce the following forecasts:
Total Totals
Index
Severe Weather Risk
Less Than 44 Thunderstorms Unlikely
44 to 45 Isolated Moderate Thunderstorms
46 to 47 Scattered Moderate, Few Heavy Thunderstorms
48 to 49 Scattered Moderate, Few Heavy, Isolated Severe Thunderstorms
50 to 51 Scattered Heavy, Few Severe Thunderstorms, Isolated Tornadoes
52 to 55 Scattered to Numerous Heavy, Few to Scattered Severe Thunderstorms, Isolated Tornadoes
Greater Than 55 Numerous Heavy, Scattered Severe Thunderstorms, Few to Scattered Tornadoes


K-Index
K = T850 + Td850 – T500 – ( T700 – Td700
) in degrees Celsius
The value produced from the K-Index then can be interpreted to produce the following forecasts:
Total Totals Index Severe Weather Risk
Less Than 20 Thunderstorms Unlikely
20 to 25 Isolated Thunderstorms
26 to 30 40% - 60% chance of thunderstorms
31 to 35 60% - 80% chance of thunderstorms, some severe
36 to 40 80% - 90% chance of heavy thunderstorms, some severe
Greater than 40 Almost 100% chance for thunderstorms, some severe


Include (minimally) the following methods for your solution:
● Calculate K-Index
● Assess K-Index risk
● Calculate Total Totals Index
● Assess Total Totals Index risk
● One or more methods for input validation


For validation, assume that 850 mb values must be between -40 ℃ and 40 ℃, 700 mb values must be between –60 ℃
and 10 ℃, and 500 mb values must be between –50 ℃ and 0 ℃. Note also that the dew point values can never exceed
the temperature values. Since there is no direct "user input", you are free to close the program for any incorrect input
data.


Instead of direct user prompts for input, your program should pull information from a data file. A file is preferred for this
solution due to the larger number of data tokens required for input. The file name and format should match what you see
in this example:

uadata.txt

which stores the following observations: T850 = 20 ℃, Td850 = 15 ℃, T700 = 3 ℃, Td700 = 1 ℃, and T500 = –9 ℃



Output for the program should be summary report (displayed via a dialog box) to include the following information:
○ Total Totals Index value and associated risk statement
○ K- Index value and associated risk statement



Optional (FYI): To utilize actual test data, visit: http://weather.uwyo.edu/upperair/sounding.html and click on DTX (Detroit)
to access the most recent weather balloon data for our area. Use this how-to to read and interpret the page.
Otherwise, use of the case study for a severe weather event from the test case above.
