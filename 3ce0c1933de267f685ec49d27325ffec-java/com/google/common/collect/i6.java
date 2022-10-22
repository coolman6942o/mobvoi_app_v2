package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.j6;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;
/* compiled from: Multiset.java */
/* loaded from: classes.dex */
public final /* synthetic */ class i6 {
    public static void a(j6 _this, final Consumer consumer) {
        p.o(consumer);
        _this.entrySet().forEach(new Consumer() { // from class: com.google.common.collect.g6
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                i6.f(consumer, (j6.a) obj);
            }
        });
    }

    public static void b(j6 _this, final ObjIntConsumer objIntConsumer) {
        p.o(objIntConsumer);
        _this.entrySet().forEach(new Consumer() { // from class: com.google.common.collect.h6
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                i6.g(objIntConsumer, (j6.a) obj);
            }
        });
    }

    public static Spliterator c(j6 _this) {
        return m6.o(_this);
    }

    public static /* synthetic */ void f(Consumer consumer, j6.a aVar) {
        Object a10 = aVar.a();
        int count = aVar.getCount();
        for (int i10 = 0; i10 < count; i10++) {
            consumer.accept(a10);
        }
    }

    public static /* synthetic */ void g(ObjIntConsumer objIntConsumer, j6.a aVar) {
        objIntConsumer.accept(aVar.a(), aVar.getCount());
    }
}
