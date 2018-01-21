package com.shaogang.security;

/**
 * Created by allen on 18/1/20.
 */
public class CurrentUserHolder {
    private static final ThreadLocal<String> holder = new ThreadLocal<>();
    public static String get() {
        return holder.get() == null ? "unknow" : holder.get();
    }
    public static void set(String user) {
            holder.set(user);
    }
}
