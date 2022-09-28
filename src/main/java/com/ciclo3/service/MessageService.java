package com.ciclo3.service;

import com.ciclo3.model.Message;
import com.ciclo3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessage() {
        return (List<Message>) messageRepository.getAllMessage();
    }
    public Optional<Message> getMessageById(Integer id) {
        return messageRepository.getMessageById(id);
    }
    public Message saveMessage(Message m) {
        return messageRepository.saveMessage(m);
    }
    public boolean deleteMessage(Integer id){
        messageRepository.deleteMessage(id);
        return true;
    }
    public Message updateMessage (Message m){
        return messageRepository.updateMessage(m);
    }
}
