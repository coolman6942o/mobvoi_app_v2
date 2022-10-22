package kotlin.random;

import java.io.Serializable;
import kotlin.jvm.internal.f;
import to.d;
/* compiled from: XorWowRandom.kt */
/* loaded from: classes3.dex */
public final class XorWowRandom extends Random implements Serializable {
    private static final a Companion = new a(null);
    @Deprecated
    private static final long serialVersionUID = 0;
    private int addend;

    /* renamed from: v  reason: collision with root package name */
    private int f30087v;

    /* renamed from: w  reason: collision with root package name */
    private int f30088w;

    /* renamed from: x  reason: collision with root package name */
    private int f30089x;

    /* renamed from: y  reason: collision with root package name */
    private int f30090y;

    /* renamed from: z  reason: collision with root package name */
    private int f30091z;

    /* compiled from: XorWowRandom.kt */
    /* loaded from: classes3.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public XorWowRandom(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f30089x = i10;
        this.f30090y = i11;
        this.f30091z = i12;
        this.f30088w = i13;
        this.f30087v = i14;
        this.addend = i15;
        int i16 = i10 | i11 | i12 | i13 | i14;
        if (i16 != 0) {
            for (int i17 = 0; i17 < 64; i17++) {
                nextInt();
            }
            return;
        }
        throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
    }

    @Override // kotlin.random.Random
    public int nextBits(int i10) {
        return d.f(nextInt(), i10);
    }

    @Override // kotlin.random.Random
    public int nextInt() {
        int i10 = this.f30089x;
        int i11 = i10 ^ (i10 >>> 2);
        this.f30089x = this.f30090y;
        this.f30090y = this.f30091z;
        this.f30091z = this.f30088w;
        int i12 = this.f30087v;
        this.f30088w = i12;
        int i13 = ((i11 ^ (i11 << 1)) ^ i12) ^ (i12 << 4);
        this.f30087v = i13;
        int i14 = this.addend + 362437;
        this.addend = i14;
        return i13 + i14;
    }

    public XorWowRandom(int i10, int i11) {
        this(i10, i11, 0, 0, ~i10, (i10 << 10) ^ (i11 >>> 4));
    }
}
