package prediction.domain;

import domain.Participant;
import domain.SystemUser;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Claudio E. de Oliveira on 19/03/16.
 */
@Data
@Builder(toBuilder = true)
public class Predictor {

  private String id;

  private String eventId;

  private Set<Participant> participants = new HashSet<>();

  @Tolerate
  Predictor() {}

  /**
   * Indicates if user is predictor participant
   *
   * @param systemUser
   * @return
   */
  public boolean isParticipant(SystemUser systemUser) {
    return this.participants.stream()
        .anyMatch(el -> el.getNickname().equals(systemUser.getNickname()));
  }

  /**
   * Add participant in predictor
   * 
   * @param participant
   * @return
   */
  public Predictor addParticipant(Participant participant) {
    if (Objects.isNull(this.participants)) {
      this.participants = new HashSet<>();
    }
    this.participants.add(participant);
    return this;
  }

}
