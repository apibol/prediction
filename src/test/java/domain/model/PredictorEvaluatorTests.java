package domain.model;

import domain.Participant;
import org.junit.Test;
import prediction.domain.BattlePrediction;
import prediction.domain.BattleResult;
import prediction.domain.PredictionEvaluator;

import static org.junit.Assert.assertEquals;

/**
 * @author Claudio E. de Oliveira on on 25/07/16.
 */
public class PredictorEvaluatorTests {

    private final Participant participantOne  = Participant.builder().id("john").email("john@john").nickname("john").build();

    private final Participant participantTwo  = Participant.builder().id("mary").email("mary@mary").nickname("mary").build();

    private final BattleResult winnerResult = BattleResult.builder().playerOneResult("2").playerTwoResult("0").eventId("120").gameId("525").build();

    private final BattleResult tieResult = BattleResult.builder().playerOneResult("0").playerTwoResult("0").eventId("120").gameId("525").build();

    @Test
    public void testFullWinnerPrediction(){
        BattlePrediction prediction = BattlePrediction.newBattlePrediction("525","54xn","2","0",this.participantOne);
        assertEquals(Integer.valueOf(6),new PredictionEvaluator(this.winnerResult).evaluate(prediction));
    }

    @Test
    public void testFullTiePrediction(){
        BattlePrediction prediction = BattlePrediction.newBattlePrediction("525","54xn","0","0",this.participantOne);
        assertEquals(Integer.valueOf(6),new PredictionEvaluator(this.tieResult).evaluate(prediction));
    }

    @Test
    public void testCorrectWinnerPrediction(){
        BattlePrediction prediction = BattlePrediction.newBattlePrediction("525","54xn","2","1",this.participantOne);
        assertEquals(Integer.valueOf(3),new PredictionEvaluator(this.winnerResult).evaluate(prediction));
    }

    @Test
    public void testWrongtWinnerPrediction(){
        BattlePrediction prediction = BattlePrediction.newBattlePrediction("525","54xn","1","2",this.participantOne);
        assertEquals(Integer.valueOf(0),new PredictionEvaluator(this.winnerResult).evaluate(prediction));
    }

    @Test
    public void testTieButWrongGoalsPrediction(){
        BattlePrediction prediction = BattlePrediction.newBattlePrediction("525","54xn","2","2",this.participantOne);
        assertEquals(Integer.valueOf(0),new PredictionEvaluator(this.tieResult).evaluate(prediction));
    }

}
