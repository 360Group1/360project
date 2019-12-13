/*
 * TCSS 360 Autumn 2019
 * Instructor: Kivanc Dincer,
 * TempSensor.java - A sensor for getting temperature.
 */

package sensors;

/**
 * A class simulating a temperature sensor. 
 * 
 * @author Brent O'Neill, Ai Nguyen, Mercedes Chea
 * @version 6 December 2019
 *
 */
public class TempSensor{
  /** An integer to set the initial temperature. This 
    * is just a simulator so is not pulling from the web. 
    */
  private int myInitial;

  /**
    * A constructor for building a temperature sensor.
    */
  public TempSensor() {
    myInitial = 60;
  }
  
  public int reportWeather() {
    // This is just a simulator, so the value is randomly selected
    // from the range InitialValue +- 10. This is to prevent drastic
    // changes within seconds. 
    int max = myInitial + 10; 
    int min = myInitial - 10; 
    myInitial = Math.abs((int)(Math.random() * (max - min)) + min); //Modified by Ai Nguyen
    return myInitial;
  }
  
  /**
   * Get current temp
   * @return
   * Ai Nguyen
   */
  public int getTemp() {
	  return myInitial;
  }
  
  
}


