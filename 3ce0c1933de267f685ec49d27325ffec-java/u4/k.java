package u4;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* compiled from: LruBitmapPool.java */
/* loaded from: classes.dex */
public class k implements e {

    /* renamed from: j  reason: collision with root package name */
    private static final Bitmap.Config f35311j = Bitmap.Config.ARGB_8888;

    /* renamed from: a  reason: collision with root package name */
    private final l f35312a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Bitmap.Config> f35313b;

    /* renamed from: c  reason: collision with root package name */
    private final a f35314c;

    /* renamed from: d  reason: collision with root package name */
    private long f35315d;

    /* renamed from: e  reason: collision with root package name */
    private long f35316e;

    /* renamed from: f  reason: collision with root package name */
    private int f35317f;

    /* renamed from: g  reason: collision with root package name */
    private int f35318g;

    /* renamed from: h  reason: collision with root package name */
    private int f35319h;

    /* renamed from: i  reason: collision with root package name */
    private int f35320i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LruBitmapPool.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    /* compiled from: LruBitmapPool.java */
    /* loaded from: classes.dex */
    private static final class b implements a {
        b() {
        }

        @Override // u4.k.a
        public void a(Bitmap bitmap) {
        }

        @Override // u4.k.a
        public void b(Bitmap bitmap) {
        }
    }

    k(long j10, l lVar, Set<Bitmap.Config> set) {
        this.f35315d = j10;
        this.f35312a = lVar;
        this.f35313b = set;
        this.f35314c = new b();
    }

    @TargetApi(26)
    private static void f(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    private static Bitmap g(int i10, int i11, Bitmap.Config config) {
        if (config == null) {
            config = f35311j;
        }
        return Bitmap.createBitmap(i10, i11, config);
    }

    private void h() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            i();
        }
    }

    private void i() {
        Log.v("LruBitmapPool", "Hits=" + this.f35317f + ", misses=" + this.f35318g + ", puts=" + this.f35319h + ", evictions=" + this.f35320i + ", currentSize=" + this.f35316e + ", maxSize=" + this.f35315d + "\nStrategy=" + this.f35312a);
    }

    private void j() {
        q(this.f35315d);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> k() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 19) {
            hashSet.add(null);
        }
        if (i10 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static l l() {
        if (Build.VERSION.SDK_INT >= 19) {
            return new n();
        }
        return new c();
    }

    private synchronized Bitmap m(int i10, int i11, Bitmap.Config config) {
        Bitmap d10;
        f(config);
        d10 = this.f35312a.d(i10, i11, config != null ? config : f35311j);
        if (d10 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f35312a.a(i10, i11, config));
            }
            this.f35318g++;
        } else {
            this.f35317f++;
            this.f35316e -= this.f35312a.b(d10);
            this.f35314c.a(d10);
            p(d10);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f35312a.a(i10, i11, config));
        }
        h();
        return d10;
    }

    @TargetApi(19)
    private static void o(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    private static void p(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        o(bitmap);
    }

    private synchronized void q(long j10) {
        while (this.f35316e > j10) {
            Bitmap removeLast = this.f35312a.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    i();
                }
                this.f35316e = 0L;
                return;
            }
            this.f35314c.a(removeLast);
            this.f35316e -= this.f35312a.b(removeLast);
            this.f35320i++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.f35312a.e(removeLast));
            }
            h();
            removeLast.recycle();
        }
    }

    @Override // u4.e
    @SuppressLint({"InlinedApi"})
    public void a(int i10) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i10);
        }
        if (i10 >= 40 || (Build.VERSION.SDK_INT >= 23 && i10 >= 20)) {
            b();
        } else if (i10 >= 20 || i10 == 15) {
            q(n() / 2);
        }
    }

    @Override // u4.e
    public void b() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        q(0L);
    }

    @Override // u4.e
    public synchronized void c(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            } else if (!bitmap.isRecycled()) {
                if (bitmap.isMutable() && this.f35312a.b(bitmap) <= this.f35315d && this.f35313b.contains(bitmap.getConfig())) {
                    int b10 = this.f35312a.b(bitmap);
                    this.f35312a.c(bitmap);
                    this.f35314c.b(bitmap);
                    this.f35319h++;
                    this.f35316e += b10;
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f35312a.e(bitmap));
                    }
                    h();
                    j();
                    return;
                }
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f35312a.e(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f35313b.contains(bitmap.getConfig()));
                }
                bitmap.recycle();
            } else {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // u4.e
    public Bitmap d(int i10, int i11, Bitmap.Config config) {
        Bitmap m10 = m(i10, i11, config);
        if (m10 == null) {
            return g(i10, i11, config);
        }
        m10.eraseColor(0);
        return m10;
    }

    @Override // u4.e
    public Bitmap e(int i10, int i11, Bitmap.Config config) {
        Bitmap m10 = m(i10, i11, config);
        return m10 == null ? g(i10, i11, config) : m10;
    }

    public long n() {
        return this.f35315d;
    }

    public k(long j10) {
        this(j10, l(), k());
    }
}
