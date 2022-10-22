package xp;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.f;
/* compiled from: AndroidSchedulers.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicReference<a> f36643b = new AtomicReference<>();

    /* renamed from: a  reason: collision with root package name */
    private final f f36644a;

    private a() {
        f b10 = wp.a.a().b().b();
        if (b10 != null) {
            this.f36644a = b10;
        } else {
            this.f36644a = new b(Looper.getMainLooper());
        }
    }

    private static a a() {
        AtomicReference<a> atomicReference;
        a aVar;
        do {
            atomicReference = f36643b;
            a aVar2 = atomicReference.get();
            if (aVar2 != null) {
                return aVar2;
            }
            aVar = new a();
        } while (!atomicReference.compareAndSet(null, aVar));
        return aVar;
    }

    public static f b() {
        return a().f36644a;
    }
}
