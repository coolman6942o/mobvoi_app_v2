package com.alipay.sdk.protocol;

import android.text.TextUtils;
import com.mobvoi.wear.common.base.Constants;
/* loaded from: classes.dex */
public enum a {
    None(Constants.Setting.SUPER_POWER_SAVE_MODE_REASON_NONE),
    WapPay("js://wappay"),
    Update("js://update"),
    OpenWeb("loc:openweb"),
    SetResult("loc:setResult"),
    Exit("loc:exit");
    

    /* renamed from: a  reason: collision with root package name */
    public String f6914a;

    a(String str) {
        this.f6914a = str;
    }

    public static a a(String str) {
        a[] values;
        if (TextUtils.isEmpty(str)) {
            return None;
        }
        a aVar = None;
        for (a aVar2 : values()) {
            if (str.startsWith(aVar2.f6914a)) {
                return aVar2;
            }
        }
        return aVar;
    }
}
