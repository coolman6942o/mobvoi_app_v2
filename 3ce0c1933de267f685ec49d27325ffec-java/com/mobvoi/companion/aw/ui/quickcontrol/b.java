package com.mobvoi.companion.aw.ui.quickcontrol;

import android.os.Bundle;
import androidx.navigation.l;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: QuickControlFragmentDirections.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final C0200b f16335a = new C0200b(null);

    /* compiled from: QuickControlFragmentDirections.kt */
    /* renamed from: com.mobvoi.companion.aw.ui.quickcontrol.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0200b {
        private C0200b() {
        }

        public /* synthetic */ C0200b(f fVar) {
            this();
        }

        public final l a(String nodeId) {
            i.f(nodeId, "nodeId");
            return new a(nodeId);
        }
    }

    /* compiled from: QuickControlFragmentDirections.kt */
    /* loaded from: classes2.dex */
    private static final class a implements l {

        /* renamed from: a  reason: collision with root package name */
        private final String f16336a;

        public a() {
            this(null, 1, null);
        }

        public a(String nodeId) {
            i.f(nodeId, "nodeId");
            this.f16336a = nodeId;
        }

        @Override // androidx.navigation.l
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putString("nodeId", this.f16336a);
            return bundle;
        }

        @Override // androidx.navigation.l
        public int b() {
            return od.b.a_res_0x7f0b006d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && i.b(this.f16336a, ((a) obj).f16336a);
        }

        public int hashCode() {
            return this.f16336a.hashCode();
        }

        public String toString() {
            return "ActionQuickControlToTicPulse(nodeId=" + this.f16336a + ')';
        }

        public /* synthetic */ a(String str, int i10, f fVar) {
            this((i10 & 1) != 0 ? "" : str);
        }
    }
}
