package com.mobvoi.apollo.client.fitness;

import com.mobvoi.apollo.protocol.model.DataSession;
import com.mobvoi.apollo.protocol.model.DataSet;
import com.mobvoi.apollo.protocol.model.FitnessRecord;
import java.util.List;
/* compiled from: FitnessCallback.kt */
/* loaded from: classes2.dex */
public interface b {
    void a(FitnessRecord fitnessRecord);

    boolean b();

    void c(List<DataSession> list);

    void d(List<DataSet> list);
}
