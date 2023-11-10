public class Enemy extends Basic {
    private int easy;
    private int medium;
    private int hard;
    private int deadly;
    private String tag;

    public Enemy(String inName, int inMin, int inMax,
                int inE, int inM, int inH, int inD, String inTag) {
        super(inName, inMin, inMax);
        setEasy(inE);
        setMedium(inM);
        setHard(inH);
        setDeadly(inD);
        setTag(inTag);
    }


    public void setEasy(int easy) {
        this.easy = easy;
    }
    public int getEasy() {
        return easy;
    }

    public void setMedium(int medium) {
        this.medium = medium;
    }
    public int getMedium() {
        return medium;
    }

    public void setHard(int hard) {
        this.hard = hard;
    }
    public int getHard() {
        return hard;
    }

    public void setDeadly(int deadly) {
        this.deadly = deadly;
    }
    public int getDeadly() {
        return deadly;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getTag() {
        return tag;
    }
}
