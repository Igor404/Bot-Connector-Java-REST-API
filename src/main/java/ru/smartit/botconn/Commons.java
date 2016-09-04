package ru.smartit.botconn;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;

public class Commons {
    public static final OkHttpClient HTTP_CLIENT = new OkHttpClient();
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
}
