package kotlinx.coroutines.channels;

import kotlinx.coroutines.internal.x;
/* compiled from: Channel.kt */
/* loaded from: classes3.dex */
public interface e<E> extends p<E>, l<E> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f30151a = a.f30152a;

    /* compiled from: Channel.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f30152a = new a();

        /* renamed from: b  reason: collision with root package name */
        private static final int f30153b = x.b("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);

        private a() {
        }

        public final int a() {
            return f30153b;
        }
    }
}
