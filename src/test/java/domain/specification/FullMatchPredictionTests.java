package domain.specification;

import domain.Participant;
import org.junit.Test;
import prediction.domain.BattlePrediction;
import prediction.domain.BattleResult;
import prediction.domain.specification.FullMatchPrediction;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Claudio E. de Oliveira on on 25/07/16.
 */
public class FullMatchPredictionTests {

    private final Participant owner  = Participant.builder().id("mary").email("mary@mary").nickname("mary").build();

    private final BattleResult result = BattleResult.builder().playerOneResult("2").playerTwoResult("0").eventId("120").gameId("525").build();

    @Test
    public void wrongFullPrediction(){
        BattlePrediction prediction = BattlePrediction.newBattlePrediction("525","54xn","2","1",this.owner);
        assertFalse(new FullMatchPrediction(this.result).isSatisfiedBy(prediction));
    }

    @Test
    public void correctFullPrediction(){
        BattlePrediction prediction = BattlePrediction.newBattlePrediction("525","54xn","2","0",this.owner);
        assertTrue(new FullMatchPrediction(this.result).isSatisfiedBy(prediction));
    }

}
