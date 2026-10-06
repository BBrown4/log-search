package com.brandon.log_search.event;

public enum Severity {
    EMERGENCY(0),
    ALERT(1),
    CRITICAL(2),
    ERROR(3),
    WARNING(4),
    NOTICE(5),
    INFORMATIONAL(6),
    DEBUG(7);

    private final int code;

    Severity(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
