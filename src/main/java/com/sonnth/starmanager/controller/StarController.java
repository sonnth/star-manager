package com.sonnth.starmanager.controller;

import com.sonnth.starmanager.model.Star;
import com.sonnth.starmanager.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class StarController {

    @Autowired
    private StarService starService;

    @GetMapping
    public ModelAndView doHome(@RequestParam("s") Optional<String> s , @PageableDefault(size = 8 ) Pageable pageable){
        Page<Star> stars;
        if(s.isPresent()){
            stars = starService.findByName(s.get(), pageable);
        } else {
            stars = starService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("stars", stars);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView viewCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("star", new Star());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView addStar(@Valid @ModelAttribute("star") Star star, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("create");
        if (bindingResult.hasFieldErrors()){
            return  modelAndView;
        }else {
            starService.save(star);
            modelAndView.addObject("message","New star created successfully");
            modelAndView.addObject("star", new Star());
            return modelAndView;
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView viewEdit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("star",starService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editStar(@Valid @ModelAttribute("star") Star star, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("edit");
        if(bindingResult.hasFieldErrors()){
            return modelAndView;
        }else {
            starService.save(star);
            modelAndView.addObject("message", "Star updated successfully");
            return modelAndView;
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView viewDelete(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("star",starService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView deleteStar(@RequestParam("id") int id,Star star){
        star = starService.findById(id);
        if(star != null) {
            starService.remove(id);
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("message","Delete Success..");
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("message","Not Star To Delete..");
            return modelAndView;
        }
    }
}
