package prediction.domain.specification;

import prediction.domain.BattlePrediction;
import prediction.domain.BattleResult;
import specification.AbstractSpecification;

/**
 * Indicates if user hit the exact result of match
 *
 * @author Claudio E. de Oliveira on 22/03/16.
 */
public class FullMatchPrediction extends AbstractSpecification<BattlePrediction> {

    private final BattleResult battleResult;

    public FullMatchPrediction(BattleResult battleResult) {
        this.battleResult = battleResult;
    }

    @Override
    public Boolean isSatisfiedBy(BattlePrediction instance) {
        return this.battleResult.getPlayerOneResult().equals(instance.getPlayerOneResult()) &&
                this.battleResult.getPlayerTwoResult().equals(instance.getPlayerTwoResult());
    }

}
