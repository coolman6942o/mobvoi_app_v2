package ec;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.mobvoi.companion.aw.watchfacecenter.fragment.c;
import com.mobvoi.companion.aw.watchfacecenter.fragment.h;
import com.mobvoi.companion.aw.watchfacecenter.fragment.r;
import com.mobvoi.companion.aw.watchfacecenter.fragment.w;
import com.mobvoi.companion.aw.watchfacecenter.p;
import kotlin.jvm.internal.i;
/* compiled from: WatchFaceFragmentManager.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final FragmentManager f25883a;

    public a(FragmentManager fragmentManager) {
        i.f(fragmentManager, "fragmentManager");
        this.f25883a = fragmentManager;
    }

    private final com.mobvoi.companion.aw.watchfacecenter.fragment.a a(String str) {
        switch (str.hashCode()) {
            case -342973585:
                if (str.equals("my_watch_face_fragment")) {
                    return new c();
                }
                break;
            case -139082114:
                if (str.equals("detail_fragment")) {
                    return new r();
                }
                break;
            case -30460719:
                if (str.equals("list_fragment")) {
                    return new h();
                }
                break;
            case 1593230826:
                if (str.equals("more_watch_fragment")) {
                    return new w();
                }
                break;
        }
        return new h();
    }

    private final Fragment c() {
        if (this.f25883a.n0() <= 0) {
            return null;
        }
        FragmentManager fragmentManager = this.f25883a;
        return this.f25883a.g0(fragmentManager.m0(fragmentManager.n0() - 1).getName());
    }

    private final void e(com.mobvoi.companion.aw.watchfacecenter.fragment.a aVar, Bundle bundle) {
        androidx.fragment.app.w l10 = this.f25883a.l();
        i.e(l10, "fragmentManager.beginTransaction()");
        Fragment c10 = c();
        if (c10 != null) {
            l10.q(c10);
        }
        aVar.setArguments(bundle);
        if (aVar.isAdded()) {
            l10.z(aVar);
        } else {
            l10.c(p.f16465h, aVar, com.mobvoi.companion.aw.watchfacecenter.fragment.a.class.getSimpleName()).h(com.mobvoi.companion.aw.watchfacecenter.fragment.a.class.getSimpleName());
        }
        l10.j();
    }

    public final int b() {
        return this.f25883a.n0();
    }

    public final boolean d() {
        if (this.f25883a.n0() <= 1) {
            return true;
        }
        this.f25883a.Z0();
        return false;
    }

    public final void f(String tag, Bundle bundle, String str) {
        i.f(tag, "tag");
        Fragment g02 = this.f25883a.g0(tag);
        if (!(str == null || str.length() == 0)) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putString("extra_node_id", str);
            } else {
                bundle.putString("extra_node_id", str);
            }
        }
        if (g02 == null) {
            e(a(tag), bundle);
        } else if (g02 instanceof com.mobvoi.companion.aw.watchfacecenter.fragment.a) {
            e((com.mobvoi.companion.aw.watchfacecenter.fragment.a) g02, bundle);
        }
    }
}
