package r4;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import r4.d;
/* compiled from: LocalUriFetcher.java */
/* loaded from: classes.dex */
public abstract class l<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f33427a;

    /* renamed from: b  reason: collision with root package name */
    private final ContentResolver f33428b;

    /* renamed from: c  reason: collision with root package name */
    private T f33429c;

    public l(ContentResolver contentResolver, Uri uri) {
        this.f33428b = contentResolver;
        this.f33427a = uri;
    }

    @Override // r4.d
    public DataSource b() {
        return DataSource.LOCAL;
    }

    @Override // r4.d
    public void c() {
        T t10 = this.f33429c;
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
    public final void e(Priority priority, d.a<? super T> aVar) {
        try {
            T f10 = f(this.f33427a, this.f33428b);
            this.f33429c = f10;
            aVar.f(f10);
        } catch (FileNotFoundException e10) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e10);
            }
            aVar.d(e10);
        }
    }

    protected abstract T f(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;
}
