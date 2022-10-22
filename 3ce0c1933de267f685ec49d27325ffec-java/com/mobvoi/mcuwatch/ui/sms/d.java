package com.mobvoi.mcuwatch.ui.sms;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f;
import androidx.lifecycle.h0;
import androidx.lifecycle.x;
import com.mobvoi.apollo.client.q;
import com.mobvoi.apollo.protocol.model.Contact;
import com.mobvoi.apollo.protocol.model.Sms;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import kotlin.text.u;
import sh.h;
import sh.k;
/* compiled from: EditSmsFragment.kt */
/* loaded from: classes2.dex */
public final class d extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private TextView f20222a;

    /* renamed from: b  reason: collision with root package name */
    private EditText f20223b;

    /* renamed from: c  reason: collision with root package name */
    private final io.d f20224c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f20225d;

    /* renamed from: e  reason: collision with root package name */
    private final a f20226e = new a();

    /* compiled from: EditSmsFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a implements TextWatcher {
        a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0031, code lost:
            if ((r5.length() > 0) != false) goto L16;
         */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void afterTextChanged(Editable editable) {
            CharSequence E0;
            EditText editText = d.this.f20223b;
            if (editText != null) {
                boolean z10 = true;
                if (editText.length() > 0) {
                    EditText editText2 = d.this.f20223b;
                    if (editText2 != null) {
                        Editable text = editText2.getText();
                        i.e(text, "etContent.text");
                        E0 = u.E0(text);
                    } else {
                        i.u("etContent");
                        throw null;
                    }
                }
                z10 = false;
                if (d.this.f20225d != z10) {
                    d.this.f20225d = z10;
                    f activity = d.this.getActivity();
                    if (activity != null) {
                        activity.invalidateOptionsMenu();
                        return;
                    }
                    return;
                }
                return;
            }
            i.u("etContent");
            throw null;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* compiled from: EditSmsFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements qo.a<m> {
        b() {
            super(0);
        }

        /* renamed from: a */
        public final m invoke() {
            f requireActivity = d.this.requireActivity();
            i.e(requireActivity, "requireActivity()");
            return (m) new h0(requireActivity).a(m.class);
        }
    }

    public d() {
        super(sh.i.f34734d0);
        io.d a10;
        a10 = io.f.a(new b());
        this.f20224c = a10;
    }

    private final m e0() {
        return (m) this.f20224c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(d this$0, View view) {
        i.f(this$0, "this$0");
        if (!q.f15504a.B()) {
            Toast.makeText(this$0.getContext(), k.V, 0).show();
            return;
        }
        this$0.i0();
        f activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(d this$0, View view) {
        i.f(this$0, "this$0");
        this$0.j0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(d this$0, Contact contact) {
        i.f(this$0, "this$0");
        if (contact == null) {
            TextView textView = this$0.f20222a;
            if (textView != null) {
                textView.setVisibility(4);
            } else {
                i.u("tvName");
                throw null;
            }
        } else {
            TextView textView2 = this$0.f20222a;
            if (textView2 != null) {
                textView2.setVisibility(0);
                TextView textView3 = this$0.f20222a;
                if (textView3 != null) {
                    textView3.setText(contact.getName());
                } else {
                    i.u("tvName");
                    throw null;
                }
            } else {
                i.u("tvName");
                throw null;
            }
        }
        f activity = this$0.getActivity();
        if (activity != null) {
            activity.invalidateOptionsMenu();
        }
    }

    private final void i0() {
        Contact f10 = e0().k().f();
        i.d(f10);
        i.e(f10, "viewModel.selectContact.value!!");
        Contact contact = f10;
        String name = contact.getName();
        String num = contact.getNum();
        EditText editText = this.f20223b;
        if (editText != null) {
            q.f15504a.Q(new Sms(name, num, editText.getText().toString()));
            return;
        }
        i.u("etContent");
        throw null;
    }

    private final void j0() {
        getParentFragmentManager().l().s(h.A0, new g()).h(null).j();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPrepareOptionsMenu(Menu menu) {
        boolean z10;
        View actionView;
        i.f(menu, "menu");
        MenuItem findItem = menu.findItem(h.f34615b);
        if (findItem != null) {
            TextView textView = null;
            if (this.f20225d) {
                TextView textView2 = this.f20222a;
                if (textView2 == null) {
                    i.u("tvName");
                    throw null;
                } else if (textView2.getVisibility() == 0) {
                    z10 = true;
                    findItem.setVisible(z10);
                    actionView = findItem.getActionView();
                    if (actionView instanceof TextView) {
                        textView = (TextView) actionView;
                    }
                    if (textView == null) {
                        textView.setText(getString(k.J1));
                        textView.setTextColor(requireContext().getColor(sh.d.G));
                        textView.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.sms.b
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                d.f0(d.this, view);
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            z10 = false;
            findItem.setVisible(z10);
            actionView = findItem.getActionView();
            if (actionView instanceof TextView) {
            }
            if (textView == null) {
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        requireActivity().setTitle(getString(k.K1));
        View findViewById = view.findViewById(h.O3);
        i.e(findViewById, "view.findViewById(R.id.tv_name)");
        this.f20222a = (TextView) findViewById;
        View findViewById2 = view.findViewById(h.B0);
        i.e(findViewById2, "view.findViewById(R.id.content)");
        EditText editText = (EditText) findViewById2;
        this.f20223b = editText;
        if (editText != null) {
            editText.addTextChangedListener(this.f20226e);
            ((ImageButton) view.findViewById(h.e_res_0x7f0b0082)).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.sms.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    d.g0(d.this, view2);
                }
            });
            e0().k().i(getViewLifecycleOwner(), new x() { // from class: com.mobvoi.mcuwatch.ui.sms.c
                @Override // androidx.lifecycle.x
                public final void a(Object obj) {
                    d.h0(d.this, (Contact) obj);
                }
            });
            return;
        }
        i.u("etContent");
        throw null;
    }
}
