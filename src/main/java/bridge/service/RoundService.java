package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.Round;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;

public class RoundService {
    private Round round = new Round(new ArrayList<>());

    public void getMoving() {
        while (true) {
            try {
                OutputView.messageMovingInput();
                round.addMoving(InputView.readMoving());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean compareBridge(Bridge bridge) {
        return bridge.compareByIndex(round.findLastIndex(), round.findLastValue());
    }
}
