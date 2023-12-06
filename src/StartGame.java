import javax.swing.*;
import java.awt.*;

/**
 * Purpose:             <br />
 * Data Submitted:      2023/12/5 <br />
 * Assignment Number:    <br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:           <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class StartGame
{
    //window size
    final static int width = 800;
    final static int height = 800;
    public static void main(String[] args)
    {
        JFrame jf = createWindow();
        GamePanel gp = new GamePanel();
        jf.add(gp);
    }
    private static JFrame createWindow(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int left = (screenSize.width - width) / 2;
        int top = (screenSize.height - height) / 2;
        //create a window using java gui
        JFrame jf = new JFrame();
        //set window title
        jf.setTitle("Snake Game");
//        jf.setLayout(null);
        //set the window attributes
        jf.setBounds(left, top, width, height);
        jf.setResizable(false);
        //set close window and terminal the app
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //set the window visible
        jf.setVisible(true);
        return jf;
    }
}