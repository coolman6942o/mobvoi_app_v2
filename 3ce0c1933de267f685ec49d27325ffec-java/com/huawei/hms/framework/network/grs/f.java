package com.huawei.hms.framework.network.grs;

import android.content.Context;
/* loaded from: classes.dex */
public class f extends GrsBaseInfo {
    @Override // com.huawei.hms.framework.network.grs.GrsBaseInfo
    public String getGrsParasTag(boolean z10, boolean z11, Context context) {
        return super.getGrsParasTag(z10, z11, context) + "geoip";
    }
}
