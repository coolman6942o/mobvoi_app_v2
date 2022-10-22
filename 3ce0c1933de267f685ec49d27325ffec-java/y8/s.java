package y8;

import androidx.recyclerview.widget.g;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GeneralAppIdDecoder.java */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    private final a f36797a;

    /* renamed from: b  reason: collision with root package name */
    private final m f36798b = new m();

    /* renamed from: c  reason: collision with root package name */
    private final StringBuilder f36799c = new StringBuilder();

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(a aVar) {
        this.f36797a = aVar;
    }

    private n b(int i10) {
        char c10;
        int f10 = f(i10, 5);
        if (f10 == 15) {
            return new n(i10 + 5, '$');
        }
        if (f10 >= 5 && f10 < 15) {
            return new n(i10 + 5, (char) ((f10 + 48) - 5));
        }
        int f11 = f(i10, 6);
        if (f11 >= 32 && f11 < 58) {
            return new n(i10 + 6, (char) (f11 + 33));
        }
        switch (f11) {
            case 58:
                c10 = '*';
                break;
            case 59:
                c10 = ',';
                break;
            case 60:
                c10 = '-';
                break;
            case 61:
                c10 = '.';
                break;
            case 62:
                c10 = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: " + f11);
        }
        return new n(i10 + 6, c10);
    }

    private n d(int i10) throws FormatException {
        char c10;
        int f10 = f(i10, 5);
        if (f10 == 15) {
            return new n(i10 + 5, '$');
        }
        if (f10 >= 5 && f10 < 15) {
            return new n(i10 + 5, (char) ((f10 + 48) - 5));
        }
        int f11 = f(i10, 7);
        if (f11 >= 64 && f11 < 90) {
            return new n(i10 + 7, (char) (f11 + 1));
        }
        if (f11 >= 90 && f11 < 116) {
            return new n(i10 + 7, (char) (f11 + 7));
        }
        switch (f(i10, 8)) {
            case 232:
                c10 = '!';
                break;
            case 233:
                c10 = '\"';
                break;
            case 234:
                c10 = '%';
                break;
            case 235:
                c10 = '&';
                break;
            case 236:
                c10 = '\'';
                break;
            case 237:
                c10 = '(';
                break;
            case 238:
                c10 = ')';
                break;
            case 239:
                c10 = '*';
                break;
            case 240:
                c10 = '+';
                break;
            case 241:
                c10 = ',';
                break;
            case 242:
                c10 = '-';
                break;
            case 243:
                c10 = '.';
                break;
            case 244:
                c10 = '/';
                break;
            case 245:
                c10 = ':';
                break;
            case 246:
                c10 = ';';
                break;
            case 247:
                c10 = '<';
                break;
            case 248:
                c10 = '=';
                break;
            case 249:
                c10 = '>';
                break;
            case g.f.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                c10 = '?';
                break;
            case 251:
                c10 = '_';
                break;
            case 252:
                c10 = ' ';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        return new n(i10 + 8, c10);
    }

    private p e(int i10) throws FormatException {
        int i11 = i10 + 7;
        if (i11 > this.f36797a.g()) {
            int f10 = f(i10, 4);
            if (f10 == 0) {
                return new p(this.f36797a.g(), 10, 10);
            }
            return new p(this.f36797a.g(), f10 - 1, 10);
        }
        int f11 = f(i10, 7) - 8;
        return new p(i11, f11 / 11, f11 % 11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(a aVar, int i10, int i11) {
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            if (aVar.c(i10 + i13)) {
                i12 |= 1 << ((i11 - i13) - 1);
            }
        }
        return i12;
    }

    private boolean h(int i10) {
        int i11 = i10 + 3;
        if (i11 > this.f36797a.g()) {
            return false;
        }
        while (i10 < i11) {
            if (this.f36797a.c(i10)) {
                return false;
            }
            i10++;
        }
        return true;
    }

    private boolean i(int i10) {
        int i11;
        if (i10 + 1 > this.f36797a.g()) {
            return false;
        }
        for (int i12 = 0; i12 < 5 && (i11 = i12 + i10) < this.f36797a.g(); i12++) {
            if (i12 == 2) {
                if (!this.f36797a.c(i10 + 2)) {
                    return false;
                }
            } else if (this.f36797a.c(i11)) {
                return false;
            }
        }
        return true;
    }

    private boolean j(int i10) {
        int i11;
        if (i10 + 1 > this.f36797a.g()) {
            return false;
        }
        for (int i12 = 0; i12 < 4 && (i11 = i12 + i10) < this.f36797a.g(); i12++) {
            if (this.f36797a.c(i11)) {
                return false;
            }
        }
        return true;
    }

    private boolean k(int i10) {
        int f10;
        if (i10 + 5 > this.f36797a.g()) {
            return false;
        }
        int f11 = f(i10, 5);
        if (f11 < 5 || f11 >= 16) {
            return i10 + 6 <= this.f36797a.g() && (f10 = f(i10, 6)) >= 16 && f10 < 63;
        }
        return true;
    }

    private boolean l(int i10) {
        int f10;
        if (i10 + 5 > this.f36797a.g()) {
            return false;
        }
        int f11 = f(i10, 5);
        if (f11 >= 5 && f11 < 16) {
            return true;
        }
        if (i10 + 7 > this.f36797a.g()) {
            return false;
        }
        int f12 = f(i10, 7);
        if (f12 < 64 || f12 >= 116) {
            return i10 + 8 <= this.f36797a.g() && (f10 = f(i10, 8)) >= 232 && f10 < 253;
        }
        return true;
    }

    private boolean m(int i10) {
        if (i10 + 7 > this.f36797a.g()) {
            return i10 + 4 <= this.f36797a.g();
        }
        int i11 = i10;
        while (true) {
            int i12 = i10 + 3;
            if (i11 >= i12) {
                return this.f36797a.c(i12);
            }
            if (this.f36797a.c(i11)) {
                return true;
            }
            i11++;
        }
    }

    private l n() {
        while (k(this.f36798b.a())) {
            n b10 = b(this.f36798b.a());
            this.f36798b.h(b10.a());
            if (b10.c()) {
                return new l(new o(this.f36798b.a(), this.f36799c.toString()), true);
            }
            this.f36799c.append(b10.b());
        }
        if (h(this.f36798b.a())) {
            this.f36798b.b(3);
            this.f36798b.g();
        } else if (i(this.f36798b.a())) {
            if (this.f36798b.a() + 5 < this.f36797a.g()) {
                this.f36798b.b(5);
            } else {
                this.f36798b.h(this.f36797a.g());
            }
            this.f36798b.f();
        }
        return new l(false);
    }

    private o o() throws FormatException {
        boolean z10;
        l lVar;
        do {
            int a10 = this.f36798b.a();
            if (this.f36798b.c()) {
                lVar = n();
                z10 = lVar.b();
            } else if (this.f36798b.d()) {
                lVar = p();
                z10 = lVar.b();
            } else {
                lVar = q();
                z10 = lVar.b();
            }
            if (!(a10 != this.f36798b.a()) && !z10) {
                break;
            }
        } while (!z10);
        return lVar.a();
    }

    private l p() throws FormatException {
        while (l(this.f36798b.a())) {
            n d10 = d(this.f36798b.a());
            this.f36798b.h(d10.a());
            if (d10.c()) {
                return new l(new o(this.f36798b.a(), this.f36799c.toString()), true);
            }
            this.f36799c.append(d10.b());
        }
        if (h(this.f36798b.a())) {
            this.f36798b.b(3);
            this.f36798b.g();
        } else if (i(this.f36798b.a())) {
            if (this.f36798b.a() + 5 < this.f36797a.g()) {
                this.f36798b.b(5);
            } else {
                this.f36798b.h(this.f36797a.g());
            }
            this.f36798b.e();
        }
        return new l(false);
    }

    private l q() throws FormatException {
        o oVar;
        while (m(this.f36798b.a())) {
            p e10 = e(this.f36798b.a());
            this.f36798b.h(e10.a());
            if (e10.d()) {
                if (e10.e()) {
                    oVar = new o(this.f36798b.a(), this.f36799c.toString());
                } else {
                    oVar = new o(this.f36798b.a(), this.f36799c.toString(), e10.c());
                }
                return new l(oVar, true);
            }
            this.f36799c.append(e10.b());
            if (e10.e()) {
                return new l(new o(this.f36798b.a(), this.f36799c.toString()), true);
            }
            this.f36799c.append(e10.c());
        }
        if (j(this.f36798b.a())) {
            this.f36798b.e();
            this.f36798b.b(4);
        }
        return new l(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(StringBuilder sb2, int i10) throws NotFoundException, FormatException {
        String str;
        String str2 = null;
        while (true) {
            o c10 = c(i10, str2);
            String a10 = r.a(c10.b());
            if (a10 != null) {
                sb2.append(a10);
            }
            if (c10.d()) {
                str = String.valueOf(c10.c());
            } else {
                str = null;
            }
            if (i10 == c10.a()) {
                return sb2.toString();
            }
            i10 = c10.a();
            str2 = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o c(int i10, String str) throws FormatException {
        this.f36799c.setLength(0);
        if (str != null) {
            this.f36799c.append(str);
        }
        this.f36798b.h(i10);
        o o10 = o();
        if (o10 == null || !o10.d()) {
            return new o(this.f36798b.a(), this.f36799c.toString());
        }
        return new o(this.f36798b.a(), this.f36799c.toString(), o10.c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f(int i10, int i11) {
        return g(this.f36797a, i10, i11);
    }
}
