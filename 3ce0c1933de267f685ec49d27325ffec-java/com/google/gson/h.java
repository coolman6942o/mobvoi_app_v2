package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: JsonArray.java */
/* loaded from: classes.dex */
public final class h extends k implements Iterable<k> {

    /* renamed from: a  reason: collision with root package name */
    private final List<k> f12580a = new ArrayList();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof h) && ((h) obj).f12580a.equals(this.f12580a));
    }

    public void h(k kVar) {
        if (kVar == null) {
            kVar = l.f12652a;
        }
        this.f12580a.add(kVar);
    }

    public int hashCode() {
        return this.f12580a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<k> iterator() {
        return this.f12580a.iterator();
    }
}
