package com.realsil.sdk.dfu.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.agconnect.exception.AGCServerException;
import com.realsil.sdk.dfu.model.ConnectionParameters;
import il.b;
import java.util.Locale;
/* loaded from: classes2.dex */
public class DfuConfig implements Parcelable {
    public static final Parcelable.Creator<DfuConfig> CREATOR = new a();
    public int A;
    public int B;
    public boolean C;
    public boolean D;
    public int E;
    public int F;
    public String G;
    public String H;
    public String I;
    public String J;
    public ConnectionParameters K;
    public String L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public boolean R;
    public int S;
    public boolean T;
    public boolean U;
    public boolean V;
    public long W;

    /* renamed from: a  reason: collision with root package name */
    public int f22232a;

    /* renamed from: b  reason: collision with root package name */
    public int f22233b;

    /* renamed from: c  reason: collision with root package name */
    public int f22234c;

    /* renamed from: d  reason: collision with root package name */
    public int f22235d;

    /* renamed from: e  reason: collision with root package name */
    public String f22236e;

    /* renamed from: f  reason: collision with root package name */
    public int f22237f;

    /* renamed from: g  reason: collision with root package name */
    public String f22238g;

    /* renamed from: h  reason: collision with root package name */
    public String f22239h;

    /* renamed from: i  reason: collision with root package name */
    public int f22240i;

    /* renamed from: j  reason: collision with root package name */
    public int f22241j;

    /* renamed from: k  reason: collision with root package name */
    public int f22242k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f22243l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f22244m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f22245n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f22246o;

    /* renamed from: p  reason: collision with root package name */
    public Long f22247p;

    /* renamed from: q  reason: collision with root package name */
    public int f22248q;

    /* renamed from: r  reason: collision with root package name */
    public int f22249r;

    /* renamed from: s  reason: collision with root package name */
    public byte[] f22250s;

    /* renamed from: t  reason: collision with root package name */
    public int f22251t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f22252u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f22253v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f22254w;

    /* renamed from: x  reason: collision with root package name */
    public int f22255x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f22256y;

    /* renamed from: z  reason: collision with root package name */
    public int f22257z;

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<DfuConfig> {
        /* renamed from: a */
        public DfuConfig createFromParcel(Parcel parcel) {
            return new DfuConfig(parcel);
        }

        /* renamed from: b */
        public DfuConfig[] newArray(int i10) {
            return new DfuConfig[i10];
        }
    }

    public DfuConfig() {
        this(0);
    }

    public DfuConfig(int i10) {
        this.f22232a = 0;
        this.f22233b = 0;
        this.f22234c = 0;
        this.f22235d = 3;
        this.f22237f = 0;
        this.f22239h = "BIN";
        this.f22240i = -1;
        this.f22241j = 7;
        this.f22242k = 0;
        this.f22243l = true;
        this.f22244m = false;
        this.f22245n = false;
        this.f22246o = false;
        this.f22247p = 0L;
        this.f22248q = 0;
        this.f22249r = 7;
        this.f22251t = 20;
        this.f22252u = false;
        this.f22253v = true;
        this.f22254w = false;
        this.f22255x = 0;
        this.f22256y = false;
        this.f22257z = 30;
        this.A = 0;
        this.B = 3;
        this.C = false;
        this.D = true;
        this.E = 6;
        this.F = 93;
        this.G = "0000d0ff-3c17-d293-8e48-14fe2e4da212";
        this.H = "00006287-3c17-d293-8e48-14fe2e4da212";
        this.I = "00006387-3c17-d293-8e48-14fe2e4da212";
        this.J = "00006487-3c17-d293-8e48-14fe2e4da212";
        this.M = 130;
        this.N = 2;
        this.O = 2;
        this.P = 0;
        this.Q = 6;
        this.R = true;
        this.S = 0;
        this.W = 10000L;
        this.f22234c = i10;
        this.K = new ConnectionParameters.b().d(6).c(17).b(0).e(AGCServerException.UNKNOW_EXCEPTION).a();
        b.j("init default:" + this.K.toString());
    }

