package com.aspose.cloud.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the Comments resource
    /// </summary>
    public class CommentsResponse extends com.aspose.cloud.common.BaseResponse
    {        
        private LinkResponse link ;
        private List<LinkResponse> CommentList ;
        private Comment Comment ;
        
        public LinkResponse getlink(){return link;}
        public List<LinkResponse> getCommentList(){return CommentList;}
        public Comment getComment(){return Comment;}
    }