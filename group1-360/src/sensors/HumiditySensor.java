/*
 * TCSS 360 Autumn 2019
 * Instructor: Kivanc Dincer,
 * HumiditySensor.java - A sensor for getting humidity.
 */

package sensors;

/**
 * A class simulating a humidity sensor. 
 * 
 * @author Brent O'Neill
 * @version 6 December 2019
 *
 */
public class HumiditySensor implements Sensor {
  /** An integer to set the initial humidity. This 
    * is just a simulator so is not pulling from the web. 
    */
  private int myInitial;

  /**
    * A constructor for building a humidity sensor.
    */
  public HumiditySensor() {
    myInitial = 45;
  }
  
  @Override
  public int reportWeather() {
    // This is just a simulator, so the value is randomly selected
    // from the range InitialValue +- 7. This is to prevent drastic
    // changes within seconds. 
    int max = myInitial + 7; 
    int min = myInitial - 7; 
    int humidity = Math.abs((int)(Math.random() * (max - min)) + min);
    myInitial = humidity;
    return humidity;
  }
}
