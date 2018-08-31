package eins.angular.learning.controller;

import eins.angular.learning.exception.NotFoundException;
import eins.angular.learning.mockdata.Hero;
import eins.angular.learning.mockdata.HeroesDataSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("${client_cross_origin}")
public class HeroesController {

    @GetMapping("/heroes")
    public ResponseEntity<List<Hero>> getAllHeroes() {
        return new ResponseEntity<>(HeroesDataSource.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/hero/{id}")
    public ResponseEntity<Hero> getHero(@PathVariable Integer id) {
        Hero found = HeroesDataSource.findOne(id);
        if (found == null) {
            throw new NotFoundException(id);
        }
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @PostMapping(value = "/hero/save")
    public ResponseEntity<String> saveHero(@RequestBody Hero hero) {
        HeroesDataSource.save(hero);
        return new ResponseEntity<>("Saved", HttpStatus.OK);
    }

}
