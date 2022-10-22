package com.google.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* compiled from: ExtensionRegistryLite.java */
/* loaded from: classes.dex */
public class q {

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f13330b = false;

    /* renamed from: c  reason: collision with root package name */
    static final q f13331c = new q(true);

    /* renamed from: a  reason: collision with root package name */
    private final Map<Object, Object> f13332a;

    static {
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q() {
        this.f13332a = new HashMap();
    }

    public static q a() {
        return p.a();
    }

    public static boolean b() {
        return f13330b;
    }

    static Class<?> c() {
        return Extension.class;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(q qVar) {
        if (qVar == f13331c) {
            this.f13332a = Collections.emptyMap();
        } else {
            this.f13332a = Collections.unmodifiableMap(qVar.f13332a);
        }
    }

    q(boolean z10) {
        this.f13332a = Collections.emptyMap();
    }
}
