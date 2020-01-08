import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;

public class Victim{
	private int px,py; //position of the Victim object
	private int LH,HS,EB; //love/hate, happiness/sadness and excitement/boredom values
	
	//constructor
	public Victim(int x, int y, int loHa,int haSa, int exBo){
		px = x;
		py = y;
		LH = loHa;
		HS = haSa;
		EB = exBo;
	}
	
	public int getR(){
		double  r = (LH+100.0)/200.0*255.0;
		return (int)r;
	}
	public int getG(){
		double g = (HS+100.0)/200.0*255.0;
		return (int)g;
	}
	public int getB(){
		double b = (EB+100.0)/200.0*255.0;
		return (int) b;
	}
	public int getX(){
		return px;
	}
	
	public int getY(){
		return py;
	}
}