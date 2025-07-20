package com.smartbugtracker.controller;

import com.smartbugtracker.model.Bug;
import com.smartbugtracker.util.BugParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BugController {

    @GetMapping("/bugs")
    public String showBugs(Model model) {
        // 🔄 Read real PMD output instead of dummy bug
        String pmdPath = "target/pmd.xml";  // PMD generates report here
        List<Bug> bugs = BugParser.parseBugsFromXml(pmdPath);

        model.addAttribute("bugs", bugs);
        return "bugs";  // Renders templates/bugs.html
    }
}
