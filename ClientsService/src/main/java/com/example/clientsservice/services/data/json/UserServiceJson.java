package com.example.clientsservice.services.data.json;

import com.example.clientsservice.models.User;
import com.example.clientsservice.services.data.UserService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceJson implements UserService {

    private final String users = "users.json";

    @Override
    public List<User> findAll(){
        try {
            return new Gson().fromJson(new JsonReader(new FileReader(users)), new TypeToken<List<User>>(){});

        } catch (Exception ignored) {
        }
        return new ArrayList<>();
    }

    @Override
    public User save(User user) {
        return null;
    }
}
