package utils;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import wherehows.models.table.LineagePathInfo;


public class Lineage {

  public static final String URNIDMAPKey = "impactUrnIDMap";

  public static LineagePathInfo convertFromURN(String urn) {
    if (StringUtils.isBlank(urn)) {
      return null;
    }

    LineagePathInfo pathInfo = new LineagePathInfo();

    String[] pathArray = urn.split(":///");
    if (pathArray != null && pathArray.length > 0) {
      String storageType = pathArray[0];
      pathInfo.storageType = storageType;
      if (StringUtils.isNotBlank(storageType)) {
        if (pathArray.length > 1 && StringUtils.isNotBlank(pathArray[1])) {
          pathInfo.filePath = "/" + pathArray[1];
        } else {
          pathInfo.storageType = null;
          pathInfo.schemaName = null;
          pathInfo.filePath = urn;
        }
      } else {
        pathInfo.storageType = null;
        pathInfo.schemaName = null;
        pathInfo.filePath = urn;
      }
    }

    return pathInfo;
  }

  public static String convertToURN(LineagePathInfo pathInfo) {
    if (pathInfo == null) {
      return null;
    }

    String filePath = "";
    if (StringUtils.isNotBlank(pathInfo.filePath)) {
      if (pathInfo.filePath.charAt(0) == '/') {
        filePath = pathInfo.filePath.substring(1);
      } else {
        filePath = pathInfo.filePath;
      }
    }
    return pathInfo.storageType.toLowerCase() + ":///" + filePath;
  }

  public static boolean isInList(List<String> list, String source) {
    if (list == null || list.size() == 0 || StringUtils.isBlank(source)) {
      return false;
    }
    for (String s : list) {
      if (source.equalsIgnoreCase(s)) {
        return true;
      }
    }
    return false;
  }
}
