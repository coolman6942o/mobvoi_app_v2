package o9;

import android.content.ContentValues;
import java.util.List;
import r9.e;
/* compiled from: ConnectionModel.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f31479a;

    /* renamed from: b  reason: collision with root package name */
    private int f31480b;

    /* renamed from: c  reason: collision with root package name */
    private long f31481c;

    /* renamed from: d  reason: collision with root package name */
    private long f31482d;

    /* renamed from: e  reason: collision with root package name */
    private long f31483e;

    public static long f(List<a> list) {
        long j10 = 0;
        for (a aVar : list) {
            j10 += aVar.a() - aVar.e();
        }
        return j10;
    }

    public long a() {
        return this.f31482d;
    }

    public long b() {
        return this.f31483e;
    }

    public int c() {
        return this.f31479a;
    }

    public int d() {
        return this.f31480b;
    }

    public long e() {
        return this.f31481c;
    }

    public void g(long j10) {
        this.f31482d = j10;
    }

    public void h(long j10) {
        this.f31483e = j10;
    }

    public void i(int i10) {
        this.f31479a = i10;
    }

    public void j(int i10) {
        this.f31480b = i10;
    }

    public void k(long j10) {
        this.f31481c = j10;
    }

    public ContentValues l() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.f31479a));
        contentValues.put("connectionIndex", Integer.valueOf(this.f31480b));
        contentValues.put("startOffset", Long.valueOf(this.f31481c));
        contentValues.put("currentOffset", Long.valueOf(this.f31482d));
        contentValues.put("endOffset", Long.valueOf(this.f31483e));
        return contentValues;
    }

    public String toString() {
        return e.n("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.f31479a), Integer.valueOf(this.f31480b), Long.valueOf(this.f31481c), Long.valueOf(this.f31483e), Long.valueOf(this.f31482d));
    }
}
