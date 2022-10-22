package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlinx.coroutines.s1;
/* compiled from: MainDispatchers.kt */
/* loaded from: classes3.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f30238a = true;

    private static final q a(Throwable th2, String str) {
        if (f30238a) {
            return new q(th2, str);
        }
        if (th2 == null) {
            c();
            throw new KotlinNothingValueException();
        }
        throw th2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ q b(Throwable th2, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            th2 = null;
        }
        if ((i10 & 2) != 0) {
            str = null;
        }
        return a(th2, str);
    }

    public static final Void c() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final s1 d(MainDispatcherFactory mainDispatcherFactory, List<? extends MainDispatcherFactory> list) {
        try {
            return mainDispatcherFactory.createDispatcher(list);
        } catch (Throwable th2) {
            return a(th2, mainDispatcherFactory.hintOnError());
        }
    }
}
