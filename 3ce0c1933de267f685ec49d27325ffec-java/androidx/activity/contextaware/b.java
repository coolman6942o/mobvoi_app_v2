package androidx.activity.contextaware;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* compiled from: ContextAwareHelper.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Set<d> f318a = new CopyOnWriteArraySet();

    /* renamed from: b  reason: collision with root package name */
    private volatile Context f319b;

    public void a(d dVar) {
        if (this.f319b != null) {
            dVar.a(this.f319b);
        }
        this.f318a.add(dVar);
    }

    public void b() {
        this.f319b = null;
    }

    public void c(Context context) {
        this.f319b = context;
        for (d dVar : this.f318a) {
            dVar.a(context);
        }
    }

    public Context d() {
        return this.f319b;
    }

    public void e(d dVar) {
        this.f318a.remove(dVar);
    }
}
