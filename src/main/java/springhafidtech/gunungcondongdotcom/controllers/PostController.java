package springhafidtech.gunungcondongdotcom.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springhafidtech.gunungcondongdotcom.config.AppConstants;
import springhafidtech.gunungcondongdotcom.payloads.*;
import springhafidtech.gunungcondongdotcom.repositories.PostRepo;
import springhafidtech.gunungcondongdotcom.services.PostService;
import springhafidtech.gunungcondongdotcom.utils.ClientInfo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/")
@Slf4j
public class PostController {


    @Autowired
    private ClientInfo clientInfo;

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId
            ) {

        PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
    }


    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUser(
            @PathVariable Integer userId
    ) {
        List<PostDto> posts = this.postService.getPostsByUser(userId);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPost(

            @RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir
    ) {
        PostResponse postResponse = this.postService.getAllPost(pageNumber, pageSize, sortBy, sortDir);
        return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(
            @PathVariable Integer postId,
            HttpServletRequest request,
            @RequestHeader HttpHeaders headers
//            @RequestBody PostViewerDto postViewerDto

    ) {
        PostDto postDto = this.postService.getPostById(postId);


        String platform = clientInfo.getClientBrowser(request);
        String ipAddress = clientInfo.getClientIpAddr(request);
        String clientOS = clientInfo.getClientOS(request);
        String getFullUrl = clientInfo.getFullURL(request);
//        String referer = clientInfo.getReferer(request);
        String userAgent = clientInfo.getUserAgent(request);
        DateFormat dateRequest = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        log.info(platform);
        log.info(ipAddress);
        log.info(clientOS);
        log.info(getFullUrl);
//        log.info(referer);
        log.info(userAgent);
        log.info(dateRequest.format(date));

//        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
//        PostViewer postViewer = this.modelMapper(po, PostViewer.class);
//        postViewer.setViewerId(1);
//        postViewer.setDate(date);
//        postViewer.setIpAddress(clientIpAddr);
//        postViewer.setPlatform(clientBrowser);
//        postViewer.setPost(post);
//
//        PostViewer newPostViewer = this.postViewerRepo.save(postViewer);


        return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory (
            @PathVariable Integer categoryId
    ) {
        List<PostDto> posts = this.postService.getPostsByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }



}
