package com.google.common.collect;

import java.util.Collection;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
/* compiled from: Streams.java */
/* loaded from: classes.dex */
public final class b8 {
    public static <T> Stream<T> a(Iterable<T> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).stream();
        }
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
