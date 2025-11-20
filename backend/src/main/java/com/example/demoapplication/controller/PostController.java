package com.example.demoapplication.controller;


import com.example.demoapplication.dto.PostDTO;
import com.example.demoapplication.entity.Post;
import com.example.demoapplication.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;


    //create post with userId
    @PostMapping("/users/{userId}")
    public Post createPost(@PathVariable Long userId , @RequestBody PostDTO postDTO)
    {
            return postService.createPost(userId,postDTO);
    }

    //get all posts
    @GetMapping()
    public Page<Post> getAllPosts(@RequestParam(defaultValue = "0")int page,
                                 @RequestParam(defaultValue = "10")int size,
                                 @RequestParam(defaultValue = "id")String sortBy)
    {
        return postService.listPosts(page,size,sortBy);
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable Long id)
    {
        return postService.getPost(id);
    }


}
