package androidx.work;

import android.content.Context;
import androidx.work.a;
import java.util.Collections;
import java.util.List;
import k1.a;
/* loaded from: classes.dex */
public final class WorkManagerInitializer implements a<r> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4684a = k.f("WrkMgrInitializer");

    @Override // k1.a
    public List<Class<? extends a<?>>> a() {
        return Collections.emptyList();
    }

    /* renamed from: c */
    public r b(Context context) {
        k.c().a(f4684a, "Initializing WorkManager with default configuration.", new Throwable[0]);
        r.d(context, new a.b().a());
        return r.c(context);
    }
}
