package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.c;
import androidx.appcompat.view.menu.j;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import d.g;
/* compiled from: MenuDialogHelper.java */
/* loaded from: classes.dex */
class f implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, j.a {

    /* renamed from: a  reason: collision with root package name */
    private e f724a;

    /* renamed from: b  reason: collision with root package name */
    private c f725b;

    /* renamed from: c  reason: collision with root package name */
    c f726c;

    /* renamed from: d  reason: collision with root package name */
    private j.a f727d;

    public f(e eVar) {
        this.f724a = eVar;
    }

    public void a() {
        c cVar = this.f725b;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    public void b(IBinder iBinder) {
        e eVar = this.f724a;
        c.a aVar = new c.a(eVar.w());
        c cVar = new c(aVar.b(), g.f24824j);
        this.f726c = cVar;
        cVar.h(this);
        this.f724a.b(this.f726c);
        aVar.c(this.f726c.a(), this);
        View A = eVar.A();
        if (A != null) {
            aVar.e(A);
        } else {
            aVar.f(eVar.y()).r(eVar.z());
        }
        aVar.l(this);
        c a10 = aVar.a();
        this.f725b = a10;
        a10.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f725b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
        this.f725b.show();
    }

    @Override // androidx.appcompat.view.menu.j.a
    public void c(e eVar, boolean z10) {
        if (z10 || eVar == this.f724a) {
            a();
        }
        j.a aVar = this.f727d;
        if (aVar != null) {
            aVar.c(eVar, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.j.a
    public boolean d(e eVar) {
        j.a aVar = this.f727d;
        if (aVar != null) {
            return aVar.d(eVar);
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        this.f724a.N((g) this.f726c.a().getItem(i10), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f726c.c(this.f724a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i10 == 82 || i10 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f725b.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f725b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f724a.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f724a.performShortcut(i10, keyEvent, 0);
    }
}
