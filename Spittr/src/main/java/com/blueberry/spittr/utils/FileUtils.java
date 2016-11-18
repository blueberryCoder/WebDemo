package com.blueberry.spittr.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Administrator on 11/18/2016.
 */
public class FileUtils {
    public static void close(Closeable close) {
        if (close != null) {
            try {
                close.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
