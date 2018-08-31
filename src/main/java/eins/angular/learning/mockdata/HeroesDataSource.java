package eins.angular.learning.mockdata;

import eins.angular.learning.exception.IllegalIdException;
import eins.angular.learning.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HeroesDataSource {
    private static List<Hero> heroes = new ArrayList<Hero>() {
        {
            add(new Hero(11, "Mr. Nice"));
            add(new Hero(12, "Narco"));
            add(new Hero(13, "Bombasto"));
            add(new Hero(14, "Celeritas"));
            add(new Hero(15, "Magneta"));
            add(new Hero(16, "RubberMan"));
            add(new Hero(17, "Dynama"));
            add(new Hero(18, "Dr IQ"));
            add(new Hero(19, "Magma"));
            add(new Hero(20, "Tornado"));
        }
    };

    public static List<Hero> findAll() {
        return new ArrayList<>(heroes);
    }

    public static Hero findOne(Integer id) {
        if (id == null || id < 1) {
            throw new IllegalIdException();
        }
        return heroes.stream().filter(hero -> hero.getId().equals(id)).findFirst()
                .orElse(null);
    }

    public static void save(Hero hero) {
        validate(hero);
        Hero found = findOne(hero.getId());
        if (found != null) {
            found.setId(hero.getId());
            found.setName(hero.getName());
        } else {
            heroes.add(hero);
        }
    }

    private static void validate(Hero hero) {
        Objects.requireNonNull(hero);
        Objects.requireNonNull(hero.getId());
    }
}
