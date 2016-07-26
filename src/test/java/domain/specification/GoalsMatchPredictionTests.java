package domain.specification;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import domain.Participant;
import prediction.domain.BattlePrediction;
import prediction.domain.BattleResult;
import prediction.domain.specification.GoalsInMatchPrediction;
import prediction.domain.specification.WinnerMatchPrediction;

/**
 * The goals match predictions unit tests
 *
 * @author Claudio E. de Oliveira on on 25/07/16.
 */
public class GoalsMatchPredictionTests {

    private final Participant owner  = Participant.builder().id("mary").email("mary@mary").nickname("mary").build();

    private final BattleResult result = BattleResult.builder().playerOneResult("2").playerTwoResult("0").eventId("120").gameId("525").build();

    @Test
    public void wrongGoalsPrediction(){
        BattlePrediction prediction = BattlePrediction.newBattlePrediction("525","54xn","1","2",this.owner);
        assertFalse(new GoalsInMatchPrediction(this.result).isSatisfiedBy(prediction));
    }

    @Test
    public void correctOneGoalPrediction(){
        BattlePrediction prediction = BattlePrediction.newBattlePrediction("525","54xn","3","0",this.owner);
        assertTrue(new GoalsInMatchPrediction(this.result).isSatisfiedBy(prediction));
    }

    @Test
    public void correctTwoGoalPrediction(){
        BattlePrediction prediction = BattlePrediction.newBattlePrediction("525","54xn","2","0",this.owner);
        assertTrue(new GoalsInMatchPrediction(this.result).isSatisfiedBy(prediction));
    }

    @Test
    public void tiePrediction(){
        BattlePrediction prediction = BattlePrediction.newBattlePrediction("525","54xn","0","0",this.owner);
        assertTrue(new GoalsInMatchPrediction(this.result).isSatisfiedBy(prediction));
    }

}
