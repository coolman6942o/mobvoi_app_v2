package bn;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f5343a;

    /* renamed from: b  reason: collision with root package name */
    private s f5344b;

    /* renamed from: c  reason: collision with root package name */
    private List<k> f5345c;

    /* renamed from: d  reason: collision with root package name */
    private List<l> f5346d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private List<j> f5347e = new ArrayList();

    public List<j> a() {
        return this.f5347e;
    }

    public List<l> b() {
        return this.f5346d;
    }

    public List<k> c() {
        return this.f5345c;
    }

    public byte[] d() {
        return this.f5343a;
    }

    public s e() {
        return this.f5344b;
    }

    public void f(List<j> list) {
        this.f5347e = list;
    }

    public void g(List<l> list) {
        this.f5346d = list;
    }

    public void h(List<k> list) {
        this.f5345c = list;
    }

    public void i(byte[] bArr) {
        this.f5343a = bArr;
    }

    public void j(s sVar) {
        this.f5344b = sVar;
    }
}
