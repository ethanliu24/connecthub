package use_case.edit_post;

import entity.Post;

public interface EditPostDataAccessInterface {

    // Method to edit a post
    void editPost(Post post) throws EditPostFailed;
}