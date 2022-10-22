package com.mobvoi.apollo.client.repository;

import androidx.lifecycle.LiveData;
import com.mobvoi.apollo.client.q;
import com.mobvoi.apollo.client.repository.d;
import com.mobvoi.apollo.protocol.model.Contact;
import io.m;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import qo.l;
/* compiled from: ContactsRepository.kt */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final ga.a f15529a;

    /* compiled from: ContactsRepository.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements l<Boolean, m> {
        final /* synthetic */ l<Boolean, m> $callback;
        final /* synthetic */ Contact $contact;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(Contact contact, l<? super Boolean, m> lVar) {
            super(1);
            this.$contact = contact;
            this.$callback = lVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final m d(d this$0, Contact contact) {
            i.f(this$0, "this$0");
            i.f(contact, "$contact");
            this$0.f15529a.b(contact);
            return m.f28349a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(l callback, boolean z10) {
            i.f(callback, "$callback");
            callback.invoke(Boolean.valueOf(z10));
        }

        public final void c(final boolean z10) {
            if (z10) {
                final d dVar = d.this;
                final Contact contact = this.$contact;
                rx.c.x(new Callable() { // from class: com.mobvoi.apollo.client.repository.c
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        m d10;
                        d10 = d.a.d(d.this, contact);
                        return d10;
                    }
                }).Z(cq.a.c()).T();
            }
            com.mobvoi.android.common.utils.l a10 = com.mobvoi.android.common.utils.l.a();
            final l<Boolean, m> lVar = this.$callback;
            a10.post(new Runnable() { // from class: com.mobvoi.apollo.client.repository.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.a.g(l.this, z10);
                }
            });
        }

        @Override // qo.l
        public /* bridge */ /* synthetic */ m invoke(Boolean bool) {
            c(bool.booleanValue());
            return m.f28349a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ContactsRepository.kt */
    /* loaded from: classes2.dex */
    public static final class b extends Lambda implements l<Boolean, m> {
        final /* synthetic */ l<Boolean, m> $callback;
        final /* synthetic */ List<Contact> $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(List<Contact> list, l<? super Boolean, m> lVar) {
            super(1);
            this.$data = list;
            this.$callback = lVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final m d(d this$0, List data) {
            i.f(this$0, "this$0");
            i.f(data, "$data");
            this$0.f15529a.c(data);
            return m.f28349a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(l callback, boolean z10) {
            i.f(callback, "$callback");
            callback.invoke(Boolean.valueOf(z10));
        }

        public final void c(final boolean z10) {
            if (z10) {
                final d dVar = d.this;
                final List<Contact> list = this.$data;
                rx.c.x(new Callable() { // from class: com.mobvoi.apollo.client.repository.f
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        m d10;
                        d10 = d.b.d(d.this, list);
                        return d10;
                    }
                }).Z(cq.a.c()).T();
            }
            com.mobvoi.android.common.utils.l a10 = com.mobvoi.android.common.utils.l.a();
            final l<Boolean, m> lVar = this.$callback;
            a10.post(new Runnable() { // from class: com.mobvoi.apollo.client.repository.e
                @Override // java.lang.Runnable
                public final void run() {
                    d.b.g(l.this, z10);
                }
            });
        }

        @Override // qo.l
        public /* bridge */ /* synthetic */ m invoke(Boolean bool) {
            c(bool.booleanValue());
            return m.f28349a;
        }
    }

    /* compiled from: ContactsRepository.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements l<Boolean, m> {
        final /* synthetic */ l<Boolean, m> $callback;
        final /* synthetic */ Contact $contact;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(Contact contact, l<? super Boolean, m> lVar) {
            super(1);
            this.$contact = contact;
            this.$callback = lVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final m d(d this$0, Contact contact) {
            i.f(this$0, "this$0");
            i.f(contact, "$contact");
            this$0.f15529a.d(contact.getName(), contact.getNum());
            return m.f28349a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(l callback, boolean z10) {
            i.f(callback, "$callback");
            callback.invoke(Boolean.valueOf(z10));
        }

        public final void c(final boolean z10) {
            if (z10) {
                final d dVar = d.this;
                final Contact contact = this.$contact;
                rx.c.x(new Callable() { // from class: com.mobvoi.apollo.client.repository.h
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        m d10;
                        d10 = d.c.d(d.this, contact);
                        return d10;
                    }
                }).Z(cq.a.c()).T();
            }
            com.mobvoi.android.common.utils.l a10 = com.mobvoi.android.common.utils.l.a();
            final l<Boolean, m> lVar = this.$callback;
            a10.post(new Runnable() { // from class: com.mobvoi.apollo.client.repository.g
                @Override // java.lang.Runnable
                public final void run() {
                    d.c.g(l.this, z10);
                }
            });
        }

        @Override // qo.l
        public /* bridge */ /* synthetic */ m invoke(Boolean bool) {
            c(bool.booleanValue());
            return m.f28349a;
        }
    }

    public d(ga.a contactsDao) {
        i.f(contactsDao, "contactsDao");
        this.f15529a = contactsDao;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer f(d this$0) {
        i.f(this$0, "this$0");
        return Integer.valueOf(this$0.f15529a.a() + 1);
    }

    public final void c(Contact contact, l<? super Boolean, m> callback) {
        i.f(contact, "contact");
        i.f(callback, "callback");
        q.f15504a.u(contact.getNum(), new a(contact, callback));
    }

    public final LiveData<List<Contact>> d() {
        return this.f15529a.getAll();
    }

    public final rx.c<Integer> e() {
        rx.c<Integer> Z = rx.c.x(new Callable() { // from class: com.mobvoi.apollo.client.repository.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Integer f10;
                f10 = d.f(d.this);
                return f10;
            }
        }).Z(cq.a.c());
        i.e(Z, "fromCallable {\n            contactsDao.maxId() + 1\n        }.subscribeOn(Schedulers.io())");
        return Z;
    }

    public final void g(Contact contact, l<? super Boolean, m> callback) {
        List<Contact> b10;
        i.f(contact, "contact");
        i.f(callback, "callback");
        b10 = kotlin.collections.l.b(contact);
        h(b10, callback);
    }

    public final void h(List<Contact> data, l<? super Boolean, m> callback) {
        i.f(data, "data");
        i.f(callback, "callback");
        q.f15504a.T(data, new b(data, callback));
    }

    public final void i(Contact contact, l<? super Boolean, m> callback) {
        List<Contact> b10;
        i.f(contact, "contact");
        i.f(callback, "callback");
        q qVar = q.f15504a;
        b10 = kotlin.collections.l.b(contact);
        qVar.T(b10, new c(contact, callback));
    }
}
