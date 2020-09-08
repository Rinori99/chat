package server.controllers;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import server.DTOs.ChatMessageDTO;
import server.services.MessageService;

import java.security.Principal;

@Controller
public class WebsocketMessageCntrl {

    private MessageService messageService;

    public WebsocketMessageCntrl(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("/message/{conversationId}")
    @SendTo("/topic/chat/{conversationId}")
    public ChatMessageDTO messageCommunication(@DestinationVariable String conversationId, ChatMessageDTO message, Principal principal) {
        messageService.saveMessage(message.getSenderId(), message.getConversationId(), message.getContent(), message.getTimeSent());
        return message;
    }

}
