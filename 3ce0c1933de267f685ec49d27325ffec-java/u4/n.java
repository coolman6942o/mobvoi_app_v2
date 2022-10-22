package u4;

import android.graphics.Bitmap;
import android.os.Build;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import n5.k;
/* compiled from: SizeConfigStrategy.java */
/* loaded from: classes.dex */
public class n implements l {

    /* renamed from: d  reason: collision with root package name */
    private static final Bitmap.Config[] f35321d;

    /* renamed from: e  reason: collision with root package name */
    private static final Bitmap.Config[] f35322e;

    /* renamed from: f  reason: collision with root package name */
    private static final Bitmap.Config[] f35323f;

    /* renamed from: g  reason: collision with root package name */
    private static final Bitmap.Config[] f35324g;

    /* renamed from: h  reason: collision with root package name */
    private static final Bitmap.Config[] f35325h;

    /* renamed from: a  reason: collision with root package name */
    private final c f35326a = new c();

    /* renamed from: b  reason: collision with root package name */
    private final h<b, Bitmap> f35327b = new h<>();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f35328c = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SizeConfigStrategy.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f35329a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f35329a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35329a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35329a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35329a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SizeConfigStrategy.java */
    /* loaded from: classes.dex */
    public static final class b implements m {

        /* renamed from: a  reason: collision with root package name */
        private final c f35330a;

        /* renamed from: b  reason: collision with root package name */
        int f35331b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap.Config f35332c;

        public b(c cVar) {
            this.f35330a = cVar;
        }

        @Override // u4.m
        public void a() {
            this.f35330a.c(this);
        }

        public void b(int i10, Bitmap.Config config) {
            this.f35331b = i10;
            this.f35332c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f35331b == bVar.f35331b && k.c(this.f35332c, bVar.f35332c);
        }

        public int hashCode() {
            int i10 = this.f35331b * 31;
            Bitmap.Config config = this.f35332c;
            return i10 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return n.h(this.f35331b, this.f35332c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SizeConfigStrategy.java */
    /* loaded from: classes.dex */
    public static class c extends d<b> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d */
        public b a() {
            return new b(this);
        }

        public b e(int i10, Bitmap.Config config) {
            b b10 = b();
            b10.b(i10, config);
            return b10;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f35321d = configArr;
        f35322e = configArr;
        f35323f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f35324g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f35325h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    private void f(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> j10 = j(bitmap.getConfig());
        Integer num2 = (Integer) j10.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + e(bitmap) + ", this: " + this);
        } else if (num2.intValue() == 1) {
            j10.remove(num);
        } else {
            j10.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private b g(int i10, Bitmap.Config config) {
        Bitmap.Config[] i11;
        b e10 = this.f35326a.e(i10, config);
        for (Bitmap.Config config2 : i(config)) {
            Integer ceilingKey = j(config2).ceilingKey(Integer.valueOf(i10));
            if (ceilingKey != null && ceilingKey.intValue() <= i10 * 8) {
                if (ceilingKey.intValue() == i10) {
                    if (config2 == null) {
                        if (config == null) {
                            return e10;
                        }
                    } else if (config2.equals(config)) {
                        return e10;
                    }
                }
                this.f35326a.c(e10);
                return this.f35326a.e(ceilingKey.intValue(), config2);
            }
        }
        return e10;
    }

    static String h(int i10, Bitmap.Config config) {
        return "[" + i10 + "](" + config + ")";
    }

    private static Bitmap.Config[] i(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f35322e;
        }
        int i10 = a.f35329a[config.ordinal()];
        if (i10 == 1) {
            return f35321d;
        }
        if (i10 == 2) {
            return f35323f;
        }
        if (i10 != 3) {
            return i10 != 4 ? new Bitmap.Config[]{config} : f35325h;
        }
        return f35324g;
    }

    private NavigableMap<Integer, Integer> j(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f35328c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f35328c.put(config, treeMap);
        return treeMap;
    }

    @Override // u4.l
    public String a(int i10, int i11, Bitmap.Config config) {
        return h(k.f(i10, i11, config), config);
    }

    @Override // u4.l
    public int b(Bitmap bitmap) {
        return k.g(bitmap);
    }

    @Override // u4.l
    public void c(Bitmap bitmap) {
        b e10 = this.f35326a.e(k.g(bitmap), bitmap.getConfig());
        this.f35327b.d(e10, bitmap);
        NavigableMap<Integer, Integer> j10 = j(bitmap.getConfig());
        Integer num = (Integer) j10.get(Integer.valueOf(e10.f35331b));
        Integer valueOf = Integer.valueOf(e10.f35331b);
        int i10 = 1;
        if (num != null) {
            i10 = 1 + num.intValue();
        }
        j10.put(valueOf, Integer.valueOf(i10));
    }

    @Override // u4.l
    public Bitmap d(int i10, int i11, Bitmap.Config config) {
        b g10 = g(k.f(i10, i11, config), config);
        Bitmap a10 = this.f35327b.a(g10);
        if (a10 != null) {
            f(Integer.valueOf(g10.f35331b), a10);
            a10.reconfigure(i10, i11, config);
        }
        return a10;
    }

    @Override // u4.l
    public String e(Bitmap bitmap) {
        return h(k.g(bitmap), bitmap.getConfig());
    }

    @Override // u4.l
    public Bitmap removeLast() {
        Bitmap f10 = this.f35327b.f();
        if (f10 != null) {
            f(Integer.valueOf(k.g(f10)), f10);
        }
        return f10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SizeConfigStrategy{groupedMap=");
        sb2.append(this.f35327b);
        sb2.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f35328c.entrySet()) {
            sb2.append(entry.getKey());
            sb2.append('[');
            sb2.append(entry.getValue());
            sb2.append("], ");
        }
        if (!this.f35328c.isEmpty()) {
            sb2.replace(sb2.length() - 2, sb2.length(), "");
        }
        sb2.append(")}");
        return sb2.toString();
    }
}
