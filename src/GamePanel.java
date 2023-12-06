import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Purpose:             PACKAGE_NAME<br />
 * Data Submitted:      2023/12/5 <br />
 * Assignment Number:    PACKAGE_NAME<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          PACKAGE_NAME <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class GamePanel extends JPanel
{
    //store the x and y for snake
    int[] snakeX = new int[200];
    int[] snakeY = new int[200];
    int snakeLength;
    int gameStatus;//0 pause 1 running
    boolean isRunning = false;// status
    int direction; //0 up 1 right 2 down 3 left
    public void initSnake(){
        initHead();
        initBody();
        direction = 1;
    }

    public GamePanel()
    {
        snakeLength = 3;
        initSnake();
        //set focus on the panel
        this.setFocusable(true);
        //add event listener
        this.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode() == 32){
                    isRunning = !isRunning;
//                    System.out.println(isRunning);
                    repaint();
                }
            }
        });
    }

    private void initBody()
    {
        snakeX[1] = 150;
        snakeY[1] = 275;
        snakeX[2] = 125;
        snakeY[2] = 275;
    }

    private void initHead()
    {
        snakeX[0] = 175;
        snakeY[0] = 275;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        //it's like gui's main method, automatically called by jvm
        super.paintComponent(g);
        this.setBackground(new Color(174, 134, 198));
        //draw title
//        Images.titleIcon.paintIcon(this,g,150,10);
        g.setColor(new Color(255,255,255));
        g.fillRect(10,10,770,50);
        //set font
        g.setColor(new Color(0,0,0));
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Snake",340,45);
        //draw rect
        g.setColor(new Color(186, 186, 186));
        g.fillRect(10,70,770,685);

        switch (direction){
            case 0 -> Images.upIcon.paintIcon(this,g,snakeX[0],snakeY[0]);
            case 1 -> Images.headIcon.paintIcon(this,g,snakeX[0],snakeY[0]);
            case 2 -> Images.downIcon.paintIcon(this,g,snakeX[0],snakeY[0]);
            case 3 -> Images.leftIcon.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        for (int i = 1; i < snakeLength; i++)
        {
            Images.bodyIcon.paintIcon(this,g,snakeX[i],snakeY[i]);
        }
        if(!isRunning){
            g.setColor(new Color(114,98,255));
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("Press blank to start!",150,400);
        }
    }
}
