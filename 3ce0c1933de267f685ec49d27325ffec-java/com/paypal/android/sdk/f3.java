package com.paypal.android.sdk;

import com.huawei.hms.scankit.C0559e;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class f3 {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f21229a;

    /* renamed from: b  reason: collision with root package name */
    private static final Set f21230b;

    static {
        HashMap hashMap = new HashMap();
        f21229a = hashMap;
        hashMap.put("c14", "erpg");
        hashMap.put("c25", "page");
        hashMap.put("c26", "link");
        hashMap.put("c27", "pgln");
        hashMap.put("c29", "eccd");
        hashMap.put("c35", "lgin");
        hashMap.put("vers", "vers");
        hashMap.put("c50", "rsta");
        hashMap.put("gn", "pgrp");
        hashMap.put("v49", "mapv");
        hashMap.put("v51", "mcar");
        hashMap.put("v52", "mosv");
        hashMap.put("v53", "mdvs");
        hashMap.put("clid", "clid");
        hashMap.put("apid", "apid");
        hashMap.put("calc", "calc");
        hashMap.put(C0559e.f14347a, C0559e.f14347a);
        hashMap.put("t", "t");
        hashMap.put("g", "g");
        hashMap.put("srce", "srce");
        hashMap.put("vid", "vid");
        hashMap.put("bchn", "bchn");
        hashMap.put("adte", "adte");
        hashMap.put("sv", "sv");
        hashMap.put("dsid", "dsid");
        hashMap.put("bzsr", "bzsr");
        hashMap.put("prid", "prid");
        HashSet hashSet = new HashSet();
        f21230b = hashSet;
        hashSet.add("v25");
        hashSet.add("v31");
        hashSet.add("c37");
    }

    public static s0 a(s0 s0Var) {
        String str;
        Map map = s0Var.f21935b;
        HashMap hashMap = new HashMap();
        for (String str2 : map.keySet()) {
            if (!y1.i(str2) && !f21230b.contains(str2)) {
                Map map2 = f21229a;
                if (map2.containsKey(str2) && (str = (String) map2.get(str2)) != null) {
                    hashMap.put(str, map.get(str2));
                }
            }
        }
        return new s0(s0Var.f21934a, hashMap);
    }
}
