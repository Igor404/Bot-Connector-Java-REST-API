package ru.smartit.botconn;

import okhttp3.*;

import java.io.IOException;
import java.net.*;

public class BotAuth {

    private static final String OAUTH_URL =
            "https://login.microsoftonline.com/common/oauth2/v2.0/token";

    public static String reqToken(final String clientId,
            final String clientSecret) throws IOException {
        final FormBody body =
                new FormBody.Builder().add("grant_type", "client_credentials").
                        add("client_id", clientId).
                        add("client_secret", clientSecret).
                        add("scope", "https://graph.microsoft.com/.default").
                        build();
        final Request request =
                new Request.Builder().url(OAUTH_URL).post(body).build();
        final Response response =
                Commons.HTTP_CLIENT.newCall(request).execute();
        try (final ResponseBody rbody = response.body()) {
            System.out.println(rbody.string());
        }
        return null;
    }

}
