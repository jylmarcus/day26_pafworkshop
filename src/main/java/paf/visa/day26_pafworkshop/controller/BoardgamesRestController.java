package paf.visa.day26_pafworkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import paf.visa.day26_pafworkshop.service.BoardgamesService;

@RestController
@RequestMapping("/api/games")
@CrossOrigin(origins="*")
public class BoardgamesRestController {
    
    @Autowired
    private BoardgamesService boardgamesService;

    @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public String findGamesWithLimitOffset(@RequestParam(name="limit", required=false) Integer limit, @RequestParam(name="offset", required=false) Integer offset) {
        limit = limit == null? 5 : limit;
        offset = offset == null? 0: offset;
        return boardgamesService.findGamesWithLimitOffset(limit, offset).toString();
    }

    @GetMapping(path="/rank", produces = MediaType.APPLICATION_JSON_VALUE)
    public String findGamesByRankWithLimitOffset(@RequestParam(name="limit", required=false) Integer limit, @RequestParam(name="offset", required=false) Integer offset) {
        return boardgamesService.findGamesByRankingWithLimitOffset(limit,offset).toString();
    }

    @GetMapping(path="/{game_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String findGameById(@PathVariable Integer gameId) {
        return boardgamesService.findGameById(gameId);
    }
}
