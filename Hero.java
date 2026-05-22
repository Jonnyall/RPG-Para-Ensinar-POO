public class Hero extends Character implements Updateble
    {
    //Esta classe representa o personagem principal do jogo, aquele que o jogador controla.

    //Atributos do personagem (Hero).

    //O inventário do personagem, onde ele pode guardar itens, flechas, etc.
    private Inventory inventory;

    //Variaveis de controle de estado, logica de jogo.
    private int is_in_Strike; //Contagem regressiva para poder dar uma nova Espadada.
    private int is_in_Shot; //Contagem regressiva para poder dar um novo Tiro de Flecha.
    static private int STRIKE_COOLDOWN = 30; //Tempo de recarga para a Espadada, em "frames". (meio segundo, se o jogo rodar a 60 fps).
    static private int SHOT_COOLDOWN = 60; //Tempo de recarga para o Tiro de Flecha, em "frames". (1 segundo, se o jogo rodar a 60 fps).

    //Construtor da classe.
    public Hero(int _x, int _y)
        {
        //Exceto pelos pontos de inicialização do Heroi (x, y), os outros atributos já são definidos.
        super("Hero", 100, 20, 10, _x, _y, 32, 32 /*, Hero.png*/);
        
        //Apenas inicializando o inventário do Heroi.
        inventory = new Inventory();
        
        //Inicializando as variaveis de estado do Heroi.
        is_in_Strike = 0;
        is_in_Shot = 0;
        }

    //Metodo para o Heroi poder criar damages.
    public boolean toStrike()
        {
        //Aqui deve ser implementada a lógica para o Heroi criar um objeto de dano (Damage) e colocá-lo no jogo.
        
        //Precisamos verificar se o Heroi não está em recarga para dar uma nova Espadada, caso contrário, o Heroi não pode atacar.
        if (is_in_Strike == 0)
            {
            //Criar o objeto Espadada!
            is_in_Strike = STRIKE_COOLDOWN; //Iniciar a contagem regressiva para a próxima Espadada.
            return (true);
            }
        
        //Se o Heroi estiver em recarga, ele não pode atacar, então retornamos false.
        return (false);
        }

    public boolean toShotArrow()
        {
        //Aqui deve ser implementada a lógica para o Heroi criar um objeto de dano (Damage) e colocá-lo no jogo.
        //Criar o objeto Flechada!
        
        //Precisamos verificar se o Heroi tem flechas o suficientes para atirar, 1 pelo menos, caso contrário, o Heroi não pode atirar.
        //Também precisamos verificar se o Heroi não está em recarga para dar um novo Tiro de Flecha, caso contrário, o Heroi não pode atacar.
        if (is_in_Shot == 0
        && inventory.getNumberItem(new Arrow()) > 0)
            {
            //Remover uma flecha do inventário.
            inventory.removeItem(new Arrow());
            
            //Iniciar a contagem regressiva para o próximo Tiro de Flecha.
            is_in_Shot = SHOT_COOLDOWN;
            
            //Criar o objeto Flechada!
            return (true);
            }
        return (false);
        }

    //Declaração do método de atualização do personagem (Hero), que deve ser implementado por todas as classes filhas de Hero.
    @Override
    public void update()
        {
        //Aqui deve ser implementada a lógica de atualização do personagem (Hero), como movimentação, ataques, etc.

        //Atualizando as variaveis de estado do Heroi.(descrescimento das contagens regressivas para os ataques).
        if (is_in_Strike > 0)   is_in_Strike--;
        if (is_in_Shot > 0)     is_in_Shot--;


        //Movimentação do Heroi, usando as setas do teclado.
        /*
        Aqui definieremos onde está livre para o Heroi se mover, ou seja, onde ele pode se mover sem colidir com paredes, objetos, etc. (UP_FREE, DOWN_FREE, LEFT_FREE, RIGHT_FREE).
        Esses booleanos devem ser definidos usando a lógica de colisão, verificando se o Heroi colidiria com algo se ele se movesse para aquela direção. (usando o método checkCollision da classe MaterialThings).
        */

        /*
        int HERO_SPD_MOVE = 1
        if (Keyboard.isKeyDown(Keyboard.KEY_UP) && UP_FREE) this.plussY(-1);

        if (Keyboard.isKeyDown(Keyboard.KEY_UP) && UP_FREE) this.plussY(-HERO_SPD_MOVE);

        if (Keyboard.isKeyDown(Keyboard.KEY_DOWN) && DOWN_FREE) this.plussY(+HERO_SPD_MOVE);

        if (Keyboard.isKeyDown(Keyboard.KEY_LEFT) && LEFT_FREE) this.plussX(-HERO_SPD_MOVE);

        if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT) && RIGHT_FREE) this.plussX(+HERO_SPD_MOVE);
        */

        //Ataques do Heroi, usando as teclas Ctrl (Espadada) e Alt (Flechada).
        /*
        if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL))
            {
            toStrike();
            } 
        if (Keyboard.isKeyDown(Keyboard.KEY_LALT))
            {
            toShotArrow();
            }
        */
        }
            
}
