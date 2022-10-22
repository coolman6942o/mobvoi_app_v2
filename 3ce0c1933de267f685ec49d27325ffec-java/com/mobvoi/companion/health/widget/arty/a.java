package com.mobvoi.companion.health.widget.arty;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.cardiex.arty.lite.models.coach.ArtyType;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.companion.R;
import kotlin.jvm.internal.i;
/* compiled from: ArtyResourcesManager.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f17142a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final Application f17143b = b.e();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f17144c = new Object();

    /* compiled from: ArtyResourcesManager.kt */
    /* renamed from: com.mobvoi.companion.health.widget.arty.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public /* synthetic */ class C0206a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f17145a;

        static {
            int[] iArr = new int[ArtyType.values().length];
            iArr[ArtyType.ARTY.ordinal()] = 1;
            iArr[ArtyType.TRU_HR.ordinal()] = 2;
            iArr[ArtyType.E_CAP.ordinal()] = 3;
            iArr[ArtyType.HSX.ordinal()] = 4;
            iArr[ArtyType.AGE.ordinal()] = 5;
            f17145a = iArr;
        }
    }

    private a() {
    }

    public final int a(ArtyType artyType) throws Exception {
        int i10 = artyType == null ? -1 : C0206a.f17145a[artyType.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 2;
        }
        if (i10 == 4) {
            return 3;
        }
        if (i10 == 5) {
            return 4;
        }
        throw new Exception("no ArtyType");
    }

    public final Bitmap b(int i10, int i11, boolean z10) {
        int l10 = l(i10, i11);
        if (z10) {
            return k()[l10];
        }
        return f()[l10];
    }

    public final Bitmap c(int i10, int i11, boolean z10) {
        int l10 = l(i10, i11);
        if (z10) {
            return e()[l10];
        }
        return d()[l10];
    }

    public final Bitmap[] d() {
        Application application = f17143b;
        Bitmap decodeResource = BitmapFactory.decodeResource(application.getResources(), R.drawable.ic_min_arty_value_down_green);
        i.e(decodeResource, "decodeResource(mContext.resources, R.drawable.ic_min_arty_value_down_green)");
        Bitmap decodeResource2 = BitmapFactory.decodeResource(application.getResources(), R.drawable.ic_min_arty_value_down_blue);
        i.e(decodeResource2, "decodeResource(mContext.resources, R.drawable.ic_min_arty_value_down_blue)");
        Bitmap decodeResource3 = BitmapFactory.decodeResource(application.getResources(), R.drawable.ic_min_arty_value_down_yellow);
        i.e(decodeResource3, "decodeResource(mContext.resources, R.drawable.ic_min_arty_value_down_yellow)");
        Bitmap decodeResource4 = BitmapFactory.decodeResource(application.getResources(), R.drawable.ic_min_arty_value_down_red);
        i.e(decodeResource4, "decodeResource(mContext.resources, R.drawable.ic_min_arty_value_down_red)");
        return new Bitmap[]{decodeResource, decodeResource2, decodeResource3, decodeResource4};
    }

    public final Bitmap[] e() {
        Application application = f17143b;
        Bitmap decodeResource = BitmapFactory.decodeResource(application.getResources(), R.drawable.ic_min_arty_value_up_green);
        i.e(decodeResource, "decodeResource(mContext.resources, R.drawable.ic_min_arty_value_up_green)");
        Bitmap decodeResource2 = BitmapFactory.decodeResource(application.getResources(), R.drawable.ic_min_arty_value_up_blue);
        i.e(decodeResource2, "decodeResource(mContext.resources, R.drawable.ic_min_arty_value_up_blue)");
        Bitmap decodeResource3 = BitmapFactory.decodeResource(application.getResources(), R.drawable.ic_min_arty_value_up_yellow);
        i.e(decodeResource3, "decodeResource(mContext.resources, R.drawable.ic_min_arty_value_up_yellow)");
        Bitmap decodeResource4 = BitmapFactory.decodeResource(application.getResources(), R.drawable.ic_min_arty_value_up_red);
        i.e(decodeResource4, "decodeResource(mContext.resources, R.drawable.ic_min_arty_value_up_red)");
        return new Bitmap[]{decodeResource, decodeResource2, decodeResource3, decodeResource4};
    }

    public final Bitmap[] f() {
        Application application = f17143b;
        Bitmap decodeResource = BitmapFactory.decodeResource(application.getResources(), R.drawable.ic_min_arty_value_down_green);
        i.e(decodeResource, "decodeResource(mContext.resources, R.drawable.ic_min_arty_value_down_green)");
        Bitmap decodeResource2 = BitmapFactory.decodeResource(application.getResources(), R.drawable.ic_min_arty_value_down_blue);
        i.e(decodeResource2, "decodeResource(mContext.resources, R.drawable.ic_min_arty_value_down_blue)");
        Bitmap decodeResource3 = BitmapFactory.decodeResource(application.getResources(), R.drawable.ic_min_arty_value_down_yellow);
        i.e(decodeResource3, "decodeResource(mContext.resources, R.drawable.ic_min_arty_value_down_yellow)");
        Bitmap decodeResource4 = BitmapFactory.decodeResource(application.getResources(), R.drawable.ic_min_arty_value_down_red);
        i.e(decodeResource4, "decodeResource(mContext.resources, R.drawable.ic_min_arty_value_down_red)");
        return new Bitmap[]{decodeResource, decodeResource2, decodeResource3, decodeResource4};
    }

    public final int g(int i10, int i11) {
        return j()[l(i10, i11)];
    }

    public final int h(int i10, int i11, boolean z10) {
        int l10 = l(i10, i11);
        if (z10) {
            return i()[l10];
        }
        return j()[l10];
    }

    public final int[] i() {
        Application application = f17143b;
        return new int[]{application.getResources().getColor(R.color.arty_card_bar_green_start_color, null), application.getResources().getColor(R.color.arty_card_bar_blue_start_color, null), application.getResources().getColor(R.color.arty_card_bar_yellow_start_color, null), application.getResources().getColor(R.color.arty_card_bar_red_start_color, null)};
    }

    public final int[] j() {
        Application application = f17143b;
        return new int[]{application.getResources().getColor(R.color.arty_card_bar_green_end_color, null), application.getResources().getColor(R.color.arty_card_bar_blue_end_color, null), application.getResources().getColor(R.color.arty_card_bar_yellow_end_color, null), application.getResources().getColor(R.color.arty_card_bar_red_end_color, null)};
    }

    public final Bitmap[] k() {
        Application application = f17143b;
        Bitmap decodeResource = BitmapFactory.decodeResource(application.getResources(), R.drawable.ic_min_arty_value_up_green);
        i.e(decodeResource, "decodeResource(mContext.resources, R.drawable.ic_min_arty_value_up_green)");
        Bitmap decodeResource2 = BitmapFactory.decodeResource(application.getResources(), R.drawable.ic_min_arty_value_up_blue);
        i.e(decodeResource2, "decodeResource(mContext.resources, R.drawable.ic_min_arty_value_up_blue)");
        Bitmap decodeResource3 = BitmapFactory.decodeResource(application.getResources(), R.drawable.ic_min_arty_value_up_yellow);
        i.e(decodeResource3, "decodeResource(mContext.resources, R.drawable.ic_min_arty_value_up_yellow)");
        Bitmap decodeResource4 = BitmapFactory.decodeResource(application.getResources(), R.drawable.ic_min_arty_value_up_red);
        i.e(decodeResource4, "decodeResource(mContext.resources, R.drawable.ic_min_arty_value_up_red)");
        return new Bitmap[]{decodeResource, decodeResource2, decodeResource3, decodeResource4};
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
        if (r7 != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0018, code lost:
        r1 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x001e, code lost:
        if (r7 != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0020, code lost:
        r1 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0028, code lost:
        if (r7 != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x002b, code lost:
        if (r7 != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int l(int i10, int i11) {
        boolean z10;
        synchronized (f17144c) {
            int i12 = 0;
            if (i10 != 1) {
                if (i10 == 3) {
                    z10 = false;
                } else if (i10 != 4) {
                    z10 = true;
                }
                i12 = 2;
                if (i11 < 75) {
                    if (i11 < 50) {
                        if (i11 >= 25) {
                        }
                    }
                    return i12;
                }
            }
            return 0;
        }
    }
}
