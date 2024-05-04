package com.sol.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;


import com.sol.config.AppConfig;
import com.sol.dao.PlayerDAOImpl;

@WebMvcTest(PlayerController.class)
@Import(AppConfig.class)
public class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerDAOImpl playerDAOImpl;
    
    //TODO implement these tests
//    @Test
//    public void testGetPlayerById_NotFound() throws Exception {
//    }
//
//    @Test
//    public void testGetPlayerByIdEmptyId() throws Exception {
//    }
//    
//    @Test
//    public void testGetPlayersChunkNegativeParams() throws Exception {
//    }
//    
//    @Test
//    public void testGetPlayersChunkMissingParams() throws Exception {
//    }
//    
//    @Test
//    public void testGetPlayersChunkOk() throws Exception {
//    }


}
