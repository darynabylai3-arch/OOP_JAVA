package midTermPrep.task4;

public enum Days {
    MONDAY,TUESDAY,WEDNESDAY,SATURDAY,SUNDAY;


    public String getType(){
        if(this == SATURDAY || this == SUNDAY){
            return "weeekend!!!";
        }
        else{
            return "not weekend;(";
        }
    }
}
