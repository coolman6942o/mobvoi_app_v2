package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.dl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class a0 {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f21658a;

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ int[] f21659b;

    static {
        int[] iArr = new int[dl.values().length];
        f21659b = iArr;
        try {
            iArr[dl.EMAIL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f21659b[dl.PHONE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[bg.values().length];
        f21658a = iArr2;
        try {
            iArr2[bg.EMAIL_LOGIN_IN_PROGRESS.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f21658a[bg.PIN_LOGIN_IN_PROGRESS.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f21658a[bg.TWO_FA_SEND_FIRST_SMS_IN_PROGRESS.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f21658a[bg.TWO_FA_SEND_ANOTHER_SMS_IN_PROGRESS.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f21658a[bg.TWO_FA_LOGIN_OTP_IN_PROGRESS.ordinal()] = 5;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f21658a[bg.EMAIL.ordinal()] = 6;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f21658a[bg.PIN.ordinal()] = 7;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f21658a[bg.EMAIL_LOGIN_FAILED.ordinal()] = 8;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f21658a[bg.PIN_LOGIN_FAILED.ordinal()] = 9;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f21658a[bg.TWO_FA_SEND_FIRST_SMS.ordinal()] = 10;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f21658a[bg.TWO_FA_SEND_SMS_FAILED.ordinal()] = 11;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            f21658a[bg.TWO_FA_ENTER_OTP.ordinal()] = 12;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            f21658a[bg.TWO_FA_LOGIN_OTP_FAILED.ordinal()] = 13;
        } catch (NoSuchFieldError unused15) {
        }
    }
}
