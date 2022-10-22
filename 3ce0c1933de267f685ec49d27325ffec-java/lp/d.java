package lp;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: Settings.kt */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private int f30588a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f30589b = new int[10];

    /* compiled from: Settings.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    public final int a(int i10) {
        return this.f30589b[i10];
    }

    public final int b() {
        if ((this.f30588a & 2) != 0) {
            return this.f30589b[1];
        }
        return -1;
    }

    public final int c() {
        if ((this.f30588a & 128) != 0) {
            return this.f30589b[7];
        }
        return 65535;
    }

    public final int d() {
        if ((this.f30588a & 16) != 0) {
            return this.f30589b[4];
        }
        return Integer.MAX_VALUE;
    }

    public final int e(int i10) {
        return (this.f30588a & 32) != 0 ? this.f30589b[5] : i10;
    }

    public final boolean f(int i10) {
        return ((1 << i10) & this.f30588a) != 0;
    }

    public final void g(d other) {
        i.f(other, "other");
        for (int i10 = 0; i10 < 10; i10++) {
            if (other.f(i10)) {
                h(i10, other.a(i10));
            }
        }
    }

    public final d h(int i10, int i11) {
        if (i10 >= 0) {
            int[] iArr = this.f30589b;
            if (i10 < iArr.length) {
                this.f30588a = (1 << i10) | this.f30588a;
                iArr[i10] = i11;
            }
        }
        return this;
    }

    public final int i() {
        return Integer.bitCount(this.f30588a);
    }
}
