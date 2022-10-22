package com.mobvoi.mcuwatch.ui.contacts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.e0;
import androidx.lifecycle.f0;
import androidx.lifecycle.w;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.apollo.client.q;
import com.mobvoi.apollo.protocol.model.Contact;
import com.mobvoi.mcuwatch.ui.contacts.z;
import com.mobvoi.mcuwatch.ui.sms.ContactSection;
import io.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.n;
import kotlin.collections.u;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import qo.l;
import yd.h;
/* compiled from: ContactsViewModel.kt */
/* loaded from: classes2.dex */
public final class o extends f0 {

    /* renamed from: a  reason: collision with root package name */
    private final com.mobvoi.apollo.client.repository.d f19551a;

    /* renamed from: c  reason: collision with root package name */
    private final LiveData<List<Contact>> f19553c;

    /* renamed from: d  reason: collision with root package name */
    private final LiveData<List<ContactSection>> f19554d;

    /* renamed from: b  reason: collision with root package name */
    private final w<Integer> f19552b = new w<>(0);

    /* renamed from: e  reason: collision with root package name */
    private final w<Contact> f19555e = new w<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ContactsViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements l<Boolean, m> {
        final /* synthetic */ l<Integer, m> $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(l<? super Integer, m> lVar) {
            super(1);
            this.$callback = lVar;
        }

        public final void a(boolean z10) {
            this.$callback.invoke(Integer.valueOf(z10 ? 0 : 3));
        }

        @Override // qo.l
        public /* bridge */ /* synthetic */ m invoke(Boolean bool) {
            a(bool.booleanValue());
            return m.f28349a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ContactsViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class b extends Lambda implements l<Boolean, m> {
        final /* synthetic */ l<Integer, m> $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(l<? super Integer, m> lVar) {
            super(1);
            this.$callback = lVar;
        }

        public final void a(boolean z10) {
            this.$callback.invoke(Integer.valueOf(z10 ? 0 : 3));
        }

        @Override // qo.l
        public /* bridge */ /* synthetic */ m invoke(Boolean bool) {
            a(bool.booleanValue());
            return m.f28349a;
        }
    }

    /* compiled from: Transformations.kt */
    /* loaded from: classes2.dex */
    public static final class c<I, O> implements m.a {
        @Override // m.a
        public final List<? extends ContactSection> apply(List<? extends Contact> list) {
            List<String> R;
            char G0;
            char G02;
            List l10;
            List<? extends ContactSection> g10;
            List<? extends Contact> list2 = list;
            if (list2.isEmpty()) {
                g10 = kotlin.collections.m.g();
                return g10;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Contact contact : list2) {
                G0 = kotlin.text.w.G0(contact.getName());
                String a10 = h.a(String.valueOf(G0));
                i.e(a10, "getPinYin(it.name.first().toString())");
                G02 = kotlin.text.w.G0(a10);
                String valueOf = String.valueOf(Character.toUpperCase(G02));
                if (linkedHashMap.containsKey(valueOf)) {
                    List list3 = (List) linkedHashMap.get(valueOf);
                    if (list3 != null) {
                        list3.add(contact);
                    }
                } else {
                    l10 = kotlin.collections.m.l(contact);
                    linkedHashMap.put(valueOf, l10);
                }
            }
            ArrayList arrayList = new ArrayList();
            R = u.R(linkedHashMap.keySet());
            for (String str : R) {
                arrayList.add(new ContactSection(str));
                List<Contact> list4 = (List) linkedHashMap.get(str);
                if (list4 != null) {
                    for (Contact contact2 : list4) {
                        arrayList.add(new ContactSection(contact2));
                    }
                }
            }
            return arrayList;
        }
    }

    /* compiled from: ContactsViewModel.kt */
    /* loaded from: classes2.dex */
    static final class d extends Lambda implements l<Boolean, m> {
        final /* synthetic */ l<Integer, m> $callback;
        final /* synthetic */ Contact $contact;
        final /* synthetic */ o this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(l<? super Integer, m> lVar, o oVar, Contact contact) {
            super(1);
            this.$callback = lVar;
            this.this$0 = oVar;
            this.$contact = contact;
        }

        public final void a(boolean z10) {
            if (z10) {
                this.$callback.invoke(0);
                this.this$0.l().o(this.$contact);
                return;
            }
            this.$callback.invoke(3);
        }

        @Override // qo.l
        public /* bridge */ /* synthetic */ m invoke(Boolean bool) {
            a(bool.booleanValue());
            return m.f28349a;
        }
    }

    public o() {
        q qVar = q.f15504a;
        com.mobvoi.apollo.client.repository.d dVar = new com.mobvoi.apollo.client.repository.d(qVar.x().F());
        this.f19551a = dVar;
        LiveData<List<Contact>> d10 = dVar.d();
        this.f19553c = d10;
        LiveData<List<ContactSection>> a10 = e0.a(d10, new c());
        i.e(a10, "crossinline transform: (…p(this) { transform(it) }");
        this.f19554d = a10;
        qVar.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String name, String number, o this$0, l callback, Integer id2) {
        i.f(name, "$name");
        i.f(number, "$number");
        i.f(this$0, "this$0");
        i.f(callback, "$callback");
        k.a("ContactsViewModel", i.n("contact id ", id2));
        i.e(id2, "id");
        this$0.f19551a.g(new Contact(id2.intValue(), name, number), new a(callback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(List contacts, o this$0, l callback, Integer num) {
        int p10;
        i.f(contacts, "$contacts");
        i.f(this$0, "this$0");
        i.f(callback, "$callback");
        k.a("ContactsViewModel", i.n("contact id ", num));
        p10 = n.p(contacts, 10);
        ArrayList arrayList = new ArrayList(p10);
        Iterator it = contacts.iterator();
        while (it.hasNext()) {
            z.b bVar = (z.b) it.next();
            num = Integer.valueOf(num.intValue() + 1);
            i.e(num, "uniqueId++");
            arrayList.add(new Contact(num.intValue(), bVar.a(), bVar.b()));
        }
        this$0.f19551a.h(arrayList, new b(callback));
    }

    private final int g(String str, String str2) {
        List<Contact> f10 = this.f19553c.f();
        if (f10 != null && !f10.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : f10) {
                if (i.b(((Contact) obj).getName(), str)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : f10) {
                if (i.b(((Contact) obj2).getNum(), str2)) {
                    arrayList2.add(obj2);
                }
            }
            if (!arrayList.isEmpty()) {
                return 1;
            }
            if (!arrayList2.isEmpty()) {
                return 2;
            }
        }
        return 0;
    }

    private final int h(String str, String str2) {
        List<Contact> f10 = this.f19553c.f();
        if (f10 != null && !f10.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : f10) {
                if (i.b(((Contact) obj).getName(), str)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : f10) {
                if (i.b(((Contact) obj2).getNum(), str2)) {
                    arrayList2.add(obj2);
                }
            }
            if ((!arrayList.isEmpty()) && (!arrayList2.isEmpty()) && !i.b(kotlin.collections.k.F(arrayList), kotlin.collections.k.F(arrayList2))) {
                Contact f11 = this.f19555e.f();
                i.d(f11);
                i.e(f11, "currentContact.value!!");
                return i.b(f11.getName(), str) ? 2 : 1;
            }
        }
        return 0;
    }

    public final void c(final String name, final String number, final l<? super Integer, m> callback) {
        i.f(name, "name");
        i.f(number, "number");
        i.f(callback, "callback");
        int g10 = g(name, number);
        if (g10 != 0) {
            callback.invoke(Integer.valueOf(g10));
        } else {
            this.f19551a.e().X(new yp.b() { // from class: com.mobvoi.mcuwatch.ui.contacts.m
                @Override // yp.b
                public final void call(Object obj) {
                    o.d(name, number, this, callback, (Integer) obj);
                }
            });
        }
    }

    public final void e(final List<z.b> contacts, final l<? super Integer, m> callback) {
        i.f(contacts, "contacts");
        i.f(callback, "callback");
        this.f19551a.e().X(new yp.b() { // from class: com.mobvoi.mcuwatch.ui.contacts.n
            @Override // yp.b
            public final void call(Object obj) {
                o.f(contacts, this, callback, (Integer) obj);
            }
        });
    }

    public final LiveData<List<Contact>> i() {
        return this.f19553c;
    }

    public final void j(l<? super Boolean, m> callback) {
        i.f(callback, "callback");
        Contact f10 = this.f19555e.f();
        if (f10 != null) {
            this.f19551a.c(f10, callback);
        }
    }

    public final LiveData<List<ContactSection>> k() {
        return this.f19554d;
    }

    public final w<Contact> l() {
        return this.f19555e;
    }

    public final w<Integer> m() {
        return this.f19552b;
    }

    public final void n(String name, String number, l<? super Integer, m> callback) {
        i.f(name, "name");
        i.f(number, "number");
        i.f(callback, "callback");
        int h10 = h(name, number);
        if (h10 != 0) {
            callback.invoke(Integer.valueOf(h10));
            return;
        }
        Contact f10 = this.f19555e.f();
        if (f10 != null) {
            Contact copy$default = Contact.copy$default(f10, 0, name, number, 1, null);
            this.f19551a.i(copy$default, new d(callback, this, copy$default));
        }
    }
}
