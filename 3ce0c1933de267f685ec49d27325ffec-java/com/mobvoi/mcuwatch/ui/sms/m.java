package com.mobvoi.mcuwatch.ui.sms;

import androidx.lifecycle.f0;
import androidx.lifecycle.p;
import androidx.lifecycle.w;
import androidx.lifecycle.x;
import com.mobvoi.apollo.client.q;
import com.mobvoi.apollo.client.repository.d;
import com.mobvoi.apollo.protocol.model.Contact;
import cq.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.u;
import kotlin.jvm.internal.i;
import rx.c;
import yd.h;
import yp.b;
import yp.g;
/* compiled from: SmsViewModel.kt */
/* loaded from: classes2.dex */
public final class m extends f0 {

    /* renamed from: a  reason: collision with root package name */
    private final d f20237a = new d(q.f15504a.x().F());

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, List<Contact>> f20238b = new LinkedHashMap();

    /* renamed from: c  reason: collision with root package name */
    private final w<List<ContactSection>> f20239c = new w<>();

    /* renamed from: d  reason: collision with root package name */
    private final w<Contact> f20240d = new w<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(m this$0, List it) {
        i.f(this$0, "this$0");
        i.e(it, "it");
        this$0.g(it);
    }

    private final void g(List<Contact> list) {
        if ((!list.isEmpty()) && this.f20238b.isEmpty()) {
            c.A(list).D(new g() { // from class: com.mobvoi.mcuwatch.ui.sms.k
                @Override // yp.g
                public final Object call(Object obj) {
                    Map h10;
                    h10 = m.h(m.this, (List) obj);
                    return h10;
                }
            }).D(l.f20236a).Z(a.a()).H(xp.a.b()).X(new b() { // from class: com.mobvoi.mcuwatch.ui.sms.j
                @Override // yp.b
                public final void call(Object obj) {
                    m.j(m.this, (List) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map h(m this$0, List list) {
        char G0;
        char G02;
        List<Contact> l10;
        i.f(this$0, "this$0");
        i.e(list, "list");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Contact contact = (Contact) it.next();
            G0 = kotlin.text.w.G0(contact.getName());
            String a10 = h.a(String.valueOf(G0));
            i.e(a10, "getPinYin(it.name.first().toString())");
            G02 = kotlin.text.w.G0(a10);
            String valueOf = String.valueOf(Character.toUpperCase(G02));
            if (this$0.f20238b.containsKey(valueOf)) {
                List<Contact> list2 = this$0.f20238b.get(valueOf);
                if (list2 != null) {
                    list2.add(contact);
                }
            } else {
                Map<String, List<Contact>> map = this$0.f20238b;
                l10 = kotlin.collections.m.l(contact);
                map.put(valueOf, l10);
            }
        }
        return this$0.f20238b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List i(Map map) {
        List<String> R;
        ArrayList arrayList = new ArrayList();
        R = u.R(map.keySet());
        for (String str : R) {
            arrayList.add(new ContactSection(str));
            List<Contact> list = (List) map.get(str);
            if (list != null) {
                for (Contact contact : list) {
                    arrayList.add(new ContactSection(contact));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(m this$0, List list) {
        i.f(this$0, "this$0");
        this$0.f20239c.o(list);
    }

    public final void e(p lifecycleOwner, x<List<ContactSection>> observer) {
        i.f(lifecycleOwner, "lifecycleOwner");
        i.f(observer, "observer");
        this.f20237a.d().i(lifecycleOwner, new x() { // from class: com.mobvoi.mcuwatch.ui.sms.i
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                m.f(m.this, (List) obj);
            }
        });
        this.f20239c.i(lifecycleOwner, observer);
    }

    public final w<Contact> k() {
        return this.f20240d;
    }
}
