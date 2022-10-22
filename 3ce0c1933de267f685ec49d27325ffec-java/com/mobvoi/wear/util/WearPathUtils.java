package com.mobvoi.wear.util;

import android.net.Uri;
import android.text.TextUtils;
import java.util.List;
/* loaded from: classes2.dex */
public class WearPathUtils {
    public static final String FEATURE_BATTERY_STATS = "battery_stats";
    private static final String SCHEME_WEAR = "wear";

    public static boolean isForFeature(Uri uri, String str) {
        if (uri == null) {
            return false;
        }
        List<String> pathSegments = uri.getPathSegments();
        return !pathSegments.isEmpty() && pathSegments.get(0).equals(str);
    }

    public static Uri pathToWearUri(String str) {
        validatePath(str);
        return new Uri.Builder().scheme("wear").path(str).build();
    }

    public static String pathWithFeature(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The feature must not be empty.");
        } else if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The path must not be empty.");
        } else if (str2.startsWith("//")) {
            throw new IllegalArgumentException("The path must not start with //.");
        } else if (str2.startsWith("/")) {
            return "/" + str + str2;
        } else {
            throw new IllegalArgumentException("The path must start with /.");
        }
    }

    private static void validatePath(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The path must not be empty.");
        } else if (str.startsWith("//")) {
            throw new IllegalArgumentException("The path must not start with //.");
        }
    }

    public static Uri wearUri(String str, String str2) {
        validatePath(str2);
        return new Uri.Builder().scheme("wear").authority(str).path(str2).build();
    }
}
