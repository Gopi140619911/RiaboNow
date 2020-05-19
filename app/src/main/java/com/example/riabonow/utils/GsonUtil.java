package com.example.riabonow.utils;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


public class GsonUtil {

    private static Gson gson;

    public static Gson getGson() {
        if (null == gson) {
            gson = new GsonBuilder().create();
        }
        return gson;
    }

    @NonNull
    public static ParameterizedType getType(@NonNull final Class raw, @Nullable final Type... args) {
        return new ParameterizedType() {
            @NonNull
            public Type getRawType() {
                return raw;
            }

            @Nullable
            public Type[] getActualTypeArguments() {
                return args;
            }

            @Nullable
            public Type getOwnerType() {
                return null;
            }
        };
    }
}
