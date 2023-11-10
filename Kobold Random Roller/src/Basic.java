public class Basic {
    private String name;
    private int minimum;
    private int maximum;

    public Basic(String inName, int inMin, int inMax){
        setName(inName);
        setMinimum(inMin);
        setMaximum(inMax);
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }
    public int getMinimum() {
        return minimum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }
    public int getMaximum() {
        return maximum;
    }
}
