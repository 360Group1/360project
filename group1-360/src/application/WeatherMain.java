/*
 * TCSS 360 Autumn 2019
 * Instructor: Kivanc Dincer,
 * WeatherMain.java - A main method for launching the raceday project.
 */

package application;

import controller.WeatherController;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



/**
 * A main application that launches a Weather System.
 * 
 * @author Brent O'Neill
 * @version  5 December 2019
 */
public final class WeatherMain {
    
  /**
   * Private empty constructor to avoid accidental instantiation. 
   */
  private WeatherMain() { }
    
  /**
   * Creates JFrame to demonstrate the panel. 
   * 
   * @param theArgs Comment line arguments.
   */
  public static void main(final String[] theArgs) {
    // Sets the layout
    try {
      UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    } catch (final UnsupportedLookAndFeelException ex) {
      ex.printStackTrace();
    } catch (final IllegalAccessException ex) {
      ex.printStackTrace();
    } catch (final InstantiationException ex) {
      ex.printStackTrace();
    } catch (final ClassNotFoundException ex) {
      ex.printStackTrace();
    }
    /* Turn off metal's use of bold fonts */
    //UIManager.put("swing.boldMetal", Boolean.FALSE);
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            WeatherController.start();
        }
    });            
  }
}
