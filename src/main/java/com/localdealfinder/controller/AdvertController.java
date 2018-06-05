package com.localdealfinder.controller;


import com.localdealfinder.Service.AdvertService;
import com.localdealfinder.model.Advert;
import com.localdealfinder.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class AdvertController {

    @GetMapping("/adverts")
    public String advertForm(Model model) {
        return "advertform";
    }

    @PostMapping("/adverts")
    public String advertSubmit(Model model) {
        List<Advert> adverts = null;
        AdvertService service = AdvertService.getInstance();
        Optional<List<Advert>> advertsOpt = service.readAll();
        if(advertsOpt.isPresent()){
            adverts = advertsOpt.get();
        }
        model.addAttribute("adverts", adverts);
        return "listadverts";
    }
}