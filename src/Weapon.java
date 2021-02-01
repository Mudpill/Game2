import java.util.Random;

public class Weapon {

    String name;
    String elementalModifier;
    String weaponType;
    String damageType;
    private double baseDamage;
    private double attackSpeed;
    double critChance;
    double critDamage;
    int level;

    Random r = new Random();

    public Weapon() {
        elementalModifier = generateElementalModifier();
        weaponType = generateWeaponType();
        damageType = generateDamageType();
        baseDamage = generateBaseDamage(weaponType);
        attackSpeed = generateAttackSpeed(weaponType);
        critChance = generateCritChance(weaponType);
        critDamage = generateCritDamage(weaponType);
        level = 0;
    }

    public Weapon(String unarmed) {
        weaponType = "unarmed strike";
        baseDamage = 0;
    }

    private String generateElementalModifier(){

        String[] baseModifierArray = {"Earth", "Lightning", "Fire", "Water", "Chaos"};
        return baseModifierArray[r.nextInt(5)];
    }

    private String generateWeaponType(){

        String[] weaponTypeArray = {"Axe", "Sword", "Dagger", "Rapier", "Quarterstaff", "Whip", "Mace"};
        return weaponTypeArray[r.nextInt(7)];
    }

    private String generateDamageType(){

        if(this.weaponType.equals("Axe") || this.weaponType.equals("Sword")
                || this.weaponType.equals("Whip")){
            return "Slashing";
        }
        else if(this.weaponType.equals("Dagger") || this.weaponType.equals("Rapier")){
            return "Piercing";
        }
        else {
            return "Bludgeoning";
        }
    }

    private double generateBaseDamage(String weaponType){

        return switch (weaponType) {
            case "Axe" -> 7;
            case "Sword", "Rapier" -> 5;
            case "Dagger", "Whip" -> 3;
            case "Quarterstaff" -> 6;
            case "Mace" -> 8;
            default -> 0;
        };
    }

    private double generateAttackSpeed(String weaponType){

        return switch (weaponType) {
            case "Axe" -> 0.7;
            case "Sword", "Whip" -> 1;
            case "Dagger" -> 1.75;
            case "Rapier" -> 1.25;
            case "Quarterstaff" -> 0.8;
            case "Mace" -> 0.6;
            default -> 0;
        };

    }

    private double generateCritChance(String weaponType){

        double critChance = switch (weaponType) {
            case "Axe", "Quarterstaff", "Mace", "Sword" -> 1;
            case "Dagger" -> 1.5;
            case "Rapier" -> 1.25;
            case "Whip" -> 2;
            default -> 0;
        };

        return critChance * 0.1;
    }

    private double generateCritDamage(String weaponType){

        return switch (weaponType) {
            case "Axe", "Rapier", "Sword", "Quarterstaff", "Mace" -> 2;
            case "Dagger" -> 2.5;
            case "Whip" -> 3;
            default -> 0;
        };
    }

    private void levelModifier(int level){
        this.baseDamage += (2 * level);
        this.critDamage += (0.2 * level);
        this.level = level;
    }

    public String toString(){
        if(!weaponType.equals("unarmed strike")) {
            if (this.level > 0) {
                return weaponType + " of " + elementalModifier + " +" + level;
            } else {
                return weaponType + " of " + elementalModifier;
            }
        }
        else {
            return "unarmed strike";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElementalModifier() {
        return elementalModifier;
    }

    public void setElementalModifier(String elementalModifier) {
        this.elementalModifier = elementalModifier;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public double getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(double baseDamage) {
        this.baseDamage = baseDamage;
    }

    public double getCritChance() {
        return critChance;
    }

    public void setCritChance(double critChance) {
        this.critChance = critChance;
    }

    public double getCritDamage() {
        return critDamage;
    }

    public void setCritDamage(double critDamage) {
        this.critDamage = critDamage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
