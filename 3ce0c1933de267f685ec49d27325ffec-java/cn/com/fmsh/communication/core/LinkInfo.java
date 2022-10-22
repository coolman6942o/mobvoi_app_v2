package cn.com.fmsh.communication.core;
/* loaded from: classes.dex */
public class LinkInfo {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f6050a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ int f6051b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ int f6052c = -1;

    /* loaded from: classes.dex */
    public enum LinkType {
        TCP,
        UDP,
        HTTP
    }

    public String a() {
        return this.f6050a;
    }

    public int b() {
        return this.f6051b;
    }

    public int c() {
        return this.f6052c;
    }

    public void d(String str) {
        this.f6050a = str;
    }

    public void e(int i10) {
        this.f6051b = i10;
    }

    public void f(int i10) {
        this.f6052c = i10;
    }
}
