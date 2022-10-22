package hf;

import ef.u;
import java.util.List;
import java.util.Locale;
/* compiled from: QueryClient.java */
/* loaded from: classes2.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public m f27847a;

    /* renamed from: b  reason: collision with root package name */
    public List<u> f27848b;

    public n() {
        this.f27847a = new m();
        this.f27848b = null;
    }

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[2];
        objArr[0] = this.f27847a;
        List<u> list = this.f27848b;
        objArr[1] = Integer.valueOf(list == null ? -1 : list.size());
        return String.format(locale, "Result with %s, got %d summaries", objArr);
    }

    public n(m mVar, List<u> list) {
        this.f27847a = mVar;
        this.f27848b = list;
    }
}
