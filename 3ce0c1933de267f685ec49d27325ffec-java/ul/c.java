package ul;

import android.content.Context;
import android.text.TextUtils;
import cm.d;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f35477a;

    /* renamed from: b  reason: collision with root package name */
    public int f35478b;

    /* renamed from: c  reason: collision with root package name */
    public int f35479c;

    /* renamed from: d  reason: collision with root package name */
    public int f35480d;

    /* renamed from: e  reason: collision with root package name */
    public int f35481e;

    /* renamed from: f  reason: collision with root package name */
    public int f35482f;

    /* renamed from: g  reason: collision with root package name */
    public int f35483g;

    /* renamed from: h  reason: collision with root package name */
    public String f35484h;

    /* renamed from: i  reason: collision with root package name */
    public String f35485i;

    /* renamed from: j  reason: collision with root package name */
    public int f35486j;

    /* renamed from: k  reason: collision with root package name */
    public d f35487k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f35488l;

    /* renamed from: m  reason: collision with root package name */
    public int f35489m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f35490n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f35491o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f35492p;

    /* renamed from: q  reason: collision with root package name */
    public int f35493q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f35494r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f35495s;

    /* renamed from: t  reason: collision with root package name */
    public int f35496t;

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Context f35497a;

        /* renamed from: c  reason: collision with root package name */
        public String f35499c;

        /* renamed from: d  reason: collision with root package name */
        public String f35500d;

        /* renamed from: k  reason: collision with root package name */
        public d f35507k;

        /* renamed from: q  reason: collision with root package name */
        public int f35513q;

        /* renamed from: b  reason: collision with root package name */
        public int f35498b = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f35501e = 3;

        /* renamed from: f  reason: collision with root package name */
        public int f35502f = 0;

        /* renamed from: g  reason: collision with root package name */
        public int f35503g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f35504h = 0;

        /* renamed from: i  reason: collision with root package name */
        public int f35505i = 1;

        /* renamed from: j  reason: collision with root package name */
        public int f35506j = -1;

        /* renamed from: l  reason: collision with root package name */
        public boolean f35508l = false;

        /* renamed from: m  reason: collision with root package name */
        public int f35509m = 0;

        /* renamed from: n  reason: collision with root package name */
        public boolean f35510n = false;

        /* renamed from: o  reason: collision with root package name */
        public boolean f35511o = true;

        /* renamed from: p  reason: collision with root package name */
        public boolean f35512p = false;

        /* renamed from: r  reason: collision with root package name */
        public boolean f35514r = false;

        /* renamed from: s  reason: collision with root package name */
        public boolean f35515s = false;

        /* renamed from: t  reason: collision with root package name */
        public int f35516t = 15;

        public final void a() {
            int i10;
            int i11;
            if (this.f35515s) {
                this.f35511o = false;
            }
            if (this.f35507k.G() == 2) {
                this.f35504h = 4;
                if (this.f35507k.t() == 1) {
                    this.f35505i = 1;
                } else if (this.f35507k.t() == 2) {
                    this.f35505i = 0;
                }
            } else {
                if (this.f35507k.G() == 1) {
                    this.f35504h = 4;
                    if (this.f35507k.t() == 1) {
                        this.f35505i = 1;
                    } else if (this.f35507k.t() == 2) {
                        this.f35505i = 0;
                    }
                    if (this.f35507k.O()) {
                        i11 = this.f35504h;
                    } else {
                        i11 = this.f35504h | 1;
                        this.f35504h = i11;
                    }
                    i10 = i11 | 2;
                } else if (this.f35507k.O()) {
                    this.f35504h = 2;
                } else {
                    i10 = 3;
                }
                this.f35504h = i10;
            }
            if (this.f35513q == 19) {
                int i12 = this.f35504h | 1;
                this.f35504h = i12;
                this.f35504h = i12 | 2;
                if (this.f35507k.O()) {
                    this.f35516t = this.f35507k.o();
                }
            }
        }

        public final void b() {
            int i10;
            int i11;
            if (this.f35515s) {
                this.f35511o = false;
            }
            d dVar = this.f35507k;
            int i12 = dVar.f6005k;
            int G = dVar.G();
            if (i12 >= 6) {
                if (G == 2) {
                    this.f35504h = 4;
                    if (this.f35507k.t() == 1) {
                        this.f35505i = 1;
                    } else if (this.f35507k.t() == 2) {
                        this.f35505i = 0;
                    }
                } else if (this.f35507k.G() == 1) {
                    this.f35504h = 4;
                    if (this.f35507k.t() == 1) {
                        this.f35505i = 1;
                    } else if (this.f35507k.t() == 2) {
                        this.f35505i = 0;
                    }
                    if (this.f35507k.O()) {
                        i11 = this.f35504h;
                    } else {
                        i11 = this.f35504h | 1;
                        this.f35504h = i11;
                    }
                    this.f35504h = i11 | 2;
                } else if (this.f35507k.O()) {
                    this.f35504h = 2;
                } else {
                    this.f35504h = 3;
                }
                if (this.f35513q == 19) {
                    int i13 = this.f35504h | 1;
                    this.f35504h = i13;
                    this.f35504h = i13 | 2;
                    if (!this.f35507k.O()) {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                if (G == 2) {
                    this.f35504h = 4;
                    if (this.f35507k.t() == 1) {
                        this.f35505i = 1;
                    } else if (this.f35507k.t() == 2) {
                        this.f35505i = 0;
                    }
                } else if (this.f35507k.G() == 1) {
                    this.f35504h = 4;
                    if (this.f35507k.t() == 1) {
                        this.f35505i = 1;
                    } else if (this.f35507k.t() == 2) {
                        this.f35505i = 0;
                    }
                    if (this.f35507k.O()) {
                        i10 = this.f35504h;
                    } else {
                        i10 = this.f35504h | 1;
                        this.f35504h = i10;
                    }
                    this.f35504h = i10 | 2;
                } else if (this.f35507k.O()) {
                    this.f35504h = 2;
                } else {
                    this.f35504h = 3;
                }
                d dVar2 = this.f35507k;
                if (dVar2.f6005k >= 5 && this.f35513q == 19) {
                    int i14 = this.f35504h | 1;
                    this.f35504h = i14;
                    this.f35504h = i14 | 2;
                    if (!dVar2.O()) {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f35516t = this.f35507k.o();
        }

        public c c() {
            d dVar = this.f35507k;
            if (dVar != null) {
                this.f35501e = dVar.f6004j;
                this.f35502f = dVar.f5995a;
                this.f35503g = dVar.f6005k;
                this.f35516t = dVar.J();
                this.f35515s = this.f35507k.O();
                d dVar2 = this.f35507k;
                int i10 = dVar2.f5995a;
                if (i10 == 16) {
                    a();
                } else if (i10 == 17) {
                    b();
                } else {
                    if (dVar2.f6004j <= 3 && this.f35513q == 0) {
                        this.f35515s = false;
                    }
                    if (this.f35515s) {
                        this.f35504h = 2;
                    }
                }
                return new c(this.f35497a, this.f35501e, this.f35502f, this.f35503g, this.f35504h, this.f35498b, this.f35499c, this.f35500d, this.f35506j, this.f35515s, this.f35516t, this.f35507k, this.f35508l, this.f35509m, this.f35510n, this.f35511o, this.f35512p, this.f35505i, this.f35513q, this.f35514r);
            }
            this.f35510n = false;
            this.f35508l = false;
            this.f35511o = false;
            this.f35504h = 3;
            return new c(this.f35497a, this.f35501e, this.f35502f, this.f35503g, this.f35504h, this.f35498b, this.f35499c, this.f35500d, this.f35506j, this.f35515s, this.f35516t, this.f35507k, this.f35508l, this.f35509m, this.f35510n, this.f35511o, this.f35512p, this.f35505i, this.f35513q, this.f35514r);
        }

        public b d(boolean z10) {
            this.f35514r = z10;
            return this;
        }

        public b e(int i10) {
            this.f35498b = i10;
            return this;
        }

        public b f(int i10) {
            this.f35501e = i10;
            return this;
        }

        public b g(int i10) {
            this.f35506j = i10;
            return this;
        }

        public b h(String str) {
            this.f35499c = str;
            return this;
        }

        public b i(String str) {
            this.f35500d = str;
            return this;
        }

        public b j(boolean z10) {
            this.f35510n = z10;
            return this;
        }

        public b k(d dVar) {
            this.f35507k = dVar;
            return this;
        }

        public b l(boolean z10) {
            this.f35511o = z10;
            return this;
        }

        public b m(int i10) {
            this.f35513q = i10;
            return this;
        }

        public b n(boolean z10, int i10) {
            this.f35508l = z10;
            this.f35509m = i10;
            return this;
        }

        public b o(Context context) {
            this.f35497a = context;
            return this;
        }
    }

    public c(Context context, int i10, int i11, int i12, int i13, int i14, String str, String str2, int i15, boolean z10, int i16, d dVar, boolean z11, int i17, boolean z12, boolean z13, boolean z14, int i18, int i19, boolean z15) {
        this.f35478b = 3;
        this.f35479c = 0;
        this.f35480d = 0;
        this.f35481e = 0;
        this.f35482f = 1;
        this.f35485i = "BIN";
        this.f35489m = 0;
        this.f35495s = false;
        this.f35496t = 15;
        this.f35477a = context;
        this.f35478b = i10;
        this.f35479c = i11;
        this.f35480d = i12;
        this.f35481e = i13;
        this.f35483g = i14;
        this.f35484h = str;
        this.f35485i = str2;
        this.f35486j = i15;
        this.f35495s = z10;
        this.f35496t = i16;
        this.f35487k = dVar;
        this.f35488l = z11;
        this.f35489m = i17;
        this.f35490n = z12;
        this.f35491o = z13;
        this.f35492p = z14;
        this.f35482f = i18;
        this.f35493q = i19;
        this.f35494r = z15;
    }

    public Context a() {
        return this.f35477a;
    }

    public int b() {
        return this.f35486j;
    }

    public int c() {
        return this.f35483g;
    }

    public String d() {
        return this.f35484h;
    }

    public String e() {
        return TextUtils.isEmpty(this.f35485i) ? "BIN" : this.f35485i;
    }

    public d f() {
        return this.f35487k;
    }

    public int g() {
        return this.f35482f;
    }

    public int h() {
        return this.f35478b;
    }

    public int i() {
        return this.f35479c;
    }

    public int j() {
        return this.f35480d;
    }

    public int k() {
        return this.f35496t;
    }

    public int l() {
        return this.f35489m;
    }

    public int m() {
        return this.f35493q;
    }

    public boolean n() {
        return (this.f35481e & 4) == 4;
    }

    public boolean o() {
        return this.f35494r;
    }

    public boolean p() {
        return this.f35495s;
    }

    public boolean q() {
        return this.f35490n;
    }

    public boolean r() {
        return (this.f35481e & 2) == 2;
    }

    public boolean s() {
        return this.f35491o;
    }

    public boolean t() {
        return (this.f35481e & 1) == 1;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        d dVar = this.f35487k;
        sb2.append(dVar != null ? String.format("icType=0x%02X, protocolType=0x%04X, specVersion=0x%02X", Integer.valueOf(dVar.f6004j), Integer.valueOf(this.f35487k.f5995a), Integer.valueOf(this.f35487k.f6005k)) : String.format("protocolType=0x%04X", 0));
        sb2.append(String.format("\ndualBank=%b, updateBank=0x%02X", Boolean.valueOf(this.f35495s), Integer.valueOf(this.f35496t)));
        sb2.append(String.format("\nworkMode=0x%02X, preferredIcType=0x%02X, preferredFileType=0x%02X, preferredBudRole=0x%02X", Integer.valueOf(this.f35493q), Integer.valueOf(this.f35478b), Integer.valueOf(this.f35481e), Integer.valueOf(this.f35482f)));
        sb2.append(String.format("\nFile: location=0x%02X, indicator=0x%08X, path=%s", Integer.valueOf(this.f35483g), Integer.valueOf(this.f35486j), this.f35484h));
        sb2.append(String.format(Locale.US, "\nvalidate: versionCheck=%b(%d), icCheck=%b, sectionSizeCheck=%b,ignoreException=%b, dataImageValidate=%b", Boolean.valueOf(this.f35488l), Integer.valueOf(this.f35489m), Boolean.valueOf(this.f35490n), Boolean.valueOf(this.f35491o), Boolean.valueOf(this.f35492p), Boolean.valueOf(this.f35494r)));
        return sb2.toString();
    }

    public boolean u() {
        d dVar = this.f35487k;
        return dVar != null && dVar.K() == 3;
    }

    public boolean v() {
        return this.f35488l;
    }
}
