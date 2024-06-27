package com.spring.Valgykla.controller;

import com.spring.Valgykla.model.Menu;
import com.spring.Valgykla.service.GenreService;
import com.spring.Valgykla.service.MenuService;
import com.spring.Valgykla.service.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MenuController {

    @Autowired
    MenuService menuService;

    @Autowired
    GenreService genreService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Menu> menuList = menuService.getAll();
        model.addAttribute("menuList", menuList);
        return "dashboard";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<String> genres = genreService.findAllGenreNames();
        model.addAttribute("genres", genres);
        model.addAttribute("menu", new Menu());
        return "create";
    }

    @PostMapping("/create")
    public String createSubmit(@ModelAttribute Menu menu, Model model) {
        menuService.save(menu);
        return "redirect:/dashboard";
    }
    @GetMapping("/menu/edit/{id}")
    public String editMenu(@PathVariable("id") int id, Model model) {
        Optional<Menu> menu = menuService.findById(id);
        List<String> genres = genreService.findAllGenreNames();
        model.addAttribute("genres", genres);
        model.addAttribute("menu", menu);
        return "edit-menu";
    }
    @PostMapping("/menu/edit")
    public String editMenuSubmit(@ModelAttribute Menu menu) {
        menuService.save(menu);
        return "redirect:/dashboard";
    }
    @GetMapping("/menu/delete/{id}")
    public String deleteMenu(@PathVariable("id") int id, Model model){
        menuService.deleteById(id);
        return "redirect:/dashboard";
    }
    @GetMapping("/dashboard/search")
    public String searchMenus(@RequestParam("query") String query, Model model) {
        List<Menu> filteredMenus = menuService.findMealsByTitle(query);
        model.addAttribute("menuList", filteredMenus);
        return "dashboard";
    }
    @GetMapping("/menu/reserve/{menuId}/{userId}")
    public String deleteMenu(@PathVariable("menuId") int menuId, @PathVariable("userId") int userId){
        Optional<Menu> optionalMenu = menuService.findById(menuId);
        if (optionalMenu.isPresent() && !optionalMenu.get().isReserved()) {
            Menu menu = optionalMenu.get();
            menu.setReservationId(userId);
            menu.setReserved(true);
            menuService.save(menu);
        }
        return "redirect:/dashboard";
    }
    @GetMapping("/account")
    public String account(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        int userId = customUserDetails.getId();
        List<Menu> reservedMenus = menuService.findMenuByReservationId(userId);
        model.addAttribute("reservedMenus", reservedMenus);
        return "account";
    }
    @GetMapping("/account/unreserve/{id}")
    public String removeReservation(@PathVariable("id") int id){
        Optional<Menu> optionalMenu = menuService.findById(id);
        if (optionalMenu.isPresent()) {
            Menu menu = optionalMenu.get();
            menu.setReservationId(0);
            menu.setReserved(false);
            menuService.save(menu);
        }
        return "redirect:/account";
    }

}
