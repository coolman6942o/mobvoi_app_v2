package com.google.common.collect;

import com.google.common.base.p;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
/* compiled from: Multimap.java */
/* loaded from: classes.dex */
public final /* synthetic */ class a6 {
    public static void a(b6 _this, final BiConsumer biConsumer) {
        p.o(biConsumer);
        _this.entries().forEach(new Consumer() { // from class: com.google.common.collect.z5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                a6.c(biConsumer, (Map.Entry) obj);
            }
        });
    }

    public static /* synthetic */ void c(BiConsumer biConsumer, Map.Entry entry) {
        biConsumer.accept(entry.getKey(), entry.getValue());
    }
}
