package y1;

import android.net.Uri;
import android.os.Build;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
/* compiled from: WorkTypeConverters.java */
/* loaded from: classes.dex */
public class v {

    /* compiled from: WorkTypeConverters.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f36728a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f36729b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f36730c;

        /* renamed from: d  reason: collision with root package name */
        static final /* synthetic */ int[] f36731d;

        static {
            int[] iArr = new int[OutOfQuotaPolicy.values().length];
            f36731d = iArr;
            try {
                iArr[OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36731d[OutOfQuotaPolicy.DROP_WORK_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[NetworkType.values().length];
            f36730c = iArr2;
            try {
                iArr2[NetworkType.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36730c[NetworkType.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f36730c[NetworkType.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f36730c[NetworkType.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f36730c[NetworkType.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[BackoffPolicy.values().length];
            f36729b = iArr3;
            try {
                iArr3[BackoffPolicy.EXPONENTIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f36729b[BackoffPolicy.LINEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr4 = new int[WorkInfo.State.values().length];
            f36728a = iArr4;
            try {
                iArr4[WorkInfo.State.ENQUEUED.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f36728a[WorkInfo.State.RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f36728a[WorkInfo.State.SUCCEEDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f36728a[WorkInfo.State.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f36728a[WorkInfo.State.BLOCKED.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f36728a[WorkInfo.State.CANCELLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public static int a(BackoffPolicy backoffPolicy) {
        int i10 = a.f36729b[backoffPolicy.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        throw new IllegalArgumentException("Could not convert " + backoffPolicy + " to int");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0053 -> B:28:0x0056). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c b(byte[] bArr) {
        Throwable th2;
        ObjectInputStream objectInputStream;
        IOException e10;
        c cVar = new c();
        if (bArr == null) {
            return cVar;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    try {
                        for (int readInt = objectInputStream.readInt(); readInt > 0; readInt--) {
                            cVar.a(Uri.parse(objectInputStream.readUTF()), objectInputStream.readBoolean());
                        }
                        try {
                            objectInputStream.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                        byteArrayInputStream.close();
                    } catch (IOException e12) {
                        e10 = e12;
                        e10.printStackTrace();
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e13) {
                                e13.printStackTrace();
                            }
                        }
                        byteArrayInputStream.close();
                        return cVar;
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e14) {
                            e14.printStackTrace();
                        }
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e15) {
                        e15.printStackTrace();
                    }
                    throw th2;
                }
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        } catch (IOException e17) {
            e10 = e17;
            objectInputStream = null;
        } catch (Throwable th4) {
            th2 = th4;
            objectInputStream = null;
            if (objectInputStream != null) {
            }
            byteArrayInputStream.close();
            throw th2;
        }
        return cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0067 -> B:29:0x006a). Please submit an issue!!! */
    public static byte[] c(c cVar) {
        IOException e10;
        ObjectOutputStream objectOutputStream;
        boolean hasNext;
        ObjectOutputStream objectOutputStream2 = null;
        ObjectOutputStream objectOutputStream3 = null;
        objectOutputStream2 = null;
        if (cVar.c() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e11) {
                e10 = e11;
            }
        } catch (IOException e12) {
            e12.printStackTrace();
            objectOutputStream2 = objectOutputStream2;
        }
        try {
            objectOutputStream.writeInt(cVar.c());
            Iterator<c.a> it = cVar.b().iterator();
            while (true) {
                hasNext = it.hasNext();
                if (hasNext != 0) {
                    c.a next = it.next();
                    objectOutputStream.writeUTF(next.a().toString());
                    objectOutputStream.writeBoolean(next.b());
                } else {
                    try {
                        break;
                    } catch (IOException e13) {
                        e13.printStackTrace();
                    }
                }
            }
            objectOutputStream.close();
            byteArrayOutputStream.close();
            objectOutputStream2 = hasNext;
        } catch (IOException e14) {
            e10 = e14;
            objectOutputStream3 = objectOutputStream;
            e10.printStackTrace();
            if (objectOutputStream3 != null) {
                try {
                    objectOutputStream3.close();
                } catch (IOException e15) {
                    e15.printStackTrace();
                }
            }
            byteArrayOutputStream.close();
            objectOutputStream2 = objectOutputStream3;
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th3) {
            th = th3;
            objectOutputStream2 = objectOutputStream;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e17) {
                e17.printStackTrace();
            }
            throw th;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static BackoffPolicy d(int i10) {
        if (i10 == 0) {
            return BackoffPolicy.EXPONENTIAL;
        }
        if (i10 == 1) {
            return BackoffPolicy.LINEAR;
        }
        throw new IllegalArgumentException("Could not convert " + i10 + " to BackoffPolicy");
    }

    public static NetworkType e(int i10) {
        if (i10 == 0) {
            return NetworkType.NOT_REQUIRED;
        }
        if (i10 == 1) {
            return NetworkType.CONNECTED;
        }
        if (i10 == 2) {
            return NetworkType.UNMETERED;
        }
        if (i10 == 3) {
            return NetworkType.NOT_ROAMING;
        }
        if (i10 == 4) {
            return NetworkType.METERED;
        }
        if (Build.VERSION.SDK_INT >= 30 && i10 == 5) {
            return NetworkType.TEMPORARILY_UNMETERED;
        }
        throw new IllegalArgumentException("Could not convert " + i10 + " to NetworkType");
    }

    public static OutOfQuotaPolicy f(int i10) {
        if (i10 == 0) {
            return OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        }
        if (i10 == 1) {
            return OutOfQuotaPolicy.DROP_WORK_REQUEST;
        }
        throw new IllegalArgumentException("Could not convert " + i10 + " to OutOfQuotaPolicy");
    }

    public static WorkInfo.State g(int i10) {
        if (i10 == 0) {
            return WorkInfo.State.ENQUEUED;
        }
        if (i10 == 1) {
            return WorkInfo.State.RUNNING;
        }
        if (i10 == 2) {
            return WorkInfo.State.SUCCEEDED;
        }
        if (i10 == 3) {
            return WorkInfo.State.FAILED;
        }
        if (i10 == 4) {
            return WorkInfo.State.BLOCKED;
        }
        if (i10 == 5) {
            return WorkInfo.State.CANCELLED;
        }
        throw new IllegalArgumentException("Could not convert " + i10 + " to State");
    }

    public static int h(NetworkType networkType) {
        int i10 = a.f36730c[networkType.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 2;
        }
        if (i10 == 4) {
            return 3;
        }
        if (i10 == 5) {
            return 4;
        }
        if (Build.VERSION.SDK_INT >= 30 && networkType == NetworkType.TEMPORARILY_UNMETERED) {
            return 5;
        }
        throw new IllegalArgumentException("Could not convert " + networkType + " to int");
    }

    public static int i(OutOfQuotaPolicy outOfQuotaPolicy) {
        int i10 = a.f36731d[outOfQuotaPolicy.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        throw new IllegalArgumentException("Could not convert " + outOfQuotaPolicy + " to int");
    }

    public static int j(WorkInfo.State state) {
        switch (a.f36728a[state.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                throw new IllegalArgumentException("Could not convert " + state + " to int");
        }
    }
}
