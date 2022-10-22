package com.google.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
/* compiled from: UnmodifiableLazyStringList.java */
/* loaded from: classes.dex */
public class b1 extends AbstractList<String> implements y, RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    private final y f13174a;

    /* compiled from: UnmodifiableLazyStringList.java */
    /* loaded from: classes.dex */
    class a implements ListIterator<String> {

        /* renamed from: a  reason: collision with root package name */
        ListIterator<String> f13175a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f13176b;

        a(int i10) {
            this.f13176b = i10;
            this.f13175a = b1.this.f13174a.listIterator(i10);
        }

        /* renamed from: a */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: b */
        public String next() {
            return this.f13175a.next();
        }

        /* renamed from: c */
        public String previous() {
            return this.f13175a.previous();
        }

        /* renamed from: d */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f13175a.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f13175a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f13175a.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f13175a.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: UnmodifiableLazyStringList.java */
    /* loaded from: classes.dex */
    class b implements Iterator<String> {

        /* renamed from: a  reason: collision with root package name */
        Iterator<String> f13178a;

        b() {
            this.f13178a = b1.this.f13174a.iterator();
        }

        /* renamed from: a */
        public String next() {
            return this.f13178a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13178a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public b1(y yVar) {
        this.f13174a = yVar;
    }

    @Override // com.google.protobuf.y
    public List<?> O() {
        return this.f13174a.O();
    }

    /* renamed from: b */
    public String get(int i10) {
        return this.f13174a.get(i10);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new b();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i10) {
        return new a(i10);
    }

    @Override // com.google.protobuf.y
    public ByteString o0(int i10) {
        return this.f13174a.o0(i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f13174a.size();
    }

    @Override // com.google.protobuf.y
    public y u0() {
        return this;
    }

    @Override // com.google.protobuf.y
    public void v(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.y
    public Object z0(int i10) {
        return this.f13174a.z0(i10);
    }
}
