package services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import server.DTOs.ChatUserDTO;
import server.DTOs.ConversationDTO;
import server.PerRequestIdStorage;
import server.mappers.UserMapper;
import server.models.ChatUser;
import server.models.Conversation;
import server.repositories.ConversationRepo;
import server.services.ConversationServiceImpl;
import server.services.UserService;

import java.lang.reflect.Field;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class ConversationServiceTest {

    @Mock
    private ConversationRepo conversationRepo;

    @Mock
    private UserService userService;

    @InjectMocks
    private ConversationServiceImpl conversationService;

    private ChatUser participant;
    private ChatUser loggedInUser;

    private Conversation conversation;
    private long conversationCreateDate = System.currentTimeMillis();

    @Before
    public void setup() {
        PerRequestIdStorage.setUserId("26b133a6-ea05-447b-904e-4415bfa92061");
        participant = new ChatUser("5211e915-c3e2-4dcb-0776-c7b900f38ab7", "John", "Doe", "STUDENT",
                "john.doe@gmail.com");
        loggedInUser = new ChatUser("26b133a6-ea05-447b-904e-4415bfa92061", "James", "Doe", "PARENT",
                "james.doe@gmail.com");
        conversation = new Conversation("efbfbad9-17a9-46ce-a052-aba8c4250ffa", new Date(conversationCreateDate));
        conversation.setParticipants(Arrays.asList(participant, loggedInUser));

        Supplier<UUID> uuidSupplier = Mockito.mock(Supplier.class);
        try {
            Field uuidSupplierField = ConversationServiceImpl.class.getDeclaredField("uuidSupplier");
            uuidSupplierField.setAccessible(true);
            uuidSupplierField.set(conversationService, uuidSupplier);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        when(uuidSupplier.get()).thenReturn(UUID.fromString("efbfbad9-17a9-46ce-a052-aba8c4250ffa"));
        when(conversationRepo.findById("efbfbad9-17a9-46ce-a052-aba8c4250ffa")).thenReturn(Optional.of(conversation));
        when(userService.getUserByEmail("john.doe@gmail.com")).thenReturn(participant);
        when(userService.getUserById("26b133a6-ea05-447b-904e-4415bfa92061")).thenReturn(loggedInUser);
        when(conversationRepo.save(conversation)).thenReturn(conversation);
    }

    @Test
    public void getConversation_byId_returnConversation() {
        assertThat(conversationService.getConversationById("efbfbad9-17a9-46ce-a052-aba8c4250ffa"))
                .isEqualToComparingFieldByField(conversation);
    }

    @Test
    public void createConversation_byEmail_returnConversationDTO() {
        ConversationDTO conversationDTO = new ConversationDTO("efbfbad9-17a9-46ce-a052-aba8c4250ffa", new Date(conversationCreateDate),
                "John Doe", "No messages yet");
        assertThat(conversationService.createConversation("john.doe@gmail.com")).isEqualToComparingFieldByField(conversationDTO);
    }

    @Test
    public void getUsers_byConversationId_returnListOfChatUserDTO() {
        List<ChatUserDTO> chatUserDTOList = conversationService.getUsersByConversationId("efbfbad9-17a9-46ce-a052-aba8c4250ffa");
        assertThat(chatUserDTOList).contains(UserMapper.chatUserToChatUserDTO(participant), UserMapper.chatUserToChatUserDTO(loggedInUser));
    }

}
