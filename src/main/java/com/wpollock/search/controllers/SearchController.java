package com.wpollock.search.controllers;

import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.wpollock.search.data.FormData;

/**
 * The Spring Controller class for this app. Only one is needed for this app,
 * with a few simple views. (More complex controllers can be split out into
 * separate classes.)
 *
 * @author wpollock
 *
 */
@Controller
public class SearchController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Defines the home view controller. This is the default view from which
     * searching can be done.
     *
     * @return The view name
     */
    @GetMapping("/")
    public String home(Model model) {
        log.debug("Home controller invoked");
        model.addAttribute("FormData", new FormData());
        return "home"; // Name of view
    }

    @PostMapping("/")
    public String search(@ModelAttribute("FormData") FormData data) {
        log.debug("Search form submitted");
        // clear search results from model.
        log.error("Search Terms: " + data.getSearchTerms());

        return "home"; // Name of view
    }

    /**
     * The file operations (maintenance mode) view. (Will probably need refactoring
     * once implemented.)
     *
     * @return The view name
     */
    @GetMapping("/maint")
    public String maint() {
        log.debug("maint controller invoked");
        return "maint";
    }

    @GetMapping("/about")
    public String about() {
        log.debug("about controller invoked");
        return "about";
    }

    @GetMapping("/login")
    public String login() {
        log.debug("login controller invoked");
        return "login";
    }
}
