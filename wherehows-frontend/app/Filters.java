import javax.inject.Inject;
import play.api.mvc.EssentialFilter;
import play.filters.gzip.GzipFilter;
import play.http.HttpFilters;


public class Filters implements HttpFilters {

  @Inject
  GzipFilter gzipFilter;

  public EssentialFilter[] filters() {
    return new EssentialFilter[] { gzipFilter };
  }
}