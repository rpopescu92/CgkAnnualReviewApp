package ro.cegeka.app.resources;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import ro.cegeka.app.domain.model.User;
import ro.cegeka.app.services.UserService;

import java.util.Date;

import static org.mockito.BDDMockito.given;

/**
 * Created by roxanap on 04.11.2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountResourceTest {

    @MockBean
    private UserService userServiceMock;
    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup(){
        given(this.userServiceMock.getAuthenticatedUserAsOptional()
        ).willReturn(java.util.Optional.of(new User(300L, "admin", "admin", "admin", "admin", new Date(), new Date())));


    }

    @Test
    public void testGetAuthenticatedUser(){
        this.restTemplate.getForEntity("/api/account",
                String.class, "sframework");
    }
}



