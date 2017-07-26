package com.karumi.training.kataloginlogout;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ApiClientUnitTest {
    @Test
    public void shouldLoginBeTrueWhenUserAndPasswordAreRight() throws Exception {
        Clock clock = new Clock();
        ApiClient apiClient = new ApiClient(clock);

        boolean success = apiClient.login(
            "pedro@karumi.com",
            "123456"
        );

        assertTrue(success);
    }

    @Test
    public void shouldLoginBeFalseWhenUserAndPasswordAreBothWrong() throws Exception {
        Clock clock = new Clock();
        ApiClient apiClient = new ApiClient(clock);

        boolean success = apiClient.login(
            "dvelasco@solidgear.es",
            "saturdaynight"
        );

        assertFalse(success);
    }

    @Test
    public void shouldLoginBeFalseWhenUserIsRightAndPasswordIsWrong() throws Exception {
        Clock clock = new Clock();
        ApiClient apiClient = new ApiClient(clock);

        boolean success = apiClient.login(
            "pedro@karumi.com",
            "654321"
        );

        assertFalse(success);
    }

    @Test
    public void shouldLoginBeFalswWhenUserIsWrongAndPasswordIsRight() throws Exception {
        Clock clock = new Clock();
        ApiClient apiClient = new ApiClient(clock);

        boolean success = apiClient.login(
            "dvelasco@solidgear.es",
            "123456"
        );

        assertFalse(success);
    }

    @Test
    public void shouldLogoutBeTrueWhenTimeInSecondsIsEven() {
        Clock clock = new StubClock(2000);
        ApiClient apiClient = new ApiClient(clock);

        boolean success = apiClient.logout();

        assertTrue(success);
    }

    @Test
    public void shouldLogoutBeFalseWhenTimeInSecondsIsOdd() {
        Clock clock = new StubClock(3000);
        ApiClient apiClient = new ApiClient(clock);

        boolean success = apiClient.logout();

        assertFalse(success);
    }

}