package com.example.demoapplication.service;

import com.example.demoapplication.dto.PostDTO;
import com.example.demoapplication.entity.Post;
import com.example.demoapplication.entity.User;
import com.example.demoapplication.repository.PostRepository;
import com.example.demoapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class PostService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;



    //crete post
    public Post createPost(Long userId, PostDTO postDTO)
    {
        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not Found"));

        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setAuthor(user);
        return postRepository.save(post);
    }

    //List All post with paginaion
    public Page<Post> listPosts(int page, int size, String sortBy)
    {
       Pageable pageable = PageRequest.of(page,size,Sort.by(sortBy));
       return postRepository.findAll(pageable);
    }

    //Get post by Id

    public Post getPost(Long id)
    {
        return postRepository.findById(id).orElseThrow(()->new RuntimeException("Post Not Found"));
    }
}
