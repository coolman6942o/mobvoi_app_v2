package com.paypal.android.sdk;

import java.util.Comparator;
import java.util.Currency;
/* loaded from: classes2.dex */
final class w2 implements Comparator {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((Currency) obj).getCurrencyCode().compareTo(((Currency) obj2).getCurrencyCode());
    }
}
