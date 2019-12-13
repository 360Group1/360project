/*
 * TCSS 360 Autumn 2019
 * Instructor: Kivanc Dincer,
 * PropretyChangeEnabledWeatherControls.java - An interface for the weather model.
 */

package model;

import java.beans.PropertyChangeListener;

/**
 * Defines behaviors allowing PropertyChangeListeners to be added or removed from a 
 * WeatherControls object. Implementing classes need to tell PropertyChangeListeners
 * when methods defined in WeatherControls mutate the state of the Weather. Documentation
 * provided by Charles Bryan's 305 demonstration.
 * 
 * @author Brent O'Neill
 * @version 6 December 2019
 *
 */
public interface PropertyChangeEnabledWeatherControls extends WeatherControls {
  /** A property name for the time. */
  String PROPERTY_DATE = "The current date";
  /** A property name for the temperature. */
  String PROPERTY_TEMP = "The current temp";
  /** A property name for the wind speed. */
  String PROPERTY_WIND = "The current wind speed";
  /** A property name for the rain total. */
  String PROPERTY_RAIN = "The current rain total";
  /** A property name for the humidity. */
  String PROPERTY_HUMID = "The current humidity";
  /** A property name for the updated date. */
  String PROPERTY_UPDATE = "The last time it was updated";
  String PROPERTY_SETTING = "Setting";
  /**
    * Add a PropertyChangeListener to the listener list. The listener is registered for 
    * all properties. The same listener object may be added more than once, and will be 
    * called as many times as it is added. If listener is null, no exception is thrown and 
    * no action is taken.
    * 
    * @param theListener The PropertyChangeListener to be added
    */
  void addPropertyChangeListener(PropertyChangeListener theListener);
    
    
  /**
    * Add a PropertyChangeListener for a specific property. The listener will be invoked only 
    * when a call on firePropertyChange names that specific property. The same listener object
    * may be added more than once. For each property, the listener will be invoked the number 
    * of times it was added for that property. If propertyName or listener is null, no 
    * exception is thrown and no action is taken.
    * 
    * @param thePropertyName The name of the property to listen on.
    * @param theListener The PropertyChangeListener to be added
    */
  void addPropertyChangeListener(String thePropertyName, PropertyChangeListener theListener);

  /**
    * Remove a PropertyChangeListener from the listener list. This removes a 
    * PropertyChangeListener that was registered for all properties. If listener was added 
    * more than once to the same event source, it will be notified one less time after being 
    * removed. If listener is null, or was never added, no exception is thrown and no action 
    * is taken.
    * 
    * @param theListener The PropertyChangeListener to be removed
    */
  void removePropertyChangeListener(PropertyChangeListener theListener);
    
  /**
    * Remove a PropertyChangeListener for a specific property. If listener was added more than
    * once to the same event source for the specified property, it will be notified one less 
    * time after being removed. If propertyName is null, no exception is thrown and no action 
    * is taken. If listener is null, or was never added for the specified property, no 
    * exception is thrown and no action is taken.
    * 
    * @param thePropertyName The name of the property that was listened on.
    * @param theListener The PropertyChangeListener to be removed
    */
  void removePropertyChangeListener(String thePropertyName, 
                                      PropertyChangeListener theListener);
}
