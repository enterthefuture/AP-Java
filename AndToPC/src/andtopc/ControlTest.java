/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package andtopc;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.MouseInfo;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 *
 * @author 2015-15
 */
public class ControlTest {
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();

				
			System.out.println(new Action(0,"mouse",1).toString());
            // Simulate a mouse click
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
			
			//move mouse relative to current position
			int x = (int)MouseInfo.getPointerInfo().getLocation().getX();
			int y = (int)MouseInfo.getPointerInfo().getLocation().getY();
            robot.mouseMove(x+20,y+20);
            // Simulate a key press
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
