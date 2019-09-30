//Point class is the parent class for the Circle and Cylinder Class's. The purpose is to set a point to the passed obj

public class Point{
    //privatly passes x and y values
    private int xValue;
    private int yValue;
    
    //constructor which defined the point coordinates to (0,0)
    public Point(int xVal, int yVal){
        super();
        this.xValue = xVal;
        this.yValue = yVal;
    }
    //Defining constructior for the Child Classes
    public Point(){
        super();
    }
    //method that sets the X val of the obj
    public void setXValue(int xVal){
        xValue = xVal;
    }
    //method that returns the X val of the obj
    public int getXValue(){
        return xValue;
    }
    //method that sets the Y val of the obj
    public void setYValue(int yVal){
        yValue = yVal;
    }
    //method that returns the Y val of the obj
    public int getYValue(){
        return yValue;
    }
    //Print string that returns the X and Y coordinates in the form "(X,Y)"
    @Override
    public String toString(){
        String coordinatePrint = "******Coorinate******\nCoordinate:(" + xValue + ", " + yValue + ")";
        return coordinatePrint;
    }
}