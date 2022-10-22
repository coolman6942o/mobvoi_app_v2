package g2;

import cn.com.fmsh.communication.message.enumerate.ETagType;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ byte f27221a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ int f27222b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ ETagType f27223c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ List<g> f27224d = new ArrayList();

    public void a(g gVar) {
        if (gVar != null) {
            this.f27224d.add(gVar);
        }
    }

    public byte b() {
        return this.f27221a;
    }

    public int c() {
        return this.f27222b;
    }

    public g[] d() {
        return (g[]) this.f27224d.toArray(new g[0]);
    }

    public ETagType e() {
        return this.f27223c;
    }

    public void f(String str) {
    }

    public void g(byte b10) {
        this.f27221a = b10;
    }

    public void h(int i10) {
        this.f27222b = i10;
    }

    public void i(ETagType eTagType) {
        this.f27223c = eTagType;
    }
}
