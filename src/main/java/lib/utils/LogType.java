package lib.utils;

public enum LogType {
    WARNING(1,"WARNING"),
    ERROR(2, "ERROR"),
    MESSAGE(3, "MESSAGE");

    private final int id;
    private final String name;

    LogType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }
}
