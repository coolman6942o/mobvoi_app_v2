package com.realsil.sdk.dfu.image.wrapper;

import android.os.Parcel;
import android.os.Parcelable;
import cm.d;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class SocImageWrapper extends tl.a implements Parcelable {
    public static final Parcelable.Creator<SocImageWrapper> CREATOR = new a();

    /* renamed from: o  reason: collision with root package name */
    public static boolean f22199o = false;

    /* renamed from: a  reason: collision with root package name */
    public int f22200a;

    /* renamed from: b  reason: collision with root package name */
    public int f22201b;

    /* renamed from: c  reason: collision with root package name */
    public int f22202c;

    /* renamed from: d  reason: collision with root package name */
    public int f22203d;

    /* renamed from: e  reason: collision with root package name */
    public int f22204e;

    /* renamed from: f  reason: collision with root package name */
    public int f22205f;

    /* renamed from: g  reason: collision with root package name */
    public int f22206g;

    /* renamed from: h  reason: collision with root package name */
    public int f22207h;

    /* renamed from: i  reason: collision with root package name */
    public int f22208i;

    /* renamed from: j  reason: collision with root package name */
    public int f22209j;

    /* renamed from: k  reason: collision with root package name */
    public int f22210k;

    /* renamed from: l  reason: collision with root package name */
    public int f22211l;

    /* renamed from: m  reason: collision with root package name */
    public String f22212m;

    /* renamed from: n  reason: collision with root package name */
    public String f22213n;

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<SocImageWrapper> {
        /* renamed from: a */
        public SocImageWrapper createFromParcel(Parcel parcel) {
            return new SocImageWrapper(parcel);
        }

        /* renamed from: b */
        public SocImageWrapper[] newArray(int i10) {
            return new SocImageWrapper[i10];
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public int f22214a;

        /* renamed from: b  reason: collision with root package name */
        public int f22215b;

        /* renamed from: c  reason: collision with root package name */
        public int f22216c;

        /* renamed from: d  reason: collision with root package name */
        public int f22217d;

        /* renamed from: e  reason: collision with root package name */
        public int f22218e;

        /* renamed from: f  reason: collision with root package name */
        public int f22219f;

        /* renamed from: g  reason: collision with root package name */
        public int f22220g = 15;

        /* renamed from: h  reason: collision with root package name */
        public d f22221h;

        public SocImageWrapper a() {
            d dVar = this.f22221h;
            if (dVar != null) {
                this.f22214a = dVar.E();
                d dVar2 = this.f22221h;
                this.f22215b = dVar2.f6005k;
                this.f22216c = dVar2.f6004j;
                this.f22220g = dVar2.o();
            }
            return new SocImageWrapper(this.f22214a, this.f22215b, this.f22216c, this.f22217d, this.f22218e, this.f22219f, this.f22220g, null);
        }

        public b b(int i10) {
            this.f22220g = i10;
            return this;
        }

        public b c(int i10) {
            this.f22218e = i10;
            return this;
        }

        public b d(int i10) {
            this.f22216c = i10;
            return this;
        }

        public b e(int i10) {
            this.f22219f = i10;
            return this;
        }

        public b f(int i10) {
            this.f22217d = i10;
            return this;
        }

        public b g(int i10) {
            this.f22214a = i10;
            return this;
        }

        public b h(int i10) {
            this.f22215b = i10;
            return this;
        }
    }

    public SocImageWrapper(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f22206g = 15;
        this.f22200a = i10;
        this.f22201b = i11;
        this.f22202c = i12;
        this.f22203d = i13;
        this.f22204e = i14;
        this.f22205f = i15;
        this.f22206g = i16;
        d();
    }

    public /* synthetic */ SocImageWrapper(int i10, int i11, int i12, int i13, int i14, int i15, int i16, a aVar) {
        this(i10, i11, i12, i13, i14, i15, i16);
    }

    public SocImageWrapper(Parcel parcel) {
        this.f22206g = 15;
        this.f22200a = parcel.readInt();
        this.f22201b = parcel.readInt();
        this.f22202c = parcel.readInt();
        this.f22203d = parcel.readInt();
        this.f22204e = parcel.readInt();
        this.f22205f = parcel.readInt();
        this.f22206g = parcel.readInt();
        this.f22207h = parcel.readInt();
        this.f22208i = parcel.readInt();
        this.f22209j = parcel.readInt();
        this.f22210k = parcel.readInt();
        this.f22211l = parcel.readInt();
        this.f22212m = parcel.readString();
        this.f22213n = parcel.readString();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int f(int i10, int i11) {
        if (i10 <= 3) {
            return 7;
        }
        if (i10 != 5 && i10 != 9 && i10 != 12) {
            switch (i11) {
                case 0:
                case 1:
                case 2:
                case 9:
                    return 2;
                case 3:
                case 4:
                    break;
                case 5:
                    return 5;
                case 6:
                case 7:
                    return 515;
                case 8:
                    return 514;
                default:
                    switch (i11) {
                        case 18:
                        case 25:
                            return 2;
                        case 19:
                        case 20:
                            break;
                        case 21:
                            break;
                        case 22:
                        case 23:
                            break;
                        case 24:
                            break;
                        default:
                            return 1;
                    }
            }
        } else if (i11 == 2) {
            return 2;
        } else {
            if (!(i11 == 3 || i11 == 4 || i11 == 5 || i11 != 18)) {
                return 2;
            }
        }
        return 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0046 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int g(int i10, int i11, int i12, int i13, boolean z10) {
        if (i10 <= 3) {
            return 7;
        }
        if (!(i10 == 5 || i10 == 9 || i10 == 12)) {
            if (i13 != 10145) {
                if (i13 != 10148) {
                    switch (i13) {
                        case 10128:
                            if (i11 != 20 ? !(i11 != 17 || i12 < 6 || !z10) : z10) {
                                return 1;
                            }
                            break;
                        case 10129:
                        case 10130:
                            break;
                        case 10131:
                            return 5;
                        case 10132:
                        case 10133:
                            return 515;
                        case 10134:
                            break;
                        case 10135:
                            return (i10 == 11 || i10 == 13 || i10 == 10) ? 516 : 514;
                        default:
                            switch (i13) {
                            }
                    }
                }
            }
            return 3;
        }
        return 2;
    }

    public final void a() {
        if (this.f22200a == 20) {
            c();
        } else {
            b();
        }
    }

    public final void b() {
        String str;
        int i10 = this.f22207h;
        if (i10 == 1) {
            if (this.f22201b > 0) {
                int i11 = this.f22203d;
                int i12 = i11 & 255;
                this.f22208i = i12;
                this.f22209j = (i11 >> 8) & 255;
                this.f22210k = (i11 >> 16) & 255;
                this.f22211l = (i11 >> 24) & 255;
                str = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i12), Integer.valueOf(this.f22209j), Integer.valueOf(this.f22210k), Integer.valueOf(this.f22211l));
            }
            int i13 = this.f22203d;
            this.f22208i = i13;
            this.f22209j = 0;
            this.f22210k = 0;
            this.f22211l = 0;
            str = String.valueOf(i13);
        } else if (i10 == 2) {
            if (this.f22201b > 0) {
                int i14 = this.f22203d;
                int i15 = (i14 >> 24) & 255;
                this.f22208i = i15;
                this.f22209j = (i14 >> 16) & 255;
                this.f22210k = (i14 >> 8) & 255;
                this.f22211l = i14 & 255;
                str = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i15), Integer.valueOf(this.f22209j), Integer.valueOf(this.f22210k), Integer.valueOf(this.f22211l));
            }
            int i132 = this.f22203d;
            this.f22208i = i132;
            this.f22209j = 0;
            this.f22210k = 0;
            this.f22211l = 0;
            str = String.valueOf(i132);
        } else if (i10 == 3) {
            if (this.f22201b > 0) {
                int i16 = this.f22203d;
                int i17 = i16 & 15;
                this.f22208i = i17;
                this.f22209j = (i16 >> 4) & 255;
                this.f22210k = (i16 >> 12) & 32767;
                this.f22211l = (i16 >> 27) & 31;
                str = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i17), Integer.valueOf(this.f22209j), Integer.valueOf(this.f22210k), Integer.valueOf(this.f22211l));
            }
            int i1322 = this.f22203d;
            this.f22208i = i1322;
            this.f22209j = 0;
            this.f22210k = 0;
            this.f22211l = 0;
            str = String.valueOf(i1322);
        } else if (i10 == 5) {
            if (this.f22201b > 0) {
                int i18 = this.f22203d;
                int i19 = i18 & 15;
                this.f22208i = i19;
                this.f22209j = (i18 >> 4) & 255;
                this.f22210k = (i18 >> 12) & 511;
                this.f22211l = (i18 >> 21) & 2047;
                str = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i19), Integer.valueOf(this.f22209j), Integer.valueOf(this.f22210k), Integer.valueOf(this.f22211l));
            }
            int i13222 = this.f22203d;
            this.f22208i = i13222;
            this.f22209j = 0;
            this.f22210k = 0;
            this.f22211l = 0;
            str = String.valueOf(i13222);
        } else if (i10 == 515) {
            if (this.f22201b > 0) {
                int i20 = this.f22203d;
                int i21 = (i20 >> 24) & 255;
                this.f22208i = i21;
                this.f22209j = (i20 >> 16) & 255;
                this.f22210k = (i20 >> 8) & 255;
                this.f22211l = i20 & 255;
                str = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i21), Integer.valueOf(this.f22209j), Integer.valueOf(this.f22210k), Integer.valueOf(this.f22211l));
            }
            int i132222 = this.f22203d;
            this.f22208i = i132222;
            this.f22209j = 0;
            this.f22210k = 0;
            this.f22211l = 0;
            str = String.valueOf(i132222);
        } else {
            if (!(i10 == 4 || i10 == 7)) {
                if (i10 == 514) {
                    if (this.f22201b > 0) {
                        int i22 = this.f22203d;
                        int i23 = (i22 >> 8) & 255;
                        this.f22208i = i23;
                        this.f22209j = i22 & 255;
                        this.f22210k = (i22 >> 24) & 255;
                        this.f22211l = (i22 >> 16) & 255;
                        str = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i23), Integer.valueOf(this.f22209j), Integer.valueOf(this.f22210k), Integer.valueOf(this.f22211l));
                    }
                } else if (i10 == 516) {
                    int i24 = this.f22203d;
                    int i25 = (i24 >> 24) & 255;
                    this.f22208i = i25;
                    this.f22209j = (i24 >> 16) & 255;
                    this.f22210k = (i24 >> 8) & 255;
                    this.f22211l = i24 & 255;
                    str = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i25), Integer.valueOf(this.f22209j), Integer.valueOf(this.f22210k), Integer.valueOf(this.f22211l));
                }
            }
            int i1322222 = this.f22203d;
            this.f22208i = i1322222;
            this.f22209j = 0;
            this.f22210k = 0;
            this.f22211l = 0;
            str = String.valueOf(i1322222);
        }
        this.f22212m = str;
        if (this.f22203d == -1) {
            this.f22212m = "";
        }
    }

    public final void c() {
        String valueOf;
        int i10 = this.f22207h;
        if (i10 == 1) {
            int i11 = this.f22203d;
            int i12 = i11 & 255;
            this.f22208i = i12;
            this.f22209j = (i11 >> 8) & 255;
            this.f22210k = (i11 >> 16) & 255;
            this.f22211l = (i11 >> 24) & 255;
            valueOf = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i12), Integer.valueOf(this.f22209j), Integer.valueOf(this.f22210k), Integer.valueOf(this.f22211l));
        } else if (i10 == 2) {
            int i13 = this.f22203d;
            int i14 = (i13 >> 24) & 255;
            this.f22208i = i14;
            this.f22209j = (i13 >> 16) & 255;
            this.f22210k = (i13 >> 8) & 255;
            this.f22211l = i13 & 255;
            valueOf = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i14), Integer.valueOf(this.f22209j), Integer.valueOf(this.f22210k), Integer.valueOf(this.f22211l));
        } else if (i10 == 3) {
            int i15 = this.f22203d;
            int i16 = i15 & 15;
            this.f22208i = i16;
            this.f22209j = (i15 >> 4) & 255;
            this.f22210k = (i15 >> 12) & 32767;
            this.f22211l = (i15 >> 27) & 31;
            valueOf = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i16), Integer.valueOf(this.f22209j), Integer.valueOf(this.f22210k), Integer.valueOf(this.f22211l));
        } else if (i10 == 5) {
            int i17 = this.f22203d;
            int i18 = i17 & 15;
            this.f22208i = i18;
            this.f22209j = (i17 >> 4) & 255;
            this.f22210k = (i17 >> 12) & 511;
            this.f22211l = (i17 >> 21) & 2047;
            valueOf = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i18), Integer.valueOf(this.f22209j), Integer.valueOf(this.f22210k), Integer.valueOf(this.f22211l));
        } else if (i10 == 515) {
            int i19 = this.f22203d;
            int i20 = (i19 >> 24) & 255;
            this.f22208i = i20;
            this.f22209j = (i19 >> 16) & 255;
            this.f22210k = (i19 >> 8) & 255;
            this.f22211l = i19 & 255;
            valueOf = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i20), Integer.valueOf(this.f22209j), Integer.valueOf(this.f22210k), Integer.valueOf(this.f22211l));
        } else {
            if (!(i10 == 4 || i10 == 7)) {
                if (i10 == 514) {
                    int i21 = this.f22203d;
                    int i22 = (i21 >> 8) & 255;
                    this.f22208i = i22;
                    this.f22209j = i21 & 255;
                    this.f22210k = (i21 >> 24) & 255;
                    this.f22211l = (i21 >> 16) & 255;
                    valueOf = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i22), Integer.valueOf(this.f22209j), Integer.valueOf(this.f22210k), Integer.valueOf(this.f22211l));
                } else if (i10 == 516) {
                    int i23 = this.f22203d;
                    int i24 = (i23 >> 24) & 255;
                    this.f22208i = i24;
                    this.f22209j = (i23 >> 16) & 255;
                    this.f22210k = (i23 >> 8) & 255;
                    this.f22211l = i23 & 255;
                    valueOf = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf(i24), Integer.valueOf(this.f22209j), Integer.valueOf(this.f22210k), Integer.valueOf(this.f22211l));
                }
            }
            int i25 = this.f22203d;
            this.f22208i = i25;
            this.f22209j = 0;
            this.f22210k = 0;
            this.f22211l = 0;
            valueOf = String.valueOf(i25);
        }
        this.f22212m = valueOf;
        if (this.f22203d == -1) {
            this.f22212m = "";
        }
    }

    public final void d() {
        String str;
        int i10;
        int g10;
        boolean z10 = false;
        if (-1 == this.f22203d) {
            this.f22206g = 0;
            this.f22208i = 0;
            this.f22209j = 0;
            this.f22210k = 0;
            this.f22211l = 0;
            this.f22212m = "";
            return;
        }
        if (f22199o) {
            il.b.j(String.format("protocolType=%04X,specVersion=%02X", Integer.valueOf(this.f22200a), Integer.valueOf(this.f22201b)));
        }
        int i11 = this.f22200a;
        if (i11 == 20) {
            int i12 = this.f22202c;
            int i13 = this.f22201b;
            int i14 = this.f22205f;
            if (this.f22206g != 15) {
                z10 = true;
            }
            g10 = g(i12, i11, i13, i14, z10);
        } else if (i11 != 17 || (i10 = this.f22201b) < 6) {
            this.f22207h = f(this.f22202c, this.f22204e);
            str = ul.a.d(this.f22202c, this.f22204e);
            this.f22213n = str;
            a();
        } else {
            int i15 = this.f22202c;
            int i16 = this.f22205f;
            if (this.f22206g != 15) {
                z10 = true;
            }
            g10 = g(i15, i11, i10, i16, z10);
        }
        this.f22207h = g10;
        str = ul.a.e(this.f22202c, this.f22205f);
        this.f22213n = str;
        a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f22203d;
    }

    public String toString() {
        return String.format(Locale.US, "0x%04X(%s), I%02XPT%04XSV%02X, imageVersion=[%08X], format=[%d]\nformatedVersion=(%d.%d.%d.%d)->[%s]", Integer.valueOf(this.f22205f), this.f22213n, Integer.valueOf(this.f22202c), Integer.valueOf(this.f22200a), Integer.valueOf(this.f22201b), Integer.valueOf(this.f22203d), Integer.valueOf(this.f22207h), Integer.valueOf(this.f22208i), Integer.valueOf(this.f22209j), Integer.valueOf(this.f22210k), Integer.valueOf(this.f22211l), this.f22212m);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f22200a);
        parcel.writeInt(this.f22201b);
        parcel.writeInt(this.f22202c);
        parcel.writeInt(this.f22203d);
        parcel.writeInt(this.f22204e);
        parcel.writeInt(this.f22205f);
        parcel.writeInt(this.f22206g);
        parcel.writeInt(this.f22207h);
        parcel.writeInt(this.f22208i);
        parcel.writeInt(this.f22209j);
        parcel.writeInt(this.f22210k);
        parcel.writeInt(this.f22211l);
        parcel.writeString(this.f22212m);
        parcel.writeString(this.f22213n);
    }
}
