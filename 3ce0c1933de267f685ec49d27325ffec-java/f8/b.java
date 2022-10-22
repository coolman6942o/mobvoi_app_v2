package f8;

import android.content.Context;
import com.google.firebase.a;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReference<b> f26362a = new AtomicReference<>();

    private b(Context context) {
    }

    public static void a(a aVar) {
    }

    public static b b(Context context) {
        AtomicReference<b> atomicReference = f26362a;
        atomicReference.compareAndSet(null, new b(context));
        return atomicReference.get();
    }
}
