package com.bjleisen.iface.sdk.apdu;

import com.bjleisen.iface.sdk.enums.EnumCardAppType;
import com.bjleisen.iface.sdk.enums.EnumEnvType;
/* compiled from: LeisenIfaceOperator.java */
/* loaded from: classes.dex */
final /* synthetic */ class h {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f7756a;

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ int[] f7757b;

    static {
        int[] iArr = new int[EnumCardAppType.values().length];
        f7757b = iArr;
        try {
            iArr[EnumCardAppType.CARD_APP_TYPE_BJT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7757b[EnumCardAppType.CARD_APP_TYPE_SZT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f7757b[EnumCardAppType.CARD_APP_TYPE_WHT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f7757b[EnumCardAppType.CARD_APP_TYPE_TFT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f7757b[EnumCardAppType.CARD_APP_TYPE_TJT.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f7757b[EnumCardAppType.CARD_APP_TYPE_WHT2.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f7757b[EnumCardAppType.CARD_APP_TYPE_HCT.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        int[] iArr2 = new int[EnumEnvType.values().length];
        f7756a = iArr2;
        try {
            iArr2[EnumEnvType.ENV_DEV.ordinal()] = 1;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f7756a[EnumEnvType.ENV_BETA.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f7756a[EnumEnvType.ENV_BETA_BJ.ordinal()] = 3;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f7756a[EnumEnvType.ENV_PRD.ordinal()] = 4;
        } catch (NoSuchFieldError unused11) {
        }
    }
}
