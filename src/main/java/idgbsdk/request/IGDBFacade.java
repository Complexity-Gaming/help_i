package idgbsdk.request;

import idgbsdk.apicalypse.APICalypse;
import idgbsdk.model.CoverModel;
import idgbsdk.model.GameModel;
import idgbsdk.model.ScreenshotModel;
import idgbsdk.util.Endpoint;
import idgbsdk.util.Endpoints;
import idgbsdk.util.Json;
import com.fasterxml.jackson.core.type.TypeReference;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class IGDBFacade {
    private static final String IGDB_API_URL = "https://api.igdb.com/v4";
    private String clientId;
    private String auth;

    public void setCredentials(String clientId, String accessToken){
        this.clientId = clientId;
        this.auth = accessToken;
    }
    private String apiJsonRequest(Endpoint endpoint, String query) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(query))
                .header("client-id", clientId)
                .header("authorization", "Bearer " + auth)
                .header("x-user-agent", "igdb-api-jvm")
                .uri(URI.create(IGDB_API_URL + endpoint.url()))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public List<CoverModel> getCovers(APICalypse apiCalypse) throws Exception {
        var response = apiJsonRequest(Endpoints.COVERS, apiCalypse.buildQuery());
        var typeRef = new TypeReference<List<CoverModel>>() {};
        return Json.getInstance().readValue(response, typeRef);
    }
    public List<GameModel> getGames(APICalypse apiCalypse) throws Exception {
        var response = apiJsonRequest(Endpoints.GAMES, apiCalypse.buildQuery());
        var typeRef = new TypeReference<List<GameModel>>() {};
        return Json.getInstance().readValue(response, typeRef);
    }
    public List<ScreenshotModel> getScreenshots(APICalypse apiCalypse) throws Exception {
        var response = apiJsonRequest(Endpoints.SCREENSHOTS, apiCalypse.buildQuery());
        var typeRef = new TypeReference<List<ScreenshotModel>>() {};
        return Json.getInstance().readValue(response, typeRef);
    }
}
