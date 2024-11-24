package controller.post;

import controller.ViewManagerModel;
import use_case.getpost.GetPostOutputBoundary;
import use_case.getpost.GetPostOutputData;

public class PostPresenter implements GetPostOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final PostViewModel postViewModel;

    // TODO will need a home page view model
    public PostPresenter(ViewManagerModel viewManagerModel,
                         PostViewModel postViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.postViewModel = postViewModel;
    }
    
    /**
     * Prepares the success view for the Get Post Use Case.
     * @param outputData the output data
     */
    @Override
    public void prepareSuccessView(GetPostOutputData outputData) {
        final PostState postState = this.postViewModel.getState();
        postState.setPostContent(outputData.getPostContent().getBody());
        this.postViewModel.setState(postState);
        this.postViewModel.firePropertyChanged();

        this.viewManagerModel.setState(postViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the failure view for the Get Post Use Case.
     * @param errorMessage the explanation of the failure
     */
    @Override
    public void prepareFailView(String errorMessage) {
        final PostState postState = this.postViewModel.getState();
        postState.setPostContentError(errorMessage);
        this.postViewModel.firePropertyChanged();
    }
}