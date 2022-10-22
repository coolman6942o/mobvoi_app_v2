package kotlinx.coroutines;

import kotlin.coroutines.f;
/* compiled from: CoroutineExceptionHandler.kt */
/* loaded from: classes3.dex */
public interface CoroutineExceptionHandler extends f.b {

    /* renamed from: f0  reason: collision with root package name */
    public static final a f30111f0 = a.f30112a;

    /* compiled from: CoroutineExceptionHandler.kt */
    /* loaded from: classes3.dex */
    public static final class a implements f.c<CoroutineExceptionHandler> {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f30112a = new a();

        private a() {
        }
    }

    void handleException(f fVar, Throwable th2);
}
