package com.karumi.training.kataloginlogout;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by David A. Velasco on 26/7/17.
 */
public class LogInPresenterTest {

    private StubClock mockClock = new StubClock(2000);
    private MockApiClient apiClient = new MockApiClient();
    private MockLogInView mockView = new MockLogInView();

    @Test
    public void shouldShowErrorIfThereIsSomethingWrongWhileLogIn() {
        apiClient.setFailOnLogIn(true);
        LogInPresenter presenter = new LogInPresenter(apiClient, mockView);

        presenter.login("pedro@karumi.com", "123");

        assertTrue(mockView.getSomeoneInvokedShowErrorMessage());
    }


    class MockApiClient extends ApiClient {

        private boolean failOnLogIn = false;

        MockApiClient() {
            super(mockClock);
        }

        public void setFailOnLogIn(boolean failOnLogIn) {
            this.failOnLogIn = failOnLogIn;
        }

        @Override
        public boolean login(String username, String password) {
            if (failOnLogIn) {
                return false;
            } else {
                return true;
            }
        }
    }

    class MockLogInView implements LogInPresenter.View {

        private boolean someoneInvokedShowErrorMessage = false;

        public void showErrorMessage() {
            someoneInvokedShowErrorMessage = true;
        }

        public boolean getSomeoneInvokedShowErrorMessage() {
            return someoneInvokedShowErrorMessage;
        }

        @Override
        public void showLogOutScreen() {

        }
    }
}