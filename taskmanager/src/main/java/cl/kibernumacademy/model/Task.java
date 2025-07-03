package cl.kibernumacademy.model;

import java.util.Objects;

public class Task {

    // refactor con final y se quita el setter de title
    private final String title;
    private String description;

    /*
     * public Task(String title, String description) {
     * this.title = title;
     * this.description = description;
     * }
     */
    // refactor de Task
    public Task(String title, String description) {
        this.title = Objects.requireNonNull(title, "El titulo no puede ser nulo");
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // refactor toString
    @Override
    public String toString() {
        return "Tarea: " + title + " - " + description;
    }

    // refactor equals y hashCode para comparaciones
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Task task = (Task) o;
        return title.equals(task.title) &&
                Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description);
    }

}
