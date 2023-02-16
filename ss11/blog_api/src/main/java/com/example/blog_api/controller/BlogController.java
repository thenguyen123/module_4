package com.example.blog_api.controller;


import com.example.blog_api.model.Blog;
import com.example.blog_api.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
@RestController
@CrossOrigin
@RequestMapping("api/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

//    @GetMapping("")
//    public ResponseEntity<List<Blog>> getAll() {
//        List<Blog> blogList = blogService.findAll();
//        if (blogList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(blogList, HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity showById(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(blog, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody Blog blog) {
        Blog blog1 = blogService.findById(id);
        BeanUtils.copyProperties(blog, blog1);
        if (blog1 == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        blogService.update(blog1);
        return new ResponseEntity<>(HttpStatus.OK);

    }


    @GetMapping("")
    public ResponseEntity showPage(@RequestParam(required = false, defaultValue ="") String name,
                                   @RequestParam(required = false, defaultValue = "2") int page) {
        Pageable pageable= PageRequest.of(0,page);
        Page<Blog> blogPage = blogService.findByNameContaining(name, pageable);
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }


}
