package tommy.naivedialog;

/**
 * @author : Tommy
 */
public class DialogType {

    private Type type;

    private String typeName;

    public DialogType(Type type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
