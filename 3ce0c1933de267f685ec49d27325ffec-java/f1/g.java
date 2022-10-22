package f1;

import androidx.room.RoomDatabase;
import i1.f;
import java.util.ArrayList;
import java.util.List;
/* compiled from: EntityInsertionAdapter.java */
/* loaded from: classes.dex */
public abstract class g<T> extends l {
    public g(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    protected abstract void g(f fVar, T t10);

    public final void h(Iterable<? extends T> iterable) {
        f a10 = a();
        try {
            for (T t10 : iterable) {
                g(a10, t10);
                a10.D0();
            }
        } finally {
            f(a10);
        }
    }

    public final void i(T t10) {
        f a10 = a();
        try {
            g(a10, t10);
            a10.D0();
        } finally {
            f(a10);
        }
    }

    public final void j(T[] tArr) {
        f a10 = a();
        try {
            for (T t10 : tArr) {
                g(a10, t10);
                a10.D0();
            }
        } finally {
            f(a10);
        }
    }

    public final long k(T t10) {
        f a10 = a();
        try {
            g(a10, t10);
            return a10.D0();
        } finally {
            f(a10);
        }
    }

    public final List<Long> l(T[] tArr) {
        f a10 = a();
        try {
            ArrayList arrayList = new ArrayList(tArr.length);
            int i10 = 0;
            for (T t10 : tArr) {
                g(a10, t10);
                arrayList.add(i10, Long.valueOf(a10.D0()));
                i10++;
            }
            return arrayList;
        } finally {
            f(a10);
        }
    }
}
