package framework.game;

import framework.player.Player;

import java.time.LocalDateTime;

public class CachedGameScoreProxy implements GameScoreCalculator {

    private int cached_score;

    private LocalDateTime cached_time;

    private Game game;

    public CachedGameScoreProxy(Game game) {
        this.game = game;

        this.cached_time = LocalDateTime.now();
    }


    @Override
    public int calculateGameScore(Player player) {

        if (cached_time.isBefore(LocalDateTime.now().minusSeconds(10))) {
            cached_score = game.calculateGameScore(player);
            cached_time = LocalDateTime.now();
        }

        return cached_score;

    }
}
