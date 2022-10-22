package y8;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.a;
import com.laser.tsm.sdk.AppConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AI013x0x1xDecoder.java */
/* loaded from: classes.dex */
public final class e extends i {

    /* renamed from: c  reason: collision with root package name */
    private final String f36777c;

    /* renamed from: d  reason: collision with root package name */
    private final String f36778d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, String str, String str2) {
        super(aVar);
        this.f36777c = str2;
        this.f36778d = str;
    }

    private void k(StringBuilder sb2, int i10) {
        int f10 = b().f(i10, 16);
        if (f10 != 38400) {
            sb2.append('(');
            sb2.append(this.f36777c);
            sb2.append(')');
            int i11 = f10 % 32;
            int i12 = f10 / 32;
            int i13 = (i12 % 12) + 1;
            int i14 = i12 / 12;
            if (i14 / 10 == 0) {
                sb2.append('0');
            }
            sb2.append(i14);
            if (i13 / 10 == 0) {
                sb2.append('0');
            }
            sb2.append(i13);
            if (i11 / 10 == 0) {
                sb2.append('0');
            }
            sb2.append(i11);
        }
    }

    @Override // y8.j
    public String d() throws NotFoundException {
        if (c().g() == 84) {
            StringBuilder sb2 = new StringBuilder();
            f(sb2, 8);
            j(sb2, 48, 20);
            k(sb2, 68);
            return sb2.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // y8.i
    protected void h(StringBuilder sb2, int i10) {
        sb2.append('(');
        sb2.append(this.f36778d);
        sb2.append(i10 / AppConfig.STATUS_SUCCESS);
        sb2.append(')');
    }

    @Override // y8.i
    protected int i(int i10) {
        return i10 % AppConfig.STATUS_SUCCESS;
    }
}
