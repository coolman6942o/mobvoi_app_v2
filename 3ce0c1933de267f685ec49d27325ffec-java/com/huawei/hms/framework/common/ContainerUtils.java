package com.huawei.hms.framework.common;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class ContainerUtils {
    public static final String FIELD_DELIMITER = "&";
    public static final String KEY_VALUE_DELIMITER = "=";

    public static <K, V> boolean equals(Map<K, V> map, Map<K, V> map2) {
        if (map == map2) {
            return true;
        }
        boolean z10 = false;
        if (map == null || map2 == null || map.size() != map2.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<K, V> next = it.next();
            if (map2.get(next.getKey()) != next.getValue()) {
                z10 = true;
                break;
            }
        }
        return !z10;
    }

    public static <K, V> int hashCode(Map<K, V> map) {
        return toString(map).hashCode();
    }

    public static <K> String toString(List<K> list) {
        if (list == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        for (K k10 : list) {
            i10++;
            if (i10 > 0) {
                sb2.append(FIELD_DELIMITER);
            }
            sb2.append(k10.toString());
        }
        return sb2.toString();
    }

    public static <K, V> String toString(Map<K, V> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            i10++;
            if (i10 > 0) {
                sb2.append(FIELD_DELIMITER);
            }
            sb2.append(entry.getKey().toString());
            sb2.append(KEY_VALUE_DELIMITER);
            sb2.append(entry.getValue().toString());
        }
        return sb2.toString();
    }

    public static <K> String toString(Set<K> set) {
        if (set == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        for (K k10 : set) {
            i10++;
            if (i10 > 0) {
                sb2.append(FIELD_DELIMITER);
            }
            sb2.append(k10.toString());
        }
        return sb2.toString();
    }
}
