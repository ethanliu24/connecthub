package use_case.login;

/**
 * The output boundary for the Login Use Case.
 */
public interface LoginOutputBoundary {

    /**
     * Prepares the success view for the Login Use Case
     * @param loginOutputData the output data
     */
    void prepareSuccessView(LoginOutputData loginOutputData);

    /**
     * Prepares the failure view for the Login Use Case
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

    /**
     * Switch to the Home Page view
     */
    void switchToHomePage();

    /**
     * Switch to the SignUp view
     */
    void switchToSignupView();
}

