package com.bjleisen.iface.sdk.apdu;

import com.bjleisen.iface.sdk.enums.EnumDeviceType;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestManager.java */
/* loaded from: classes.dex */
public final /* synthetic */ class am {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f7730a;

    static {
        int[] iArr = new int[EnumDeviceType.values().length];
        f7730a = iArr;
        try {
            iArr[EnumDeviceType.DEVICE_TYPE_BLUETOOTH.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7730a[EnumDeviceType.DEVICE_TYPE_MOBILE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f7730a[EnumDeviceType.DEVICE_TYPE_NFC.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f7730a[EnumDeviceType.DEVICE_TYPE_MULTI_BLUETOOTH.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f7730a[EnumDeviceType.DEVICE_TYPE_PARTENER.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
