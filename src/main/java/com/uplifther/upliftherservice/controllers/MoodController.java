package com.uplifther.upliftherservice.controllers;

import com.uplifther.upliftherservice.model.MoodSelection;
import com.uplifther.upliftherservice.services.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/moodEntries")
public class MoodController {
    @Autowired
    MoodService moodService;

    @PostMapping
    MoodSelection addMoodEntry(@RequestBody MoodSelection moodSelection) {
        // do something
        moodService.doSomething();
        return moodSelection;
    }


    @PutMapping("/{entryId}")
    MoodSelection updateMoodEntry(@PathVariable("entryId") int id, @RequestBody MoodSelection moodSelection) {
        // do something.
        moodService.doSomething();
        moodSelection.setEntryId(id);
        return moodSelection;
    }

}
