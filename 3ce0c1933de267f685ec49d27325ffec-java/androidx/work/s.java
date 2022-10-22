package androidx.work;

import android.os.Build;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import y1.p;
/* compiled from: WorkRequest.java */
/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a  reason: collision with root package name */
    private UUID f4897a;

    /* renamed from: b  reason: collision with root package name */
    private p f4898b;

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f4899c;

    /* compiled from: WorkRequest.java */
    /* loaded from: classes.dex */
    public static abstract class a<B extends a<?, ?>, W extends s> {

        /* renamed from: c  reason: collision with root package name */
        p f4902c;

        /* renamed from: a  reason: collision with root package name */
        boolean f4900a = false;

        /* renamed from: d  reason: collision with root package name */
        Set<String> f4903d = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        UUID f4901b = UUID.randomUUID();

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Class<? extends ListenableWorker> cls) {
            this.f4902c = new p(this.f4901b.toString(), cls.getName());
            a(cls.getName());
        }

        public final B a(String str) {
            this.f4903d.add(str);
            return d();
        }

        public final W b() {
            W c10 = c();
            b bVar = this.f4902c.f36698j;
            int i10 = Build.VERSION.SDK_INT;
            boolean z10 = (i10 >= 24 && bVar.e()) || bVar.f() || bVar.g() || (i10 >= 23 && bVar.h());
            p pVar = this.f4902c;
            if (pVar.f36705q) {
                if (z10) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                } else if (pVar.f36695g > 0) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                }
            }
            this.f4901b = UUID.randomUUID();
            p pVar2 = new p(this.f4902c);
            this.f4902c = pVar2;
            pVar2.f36689a = this.f4901b.toString();
            return c10;
        }

        abstract W c();

        abstract B d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public s(UUID uuid, p pVar, Set<String> set) {
        this.f4897a = uuid;
        this.f4898b = pVar;
        this.f4899c = set;
    }

    public String a() {
        return this.f4897a.toString();
    }

    public Set<String> b() {
        return this.f4899c;
    }

    public p c() {
        return this.f4898b;
    }
}
