package com.huawei.hms.scankit.aiscan.common;

import java.util.List;
/* compiled from: DecodeHintType.java */
/* renamed from: com.huawei.hms.scankit.aiscan.common.d  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public enum EnumC0553d {
    OTHER(Object.class),
    POSSIBLE_FORMATS(List.class),
    PHOTO_MODE(Void.TYPE),
    PHOTO_MODE_NUM(Integer.TYPE),
    NEED_JNI(Void.TYPE),
    CHARACTER_SET(String.class),
    RETURN_CODABAR_START_END(Void.class),
    NEED_RESULT_POINT_CALLBACK(A.class),
    ALLOWED_EAN_EXTENSIONS(int[].class);
    

    /* renamed from: k  reason: collision with root package name */
    private final Class<?> f14205k;

    EnumC0553d(Class cls) {
        this.f14205k = cls;
    }
}
