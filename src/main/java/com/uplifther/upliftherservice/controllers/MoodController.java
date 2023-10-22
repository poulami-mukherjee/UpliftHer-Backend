package com.uplifther.upliftherservice.controllers;

import com.uplifther.upliftherservice.model.Insight;
import com.uplifther.upliftherservice.model.MoodSelection;
import com.uplifther.upliftherservice.services.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/insights")
    public List<Insight> getInsights(@RequestParam(name = "startDate") String startDate,
                                     @RequestParam(name = "endDate") String endDate) {
        //do something
        return List.of(new Insight("Test"));
    }

}
