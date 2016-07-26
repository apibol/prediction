package prediction.domain.factory;

import prediction.domain.PredictionResult;

/**
 * The prediction result factory
 * 
 * Created by claudio on 26/07/16.
 */
public class PredictionResultFactory {

  /**
   * Full match prediction result
   *
   * @param correct
   * @return
   */
  public static PredictionResult newFullMatchPredictionResult(Boolean correct) {
    return PredictionResult.builder().points(30).correct(correct).weight(50).build();
  }

  /**
   * Winner match prediction result
   *
   * @param correct
   * @return
   */
  public static PredictionResult newWinnerMatchPredictionResult(Boolean correct) {
    return PredictionResult.builder().points(15).correct(correct).weight(40).build();
  }

  /**
   * Goal match prediction result
   *
   * @param correct
   * @return
   */
  public static PredictionResult newGoalMatchPredictionResult(Boolean correct) {
    return PredictionResult.builder().points(5).correct(correct).weight(20).build();
  }

  /**
   * Wrong prediction result
   *
   * @return
   */
  public static PredictionResult wrongMatchPredictionResult() {
    return PredictionResult.builder().points(0).correct(Boolean.TRUE).weight(0).build();
  }

}
