package prediction.domain;

import lombok.Builder;
import lombok.Getter;

/**
 * The prediction result
 *
 * @author Claudio E. de Oliveira on 22/03/16.
 */
@Builder(toBuilder = true)
public class PredictionResult {

  @Getter
  private final Integer points;

  @Getter
  private final Boolean correct;

  @Getter
  private final Integer weight;

}
