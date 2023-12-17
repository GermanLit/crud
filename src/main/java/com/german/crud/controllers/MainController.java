package com.german.crud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // это главный класс, который отвечает за обработку всех переходов на сайте
public class MainController {

    @GetMapping("/") //выбран url адресс, который обрабатывается (при переходе на адрес, будет вызываться функция ниже)
    public String home(Model model) { //тут передаётся обязательный параметр (этот параметр всегда принимается)
        model.addAttribute("title", "Главная");//припомощи параметра model, указываем какие данные передаём в шаблон
        return "home"; //тут вызываем шаблон с названием home
    }

    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }

}