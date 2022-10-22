package f1;

import androidx.room.RoomDatabase;
/* compiled from: EntityDeletionOrUpdateAdapter.java */
/* loaded from: classes.dex */
public abstract class f<T> extends l {
    public f(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    protected abstract void g(i1.f fVar, T t10);

    public final int h(T t10) {
        i1.f a10 = a();
        try {
            g(a10, t10);
            return a10.r();
        } finally {
            f(a10);
        }
    }

    public final int i(T[] tArr) {
        i1.f a10 = a();
        try {
            int i10 = 0;
            for (T t10 : tArr) {
                g(a10, t10);
                i10 += a10.r();
            }
            return i10;
        } finally {
            f(a10);
        }
    }
}
