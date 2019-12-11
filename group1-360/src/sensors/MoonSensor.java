/*
 * TCSS 360 Autumn 2019
 * Instructor: Kivanc Dincer,
 * MoonSensor.java - A sensor for getting the moon phase.
 */

package sensors;

/**
 * A class simulating a moon phase sensor. 
 * 
 * @author Brent O'Neill
 * @version 6 December 2019
 *
 */
public class MoonSensor implements Sensor {
  /** An integer to set the initial moon phase. This 
    * is just a simulator so is not pulling from the web. 
    * 
    * 
    */
  private int myInitial;
  
  /**
    * A constructor for building a moon phase sensor.
    */
  public MoonSensor() {
    // These integers can represent indexes for a moon
    // phase icon array
    myInitial = (int) Math.random() * 10;
  }

  @Override
  public int reportWeather() {
    // Moon phase shouldn't change in such a short time. 
    return myInitial;
  }

}
