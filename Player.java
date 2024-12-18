public class Player {
    public String name;
    public int hp;
    public int attackPower;
    public int defense;
    public int score;
    public int level;
    public int xp;
    public int stamina;

    public Player(String name) {
        this.name = name;
        this.hp = 200;
        this.attackPower = 40;
        this.defense = 20;
        this.score = 0;
        this.level = 1;
        this.xp = 0;
        this.stamina = 5; 
    }

    public int attack() {
        return attackPower;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        System.out.println(name + " terkena damage " + damage + ", HP sekarang: " + hp);
    }

    public void gainXP(int amount) {
        xp += amount;
        System.out.println(name + " mendapatkan " + amount + " XP.");
        if (xp >= 50 * level) {
            levelUp();
        }
    }

    private void levelUp() {
        level++;
        attackPower += 10;
        defense += 5;
        hp += 50;
        stamina += 2;
        xp = 0;
        System.out.println("\nSelamat! " + name + " naik ke level " + level + "!");
    }

    public void decreaseStamina() {
        if (stamina > 0) {
            stamina--;
            System.out.println(name + " menggunakan stamina. Stamina tersisa: " + stamina);
        } else {
            System.out.println(name + " kelelahan! Tidak bisa menyelesaikan quest tanpa stamina.");
        }
    }

    public void rest() {
        stamina = Math.min(stamina + 2, 5);
        System.out.println(name + " beristirahat dan mengembalikan stamina menjadi: " + stamina);
    }

    public void completeQuest() {
        System.out.println(name + " menyelesaikan quest! Skor bertambah 10.");
        score += 10;
    }

    public void defend() {
        int reducedDamage = defense + 10; // Meningkatkan pertahanan untuk 1 giliran
        System.out.println(name + " bertahan! Pertahanan meningkat sementara menjadi: " + reducedDamage);
    }
}
