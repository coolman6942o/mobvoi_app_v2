package y8;

import com.google.zxing.FormatException;
/* compiled from: DecodedNumeric.java */
/* loaded from: classes.dex */
final class p extends q {

    /* renamed from: b  reason: collision with root package name */
    private final int f36789b;

    /* renamed from: c  reason: collision with root package name */
    private final int f36790c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(int i10, int i11, int i12) throws FormatException {
        super(i10);
        if (i11 < 0 || i11 > 10 || i12 < 0 || i12 > 10) {
            throw FormatException.getFormatInstance();
        }
        this.f36789b = i11;
        this.f36790c = i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f36789b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f36790c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f36789b == 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f36790c == 10;
    }
}
