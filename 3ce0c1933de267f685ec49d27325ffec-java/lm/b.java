package lm;

import android.hardware.usb.UsbDevice;
import java.util.Locale;
import java.util.UUID;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f30521a;

    /* renamed from: b  reason: collision with root package name */
    public String f30522b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30523c;

    /* renamed from: d  reason: collision with root package name */
    public int f30524d;

    /* renamed from: e  reason: collision with root package name */
    public UUID f30525e;

    /* renamed from: f  reason: collision with root package name */
    public UUID f30526f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f30527g;

    /* renamed from: h  reason: collision with root package name */
    public int f30528h;

    /* renamed from: lm.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0389b {

        /* renamed from: a  reason: collision with root package name */
        public String f30529a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f30530b;

        /* renamed from: c  reason: collision with root package name */
        public String f30531c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f30532d;

        /* renamed from: h  reason: collision with root package name */
        public UsbDevice f30536h;

        /* renamed from: j  reason: collision with root package name */
        public boolean f30538j;

        /* renamed from: e  reason: collision with root package name */
        public int f30533e = 1;

        /* renamed from: f  reason: collision with root package name */
        public UUID f30534f = UUID.fromString("0000d0ff-3c17-d293-8e48-14fe2e4da212");

        /* renamed from: g  reason: collision with root package name */
        public UUID f30535g = UUID.fromString("00006287-3c17-d293-8e48-14fe2e4da212");

        /* renamed from: i  reason: collision with root package name */
        public int f30537i = 2;

        /* renamed from: k  reason: collision with root package name */
        public int f30539k = 1;

        public C0389b a(String str) {
            this.f30529a = str;
            return this;
        }

        public b b() {
            return new b(this.f30529a, this.f30530b, this.f30531c, this.f30532d, this.f30533e, this.f30534f, this.f30535g, this.f30536h, this.f30537i, this.f30538j, this.f30539k);
        }

        public C0389b c(int i10) {
            this.f30533e = i10;
            return this;
        }
    }

    public b(String str, boolean z10, String str2, boolean z11, int i10, UUID uuid, UUID uuid2, UsbDevice usbDevice, int i11, boolean z12, int i12) {
        this.f30524d = 1;
        this.f30525e = UUID.fromString("0000d0ff-3c17-d293-8e48-14fe2e4da212");
        this.f30526f = UUID.fromString("00006287-3c17-d293-8e48-14fe2e4da212");
        this.f30528h = 1;
        this.f30521a = str;
        this.f30522b = str2;
        this.f30523c = z11;
        this.f30524d = i10;
        this.f30525e = uuid;
        this.f30526f = uuid2;
        this.f30527g = z12;
        this.f30528h = i12;
    }

    public String a() {
        return this.f30521a;
    }

    public int b() {
        return this.f30528h;
    }

    public UUID c() {
        return this.f30526f;
    }

    public String d() {
        return this.f30522b;
    }

    public UUID e() {
        return this.f30525e;
    }

    public int f() {
        return this.f30524d;
    }

    public boolean g() {
        return this.f30523c;
    }

    public boolean h() {
        return this.f30527g;
    }

    public String toString() {
        return "ConnectParams{\n" + String.format("localName=%s, address=%s\n", this.f30522b, fl.a.c(this.f30521a, true)) + String.format("isHid=%b\n", Boolean.valueOf(this.f30523c)) + String.format("refreshCache=%b\n", Boolean.valueOf(this.f30527g)) + String.format(Locale.US, "reconnectTimes=%d\n", Integer.valueOf(this.f30524d)) + "}";
    }
}
