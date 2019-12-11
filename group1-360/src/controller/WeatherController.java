/*
 * TCSS 360 Autumn 2019
 * Instructor: Kivanc Dincer,
 * WeatherController.java - A controller for the Weather System.
 */

package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.ObservableWeather;
import model.PropertyChangeEnabledWeatherControls;
import view.DateTimeLabel;
import view.WeatherView;


/**
 * A GUI controller for allowing the user to use the weather system.
 * 
 * @author Brent O'Neill
 * @version 6 December 2019
 *
 */
public class WeatherController extends JPanel {
  /** The delay in the date timer for sending events. */
  private static final int DATE_TIMER_FREQUENCY = 30;
  /** The delay in the weather timer for sending events. */
  private static final int WEATHER_UPDATE_FREQ = 10000;
  /** A generated serial ID for the GUI. */
  private static final long serialVersionUID = -5349136816220577100L;
  /** A weather control object. */
  private PropertyChangeEnabledWeatherControls myWeather;
  /** The timer to control how often to advance the date/time. */ 
  private final Timer myDateTimer;
  /** The timer to control how often to update the weather. */
  private final Timer myWeatherTimer;
  
  /**
   * A constructor that builds a weather controller object.
   *
   * @param theWeather The weather object this class controls.
   */
  public WeatherController(final PropertyChangeEnabledWeatherControls theWeather) {
    // Sets the layout
    super(new BorderLayout());
    // Declares the race model object
    myWeather = theWeather;
    // Declares the actions for the timers.
    myWeatherTimer = new Timer(DATE_TIMER_FREQUENCY, this::handleWeather);
    myDateTimer = new Timer(DATE_TIMER_FREQUENCY, this::handleDateTimer);
  }
    
  /**
   * Handles the date/time timer when the timer starts.
   * 
   * @param theEvent An ActionEvent that occurs when the timer starts.
   */
  private void handleDateTimer(final ActionEvent theEvent) {
    myWeather.changeDateTime();
  }
  
  /**
   * Handles the weather update when the timer starts.
   * 
   * @param theEvent An ActionEvent that occurs when the timer starts.
   */
  private void handleWeather(final ActionEvent theEvent) {
    myWeather.updateWeather();
  }
 
  /**
   * Starts the GUI window.
   */
  public static void start() {
    //Create and set up the window.
    final JFrame frame = new JFrame("Weather System");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Instantiate the weather model object
    final ObservableWeather weather = new ObservableWeather();
    // Creates and sets up a pane
    final WeatherController pane = new WeatherController(weather);
    // Starts the timers
    pane.myDateTimer.start();
    // The weather timer starts with a low frequency so that it displays
    // statistics when the program loads, then the frequency is changed
    // to only update every 10 seconds. 
    pane.myWeatherTimer.start();
    pane.myWeatherTimer.setDelay(WEATHER_UPDATE_FREQ);
    // The date portion and the statistics portion of the GUI are created.
    final DateTimeLabel time = new DateTimeLabel();
    final WeatherView stats = new WeatherView();
    // A blank panel to fill the grid layout.
    final JPanel blank = new JPanel();
    blank.setPreferredSize(new Dimension(300, 30));
    // A panel to put in our components. It has a grid layout arranged in a 3x3.
    final JPanel content = new JPanel();
    content.setLayout(new GridLayout(3, 3));
    
    // The date and time need to listen to changes in the weather/time. 
    weather.addPropertyChangeListener(
        PropertyChangeEnabledWeatherControls.PROPERTY_DATE, time);
    // The statistics need to listen for changes in the weather.
    weather.addPropertyChangeListener(
        PropertyChangeEnabledWeatherControls.PROPERTY_UPDATE, stats);
    weather.addPropertyChangeListener(
        PropertyChangeEnabledWeatherControls.PROPERTY_TEMP, stats);
    weather.addPropertyChangeListener(
        PropertyChangeEnabledWeatherControls.PROPERTY_WIND, stats);
    weather.addPropertyChangeListener(
        PropertyChangeEnabledWeatherControls.PROPERTY_RAIN, stats);
    weather.addPropertyChangeListener(
        PropertyChangeEnabledWeatherControls.PROPERTY_HUMID, stats);
     
    // Adding panels to the GUI, the blanks are to put the panels in the
    // right places of a 3x3 grid. 
    content.add(blank);
    content.add(blank);
    content.add(time);
    content.add(stats);
    content.add(blank);
    content.add(blank);
    content.add(blank);
    content.add(blank);
    content.add(blank);
     
    // Adds the content panel to the frame. 
    frame.add(content);
    frame.setLocationRelativeTo(null);
    // Display the window. It cannot be resized and is only as 
    // large as it needs to be.
    frame.pack();       
    frame.setResizable(false);
    frame.setVisible(true);
  }
}
