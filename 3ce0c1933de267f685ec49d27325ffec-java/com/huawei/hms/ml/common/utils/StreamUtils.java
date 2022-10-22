package com.huawei.hms.ml.common.utils;

import java.io.Closeable;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class StreamUtils {
    private StreamUtils() {
    }

    public static void closeStreams(Closeable... closeableArr) {
        if (closeableArr != null) {
            for (Closeable closeable : closeableArr) {
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException unused) {
                        SmartLog.w("StreamUtils", "IOException closeStreams");
                    } catch (RuntimeException unused2) {
                        SmartLog.w("StreamUtils", "RuntimeException closeStreams");
                    }
                }
            }
        }
    }
}
