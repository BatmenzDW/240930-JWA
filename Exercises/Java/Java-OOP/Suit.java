public enum Suit {
    CLUB("\u2663", ColorUtil.BLACK, "d"),
    SPADE("\u2660", ColorUtil.BLACK, "a"),
    HEART("\u2665", ColorUtil.RED, "b"),
    DIAMOND("\u2666", ColorUtil.RED, "c");

    private final String symbol;
    private final String color;
    private final String suffix;

    Suit(String symbol, String color, String suffix){
        this.symbol = symbol;
        this.color = color;
        this.suffix = suffix;
    }

    public String getSymbol(){
        return symbol;
    }

    public String getColor(){
        return color;
    }

    public String getSuffix(){
        return suffix;
    }
}
