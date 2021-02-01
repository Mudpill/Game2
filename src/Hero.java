public class Hero extends Entity{

    public Hero() {
        name = "Dylan";
        damageValue = 5;
        attackSpeed = 1;
        healthValue = 50;
        mainWeapon  = initialWeapon();
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
