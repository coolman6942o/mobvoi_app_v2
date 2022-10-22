package hf;

import ef.u;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* compiled from: QueryClient.java */
/* loaded from: classes2.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public Date f27843a;

    /* renamed from: b  reason: collision with root package name */
    public Date f27844b;

    /* renamed from: c  reason: collision with root package name */
    public int f27845c;

    /* renamed from: d  reason: collision with root package name */
    public List<u> f27846d;

    public m() {
        this.f27843a = null;
        this.f27844b = null;
        this.f27845c = -1;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Request in [%s, %s), count %d", this.f27843a, this.f27844b, Integer.valueOf(this.f27845c));
    }

    public m(Date date, Date date2, int i10) {
        this.f27843a = date;
        this.f27844b = date2;
        this.f27845c = i10;
    }
}
