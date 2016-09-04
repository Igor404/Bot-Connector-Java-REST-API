package ru.smartit.botconn;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OAuthToken {

    @JsonProperty("token_type")
    public String tokenType;

    @JsonProperty("expires_in")
    public int expiresIn;

    @JsonProperty("ext_expires_in")
    public int extExpiresIn;

    @JsonProperty("access_token")
    public String accessToken;

    @Override
    public String toString() {
        return "OauthToken{" +
                "tokenType='" + tokenType + '\'' +
                ", expiresIn=" + expiresIn +
                ", extExpiresIn=" + extExpiresIn +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}
