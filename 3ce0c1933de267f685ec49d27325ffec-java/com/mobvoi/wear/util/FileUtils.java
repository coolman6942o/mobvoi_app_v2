package com.mobvoi.wear.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Pair;
import com.mobvoi.wear.common.base.WearPath;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
/* loaded from: classes2.dex */
public class FileUtils {
    private static String convertStreamToString(InputStream inputStream) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb2.append(readLine);
                sb2.append("\n");
            } else {
                bufferedReader.close();
                return sb2.toString();
            }
        }
    }

    public static String getFileExtension(String str) {
        Pair<String, String> splitExtension = splitExtension(str);
        if (splitExtension == null) {
            return null;
        }
        return (String) splitExtension.second;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
        if (r8 == null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getPath(Context context, Uri uri) throws URISyntaxException {
        Cursor cursor;
        Throwable th2;
        Cursor cursor2 = null;
        if ("content".equalsIgnoreCase(uri.getScheme())) {
            try {
                cursor = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            } catch (Exception unused) {
                cursor = null;
            } catch (Throwable th3) {
                th2 = th3;
            }
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            try {
                int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_data");
                if (cursor.moveToFirst()) {
                    String string = cursor.getString(columnIndexOrThrow);
                    cursor.close();
                    return string;
                }
            } catch (Exception unused2) {
            } catch (Throwable th4) {
                th2 = th4;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th2;
            }
            cursor.close();
        } else if (WearPath.RecorderV2.MAP_KEY_FILE.equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    public static String getStringFromFile(File file) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(file);
        String convertStreamToString = convertStreamToString(fileInputStream);
        fileInputStream.close();
        return convertStreamToString;
    }

    public static Pair<String, String> splitExtension(String str) {
        String str2;
        if (str == null || str.isEmpty()) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1) {
            str2 = str.substring(lastIndexOf);
            str = str.substring(0, lastIndexOf);
        } else {
            str2 = "";
        }
        return new Pair<>(str, str2);
    }
}
