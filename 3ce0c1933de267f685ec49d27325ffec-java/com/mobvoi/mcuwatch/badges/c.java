package com.mobvoi.mcuwatch.badges;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.u;
import sh.h;
import sh.k;
import xh.d;
/* compiled from: BadgeEarnedFragment.kt */
/* loaded from: classes2.dex */
public final class c extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public static final a f19127a = new a(null);

    /* compiled from: BadgeEarnedFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final c a(String category, String name, String id2) {
            i.f(category, "category");
            i.f(name, "name");
            i.f(id2, "id");
            c cVar = new c();
            Bundle bundle = new Bundle();
            bundle.putString("badge_category", category);
            bundle.putString("badge_name", name);
            bundle.putString("badge_id", id2);
            cVar.setArguments(bundle);
            return cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(c this$0, View view) {
        i.f(this$0, "this$0");
        androidx.fragment.app.f activity = this$0.getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.mobvoi.mcuwatch.badges.BadgesActivity");
        ((BadgesActivity) activity).O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(c this$0, View view) {
        i.f(this$0, "this$0");
        androidx.fragment.app.f activity = this$0.getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.mobvoi.mcuwatch.badges.BadgesActivity");
        ((BadgesActivity) activity).W();
    }

    private final void c0(ImageView imageView, List<String> list) {
        if (imageView != null) {
            Context requireContext = requireContext();
            i.e(requireContext, "requireContext()");
            imageView.setImageDrawable(new d(requireContext, list.get(0), true));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        return LayoutInflater.from(getContext()).inflate(sh.i.f34732c0, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        List<String> o02;
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        String string = requireArguments().getString("badge_id");
        if (string != null) {
            ad.a.f168a.n(string);
        }
        String string2 = requireArguments().getString("badge_category");
        String string3 = requireArguments().getString("badge_name");
        ImageView imageView = (ImageView) view.findViewById(h.f34700u1);
        TextView textView = (TextView) view.findViewById(h.f34726z3);
        Button button = (Button) view.findViewById(h.f34610a0);
        ((Toolbar) view.findViewById(h.I0)).setNavigationOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.badges.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c.a0(c.this, view2);
            }
        });
        if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string2)) {
            i.d(string3);
            o02 = u.o0(string3, new String[]{" "}, false, 0, 6, null);
            if (!o02.isEmpty()) {
                i.d(string2);
                Locale locale = Locale.getDefault();
                i.e(locale, "getDefault()");
                Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = string2.toLowerCase(locale);
                i.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (i.b(lowerCase, "reading streaks")) {
                    c0(imageView, o02);
                } else if (!i.b(lowerCase, "arty score")) {
                    c0(imageView, o02);
                } else if (imageView != null) {
                    Context requireContext = requireContext();
                    i.e(requireContext, "requireContext()");
                    imageView.setImageDrawable(new xh.a(requireContext, o02.get(0), true));
                }
            }
            if (textView != null) {
                int i10 = k.O;
                Locale locale2 = Locale.getDefault();
                i.e(locale2, "getDefault()");
                String upperCase = string3.toUpperCase(locale2);
                i.e(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                i.d(string2);
                Locale locale3 = Locale.getDefault();
                i.e(locale3, "getDefault()");
                Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
                String upperCase2 = string2.toUpperCase(locale3);
                i.e(upperCase2, "(this as java.lang.String).toUpperCase(locale)");
                textView.setText(getString(i10, upperCase, upperCase2));
            }
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.badges.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c.b0(c.this, view2);
            }
        });
    }
}
