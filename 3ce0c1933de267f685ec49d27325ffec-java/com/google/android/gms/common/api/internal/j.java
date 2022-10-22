package com.google.android.gms.common.api.internal;

import android.os.Looper;
import b6.i;
import com.google.android.gms.common.api.internal.i;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private final Set<i<?>> f8637a = Collections.newSetFromMap(new WeakHashMap());

    public static <L> i<L> a(L l10, Looper looper, String str) {
        i.l(l10, "Listener must not be null");
        i.l(looper, "Looper must not be null");
        i.l(str, "Listener type must not be null");
        return new i<>(looper, l10, str);
    }

    public static <L> i.a<L> b(L l10, String str) {
        b6.i.l(l10, "Listener must not be null");
        b6.i.l(str, "Listener type must not be null");
        b6.i.h(str, "Listener type must not be empty");
        return new i.a<>(l10, str);
    }

    public final void c() {
        for (i<?> iVar : this.f8637a) {
            iVar.a();
        }
        this.f8637a.clear();
    }
}
