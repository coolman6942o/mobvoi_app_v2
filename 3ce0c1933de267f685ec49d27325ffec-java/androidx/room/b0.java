package androidx.room;

import androidx.room.RoomDatabase;
import i1.c;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QueryInterceptorOpenHelperFactory.java */
/* loaded from: classes.dex */
public final class b0 implements c.AbstractC0307c {

    /* renamed from: a  reason: collision with root package name */
    private final c.AbstractC0307c f4194a;

    /* renamed from: b  reason: collision with root package name */
    private final RoomDatabase.e f4195b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f4196c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(c.AbstractC0307c cVar, RoomDatabase.e eVar, Executor executor) {
        this.f4194a = cVar;
        this.f4195b = eVar;
        this.f4196c = executor;
    }

    @Override // i1.c.AbstractC0307c
    public c a(c.b bVar) {
        return new a0(this.f4194a.a(bVar), this.f4195b, this.f4196c);
    }
}
