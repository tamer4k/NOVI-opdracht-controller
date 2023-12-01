package nl.tv.NOVIopdrachtcontroller.model;

public enum AvailableSize {
    SMALL(49),
    MEDIUM(55),
    LARGE(65);
    private final int value;
    AvailableSize(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public static AvailableSize fromValue(int value) {
        for (AvailableSize size : values()) {
            if (size.getValue() == value) {
                return size;
            }
        }
        throw new IllegalArgumentException("Unknown AvailableSize with value: " + value);
    }
}
