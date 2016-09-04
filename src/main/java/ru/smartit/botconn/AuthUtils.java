package ru.smartit.botconn;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.internal.Nullable;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by bolsh_000 on 9/4/2016.
 */
public class AuthUtils {
    public static @Nullable AuthData getAuthData() {
        AuthData res = null;
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("auth.properties");
            ObjectMapper mapper = new ObjectMapper();
            res = mapper.readValue(is, AuthData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
