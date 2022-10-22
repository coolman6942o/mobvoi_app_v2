package com.mobvoi.fitness.core.data.bt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.Map;
/* compiled from: BtShare.java */
/* loaded from: classes2.dex */
public class d extends a {
    @JSONField(name = "rid")

    /* renamed from: id  reason: collision with root package name */
    public String f17904id = null;
    @JSONField(name = "ty")
    public int type = -1;

    static {
        Map<String, Object> map = a.DEFAULT_VALUE_MAP;
        map.put("rid", null);
        map.put("ty", null);
    }

    public static d b(String str) {
        return (d) JSON.parseObject(str, d.class);
    }
}
