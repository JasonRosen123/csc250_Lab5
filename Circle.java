import java.text.DecimalFormat;

public class Circle extends Point{
    private double radius;

    public Circle(int xVal, int yVal, double inputRadius){
        
        super(xVal,yVal);
        setRadius(inputRadius);

    }

    public Circle(){
        this.radius =  0.0;
    }

    public double getRadius(){
       return radius;
    }
    
    public void setRadius(double inRadius){
        if (inRadius >= 0){
            radius = inRadius;
        }
        else{
            System.out.println("Error: radius is a negative value. Radius not saved.");
        }
    }

    public double userArea(){
        return (getRadius()*getRadius()*3.14);
    }

    @Override
    public String toString(){
       DecimalFormat df = new DecimalFormat("#.##");
       System.out.println(super.toString());
       return "*******Circle********\nRadius: " + radius + "\nArea of Circle: "+df.format(userArea());

    }
}