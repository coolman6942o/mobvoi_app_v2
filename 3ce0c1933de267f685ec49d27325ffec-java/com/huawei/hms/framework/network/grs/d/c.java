package com.huawei.hms.framework.network.grs.d;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13955a = "c";

    public static String a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStream = context.getAssets().open(str);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                }
            }
        } catch (IOException unused) {
            Logger.w(f13955a, "local config file is not exist.filename is {%s}", str);
            return "";
        } finally {
            a((OutputStream) byteArrayOutputStream);
            a(inputStream);
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                Logger.e(f13955a, "closeQuietly IOException", e10);
            }
        }
    }

    public static void a(InputStream inputStream) {
        a((Closeable) inputStream);
    }

    public static void a(OutputStream outputStream) {
        a((Closeable) outputStream);
    }
}
