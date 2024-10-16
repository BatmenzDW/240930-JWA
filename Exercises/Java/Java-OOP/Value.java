public enum Value {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10", "a"),
    JACK("J", "b"),
    QUEEN("Q", "c"),
    KING("K", "d"),
    ACE("A", "1");

    private final String value;
    private final String suffix;

    Value(String value, String suffix){
        this.value = value;
        this.suffix = suffix;
    }

    Value(String value){
        this.value = value;
        this.suffix = value;
    }

    public String getValue(){
        return value;
    }

    public String getSuffix(){
        return suffix;
    }
}
