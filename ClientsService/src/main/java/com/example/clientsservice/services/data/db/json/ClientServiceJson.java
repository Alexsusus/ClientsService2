package com.example.clientsservice.services.data.db.json;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.ClientService;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;

public class ClientServiceJson {

    private ClientService clientService;

    void clientDateSave() {
    Client client = new Client(0, "a", "a", "a",
            Client.Gender.FEMALE, "a@t.com", LocalDate.now(), null, null, null);
    client = clientService.save(client);
    System.err.println(client);
}

    void clientDateJson() {
        Client client = new Client(0, "a", "a", "a",
                Client.Gender.FEMALE, "a@t.com", LocalDate.now(), null, null, null);
       /* Gson gson = new Gson();
        String json = gson.toJson(client);
        System.err.println(json);
        client = gson.fromJson(json,Client.class);
        System.err.println(client);*/
        TypeAdapter<Client> typeAdapter = new TypeAdapter<>() {

            @Override
            public void write(JsonWriter jw, Client cl) throws IOException {
                jw.beginObject();
                jw.name("id").value(cl.getId());
                jw.name("surname").value(cl.getSurname());
                jw.name("name").value(cl.getName());
                jw.name("patronymic").value(cl.getPatronymic());
                jw.name("email").value(cl.getEmail());
                jw.name("gender").value(cl.getGender().name());
                jw.name("birthDate").value(cl.getBirthDate().toString());
                jw.endObject();
            }


            @Override
            public Client read(JsonReader jr) throws IOException {
                Client cl = new Client();
                jr.beginObject();
                jr.nextName();
                cl.setId(jr.nextInt());
                jr.nextName();
                cl.setSurname(jr.nextString());
                jr.nextName();
                cl.setName(jr.nextString());
                jr.nextName();
                cl.setPatronymic(jr.nextString());
                jr.nextName();
                cl.setEmail(jr.nextString());
                jr.nextName();
                cl.setGender(Client.Gender.valueOf(jr.nextString()));
                jr.nextName();
                cl.setBirthDate(LocalDate.parse(jr.nextString()));
                jr.endObject();
                return cl;
            }
        };
        String json = typeAdapter.toJson(client);
        System.err.println(json);
        try {
            client = typeAdapter.fromJson(json);
            System.err.println(client);
        } catch (Exception e) {
            System.err.println(e);
        }

    }
}
