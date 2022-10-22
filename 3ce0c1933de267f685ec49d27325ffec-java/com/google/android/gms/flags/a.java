package com.google.android.gms.flags;

import android.os.RemoteException;
/* loaded from: classes.dex */
public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f9058a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9059b;

    /* renamed from: c  reason: collision with root package name */
    private final T f9060c;

    /* renamed from: com.google.android.gms.flags.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0111a extends a<Boolean> {
        public C0111a(int i10, String str, Boolean bool) {
            super(i10, str, bool);
        }

        /* renamed from: j */
        public Boolean f(com.google.android.gms.flags.d dVar) {
            try {
                return Boolean.valueOf(dVar.getBooleanFlagValue(h(), g().booleanValue(), i()));
            } catch (RemoteException unused) {
                return g();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a<Integer> {
        public b(int i10, String str, Integer num) {
            super(i10, str, num);
        }

        /* renamed from: j */
        public Integer f(com.google.android.gms.flags.d dVar) {
            try {
                return Integer.valueOf(dVar.getIntFlagValue(h(), g().intValue(), i()));
            } catch (RemoteException unused) {
                return g();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends a<Long> {
        public c(int i10, String str, Long l10) {
            super(i10, str, l10);
        }

        /* renamed from: j */
        public Long f(com.google.android.gms.flags.d dVar) {
            try {
                return Long.valueOf(dVar.getLongFlagValue(h(), g().longValue(), i()));
            } catch (RemoteException unused) {
                return g();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d extends a<String> {
        public d(int i10, String str, String str2) {
            super(i10, str, str2);
        }

        /* renamed from: j */
        public String f(com.google.android.gms.flags.d dVar) {
            try {
                return dVar.getStringFlagValue(h(), g(), i());
            } catch (RemoteException unused) {
                return g();
            }
        }
    }

    private a(int i10, String str, T t10) {
        this.f9058a = i10;
        this.f9059b = str;
        this.f9060c = t10;
        l6.a.a().b(this);
    }

    public static C0111a a(int i10, String str, Boolean bool) {
        return new C0111a(i10, str, bool);
    }

    public static b b(int i10, String str, int i11) {
        return new b(i10, str, Integer.valueOf(i11));
    }

    public static c c(int i10, String str, long j10) {
        return new c(i10, str, Long.valueOf(j10));
    }

    public static d d(int i10, String str, String str2) {
        return new d(i10, str, str2);
    }

    public T e() {
        return (T) l6.a.b().a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T f(com.google.android.gms.flags.d dVar);

    public T g() {
        return this.f9060c;
    }

    public String h() {
        return this.f9059b;
    }

    public int i() {
        return this.f9058a;
    }
}
