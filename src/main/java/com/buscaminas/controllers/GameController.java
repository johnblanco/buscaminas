package com.buscaminas.controllers;

import com.buscaminas.entities.Customer;
import com.buscaminas.repositories.CellRepository;
import com.buscaminas.repositories.CustomerRepository;
import com.buscaminas.entities.Cell;
import com.buscaminas.models.CellClicked;
import com.buscaminas.service.Board;
import com.buscaminas.service.MinesweeperBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class GameController {

    @Autowired
    private Board board;

    @Autowired
    private CellRepository cellRepository;

    @GetMapping("/delete")
    public RedirectView delete(Model model) {
        cellRepository.deleteAll();
        return new RedirectView("/");
    }

    @GetMapping("/")
    public String game(Model model) {

        List<Cell> cells = (List<Cell>) cellRepository.findAll();
        if (cells.isEmpty()) {
            cells = board.createCells();
            cells.forEach(c -> cellRepository.save(c));
        }

        model.addAttribute("cells", cells);
        model.addAttribute("cellClicked", new CellClicked());
        return "game";
    }

    @PostMapping("/cellClicked")
    public RedirectView cellClicked(@ModelAttribute CellClicked cellClicked, Model model) {
        cellRepository.findById(cellClicked.getId()).ifPresent(this::updateCellClicked);
        return new RedirectView("/");
    }

    private void updateCellClicked(Cell c){
        c.setVisible(true);
        cellRepository.save(c);
    }

}
