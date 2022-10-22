package com.mobvoi.companion.lpa;

import com.mobvoi.android.common.json.JsonBean;
import kotlin.jvm.internal.f;
/* compiled from: OperatorSelection.kt */
/* loaded from: classes2.dex */
public final class x implements JsonBean {
    public static final a Companion = new a(null);
    public static final int DONT_NEED = 0;
    public static final int NEED = 1;
    public static final int UNCERTAIN = -1;
    private int needConfirm;
    private String operator;
    private String region;

    /* compiled from: OperatorSelection.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public final int a() {
        return this.needConfirm;
    }

    public String toString() {
        return "OperatorSelection{region='" + ((Object) this.region) + "', operator='" + ((Object) this.operator) + "', needConfirm=" + this.needConfirm + '}';
    }
}
