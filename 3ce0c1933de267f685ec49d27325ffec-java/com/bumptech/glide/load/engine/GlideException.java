package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import q4.b;
/* loaded from: classes.dex */
public final class GlideException extends Exception {
    private static final StackTraceElement[] EMPTY_ELEMENTS = new StackTraceElement[0];
    private static final long serialVersionUID = 1;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private DataSource dataSource;
    private String detailMessage;
    private Exception exception;
    private b key;

    public GlideException(String str) {
        this(str, Collections.emptyList());
    }

    private void a(Throwable th2, List<Throwable> list) {
        if (th2 instanceof GlideException) {
            for (Throwable th3 : ((GlideException) th2).getCauses()) {
                a(th3, list);
            }
            return;
        }
        list.add(th2);
    }

    private static void b(List<Throwable> list, Appendable appendable) {
        try {
            c(list, appendable);
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    private static void c(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            appendable.append("Cause (").append(String.valueOf(i11)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th2 = list.get(i10);
            if (th2 instanceof GlideException) {
                ((GlideException) th2).g(appendable);
            } else {
                d(th2, appendable);
            }
            i10 = i11;
        }
    }

    private static void d(Throwable th2, Appendable appendable) {
        try {
            appendable.append(th2.getClass().toString()).append(": ").append(th2.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th2);
        }
    }

    private void g(Appendable appendable) {
        d(this, appendable);
        b(getCauses(), new a(appendable));
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    public List<Throwable> getCauses() {
        return this.causes;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb2 = new StringBuilder(71);
        sb2.append(this.detailMessage);
        String str = "";
        sb2.append(this.dataClass != null ? ", " + this.dataClass : str);
        sb2.append(this.dataSource != null ? ", " + this.dataSource : str);
        if (this.key != null) {
            str = ", " + this.key;
        }
        sb2.append(str);
        List<Throwable> rootCauses = getRootCauses();
        if (rootCauses.isEmpty()) {
            return sb2.toString();
        }
        if (rootCauses.size() == 1) {
            sb2.append("\nThere was 1 cause:");
        } else {
            sb2.append("\nThere were ");
            sb2.append(rootCauses.size());
            sb2.append(" causes:");
        }
        for (Throwable th2 : rootCauses) {
            sb2.append('\n');
            sb2.append(th2.getClass().getName());
            sb2.append('(');
            sb2.append(th2.getMessage());
            sb2.append(')');
        }
        sb2.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb2.toString();
    }

    public Exception getOrigin() {
        return this.exception;
    }

    public List<Throwable> getRootCauses() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(b bVar, DataSource dataSource) {
        i(bVar, dataSource, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(b bVar, DataSource dataSource, Class<?> cls) {
        this.key = bVar;
        this.dataSource = dataSource;
        this.dataClass = cls;
    }

    public void logRootCauses(String str) {
        List<Throwable> rootCauses = getRootCauses();
        int size = rootCauses.size();
        int i10 = 0;
        while (i10 < size) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Root cause (");
            int i11 = i10 + 1;
            sb2.append(i11);
            sb2.append(" of ");
            sb2.append(size);
            sb2.append(")");
            Log.i(str, sb2.toString(), rootCauses.get(i10));
            i10 = i11;
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void setOrigin(Exception exc) {
        this.exception = exc;
    }

    public GlideException(String str, Throwable th2) {
        this(str, Collections.singletonList(th2));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        g(printStream);
    }

    public GlideException(String str, List<Throwable> list) {
        this.detailMessage = str;
        setStackTrace(EMPTY_ELEMENTS);
        this.causes = list;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        g(printWriter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a implements Appendable {

        /* renamed from: a  reason: collision with root package name */
        private final Appendable f7863a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f7864b = true;

        a(Appendable appendable) {
            this.f7863a = appendable;
        }

        private CharSequence a(CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c10) throws IOException {
            boolean z10 = false;
            if (this.f7864b) {
                this.f7864b = false;
                this.f7863a.append("  ");
            }
            if (c10 == '\n') {
                z10 = true;
            }
            this.f7864b = z10;
            this.f7863a.append(c10);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) throws IOException {
            CharSequence a10 = a(charSequence);
            return append(a10, 0, a10.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i10, int i11) throws IOException {
            CharSequence a10 = a(charSequence);
            boolean z10 = false;
            if (this.f7864b) {
                this.f7864b = false;
                this.f7863a.append("  ");
            }
            if (a10.length() > 0 && a10.charAt(i11 - 1) == '\n') {
                z10 = true;
            }
            this.f7864b = z10;
            this.f7863a.append(a10, i10, i11);
            return this;
        }
    }
}
