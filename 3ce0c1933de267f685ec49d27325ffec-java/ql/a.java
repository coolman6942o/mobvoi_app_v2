package ql;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kl.b;
/* loaded from: classes2.dex */
public class a extends BufferedInputStream {

    /* renamed from: m  reason: collision with root package name */
    public static final boolean f33239m = b.f30016b;

    /* renamed from: a  reason: collision with root package name */
    public int f33240a;

    /* renamed from: b  reason: collision with root package name */
    public int f33241b;

    /* renamed from: c  reason: collision with root package name */
    public int f33242c = 1;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33243d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33244e;

    /* renamed from: f  reason: collision with root package name */
    public int f33245f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f33246g;

    /* renamed from: h  reason: collision with root package name */
    public int f33247h;

    /* renamed from: i  reason: collision with root package name */
    public int f33248i;

    /* renamed from: j  reason: collision with root package name */
    public ArrayList<vl.a> f33249j;

    /* renamed from: k  reason: collision with root package name */
    public String f33250k;

    /* renamed from: l  reason: collision with root package name */
    public long f33251l;

    public a(Context context, String str, InputStream inputStream, long j10) {
        super(inputStream);
        if (available() >= 44) {
            this.f33250k = str;
            this.f33251l = j10;
            O();
            o(context);
            close();
            return;
        }
        throw new IOException("The input file size is less to 44, please check!");
    }

    public a(String str, long j10, InputStream inputStream) {
        super(inputStream);
        if (available() >= 44) {
            this.f33250k = str;
            this.f33251l = j10;
            O();
            Q();
            close();
            return;
        }
        throw new IOException("The input file size is less to 44, please check!");
    }

    public static a d(Context context, String str, InputStream inputStream, long j10) {
        a aVar = null;
        if (inputStream == null) {
            il.b.l("InputStream can not be null");
            return null;
        }
        try {
            aVar = new a(context, str, inputStream, j10);
        } catch (IOException e10) {
            if (f33239m) {
                il.b.c(e10.toString());
            }
        }
        try {
            inputStream.close();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        return aVar;
    }

    public static a h(String str) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            a i10 = i(str, 0L, bufferedInputStream);
            try {
                bufferedInputStream.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            return i10;
        } catch (IOException e11) {
            if (!f33239m) {
                return null;
            }
            il.b.j(e11.toString());
            return null;
        }
    }

