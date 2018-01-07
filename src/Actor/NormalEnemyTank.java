package Actor;
import Main.*;
import Util.EnemyManager;

public class NormalEnemyTank extends EnemyTank {
    public NormalEnemyTank(Scene scene, int x, int y, Actor searchTank, Actor Heart, EnemyManager enemyManager) {
        super(new String[] {
                "img/enemy/normal_enemy_01.png",
                "img/enemy/normal_enemy_02.png",
                "img/enemy/normal_enemy_03.png",
                "img/enemy/normal_enemy_04.png",
        }, scene, x, y, searchTank, Heart, enemyManager);
        this.setWidth(28);
        this.setHeight(28);
    }
}
