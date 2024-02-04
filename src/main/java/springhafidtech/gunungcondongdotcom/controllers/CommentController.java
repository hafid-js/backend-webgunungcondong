package springhafidtech.gunungcondongdotcom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springhafidtech.gunungcondongdotcom.entities.Post;
import springhafidtech.gunungcondongdotcom.payloads.AddressDto;
import springhafidtech.gunungcondongdotcom.payloads.ApiResponse;
import springhafidtech.gunungcondongdotcom.payloads.CommentDto;
import springhafidtech.gunungcondongdotcom.services.CommentService;

@RestController
@RequestMapping("/api/comment/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}")
    public ResponseEntity<CommentDto> createComment (
            @RequestBody CommentDto commentDto,
            @PathVariable Integer postId
            )
    {

        CommentDto createComment = this.commentService.createComment(commentDto, postId);
        return new ResponseEntity<CommentDto>(createComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId) {
        this.commentService.deleteComment(commentId);

        return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted successfully !", true), HttpStatus.OK);
    }

}
