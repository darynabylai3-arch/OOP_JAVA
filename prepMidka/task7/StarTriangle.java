package prepMidka.task7;

public class StarTriangle {
    Integer width;

    public StarTriangle(Integer width){
        this.width = width;
    }

    public void makeTri(){
        for(int i=1;i<=width+1;i++){
            System.out.println("[*]".repeat(i-1));
        }
    }
    public static void main(String[] args) {
        StarTriangle triangle = new StarTriangle(5);
        triangle.makeTri();
    }
}