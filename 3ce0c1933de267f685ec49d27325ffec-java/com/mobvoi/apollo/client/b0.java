package com.mobvoi.apollo.client;

import android.bluetooth.BluetoothDevice;
import com.mobvoi.apollo.client.d;
import com.mobvoi.apollo.protocol.ble.client.ClientState;
import java.util.concurrent.CopyOnWriteArrayList;
import ka.a;
import kotlin.jvm.internal.i;
/* compiled from: ListenerHub.kt */
/* loaded from: classes2.dex */
public final class b0 implements d.b {

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArrayList<d.b> f15464a = new CopyOnWriteArrayList<>();

    @Override // com.mobvoi.apollo.client.d.b
    public void a(BluetoothDevice device, ClientState newState) {
        i.f(device, "device");
        i.f(newState, "newState");
        for (d.b bVar : this.f15464a) {
            bVar.a(device, newState);
        }
    }

    @Override // com.mobvoi.apollo.client.d.b
    public void b(a packet) {
        i.f(packet, "packet");
        for (d.b bVar : this.f15464a) {
            bVar.b(packet);
        }
    }

    @Override // com.mobvoi.apollo.client.d.b
    public void c() {
        for (d.b bVar : this.f15464a) {
            bVar.c();
        }
    }

    @Override // com.mobvoi.apollo.client.d.b
    public void d(int i10, int i11) {
        for (d.b bVar : this.f15464a) {
            bVar.d(i10, i11);
        }
    }

    public final void e(d.b listener) {
        i.f(listener, "listener");
        if (!this.f15464a.contains(listener)) {
            this.f15464a.add(listener);
        }
    }

    public final void f(d.b listener) {
        i.f(listener, "listener");
        this.f15464a.remove(listener);
    }

    @Override // com.mobvoi.apollo.client.d.b
    public void i(boolean z10) {
        for (d.b bVar : this.f15464a) {
            bVar.i(z10);
        }
    }

    @Override // com.mobvoi.apollo.client.d.b
    public void k(BluetoothDevice device, da.a payload) {
        i.f(device, "device");
        i.f(payload, "payload");
        for (d.b bVar : this.f15464a) {
            bVar.k(device, payload);
        }
    }

    @Override // com.mobvoi.apollo.client.d.b
    public void m() {
        for (d.b bVar : this.f15464a) {
            bVar.m();
        }
    }
}
