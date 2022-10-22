package f1;

import i1.d;
import i1.e;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
/* compiled from: RoomSQLiteQuery.java */
/* loaded from: classes.dex */
public class k implements e, d {

    /* renamed from: i  reason: collision with root package name */
    static final TreeMap<Integer, k> f26326i = new TreeMap<>();

    /* renamed from: a  reason: collision with root package name */
    private volatile String f26327a;

    /* renamed from: b  reason: collision with root package name */
    final long[] f26328b;

    /* renamed from: c  reason: collision with root package name */
    final double[] f26329c;

    /* renamed from: d  reason: collision with root package name */
    final String[] f26330d;

    /* renamed from: e  reason: collision with root package name */
    final byte[][] f26331e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f26332f;

    /* renamed from: g  reason: collision with root package name */
    final int f26333g;

    /* renamed from: h  reason: collision with root package name */
    int f26334h;

    private k(int i10) {
        this.f26333g = i10;
        int i11 = i10 + 1;
        this.f26332f = new int[i11];
        this.f26328b = new long[i11];
        this.f26329c = new double[i11];
        this.f26330d = new String[i11];
        this.f26331e = new byte[i11];
    }

    public static k h(String str, int i10) {
        TreeMap<Integer, k> treeMap = f26326i;
        synchronized (treeMap) {
            Map.Entry<Integer, k> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i10));
            if (ceilingEntry != null) {
                treeMap.remove(ceilingEntry.getKey());
                k value = ceilingEntry.getValue();
                value.i(str, i10);
                return value;
            }
            k kVar = new k(i10);
            kVar.i(str, i10);
            return kVar;
        }
    }

    private static void n() {
        TreeMap<Integer, k> treeMap = f26326i;
        if (treeMap.size() > 15) {
            int size = treeMap.size() - 10;
            Iterator<Integer> it = treeMap.descendingKeySet().iterator();
            while (true) {
                size--;
                if (size > 0) {
                    it.next();
                    it.remove();
                } else {
                    return;
                }
            }
        }
    }

    @Override // i1.d
    public void K(int i10, long j10) {
        this.f26332f[i10] = 2;
        this.f26328b[i10] = j10;
    }

    @Override // i1.d
    public void P(int i10, byte[] bArr) {
        this.f26332f[i10] = 5;
        this.f26331e[i10] = bArr;
    }

    @Override // i1.e
    public void c(d dVar) {
        for (int i10 = 1; i10 <= this.f26334h; i10++) {
            int i11 = this.f26332f[i10];
            if (i11 == 1) {
                dVar.l0(i10);
            } else if (i11 == 2) {
                dVar.K(i10, this.f26328b[i10]);
            } else if (i11 == 3) {
                dVar.y(i10, this.f26329c[i10]);
            } else if (i11 == 4) {
                dVar.m(i10, this.f26330d[i10]);
            } else if (i11 == 5) {
                dVar.P(i10, this.f26331e[i10]);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // i1.e
    public String d() {
        return this.f26327a;
    }

    void i(String str, int i10) {
        this.f26327a = str;
        this.f26334h = i10;
    }

    @Override // i1.d
    public void l0(int i10) {
        this.f26332f[i10] = 1;
    }

    @Override // i1.d
    public void m(int i10, String str) {
        this.f26332f[i10] = 4;
        this.f26330d[i10] = str;
    }

    public void o() {
        TreeMap<Integer, k> treeMap = f26326i;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f26333g), this);
            n();
        }
    }

    @Override // i1.d
    public void y(int i10, double d10) {
        this.f26332f[i10] = 3;
        this.f26329c[i10] = d10;
    }
}
