package com.ifanr.android.Api;

import com.ifanr.android.Model.Entity.Account;

import io.realm.Realm;

/**
 * Created by ganyao on 2016/10/27.
 */

public class ShuduDaoRealmImpl implements ShuduDaoApi{

    private Realm realm;

    public ShuduDaoRealmImpl(Realm realm) {
        this.realm = realm;
    }

    @Override
    public void saveAccount(Account account) throws Exception {
        realm.beginTransaction();
        Account account1 = realm.copyToRealm(account);
        realm.commitTransaction();
        realm.close();
    }

}
