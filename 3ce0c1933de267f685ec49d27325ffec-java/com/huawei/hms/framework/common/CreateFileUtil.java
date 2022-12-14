package com.huawei.hms.framework.common;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.android.os.BuildEx;
import com.huawei.libcore.io.ExternalStorageFile;
import com.huawei.libcore.io.ExternalStorageFileInputStream;
import com.huawei.libcore.io.ExternalStorageFileOutputStream;
import com.huawei.libcore.io.ExternalStorageRandomAccessFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes.dex */
public class CreateFileUtil {
    private static final String BUILDEX_NAME = "com.huawei.android.os.BuildEx";
    private static final String EXTERNAL_FILE_NAME = "com.huawei.libcore.io.ExternalStorageFile";
    private static final String EXTERNAL_INPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileInputStream";
    private static final String EXTERNAL_OUTPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileOutputStream";
    private static final String RANDOM_ACCESS_FILE_NAME = "com.huawei.libcore.io.ExternalStorageRandomAccessFile";
    private static final String TAG = "CreateFileUtil";

    private static boolean checkCompatible(String str) {
        try {
            tryLoadClass(str);
            return true;
        } catch (Exception unused) {
            Logger.w(TAG, str + "ClassNotFoundException");
            return false;
        }
    }

    public static void deleteSecure(File file) {
        if (file != null && file.exists() && !file.delete()) {
            Logger.w(TAG, "deleteSecure exception");
        }
    }

    public static void deleteSecure(String str) {
        if (!TextUtils.isEmpty(str)) {
            deleteSecure(newFile(str));
        }
    }

    public static String getCacheDirPath(Context context) {
        if (context == null) {
            return "";
        }
        if (Build.VERSION.SDK_INT >= 24) {
            context = context.createDeviceProtectedStorageContext();
        }
        return context.getCacheDir().getPath();
    }

    public static String getCanonicalPath(String str) {
        String str2;
        Throwable e10;
        try {
            return newFile(str).getCanonicalPath();
        } catch (IOException e11) {
            e10 = e11;
            str2 = "the canonicalPath has IOException";
            Logger.w(TAG, str2, e10);
            return str;
        } catch (SecurityException e12) {
            e10 = e12;
            str2 = "the canonicalPath has securityException";
            Logger.w(TAG, str2, e10);
            return str;
        } catch (Exception e13) {
            e10 = e13;
            str2 = "the canonicalPath has other Exception";
            Logger.w(TAG, str2, e10);
            return str;
        }
    }

    public static boolean isPVersion() {
        return checkCompatible(BUILDEX_NAME) && BuildEx.VERSION.EMUI_SDK_INT >= 17;
    }

    public static File newFile(String str) {
        if (str == null) {
            return null;
        }
        if (isPVersion() && checkCompatible(EXTERNAL_FILE_NAME)) {
            return new ExternalStorageFile(str);
        }
        return new File(str);
    }

    public static FileInputStream newFileInputStream(String str) {
        if (str != null) {
            if (isPVersion() && checkCompatible(EXTERNAL_INPUTSTREAM_NAME)) {
                return new ExternalStorageFileInputStream(str);
            }
            return new FileInputStream(str);
        }
        Logger.w(TAG, "newFileInputStream  file is null");
        throw new FileNotFoundException("file is null");
    }

    public static FileOutputStream newFileOutputStream(File file) {
        if (file != null) {
            if (isPVersion() && checkCompatible(EXTERNAL_OUTPUTSTREAM_NAME)) {
                return new ExternalStorageFileOutputStream(file);
            }
            return new FileOutputStream(file);
        }
        Logger.e(TAG, "newFileOutputStream  file is null");
        throw new FileNotFoundException("file is null");
    }

    public static RandomAccessFile newRandomAccessFile(String str, String str2) {
        if (str != null) {
            if (isPVersion() && checkCompatible(RANDOM_ACCESS_FILE_NAME)) {
                return new ExternalStorageRandomAccessFile(str, str2);
            }
            return new RandomAccessFile(str, str2);
        }
        Logger.w(TAG, "newFileOutputStream  file is null");
        throw new FileNotFoundException("file is null");
    }

    private static void tryLoadClass(String str) {
        ClassLoader classLoader = CreateFileUtil.class.getClassLoader();
        if (classLoader != null) {
            classLoader.loadClass(str);
            return;
        }
        throw new ClassNotFoundException("not found classloader");
    }
}
