package androidx.room;

import androidx.room.RoomDatabase;
import i1.b;
import i1.c;
import java.util.concurrent.Executor;
/* compiled from: QueryInterceptorOpenHelper.java */
/* loaded from: classes.dex */
final class a0 implements c, j {

    /* renamed from: a  reason: collision with root package name */
    private final c f4190a;

    /* renamed from: b  reason: collision with root package name */
    private final RoomDatabase.e f4191b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f4192c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a0(c cVar, RoomDatabase.e eVar, Executor executor) {
        this.f4190a = cVar;
        this.f4191b = eVar;
        this.f4192c = executor;
    }

    @Override // i1.c
    public b S() {
        return new z(this.f4190a.S(), this.f4191b, this.f4192c);
    }

    @Override // i1.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4190a.close();
    }

    @Override // i1.c
    public String getDatabaseName() {
        return this.f4190a.getDatabaseName();
    }

    @Override // androidx.room.j
    public c getDelegate() {
        return this.f4190a;
    }

    @Override // i1.c
    public void setWriteAheadLoggingEnabled(boolean z10) {
        this.f4190a.setWriteAheadLoggingEnabled(z10);
    }
}
