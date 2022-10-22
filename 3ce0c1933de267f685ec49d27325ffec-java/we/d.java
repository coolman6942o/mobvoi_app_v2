package we;

import ef.p;
import java.util.ArrayList;
import java.util.List;
import tf.a;
import xf.f;
/* compiled from: SmoothAnalyzer.java */
/* loaded from: classes2.dex */
public abstract class d<Data extends f> extends a<Data> {

    /* renamed from: b  reason: collision with root package name */
    private boolean f36226b = false;

    private boolean h(double d10, double d11) {
        return d10 >= d11 - 0.001d && d10 <= d11 + 0.001d;
    }

    @Override // we.a, we.b
    public List<Data> a(Iterable<p> iterable) {
        List<Data> a10 = super.a(iterable);
        if (a10.isEmpty()) {
            return a10;
        }
        boolean z10 = true;
        double a11 = (a10.get(a10.size() - 1).a() - a10.get(0).a()) / 160.0d;
        double d10 = 20.0d;
        if (a11 >= 20.0d) {
            d10 = a11;
        }
        a aVar = new a(d10);
        int min = Math.min(160, a10.size());
        if (a10.size() <= 16) {
            z10 = false;
        }
        if (a11 < 5.0d) {
            a11 = 5.0d;
        }
        ArrayList arrayList = new ArrayList(min);
        Data data = null;
        double d11 = 0.0d;
        double d12 = 0.0d;
        for (Data data2 : a10) {
            while (this.f36226b && data != null && data2.a() - data.a() > 15.0d) {
                double a12 = data.a() + 15.0d;
                data = f(a12, d11);
                if (h(data.a(), a12)) {
                    arrayList.add(data);
                    d11 = 0.0d;
                } else {
                    throw new RuntimeException("New created data time is invalid, should be " + a12 + ", but is " + data.a());
                }
            }
            data = f(data2.a(), aVar.a(data2.a(), data2.getValue()));
            if (!z10) {
                arrayList.add(data);
            } else if (data.a() - d12 > a11) {
                arrayList.add(data);
                d12 = data.a();
            }
            d11 = 0.0d;
        }
        return arrayList;
    }

    protected abstract Data f(double d10, double d11);

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        this.f36226b = true;
    }
}
