package immutable;

public final class SomeClass {
    private final String strField;
    private final int intField;
    private final SomePojo somePojo;

    public SomeClass(final String strField, final int intField, final SomePojo somePojo) {
        this.strField = strField;
        this.intField = intField;
        SomePojo newPojo = new SomePojo(somePojo.getStrValue(), somePojo.getIntValue());
        this.somePojo = newPojo;
    }

    public String getStrField() {
        return strField;
    }

    public int getIntField() {
        return intField;
    }

    public SomePojo getSomePojo() {

        return new SomePojo(somePojo.getStrValue(), somePojo.getIntValue());
    }

    @Override
    public String toString() {
        return "SomeClass{" +
                "strField='" + strField + '\'' +
                ", intField=" + intField +
                ", somePojo=" + somePojo +
                '}';
    }
}
