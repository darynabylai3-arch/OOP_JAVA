package task3;
public class Temperature {
    private double value;
    private char scale;
    
    public Temperature() {
        this.value = 0.0;
        this.scale = 'C';
    }
    
    public Temperature(double value) {
        this.value = value;
        this.scale = 'C';
    }
    
    public Temperature(char scale) {
        this.value = 0.0;
        this.scale = scale;
    }
    
    public Temperature(double value, char scale) {
        this.value = value;
        this.scale = scale;
    }
    
    public double getCelsius() {
        if (scale == 'C') {
            return value;
        } else {
            return 5.0 * (value - 32) / 9.0;
        }
    }
    
    public double getFahrenheit() {
        if (scale == 'F') {
            return value;
        } else {
            return 9.0 * (value / 5.0) + 32;
        }
    }
    
    public void setValue(double value) {
        this.value = value;
    }
    
    public void setScale(char scale) {
        this.scale = scale;
    }
    
    public void setBoth(double value, char scale) {
        this.value = value;
        this.scale = scale;
    }
    
    public char getScale() {
        return scale;
    }
}
