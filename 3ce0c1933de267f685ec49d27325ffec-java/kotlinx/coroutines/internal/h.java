package kotlinx.coroutines.internal;

import kotlin.Result;
/* compiled from: FastServiceLoader.kt */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f30218a;

    static {
        Object obj;
        try {
            Result.a aVar = Result.Companion;
            obj = Result.m28constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m28constructorimpl(io.h.a(th2));
        }
        f30218a = Result.m34isSuccessimpl(obj);
    }

    public static final boolean a() {
        return f30218a;
    }
}
