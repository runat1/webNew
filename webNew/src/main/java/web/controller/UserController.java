package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/")
	public String getUsers(Model model) {
		model.addAttribute("users", userService.getListOfUsers());
		return "/all-user";
	}

	@GetMapping("/newUser")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "newUser";
	}
    @GetMapping("/{id}/getUserId")
    public String getUserId(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserId(id));
        return "remove";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user,
                             @PathVariable("id") long id) {
        userService.updateUser( id, user);
        return "redirect:/";
    }
	@DeleteMapping("/{id}/delete")
	public String deleteUser(@PathVariable("id") long id) {
		userService.deleteUserById(id);
		return "redirect:/";
	}
	@PostMapping
	public String creatNewUser(@ModelAttribute("user") User user) {
		userService.addUser(user);
		return "redirect:/";
	}
}