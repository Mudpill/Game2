public class Monster extends Entity{

    private int level;
    private int experiencePoints;

    public Monster(int i) {
        name = generateMonsterType(i);
        damageValue = initialDamageValue(name);
        attackSpeed = initialAttackSpeed(name);
        healthValue = initialHealthValue(name);
        mainWeapon  = initialWeapon();
    }

    private String generateMonsterType(int i){
        String[] monsterTypeArray = {"Orc", "Skeleton", "Zombie", "Vampire", "Bandit"};
        return monsterTypeArray[i];
    }

    private double initialDamageValue(String monsterType){
        return switch(monsterType) {
            case "Orc" -> 8;
            case "Skeleton" -> 6;
            case "Zombie" -> 5;
            case "Vampire" -> 7;
            case "Bandit" -> 4;
            default -> 0;
        };
    }

    private double initialHealthValue(String monsterType){
        return switch(monsterType) {
            case "Orc" -> 18;
            case "Skeleton" -> 10;
            case "Zombie", "Bandit" -> 9;
            case "Vampire" -> 15;
            default -> 0;
        };
    }

    private double initialAttackSpeed(String monsterType){
        return switch(monsterType) {
            case "Orc" -> 0.7;
            case "Skeleton", "Zombie" -> 1;
            case "Bandit" -> 1.5;
            case "Vampire" -> 0.8;
            default -> 0;
        };
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDamageValue() {
        return damageValue;
    }

    public void setDamageValue(double damageValue) {
        this.damageValue = damageValue;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public double getHealthValue() {
        return healthValue;
    }

    public void setHealthValue(double healthValue) {
        this.healthValue = healthValue;
    }

    public Weapon getMainWeapon() {
        return mainWeapon;
    }

    public void setMainWeapon(Weapon mainWeapon) {
        this.mainWeapon = mainWeapon;
    }
}
