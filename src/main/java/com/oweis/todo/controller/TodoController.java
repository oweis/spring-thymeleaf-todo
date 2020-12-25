package com.oweis.todo.controller;

import com.oweis.todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.oweis.todo.repository.TodoRepository;

@Controller
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @GetMapping("/")
    public String index(Todo todo, BindingResult result,Model model){
        model.addAttribute("todoList", todoRepository.findByIsDoneFalse());
        model.addAttribute("doneList", todoRepository.findByIsDoneTrue());
        return "index";
    }

    @PostMapping("/addtodo")
    public String addTodo(Todo todo, BindingResult result, Model model) {
        todoRepository.save(todo);
        return "redirect:/";
    }

    @GetMapping("/todo/{id}/markdone")
    public String markdoneTodo(@PathVariable("id") long id, Model model) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid todo Id:" + id));
        todo.setDone(true);
        todoRepository.save(todo);
        return "redirect:/";
    }

    @GetMapping("/todo/{id}/marktodo")
    public String marktodoTodo(@PathVariable("id") long id, Model model) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid todo Id:" + id));
        todo.setDone(false);
        todoRepository.save(todo);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable("id") long id, Model model) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid todo Id:" + id));
        todoRepository.delete(todo);
        return "redirect:/";
    }
}