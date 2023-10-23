package com.anma.bh.sb.springtesting;

import com.anma.bh.sb.springtesting.core.repositories.BuildingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SpringTestingApplicationTest {
//    @Autowired
//    private WebTestClient webClient = WebTestClient.bindToServer().build();

    private final TestRestTemplate template = new TestRestTemplate();

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    BuildingRepository buildingRepository;

    @MockBean
    CommandLineRunner commandLineRunner;

    @Test
    void testWithMockMvc(@Autowired MockMvc mvc) throws Exception {
        MockEnvironment environment = new MockEnvironment();
//        mvc.perform(get("/")).andExpect(status().isOk()).andExpect(content().string("Hello World"));
    }

    @Test
    void testWithWebTestClient(@Autowired WebTestClient webClient) {
        webClient
                .get().uri("/buildings")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void run() {

    }
}