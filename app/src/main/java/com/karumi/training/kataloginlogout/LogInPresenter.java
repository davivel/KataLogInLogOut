package com.karumi.training.kataloginlogout;

/**
 * Created by David A. Velasco on 26/7/17.
 */

public class LogInPresenter {


    private ApiClient apiClient;
    private View view;

    public LogInPresenter(ApiClient apiClient, View view) {
        this.apiClient = apiClient;
        this.view = view;
    }

    public void login(String username, String password) {
        if (apiClient.login(username,password)) {
            view.showLogOutScreen();

        } else {
            view.showErrorMessage();
        }
    }

    public interface View {

        void showLogOutScreen();

        void showErrorMessage();

    }
}