    public DfuConfig(Parcel parcel) {
        boolean z10 = false;
        this.f22232a = 0;
        this.f22233b = 0;
        this.f22234c = 0;
        this.f22235d = 3;
        this.f22237f = 0;
        this.f22239h = "BIN";
        this.f22240i = -1;
        this.f22241j = 7;
        this.f22242k = 0;
        this.f22243l = true;
        this.f22244m = false;
        this.f22245n = false;
        this.f22246o = false;
        this.f22247p = 0L;
        this.f22248q = 0;
        this.f22249r = 7;
        this.f22251t = 20;
        this.f22252u = false;
        this.f22253v = true;
        this.f22254w = false;
        this.f22255x = 0;
        this.f22256y = false;
        this.f22257z = 30;
        this.A = 0;
        this.B = 3;
        this.C = false;
        this.D = true;
        this.E = 6;
        this.F = 93;
        this.G = "0000d0ff-3c17-d293-8e48-14fe2e4da212";
        this.H = "00006287-3c17-d293-8e48-14fe2e4da212";
        this.I = "00006387-3c17-d293-8e48-14fe2e4da212";
        this.J = "00006487-3c17-d293-8e48-14fe2e4da212";
        this.M = 130;
        this.N = 2;
        this.O = 2;
        this.P = 0;
        this.Q = 6;
        this.R = true;
        this.S = 0;
        this.W = 10000L;
        this.f22232a = parcel.readInt();
        this.f22233b = parcel.readInt();
        this.f22234c = parcel.readInt();
        this.f22235d = parcel.readInt();
        this.f22236e = parcel.readString();
        this.f22237f = parcel.readInt();
        this.f22238g = parcel.readString();
        this.f22239h = parcel.readString();
        this.f22240i = parcel.readInt();
        this.f22241j = parcel.readInt();
        this.f22242k = parcel.readInt();
        this.f22243l = parcel.readByte() != 0;
        this.f22244m = parcel.readByte() != 0;
        this.f22245n = parcel.readByte() != 0;
        this.f22246o = parcel.readByte() != 0;
        this.f22247p = parcel.readByte() == 0 ? null : Long.valueOf(parcel.readLong());
        this.f22248q = parcel.readInt();
        this.f22249r = parcel.readInt();
        this.f22250s = parcel.createByteArray();
        this.f22251t = parcel.readInt();
        this.f22252u = parcel.readByte() != 0;
        this.f22253v = parcel.readByte() != 0;
        this.f22254w = parcel.readByte() != 0;
        this.f22255x = parcel.readInt();
        this.f22256y = parcel.readByte() != 0;
        this.f22257z = parcel.readInt();
        this.A = parcel.readInt();
        this.B = parcel.readInt();
        this.C = parcel.readByte() != 0;
        this.D = parcel.readByte() != 0;
        this.E = parcel.readInt();
        this.F = parcel.readInt();
        this.G = parcel.readString();
        this.H = parcel.readString();
        this.I = parcel.readString();
        this.J = parcel.readString();
        this.K = (ConnectionParameters) parcel.readParcelable(ConnectionParameters.class.getClassLoader());
        this.L = parcel.readString();
        this.M = parcel.readInt();
        this.N = parcel.readInt();
        this.O = parcel.readInt();
        this.P = parcel.readInt();
        this.Q = parcel.readInt();
        this.R = parcel.readByte() != 0;
        this.S = parcel.readInt();
        this.T = parcel.readByte() != 0;
        this.U = parcel.readByte() != 0;
        this.V = parcel.readByte() != 0 ? true : z10;
        this.W = parcel.readLong();
    }

    public int A() {
        return this.f22233b;
    }

    public int B() {
        return this.B;
    }

    public byte[] C() {
        return this.f22250s;
    }

    public int D() {
        return this.f22242k;
    }

    public boolean E() {
        return this.f22243l;
    }

    public boolean F() {
        return this.f22256y;
    }

    public boolean G() {
        return this.f22245n;
    }

    public boolean H() {
        return this.f22253v;
    }

    public boolean I(int i10) {
        return (this.f22248q & i10) == i10;
    }

