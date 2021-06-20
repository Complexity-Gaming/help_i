package com.complexity.gaming.help_i.games.interfaces.rest;

import com.complexity.gaming.help_i.games.domain.model.aggregate.GameModel;
import com.complexity.gaming.help_i.games.domain.model.valueobjects.ProviderInformation;
import com.complexity.gaming.help_i.games.domain.service.GameService;
import com.complexity.gaming.help_i.security.application.transform.resource.PlayerResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class GamesController {
    private final GameService gameService;
    List<GameModel> games;

    public GamesController(GameService gameService) {
        this.gameService = gameService;
        this.games = new ArrayList<>();
        games.add(new GameModel().setId(1L).setProviderId(1L)
        .SetProviderInformation(new ProviderInformation("Counter-Strike: Global Offensiv",
                "//images.igdb.com/igdb/image/upload/t_1080p/co1vce.jpg",
                2000,1500, null, "CS:GO is the fourth iteration of Valve's " +
                "team-based modern-military first-person shooter that features new and updated versions of the classic" +
                " CS content. While expanding the franchise, the game also introduces new gameplay modes, matchmaking" +
                " and leader boards."
                )));
        games.add(new GameModel().setId(2L).setProviderId(2L)
                .SetProviderInformation(new ProviderInformation("Dota 2",
                        "//images.igdb.com/igdb/image/upload/t_1080p/co1y5n.jpg",
                        1600,1200, "Each match of Dota 2 involves two teams, both containing " +
                        "five players and occupying a fortified stronghold at either end of the map. Victory is " +
                        "achieved by destroying the enemy's Ancient, a building that is invulnerable until certain " +
                        "objectives are achieved. Each player controls a \"Hero\" character and focuses on leveling up," +
                        " acquiring items and fighting against the other team to achieve victory during each match.",
                        "Dota 2 is a multiplayer online battle arena video game and the stand-alone sequel to " +
                                "the Defense of the Ancients (DotA) mod. With regular updates that ensure a constant " +
                                "evolution of gameplay, features, and heroes, Dota 2 has taken on a life of its own."
                )));
        games.add(new GameModel().setId(3L).setProviderId(3L)
                .SetProviderInformation(new ProviderInformation("Apex Legends",
                        "//images.igdb.com/igdb/image/upload/t_1080p/co1wzo.jpg",
                        2427,1820, "A WORLD WHERE ANYTHING GOES\\n\\nThe Frontier War is over. After hundreds of years of conflict between the Interstellar Manufacturing Corporation and the Militia founded to fight them, the far-off region of space known as the Frontier can finally know peace.\\n\\nBut liberation can come at a cost: when the IMC and the Militia departed, they took everything of value and left the Frontier worlds in disarray. With no way to support themselves, the people of the Frontier had no choice but to leave their homes. The brave relocated to the Outlands.\\n\\nA remote cluster of planets on the fringes of the Frontier, the Outlands are untouched by war and teeming with resources and opportunity. But life is cheap here, and danger lurks around every corner. Its pioneers, explorers, and outlaws used to spend their lives locked in an endless power struggle – now, they settle their differences in the Apex Games, a bloodsport where Legends from all corners of the Frontier compete for money, fame, and glory.",
                        "Conquer with character in Apex Legends, a free-to-play battle royale game where legendary challengers fight for glory, fame, and fortune on the fringes of the Frontier. Explore a growing roster of diverse characters and experience intense tactical squad play in a bold, new evolution of battle royale."
                )));
        games.add(new GameModel().setId(4L).setProviderId(4L)
                .SetProviderInformation(new ProviderInformation("Call of Duty: Warzone",
                        "//images.igdb.com/igdb/image/upload/t_1080p/co1wzo.jpg",
                        2427,1820, null
                        ,"Welcome to Warzone, the new massive free-to-play combat arena from the world of Modern Warfare®. Drop in, armor up, loot for rewards, and battle your way to the top."
                )));
    }


    @GetMapping("/games")
    public Page<GameModel> getAllGames(Pageable pageable){
        return new PageImpl<>(this.games, pageable, this.games.size());
    }
    @GetMapping("/games/{id}")
    public GameModel getGameById(@PathVariable(name = "id") Long gameId){
        return (GameModel) this.games.stream().filter(g -> g.getId() == gameId).collect(Collectors.toList()).get(0);
    }
}
