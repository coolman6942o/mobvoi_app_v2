package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;
/* compiled from: JsonObject.java */
/* loaded from: classes.dex */
public final class m extends k {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedTreeMap<String, k> f12653a = new LinkedTreeMap<>();

    public Set<Map.Entry<String, k>> entrySet() {
        return this.f12653a.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof m) && ((m) obj).f12653a.equals(this.f12653a));
    }

    public void h(String str, k kVar) {
        if (kVar == null) {
            kVar = l.f12652a;
        }
        this.f12653a.put(str, kVar);
    }

    public int hashCode() {
        return this.f12653a.hashCode();
    }
}
