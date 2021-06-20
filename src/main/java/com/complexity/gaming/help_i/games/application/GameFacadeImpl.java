/*
package com.complexity.gaming.help_i.games.application;

import com.api.igdb.apicalypse.APICalypse;
import com.api.igdb.exceptions.RequestException;
import com.api.igdb.request.IGDBWrapper;
import com.api.igdb.request.ProtoRequestKt;
import com.complexity.gaming.help_i.games.domain.service.GameFacade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import proto.Game;

import java.util.List;

@Service
public class GameFacadeImpl implements GameFacade {
    private final String CLIENT_ID = "ov3od6hqyjyb0iurx0hbbvp6ijde7v";
    private final String ACCESS_TOKEN = "7jtzb99a7qf3yplg6m0jvst5d5wbp1";
    private final IGDBWrapper wrapper;

    public GameFacadeImpl() {
        wrapper = IGDBWrapper.INSTANCE;
        wrapper.setCredentials(CLIENT_ID, ACCESS_TOKEN);
    }
    @Override
    public Page<Game> getAllGames(Pageable pageable) {

        APICalypse apicalypse = new APICalypse().fields("*, cover.*").where("id = (2963,114795,131800,1372)");
        try{
            List<Game> games = ProtoRequestKt.games(wrapper, apicalypse);
            return new PageImpl<>(games, pageable, games.size());
        } catch(RequestException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Game getGameById(Long gameId) {
        APICalypse apicalypse = new APICalypse().fields("*, cover.*").where(String.format("id = %s", gameId));
        try{
            List<Game> games = ProtoRequestKt.games(wrapper, apicalypse);
            return games.get(0);
        } catch(RequestException e) {
            throw new RuntimeException(e);
        }
    }
}
*/
