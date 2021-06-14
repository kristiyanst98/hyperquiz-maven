package hyperquiz.model;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Quiz extends AbstractEntity<Long,Quiz> {
    private String title;
    private User author;
    private String description;
    private List<Question> questions=new ArrayList<>();
    private int expectedDuration;
    private URL picture;
    private String tags;

    public Quiz() {

    }

    public Quiz(Long id) {
        super(id);
    }

    public Quiz(String title, User author, String description, int expectedDuration, String tags) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.expectedDuration = expectedDuration;
        this.tags = tags;
        this.questions=new ArrayList<>();
    }

    public Quiz(String title, User author, String description, int expectedDuration, URL picture, String tags) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.questions = new ArrayList<>();
        this.expectedDuration = expectedDuration;
        this.picture = picture;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getExpectedDuration() {
        return expectedDuration;
    }

    public void setExpectedDuration(int expectedDuration) {
        this.expectedDuration = expectedDuration;
    }

    public URL getPicture() {
        return picture;
    }

    public void setPicture(URL picture) {
        this.picture = picture;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(this.title);
        return sb.toString();
    }
}
