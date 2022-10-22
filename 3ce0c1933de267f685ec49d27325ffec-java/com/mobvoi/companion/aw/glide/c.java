package com.mobvoi.companion.aw.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.h;
import g5.m;
/* compiled from: GlideRequests.java */
/* loaded from: classes2.dex */
public class c extends h {
    public c(com.bumptech.glide.c cVar, g5.h hVar, m mVar, Context context) {
        super(cVar, hVar, mVar, context);
    }

    /* renamed from: B */
    public <ResourceType> b<ResourceType> i(Class<ResourceType> cls) {
        return new b<>(this.f7847a, this, cls, this.f7848b);
    }

    /* renamed from: C */
    public b<Bitmap> j() {
        return (b) super.j();
    }

    /* renamed from: D */
    public b<Drawable> k() {
        return (b) super.k();
    }

    /* renamed from: E */
    public b<Drawable> q(Uri uri) {
        return (b) super.q(uri);
    }

    /* renamed from: F */
    public b<Drawable> r(String str) {
        return (b) super.r(str);
    }

    /* renamed from: G */
    public synchronized c w(j5.c cVar) {
        return (c) super.w(cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.h
    public void x(j5.c cVar) {
        if (cVar instanceof a) {
            super.x(cVar);
        } else {
            super.x(new a().a(cVar));
        }
    }
}
