package f1;

import androidx.room.RoomDatabase;
import i1.f;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: SharedSQLiteStatement.java */
/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f26335a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private final RoomDatabase f26336b;

    /* renamed from: c  reason: collision with root package name */
    private volatile f f26337c;

    public l(RoomDatabase roomDatabase) {
        this.f26336b = roomDatabase;
    }

    private f c() {
        return this.f26336b.f(d());
    }

    private f e(boolean z10) {
        if (!z10) {
            return c();
        }
        if (this.f26337c == null) {
            this.f26337c = c();
        }
        return this.f26337c;
    }

    public f a() {
        b();
        return e(this.f26335a.compareAndSet(false, true));
    }

    protected void b() {
        this.f26336b.c();
    }

    protected abstract String d();

    public void f(f fVar) {
        if (fVar == this.f26337c) {
            this.f26335a.set(false);
        }
    }
}
