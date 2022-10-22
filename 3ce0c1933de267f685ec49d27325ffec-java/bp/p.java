package bp;

import android.bluetooth.BluetoothGatt;
import android.content.Intent;
import bp.h;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
/* compiled from: DfuServiceProvider.java */
/* loaded from: classes3.dex */
class p implements h {

    /* renamed from: a  reason: collision with root package name */
    private c f5494a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5495b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5496c;

    @Override // bp.i
    public void a() {
        this.f5496c = true;
        c cVar = this.f5494a;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // bp.i
    public void b() {
        this.f5495b = true;
    }

    @Override // bp.h
    public void c(int i10) {
        c cVar = this.f5494a;
        if (cVar != null) {
            cVar.c(i10);
        }
    }

    @Override // bp.i
    public void d() {
        this.f5495b = false;
    }

    @Override // bp.h
    public h.a e() {
        c cVar = this.f5494a;
        if (cVar != null) {
            return cVar.e();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Finally extract failed */
    public l i(Intent intent, g gVar, BluetoothGatt bluetoothGatt) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        try {
            e eVar = new e(intent, gVar);
            this.f5494a = eVar;
            if (eVar.f(intent, bluetoothGatt)) {
                c cVar = this.f5494a;
                if (cVar != null) {
                    if (this.f5495b) {
                        cVar.b();
                    }
                    if (this.f5496c) {
                        this.f5494a.a();
                    }
                }
                return cVar;
            }
            f fVar = new f(intent, gVar);
            this.f5494a = fVar;
            if (fVar.f(intent, bluetoothGatt)) {
                c cVar2 = this.f5494a;
                if (cVar2 != null) {
                    if (this.f5495b) {
                        cVar2.b();
                    }
                    if (this.f5496c) {
                        this.f5494a.a();
                    }
                }
                return cVar2;
            }
            v vVar = new v(intent, gVar);
            this.f5494a = vVar;
            if (vVar.f(intent, bluetoothGatt)) {
                c cVar3 = this.f5494a;
                if (cVar3 != null) {
                    if (this.f5495b) {
                        cVar3.b();
                    }
                    if (this.f5496c) {
                        this.f5494a.a();
                    }
                }
                return cVar3;
            }
            r rVar = new r(intent, gVar);
            this.f5494a = rVar;
            if (rVar.f(intent, bluetoothGatt)) {
                c cVar4 = this.f5494a;
                if (cVar4 != null) {
                    if (this.f5495b) {
                        cVar4.b();
                    }
                    if (this.f5496c) {
                        this.f5494a.a();
                    }
                }
                return cVar4;
            }
            s sVar = new s(intent, gVar);
            this.f5494a = sVar;
            if (sVar.f(intent, bluetoothGatt)) {
                c cVar5 = this.f5494a;
                if (cVar5 != null) {
                    if (this.f5495b) {
                        cVar5.b();
                    }
                    if (this.f5496c) {
                        this.f5494a.a();
                    }
                }
                return cVar5;
            }
            if (intent.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_UNSAFE_EXPERIMENTAL_BUTTONLESS_DFU", false)) {
                q qVar = new q(intent, gVar);
                this.f5494a = qVar;
                if (qVar.f(intent, bluetoothGatt)) {
                    c cVar6 = this.f5494a;
                    if (cVar6 != null) {
                        if (this.f5495b) {
                            cVar6.b();
                        }
                        if (this.f5496c) {
                            this.f5494a.a();
                        }
                    }
                    return cVar6;
                }
            }
            c cVar7 = this.f5494a;
            if (cVar7 != null) {
                if (this.f5495b) {
                    cVar7.b();
                }
                if (this.f5496c) {
                    this.f5494a.a();
                }
            }
            return null;
        } catch (Throwable th2) {
            c cVar8 = this.f5494a;
            if (cVar8 != null) {
                if (this.f5495b) {
                    cVar8.b();
                }
                if (this.f5496c) {
                    this.f5494a.a();
                }
            }
            throw th2;
        }
    }
}
