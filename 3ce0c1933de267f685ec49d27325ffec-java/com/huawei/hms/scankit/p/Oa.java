package com.huawei.hms.scankit.p;

import java.text.SimpleDateFormat;
import java.util.TimeZone;
/* compiled from: HaLog60000.java */
/* loaded from: classes2.dex */
class Oa extends SimpleDateFormat {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Qa f14607a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Oa(Qa qa2, String str) {
        super(str);
        this.f14607a = qa2;
        setTimeZone(TimeZone.getTimeZone("UTC"));
    }
}
