package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import b6.h;
import b6.i;
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f8944a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static e f8945b;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f8946a;

        /* renamed from: b  reason: collision with root package name */
        private final String f8947b;

        /* renamed from: c  reason: collision with root package name */
        private final ComponentName f8948c = null;

        /* renamed from: d  reason: collision with root package name */
        private final int f8949d;

        public a(String str, String str2, int i10) {
            this.f8946a = i.g(str);
            this.f8947b = i.g(str2);
            this.f8949d = i10;
        }

        public final ComponentName a() {
            return this.f8948c;
        }

        public final String b() {
            return this.f8947b;
        }

        public final Intent c(Context context) {
            if (this.f8946a != null) {
                return new Intent(this.f8946a).setPackage(this.f8947b);
            }
            return new Intent().setComponent(this.f8948c);
        }

        public final int d() {
            return this.f8949d;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return h.a(this.f8946a, aVar.f8946a) && h.a(this.f8947b, aVar.f8947b) && h.a(this.f8948c, aVar.f8948c) && this.f8949d == aVar.f8949d;
        }

        public final int hashCode() {
            return h.b(this.f8946a, this.f8947b, this.f8948c, Integer.valueOf(this.f8949d));
        }

        public final String toString() {
            String str = this.f8946a;
            return str == null ? this.f8948c.flattenToString() : str;
        }
    }

    public static e a(Context context) {
        synchronized (f8944a) {
            if (f8945b == null) {
                f8945b = new u(context.getApplicationContext());
            }
        }
        return f8945b;
    }

    public final void b(String str, String str2, int i10, ServiceConnection serviceConnection, String str3) {
        d(new a(str, str2, i10), serviceConnection, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean c(a aVar, ServiceConnection serviceConnection, String str);

    protected abstract void d(a aVar, ServiceConnection serviceConnection, String str);
}
