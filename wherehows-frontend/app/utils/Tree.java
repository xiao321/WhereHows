package utils;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.File;
import java.io.FileInputStream;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.Play;
import play.libs.Json;


public class Tree {
  public static JsonNode loadTreeJsonNode(String key) {
    if (StringUtils.isNotBlank(key)) {
      String treeName = Play.application().configuration().getString(key);
      if (StringUtils.isNotBlank(treeName)) {
        try {
          return Json.parse(new FileInputStream(new File(treeName)));
        } catch (Exception e) {
          Logger.error(e.getMessage());
        }
      }
    }

    return Json.toJson("");
  }
}
