package th.mfu;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConcertController {
 private final List<Concert> concerts = new ArrayList<>();
  private Long nextId = 1L;

    @GetMapping("/concerts")
    public String listConcerts(Model model) {
        model.addAttribute("concerts", concerts);
        return "list-concert";
    }

    @GetMapping("/add-concert-form")
    public String addAConcertForm(Model model) {
        model.addAttribute("concert", new Concert());
        return "add-concert-form";
    }

    @PostMapping("/concerts")
    public String saveConcert(@ModelAttribute Concert concert) {
        concert.setId((long) nextId++);
        concerts.add(concert);
        return "redirect:/concerts";
    }

    @GetMapping("/delete-concert/{id}")
    public String deleteConcert(@PathVariable("id") Long id) {
        concerts.removeIf(c -> c.getId().equals(id));
        return "redirect:/concerts";
    }

    @GetMapping("/delete-concert")
    public String removeAllConcerts() {
        concerts.clear();
        nextId = 1L;
        return "redirect:/concerts";
    }

}
