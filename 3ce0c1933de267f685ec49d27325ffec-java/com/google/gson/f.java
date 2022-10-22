package com.google.gson;

import com.google.gson.internal.d;
import i8.n;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: GsonBuilder.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: h  reason: collision with root package name */
    private String f12571h;

    /* renamed from: a  reason: collision with root package name */
    private d f12564a = d.f12627g;

    /* renamed from: b  reason: collision with root package name */
    private LongSerializationPolicy f12565b = LongSerializationPolicy.DEFAULT;

    /* renamed from: c  reason: collision with root package name */
    private d f12566c = FieldNamingPolicy.IDENTITY;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Type, g<?>> f12567d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final List<r> f12568e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final List<r> f12569f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private boolean f12570g = false;

    /* renamed from: i  reason: collision with root package name */
    private int f12572i = 2;

    /* renamed from: j  reason: collision with root package name */
    private int f12573j = 2;

    /* renamed from: k  reason: collision with root package name */
    private boolean f12574k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f12575l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f12576m = true;

    /* renamed from: n  reason: collision with root package name */
    private boolean f12577n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f12578o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f12579p = false;

    private void a(String str, int i10, int i11, List<r> list) {
        a aVar;
        a aVar2;
        a aVar3;
        if (str != null && !"".equals(str.trim())) {
            aVar2 = new a(Date.class, str);
            aVar = new a(Timestamp.class, str);
            aVar3 = new a(java.sql.Date.class, str);
        } else if (i10 != 2 && i11 != 2) {
            a aVar4 = new a(Date.class, i10, i11);
            a aVar5 = new a(Timestamp.class, i10, i11);
            a aVar6 = new a(java.sql.Date.class, i10, i11);
            aVar2 = aVar4;
            aVar = aVar5;
            aVar3 = aVar6;
        } else {
            return;
        }
        list.add(n.a(Date.class, aVar2));
        list.add(n.a(Timestamp.class, aVar));
        list.add(n.a(java.sql.Date.class, aVar3));
    }

    public e b() {
        List<r> arrayList = new ArrayList<>(this.f12568e.size() + this.f12569f.size() + 3);
        arrayList.addAll(this.f12568e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f12569f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.f12571h, this.f12572i, this.f12573j, arrayList);
        return new e(this.f12564a, this.f12566c, this.f12567d, this.f12570g, this.f12574k, this.f12578o, this.f12576m, this.f12577n, this.f12579p, this.f12575l, this.f12565b, this.f12571h, this.f12572i, this.f12573j, this.f12568e, this.f12569f, arrayList);
    }

    public f c() {
        this.f12564a = this.f12564a.g();
        return this;
    }

    public f d(b... bVarArr) {
        for (b bVar : bVarArr) {
            this.f12564a = this.f12564a.o(bVar, true, true);
        }
        return this;
    }
}
