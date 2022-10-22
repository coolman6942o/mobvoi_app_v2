package com.mobvoi.mcuwatch.ui.sms;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f;
import androidx.lifecycle.h0;
import androidx.lifecycle.p;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mobvoi.apollo.protocol.model.Contact;
import com.mobvoi.mcuwatch.ui.sms.g;
import io.d;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import sh.h;
import sh.i;
import sh.k;
/* compiled from: SelectContactFragment.kt */
/* loaded from: classes2.dex */
public final class g extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final d f20231a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SelectContactFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a extends BaseSectionQuickAdapter<ContactSection, BaseViewHolder> {
        public a() {
            super(i.E0, i.F0, null);
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

    /* compiled from: SelectContactFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements qo.a<m> {
        b() {
            super(0);
        }

        /* renamed from: a */
        public final m invoke() {
            f requireActivity = g.this.requireActivity();
            kotlin.jvm.internal.i.e(requireActivity, "requireActivity()");
            return (m) new h0(requireActivity).a(m.class);
        }
    }

    public g() {
        super(i.f34744m0);
        d a10;
        a10 = io.f.a(new b());
        this.f20231a = a10;
    }

    private final m a0() {
        return (m) this.f20231a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(a contactAdapter, List list) {
        kotlin.jvm.internal.i.f(contactAdapter, "$contactAdapter");
        contactAdapter.setNewData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    public static final void c0(a contactAdapter, g this$0, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        kotlin.jvm.internal.i.f(contactAdapter, "$contactAdapter");
        kotlin.jvm.internal.i.f(this$0, "this$0");
        ContactSection contactSection = (ContactSection) contactAdapter.getItem(i10);
        if (contactSection != null && !contactSection.isHeader) {
            this$0.a0().k().o(contactSection.f8204t);
            this$0.getParentFragmentManager().W0();
        }
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
            findItem.setVisible(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        requireActivity().setTitle(getString(k.I1));
        final a aVar = new a();
        aVar.bindToRecyclerView((RecyclerView) view.findViewById(h.f34723z0));
        m a02 = a0();
        p viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.i.e(viewLifecycleOwner, "viewLifecycleOwner");
        a02.e(viewLifecycleOwner, new x() { // from class: com.mobvoi.mcuwatch.ui.sms.e
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                g.b0(g.a.this, (List) obj);
            }
        });
        aVar.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.mobvoi.mcuwatch.ui.sms.f
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i10) {
                g.c0(g.a.this, this, baseQuickAdapter, view2, i10);
            }
        });
    }
}
