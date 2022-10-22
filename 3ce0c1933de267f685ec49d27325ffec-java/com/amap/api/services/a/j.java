package com.amap.api.services.a;

import java.util.Date;
/* compiled from: CrashLogProcessor.java */
/* loaded from: classes.dex */
public class j extends l {
    /* JADX INFO: Access modifiers changed from: protected */
    public j(int i10) {
        super(i10);
    }

    @Override // com.amap.api.services.a.l
    protected String c(String str) {
        String b10 = f.b(new Date().getTime());
        return d.a(str + b10);
    }
}
