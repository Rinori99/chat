package server.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.DTOs.ChatMessageDTO;
import server.services.MessageService;

import java.util.List;

@RestController
@RequestMapping("messages")
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("{conversationId}")
    public List<ChatMessageDTO> getMessagesByConversationId(@PathVariable String conversationId) {
        return messageService.getMessagesByConversationId(conversationId);
    }

}
