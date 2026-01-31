package lab2;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour , int minute , int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public String toUniversal(){
        StringBuilder s = new StringBuilder();
        if(hour>24 | minute >60 | second>60){
        s.append("invalid syntax");
        return s.toString();
    }
        s.append(String.format("%02d", hour)).append(":")
        .append(String.format("%02d", minute)).append(":")
        .append(String.format("%02d", second));
        return s.toString();
    }

    public String toStandard(){
    
    StringBuilder s = new StringBuilder();
    if(hour>24 | minute >60 | second>60){
        s.append("invalid syntax");
        return s.toString();
    }
    if(hour >= 12){
        s.append(String.format("%02d", hour)).append(":")
         .append(String.format("%02d", minute)).append(":")
         .append(String.format("%02d", second)).append(" PM");
    } else {
        s.append(String.format("%02d", hour)).append(":")
         .append(String.format("%02d", minute)).append(":")
         .append(String.format("%02d", second)).append(" AM");
    }

    return s.toString();
}

    public static void main(String[] args){
    Time t = new Time(32, 5, 6);
    System.out.println(t.toStandard());
}

}
