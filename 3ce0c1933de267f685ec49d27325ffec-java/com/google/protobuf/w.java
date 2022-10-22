package com.google.protobuf;

import java.util.Objects;
/* compiled from: LazyFieldLite.java */
/* loaded from: classes.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    private ByteString f13378a;

    /* renamed from: b  reason: collision with root package name */
    private q f13379b;

    /* renamed from: c  reason: collision with root package name */
    protected volatile e0 f13380c;

    /* renamed from: d  reason: collision with root package name */
    private volatile ByteString f13381d;

    static {
        q.a();
    }

    public w(q qVar, ByteString byteString) {
        a(qVar, byteString);
        this.f13379b = qVar;
        this.f13378a = byteString;
    }

    private static void a(q qVar, ByteString byteString) {
        Objects.requireNonNull(qVar, "found null ExtensionRegistry");
        Objects.requireNonNull(byteString, "found null ByteString");
    }

    protected void b(e0 e0Var) {
        if (this.f13380c == null) {
            synchronized (this) {
                if (this.f13380c == null) {
                    try {
                        if (this.f13378a != null) {
                            this.f13380c = e0Var.getParserForType().parseFrom(this.f13378a, this.f13379b);
                            this.f13381d = this.f13378a;
                        } else {
                            this.f13380c = e0Var;
                            this.f13381d = ByteString.EMPTY;
                        }
                    } catch (InvalidProtocolBufferException unused) {
                        this.f13380c = e0Var;
                        this.f13381d = ByteString.EMPTY;
                    }
                }
            }
        }
    }

    public int c() {
        if (this.f13381d != null) {
            return this.f13381d.size();
        }
        ByteString byteString = this.f13378a;
        if (byteString != null) {
            return byteString.size();
        }
        if (this.f13380c != null) {
            return this.f13380c.getSerializedSize();
        }
        return 0;
    }

    public e0 d(e0 e0Var) {
        b(e0Var);
        return this.f13380c;
    }

    public e0 e(e0 e0Var) {
        e0 e0Var2 = this.f13380c;
        this.f13378a = null;
        this.f13381d = null;
        this.f13380c = e0Var;
        return e0Var2;
    }

    public ByteString f() {
        if (this.f13381d != null) {
            return this.f13381d;
        }
        ByteString byteString = this.f13378a;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            if (this.f13381d != null) {
                return this.f13381d;
            }
            if (this.f13380c == null) {
                this.f13381d = ByteString.EMPTY;
            } else {
                this.f13381d = this.f13380c.toByteString();
            }
            return this.f13381d;
        }
    }
}
