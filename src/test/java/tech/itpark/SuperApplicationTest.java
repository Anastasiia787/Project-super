package tech.itpark;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@SpringBootTest
@AutoConfigureMockMvc
class SuperApplicationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception {
        mockMvc.perform(get("/products"))
                .andExpect(content().json("[\n" +
                        "  {\n" +
                        "    \"id\": 1,\n" +
                        "    \"picture\": \"noavatar.jpg\",\n" +
                        "    \"model\": \"comfortable\",\n" +
                        "    \"brand\": \"Forward Parma 28\",\n" +
                        "    \"wheelDiameter\": 19,\n" +
                        "    \"price\": 17890,\n" +
                        "    \"quantity\": 15,\n" +
                        "    \"deleted\": false\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"id\": 2,\n" +
                        "    \"picture\": \"noavatar.jpg\",\n" +
                        "    \"model\": \"mountain\",\n" +
                        "    \"brand\": \"Cube Aim EX 29\",\n" +
                        "    \"wheelDiameter\": 23,\n" +
                        "    \"price\": 60100,\n" +
                        "    \"quantity\": 10,\n" +
                        "    \"deleted\": false\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"id\": 3,\n" +
                        "    \"picture\": \"noavatar.jpg\",\n" +
                        "    \"model\": \"urban\",\n" +
                        "    \"brand\": \"Stark Terros 700 S\",\n" +
                        "    \"wheelDiameter\": 28,\n" +
                        "    \"price\": 23690,\n" +
                        "    \"quantity\": 12,\n" +
                        "    \"deleted\": false\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"id\": 4,\n" +
                        "    \"picture\": \"noavatar.jpg\",\n" +
                        "    \"model\": \"child\",\n" +
                        "    \"brand\": \"Novatrack Maple 16\",\n" +
                        "    \"wheelDiameter\": 16,\n" +
                        "    \"price\": 9600,\n" +
                        "    \"quantity\": 5,\n" +
                        "    \"deleted\": false\n" +
                        "  }\n" +
                        "]\n"));
    }

        @Test
        void productsTest() throws Exception {
            mockMvc.perform(get("/products/1"))
                    .andExpect(content().json(" {\n" +
                            "    \"id\": 1,\n" +
                            "    \"picture\": \"noavatar.jpg\",\n" +
                            "    \"model\": \"comfortable\",\n" +
                            "    \"brand\": \"Forward Parma 28\",\n" +
                            "    \"wheelDiameter\": 19,\n" +
                            "    \"price\": 17890,\n" +
                            "    \"quantity\": 15,\n" +
                            "    \"deleted\": false\n" +
                            "  }"));

            mockMvc.perform(get("/products/search")
                    .queryParam("model", "comfortable"))
                    .andExpect(content().json("[{\n" +
                            "    \"id\": 1,\n" +
                            "    \"picture\": \"noavatar.jpg\",\n" +
                            "    \"model\": \"comfortable\",\n" +
                            "    \"brand\": \"Forward Parma 28\",\n" +
                            "    \"wheelDiameter\": 19,\n" +
                            "    \"price\": 17890,\n" +
                            "    \"quantity\": 15,\n" +
                            "    \"deleted\": false\n" +
                            "  }]"));
        }

    @Test
    void putProductTest() throws Exception {
        mockMvc.perform(post("/products")
                .contentType("application/json")
                .content("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"model\": \"child\",\n" +
                        "  \"picture\": \"noavatar.jpg\",\n" +
                        "  \"brand\": \"Novatrack Maple 16\",\n" +
                        "  \"wheelDiameter\": 16,\n" +
                        "  \"price\": 9600,\n" +
                        "  \"quantity\": 5\n" +
                        "}"))
                .andExpect(content().json("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"model\": \"child\",\n" +
                        "  \"picture\": \"noavatar.jpg\",\n" +
                        "  \"brand\": \"Novatrack Maple 16\",\n" +
                        "  \"wheelDiameter\": 16,\n" +
                        "  \"price\": 9600,\n" +
                        "  \"quantity\": 5\n" +
                        "}"));
    }

    @Test
    void productsLoads() throws Exception {
        mockMvc.perform(post("/products")
                .contentType("application/json")
                .content("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"picture\": \"noavatar.jpg\",\n" +
                        "    \"model\": \"comfortable\",\n" +
                        "    \"brand\": \"Forward Parma 28\",\n" +
                        "    \"wheelDiameter\": 19,\n" +
                        "    \"price\": 17890,\n" +
                        "    \"quantity\": 15,\n" +
                        "    \"deleted\": false\n" +
                        "  }"))
                .andExpect(content().json("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"picture\": \"noavatar.jpg\",\n" +
                        "  \"model\": \"comfortable\",\n" +
                        "  \"brand\": \"Forward Parma 28\",\n" +
                        "  \"wheelDiameter\": 19,\n" +
                        "  \"price\": 17890,\n" +
                        "  \"quantity\": 15,\n" +
                        "  \"deleted\": false\n" +
                        "}"));
    }
}