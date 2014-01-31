import java.io.*;
import java.text.*;
import java.util.*;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.MouseInfo;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


public class Action implements Serializable {
	private int type;
	private int target;
	private int dir;
	
	public Action(int atype, int atarget, int adir) {
		this.type=atype;
		this.target=atarget;
		this.dir=adir;
	}
	public String toString() {
		return String.format("[%d:%d:%d]",type,target,dir);
	}
	public void execute() {
		if(type==0) {
			//keyboard code
		} else if(type==1) {
			//mouseclick code
		} else if(type==2) {
			//mousemove code
		}
	}
}