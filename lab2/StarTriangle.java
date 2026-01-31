package lab2;

public class StarTriangle {
    private int width; 

    public StarTriangle(int width){
        this.width = width;
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder;
        
        for(int i=1;i<width;i++){
            s.append("[*]".repeat(i)).append("\n")
        }
        return s.toString();
    }
    
}
