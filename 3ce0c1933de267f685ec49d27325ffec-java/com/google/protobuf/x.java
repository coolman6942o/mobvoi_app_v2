package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/* compiled from: LazyStringArrayList.java */
/* loaded from: classes.dex */
public class x extends d<String> implements y {

    /* renamed from: c  reason: collision with root package name */
    private static final x f13384c;

    /* renamed from: d  reason: collision with root package name */
    public static final y f13385d;

    /* renamed from: b  reason: collision with root package name */
    private final List<Object> f13386b;

    static {
        x xVar = new x();
        f13384c = xVar;
        xVar.c();
        f13385d = xVar;
    }

    public x() {
        this(10);
    }

    private static ByteString e(Object obj) {
        if (obj instanceof ByteString) {
            return (ByteString) obj;
        }
        if (obj instanceof String) {
            return ByteString.copyFromUtf8((String) obj);
        }
        return ByteString.copyFrom((byte[]) obj);
    }

    private static String f(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            return ((ByteString) obj).toStringUtf8();
        }
        return u.k((byte[]) obj);
    }

    @Override // com.google.protobuf.y
    public List<?> O() {
        return Collections.unmodifiableList(this.f13386b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        a();
        this.f13386b.clear();
        ((AbstractList) this).modCount++;
    }

    /* renamed from: d */
    public void add(int i10, String str) {
        a();
        this.f13386b.add(i10, str);
        ((AbstractList) this).modCount++;
    }

    /* renamed from: g */
    public String get(int i10) {
        Object obj = this.f13386b.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.f13386b.set(i10, stringUtf8);
            }
            return stringUtf8;
        }
        byte[] bArr = (byte[]) obj;
        String k10 = u.k(bArr);
        if (u.i(bArr)) {
            this.f13386b.set(i10, k10);
        }
        return k10;
    }

    /* renamed from: h */
    public String remove(int i10) {
        a();
        Object remove = this.f13386b.remove(i10);
        ((AbstractList) this).modCount++;
        return f(remove);
    }

    /* renamed from: i */
    public String set(int i10, String str) {
        a();
        return f(this.f13386b.set(i10, str));
    }

    @Override // com.google.protobuf.y
    public ByteString o0(int i10) {
        Object obj = this.f13386b.get(i10);
        ByteString e10 = e(obj);
        if (e10 != obj) {
            this.f13386b.set(i10, e10);
        }
        return e10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f13386b.size();
    }

    @Override // com.google.protobuf.y
    public y u0() {
        return b() ? new b1(this) : this;
    }

    @Override // com.google.protobuf.y
    public void v(ByteString byteString) {
        a();
        this.f13386b.add(byteString);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.y
    public Object z0(int i10) {
        return this.f13386b.get(i10);
    }

    public x(int i10) {
        this(new ArrayList(i10));
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i10, Collection<? extends String> collection) {
        a();
        if (collection instanceof y) {
            collection = ((y) collection).O();
        }
        boolean addAll = this.f13386b.addAll(i10, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    public x(y yVar) {
        this.f13386b = new ArrayList(yVar.size());
        addAll(yVar);
    }

    private x(ArrayList<Object> arrayList) {
        this.f13386b = arrayList;
    }
}
