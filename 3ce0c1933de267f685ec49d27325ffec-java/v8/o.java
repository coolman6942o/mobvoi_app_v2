package v8;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.common.a;
import com.google.zxing.h;
/* compiled from: UPCEANExtensionSupport.java */
/* loaded from: classes.dex */
final class o {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f35668c = {1, 1, 2};

    /* renamed from: a  reason: collision with root package name */
    private final m f35669a = new m();

    /* renamed from: b  reason: collision with root package name */
    private final n f35670b = new n();

    /* JADX INFO: Access modifiers changed from: package-private */
    public h a(int i10, a aVar, int i11) throws NotFoundException {
        int[] m10 = p.m(aVar, i11, false, f35668c);
        try {
            return this.f35670b.b(i10, aVar, m10);
        } catch (ReaderException unused) {
            return this.f35669a.b(i10, aVar, m10);
        }
    }
}
