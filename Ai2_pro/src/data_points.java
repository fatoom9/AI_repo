
import java.awt.Color;
public class data_points{

    private double x;
    private double y;
    private double ya;
    private int yp;
    private int xp;
    private int Class;
    private int lable;
    private Color color;

    public data_points(double x, double y, int Class) {
        super();
        this.x = x;
        this.y = y;
        this.Class = Class;

    }

    public data_points(double x, double y) {
        super();
        this.x = x;
        this.y = y;

    }

    public data_points() {

    }

    public void copy(data_points p) {
        this.x = p.getX();
        this.y = p.getY();
        this.xp = p.getXP();
        this.yp = p.getYP();
        this.ya = p.getYA();
        this.color = p.getColor();
        this.lable = p.getLable();
        this.Class = p.getclass();
    }

    public String toString() {
        return "point [x=" + x + ", y=" + y + "]  Class:" + Class;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getYA() {
        return ya;
    }

    public void setYA(double ya) {
        this.ya = ya;
    }

    public int getXP() {
        return xp;
    }

    public void setXP(int xp) {
        this.xp = xp;
    }

    public int getYP() {
        return yp;
    }

    public void setYP(int yp) {
        this.yp = yp;
    }

    public int getclass() {
        return Class;
    }

    public void setClass(int Class) {
        this.Class = Class;
    }

    public int getLable() {
        return lable;
    }

    public void setLable(int lable) {
        this.lable = lable;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
