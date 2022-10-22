package com.bumptech.glide;

import com.bumptech.glide.i;
import l5.a;
import l5.c;
/* compiled from: TransitionOptions.java */
/* loaded from: classes.dex */
public abstract class i<CHILD extends i<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private c<? super TranscodeType> f7862a = a.b();

    /* renamed from: a */
    public final CHILD clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final c<? super TranscodeType> b() {
        return this.f7862a;
    }
}
