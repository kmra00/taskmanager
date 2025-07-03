package cl.kibernumacademy;

import org.junit.jupiter.api.Test;

import cl.kibernumacademy.model.TaskManager;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {
    @Test
    public void testAddTask() {
        TaskManager manager = new TaskManager();
        manager.addTask("Comprar leche", "Ir al supermercado");
        assertEquals(1, manager.getTaskCount());

    }

    @Test
    public void testUpdateTask() {
        TaskManager manager = new TaskManager();
        manager.addTask("Comprar leche", "Ir al supermercado");
        manager.updateTask(0, "Comprar pan", "Ir a la panadería");
        assertEquals("Comprar pan", manager.getTask(0).getTitle());
        assertEquals("Ir a la panadería", manager.getTask(0).getDescription());
    }

    @Test
    public void testDeleteTask() {
        TaskManager manager = new TaskManager();
        manager.addTask("eliminar leche", "eliminar Ir al supermercado");
        manager.deleteTask(0);
        assertEquals(0, manager.getTaskCount());
    }
}