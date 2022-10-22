package com.mobvoi.mcuwatch.ui.contacts;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f;
import androidx.lifecycle.h0;
import androidx.lifecycle.x;
import com.mobvoi.apollo.client.q;
import com.mobvoi.apollo.protocol.model.Contact;
import io.d;
import io.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import qo.l;
import sh.h;
import sh.k;
/* compiled from: ContactDetailFragment.kt */
/* loaded from: classes2.dex */
public final class g extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final d f19534a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ContactDetailFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements l<Boolean, m> {
        a() {
            super(1);
        }

        public final void a(boolean z10) {
            if (z10) {
                g.this.getParentFragmentManager().W0();
            } else {
                Toast.makeText(g.this.getContext(), "删除联系人失败", 0).show();
            }
        }

        @Override // qo.l
        public /* bridge */ /* synthetic */ m invoke(Boolean bool) {
            a(bool.booleanValue());
            return m.f28349a;
        }
    }

    /* compiled from: ContactDetailFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements qo.a<o> {
        b() {
            super(0);
        }

        /* renamed from: a */
        public final o invoke() {
            f requireActivity = g.this.requireActivity();
            i.e(requireActivity, "requireActivity()");
            return (o) new h0(requireActivity).a(o.class);
        }
    }

    public g() {
        super(sh.i.Y);
        d a10;
        a10 = io.f.a(new b());
        this.f19534a = a10;
    }

    private final o b0() {
        return (o) this.f19534a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(g this$0, View view) {
        i.f(this$0, "this$0");
        this$0.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(View view, Contact contact) {
        i.f(view, "$view");
        if (contact != null) {
            ((TextView) view.findViewById(h.O3)).setText(contact.getName());
            ((TextView) view.findViewById(h.R3)).setText(v.b(contact.getNum()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(g this$0, View view) {
        i.f(this$0, "this$0");
        if (!q.f15504a.B()) {
            Toast.makeText(this$0.getContext(), k.V, 0).show();
        } else {
            this$0.b0().j(new a());
        }
    }

    private final void f0() {
        getParentFragmentManager().l().s(h.A0, new t()).h(null).j();
    }

    private final void g0() {
        Contact f10 = b0().l().f();
        requireActivity().setTitle(f10 == null ? null : f10.getName());
        b0().m().o(2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        i.f(menu, "menu");
        MenuItem findItem = menu.findItem(h.f34615b);
        if (findItem != null) {
            View actionView = findItem.getActionView();
            TextView textView = actionView instanceof TextView ? (TextView) actionView : null;
            if (textView != null) {
                textView.setText(getString(k.D0));
                textView.setTextColor(requireContext().getColor(sh.d.G));
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.contacts.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        g.c0(g.this, view);
                    }
                });
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        g0();
        b0().l().i(getViewLifecycleOwner(), new x() { // from class: com.mobvoi.mcuwatch.ui.contacts.f
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                g.d0(view, (Contact) obj);
            }
        });
        ((Button) view.findViewById(h.Y)).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.contacts.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g.e0(g.this, view2);
            }
        });
    }
}
