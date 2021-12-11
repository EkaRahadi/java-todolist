package view;

import service.TodoListService;
import service.TodoListServiceImpl;
import util.InputUtil;

public class TodoListView {
    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList() {
        while(true) {
            this.todoListService.showTodoList();

            System.out.println("Menu : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = InputUtil.input("Pilihan");

            if(input.equals("1")) {
                addTodoList();
            } else if (input.equals("2")) {
                removeTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public void addTodoList() {
        System.out.println("Add Todo List");
        var todo = InputUtil.input("x For Cancel");
        if(todo.equals("x")) {
            //cancel
        } else {
            this.todoListService.addTodoList(todo);
        }
    }

    public void removeTodoList() {
        System.out.println("Remove Todo List");
        var num = InputUtil.input("Nomor yang akan dihapus (x Jika batal)");

        if(num.equals("x")) {
            //batal
        } else {
           this.todoListService.removeTodoList(Integer.valueOf(num));
        }
    }
}
