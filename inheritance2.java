class car {
    String company ;
    int modelyear ;
    

    car(){
        this("unknown");
        System.out.println("no argument constructor");

    }

    car(String company){
        this(company ,0);
        System.out.println("one argument constructor");

    }

    car(String company , int modelyear){
        this.company=company;
        this.modelyear=modelyear;
        System.out.println("three argument constructor");

    }

    public void displayinfo(){
        System.out.println("brand : "+ company);
        System.out.println("model year : "+ modelyear);
    }


}



public class inheritance2 {
    public static void main(String[] args) {
        car c = new car();
        c.displayinfo();

        car c2 = new car("toyta");
        c2.displayinfo();

        car c3 = new car("toyta",2012);
        c3.displayinfo();
    }
    
}
