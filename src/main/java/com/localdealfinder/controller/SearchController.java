package com.localdealfinder.controller;

import com.localdealfinder.Service.SearchPositiveMatchService;
import com.localdealfinder.Service.UserSearchService;
import com.localdealfinder.Service.UserService;
import com.localdealfinder.model.Search;
import com.localdealfinder.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {

    @GetMapping("/searches")
    public String searchList(Model model) {
        UserSearchService service = UserSearchService.getInstance();
        User user = service.readAll("test_user");

        model.addAttribute("searches", user.getSearches());

        return "listsearches";
    }

    @GetMapping("/search-form")
    public String searchForm(Model model) {
        model.addAttribute("search", new Search());
        return "searchform";
    }

    @PostMapping("/submit-search")
    public ModelAndView submitSearchForm(@ModelAttribute Search search) {
        return new ModelAndView("redirect:/searches");
    }
}
