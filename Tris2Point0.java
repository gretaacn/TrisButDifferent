package com.example.springTest.tris;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Tris2Point0 {

    private Tris tris;

    //Metodi
    @GetMapping("/new")
    public String getNewTris(){
        this.tris = new Tris();
        return tris.toString();
    }

    @GetMapping("/{c}/{row}/{col}")
    public String move(@PathVariable char c, @PathVariable int row, @PathVariable int col ){
        if(!tris.isGameOver()){
            tris.mossa(row, col, c);

            if(tris.didYouWin(tris.getMatrice(), row, col, c)){
                return "Ha vinto " + c + "!\n" + tris.toString();
            }

            if(tris.isGameOver(tris.getMatrice())){
                return "Game over! \n" + tris.toString();
            }
        }
        return tris.toString();
    }

    @GetMapping("/move")
    public String mosse(@RequestParam int row, @RequestParam int col, @RequestParam char c){
        if(!tris.isGameOver()){
            tris.mossa(row, col, c);

            if(tris.didYouWin(tris.getMatrice(), row, col, c)){
                return "Ha vinto " + c + "!\n" + tris.toString();
            }

            if(tris.isGameOver(tris.getMatrice())){
                return "Game over! \n" + tris.toString();
            }
        }
        return tris.toString();
    }

}
