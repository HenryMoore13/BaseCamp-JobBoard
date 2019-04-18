package com.BaseCamp.Jobboard.Controller;
import com.BaseCamp.Jobboard.Models.Postings;
import com.BaseCamp.Jobboard.repositories.PostgresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class LandingController {

    PostgresRepository repository;
    @Autowired
    public LandingController(PostgresRepository repo){
        repository = repo;
    }

    @GetMapping("/CreatePost")
    public String create(){
        return "makePost";
    }

    @PostMapping("/CreatePost")
    public String create1(Postings postings){
        repository.savePost(postings);
        return "redirect:/";
    }

    @GetMapping("/")
    public String Posts(Model model) {
        model.addAttribute("postings", repository.findAll());
        return "home";
    }

    @GetMapping("/{uuid}")
    public String Post(Model Postings, @PathVariable(value = "uuid") UUID id) {
        Optional<Postings> postings;
        postings = repository.findById(id);


        if (postings.isPresent()) {
            Postings.addAttribute("posting", postings.get());
            return "Post";
        } else {
            return "home";
        }

    }
}
