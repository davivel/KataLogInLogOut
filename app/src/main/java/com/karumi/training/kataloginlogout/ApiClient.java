package com.karumi.training.kataloginlogout;

import static java.lang.System.currentTimeMillis;

/**
 * Created by David A. Velasco on 26/7/17.
 */

public class ApiClient {

    public boolean login(String username, String password) {
        return (
            "pedro@karumi.com".equals(username) &&
            "123456".equals(password)
        );
    }

    public boolean logout() {
        return ((currentTimeMillis() / 1000)%2 == 0);
    }
}
