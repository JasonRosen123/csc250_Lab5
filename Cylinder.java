public class Cylinder extends Circle{
    private double height;

    public Cylinder(){
        super();
    }

    public Cylinder(int xVal, int yVal, double inputRadius, double userHeight){
        super(xVal,yVal,inputRadius);
        setHeight(userHeight);
    }

    public double getHeight(){
        return height;
    }

    public void setHeight(double userHeight){
        if (userHeight > 0){
            height = userHeight;
        }
        else{
            System.out.println("Error: height is a negative value. Height not saved.");
        }
    }
    public double getVolume(){
        return (3.14*getRadius()*getRadius()*getHeight());
    }
    @Override
    public String toString(){
        System.out.println(super.toString());
        return "******Cylinder*******\nHeight: " + height + "\nVolume: " + super.df.format(getVolume()) + "\n";
    }
}