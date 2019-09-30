import java.util.Scanner;

public class Application{
    public static void main(String[] args){
       // String array[] = new String[3];
        Scanner scnr = new Scanner(System.in);

        //Change i <= 3
        for (int i = 1; i <= 1; i++){
            System.out.println("Enter X-Coorinate " + i + ":");
            int xVal = scnr.nextInt();
            System.out.println("Enter Y-Coorinate " + i + ":");
            int yVal = scnr.nextInt();
            System.out.println("Enter radii " + i + ":");
            double radius = scnr.nextInt();
            System.out.println("Enter height " + i + ":");
            double height = scnr.nextInt();

           Point newPoint = new Point(xVal,yVal);
           Circle newCircle = new Circle(newPoint.getXValue(),newPoint.getYValue(), radius);
           Cylinder newCylinder = new Cylinder(newCircle.getXValue(), newCircle.getYValue(), newCircle.getRadius(), height);
           System.out.println(newCylinder.toString());

           scnr.close();
        }
    }

}