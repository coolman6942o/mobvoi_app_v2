package bh;

import com.mobvoi.android.common.utils.b;
import java.text.Collator;
import java.util.Comparator;
import ug.m;
/* compiled from: LocaleComparator.java */
/* loaded from: classes2.dex */
public class c implements Comparator<m> {
    /* renamed from: a */
    public int compare(m mVar, m mVar2) {
        String str = mVar.f35436c;
        String str2 = mVar2.f35436c;
        Collator collator = Collator.getInstance(b.e().getResources().getConfiguration().locale);
        if (collator.compare(str, str2) < 0) {
            return -1;
        }
        return collator.compare(str, str2) > 0 ? 1 : 0;
    }
}
