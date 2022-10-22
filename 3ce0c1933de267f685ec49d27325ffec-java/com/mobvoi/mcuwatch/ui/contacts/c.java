package com.mobvoi.mcuwatch.ui.contacts;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f;
import androidx.lifecycle.h0;
import com.mobvoi.apollo.client.q;
import io.d;
import io.m;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import qo.l;
import sh.h;
import sh.k;
/* compiled from: AddContactFragment.kt */
/* loaded from: classes2.dex */
public final class c extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private EditText f19528a;

    /* renamed from: b  reason: collision with root package name */
    private EditText f19529b;

    /* renamed from: c  reason: collision with root package name */
    private final d f19530c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AddContactFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements l<Integer, m> {
        a() {
            super(1);
        }

        public final void a(int i10) {
            if (i10 != 0) {
                Toast.makeText(c.this.getContext(), i10 != 1 ? i10 != 2 ? "添加联系人失败" : "已存在该手机号联系人" : "已存在同名联系人", 0).show();
            } else {
                c.this.getParentFragmentManager().W0();
            }
        }

        @Override // qo.l
        public /* bridge */ /* synthetic */ m invoke(Integer num) {
            a(num.intValue());
            return m.f28349a;
        }
    }

    /* compiled from: AddContactFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements qo.a<o> {
        b() {
            super(0);
        }

        /* renamed from: a */
        public final o invoke() {
            f requireActivity = c.this.requireActivity();
            i.e(requireActivity, "requireActivity()");
            return (o) new h0(requireActivity).a(o.class);
        }
    }

    public c() {
        super(sh.i.X);
        d a10;
        a10 = io.f.a(new b());
        this.f19530c = a10;
    }

    private final void a0() {
        EditText editText = this.f19528a;
        if (editText != null) {
            String obj = editText.getText().toString();
            EditText editText2 = this.f19529b;
            if (editText2 != null) {
                String a10 = v.a(editText2.getText().toString());
                boolean z10 = true;
                if (!(obj.length() == 0)) {
                    if (a10.length() != 0) {
                        z10 = false;
                    }
                    if (!z10) {
                        b0().c(obj, a10, new a());
                        return;
                    }
                }
                Toast.makeText(getContext(), "请输入姓名或手机号", 0).show();
                return;
            }
            i.u("etPhone");
            throw null;
        }
        i.u("etName");
        throw null;
    }

    private final o b0() {
        return (o) this.f19530c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(c this$0, View view) {
        i.f(this$0, "this$0");
        if (!q.f15504a.B()) {
            Toast.makeText(this$0.getContext(), k.V, 0).show();
        } else {
            this$0.a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(c this$0, View view) {
        i.f(this$0, "this$0");
        this$0.e0();
    }

    private final void e0() {
        getParentFragmentManager().l().s(h.A0, new z()).h(null).j();
    }

    private final void f0() {
        requireActivity().setTitle(getString(k.C0));
        b0().m().o(0);
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
                        EditText editText = this.f19528a;
                        if (editText != null) {
                            editText.setText(string2);
                            EditText editText2 = this.f19529b;
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
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        f0();
        View findViewById = view.findViewById(h.T0);
        i.e(findViewById, "view.findViewById(R.id.et_name)");
        this.f19528a = (EditText) findViewById;
        View findViewById2 = view.findViewById(h.U0);
        i.e(findViewById2, "view.findViewById(R.id.et_phone)");
        EditText editText = (EditText) findViewById2;
        this.f19529b = editText;
        if (editText == null) {
            i.u("etPhone");
            throw null;
        } else if (editText != null) {
            editText.addTextChangedListener(new u(editText));
            ((Button) view.findViewById(h.X_res_0x7f0b0129)).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.contacts.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.c0(c.this, view2);
                }
            });
            ((TextView) view.findViewById(h.f34631e3)).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.contacts.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.d0(c.this, view2);
                }
            });
        } else {
            i.u("etPhone");
            throw null;
        }
    }
}
