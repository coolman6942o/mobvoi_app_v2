package qf;

import android.text.TextUtils;
import com.mobvoi.android.common.utils.d;
import com.mobvoi.health.common.data.pojo.DataType;
import java.util.Locale;
import yf.e;
/* compiled from: DataPoint.java */
/* loaded from: classes2.dex */
public class a extends b<DataType> {

    /* renamed from: i  reason: collision with root package name */
    public int f33123i;

    /* renamed from: j  reason: collision with root package name */
    public String f33124j;

    public a() {
        super(DataType.class);
        this.f33124j = "";
    }

    public static a d(String str, String str2, int i10, ag.a aVar) {
        a aVar2 = new a();
        aVar2.f33126b = str;
        if (str2 == null) {
            str2 = "";
        }
        aVar2.f33125a = str2;
        aVar2.f33127c = i10;
        aVar2.f33129e = aVar.time_from;
        aVar2.f33128d = aVar.time_to;
        aVar2.f33124j = aVar.values;
        aVar2.f33131g = aVar.deleted;
        aVar2.f33130f = 1;
        return aVar2;
    }

    public float e() {
        float[] f10 = f();
        if (f10.length == 0) {
            return 0.0f;
        }
        return f10[0];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f33127c == aVar.f33127c && this.f33129e == aVar.f33129e && this.f33128d == aVar.f33128d && TextUtils.equals(this.f33124j, aVar.f33124j) && TextUtils.equals(this.f33126b, aVar.f33126b) && TextUtils.equals(this.f33125a, aVar.f33125a);
    }

    public float[] f() {
        String[] split = this.f33124j.split(",");
        float[] fArr = new float[split.length];
        for (int i10 = 0; i10 < split.length; i10++) {
            fArr[i10] = Float.parseFloat(split[i10]);
        }
        return fArr;
    }

    public boolean g() {
        if (this.f33127c != -1) {
            long j10 = this.f33129e;
            long j11 = this.f33128d;
            if (j10 <= j11 && j10 > 0 && j11 > e.f37076a && j11 - j10 < e.f37077b) {
                return true;
            }
        }
        return false;
    }

    public void h(float... fArr) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < fArr.length; i10++) {
            float f10 = fArr[i10];
            int round = Math.round(f10);
            if (round == f10) {
                sb2.append(round);
            } else {
                sb2.append(f10);
            }
            if (i10 != fArr.length - 1) {
                sb2.append(",");
            }
        }
        this.f33124j = sb2.toString();
    }

    public void i(long... jArr) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < jArr.length; i10++) {
            sb2.append(jArr[i10]);
            if (i10 != jArr.length - 1) {
                sb2.append(",");
            }
        }
        this.f33124j = sb2.toString();
    }

    public String toString() {
        return String.format(Locale.US, "DataPoint[{%s ~ %s}, %s, synced=%s, value=%s, wwid=%s, did=%s, id=%s]", d.a(this.f33129e), d.a(this.f33128d), c(), Integer.valueOf(this.f33130f), this.f33124j, this.f33126b, this.f33125a, Integer.valueOf(this.f33123i));
    }

    public a(DataType dataType, long j10) {
        super(dataType, j10, j10);
        this.f33124j = "";
    }

    public a(DataType dataType, long j10, long j11) {
        super(dataType, j10, j11);
        this.f33124j = "";
    }

    public a(DataType dataType, long j10, long j11, String str) {
        super(dataType, j10, j11);
        this.f33124j = "";
        this.f33124j = str;
    }

    public a(DataType dataType, long j10, long j11, float... fArr) {
        super(dataType, j10, j11);
        this.f33124j = "";
        h(fArr);
    }
}
