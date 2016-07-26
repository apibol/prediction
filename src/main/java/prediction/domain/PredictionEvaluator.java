package prediction.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import prediction.domain.factory.PredictionResultFactory;
import prediction.domain.specification.FullMatchPrediction;
import prediction.domain.specification.GoalsInMatchPrediction;
import prediction.domain.specification.WinnerMatchPrediction;

/**
 * Evaluate the prediction
 *
 * @author Claudio E. de Oliveira on 22/03/16.
 */
public class PredictionEvaluator {

    private final FullMatchPrediction fullMatchPrediction;

    private final WinnerMatchPrediction winnerMatchPrediction;

    private final GoalsInMatchPrediction goalsInMatchPrediction;

    private List<PredictionResult> results = new ArrayList<>();

    public PredictionEvaluator(BattleResult battleResult) {
        this.fullMatchPrediction = new FullMatchPrediction(battleResult);
        this.winnerMatchPrediction = new WinnerMatchPrediction(battleResult);
        this.goalsInMatchPrediction = new GoalsInMatchPrediction(battleResult);
    }

    /**
     * Evaluate the battle prediction
     *
     * @param battlePrediction - the battle prediction
     *
     * @return - points earned
     */
    public Integer evaluate(BattlePrediction battlePrediction) {
        this.results.add(PredictionResultFactory.wrongMatchPredictionResult());
        this.results.add(PredictionResultFactory.newFullMatchPredictionResult(this.fullMatchPrediction.isSatisfiedBy(battlePrediction)));
        this.results.add(PredictionResultFactory.newWinnerMatchPredictionResult(this.winnerMatchPrediction.isSatisfiedBy(battlePrediction)));
        this.results.add(PredictionResultFactory.newGoalMatchPredictionResult(this.goalsInMatchPrediction.isSatisfiedBy(battlePrediction)));
        final List<PredictionResult> values = this.results.stream().sorted((el1, el2) -> el2.getWeight().compareTo(el1.getPoints())).collect(Collectors.toList());
        return values.stream().filter(PredictionResult::getCorrect).findFirst().get().getPoints();
    }

}
