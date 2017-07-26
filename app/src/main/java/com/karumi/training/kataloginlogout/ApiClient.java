package com.karumi.training.kataloginlogout;

/**
 * Created by David A. Velasco on 26/7/17.
 */

public class ApiClient {

    private final Clock clock;

    public ApiClient(Clock clock) {
        this.clock = clock;
    }

    public boolean login(String username, String password) {
        return (
            "pedro@karumi.com".equals(username) &&
            "123456".equals(password)
        );
    }

    public boolean logout() {
        return ((clock.getCurrentTime() / 1000)%2 == 0);
    }
}
