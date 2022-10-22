package yo;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import io.h;
import java.util.Objects;
import kotlin.Result;
/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes3.dex */
public final class c {
    private static volatile Choreographer choreographer;

    static {
        Object obj;
        b bVar = null;
        try {
            Result.a aVar = Result.Companion;
            obj = Result.m28constructorimpl(new a(a(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m28constructorimpl(h.a(th2));
        }
        if (!Result.m33isFailureimpl(obj)) {
            bVar = obj;
        }
    }

    public static final Handler a(Looper looper, boolean z10) {
        int i10;
        if (!z10 || (i10 = Build.VERSION.SDK_INT) < 16) {
            return new Handler(looper);
        }
        if (i10 >= 28) {
            Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
            Objects.requireNonNull(invoke, "null cannot be cast to non-null type android.os.Handler");
            return (Handler) invoke;
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }
}
