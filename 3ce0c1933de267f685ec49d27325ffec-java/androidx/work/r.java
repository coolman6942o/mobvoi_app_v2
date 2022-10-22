package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.Collections;
import java.util.List;
import r1.i;
/* compiled from: WorkManager.java */
@SuppressLint({"AddedAbstractMethod"})
/* loaded from: classes.dex */
public abstract class r {
    public static r c(Context context) {
        return i.j(context);
    }

    public static void d(Context context, a aVar) {
        i.d(context, aVar);
    }

    public final m a(s sVar) {
        return b(Collections.singletonList(sVar));
    }

    public abstract m b(List<? extends s> list);
}