    public static a i(String str, long j10, InputStream inputStream) {
        a aVar;
        try {
            aVar = new a(str, j10, inputStream);
        } catch (IOException e10) {
            if (f33239m) {
                il.b.c(e10.toString());
            }
            aVar = null;
        }
        try {
            inputStream.close();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        return aVar;
    }

    public List<vl.a> E(int i10) {
        ArrayList arrayList = new ArrayList();
        ArrayList<vl.a> arrayList2 = this.f33249j;
        if (arrayList2 != null && arrayList2.size() > 0) {
            int i11 = 16;
            if (this.f33242c >= 2) {
                i11 = 128;
            }
            if (i10 == 1) {
                Iterator<vl.a> it = this.f33249j.iterator();
                while (it.hasNext()) {
                    vl.a next = it.next();
                    int i12 = next.f35830c;
                    if (i12 >= i11 || (this.f33245f == 11 && i12 == 24)) {
                        arrayList.add(next);
                    }
                }
            } else {
                Iterator<vl.a> it2 = this.f33249j.iterator();
                while (it2.hasNext()) {
                    vl.a next2 = it2.next();
                    if (next2.f35830c < i11) {
                        arrayList.add(next2);
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean I() {
        return this.f33243d;
    }

    public final void O() {
        byte[] bArr = new byte[40];
        read(bArr, 0, 40);
        boolean z10 = true;
        if (f33239m) {
            il.b.j(String.format(Locale.US, "PackHeader:(%d)%s", 40, jl.a.a(bArr)));
        }
        int i10 = (((bArr[1] << 8) & 65280) | (bArr[0] & 255)) & 65535;
        this.f33240a = i10;
        if (i10 == 19783) {
            this.f33241b = ((bArr[5] << 24) & (-16777216)) | ((bArr[4] << 16) & 16711680) | ((bArr[3] << 8) & 65280) | (bArr[2] & 255);
            System.arraycopy(bArr, 6, new byte[32], 0, 32);
            int i11 = ((bArr[38] & 255) | (65280 & (bArr[39] << 8))) & 65535;
            int i12 = i11 & 15;
            this.f33242c = i12;
            this.f33244e = ((byte) ((i11 >> 7) & 1)) == 1;
            this.f33245f = (i11 >> 8) & 255;
            if (i12 <= 1) {
                this.f33243d = true;
                this.f33247h = 4;
            } else {
                if (!(i12 == 2 || ((byte) ((i11 >> 6) & 1)) == 1)) {
                    z10 = false;
                }
                this.f33243d = z10;
                this.f33247h = 32;
            }
            int i13 = this.f33247h;
            byte[] bArr2 = new byte[i13];
            this.f33246g = bArr2;
            read(bArr2, 0, i13);
            this.f33251l += 40 + this.f33247h;
            return;
        }
        throw new IOException(String.format("The signature(0x%04X) is not right", Integer.valueOf(this.f33240a)));
    }

    public final void Q() {
        byte[] bArr;
        int i10;
        this.f33248i = 0;
        this.f33249j = new ArrayList<>();
        byte[] bArr2 = this.f33246g;
        int length = bArr2.length;
        for (byte b10 : bArr2) {
            for (int i11 = 0; i11 < 8; i11++) {
                if (((byte) (((byte) (b10 >> i11)) & 1)) == 1) {
                    this.f33248i++;
                }
            }
        }
        long j10 = this.f33251l + (this.f33248i * 12);
        int i12 = 0;
        for (byte b11 : this.f33246g) {
            int i13 = 0;
            while (i13 < 8) {
                if (((byte) (((byte) (b11 >> i13)) & 1)) == 1) {
                    byte[] bArr3 = new byte[12];
                    read(bArr3, 0, 12);
                    i10 = i13;
                    vl.a c10 = vl.a.c(this.f33245f, this.f33250k, i12, this.f33247h * 4, j10, bArr3);
                    if (f33239m) {
                        il.b.j(c10.toString());
                    }
                    this.f33249j.add(c10);
                    j10 += c10.f35834g;
                } else {
                    i10 = i13;
                }
                i12++;
                i13 = i10 + 1;
            }
        }
    }

    public int c() {
        return this.f33247h * 4;
    }

    public vl.a n(int i10) {
        Iterator<vl.a> it = this.f33249j.iterator();
        while (it.hasNext()) {
            vl.a next = it.next();
            if (next.f35836i == i10) {
                return next;
            }
        }
        return null;
    }

    public final void o(Context context) {
        byte[] bArr;
        int i10;
        this.f33248i = 0;
        this.f33249j = new ArrayList<>();
        byte[] bArr2 = this.f33246g;
        int length = bArr2.length;
        for (byte b10 : bArr2) {
            for (int i11 = 0; i11 < 8; i11++) {
                if (((byte) (((byte) (b10 >> i11)) & 1)) == 1) {
                    this.f33248i++;
                }
            }
        }
        long j10 = this.f33251l + (this.f33248i * 12);
        int i12 = 0;
        for (byte b11 : this.f33246g) {
            int i13 = 0;
            while (i13 < 8) {
                if (((byte) (((byte) (b11 >> i13)) & 1)) == 1) {
                    byte[] bArr3 = new byte[12];
                    read(bArr3, 0, 12);
                    i10 = i13;
                    vl.a d10 = vl.a.d(context, this.f33245f, this.f33250k, i12, this.f33247h * 4, j10, bArr3);
                    if (f33239m) {
                        il.b.j(d10.toString());
                    }
                    this.f33249j.add(d10);
                    j10 += d10.f35834g;
                } else {
                    i10 = i13;
                }
                i12++;
                i13 = i10 + 1;
            }
        }
    }

    public boolean q(int i10, int i11) {
        wl.a w10 = w(i10, i11);
        if (w10 == null) {
            return false;
        }
        try {
            w10.close();
            return true;
        } catch (IOException e10) {
            e10.printStackTrace();
            return true;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (f33239m) {
            sb2.append(String.format("signature==0x%04X", Integer.valueOf(this.f33240a)));
        }
        sb2.append(String.format(Locale.US, "size=0x%08x(%d)", Integer.valueOf(this.f33241b), Integer.valueOf(this.f33241b)) + String.format("packVersion=0x%02X, dualBank=%b", Integer.valueOf(this.f33242c), Boolean.valueOf(this.f33244e)) + String.format(", icType=0x%02X", Integer.valueOf(this.f33245f)) + String.format(", subFileNum=0x%04X, subFileIndicator=%s", Integer.valueOf(this.f33248i), jl.a.a(this.f33246g)));
        return sb2.toString();
    }

    public int u() {
        return this.f33245f;
    }

    public vl.a v(int i10) {
        Iterator<vl.a> it = this.f33249j.iterator();
        while (it.hasNext()) {
            vl.a next = it.next();
            if (next.f35830c == i10) {
                return next;
            }
        }
        return null;
    }

    public wl.a w(int i10, int i11) {
        ArrayList<vl.a> arrayList = this.f33249j;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<vl.a> it = this.f33249j.iterator();
            while (it.hasNext()) {
                vl.a next = it.next();
                if (next.f35830c == i10) {
                    return next.f(next.f35828a);
                }
            }
        }
        return null;
    }

    public ArrayList<vl.a> x() {
        return this.f33249j;
    }
}
