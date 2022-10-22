package w8;

import com.google.zxing.i;
/* compiled from: FinderPattern.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final int f36141a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f36142b;

    /* renamed from: c  reason: collision with root package name */
    private final i[] f36143c;

    public c(int i10, int[] iArr, int i11, int i12, int i13) {
        this.f36141a = i10;
        this.f36142b = iArr;
        float f10 = i13;
        this.f36143c = new i[]{new i(i11, f10), new i(i12, f10)};
    }

    public i[] a() {
        return this.f36143c;
    }

    public int[] b() {
        return this.f36142b;
    }

    public int c() {
        return this.f36141a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.f36141a == ((c) obj).f36141a;
    }

    public int hashCode() {
        return this.f36141a;
    }
}
