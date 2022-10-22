package com.google.gson;

import com.google.gson.internal.j;
import com.google.gson.stream.b;
import java.io.IOException;
import java.io.StringWriter;
/* compiled from: JsonElement.java */
/* loaded from: classes.dex */
public abstract class k {
    public h a() {
        if (d()) {
            return (h) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public m b() {
        if (f()) {
            return (m) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public n c() {
        if (g()) {
            return (n) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public boolean d() {
        return this instanceof h;
    }

    public boolean e() {
        return this instanceof l;
    }

    public boolean f() {
        return this instanceof m;
    }

    public boolean g() {
        return this instanceof n;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            b bVar = new b(stringWriter);
            bVar.h0(true);
            j.b(this, bVar);
            return stringWriter.toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }
}
