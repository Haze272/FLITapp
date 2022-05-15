package com.example.flitapp.mvvm.models;

import com.example.flitapp.mvvm.models.repositories.TagRepository;

import java.util.HashMap;

public class TagsCount {
    private HashMap<String, Integer> tagsDone = new HashMap<>();
    private TagRepository repository = TagRepository.getInstance();

    public TagsCount() {
        fillTags();
    }

    private void fillTags() {
        for (String tag : repository.getTagsList()) {
            tagsDone.put(tag, 0);
        }
    }

    public void setAmountOfTag(String tag, int value) {
        tagsDone.put(tag, value);
    }
}
