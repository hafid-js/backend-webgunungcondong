package springhafidtech.gunungcondongdotcom.services;

import springhafidtech.gunungcondongdotcom.payloads.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto, Integer postId);

    void deleteComment(Integer commentId);
}
