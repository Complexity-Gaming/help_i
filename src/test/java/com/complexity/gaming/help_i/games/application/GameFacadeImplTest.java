package com.complexity.gaming.help_i.games.application;

import idgbsdk.apicalypse.APICalypse;
import idgbsdk.model.CoverModel;
import idgbsdk.model.GameModel;
import idgbsdk.model.ScreenshotModel;
import idgbsdk.request.IGDBFacade;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class GameFacadeImplTest {
    private final IGDBFacade facade = new IGDBFacade();

    public GameFacadeImplTest() {
        facade.setCredentials("cg5hbasfqcgsspirqwwy5x69z1l14p", "6bb1vdi2pu14t4sdydzlv8rv986c86");
    }
    @Test
    void testGetCoverByGameIdResponseWithFieldsIdAndGameId() throws Exception {
        APICalypse api = new APICalypse();
        var cover = new CoverModel();
        cover.setId(89412);
        cover.setGame(114795);

        var response = facade.getCovers(api.setFields("game, id").setWhere("id = 89412"));

        Assert.isTrue(response.get(0).getGame() == cover.getGame(), "Cover and response game Id are not equal");
        Assert.isTrue(response.get(0).getId() == cover.getId(), "Cover and response id are not equal");
    }

    @Test
    void testGetGameByIdWithFieldsIdAndName() throws Exception {
        APICalypse api = new APICalypse();
        var game = new GameModel();
        game.setId(114795);
        game.setName("Apex Legends");

        var response = facade.getGames(api.setLimit(1).setWhere("id = 114795").setFields("name, id"));

        Assert.isTrue(response.get(0).getName().equals(game.getName()), "Game and response name are not equal");
        Assert.isTrue(response.get(0).getId() == game.getId(), "Game and response id are not equal");
    }
    @Test
    void testGetScreenshotsBy() throws Exception {
        APICalypse api = new APICalypse();
        var screenshotModel = new ScreenshotModel();
        screenshotModel.setId(320512);
        screenshotModel.setGame(114795);

        var response = facade.getScreenshots(api.setLimit(1).setWhere("id = 320512").setFields("game, id"));

        Assert.isTrue(response.get(0).getGame() == screenshotModel.getGame(), "Screenshot and response game Id are not equal");
        Assert.isTrue(response.get(0).getId() == screenshotModel.getId(), "Screenshot and response id are not equal");
    }
}