package cm;

import android.util.SparseIntArray;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f5978a;

    /* renamed from: b  reason: collision with root package name */
    public String f5979b;

    /* renamed from: c  reason: collision with root package name */
    public long f5980c;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5982e;

    /* renamed from: f  reason: collision with root package name */
    public int f5983f;

    /* renamed from: g  reason: collision with root package name */
    public int f5984g;

    /* renamed from: l  reason: collision with root package name */
    public List<vl.a> f5989l;

    /* renamed from: m  reason: collision with root package name */
    public List<wl.a> f5990m;

    /* renamed from: n  reason: collision with root package name */
    public List<vl.a> f5991n;

    /* renamed from: o  reason: collision with root package name */
    public List<vl.a> f5992o;

    /* renamed from: p  reason: collision with root package name */
    public List<wl.a> f5993p;

    /* renamed from: q  reason: collision with root package name */
    public SparseIntArray f5994q;

    /* renamed from: d  reason: collision with root package name */
    public int f5981d = 1;

    /* renamed from: h  reason: collision with root package name */
    public int f5985h = 4096;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5986i = true;

    /* renamed from: j  reason: collision with root package name */
    public int f5987j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f5988k = 15;

    public wl.a a(int i10) {
        List<wl.a> list = this.f5990m;
        if (list != null && list.size() > 0) {
            for (wl.a aVar : this.f5990m) {
                if (aVar.w() == i10) {
                    return aVar;
                }
            }
        }
        return null;
    }

    public List<vl.a> b(int i10) {
        return i10 == 1 ? this.f5991n : this.f5989l;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("BinInfo{\n");
        sb2.append(String.format("path=%s\n", this.f5978a));
        Locale locale = Locale.US;
        sb2.append(String.format(locale, "fileName=%s, fileSize=%d\n", this.f5979b, Long.valueOf(this.f5980c)));
        sb2.append(String.format(locale, "fileType=0x%02X, isPackFile=%b, bankIndicator=0x%02X, updateBank=0x%02X\n", Integer.valueOf(this.f5981d), Boolean.valueOf(this.f5982e), Integer.valueOf(this.f5987j), Integer.valueOf(this.f5988k)));
        sb2.append(String.format(locale, "icType=0x%02X, updateEnabled=%b, status=%d\n", Integer.valueOf(this.f5983f), Boolean.valueOf(this.f5986i), Integer.valueOf(this.f5985h)));
        if (this.f5982e) {
            Object[] objArr = new Object[1];
            List<vl.a> list = this.f5989l;
            objArr[0] = Integer.valueOf(list != null ? list.size() : 0);
            sb2.append(String.format(locale, "subFileInfos.size=%d\n", objArr));
            Object[] objArr2 = new Object[1];
            List<vl.a> list2 = this.f5992o;
            objArr2[0] = Integer.valueOf(list2 != null ? list2.size() : 0);
            str = String.format(locale, "supportSubFileInfos.size=%d\n", objArr2);
        } else {
            Object[] objArr3 = new Object[1];
            List<wl.a> list3 = this.f5990m;
            objArr3[0] = Integer.valueOf(list3 != null ? list3.size() : 0);
            sb2.append(String.format(locale, "subBinInputStreams.size=%d\n", objArr3));
            Object[] objArr4 = new Object[1];
            List<wl.a> list4 = this.f5993p;
            objArr4[0] = Integer.valueOf(list4 != null ? list4.size() : 0);
            sb2.append(String.format(locale, "supportBinInputStreams.size=%d\n", objArr4));
            str = String.format(locale, "version=%d\n", Integer.valueOf(this.f5984g));
        }
        sb2.append(str);
        sb2.append("}");
        return sb2.toString();
    }
}
