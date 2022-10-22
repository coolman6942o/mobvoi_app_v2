package io.reactivex.subjects;

import io.reactivex.k;
import io.reactivex.r;
/* compiled from: Subject.java */
/* loaded from: classes3.dex */
public abstract class c<T> extends k<T> implements r<T> {
    public final c<T> b() {
        return this instanceof b ? this : new b(this);
    }
}
