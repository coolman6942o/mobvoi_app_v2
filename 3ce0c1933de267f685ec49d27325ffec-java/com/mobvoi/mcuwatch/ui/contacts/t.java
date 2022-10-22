package com.mobvoi.mcuwatch.ui.contacts;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f;
import androidx.lifecycle.h0;
import androidx.lifecycle.x;
import com.mobvoi.apollo.client.q;
import com.mobvoi.apollo.protocol.model.Contact;
import io.d;
import io.m;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import kotlin.text.u;
import qo.l;
import sh.h;
import sh.k;
/* compiled from: EditContactFragment.kt */
/* loaded from: classes2.dex */
public final class t extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private Toolbar f19560a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f19561b;

    /* renamed from: c  reason: collision with root package name */
    private EditText f19562c;

    /* renamed from: d  reason: collision with root package name */
    private EditText f19563d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f19564e;

    /* renamed from: f  reason: collision with root package name */
    private final d f19565f;

    /* renamed from: g  reason: collision with root package name */
    private final a f19566g = new a();

    /* compiled from: EditContactFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a implements TextWatcher {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void afterTextChanged(Editable editable) {
            boolean z10;
            Contact f10 = t.this.h0().l().f();
            i.d(f10);
            i.e(f10, "viewModel.currentContact.value!!");
            Contact contact = f10;
            String name = contact.getName();
            EditText editText = t.this.f19562c;
            if (editText != null) {
                if (i.b(name, editText.getText().toString())) {
                    String num = contact.getNum();
                    EditText editText2 = t.this.f19563d;
                    if (editText2 == null) {
                        i.u("etPhone");
                        throw null;
                    } else if (i.b(num, v.a(editText2.getText().toString()))) {
                        z10 = false;
                        if (t.this.f19564e == z10) {
                            t.this.f19564e = z10;
                            f activity = t.this.getActivity();
                            if (activity != null) {
                                activity.invalidateOptionsMenu();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                z10 = true;
                if (t.this.f19564e == z10) {
                }
            } else {
                i.u("etName");
                throw null;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditContactFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends Lambda implements l<Integer, m> {
        b() {
            super(1);
        }

        public final void a(int i10) {
            if (i10 != 0) {
                Toast.makeText(t.this.getContext(), i10 != 1 ? i10 != 2 ? "更新联系人失败" : "已存在该手机号联系人" : "已存在同名联系人", 0).show();
            } else {
                t.this.getParentFragmentManager().W0();
            }
        }

        @Override // qo.l
        public /* bridge */ /* synthetic */ m invoke(Integer num) {
            a(num.intValue());
            return m.f28349a;
        }
    }

    /* compiled from: EditContactFragment.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements qo.a<o> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final o invoke() {
            f requireActivity = t.this.requireActivity();
            i.e(requireActivity, "requireActivity()");
            return (o) new h0(requireActivity).a(o.class);
        }
    }

    public t() {
        super(sh.i.Z);
        d a10;
        a10 = io.f.a(new c());
        this.f19565f = a10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final o h0() {
        return (o) this.f19565f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(t this$0, View view) {
        i.f(this$0, "this$0");
        this$0.m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(t this$0, Contact contact) {
        i.f(this$0, "this$0");
        EditText editText = this$0.f19562c;
        if (editText != null) {
            editText.setText(contact.getName());
            EditText editText2 = this$0.f19563d;
            if (editText2 != null) {
                editText2.setText(v.b(contact.getNum()));
            } else {
                i.u("etPhone");
                throw null;
            }
        } else {
            i.u("etName");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(t this$0, View view) {
        i.f(this$0, "this$0");
        this$0.l0();
    }

    private final void l0() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("vnd.android.cursor.dir/phone_v2");
        if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
            startActivityForResult(intent, 1);
        }
    }

    private final void m0() {
        CharSequence E0;
        CharSequence E02;
        if (!q.f15504a.B()) {
            Toast.makeText(getContext(), k.V, 0).show();
            return;
        }
        EditText editText = this.f19562c;
        if (editText != null) {
            String obj = editText.getText().toString();
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.CharSequence");
            E0 = u.E0(obj);
            String obj2 = E0.toString();
            EditText editText2 = this.f19563d;
            if (editText2 != null) {
                String obj3 = editText2.getText().toString();
                Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.CharSequence");
                E02 = u.E0(obj3);
                String a10 = v.a(E02.toString());
                boolean z10 = true;
                if (obj2.length() == 0) {
                    Toast.makeText(getContext(), k.F0, 0).show();
                    return;
                }
                if (a10.length() != 0) {
                    z10 = false;
                }
                if (z10) {
                    Toast.makeText(getContext(), k.G0, 0).show();
                } else {
                    h0().n(obj2, a10, new b());
                }
            } else {
                i.u("etPhone");
                throw null;
            }
        } else {
            i.u("etName");
            throw null;
        }
    }

    private final void n0() {
        requireActivity().setTitle(getString(k.E0));
        h0().m().o(3);
        this.f19560a = (Toolbar) requireActivity().findViewById(h.f34675o3);
        View inflate = getLayoutInflater().inflate(sh.i.T0, (ViewGroup) this.f19560a, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) inflate;
        this.f19561b = textView;
        textView.setText(k.f34848p0);
        textView.setTextColor(textView.getContext().getColor(sh.d.G));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.contacts.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.o0(t.this, view);
            }
        });
        Toolbar toolbar = this.f19560a;
        if (toolbar != null) {
            toolbar.addView(textView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(t this$0, View view) {
        i.f(this$0, "this$0");
        this$0.getParentFragmentManager().W0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Throwable] */
    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (i10 == 1 && i11 == -1) {
            th = 0;
            Uri data = intent == null ? th : intent.getData();
            i.d(data);
            i.e(data, "data?.data!!");
            Cursor query = requireContext().getContentResolver().query(data, new String[]{"data1", "display_name"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndex("data1"));
                        String string2 = query.getString(query.getColumnIndex("display_name"));
                        EditText editText = this.f19562c;
                        if (editText != null) {
                            editText.setText(string2);
                            EditText editText2 = this.f19563d;
                            if (editText2 != null) {
                                editText2.setText(string);
                            } else {
                                i.u("etPhone");
                                throw th;
                            }
                        } else {
                            i.u("etName");
                            throw th;
                        }
                    }
                    m mVar = m.f28349a;
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } finally {
                        oo.b.a(query, th2);
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Toolbar toolbar = this.f19560a;
        if (toolbar != null) {
            toolbar.removeView(this.f19561b);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        i.f(menu, "menu");
        MenuItem findItem = menu.findItem(h.f34615b);
        if (findItem != null) {
            View actionView = findItem.getActionView();
            TextView textView = actionView instanceof TextView ? (TextView) actionView : null;
            if (textView != null) {
                textView.setText(getString(k.I0));
                if (this.f19564e) {
                    textView.setTextColor(requireContext().getColor(sh.d.G));
                } else {
                    textView.setTextColor(requireContext().getColor(sh.d.H));
                }
                textView.setEnabled(this.f19564e);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.contacts.q
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        t.i0(t.this, view);
                    }
                });
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        n0();
        View findViewById = view.findViewById(h.T0);
        i.e(findViewById, "view.findViewById(R.id.et_name)");
        this.f19562c = (EditText) findViewById;
        View findViewById2 = view.findViewById(h.U0);
        i.e(findViewById2, "view.findViewById(R.id.et_phone)");
        this.f19563d = (EditText) findViewById2;
        EditText editText = this.f19562c;
        if (editText != null) {
            editText.addTextChangedListener(this.f19566g);
            EditText editText2 = this.f19563d;
            if (editText2 != null) {
                editText2.addTextChangedListener(this.f19566g);
                EditText editText3 = this.f19563d;
                if (editText3 == null) {
                    i.u("etPhone");
                    throw null;
                } else if (editText3 != null) {
                    editText3.addTextChangedListener(new u(editText3));
                    h0().l().i(getViewLifecycleOwner(), new x() { // from class: com.mobvoi.mcuwatch.ui.contacts.s
                        @Override // androidx.lifecycle.x
                        public final void a(Object obj) {
                            t.j0(t.this, (Contact) obj);
                        }
                    });
                    ((TextView) view.findViewById(h.f34631e3)).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.contacts.p
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            t.k0(t.this, view2);
                        }
                    });
                } else {
                    i.u("etPhone");
                    throw null;
                }
            } else {
                i.u("etPhone");
                throw null;
            }
        } else {
            i.u("etName");
            throw null;
        }
    }
}
