package repository;

import entity.TodoList;

public class TodoListRepositoryImpl implements TodoListRepository {
    private TodoList[] data = new TodoList[10];

    @Override
    public TodoList[] getAllTodo() {
        return data;
    }

    @Override
    public void addTodo(TodoList todo) {
        resizeIfFull();

        //Add todo to index value null
        for(var i=0; i< data.length; i++) {
            if(data[i] == null) {
                data[i] = todo;
                break;
            }
        }
    }

    @Override
    public boolean deleteTodo(Integer number) {
        if ((number - 1) >= data.length) {
            return false;
        } else if (data[number-1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < data.length; i++) {
                if (i == (data.length - 1)) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }

    private boolean isFull() {
        var isFull = true;
        //Check if array is full
        for (var i=0; i< data.length; i++) {
            if (data[i] == null) {
                isFull = false;
                break;
            }
        }

        return isFull;
    }

    private void resizeIfFull() {
        // Resize array
        if(isFull()) {
            var temp = data;
            data = new TodoList[data.length * 2];
            for (var i=0; i< temp.length; i++) {
                data[i] = temp[i];
            }
        }
    }
}
