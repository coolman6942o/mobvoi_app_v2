package com.mobvoi.apollo.db;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import com.mobvoi.apollo.protocol.model.Contact;
import com.mobvoi.wear.contacts.ContactConstant;
import f1.f;
import f1.g;
import f1.k;
import f1.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
/* compiled from: ContactsDao_Impl.java */
/* loaded from: classes2.dex */
public final class a implements ga.a {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f15566a;

    /* renamed from: b  reason: collision with root package name */
    private final g<Contact> f15567b;

    /* renamed from: c  reason: collision with root package name */
    private final f<Contact> f15568c;

    /* renamed from: d  reason: collision with root package name */
    private final l f15569d;

    /* renamed from: e  reason: collision with root package name */
    private final l f15570e;

    /* compiled from: ContactsDao_Impl.java */
    /* renamed from: com.mobvoi.apollo.db.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0191a extends g<Contact> {
        C0191a(a aVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "INSERT OR REPLACE INTO `contacts` (`id`,`name`,`num`) VALUES (nullif(?, 0),?,?)";
        }

        /* renamed from: m */
        public void g(i1.f fVar, Contact contact) {
            fVar.K(1, contact.getId());
            if (contact.getName() == null) {
                fVar.l0(2);
            } else {
                fVar.m(2, contact.getName());
            }
            if (contact.getNum() == null) {
                fVar.l0(3);
            } else {
                fVar.m(3, contact.getNum());
            }
        }
    }

    /* compiled from: ContactsDao_Impl.java */
    /* loaded from: classes2.dex */
    class b extends f<Contact> {
        b(a aVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "DELETE FROM `contacts` WHERE `id` = ?";
        }

        /* renamed from: j */
        public void g(i1.f fVar, Contact contact) {
            fVar.K(1, contact.getId());
        }
    }

    /* compiled from: ContactsDao_Impl.java */
    /* loaded from: classes2.dex */
    class c extends l {
        c(a aVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "UPDATE contacts SET name = ?, num = ? WHERE name = ? OR num = ?";
        }
    }

    /* compiled from: ContactsDao_Impl.java */
    /* loaded from: classes2.dex */
    class d extends l {
        d(a aVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // f1.l
        public String d() {
            return "DELETE FROM contacts";
        }
    }

    /* compiled from: ContactsDao_Impl.java */
    /* loaded from: classes2.dex */
    class e implements Callable<List<Contact>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k f15571a;

        e(k kVar) {
            this.f15571a = kVar;
        }

        /* renamed from: a */
        public List<Contact> call() throws Exception {
            Cursor b10 = h1.c.b(a.this.f15566a, this.f15571a, false, null);
            try {
                int e10 = h1.b.e(b10, "id");
                int e11 = h1.b.e(b10, ContactConstant.CallsRecordKeys.NAME);
                int e12 = h1.b.e(b10, "num");
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    arrayList.add(new Contact(b10.getInt(e10), b10.isNull(e11) ? null : b10.getString(e11), b10.isNull(e12) ? null : b10.getString(e12)));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        protected void finalize() {
            this.f15571a.o();
        }
    }

    public a(RoomDatabase roomDatabase) {
        this.f15566a = roomDatabase;
        this.f15567b = new C0191a(this, roomDatabase);
        this.f15568c = new b(this, roomDatabase);
        this.f15569d = new c(this, roomDatabase);
        this.f15570e = new d(this, roomDatabase);
    }

    public static List<Class<?>> f() {
        return Collections.emptyList();
    }

    @Override // ga.a
    public int a() {
        int i10 = 0;
        k h10 = k.h("Select seq From sqlite_sequence Where name = 'contacts'", 0);
        this.f15566a.d();
        Cursor b10 = h1.c.b(this.f15566a, h10, false, null);
        try {
            if (b10.moveToFirst()) {
                i10 = b10.getInt(0);
            }
            return i10;
        } finally {
            b10.close();
            h10.o();
        }
    }

    @Override // ga.a
    public void b(Contact... contactArr) {
        this.f15566a.d();
        this.f15566a.e();
        try {
            this.f15568c.i(contactArr);
            this.f15566a.B();
        } finally {
            this.f15566a.i();
        }
    }

    @Override // ga.a
    public void c(List<Contact> list) {
        this.f15566a.d();
        this.f15566a.e();
        try {
            this.f15567b.h(list);
            this.f15566a.B();
        } finally {
            this.f15566a.i();
        }
    }

    @Override // ga.a
    public void clear() {
        this.f15566a.d();
        i1.f a10 = this.f15570e.a();
        this.f15566a.e();
        try {
            a10.r();
            this.f15566a.B();
        } finally {
            this.f15566a.i();
            this.f15570e.f(a10);
        }
    }

    @Override // ga.a
    public void d(String str, String str2) {
        this.f15566a.d();
        i1.f a10 = this.f15569d.a();
        if (str == null) {
            a10.l0(1);
        } else {
            a10.m(1, str);
        }
        if (str2 == null) {
            a10.l0(2);
        } else {
            a10.m(2, str2);
        }
        if (str == null) {
            a10.l0(3);
        } else {
            a10.m(3, str);
        }
        if (str2 == null) {
            a10.l0(4);
        } else {
            a10.m(4, str2);
        }
        this.f15566a.e();
        try {
            a10.r();
            this.f15566a.B();
        } finally {
            this.f15566a.i();
            this.f15569d.f(a10);
        }
    }

    @Override // ga.a
    public LiveData<List<Contact>> getAll() {
        return this.f15566a.k().e(new String[]{"contacts"}, false, new e(k.h("SELECT * FROM contacts ORDER BY name COLLATE LOCALIZED ASC", 0)));
    }

    @Override // ga.a
    public int size() {
        int i10 = 0;
        k h10 = k.h("SELECT count('id') FROM contacts", 0);
        this.f15566a.d();
        Cursor b10 = h1.c.b(this.f15566a, h10, false, null);
        try {
            if (b10.moveToFirst()) {
                i10 = b10.getInt(0);
            }
            return i10;
        } finally {
            b10.close();
            h10.o();
        }
    }
}
