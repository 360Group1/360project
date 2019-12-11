/*
 * TCSS 360 Autumn 2019
 * Instructor: Kivanc Dincer,
 * WindSensor.java - A sensor for getting wind speed.
 */

package sensors;

/**
 * A class simulating a wind sensor. 
 * 
 * @author Brent O'Neill
 * @version 6 December 2019
 *
 */
public class WindSensor implements Sensor {
  /** An integer to set the initial wind speed. This 
    * is just a simulator so is not pulling from the web. 
    */
  private int myInitial;

  /**
    * A constructor for building a wind sensor.
    */
  public WindSensor() {
    myInitial = 2;
  }
  
  @Override
  public int reportWeather() {
    // This is just a simulator, so the value is randomly selected
    // from the range InitialValue +- 2. This is to prevent drastic
    // changes within seconds. 
    int max = myInitial + 2; 
    int min = myInitial - 2; 
    int windSpeed = Math.abs((int)(Math.random() * (max - min)) + min);
    myInitial = windSpeed;
    return windSpeed;
  }
}
