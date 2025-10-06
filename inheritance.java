class shape {
    public void area() {
        System.out.println("displayd area  ");
    }
}

class circle extends shape {
    int r;
    circle(int r){
        this.r = r;
    }
    public void area(){
        
        System.out.println("area of circlr : " + (3.14)*r*r);
    }
}

class rectangle extends shape {
    int l,b;
    rectangle(int l , int b){
        this.b = b;
        this.l = l;
    }
    public void area() {
        System.out.println(" area of rectangle : "+ l*b);
    }
}



public class inheritance {
    public static void main(String[] args) {
        shape s1 = new circle(3);
        s1.area();

        shape s2 = new rectangle(3,5);
        s2.area();
        
    }
    
}
