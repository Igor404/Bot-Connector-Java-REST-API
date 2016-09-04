package ru.smartit.botconn;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;

public class BotAuth {

    private static final String OAUTH_URL =
            "https://login.microsoftonline.com/common/oauth2/v2.0/token";

    public static OAuthToken reqToken(final String clientId,
            final String clientSecret) throws IOException, OAuthEx {
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
            final JsonNode jnode =
                    Commons.OBJECT_MAPPER.readTree(rbody.byteStream());
            final JsonNode jerr = jnode.get("error");
            if (jerr != null) {
                throw new OAuthEx(jerr.asText(),
                        jnode.get("error_description").asText());
            }
            return Commons.OBJECT_MAPPER.treeToValue(jnode, OAuthToken.class);
        } catch (final JsonProcessingException ex) {
            throw new Error(ex); // Must not appear
        }
    }

}
