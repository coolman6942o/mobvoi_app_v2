package com.huawei.agconnect.core.service.auth;

import com.huawei.hmf.tasks.Task;
/* loaded from: classes.dex */
public interface CredentialsProvider {
    Task<Token> getTokens();
}
