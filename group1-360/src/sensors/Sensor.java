/*
 * TCSS 360 Autumn 2019
 * Instructor: Kivanc Dincer,
 * Sensor.java - An interface for weather sensors.
 */

package sensors;

/** 
 * An interface for different weather sensors.
 * 
 * @author Brent O'Neill
 * @version 5 December 2019
 */
public interface Sensor {
  /**
    * A method that reports the current weather for whichever statistic 
    * a sensor is responsible for.
    * 
    * @return An integer representing a weather statistic.
    */
  int reportWeather();
  
}
