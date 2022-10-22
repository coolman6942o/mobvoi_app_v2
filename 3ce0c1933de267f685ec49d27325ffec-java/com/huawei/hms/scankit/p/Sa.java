package com.huawei.hms.scankit.p;

import java.text.SimpleDateFormat;
import java.util.TimeZone;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HaLog60001.java */
/* loaded from: classes2.dex */
public class Sa extends SimpleDateFormat {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Ta f14641a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Sa(Ta ta2, String str) {
        super(str);
        this.f14641a = ta2;
        setTimeZone(TimeZone.getTimeZone("UTC"));
    }
}
