package edu.badpals;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class game  implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String description;
    private List<String> languages = new ArrayList<String>();

    public game(){}
    public game(String name) {
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void addLanguage(String language) {
        languages.add(language);
    }

    public List<String> getLanguages() {
        return languages;
    }

}
