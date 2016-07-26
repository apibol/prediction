package prediction.domain;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.Tolerate;

/**
 * Battle result model
 *
 * @author Claudio E. de Oliveira on 22/03/16.
 */
@Data
@Builder(toBuilder = true)
public class BattleResult {

    private String eventId;

    private String gameId;
    
    private String playerOneResult;

    private String playerTwoResult;

    @Tolerate
    BattleResult(){}
    
}
