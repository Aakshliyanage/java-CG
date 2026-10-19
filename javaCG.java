//DDA Line Drawing

package practise;

import java.awt.*;
import javax.swing.*;

public class DDALineDrawing extends JPanel{
	
	public void paint(Graphics g) {
		int x1 = 50, y1 = 50;
		int x2 = 350, y2 = 300;
		
		drawDDA(g,x1,y1,x2,y2);
	}
	
	public void drawDDA(Graphics g,int x1,int y1,int x2,int y2) {
		int dx = x2-x1;
		int dy = y2-y1;
		
		int steps = Math.max(Math.abs(dx), Math.abs(dy));
		
		float x_inc = (float) dx/steps;
		float y_inc = (float) dy/steps;
		
		float x= x1;
		float y = y1;
		
		for(int i=0;i<=steps;i++){
			g.fillRect(Math.round(x), Math.round(y),2, 2);
			x += x_inc;
			y += y_inc;
		}
	}
	
	public static void main(String[]args) {
		JFrame frame = new JFrame("DDA Line Drawing Algorithm");
		
		DDALineDrawing panel = new DDALineDrawing();
		
		frame.add(panel);
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(frame);
		frame.setVisible(true);
	}
}

//Bresenham Line Drawing

package practise;
import java.awt.*;
import javax.swing.*;

public class BresenhamLine extends JPanel{
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		int x1 = 50 , y1 = 50;
		int x2 = 350, y2 = 300;
		
		bresenham(g,x1,y1,x2,y2);
		
	}
	
	public void bresenham(Graphics g,int x1,int y1,int x2,int y2) {
		
		int dx = Math.abs(x2-x1);
		int dy = Math.abs(y2-y1);
		
		int sx = (x1<x2) ? 1 : -1;
		int sy = (y1<y2) ? 1 : -1;
		
		int err = dx - dy;
		
		while(true) {
			
			g.fillRect(x1, y1, 2, 2);
			
			if(x1 == x2 && y1 == y2) break;
			
			int e2 = err*2;
			
			if(e2 > -dy) {
				err -= dy;
				x1 += sx;
			}
			if(e2 < dx) {
				err += dx;
				y1 += sy;
			}
		}
	}
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Bresenham Line Drawing Algorithm");
		
		BresenhamLine panel = new BresenhamLine();
		frame.add(panel);
		
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}

//Midpoint circle

package practise;

import java.awt.*;
import javax.swing.*;

public class practise1 extends JPanel {

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int xc = 200, yc = 200;
        int r = 100;

        drawCircle(g, xc, yc, r);
    }

    private void drawCircle(Graphics g, int xc, int yc, int r) {

        int x = 0, y = r;
        int p = 1 - r;

        plotPoints(g, xc, yc, x, y);

        while (x < y) {
            x++;

            if (p < 0) {
                p += 2 * x + 1;
            } else {
                y--;
                p += 2 * (x - y) + 1;
            }

            plotPoints(g, xc, yc, x, y);
        }
    }

    private void plotPoints(Graphics g, int xc, int yc,
                            int x, int y) {

        g.fillRect(xc + x, yc + y, 2, 2);
        g.fillRect(xc - x, yc + y, 2, 2);
        g.fillRect(xc + x, yc - y, 2, 2);
        g.fillRect(xc - x, yc - y, 2, 2);

        g.fillRect(xc + y, yc + x, 2, 2);
        g.fillRect(xc - y, yc + x, 2, 2);
        g.fillRect(xc + y, yc - x, 2, 2);
        g.fillRect(xc - y, yc - x, 2, 2);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Bresenham Circle Drawing");

        practise1 panel = new practise1();
        frame.add(panel);

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

//Bresenham circle drawing

package practise;

import java.awt.*;
import javax.swing.*;

public class practise1 extends JPanel {

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int xc = 200, yc = 200;
        int r = 100;

        drawBresenhamCircle(g, xc, yc, r);
    }

    private void drawBresenhamCircle(
            Graphics g, int xc, int yc, int r) {

        int x = 0, y = r;
        int d = 3 - 2 * r;

        while (x <= y) {
            plotPoints(g, xc, yc, x, y);

            if (d < 0) {
                d += 4 * x + 6;
            } else {
                d += 4 * (x - y) + 10;
                y--;
            }

            x++;
        }
    }

    private void plotPoints(Graphics g, int xc, int yc,
                            int x, int y) {

        g.fillRect(xc + x, yc + y, 2, 2);
        g.fillRect(xc - x, yc + y, 2, 2);
        g.fillRect(xc + x, yc - y, 2, 2);
        g.fillRect(xc - x, yc - y, 2, 2);

        g.fillRect(xc + y, yc + x, 2, 2);
        g.fillRect(xc - y, yc + x, 2, 2);
        g.fillRect(xc + y, yc - x, 2, 2);
        g.fillRect(xc - y, yc - x, 2, 2);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Bresenham Circle Drawing");

        practise1 panel = new practise1();
        frame.add(panel);

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
 