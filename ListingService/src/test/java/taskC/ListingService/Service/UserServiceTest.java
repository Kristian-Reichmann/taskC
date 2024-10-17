package taskC.ListingService.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import taskC.ListingService.Exceptions.ResourceNotFoundException;
import taskC.ListingService.Models.User;
import taskC.ListingService.Repositories.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user1;
    private User user2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user1 = new User("john_doe", "john@example.com", "password123");
        user1.setId(1L);
        user2 = new User("jane_doe", "jane@example.com", "password456");
        user2.setId(2L);
    }

    @Test
    void getAllUsers_ShouldReturnAllUsers() {
        List<User> users = Arrays.asList(user1, user2);
        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        assertEquals(2, result.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void createUser_ShouldSaveUser() {
        when(userRepository.save(any(User.class))).thenReturn(user1);

        User createdUser = userService.createUser(user1);

        assertNotNull(createdUser);
        assertEquals("john_doe", createdUser.getUsername());
        assertEquals("password123", createdUser.getPassword());  // No encoding
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void updateUser_ShouldUpdateExistingUser() {
        User updatedDetails = new User("john_updated", "john_new@example.com", "newpassword");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user1));
        when(userRepository.save(any(User.class))).thenReturn(updatedDetails);

        User updatedUser = userService.updateUser(1L, updatedDetails);

        assertEquals("john_updated", updatedUser.getUsername());
        assertEquals("john_new@example.com", updatedUser.getEmail());
        assertEquals("newpassword", updatedUser.getPassword());  // No encoding
        verify(userRepository, times(1)).findById(1L);
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void updateUser_NonExistingUser_ShouldThrowException() {
        User updatedDetails = new User("john_updated", "john_new@example.com", "newpassword");
        when(userRepository.findById(3L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            userService.updateUser(3L, updatedDetails);
        });
        verify(userRepository, times(1)).findById(3L);
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void deleteUser_ShouldDeleteExistingUser() {
        when(userRepository.existsById(1L)).thenReturn(true);
        doNothing().when(userRepository).deleteById(1L);

        userService.deleteUser(1L);

        verify(userRepository, times(1)).existsById(1L);
        verify(userRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteUser_NonExistingUser_ShouldThrowException() {
        when(userRepository.existsById(3L)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> {
            userService.deleteUser(3L);
        });
        verify(userRepository, times(1)).existsById(3L);
        verify(userRepository, never()).deleteById(anyLong());
    }
}
