/*
 * TCSS 360 Autumn 2019
 * Instructor: Kivanc Dincer,
 * WeatherTimeView.java - A panel for viewing weather statistics.
 */

package view;

import static model.PropertyChangeEnabledWeatherControls.PROPERTY_HUMID;
import static model.PropertyChangeEnabledWeatherControls.PROPERTY_RAIN;
import static model.PropertyChangeEnabledWeatherControls.PROPERTY_TEMP;
import static model.PropertyChangeEnabledWeatherControls.PROPERTY_UPDATE;
import static model.PropertyChangeEnabledWeatherControls.PROPERTY_WIND;

import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A GUI panel for viewing the weather statistics. 
 * 
 * @author Brent O'Neill
 * @version 6 December 2019
 *
 */
public class WeatherView extends JPanel implements PropertyChangeListener {
  /** A serial ID for the GUI. */
  private static final long serialVersionUID = 5857015317561000946L;
  /** A label for the last update date. */
  private JLabel myUpdateLbl;
  /** A label for the temperature. */
  private JLabel myTempLbl;
  /** A label for the wind speed. */
  private JLabel myWindLbl;
  /** A label for the rain total. */
  private JLabel myRainLbl;
  /** A label for the humidity. */
  private JLabel myHumidLbl;
  
  /**
   * A constructor for the weather GUI Panel. 
   */
  public WeatherView() {
    // The labels are stacked on top of each other with 5px of vertical padding.
    super((new GridLayout(5, 1, 0, 5)));
    // The labels are initialized. 
    myUpdateLbl = new JLabel("Last Updated on: ");
    myTempLbl = new JLabel("Temperature: ");
    myWindLbl = new JLabel("Wind Speed: ");
    myRainLbl = new JLabel("Rain Total: ");
    myHumidLbl = new JLabel("Humidity: ");
    // Add components to the panel. 
    this.add(myUpdateLbl);
    this.add(myTempLbl);
    this.add(myWindLbl);
    this.add(myRainLbl);
    this.add(myHumidLbl);
  }
  
  @Override
  public void propertyChange(PropertyChangeEvent theEvent) {
    // Gets notified of property changes and updates labels. 
    if (PROPERTY_TEMP.equals(theEvent.getPropertyName())) {
      myTempLbl.setText("Temperature: " + theEvent.getNewValue() + " degrees F");
    } else if (PROPERTY_WIND.equals(theEvent.getPropertyName())) {
      myWindLbl.setText("Wind Speed: " + theEvent.getNewValue() + "mph");
    } else if (PROPERTY_RAIN.equals(theEvent.getPropertyName())) {
      myRainLbl.setText("Rain Total: " + theEvent.getNewValue() + "mm");
    } else if (PROPERTY_HUMID.equals(theEvent.getPropertyName())) {
      myHumidLbl.setText("Humidity: " + theEvent.getNewValue() + "%");
    } else if (PROPERTY_UPDATE.equals(theEvent.getPropertyName())) {
      myUpdateLbl.setText("Last Updated on: " + theEvent.getNewValue());
    }
    
  }

}