    public boolean J() {
        return this.D;
    }

    public boolean K(int i10) {
        return (this.f22249r & i10) == i10;
    }

    public boolean L() {
        return this.f22254w;
    }

    public boolean M() {
        return this.T;
    }

    public boolean N() {
        return (this.f22241j & 1) == 1;
    }

    public boolean O() {
        return this.f22252u;
    }

    public boolean P() {
        return (this.f22241j & 4) == 4;
    }

    public boolean Q() {
        return this.f22244m;
    }

    public boolean R() {
        return (this.f22241j & 2) == 2;
    }

    public boolean S() {
        return this.f22246o;
    }

    public boolean U() {
        return this.R;
    }

    public void W(String str) {
        this.f22236e = str;
    }

    public void X(String str) {
        this.f22238g = str;
    }

    public void Y(int i10) {
        this.f22234c = i10;
    }

    public void Z(int i10) {
        this.f22233b = i10;
    }

    public Long a() {
        return this.f22247p;
    }

    public void a0(byte[] bArr) {
        this.f22250s = bArr;
    }

    public String b() {
        return this.f22236e;
    }

    public void b0(boolean z10) {
        this.f22241j = z10 ? this.f22241j | 2 : this.f22241j & (-3);
    }

    public int c() {
        return this.f22232a;
    }

    public ConnectionParameters d() {
        return this.K;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.J;
    }

    public String f() {
        return this.I;
    }

    public String g() {
        return this.H;
    }

    public int h() {
        return this.f22240i;
    }

    public int i() {
        return this.f22237f;
    }

    public String j() {
        return this.f22238g;
    }

    public String k() {
        return TextUtils.isEmpty(this.f22239h) ? "BIN" : this.f22239h;
    }

    public int l() {
        return this.f22255x;
    }

    public int m() {
        return this.Q;
    }

    public int o() {
        return this.E;
    }

    public int p() {
        return this.P;
    }

    public int r() {
        return this.f22257z;
    }

    public int s() {
        return this.F;
    }

