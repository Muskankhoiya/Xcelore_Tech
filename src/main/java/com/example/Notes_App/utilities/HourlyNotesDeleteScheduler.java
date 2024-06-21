package com.example.Notes_App.utilities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.Notes_App.entity.User;
import com.example.Notes_App.repo.*;


@Component

public class HourlyNotesDeleteScheduler {




    @Autowired
    private NotesRepository noteRepository;
    @Autowired
    private UserRepository userRepository;

    @Scheduled(cron = "0 0 * * * *") //every hour
//	@Scheduled(cron = "*/10 * * * * *")  // every 10 second

    	public void deleteNotesHourly() {
    	    List<User> users = userRepository.findAll();
    	    for (User user : users) {
    	        List<Long> lastTenNoteIds = noteRepository.findLastTenNoteIds(user.getId(), PageRequest.of(0, 10));
    	        noteRepository.deleteUsers(user.getId(), lastTenNoteIds);
    	    }
    	}




}
