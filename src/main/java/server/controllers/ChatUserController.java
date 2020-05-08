package server.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.DTOs.ConversationDTO;
import server.services.UserService;

import java.util.List;

@RestController
@RequestMapping("//chat-users")
public class ChatUserController {

    private UserService userService;

    public ChatUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/conversations/{userId}")
    public List<ConversationDTO> getConversationsByUserId(@PathVariable String userId) {
        return userService.getConversationsByUserId(userId);
    }

}
