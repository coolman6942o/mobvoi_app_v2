package dp;

import h8.c;
/* compiled from: Manifest.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private a f25681a;

    /* renamed from: b  reason: collision with root package name */
    private a f25682b;

    /* renamed from: c  reason: collision with root package name */
    private a f25683c;
    @c("softdevice_bootloader")

    /* renamed from: d  reason: collision with root package name */
    private d f25684d;
    @c("bootloader_application")

    /* renamed from: e  reason: collision with root package name */
    private a f25685e;
    @c("softdevice_application")

    /* renamed from: f  reason: collision with root package name */
    private a f25686f;
    @c("softdevice_bootloader_application")

    /* renamed from: g  reason: collision with root package name */
    private a f25687g;

    public a a() {
        a aVar = this.f25681a;
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = this.f25686f;
        if (aVar2 != null) {
            return aVar2;
        }
        a aVar3 = this.f25685e;
        return aVar3 != null ? aVar3 : this.f25687g;
    }

    public a b() {
        return this.f25682b;
    }

    public d c() {
        return this.f25684d;
    }

    public a d() {
        return this.f25683c;
    }

    public boolean e() {
        return (this.f25685e == null && this.f25686f == null && this.f25687g == null) ? false : true;
    }
}
