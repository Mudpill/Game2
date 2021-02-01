import java.util.Random;

public abstract class Entity {

    String name;
    double damageValue;
    double attackSpeed;
    double healthValue;
    Weapon mainWeapon;

    final private Random r = new Random();

    public Weapon initialWeapon(){
        Random r = new Random();
        if(r.nextInt(10) > 3){
            return new Weapon();
        }
        else{
            return new Weapon("unarmed");
        }
    }

    private double damageValueWithWeapon() {
        return this.damageValue + this.mainWeapon.getBaseDamage();
    }

    private double attackSpeedWithWeapon() {
        return attackSpeed + mainWeapon.getAttackSpeed();
    }

    private double critDamage() {
        return (mainWeapon.getBaseDamage() * mainWeapon.getCritDamage()) + damageValue;
    }

   public void attack(Entity e) {
       if(this.getClass().getSimpleName().equals("Hero")) {
           if (r.nextInt(100) >= 100 - (10 * mainWeapon.getCritChance())) {
               System.out.println("You critically strike the " + e.name + " for " + critDamage());
               e.updateHealth(critDamage());
           }
           else {
               System.out.println("You attack the " + e.name + " for " + damageValueWithWeapon());
               e.updateHealth(damageValueWithWeapon());
           }
       }
       else {
           if (r.nextInt(100) >= 100 - (10 * mainWeapon.getCritChance())) {
               System.out.println(this.name + " critically strikes you for " + critDamage() + " with its " + mainWeapon.toString() + "!");
               e.updateHealth(critDamage());
           } else {
               System.out.println(this.name + " attacks you for " + damageValueWithWeapon() + " with its " + mainWeapon.toString() + "!");
               e.updateHealth(damageValueWithWeapon());
           }
       }
    }

    public void whoAttacksFirst(Entity enemy) {
        if (attackSpeedWithWeapon() == enemy.attackSpeedWithWeapon()) {
            if (r.nextInt(2) == 0) {
                System.out.println("You attack first!");
                attack(enemy);
                if(enemy.healthValue > 0) {
                    enemy.attack(this);
                }
            } else {
                System.out.println("The " + enemy.name + " attacks first!");
                enemy.attack(this);
                if(healthValue > 0) {
                    attack(enemy);
                }
            }
        } else if (attackSpeedWithWeapon() > enemy.attackSpeedWithWeapon()) {
            System.out.println("You attack first!");
            attack(enemy);
            if(enemy.healthValue > 0) {
                enemy.attack(this);
            }
        }

        else {
            System.out.println("The " + enemy.name + " attacks first!");
            enemy.attack(this);
            if(healthValue > 0) {
                attack(enemy);
            }
        }
    }

    public void updateHealth(double damage) {
        if(this.getClass().getTypeName().equals("Hero")) {
            if(this.healthValue - damage <= 0){
                deathAnimation();
            }
            else {
                this.healthValue -= damage;
                System.out.println("Current HP: " + healthValue);
            }
        }
        else {
            if(this.healthValue - damage <= 0){
                deathAnimation();
            }
            else {
                this.healthValue -= damage;
                System.out.println(name + "'s HP: " + healthValue);
            }
        }
    }

    private void deathAnimation() {
        if (this.getClass().getTypeName().equals("Hero")) {
            this.healthValue = 0;
            System.out.println("You died!");
        }
        else {
            this.healthValue = 0;
            System.out.println("You killed " + name + "!");
        }
    }
}
