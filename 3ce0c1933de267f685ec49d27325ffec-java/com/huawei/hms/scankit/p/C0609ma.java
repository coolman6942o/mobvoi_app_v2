package com.huawei.hms.scankit.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* compiled from: DataMask.java */
/* renamed from: com.huawei.hms.scankit.p.ma  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0609ma extends EnumC0632ua {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C0609ma(String str, int i10) {
        super(str, i10, null);
    }

    @Override // com.huawei.hms.scankit.p.EnumC0632ua
    boolean a(int i10, int i11) {
        return ((i10 + i11) & 1) == 0;
    }
}
