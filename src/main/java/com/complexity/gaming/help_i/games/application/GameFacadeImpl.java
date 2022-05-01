package com.complexity.gaming.help_i.games.application;
import com.complexity.gaming.help_i.games.domain.service.GameFacade;
import com.complexity.gaming.help_i.shared.exception.ResourceNotFoundException;
import idgbsdk.apicalypse.APICalypse;
import idgbsdk.model.GameModel;
import idgbsdk.request.IGDBFacade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GameFacadeImpl implements GameFacade {
    private final IGDBFacade facade = new IGDBFacade();

    public GameFacadeImpl() {
        facade.setCredentials("cg5hbasfqcgsspirqwwy5x69z1l14p", "6bb1vdi2pu14t4sdydzlv8rv986c86");
    }

    @Override
    public Page<GameModel> getAllGames(Pageable pageable, String fields) {
        APICalypse apiCalypse = new APICalypse();
        try {
            var games = facade.getGames(apiCalypse.setWhere("id = (" + fields + ");")
                    .setFields("id, name, cover.*, screenshots.*, storyline, summary;"));
            return new PageImpl<>(games, pageable, games.size());
        }
        catch (Exception e){
            throw new ResourceNotFoundException(e.getMessage());
        }
    }
    @Override
    public GameModel getGameById(int gameId) {
        APICalypse apiCalypse = new APICalypse();
        try {
            return facade.getGames(apiCalypse.setWhere("id = "+ gameId +";")
                    .setFields("id, name, cover.*, screenshots.*, storyline, summary;")).get(0);
        }
        catch (Exception e){
            throw new ResourceNotFoundException(e.getMessage());
        }
    }
}
