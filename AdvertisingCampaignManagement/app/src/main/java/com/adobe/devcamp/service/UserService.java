package com.adobe.devcamp.service;

import com.adobe.devcamp.dao.UserDao;
import com.adobe.devcamp.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public final class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserDao userDao;
    private final ObjectMapper objectMapper;

    public UserService(UserDao userDao, ObjectMapper objectMapper) {
        this.userDao = userDao;
        this.objectMapper = objectMapper;
    }

    public Map<Integer, User> getUser() {
        final Map<Integer, String> usersMap = userDao.selectUsers();
        final Map<Integer, User> users = new HashMap();

        for(Map.Entry<Integer, String> entry : usersMap.entrySet()) {
            final User user;
            try {
                user = objectMapper.readValue(entry.getValue(), User.class);
                users.put(entry.getKey(), user);
            } catch (JsonProcessingException e) {
                logger.error("Object {} could not be deserialized", entry.getValue());
            }
        }
        return users;
    }
}
