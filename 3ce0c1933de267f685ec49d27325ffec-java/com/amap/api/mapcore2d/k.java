package com.amap.api.mapcore2d;

import java.util.Date;
/* compiled from: CrashLogProcessor.java */
/* loaded from: classes.dex */
public class k extends m {
    /* JADX INFO: Access modifiers changed from: protected */
    public k(int i10) {
        super(i10);
    }

    @Override // com.amap.api.mapcore2d.m
    protected String c(String str) {
        String b10 = g.b(new Date().getTime());
        return e.a(str + b10);
    }
}
