package repository;

import entity.TodoList;

public interface TodoListRepository {
    TodoList[] getAllTodo();
    void addTodo(TodoList todo);
    boolean deleteTodo(Integer number);
}
