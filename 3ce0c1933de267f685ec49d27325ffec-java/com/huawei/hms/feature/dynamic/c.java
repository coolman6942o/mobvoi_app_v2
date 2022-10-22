package com.huawei.hms.feature.dynamic;

import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: b  reason: collision with root package name */
    private static final String f13813b = "c";

    /* renamed from: c  reason: collision with root package name */
    private static final c f13814c = new c();

    /* renamed from: a  reason: collision with root package name */
    public Set<String> f13815a;

    private c() {
    }

    public static c a() {
        return f13814c;
    }

    public final void a(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("installed_module_name");
        if (stringArrayList == null || stringArrayList.isEmpty()) {
            Logger.w(f13813b, "Get installed module name failed.");
            this.f13815a = new HashSet();
            return;
        }
        Logger.i(f13813b, "Installed module name:".concat(String.valueOf(stringArrayList)));
        this.f13815a = new HashSet(stringArrayList);
    }
}
