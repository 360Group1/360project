/*
 * TCSS 360 Autumn 2019
 * Instructor: Kivanc Dincer,
 * DateTimeView.java - A panel for viewing the date and time.
 */

package view;

import static model.PropertyChangeEnabledWeatherControls.PROPERTY_DATE;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A GUI panel for viewing the date and time. 
 * 
 * @author Brent O'Neill
 * @version 6 December 2019
 *
 */
public class DateTimeLabel extends JPanel implements PropertyChangeListener {
  /** Border around the label. */
  private static final int PADDING = 5;
  /** The generated serial ID. */
  private static final long serialVersionUID = 3443843254248734262L;
  /** A panel to display the date and time. */
  private final JPanel myPanel;
  /** A label for the date. */
  private final JLabel myDateLabel;
  /** A label for the time. */
  private final JLabel myTimeLabel;
  
  /**
   * A constructor for building a date/time panel.
   */
  public DateTimeLabel() {
    super();
    // They are layered in a grid layout.
    myPanel = new JPanel(new GridLayout(0,1));
    // Creating and adding the components.
    myDateLabel = new JLabel(formatDate(LocalDateTime.now()));
    myTimeLabel = new JLabel(formatTime(LocalDateTime.now()));
    myPanel.add(myDateLabel);
    myPanel.add(myTimeLabel);
    setupComponents();
  }
  
  /**
    * A private helper method to create a border.
    */
  private void setupComponents() {
    setLayout(new BorderLayout());        
    final JPanel content = new JPanel();     
    myPanel.setBorder(BorderFactory.createCompoundBorder(
                             BorderFactory.createEtchedBorder(),
                             BorderFactory.createEmptyBorder(PADDING,
                                                             PADDING,
                                                             PADDING,
                                                             PADDING)));
    content.add(myPanel);
    add(content, BorderLayout.EAST);        
  }   
 
  /**
   * A method to format the date into a format DD Month YYYY.
   * 
   * @param theNewDate The date to be formatted.
   * 
   * @return A string of the new date formatted properly.
   */
  public String formatDate(final LocalDateTime theNewDate) {
    DateTimeFormatter date = DateTimeFormatter.ofPattern("dd MMMM yyyy");  
    return "Date: " + date.format(theNewDate); 
  }
  
  /**
   * A method to format the time into a format Hour:Minute:Second.
   * 
   * @param theNewTime The time to be formatted. 
   * 
   * @return A string of the new time formatted properly.
   * 
   */
  public String formatTime(final LocalDateTime theNewTime) {
    DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");  
    return "Time: " + time.format(theNewTime);  
  }

  @Override
  public void propertyChange(PropertyChangeEvent theEvent) {
    // Gets notified of a property change and changes labels.
    if (PROPERTY_DATE.equals(theEvent.getPropertyName())) {
      myDateLabel.setText((formatDate((LocalDateTime) theEvent.getNewValue())));
      myTimeLabel.setText((formatTime((LocalDateTime) theEvent.getNewValue())));
    }  
  }

}
