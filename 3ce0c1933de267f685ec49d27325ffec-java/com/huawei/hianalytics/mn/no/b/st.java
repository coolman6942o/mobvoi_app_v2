package com.huawei.hianalytics.mn.no.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import com.huawei.hianalytics.mn.mn.no;
import com.mobvoi.wear.common.base.Constants;
/* loaded from: classes.dex */
public class st {

    /* renamed from: mn  reason: collision with root package name */
    private static st f13534mn = new st();

    /* renamed from: no  reason: collision with root package name */
    private boolean f13535no = false;

    /* renamed from: op  reason: collision with root package name */
    private Context f13536op = no.a();

    private st() {
    }

    public static st mn() {
        return f13534mn;
    }

    @TargetApi(24)
    public boolean no() {
        boolean z10;
        if (!this.f13535no) {
            Context context = this.f13536op;
            if (context == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                UserManager userManager = (UserManager) context.getSystemService(Constants.Setting.SUPER_POWER_SAVE_MODE_REASON_USER);
                if (userManager != null) {
                    z10 = userManager.isUserUnlocked();
                } else {
                    this.f13535no = false;
                }
            } else {
                z10 = true;
            }
            this.f13535no = z10;
        }
        return this.f13535no;
    }
}
