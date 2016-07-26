package domain.model;

import domain.Participant;
import domain.SystemUser;
import org.junit.Test;
import prediction.domain.Predictor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Claudio E. de Oliveira on on 25/07/16.
 */
public class PredictorTests {

    private final Participant participantOne  = Participant.builder().id("john").email("john@john").nickname("john").build();

    private final Participant participantTwo  = Participant.builder().id("mary").email("mary@mary").nickname("mary").build();

    private final Participant participantThree  = Participant.builder().id("nick").email("nick@nick").nickname("nick").build();

    @Test
    public void testAddParticipant(){
        Predictor predictor = Predictor.builder().id("da39a3ee5e6b4b0d3255bfef95601890afd80709").eventId("d41d8cd98f00b204e9800998ecf8427e").build();
        predictor.addParticipant(this.participantOne);
        assertTrue(predictor.getParticipants().size() == 1);
    }

    @Test
    public void testParticipantInPredictor(){
        Predictor predictor = Predictor.builder().id("da39a3ee5e6b4b0d3255bfef95601890afd80709").eventId("d41d8cd98f00b204e9800998ecf8427e").build();
        predictor.addParticipant(this.participantOne);
        final SystemUser systemUser = SystemUser.builder().id(this.participantOne.getId()).email(this.participantOne.getEmail()).nickname(this.participantOne.getNickname()).build();
        assertTrue(predictor.isParticipant(systemUser));
    }

    @Test
    public void testParticipantIsNotInPredictor(){
        Predictor predictor = Predictor.builder().id("da39a3ee5e6b4b0d3255bfef95601890afd80709").eventId("d41d8cd98f00b204e9800998ecf8427e").build();
        predictor.addParticipant(this.participantOne);
        final SystemUser systemUser = SystemUser.builder().id(this.participantTwo.getId()).email(this.participantTwo.getEmail()).nickname(this.participantTwo.getNickname()).build();
        assertFalse(predictor.isParticipant(systemUser));
    }

}
