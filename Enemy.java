// Inheritance
public class Enemy {
        protected String enemyName;
        protected int enemyMagic;
        protected int enemyAttack;
        protected int enemySpeed;
        protected int enemyHealth;
    
        public String getEnemyName() {
            return enemyName;
        }
    
        public int getEnemyMagic() {
            return enemyMagic;
        }
    
        public int getEnemyAttack() {
            return enemyAttack;
        }
    
        public int getEnemySpeed() {
            return enemySpeed;
        }
    
        public int getEnemyHealth() {
            return enemyHealth;
        }
    
        public void setEnemyHealth(int enemyHealth) {
            this.enemyHealth = enemyHealth;
        }

        public void displayStats() {
            System.out.println("\n" + enemyName + " Stats:");
            System.out.println("Magic: " + enemyMagic);
            System.out.println("Attack: " + enemyAttack);
            System.out.println("Speed: " + enemySpeed);
            System.out.println("Health: " + enemyHealth);
            System.out.println();
        }
}


class Slime extends Enemy {
    public Slime() {
        this.enemyName = "Slime";
        this.enemyMagic = 1;
        this.enemyAttack = 1;
        this.enemySpeed = 1;
        this.enemyHealth = 10;
    }
}

class Goblin extends Enemy {
    public Goblin() {
        this.enemyName = "Goblin";
        this.enemyMagic = 0;
        this.enemyAttack = 2;
        this.enemySpeed = 2;
        this.enemyHealth = 15;
    }
}

class Thieves extends Enemy {
    public Thieves() {
        this.enemyName = "Thieves";
        this.enemyMagic = 0;
        this.enemyAttack = 5;
        this.enemySpeed = 5;
        this.enemyHealth = 20;
    }
}

class Zombie extends Enemy {
    public Zombie() {
        this.enemyName = "Zombie";
        this.enemyMagic = 0;
        this.enemyAttack = 5;
        this.enemySpeed = 5;
        this.enemyHealth = 40;
    }
}

class Robot extends Enemy {
    public Robot() {
        this.enemyName = "Robot";
        this.enemyMagic = 0;
        this.enemyAttack = 15;
        this.enemySpeed = 10;
        this.enemyHealth = 80;
    }
}

class Alien extends Enemy {
    public Alien() {
        this.enemyName = "Alien";
        this.enemyMagic = 5;
        this.enemyAttack = 15;
        this.enemySpeed = 15;
        this.enemyHealth = 100;
    }
}

class Phoenix extends Enemy {
    public Phoenix() {
        this.enemyName = "Phoenix";
        this.enemyMagic = 10;
        this.enemyAttack = 20;
        this.enemySpeed = 20;
        this.enemyHealth = 100;
    }
}

class Dragon extends Enemy {
    public Dragon() {
        this.enemyName = "Dragon";
        this.enemyMagic = 10;
        this.enemyAttack = 20;
        this.enemySpeed = 20;
        this.enemyHealth = 110;
    }
}

class Demon extends Enemy {
    public Demon() {
        this.enemyName = "Demon";
        this.enemyMagic = 15;
        this.enemyAttack = 25;
        this.enemySpeed = 25;
        this.enemyHealth = 130;
    }
}

class God extends Enemy {
    public God() {
        this.enemyName = "God";
        this.enemyMagic = 20;
        this.enemyAttack = 25;
        this.enemySpeed = 30;
        this.enemyHealth = 150;
    }
}