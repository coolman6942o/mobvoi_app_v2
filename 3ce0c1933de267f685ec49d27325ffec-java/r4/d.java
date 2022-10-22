package r4;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
/* compiled from: DataFetcher.java */
/* loaded from: classes.dex */
public interface d<T> {

    /* compiled from: DataFetcher.java */
    /* loaded from: classes.dex */
    public interface a<T> {
        void d(Exception exc);

        void f(T t10);
    }

    Class<T> a();

    DataSource b();

    void c();

    void cancel();

    void e(Priority priority, a<? super T> aVar);
}
