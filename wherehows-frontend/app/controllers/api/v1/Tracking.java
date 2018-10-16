package controllers.api.v1;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dao.TrackingDAO;
import org.apache.commons.lang3.StringUtils;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;


public class Tracking extends Controller {

  public static Result addTrackingEvent() {
    ObjectNode result = Json.newObject();
    String username = session("user");
    ObjectNode json = Json.newObject();
    ArrayNode res = json.arrayNode();
    JsonNode requestNode = request().body().asJson();

    if (StringUtils.isNotBlank(username)) {
      String message = TrackingDAO.addTrackingEvent(requestNode, username);
      if (StringUtils.isBlank(message)) {
        result.put("status", "success");
        return ok(result);
      } else {
        result.put("status", "failed");
        result.put("message", message);
        return badRequest(result);
      }
    } else {
      result.put("status", "failed");
      result.put("message", "User is not authenticated");
      return unauthorized(result);
    }
  }
}
