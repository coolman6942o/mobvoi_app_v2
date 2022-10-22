package v8;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.b;
import com.google.zxing.common.a;
import com.google.zxing.h;
import java.util.Map;
/* compiled from: UPCAReader.java */
/* loaded from: classes.dex */
public final class l extends p {

    /* renamed from: h  reason: collision with root package name */
    private final p f35662h = new e();

    private static h q(h hVar) throws FormatException {
        String f10 = hVar.f();
        if (f10.charAt(0) == '0') {
            return new h(f10.substring(1), null, hVar.e(), BarcodeFormat.UPC_A);
        }
        throw FormatException.getFormatInstance();
    }

    @Override // v8.k, com.google.zxing.g
    public h a(b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        return q(this.f35662h.a(bVar, map));
    }

    @Override // v8.p, v8.k
    public h b(int i10, a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        return q(this.f35662h.b(i10, aVar, map));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // v8.p
    public int k(a aVar, int[] iArr, StringBuilder sb2) throws NotFoundException {
        return this.f35662h.k(aVar, iArr, sb2);
    }

    @Override // v8.p
    public h l(int i10, a aVar, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        return q(this.f35662h.l(i10, aVar, iArr, map));
    }

    @Override // v8.p
    BarcodeFormat p() {
        return BarcodeFormat.UPC_A;
    }
}
