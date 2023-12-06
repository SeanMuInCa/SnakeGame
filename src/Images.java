import javax.swing.*;
import java.net.URL;

/**
 * Purpose:             pictures<br />
 * Data Submitted:      2023/12/5 <br />
 * Assignment Number:    PACKAGE_NAME<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          PACKAGE_NAME <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class Images
{
    //all the images have to become an object first, that is the key thought of OOP.
    //encapsulate the body's url
    public static URL bodyUrl = Images.class.getResource("/images/body.png");//build first then you have the out.
    //encapsulate the body into an object
    public static ImageIcon bodyIcon = new ImageIcon(bodyUrl);

    //encapsulate the head's url
    public static URL headUrl = Images.class.getResource("/images/head.png");//build first then you have the out.
    //encapsulate the image into an object
    public static ImageIcon headIcon = new ImageIcon(headUrl);

    //encapsulate the food's url
    public static URL foodUrl = Images.class.getResource("/images/food.png");//build first then you have the out.
    //encapsulate the image into an object
    public static ImageIcon foodIcon = new ImageIcon(foodUrl);

    //encapsulate the title's url
    public static URL titleUrl = Images.class.getResource("/images/title.png");//build first then you have the out.
    //encapsulate the image into an object
    public static ImageIcon titleIcon = new ImageIcon(titleUrl);



}
