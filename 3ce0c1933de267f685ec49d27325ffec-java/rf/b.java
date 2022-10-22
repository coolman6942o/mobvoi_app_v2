package rf;

import com.mobvoi.health.common.data.db.DataPoint;
import com.mobvoi.health.common.data.pojo.DataType;
import i1.e;
import java.util.List;
import qf.a;
/* compiled from: DataPointDao.java */
/* loaded from: classes2.dex */
public interface b {
    int a(e eVar);

    Long b(a aVar);

    List<a> c(String str, String str2, DataType dataType, long j10, long j11, String str3);

    int d(a aVar);

    List<a> e(String str, String str2, DataType dataType);

    int f(String str, String str2, int i10, long j10, long j11);

    List<a> g(String str, String str2, DataType dataType, long j10, long j11);

    List<a> h(e eVar);

    List<a> i(i1.a aVar);

    int j(a aVar);

    List<a> k(String str, String str2, DataType dataType, long j10);

    a l(String str, String str2, int i10);

    int m(a aVar);

    List<a> n(String str, String str2, DataType dataType, long j10, long j11);

    List<Long> o(DataPoint... dataPointArr);

    int p(String str, String str2, int i10, long j10);

    int q(String str, String str2, int i10, long j10, long j11);

    int r(e eVar);

    int s(String str, DataType dataType, long j10, long j11);
}
