package com.mobvoi.mcuwatch.badges.adapter;

import android.graphics.drawable.StateListDrawable;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.internal.i;
import kotlin.text.u;
import sh.h;
import wh.a;
import xh.b;
/* compiled from: BadgeAdapter.kt */
/* loaded from: classes2.dex */
public final class BadgeAdapter extends BaseMultiItemQuickAdapter<a, BaseViewHolder> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BadgeAdapter(List<a> badgeList) {
        super(badgeList);
        i.f(badgeList, "badgeList");
        addItemType(0, sh.i.f34751r0);
        addItemType(1, sh.i.f34749q0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void convert(BaseViewHolder helper, a item) {
        List o02;
        StateListDrawable stateListDrawable;
        i.f(helper, "helper");
        i.f(item, "item");
        int itemType = item.getItemType();
        if (itemType == 0) {
            int i10 = h.K3;
            String a10 = item.a();
            Locale locale = Locale.getDefault();
            i.e(locale, "getDefault()");
            Objects.requireNonNull(a10, "null cannot be cast to non-null type java.lang.String");
            String upperCase = a10.toUpperCase(locale);
            i.e(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            helper.setText(i10, upperCase);
        } else if (itemType == 1) {
            int i11 = h.f34700u1;
            ImageView imageView = (ImageView) helper.getView(i11);
            o02 = u.o0(item.b(), new String[]{" "}, false, 0, 6, null);
            if (true ^ o02.isEmpty()) {
                String a11 = item.a();
                Locale locale2 = Locale.getDefault();
                i.e(locale2, "getDefault()");
                Objects.requireNonNull(a11, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = a11.toLowerCase(locale2);
                i.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (i.b(lowerCase, "reading streaks")) {
                    stateListDrawable = b.f36555a.b((String) o02.get(0));
                } else if (i.b(lowerCase, "arty score")) {
                    stateListDrawable = b.f36555a.a((String) o02.get(0));
                } else {
                    stateListDrawable = b.f36555a.b((String) o02.get(0));
                }
                imageView.setSelected(item.c());
                helper.setImageDrawable(i11, stateListDrawable);
            }
        }
    }
}
