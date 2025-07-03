package cl.kibernumacademy.model;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    // Lista de tareas ahora es inmutable (final)
    private final List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();

    }

    public void addTask(String title, String description) {
        Task newTask = new Task(title, description);
        tasks.add(newTask);
    }

    /*
     * public void updateTask(int index, String title, String description) {
     * if (index >= 0 && index < tasks.size()) {
     * Task task = tasks.get(index);
     * task.setTitle(title);
     * task.setDescription(description);
     * }
     * }
     */

    // Refactor de updateTask
    private boolean isValidIndex(int index) {
        return index >= 0 && index < tasks.size();
    }

    public boolean updateTask(int index, String newTitle, String newDescription) {
        if (isValidIndex(index)) {
            // Crear nueva tarea directamente sin obtener la anterior
            tasks.set(index, new Task(newTitle, newDescription));
            return true;
        }
        return false;
    }
    

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public Task getTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            return tasks.get(index);
        }
        return null;
    }

    public int getTaskCount() {
        return tasks.size();
    }

}
