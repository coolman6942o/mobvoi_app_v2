package com.google.protobuf;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExtensionRegistryFactory.java */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    static final Class<?> f13319a = c();

    public static q a() {
        if (f13319a != null) {
            try {
                return b("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return q.f13331c;
    }

    private static final q b(String str) throws Exception {
        return (q) f13319a.getMethod(str, new Class[0]).invoke(null, new Object[0]);
    }

    static Class<?> c() {
        try {
            o oVar = o.f13299h;
            return o.class;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
