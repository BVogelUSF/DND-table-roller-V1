public class Resource extends Basic{
    private int quantity;
    private String tag;

    public Resource(String inName, int inMin, int inMax, int inQuan, String inTag) {
        super(inName, inMin, inMax);
        setQuantity(inQuan);
        setTag(inTag);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getTag() {
        return tag;
    }
}
