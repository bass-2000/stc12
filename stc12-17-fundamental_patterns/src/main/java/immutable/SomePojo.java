package immutable;

public class SomePojo {
    private String strValue;
    private Integer intValue;

    public SomePojo(String strValue, Integer intValue) {
        this.strValue = strValue;
        this.intValue = intValue;
    }

    public String getStrValue() {
        return strValue;
    }

    public void setStrValue(String strValue) {
        this.strValue = strValue;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    @Override
    public String toString() {
        return "SomePojo{" +
                "strValue='" + strValue + '\'' +
                ", intValue=" + intValue +
                '}';
    }
}