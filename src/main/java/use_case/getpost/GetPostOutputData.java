package use_case.getpost;

import java.util.Objects;

import entity.Content;

/**
 * The Input Data for the Get Post Use Case.
 */
public class GetPostOutputData {

    private final String entryID;
    private final Content postContent;

    public GetPostOutputData(String entryID, Content postContent) {
        this.entryID = entryID;
        this.postContent = postContent;
    }

    public String getEntryID() {
        return entryID;
    }

    public Content getPostContent() {
        return postContent;
    }

    /**
     * Ensure that two posts are equal if they have the same content
     * This is so that testGetPost_PresenterCalledOnSuccess test passes
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetPostOutputData that = (GetPostOutputData) o;
        return entryID.equals(that.entryID) &&
                postContent.equals(that.postContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entryID, postContent);
    }


}
