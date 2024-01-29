package springhafidtech.gunungcondongdotcom.services.impl;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import springhafidtech.gunungcondongdotcom.entities.Category;
import springhafidtech.gunungcondongdotcom.entities.Post;
import springhafidtech.gunungcondongdotcom.entities.User;
import springhafidtech.gunungcondongdotcom.exceptions.ResourceNotFoundException;
import springhafidtech.gunungcondongdotcom.payloads.PostDto;
import springhafidtech.gunungcondongdotcom.payloads.PostResponse;
import springhafidtech.gunungcondongdotcom.repositories.CategoryRepo;
import springhafidtech.gunungcondongdotcom.repositories.PostRepo;
import springhafidtech.gunungcondongdotcom.repositories.UserRepo;
import springhafidtech.gunungcondongdotcom.services.PostService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private HttpServletRequest httpServletRequest;


    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "user id", userId));

        Category category = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));

        Post post = this.modelMapper.map(postDto, Post.class);
        post.setTitle(postDto.getTitle());
        post.setThumbnail(postDto.getThumbnail());
        post.setShortDescription(postDto.getShortDescription());
        post.setContent(postDto.getContent());
        post.setPublish(Boolean.TRUE);
        post.setCategory(category);
        post.setUser(user);
        post.setCreatedAt(new Date());

        Post newPost = this.postRepo.save(post);
        return this.modelMapper.map(newPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
        Sort sort = (sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
        Pageable p = PageRequest.of(pageNumber, pageSize, sort);
        Page<Post> pagePost = this.postRepo.findAll(p);
        List<Post> allPosts = pagePost.getContent();
        List<PostDto> postDtos = allPosts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setPageNumber(pagePost.getNumber());
        postResponse.setPageSize(pagePost.getSize());
        postResponse.setTotalElements(pagePost.getTotalElements());
        postResponse.setTotalPages(pagePost.getTotalPages());
        postResponse.setLastPage(pagePost.isLast());

        return postResponse;

    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
        return this.modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<PostDto> getPostsByUser(Integer userId) {
        return null;
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        return null;
    }
}
