package vo;

import kotlin.collections.y;
import kotlin.jvm.internal.f;
import lo.c;
/* compiled from: Progressions.kt */
/* loaded from: classes3.dex */
public class a implements Iterable<Integer>, ro.a {

    /* renamed from: d  reason: collision with root package name */
    public static final C0517a f35841d = new C0517a(null);

    /* renamed from: a  reason: collision with root package name */
    private final int f35842a;

    /* renamed from: b  reason: collision with root package name */
    private final int f35843b;

    /* renamed from: c  reason: collision with root package name */
    private final int f35844c;

    /* compiled from: Progressions.kt */
    /* renamed from: vo.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0517a {
        private C0517a() {
        }

        public final a a(int i10, int i11, int i12) {
            return new a(i10, i11, i12);
        }

        public /* synthetic */ C0517a(f fVar) {
            this();
        }
    }

    public a(int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i12 != Integer.MIN_VALUE) {
            this.f35842a = i10;
            this.f35843b = c.b(i10, i11, i12);
            this.f35844c = i12;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public final int a() {
        return this.f35842a;
    }

    public final int b() {
        return this.f35843b;
    }

    public final int d() {
        return this.f35844c;
    }

    /* renamed from: e */
    public y iterator() {
        return new b(this.f35842a, this.f35843b, this.f35844c);
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (!(this.f35842a == aVar.f35842a && this.f35843b == aVar.f35843b && this.f35844c == aVar.f35844c)) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f35842a * 31) + this.f35843b) * 31) + this.f35844c;
    }

    public boolean isEmpty() {
        if (this.f35844c > 0) {
            if (this.f35842a > this.f35843b) {
                return true;
            }
        } else if (this.f35842a < this.f35843b) {
            return true;
        }
        return false;
    }

    public String toString() {
        int i10;
        StringBuilder sb2;
        if (this.f35844c > 0) {
            sb2 = new StringBuilder();
            sb2.append(this.f35842a);
            sb2.append("..");
            sb2.append(this.f35843b);
            sb2.append(" step ");
            i10 = this.f35844c;
        } else {
            sb2 = new StringBuilder();
            sb2.append(this.f35842a);
            sb2.append(" downTo ");
            sb2.append(this.f35843b);
            sb2.append(" step ");
            i10 = -this.f35844c;
        }
        sb2.append(i10);
        return sb2.toString();
    }
}
