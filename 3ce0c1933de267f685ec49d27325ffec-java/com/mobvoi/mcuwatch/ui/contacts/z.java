package com.mobvoi.mcuwatch.ui.contacts;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.h0;
import androidx.loader.app.a;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mobvoi.apollo.protocol.model.Contact;
import com.mobvoi.wear.util.DimensionUtils;
import io.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import qo.l;
import sh.f;
import sh.h;
import sh.i;
import sh.k;
/* compiled from: SyncSystemContactFragment.kt */
/* loaded from: classes2.dex */
public final class z extends Fragment implements a.AbstractC0034a<Cursor> {

    /* renamed from: a  reason: collision with root package name */
    private final io.d f19574a;

    /* renamed from: b  reason: collision with root package name */
    private final io.d f19575b;

    /* renamed from: c  reason: collision with root package name */
    private a f19576c;

    /* renamed from: d  reason: collision with root package name */
    private Button f19577d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SyncSystemContactFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a extends BaseQuickAdapter<b, BaseViewHolder> {
        public a() {
            super(i.f34757u0);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: c */
        public void convert(BaseViewHolder helper, b item) {
            kotlin.jvm.internal.i.f(helper, "helper");
            kotlin.jvm.internal.i.f(item, "item");
            helper.setText(h.O3, item.a());
            int i10 = h.f34713x0;
            helper.setVisible(i10, !item.d());
            helper.setBackgroundRes(i10, item.c() ? f.f34580r : f.f34583s);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SyncSystemContactFragment.kt */
    /* loaded from: classes2.dex */
    public static final class c extends Lambda implements l<Integer, m> {
        c() {
            super(1);
        }

        public final void a(int i10) {
            if (i10 != 0) {
                Toast.makeText(z.this.getContext(), i10 != 1 ? i10 != 2 ? "添加联系人失败" : "已存在该手机号联系人" : "已存在同名联系人", 0).show();
                return;
            }
            z.this.getParentFragmentManager().W0();
            z.this.getParentFragmentManager().W0();
        }

        @Override // qo.l
        public /* bridge */ /* synthetic */ m invoke(Integer num) {
            a(num.intValue());
            return m.f28349a;
        }
    }

    /* compiled from: SyncSystemContactFragment.kt */
    /* loaded from: classes2.dex */
    static final class d extends Lambda implements qo.a<List<? extends Contact>> {
        d() {
            super(0);
        }

        /* renamed from: a */
        public final List<Contact> invoke() {
            List<Contact> g10;
            List<Contact> f10 = z.this.d0().i().f();
            if (f10 != null) {
                return f10;
            }
            g10 = kotlin.collections.m.g();
            return g10;
        }
    }

    /* compiled from: SyncSystemContactFragment.kt */
    /* loaded from: classes2.dex */
    static final class e extends Lambda implements qo.a<o> {
        e() {
            super(0);
        }

        /* renamed from: a */
        public final o invoke() {
            androidx.fragment.app.f requireActivity = z.this.requireActivity();
            kotlin.jvm.internal.i.e(requireActivity, "requireActivity()");
            return (o) new h0(requireActivity).a(o.class);
        }
    }

    public z() {
        super(i.f34745n0);
        io.d a10;
        io.d a11;
        a10 = io.f.a(new e());
        this.f19574a = a10;
        a11 = io.f.a(new d());
        this.f19575b = a11;
    }

    private final List<Contact> c0() {
        return (List) this.f19575b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final o d0() {
        return (o) this.f19574a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(List list, z this$0, boolean z10, View view) {
        kotlin.jvm.internal.i.f(list, "$list");
        kotlin.jvm.internal.i.f(this$0, "this$0");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((b) it.next()).e(z10);
        }
        a aVar = this$0.f19576c;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
            androidx.fragment.app.f activity = this$0.getActivity();
            if (activity != null) {
                activity.invalidateOptionsMenu();
                return;
            }
            return;
        }
        kotlin.jvm.internal.i.u("contactAdapter");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(z this$0, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        a aVar = this$0.f19576c;
        if (aVar != null) {
            b item = aVar.getItem(i10);
            if (item != null && !item.d()) {
                item.e(!item.c());
                a aVar2 = this$0.f19576c;
                if (aVar2 != null) {
                    aVar2.notifyDataSetChanged();
                    androidx.fragment.app.f activity = this$0.getActivity();
                    if (activity != null) {
                        activity.invalidateOptionsMenu();
                        return;
                    }
                    return;
                }
                kotlin.jvm.internal.i.u("contactAdapter");
                throw null;
            }
            return;
        }
        kotlin.jvm.internal.i.u("contactAdapter");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(z this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        a aVar = this$0.f19576c;
        if (aVar != null) {
            List<b> data = aVar.getData();
            kotlin.jvm.internal.i.e(data, "contactAdapter.data");
            ArrayList arrayList = new ArrayList();
            for (Object obj : data) {
                if (((b) obj).c()) {
                    arrayList.add(obj);
                }
            }
            this$0.d0().e(arrayList, new c());
            return;
        }
        kotlin.jvm.internal.i.u("contactAdapter");
        throw null;
    }

    private final void i0() {
        requireActivity().setTitle(getString(k.H0));
        d0().m().o(4);
    }

    @Override // androidx.loader.app.a.AbstractC0034a
    public void V(androidx.loader.content.c<Cursor> loader) {
        kotlin.jvm.internal.i.f(loader, "loader");
    }

    @SuppressLint({"Range"})
    /* renamed from: e0 */
    public void o(androidx.loader.content.c<Cursor> loader, Cursor cursor) {
        Object obj;
        kotlin.jvm.internal.i.f(loader, "loader");
        if (cursor != null && cursor.moveToFirst()) {
            ArrayList arrayList = new ArrayList();
            do {
                String name = cursor.getString(cursor.getColumnIndex("display_name"));
                String phone = cursor.getString(cursor.getColumnIndex("data1"));
                kotlin.jvm.internal.i.e(name, "name");
                kotlin.jvm.internal.i.e(phone, "phone");
                b bVar = new b(name, v.a(phone), false, false, 12, null);
                Iterator<T> it = c0().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (bVar.equals((Contact) obj)) {
                        break;
                    }
                }
                if (((Contact) obj) != null) {
                    bVar.f(true);
                    bVar.e(false);
                }
                arrayList.add(bVar);
            } while (cursor.moveToNext());
            a aVar = this.f19576c;
            if (aVar != null) {
                aVar.setNewData(arrayList);
                androidx.fragment.app.f activity = getActivity();
                if (activity != null) {
                    activity.invalidateOptionsMenu();
                    return;
                }
                return;
            }
            kotlin.jvm.internal.i.u("contactAdapter");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        androidx.loader.app.a.b(this).c(0, null, this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        boolean z10;
        boolean z11;
        final boolean z12;
        kotlin.jvm.internal.i.f(menu, "menu");
        MenuItem findItem = menu.findItem(h.f34615b);
        if (findItem != null) {
            View actionView = findItem.getActionView();
            TextView textView = actionView instanceof TextView ? (TextView) actionView : null;
            if (textView != null) {
                a aVar = this.f19576c;
                if (aVar != null) {
                    List<b> data = aVar.getData();
                    kotlin.jvm.internal.i.e(data, "contactAdapter.data");
                    final ArrayList<b> arrayList = new ArrayList();
                    Iterator<T> it = data.iterator();
                    while (true) {
                        z10 = true;
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (true ^ ((b) next).d()) {
                            arrayList.add(next);
                        }
                    }
                    textView.setEnabled(!arrayList.isEmpty());
                    if (arrayList.isEmpty()) {
                        textView.setTextColor(requireContext().getColor(sh.d.H));
                    } else {
                        if (!arrayList.isEmpty()) {
                            for (b bVar : arrayList) {
                                if (!bVar.c()) {
                                    z11 = true;
                                    break;
                                }
                            }
                        }
                        z11 = false;
                        if (z11) {
                            textView.setText(getString(k.J0));
                            z12 = true;
                        } else {
                            textView.setText(getString(k.K0));
                            z12 = false;
                        }
                        textView.setTextColor(requireContext().getColor(sh.d.G));
                        textView.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.contacts.x
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                z.f0(arrayList, this, z12, view);
                            }
                        });
                    }
                    Button button = this.f19577d;
                    if (button != null) {
                        if (!arrayList.isEmpty()) {
                            for (b bVar2 : arrayList) {
                                if (bVar2.c()) {
                                    break;
                                }
                            }
                        }
                        z10 = false;
                        button.setEnabled(z10);
                        return;
                    }
                    kotlin.jvm.internal.i.u("btnAdd");
                    throw null;
                }
                kotlin.jvm.internal.i.u("contactAdapter");
                throw null;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.i.f(view, "view");
        i0();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(h.f34723z0);
        a aVar = new a();
        this.f19576c = aVar;
        recyclerView.setAdapter(aVar);
        l7.a aVar2 = new l7.a(requireContext(), 1);
        aVar2.l((int) DimensionUtils.dp2px(getContext(), 16.0f));
        recyclerView.h(aVar2);
        a aVar3 = this.f19576c;
        if (aVar3 != null) {
            aVar3.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.mobvoi.mcuwatch.ui.contacts.y
                @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i10) {
                    z.g0(z.this, baseQuickAdapter, view2, i10);
                }
            });
            View findViewById = view.findViewById(h.V_res_0x7f0b0121);
            kotlin.jvm.internal.i.e(findViewById, "view.findViewById(R.id.btn_add)");
            Button button = (Button) findViewById;
            this.f19577d = button;
            if (button != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.contacts.w
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        z.h0(z.this, view2);
                    }
                });
            } else {
                kotlin.jvm.internal.i.u("btnAdd");
                throw null;
            }
        } else {
            kotlin.jvm.internal.i.u("contactAdapter");
            throw null;
        }
    }

    @Override // androidx.loader.app.a.AbstractC0034a
    public androidx.loader.content.c<Cursor> r(int i10, Bundle bundle) {
        return new androidx.loader.content.b(requireContext(), ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, "display_name COLLATE LOCALIZED ASC");
    }

    /* compiled from: SyncSystemContactFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f19578a;

        /* renamed from: b  reason: collision with root package name */
        private final String f19579b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f19580c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f19581d;

        public b(String name, String num, boolean z10, boolean z11) {
            kotlin.jvm.internal.i.f(name, "name");
            kotlin.jvm.internal.i.f(num, "num");
            this.f19578a = name;
            this.f19579b = num;
            this.f19580c = z10;
            this.f19581d = z11;
        }

        public final String a() {
            return this.f19578a;
        }

        public final String b() {
            return this.f19579b;
        }

        public final boolean c() {
            return this.f19580c;
        }

        public final boolean d() {
            return this.f19581d;
        }

        public final void e(boolean z10) {
            this.f19580c = z10;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Contact)) {
                return super.equals(obj);
            }
            Contact contact = (Contact) obj;
            return kotlin.jvm.internal.i.b(this.f19578a, contact.getName()) && kotlin.jvm.internal.i.b(this.f19579b, contact.getNum());
        }

        public final void f(boolean z10) {
            this.f19581d = z10;
        }

        public int hashCode() {
            return (((((this.f19578a.hashCode() * 31) + this.f19579b.hashCode()) * 31) + a0.a(this.f19580c)) * 31) + a0.a(this.f19581d);
        }

        public /* synthetic */ b(String str, String str2, boolean z10, boolean z11, int i10, kotlin.jvm.internal.f fVar) {
            this(str, str2, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? false : z11);
        }
    }
}
