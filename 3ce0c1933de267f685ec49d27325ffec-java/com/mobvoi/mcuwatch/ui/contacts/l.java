package com.mobvoi.mcuwatch.ui.contacts;

import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f;
import androidx.lifecycle.h0;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mobvoi.apollo.protocol.model.Contact;
import com.mobvoi.mcuwatch.ui.contacts.l;
import com.mobvoi.mcuwatch.ui.sms.ContactSection;
import io.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import kotlin.text.t;
import kotlin.text.u;
import sh.h;
import sh.i;
import sh.k;
/* compiled from: ContactsFragment.kt */
/* loaded from: classes2.dex */
public final class l extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final d f19540a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ContactsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a extends BaseSectionQuickAdapter<ContactSection, BaseViewHolder> {
        public a() {
            super(i.f34755t0, i.F0, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: c */
        public void convert(BaseViewHolder helper, ContactSection item) {
            kotlin.jvm.internal.i.f(helper, "helper");
            kotlin.jvm.internal.i.f(item, "item");
            helper.setText(h.O3, ((Contact) item.f8204t).getName());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d */
        public void convertHead(BaseViewHolder helper, ContactSection item) {
            kotlin.jvm.internal.i.f(helper, "helper");
            kotlin.jvm.internal.i.f(item, "item");
            helper.setText(h.f34647h4, item.header);
        }
    }

    /* compiled from: ContactsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends gc.i {

        /* renamed from: a  reason: collision with root package name */
        private boolean f19541a = true;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f19542b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l f19543c;

        b(a aVar, l lVar) {
            this.f19542b = aVar;
            this.f19543c = lVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0070 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x004a A[SYNTHETIC] */
        @Override // gc.i, android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void afterTextChanged(Editable s10) {
            boolean s11;
            boolean z10;
            boolean I;
            kotlin.jvm.internal.i.f(s10, "s");
            String obj = s10.toString();
            s11 = t.s(obj);
            if (!s11) {
                List<ContactSection> f10 = this.f19543c.c0().k().f();
                if (f10 != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : f10) {
                        ContactSection contactSection = (ContactSection) obj2;
                        if (!contactSection.isHeader) {
                            I = u.I(((Contact) contactSection.f8204t).getName(), obj, false, 2, null);
                            if (I) {
                                z10 = true;
                                if (!z10) {
                                    arrayList.add(obj2);
                                }
                            }
                        }
                        z10 = false;
                        if (!z10) {
                        }
                    }
                    this.f19542b.setNewData(arrayList);
                }
                this.f19541a = false;
            } else if (!this.f19541a) {
                this.f19541a = true;
                this.f19542b.setNewData(this.f19543c.c0().k().f());
            }
        }
    }

    /* compiled from: ContactsFragment.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements qo.a<o> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final o invoke() {
            f requireActivity = l.this.requireActivity();
            kotlin.jvm.internal.i.e(requireActivity, "requireActivity()");
            return (o) new h0(requireActivity).a(o.class);
        }
    }

    public l() {
        super(i.f34728a0);
        d a10;
        a10 = io.f.a(new c());
        this.f19540a = a10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final o c0() {
        return (o) this.f19540a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(l this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.g0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(a contactAdapter, l this$0, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        kotlin.jvm.internal.i.f(contactAdapter, "$contactAdapter");
        kotlin.jvm.internal.i.f(this$0, "this$0");
        ContactSection contactSection = (ContactSection) contactAdapter.getItem(i10);
        if (contactSection != null && !contactSection.isHeader) {
            T t10 = contactSection.f8204t;
            kotlin.jvm.internal.i.e(t10, "section.t");
            this$0.h0((Contact) t10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(a contactAdapter, List list) {
        kotlin.jvm.internal.i.f(contactAdapter, "$contactAdapter");
        contactAdapter.setNewData(list);
    }

    private final void g0() {
        getParentFragmentManager().l().s(h.A0, new com.mobvoi.mcuwatch.ui.contacts.c()).h(null).j();
    }

    private final void h0(Contact contact) {
        c0().l().o(contact);
        getParentFragmentManager().l().s(h.A0, new g()).h(null).j();
    }

    private final void i0() {
        requireActivity().setTitle(getString(k.B0));
        c0().m().o(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        kotlin.jvm.internal.i.f(menu, "menu");
        MenuItem findItem = menu.findItem(h.f34615b);
        if (findItem != null) {
            View actionView = findItem.getActionView();
            TextView textView = actionView instanceof TextView ? (TextView) actionView : null;
            if (textView != null) {
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(sh.f.f34598x, 0, 0, 0);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.contacts.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        l.d0(l.this, view);
                    }
                });
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        i0();
        final a aVar = new a();
        ((RecyclerView) view.findViewById(h.f34723z0)).setAdapter(aVar);
        aVar.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.mobvoi.mcuwatch.ui.contacts.k
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i10) {
                l.e0(l.a.this, this, baseQuickAdapter, view2, i10);
            }
        });
        ((EditText) view.findViewById(h.P2)).addTextChangedListener(new b(aVar, this));
        c0().k().i(getViewLifecycleOwner(), new x() { // from class: com.mobvoi.mcuwatch.ui.contacts.j
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                l.f0(l.a.this, (List) obj);
            }
        });
        if (requireActivity().getIntent().getBooleanExtra("toAdd", false)) {
            requireActivity().getIntent().removeExtra("toAdd");
            g0();
        }
    }
}
