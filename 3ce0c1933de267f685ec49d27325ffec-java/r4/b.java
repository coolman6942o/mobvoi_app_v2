package r4;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.IOException;
import r4.d;
/* compiled from: AssetPathFetcher.java */
/* loaded from: classes.dex */
public abstract class b<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f33403a;

    /* renamed from: b  reason: collision with root package name */
    private final AssetManager f33404b;

    /* renamed from: c  reason: collision with root package name */
    private T f33405c;

    public b(AssetManager assetManager, String str) {
        this.f33404b = assetManager;
        this.f33403a = str;
    }

    @Override // r4.d
    public DataSource b() {
        return DataSource.LOCAL;
    }

    @Override // r4.d
    public void c() {
        T t10 = this.f33405c;
        if (t10 != null) {
            try {
                d(t10);
            } catch (IOException unused) {
            }
        }
    }

    @Override // r4.d
    public void cancel() {
    }

    protected abstract void d(T t10) throws IOException;

    @Override // r4.d
    public void e(Priority priority, d.a<? super T> aVar) {
        try {
            T f10 = f(this.f33404b, this.f33403a);
            this.f33405c = f10;
            aVar.f(f10);
        } catch (IOException e10) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e10);
            }
            aVar.d(e10);
        }
    }

    protected abstract T f(AssetManager assetManager, String str) throws IOException;
}