    public long t() {
        return this.W;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format("manufacturerId=0x%04X, primaryIcType=%s\n", Integer.valueOf(this.F), am.a.a(this.f22235d)));
        sb2.append(String.format("address==%s, localName=%s, isHid=%b\n", fl.a.c(this.f22236e, true), this.L, Boolean.valueOf(this.T)));
        Locale locale = Locale.US;
        sb2.append(String.format(locale, "logLevel=%d\n", Integer.valueOf(this.P)));
        sb2.append(String.format("mProtocolType=0x%04X, mChannelType=0x%02x, workMode=0x%04X\n", Integer.valueOf(this.f22233b), Integer.valueOf(this.f22232a), Integer.valueOf(this.f22234c)));
        int i10 = this.f22232a;
        if (i10 == 0) {
            sb2.append(String.format("\tOtaService=%s\n", this.G));
            sb2.append(String.format("\tDfuService=%s\n", this.H));
            sb2.append(String.format("\tDfuData==%s\n", this.I));
            sb2.append(String.format("\tDfuControlPoint=%s\n", this.J));
            ConnectionParameters connectionParameters = this.K;
            if (connectionParameters != null) {
                str = String.format("\t%s\n", connectionParameters.toString());
                sb2.append(str);
            } else {
                b.j("not set connectionParameters");
            }
        } else if (i10 == 2) {
            str = String.format("\tEndPointInAddr=0x%02X, EndPointOutAddr=0x%02X\n", Integer.valueOf(this.M), Integer.valueOf(this.N));
            sb2.append(str);
        }
        sb2.append(String.format(locale, "handoverTimeout=%ds, notificationTimeout=%dms\n", Integer.valueOf(this.Q), Long.valueOf(this.W)));
        sb2.append(String.format(locale, "file location=%d, path==%s, suffix=%s\n", Integer.valueOf(this.f22237f), this.f22238g, this.f22239h));
        sb2.append(String.format("\tfileIndicator=0x%08x, imageVerifyIndicator=0x%08x\n", Integer.valueOf(this.f22240i), Integer.valueOf(this.f22241j)));
        sb2.append(String.format(locale, "\tversionCheck=%b, mode=%d, icCheck=%b, sectionSizeCheck=%b\n, batteryCheck=%b, connectBack=%b, checkOtaResult=%b\n", Boolean.valueOf(R()), Integer.valueOf(D()), Boolean.valueOf(N()), Boolean.valueOf(P()), Boolean.valueOf(this.f22256y), Boolean.valueOf(this.U), Boolean.valueOf(this.V)));
        sb2.append(String.format(locale, "conParamUpdateLatency=%b, latencyTimeout=%d", Boolean.valueOf(this.D), Integer.valueOf(this.E)));
        if (this.f22256y) {
            sb2.append(String.format(locale, "\nlowBatteryThreshold=%d, batteryLevelFormat=%d", Integer.valueOf(this.f22257z), Integer.valueOf(this.A)));
        }
        sb2.append(String.format(locale, "\nmtuUpdate=%b,bufferCheckMtuUpdateEnabled=%b,primaryMtuSize=%d", Boolean.valueOf(this.f22252u), Boolean.valueOf(this.f22253v), Integer.valueOf(this.f22251t)));
        sb2.append(String.format("\nthroughput=%b, breakpointResume=%b,waitActiveCmdAck=%b, activeImageDelayTime=%d", Boolean.valueOf(this.f22244m), Boolean.valueOf(this.f22245n), Boolean.valueOf(this.f22246o), this.f22247p));
        if (this.f22254w) {
            sb2.append(String.format(locale, ", flowControlInterval=%d ms", Integer.valueOf(this.f22255x * 50)));
        }
        sb2.append(String.format("\ncompleteAction=0x%04X, ", Integer.valueOf(this.f22248q)));
        sb2.append(String.format("\nerrorAction=0x%04X, ERROR_ACTION_DISCONNECT=%b, ERROR_ACTION_REFRESH_DEVICE=%b, EA_CLOSE_GATT=%b", Integer.valueOf(this.f22249r), Boolean.valueOf(K(1)), Boolean.valueOf(K(2)), Boolean.valueOf(K(4))));
        sb2.append(String.format(locale, "\nretransConnectTimes=%d", Integer.valueOf(this.B)));
        return sb2.toString();
    }

    public String u() {
        return this.G;
    }

    public int v() {
        return this.f22234c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f22232a);
        parcel.writeInt(this.f22233b);
        parcel.writeInt(this.f22234c);
        parcel.writeInt(this.f22235d);
        parcel.writeString(this.f22236e);
        parcel.writeInt(this.f22237f);
        parcel.writeString(this.f22238g);
        parcel.writeString(this.f22239h);
        parcel.writeInt(this.f22240i);
        parcel.writeInt(this.f22241j);
        parcel.writeInt(this.f22242k);
        parcel.writeByte(this.f22243l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f22244m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f22245n ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f22246o ? (byte) 1 : (byte) 0);
        if (this.f22247p == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(this.f22247p.longValue());
        }
        parcel.writeInt(this.f22248q);
        parcel.writeInt(this.f22249r);
        parcel.writeByteArray(this.f22250s);
        parcel.writeInt(this.f22251t);
        parcel.writeByte(this.f22252u ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f22253v ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f22254w ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f22255x);
        parcel.writeByte(this.f22256y ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f22257z);
        parcel.writeInt(this.A);
        parcel.writeInt(this.B);
        parcel.writeByte(this.C ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.D ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.E);
        parcel.writeInt(this.F);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.J);
        parcel.writeParcelable(this.K, i10);
        parcel.writeString(this.L);
        parcel.writeInt(this.M);
        parcel.writeInt(this.N);
        parcel.writeInt(this.O);
        parcel.writeInt(this.P);
        parcel.writeInt(this.Q);
        parcel.writeByte(this.R ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.S);
        parcel.writeByte(this.T ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.U ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.V ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.W);
    }

    public int x() {
        return this.S;
    }

    public int y() {
        return this.f22235d;
    }

    public int z() {
        return this.f22251t;
    }
}
