package androidx.work;

import android.app.Notification;
/* compiled from: ForegroundInfo.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final int f4743a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4744b;

    /* renamed from: c  reason: collision with root package name */
    private final Notification f4745c;

    public e(int i10, Notification notification, int i11) {
        this.f4743a = i10;
        this.f4745c = notification;
        this.f4744b = i11;
    }

    public int a() {
        return this.f4744b;
    }

    public Notification b() {
        return this.f4745c;
    }

    public int c() {
        return this.f4743a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f4743a == eVar.f4743a && this.f4744b == eVar.f4744b) {
            return this.f4745c.equals(eVar.f4745c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f4743a * 31) + this.f4744b) * 31) + this.f4745c.hashCode();
    }

    public String toString() {
        return "ForegroundInfo{mNotificationId=" + this.f4743a + ", mForegroundServiceType=" + this.f4744b + ", mNotification=" + this.f4745c + '}';
    }
}
