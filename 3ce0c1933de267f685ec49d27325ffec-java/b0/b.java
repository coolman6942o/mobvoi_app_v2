package b0;

import android.graphics.Insets;
import android.graphics.Rect;
/* compiled from: Insets.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final b f4958e = new b(0, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final int f4959a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4960b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4961c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4962d;

    private b(int i10, int i11, int i12, int i13) {
        this.f4959a = i10;
        this.f4960b = i11;
        this.f4961c = i12;
        this.f4962d = i13;
    }

    public static b a(b bVar, b bVar2) {
        return b(Math.max(bVar.f4959a, bVar2.f4959a), Math.max(bVar.f4960b, bVar2.f4960b), Math.max(bVar.f4961c, bVar2.f4961c), Math.max(bVar.f4962d, bVar2.f4962d));
    }

    public static b b(int i10, int i11, int i12, int i13) {
        if (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) {
            return f4958e;
        }
        return new b(i10, i11, i12, i13);
    }

    public static b c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static b d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return Insets.of(this.f4959a, this.f4960b, this.f4961c, this.f4962d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f4962d == bVar.f4962d && this.f4959a == bVar.f4959a && this.f4961c == bVar.f4961c && this.f4960b == bVar.f4960b;
    }

    public int hashCode() {
        return (((((this.f4959a * 31) + this.f4960b) * 31) + this.f4961c) * 31) + this.f4962d;
    }

    public String toString() {
        return "Insets{left=" + this.f4959a + ", top=" + this.f4960b + ", right=" + this.f4961c + ", bottom=" + this.f4962d + '}';
    }
}
