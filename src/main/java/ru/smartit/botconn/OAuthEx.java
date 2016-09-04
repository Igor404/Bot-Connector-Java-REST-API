package ru.smartit.botconn;

public class OAuthEx extends Exception {

    public final String type;

    public OAuthEx(final String type, final String description) {
        super(description);
        this.type = type;
    }

}
