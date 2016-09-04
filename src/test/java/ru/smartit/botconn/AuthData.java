package ru.smartit.botconn;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by bolsh_000 on 9/4/2016.
 */
public class AuthData {
    @JsonProperty("CLIENT_ID")
    public String clientId;
    @JsonProperty("CLIENT_SECRET")
    public String clientSecret;
}
