package server.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import server.DTOs.ChatMessageDTO;
import server.mappers.MessageMapper;
import server.models.ChatMessage;
import server.models.ChatUser;
import server.models.Conversation;
import server.repositories.MessageRepo;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepo messageRepo;
    private ConversationService conversationService;
    private UserService userService;

    public MessageServiceImpl(MessageRepo messageRepo, ConversationService conversationService, UserService userService) {
        this.messageRepo = messageRepo;
        this.conversationService = conversationService;
        this.userService = userService;
    }

    @Override
    public ChatMessage getMessageById(String messageId) {
        return messageRepo.findById(messageId).orElseThrow(() -> new NoSuchElementException("Message not found!"));
    }

    @Override
    @Async("threadPoolTaskExecutor")
    public void saveMessage(String senderId, String conversationId, String content, Timestamp timeStamp) {
        ChatUser sender = userService.getUserById(senderId);
        Conversation conversation = conversationService.getConversationById(conversationId);
        ChatMessage message = new ChatMessage(UUID.randomUUID().toString(), sender, conversation, content);
        messageRepo.save(message);
    }

    @Override
    public List<ChatMessageDTO> getMessagesByConversationId(String conversationId) {
        List<ChatMessage> chatMessageList = messageRepo.getMessagesByConversationId(conversationId);
        List<ChatMessageDTO> chatMessageDTOList = new ArrayList<>();
        for(ChatMessage chatMessage : chatMessageList) {
            chatMessageDTOList.add(MessageMapper.chatMessageToChatMessageDTO(chatMessage));
        }
        return chatMessageDTOList;
    }

}
