/*
 * TCSS 360 Autumn 2019
 * Instructor: Kivanc Dincer,
 * WeatherControls.java - An interface for defining the controls in
 * the weather object. 
 */

package model;

/**
 * An interface for defining the controls in a weather object.
 *
 * @author Brent O'Neill
 * @version 6 December 2019
 */
public interface WeatherControls {

  /**
    * Method to change the date/time and notify observers. 
    */
  void changeDateTime();

  /**
    * Method to get the new weather statistics and notify observers.
    */
  void updateWeather();
}
