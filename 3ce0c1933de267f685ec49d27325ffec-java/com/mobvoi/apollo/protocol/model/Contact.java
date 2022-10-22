package com.mobvoi.apollo.protocol.model;

import com.mobvoi.android.common.json.JsonBean;
import kotlin.jvm.internal.i;
/* compiled from: Contact.kt */
/* loaded from: classes2.dex */
public final class Contact implements JsonBean {
    @SkipGsonSerialize

    /* renamed from: id  reason: collision with root package name */
    private final int f15612id;
    private final String name;
    private final String num;

    public Contact(int i10, String name, String num) {
        i.f(name, "name");
        i.f(num, "num");
        this.f15612id = i10;
        this.name = name;
        this.num = num;
    }

    public static /* synthetic */ Contact copy$default(Contact contact, int i10, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = contact.f15612id;
        }
        if ((i11 & 2) != 0) {
            str = contact.name;
        }
        if ((i11 & 4) != 0) {
            str2 = contact.num;
        }
        return contact.copy(i10, str, str2);
    }

    public final int component1() {
        return this.f15612id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.num;
    }

    public final Contact copy(int i10, String name, String num) {
        i.f(name, "name");
        i.f(num, "num");
        return new Contact(i10, name, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Contact)) {
            return false;
        }
        Contact contact = (Contact) obj;
        return this.f15612id == contact.f15612id && i.b(this.name, contact.name) && i.b(this.num, contact.num);
    }

    public final int getId() {
        return this.f15612id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNum() {
        return this.num;
    }

    public int hashCode() {
        return (((this.f15612id * 31) + this.name.hashCode()) * 31) + this.num.hashCode();
    }

    public String toString() {
        return "Contact(id=" + this.f15612id + ", name=" + this.name + ", num=" + this.num + ')';
    }
}
