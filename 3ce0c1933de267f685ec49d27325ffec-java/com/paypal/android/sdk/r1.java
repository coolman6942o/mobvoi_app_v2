package com.paypal.android.sdk;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes2.dex */
public abstract class r1 {

    /* renamed from: k  reason: collision with root package name */
    private static final String f21874k = "r1";

    /* renamed from: l  reason: collision with root package name */
    private static long f21875l = 1;

    /* renamed from: a  reason: collision with root package name */
    private final Map f21876a = new LinkedHashMap();

    /* renamed from: b  reason: collision with root package name */
    private final s1 f21877b;

    /* renamed from: c  reason: collision with root package name */
    private final p1 f21878c;

    /* renamed from: d  reason: collision with root package name */
    private final String f21879d;

    /* renamed from: e  reason: collision with root package name */
    private final long f21880e;

    /* renamed from: f  reason: collision with root package name */
    private String f21881f;

    /* renamed from: g  reason: collision with root package name */
    private String f21882g;

    /* renamed from: h  reason: collision with root package name */
    private w0 f21883h;

    /* renamed from: i  reason: collision with root package name */
    private Integer f21884i;

    /* renamed from: j  reason: collision with root package name */
    private String f21885j;

    public r1(p1 p1Var, s1 s1Var, z zVar, String str) {
        long j10 = f21875l;
        f21875l = 1 + j10;
        this.f21880e = j10;
        this.f21878c = p1Var;
        this.f21879d = str;
        this.f21877b = s1Var;
    }

    public static void s() {
    }

    public final s1 A() {
        return this.f21877b;
    }

    public String a(p1 p1Var) {
        String b10 = this.f21877b.b(p1Var);
        if (b10 == null) {
            throw new RuntimeException("API " + p1Var.toString() + " has no record for server " + this.f21877b.c());
        } else if (this.f21879d == null) {
            return b10;
        } else {
            return b10 + this.f21879d;
        }
    }

    public final void b(w0 w0Var) {
        if (this.f21883h == null) {
            this.f21883h = w0Var;
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Multiple exceptions reported");
        String str = f21874k;
        Log.e(str, "first mError=" + this.f21883h);
        Log.e(str, "second mError=" + w0Var);
        Log.e(str, "", illegalStateException);
        throw illegalStateException;
    }

    public final void c(Integer num) {
        this.f21884i = num;
    }

    public final void d(String str) {
        this.f21881f = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e(String str, String str2) {
        this.f21876a.put(str, str2);
    }

    public final void f(String str, String str2, String str3) {
        b(new x0(str, str2, str3));
    }

    public boolean g() {
        return false;
    }

    public abstract String h();

    public final void i(String str) {
        this.f21882g = str;
    }

    public abstract void j();

    public final void k(String str) {
        this.f21885j = str;
    }

    public abstract void l();

    public abstract String m();

    public final String n() {
        return this.f21881f;
    }

    public final String o() {
        return this.f21882g;
    }

    public final p1 p() {
        return this.f21878c;
    }

    public final Map q() {
        return this.f21876a;
    }

    public final String r() {
        return this.f21885j;
    }

    public void t() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JSONObject u() {
        String str = this.f21882g;
        Object nextValue = new JSONTokener(str).nextValue();
        if (nextValue instanceof JSONObject) {
            return (JSONObject) nextValue;
        }
        throw new JSONException("could not parse:" + str + "\nnextValue:" + nextValue);
    }

    public final String v() {
        return getClass().getSimpleName() + " SN:" + this.f21880e;
    }

    public final long w() {
        return this.f21880e;
    }

    public final w0 x() {
        return this.f21883h;
    }

    public final boolean y() {
        return this.f21883h == null;
    }

    public final Integer z() {
        return this.f21884i;
    }
}
