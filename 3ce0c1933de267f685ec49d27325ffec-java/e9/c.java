package e9;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.b;
import com.google.zxing.common.e;
import com.google.zxing.i;
import com.google.zxing.j;
import com.google.zxing.qrcode.decoder.h;
import java.util.Map;
import o8.d;
import p8.a;
/* compiled from: Detector.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final b f25866a;

    /* renamed from: b  reason: collision with root package name */
    private j f25867b;

    public c(b bVar) {
        this.f25866a = bVar;
    }

    private float b(i iVar, i iVar2) {
        float j10 = j((int) iVar.c(), (int) iVar.d(), (int) iVar2.c(), (int) iVar2.d());
        float j11 = j((int) iVar2.c(), (int) iVar2.d(), (int) iVar.c(), (int) iVar.d());
        return Float.isNaN(j10) ? j11 / 7.0f : Float.isNaN(j11) ? j10 / 7.0f : (j10 + j11) / 14.0f;
    }

    private static int c(i iVar, i iVar2, i iVar3, float f10) throws NotFoundException {
        int c10 = ((a.c(i.b(iVar, iVar2) / f10) + a.c(i.b(iVar, iVar3) / f10)) / 2) + 7;
        int i10 = c10 & 3;
        if (i10 == 0) {
            return c10 + 1;
        }
        if (i10 == 2) {
            return c10 - 1;
        }
        if (i10 != 3) {
            return c10;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static d d(i iVar, i iVar2, i iVar3, i iVar4, int i10) {
        float f10;
        float f11;
        float f12;
        float f13 = i10 - 3.5f;
        if (iVar4 != null) {
            f12 = f13 - 3.0f;
            f11 = iVar4.c();
            f10 = iVar4.d();
        } else {
            f11 = (iVar2.c() - iVar.c()) + iVar3.c();
            f10 = (iVar2.d() - iVar.d()) + iVar3.d();
            f12 = f13;
        }
        return d.b(3.5f, 3.5f, f13, 3.5f, f12, f12, 3.5f, f13, iVar.c(), iVar.d(), iVar2.c(), iVar2.d(), f11, f10, iVar3.c(), iVar3.d());
    }

    private static b h(b bVar, d dVar, int i10) throws NotFoundException {
        return e.b().d(bVar, i10, i10, dVar);
    }

    private float i(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z10;
        c cVar;
        boolean z11;
        boolean z12 = true;
        boolean z13 = Math.abs(i13 - i11) > Math.abs(i12 - i10);
        if (z13) {
            i16 = i10;
            i17 = i11;
            i14 = i12;
            i15 = i13;
        } else {
            i17 = i10;
            i16 = i11;
            i15 = i12;
            i14 = i13;
        }
        int abs = Math.abs(i15 - i17);
        int abs2 = Math.abs(i14 - i16);
        int i20 = 2;
        int i21 = (-abs) / 2;
        int i22 = -1;
        int i23 = i17 < i15 ? 1 : -1;
        if (i16 < i14) {
            i22 = 1;
        }
        int i24 = i15 + i23;
        int i25 = i17;
        int i26 = i16;
        int i27 = 0;
        while (true) {
            if (i25 == i24) {
                i18 = i24;
                i19 = i20;
                break;
            }
            int i28 = z13 ? i26 : i25;
            int i29 = z13 ? i25 : i26;
            if (i27 == z12) {
                z10 = z13;
                z11 = z12;
                i18 = i24;
                cVar = this;
            } else {
                cVar = this;
                z10 = z13;
                i18 = i24;
                z11 = false;
            }
            if (z11 == cVar.f25866a.d(i28, i29)) {
                if (i27 == 2) {
                    return a.b(i25, i26, i17, i16);
                }
                i27++;
            }
            i21 += abs2;
            if (i21 > 0) {
                if (i26 == i14) {
                    i19 = 2;
                    break;
                }
                i26 += i22;
                i21 -= abs;
            }
            i25 += i23;
            i24 = i18;
            z13 = z10;
            z12 = true;
            i20 = 2;
        }
        if (i27 == i19) {
            return a.b(i18, i14, i17, i16);
        }
        return Float.NaN;
    }

    private float j(int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float i14 = i(i10, i11, i12, i13);
        int i15 = i10 - (i12 - i10);
        int i16 = 0;
        if (i15 < 0) {
            f10 = i10 / (i10 - i15);
            i15 = 0;
        } else if (i15 >= this.f25866a.k()) {
            f10 = ((this.f25866a.k() - 1) - i10) / (i15 - i10);
            i15 = this.f25866a.k() - 1;
        } else {
            f10 = 1.0f;
        }
        float f12 = i11;
        int i17 = (int) (f12 - ((i13 - i11) * f10));
        if (i17 < 0) {
            f11 = f12 / (i11 - i17);
        } else if (i17 >= this.f25866a.g()) {
            f11 = ((this.f25866a.g() - 1) - i11) / (i17 - i11);
            i16 = this.f25866a.g() - 1;
        } else {
            i16 = i17;
            f11 = 1.0f;
        }
        return (i14 + i(i10, i11, (int) (i10 + ((i15 - i10) * f11)), i16)) - 1.0f;
    }

    protected final float a(i iVar, i iVar2, i iVar3) {
        return (b(iVar, iVar2) + b(iVar, iVar3)) / 2.0f;
    }

    public final o8.c e(Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        j jVar = map == null ? null : (j) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        this.f25867b = jVar;
        return g(new e(this.f25866a, jVar).e(map));
    }

    protected final a f(float f10, int i10, int i11, float f11) throws NotFoundException {
        int i12 = (int) (f11 * f10);
        int max = Math.max(0, i10 - i12);
        int min = Math.min(this.f25866a.k() - 1, i10 + i12) - max;
        float f12 = 3.0f * f10;
        if (min >= f12) {
            int max2 = Math.max(0, i11 - i12);
            int min2 = Math.min(this.f25866a.g() - 1, i11 + i12) - max2;
            if (min2 >= f12) {
                return new b(this.f25866a, max, max2, min, min2, f10, this.f25867b).c();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected final o8.c g(f fVar) throws NotFoundException, FormatException {
        d b10 = fVar.b();
        d c10 = fVar.c();
        d a10 = fVar.a();
        float a11 = a(b10, c10, a10);
        if (a11 >= 1.0f) {
            int c11 = c(b10, c10, a10, a11);
            h g10 = h.g(c11);
            int e10 = g10.e() - 7;
            a aVar = null;
            if (g10.d().length > 0) {
                float c12 = (c10.c() - b10.c()) + a10.c();
                float d10 = (c10.d() - b10.d()) + a10.d();
                float f10 = 1.0f - (3.0f / e10);
                int c13 = (int) (b10.c() + ((c12 - b10.c()) * f10));
                int d11 = (int) (b10.d() + (f10 * (d10 - b10.d())));
                for (int i10 = 4; i10 <= 16; i10 <<= 1) {
                    try {
                        aVar = f(a11, c13, d11, i10);
                        break;
                    } catch (NotFoundException unused) {
                    }
                }
            }
            return new o8.c(h(this.f25866a, d(b10, c10, a10, aVar, c11), c11), aVar == null ? new i[]{a10, b10, c10} : new i[]{a10, b10, c10, aVar});
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
