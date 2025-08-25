package th.mfu;

import java.util.Date;

public class Concert {
  private static long counter = 0;

    private Long id;
    private String title;
    private String performer;
    private String date;
    private String description;

    // Default constructor
    public Concert() {
        this.id = ++counter;
    }

    // Parameterized constructor
    public Concert(String title, String description) {
        this.id = ++counter;
        this.title = title;
        this.description = description;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id){this.id = id;}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getPerformer() { return performer; }
    public void setPerformer(String performer) { this.performer = performer; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

}
