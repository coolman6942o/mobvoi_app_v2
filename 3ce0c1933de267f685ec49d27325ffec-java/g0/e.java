package g0;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
/* compiled from: HandlerCompat.java */
/* loaded from: classes.dex */
public final class e {

    /* compiled from: HandlerCompat.java */
    /* loaded from: classes.dex */
    private static class a {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static Handler a(Looper looper) {
        Throwable e10;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            return a.a(looper);
        }
        if (i10 >= 17) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (IllegalAccessException e11) {
                e10 = e11;
                Log.w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e10);
                return new Handler(looper);
            } catch (InstantiationException e12) {
                e10 = e12;
                Log.w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e10);
                return new Handler(looper);
            } catch (NoSuchMethodException e13) {
                e10 = e13;
                Log.w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e10);
                return new Handler(looper);
            } catch (InvocationTargetException e14) {
                Throwable cause = e14.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                } else if (cause instanceof Error) {
                    throw ((Error) cause);
                } else {
                    throw new RuntimeException(cause);
                }
            }
        }
        return new Handler(looper);
    }
}
