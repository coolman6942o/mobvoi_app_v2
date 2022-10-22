package com.mobvoi.companion.unit;

import android.content.Context;
import android.content.Intent;
import com.mobvoi.android.common.utils.b;
import wd.c;
/* loaded from: classes2.dex */
public class UnitPolicy {

    /* loaded from: classes2.dex */
    public enum UNIT {
        IMPERIAL,
        METRIC
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17646a;

        static {
            int[] iArr = new int[UNIT.values().length];
            f17646a = iArr;
            try {
                iArr[UNIT.IMPERIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17646a[UNIT.METRIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static Context a() {
        return b.e();
    }

    public static wd.a b() {
        if (com.mobvoi.companion.base.settings.a.isUnitMetric(a())) {
            wd.a c10 = c(UNIT.METRIC);
            d(1);
            return c10;
        }
        wd.a c11 = c(UNIT.IMPERIAL);
        d(2);
        return c11;
    }

    public static wd.a c(UNIT unit) {
        int i10 = a.f17646a[unit.ordinal()];
        if (i10 == 1) {
            return new wd.b();
        }
        if (i10 != 2) {
            return null;
        }
        return new c();
    }

    private static void d(int i10) {
        Intent intent = new Intent("com.mobvoi.ticpod.service.ACTION_UPDATE_USER_SETTING_UNIT");
        intent.putExtra("distance_unit", i10);
        b.e().sendBroadcast(intent);
    }
}
