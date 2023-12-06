import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    int snakeSize = 25;
    int titleHeight = 50;
    int gap = snakeSize / 2;
    //store the x and y for snake
    int[] snakeX = new int[200];
    int[] snakeY = new int[200];
    int snakeLength;
    int gameStatus;//0 pause 1 running
    boolean isRunning = false;// status
    int direction; //0 up 1 right 2 down 3 left
    Timer timer;
    int foodX;
    int foodY;

    public void initSnake()
    {
        initHead();
        initBody();
        direction = 1;
    }

    public GamePanel()
    {
        snakeLength = 3;
        initSnake();
        initFood();
        //set focus on the panel
        this.setFocusable(true);
        //add event listener
        this.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyCode() == 32)
                {

                }
//                System.out.println(e.getKeyCode());
                switch(e.getKeyCode()) {
                    case 32:
                    {
                        isRunning = !isRunning;
                        repaint();
                    }
                    break;
                    case 37:
                    {
                        direction = 3;
                    }
                    break;
                    case 38:
                    {
                        direction = 0;
                    }
                    break;
                    case 39:
                    {
                        direction = 1;
                    }
                    break;
                    case 40:
                    {
                        direction = 2;
                    }
                    break;
                }
            }
        });
        timer = new Timer(100, new ActionListener()
        {
            //action event listener, every delay time, it will listen
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (isRunning)
                {
                    moving();
                }
            }
        });
        timer.start();
    }

    private void initFood()
    {
        foodX = (int)(Math.random() * 700) + 50;
        foodY = (int)(Math.random() * 700) + 120;
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
        g.setColor(new Color(255, 255, 255));
        g.fillRect(gap, gap, Main.width - (gap * 3), titleHeight);
        //set font
        g.setColor(new Color(0, 0, 0));
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Snake", 340, 45);
        //draw rect
        g.setColor(new Color(186, 186, 186));
        g.fillRect(gap, gap * 2 + titleHeight, Main.width - gap * 3, Main.height - gap * 5 - titleHeight);

        //draw food
        Images.foodIcon.paintIcon(this, g, foodX, foodY);
        System.out.println(foodX);
        System.out.println(foodY);
        switch (direction)
        {
            case 0 -> Images.upIcon.paintIcon(this, g, snakeX[0], snakeY[0]);
            case 1 -> Images.headIcon.paintIcon(this, g, snakeX[0], snakeY[0]);
            case 2 -> Images.downIcon.paintIcon(this, g, snakeX[0], snakeY[0]);
            case 3 -> Images.leftIcon.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        for (int i = 1; i < snakeLength; i++)
        {
            Images.bodyIcon.paintIcon(this, g, snakeX[i], snakeY[i]);
        }
        if (!isRunning)
        {
            g.setColor(new Color(114, 98, 255));
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("Press blank to start!", 150, 400);
        }
//        moveRight();
    }

    private void moving()
    {
        //moving body from last to the 1st part
        for (int i = snakeLength - 1; i > 0; i--)
        {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }
        //moving head
        switch (direction)
        {
            case 0 -> snakeY[0] = snakeY[0] < gap * 3 + titleHeight ? Main.height - gap * 2 : snakeY[0] - 25;
            case 1 -> snakeX[0] = snakeX[0] > Main.width - gap * 3 ? gap : snakeX[0] + 25;
            case 2 -> snakeY[0] = snakeY[0] > Main.height - gap * 3 ? gap * 2 + titleHeight : snakeY[0] + 25;
            case 3 -> snakeX[0] = snakeX[0] < gap ? Main.width - gap * 3 : snakeX[0] - 25;
        }
        repaint();
    }
}
