package a6;

import b6.h;
import b6.i;
import com.google.android.gms.common.data.DataHolder;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    protected final DataHolder f105a;

    /* renamed from: b  reason: collision with root package name */
    protected int f106b;

    /* renamed from: c  reason: collision with root package name */
    private int f107c;

    public d(DataHolder dataHolder, int i10) {
        this.f105a = (DataHolder) i.k(dataHolder);
        d(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] a(String str) {
        return this.f105a.G0(str, this.f106b, this.f107c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b(String str) {
        return this.f105a.H0(str, this.f106b, this.f107c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c(String str) {
        return this.f105a.K0(str, this.f106b, this.f107c);
    }

    protected final void d(int i10) {
        i.n(i10 >= 0 && i10 < this.f105a.getCount());
        this.f106b = i10;
        this.f107c = this.f105a.L0(i10);
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (h.a(Integer.valueOf(dVar.f106b), Integer.valueOf(this.f106b)) && h.a(Integer.valueOf(dVar.f107c), Integer.valueOf(this.f107c)) && dVar.f105a == this.f105a) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return h.b(Integer.valueOf(this.f106b), Integer.valueOf(this.f107c), this.f105a);
    }
}
