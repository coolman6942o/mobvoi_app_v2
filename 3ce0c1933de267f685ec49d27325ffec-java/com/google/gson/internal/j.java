package com.google.gson.internal;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.k;
import com.google.gson.l;
import com.google.gson.stream.MalformedJsonException;
import com.google.gson.stream.b;
import i8.n;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
/* compiled from: Streams.java */
/* loaded from: classes.dex */
public final class j {
    public static k a(com.google.gson.stream.a aVar) throws JsonParseException {
        EOFException e10;
        boolean z10;
        try {
            try {
                aVar.k0();
                z10 = false;
            } catch (EOFException e11) {
                e10 = e11;
                z10 = true;
            }
            try {
                return n.X.b(aVar);
            } catch (EOFException e12) {
                e10 = e12;
                if (z10) {
                    return l.f12652a;
                }
                throw new JsonSyntaxException(e10);
            }
        } catch (MalformedJsonException e13) {
            throw new JsonSyntaxException(e13);
        } catch (IOException e14) {
            throw new JsonIOException(e14);
        } catch (NumberFormatException e15) {
            throw new JsonSyntaxException(e15);
        }
    }

    public static void b(k kVar, b bVar) throws IOException {
        n.X.d(bVar, kVar);
    }

    public static Writer c(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    /* compiled from: Streams.java */
    /* loaded from: classes.dex */
    private static final class a extends Writer {

        /* renamed from: a  reason: collision with root package name */
        private final Appendable f12644a;

        /* renamed from: b  reason: collision with root package name */
        private final C0165a f12645b = new C0165a();

        /* compiled from: Streams.java */
        /* renamed from: com.google.gson.internal.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static class C0165a implements CharSequence {

            /* renamed from: a  reason: collision with root package name */
            char[] f12646a;

            C0165a() {
            }

            @Override // java.lang.CharSequence
            public char charAt(int i10) {
                return this.f12646a[i10];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f12646a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i10, int i11) {
                return new String(this.f12646a, i10, i11 - i10);
            }
        }

        a(Appendable appendable) {
            this.f12644a = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) throws IOException {
            C0165a aVar = this.f12645b;
            aVar.f12646a = cArr;
            this.f12644a.append(aVar, i10, i11 + i10);
        }

        @Override // java.io.Writer
        public void write(int i10) throws IOException {
            this.f12644a.append((char) i10);
        }
    }
}
