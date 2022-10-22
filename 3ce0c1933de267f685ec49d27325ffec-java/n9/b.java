package n9;

import com.liulishuo.filedownloader.message.MessageSnapshot;
/* compiled from: MessageSnapshotFlow.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private volatile c f31065a;

    /* renamed from: b  reason: collision with root package name */
    private volatile AbstractC0410b f31066b;

    /* compiled from: MessageSnapshotFlow.java */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f31067a = new b();
    }

    /* compiled from: MessageSnapshotFlow.java */
    /* renamed from: n9.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0410b {
        void c(MessageSnapshot messageSnapshot);
    }

    public static b a() {
        return a.f31067a;
    }

    public void b(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof n9.a) {
            if (this.f31066b != null) {
                this.f31066b.c(messageSnapshot);
            }
        } else if (this.f31065a != null) {
            this.f31065a.b(messageSnapshot);
        }
    }

    public void c(AbstractC0410b bVar) {
        this.f31066b = bVar;
        if (bVar == null) {
            this.f31065a = null;
        } else {
            this.f31065a = new c(5, bVar);
        }
    }
}
