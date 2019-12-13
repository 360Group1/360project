/*
 * TCSS 360 Autumn 2019
 * Instructor: Kivanc Dincer,
 * ObservableWeather.java - Represents an observable weather object.
 * 
 */

package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import sensors.HumiditySensor;
import sensors.RainSensor;
import sensors.Sensor;
import sensors.TempSensor;
import sensors.WindSensor;

/** 
 * An ObservableWeather object, it is capable of viewing the weather. 
 * 
 * @author Brent O'Neill, Ai Nguyen, Mercedes Chea
 * @version 6 December 2019
 */
public class ObservableWeather implements PropertyChangeEnabledWeatherControls {
  /** The default starting time. */
  public static final int DEFAULT_START_TIME = 0;
    
  /** Stores this objects time. */
  private LocalDateTime myDate;
  /** A weather sensor for temperature. */
  private TempSensor myTempSensor;
  /** A weather sensor for wind speed. */
  private Sensor myWindSensor;
  /** A weather sensor for rain total. */
  private Sensor myRainSensor;
  /** A weather sensor for humidity. */
  private Sensor myHumidSensor;
  /** A List for the past temperatures. */
  private List<Integer> myTemps;
  /** A List for the past wind speeds. */
  private List<Integer> myWinds;
  /** A List for the past rain totals. */
  private List<Integer> myRains;
  /** A List for the past humidities. */
  private List<Integer> myHumids;
  /** Manager for Property Change Listeners. */
  private final PropertyChangeSupport myPcs;
    
  /**
    * Constructs ObservableWeather object. 
    */
  public ObservableWeather() {
    super();
    // Enables property change listeners and sets the date.
    myPcs = new PropertyChangeSupport(this);
    myDate = LocalDateTime.now();
    // Sets the sensors and lists. 
    buildSensors();
    buildLists();    
  }
  
  /**
    * A private helper method to build the different sensors.
    */
  private void buildSensors() {
    myTempSensor = new TempSensor();
    myWindSensor = new WindSensor();
    myRainSensor = new RainSensor();
    myHumidSensor = new HumiditySensor();
  }
  
  /**
    * A private helper method to build the different lists. 
    */
  private void buildLists() {
    myTemps = new ArrayList<Integer>();
    myWinds = new ArrayList<Integer>();
    myRains = new ArrayList<Integer>();
    myHumids = new ArrayList<Integer>();
  }
  
  @Override
  public void changeDateTime() {
    final LocalDateTime old = myDate;
    myDate = LocalDateTime.now();
    // Fires the property change to update the time/date
    myPcs.firePropertyChange(PROPERTY_DATE, old, myDate); 
  }
  
  @Override
  public void updateWeather() {
    // Gets new weather statistics
    final int newTemp = myTempSensor.reportWeather();
    
    final int newSpeed = myWindSensor.reportWeather();
    final int newRain = myRainSensor.reportWeather();
    final int newHumid = myHumidSensor.reportWeather();
    final DateTimeFormatter date = 
        DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss");
    final LocalDateTime updateTime = LocalDateTime.now();
    
    // Ai Nguyen Mercedes Chea {
    if (newTemp > 150 || newSpeed > 70 || newRain > 30 || newHumid > 80) {
        JOptionPane.showMessageDialog(null, "This area has hazardous conditions!", "Warning", 
                                    JOptionPane.INFORMATION_MESSAGE, new ImageIcon("images/hazard.png"));
    }
    // }
    
    // Adds weather statistics to the data that's tracked.
    myTemps.add(newTemp);
    myWinds.add(newSpeed);
    myRains.add(newRain);
    myHumids.add(newHumid);
    // Listeners are notified.
    myPcs.firePropertyChange(PROPERTY_UPDATE, myDate, date.format(updateTime));
    myPcs.firePropertyChange(PROPERTY_TEMP, 0, newTemp + " F");
  
    myPcs.firePropertyChange(PROPERTY_WIND, 0, newSpeed);
    myPcs.firePropertyChange(PROPERTY_RAIN, 0, newRain);
    myPcs.firePropertyChange(PROPERTY_HUMID, 0, newHumid);  
  }
  

  /**
   * Convert current temp to C
   * Ai Nguyen, Mercedes Chea
   */
  public void updateCurrentTempToC(String sign) {
	  	//(current-32)*5/9;
	    // Gets new weather statistics
	  	final int newTemp = myTempSensor.getTemp() * 9 / 5 + 32;
	  	

	    // Adds weather statistics to the data that's tracked.
	    myTemps.add(newTemp);

	    // Listeners are notified.
	    myPcs.firePropertyChange(PROPERTY_TEMP, 0, newTemp + sign);
 
  }
  
  /**
   * Convert current temp to F
   * Ai Nguyen, Mercedes Chea
   */
  public void updateCurrentTempToF(String sign) {
	  	//((9*current)/5)+32;
	    // Gets new weather statistics
	  	final int newTemp = ((myTempSensor.getTemp() - 32) * 5 / 9);
	    

	    // Adds weather statistics to the data that's tracked.
	    myTemps.add(newTemp);

	    // Listeners are notified.
	    myPcs.firePropertyChange(PROPERTY_TEMP, 0, newTemp + sign);
 
  }

  @Override
  public void addPropertyChangeListener(final PropertyChangeListener theListener) {
    myPcs.addPropertyChangeListener(theListener);
  }
  
  @Override
  public void addPropertyChangeListener(final String thePropertyName,
                                     final PropertyChangeListener theListener) {
    myPcs.addPropertyChangeListener(thePropertyName, theListener);             
  }
 

  @Override
  public void removePropertyChangeListener(final PropertyChangeListener theListener) {
    myPcs.removePropertyChangeListener(theListener);
  }
  

  @Override
  public void removePropertyChangeListener(final String thePropertyName,
                                             final PropertyChangeListener theListener) {
    myPcs.removePropertyChangeListener(thePropertyName, theListener);
        
  }
}
