package me.david.werwolf.game.states;

import me.david.werwolf.game.Game;
import me.david.werwolf.game.Roles;
import me.david.werwolf.task.RunLaterTask;
import me.david.werwolf.task.TaskManager;

public class VillageUpState extends GameState {

    private static final long VILLAGE_DELAY = 15000;

    private boolean rubber;

    public VillageUpState(boolean rubber) {
        super("Village Up");
        this.rubber = rubber;
    }

    @Override
    public void onEnable(Game game) {
        game.setRound(game.getRound() + 1);
        TaskManager.getInstance().registerTask(new RunLaterTask(true, () -> {
            if (!rubber && game.getSingleRolePlayers().containsKey(Roles.ARMOR) && game.isFirstRound()) {
                game.switchState(new ArmorPickState());
                return;
            }
            if (!rubber && game.getSingleRolePlayers().containsKey(Roles.DIEB)) {
                game.switchState(new RuberState());
                return;
            }
            game.switchState(new WerWolfState());
        }, VILLAGE_DELAY));
    }

    @Override
    public void onDisable(Game game) {

    }
}
