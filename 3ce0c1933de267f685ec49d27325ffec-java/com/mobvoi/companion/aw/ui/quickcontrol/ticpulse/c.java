package com.mobvoi.companion.aw.ui.quickcontrol.ticpulse;

import android.os.Bundle;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: ControlTicPulseFragmentArgs.kt */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: b  reason: collision with root package name */
    public static final a f16342b = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f16343a;

    /* compiled from: ControlTicPulseFragmentArgs.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final c a(Bundle bundle) {
            String str;
            i.f(bundle, "bundle");
            bundle.setClassLoader(c.class.getClassLoader());
            if (bundle.containsKey("nodeId")) {
                str = bundle.getString("nodeId");
                if (str == null) {
                    throw new IllegalArgumentException("Argument \"nodeId\" is marked as non-null but was passed a null value.");
                }
            } else {
                str = "";
            }
            return new c(str);
        }
    }

    public c() {
        this(null, 1, null);
    }

    public c(String nodeId) {
        i.f(nodeId, "nodeId");
        this.f16343a = nodeId;
    }

    public static final c fromBundle(Bundle bundle) {
        return f16342b.a(bundle);
    }

    public final String a() {
        return this.f16343a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && i.b(this.f16343a, ((c) obj).f16343a);
    }

    public int hashCode() {
        return this.f16343a.hashCode();
    }

    public String toString() {
        return "ControlTicPulseFragmentArgs(nodeId=" + this.f16343a + ')';
    }

    public /* synthetic */ c(String str, int i10, f fVar) {
        this((i10 & 1) != 0 ? "" : str);
    }
}
