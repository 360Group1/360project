/*
 * TCSS 360 Autumn 2019
 * Instructor: Kivanc Dincer,
 * RainSensor.java - A sensor for getting rain totals.
 */

package sensors;

/**
 * A class simulating a rain sensor. 
 * 
 * @author Brent O'Neill
 * @version 6 December 2019
 *
 */
public class RainSensor implements Sensor {
  /** An integer to set the initial rain total. This 
    * is just a simulator so is not pulling from the web. 
    */
  private int myInitial;
  
  /**
    * A constructor for building a rain sensor.
    */
  public RainSensor() {
    myInitial = 5;
  }
  
  @Override
  public int reportWeather() {
    // This is just a simulator, so the value is randomly selected
    // from the range InitialValue +- 5. This is to prevent drastic
    // changes within seconds. 
    int max = myInitial + 5; 
    int min = myInitial - 5; 
    int rain = Math.abs((int)(Math.random() * (max - min)) + min);
    myInitial = rain;
    return rain;
  }
}