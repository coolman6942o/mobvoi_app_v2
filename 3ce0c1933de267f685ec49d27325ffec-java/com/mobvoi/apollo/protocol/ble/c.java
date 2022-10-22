package com.mobvoi.apollo.protocol.ble;

import java.util.UUID;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: BleServiceInfo.kt */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final UUID f15588a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15589b;

    /* compiled from: BleServiceInfo.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    public c(UUID uuid, int i10) {
        i.f(uuid, "uuid");
        this.f15588a = uuid;
        this.f15589b = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return i.b(this.f15588a, cVar.f15588a) && this.f15589b == cVar.f15589b;
    }

    public int hashCode() {
        return (this.f15588a.hashCode() * 31) + this.f15589b;
    }

    public String toString() {
        return "BleServiceInfo(uuid=" + this.f15588a + ", instanceId=" + this.f15589b + ')';
    }
}
