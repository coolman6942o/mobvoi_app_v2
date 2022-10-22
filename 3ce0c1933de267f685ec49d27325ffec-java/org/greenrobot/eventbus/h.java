package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;
/* compiled from: PendingPost.java */
/* loaded from: classes3.dex */
final class h {

    /* renamed from: d  reason: collision with root package name */
    private static final List<h> f32485d = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    Object f32486a;

    /* renamed from: b  reason: collision with root package name */
    n f32487b;

    /* renamed from: c  reason: collision with root package name */
    h f32488c;

    private h(Object obj, n nVar) {
        this.f32486a = obj;
        this.f32487b = nVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h a(n nVar, Object obj) {
        List<h> list = f32485d;
        synchronized (list) {
            int size = list.size();
            if (size <= 0) {
                return new h(obj, nVar);
            }
            h remove = list.remove(size - 1);
            remove.f32486a = obj;
            remove.f32487b = nVar;
            remove.f32488c = null;
            return remove;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(h hVar) {
        hVar.f32486a = null;
        hVar.f32487b = null;
        hVar.f32488c = null;
        List<h> list = f32485d;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(hVar);
            }
        }
    }
}
