package nl;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f31303a;

    /* renamed from: b  reason: collision with root package name */
    public int f31304b;

    /* renamed from: c  reason: collision with root package name */
    public int f31305c;

    /* renamed from: d  reason: collision with root package name */
    public int f31306d;

    public b(int i10, int i11, int i12, int i13) {
        this.f31303a = i10;
        this.f31304b = i11;
        this.f31305c = i12;
        this.f31306d = i13;
    }

    public static b b(int i10, int i11) {
        if (i10 == 1) {
            return new b(i11 & 255, (i11 >> 8) & 255, (i11 >> 16) & 255, (i11 >> 24) & 255);
        }
        if (!(i10 == 515 || i10 == 516 || i10 == 2)) {
            if (i10 == 3) {
                return new b(i11 & 15, (i11 >> 4) & 255, (i11 >> 12) & 32767, (i11 >> 27) & 31);
            }
            if (i10 == 5) {
                return new b(i11 & 15, (i11 >> 4) & 255, (i11 >> 12) & 511, (i11 >> 21) & 32767);
            }
            if (!(i10 == 4 || i10 == 7 || i10 != 514)) {
                return new b((i11 >> 8) & 255, i11 & 255, (i11 >> 24) & 255, (i11 >> 16) & 255);
            }
            return new b(0, 0, 0, i11);
        }
        return new b((i11 >> 24) & 255, (i11 >> 16) & 255, (i11 >> 8) & 255, i11 & 255);
    }

    public int a(b bVar) {
        int i10 = this.f31303a;
        int i11 = bVar.f31303a;
        if (i10 > i11) {
            return 1;
        }
        if (i10 < i11) {
            return -1;
        }
        int i12 = this.f31304b;
        int i13 = bVar.f31304b;
        if (i12 > i13) {
            return 1;
        }
        if (i12 < i13) {
            return -1;
        }
        int i14 = this.f31305c;
        int i15 = bVar.f31305c;
        if (i14 > i15) {
            return 1;
        }
        if (i14 < i15) {
            return -1;
        }
        int i16 = this.f31306d;
        int i17 = bVar.f31306d;
        if (i16 > i17) {
            return 1;
        }
        return i16 == i17 ? 0 : -1;
    }
}
