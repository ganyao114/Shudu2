package com.ifanr.android.Api;

import com.ifanr.android.Model.Entity.Account;

/**
 * Created by ganyao on 2016/10/27.
 */

public interface ShuduDaoApi {
    /**
     * saveAccount
     * @param account
     * @return
     */
    public void saveAccount(Account account) throws Exception;
}
