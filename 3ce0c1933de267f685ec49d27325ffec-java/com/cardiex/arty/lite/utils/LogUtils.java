package com.cardiex.arty.lite.utils;

import android.util.Log;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: LogUtils.kt */
/* loaded from: classes.dex */
public final class LogUtils {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_LOG_TAG_LENGTH = 23;

    /* compiled from: LogUtils.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private final void sendToFirebaseCrashLytics(Throwable th2) {
            if (th2 != null && !(th2 instanceof SSLException) && !(th2 instanceof UnknownHostException) && !(th2 instanceof SocketTimeoutException)) {
                boolean z10 = th2 instanceof SocketException;
            }
        }

        public final void LOGD(String tag, String message) {
            i.f(tag, "tag");
            i.f(message, "message");
            if (Log.isLoggable(tag, 3)) {
                Log.d(tag, message);
            }
        }

        public final void LOGE(String tag, String message) {
            i.f(tag, "tag");
            i.f(message, "message");
            Log.e(tag, message);
        }

        public final void LOGI(String tag, String message) {
            i.f(tag, "tag");
            i.f(message, "message");
            Log.i(tag, message);
        }

        public final void LOGV(String tag, String message) {
            i.f(tag, "tag");
            i.f(message, "message");
            if (Log.isLoggable(tag, 2)) {
                Log.v(tag, message);
            }
        }

        public final void LOGW(String tag, String message) {
            i.f(tag, "tag");
            i.f(message, "message");
            Log.w(tag, message);
        }

        public final String makeLogTag(String str) {
            i.f(str, "str");
            if (str.length() <= 23) {
                return str;
            }
            String substring = str.substring(0, 22);
            i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        public final void LOGE(String tag, String message, Throwable th2) {
            i.f(tag, "tag");
            i.f(message, "message");
            Log.e(tag, message, th2);
            sendToFirebaseCrashLytics(th2);
        }

        public final void LOGI(String tag, String message, Throwable th2) {
            i.f(tag, "tag");
            i.f(message, "message");
            Log.i(tag, message, th2);
            sendToFirebaseCrashLytics(th2);
        }

        public final void LOGW(String tag, String message, Throwable th2) {
            i.f(tag, "tag");
            i.f(message, "message");
            Log.w(tag, message, th2);
            sendToFirebaseCrashLytics(th2);
        }

        public final void LOGD(String tag, String message, Throwable th2) {
            i.f(tag, "tag");
            i.f(message, "message");
            if (Log.isLoggable(tag, 3)) {
                Log.d(tag, message, th2);
            }
            sendToFirebaseCrashLytics(th2);
        }

        public final void LOGV(String tag, String message, Throwable th2) {
            i.f(tag, "tag");
            i.f(message, "message");
            if (Log.isLoggable(tag, 2)) {
                Log.v(tag, message, th2);
            }
            sendToFirebaseCrashLytics(th2);
        }

        public final String makeLogTag(Class<?> cls) {
            i.f(cls, "cls");
            String simpleName = cls.getSimpleName();
            i.e(simpleName, "cls.simpleName");
            return makeLogTag(simpleName);
        }
    }
}
