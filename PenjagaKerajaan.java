public class PenjagaKerajaan {
    public String nama;
    public int HP;
    public int attack;
    public int defense;

    public PenjagaKerajaan(String nama, int HP, int attack, int defense) {
        this.nama = nama;
        this.HP = HP;
        this.attack = attack;
        this.defense = defense;
    }

    public void tampilkanStatus() {
        System.out.println("Penjaga: " + nama);
        System.out.println("HP: " + HP);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
    }

    public int serangPemain(int pemainDefense) {
        int damage = this.attack - pemainDefense;
        return Math.max(damage, 0);
    }
}
