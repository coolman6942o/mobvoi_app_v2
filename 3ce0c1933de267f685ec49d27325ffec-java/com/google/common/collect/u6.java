package com.google.common.collect;

import java.lang.Comparable;
import java.util.Map;
/* compiled from: RangeMap.java */
/* loaded from: classes.dex */
public interface u6<K extends Comparable, V> {
    Map<Range<K>, V> asMapOfRanges();
}
