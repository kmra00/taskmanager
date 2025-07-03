package cl.kibernumacademy;

import org.junit.jupiter.api.Test;

import cl.kibernumacademy.model.TaskManager;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {
    private TaskManager manager; // Instancia compartida

    // implementacion de beforeEach @BeforeEach
    public void setUp() {
        manager = new TaskManager(); // Se ejecuta ANTES de cada test
    }

    @Test
    public void testAddTask() {
        // TaskManager manager = new TaskManager();
        manager.addTask("Comprar leche", "Ir al supermercado");
        assertEquals(1, manager.getTaskCount());

    }

    @Test
    public void testUpdateTask() {
        // TaskManager manager = new TaskManager();
        manager.addTask("Comprar leche", "Ir al supermercado");
        manager.updateTask(0, "Comprar pan", "Ir a la panadería");
        assertEquals("Comprar pan", manager.getTask(0).getTitle());
        assertEquals("Ir a la panadería", manager.getTask(0).getDescription());
    }

    @Test
    public void testDeleteTask() {
        manager.addTask("eliminar leche", "eliminar Ir al supermercado");
        manager.deleteTask(0);
        assertEquals(0, manager.getTaskCount());
    }

    // prueba casos extremos refactor
    @Test
    public void testAddTaskWithEmptyTitleShouldFail() {
        assertThrows(IllegalArgumentException.class, () -> {
            manager.addTask("", "Descripción vacía");
        });
    }

    @Test
    public void testUpdateNonExistentTask() {
        assertFalse(manager.updateTask(999, "Título", "Descripción"));
    }

}