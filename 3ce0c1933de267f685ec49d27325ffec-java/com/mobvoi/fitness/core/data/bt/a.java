package com.mobvoi.fitness.core.data.bt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mobvoi.android.common.json.JsonBean;
import java.util.Map;
import java.util.TreeMap;
/* compiled from: BtBase.java */
@JSONType
/* loaded from: classes2.dex */
public class a implements JsonBean {
    private static final b DEFAULT_VALUE_FILTER;
    static final Map<String, Object> DEFAULT_VALUE_MAP;
    @JSONField(name = "a")
    public String accountId = null;
    @JSONField(name = "t")
    public long timestamp = -1;

    /* compiled from: BtBase.java */
    /* loaded from: classes2.dex */
    private static class b implements PropertyFilter {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, Object> f17900a;

        @Override // com.alibaba.fastjson.serializer.PropertyFilter
        public boolean apply(Object obj, String str, Object obj2) {
            if (!this.f17900a.containsKey(str)) {
                return true;
            }
            Object obj3 = this.f17900a.get(str);
            if (obj2 == null) {
                if (obj3 != null) {
                    return true;
                }
            } else if (!obj2.equals(obj3)) {
                return true;
            }
            return false;
        }

        private b(Map<String, Object> map) {
            this.f17900a = map;
        }
    }

    static {
        TreeMap treeMap = new TreeMap();
        DEFAULT_VALUE_MAP = treeMap;
        DEFAULT_VALUE_FILTER = new b(treeMap);
        treeMap.put("a", null);
        treeMap.put("t", -1L);
    }

    public static String a(Object obj) {
        return JSON.toJSONString(obj, DEFAULT_VALUE_FILTER, new SerializerFeature[0]);
    }
}
